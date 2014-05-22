package edu.ruc.labmgr.excel;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.service.ClassifService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.SysUtil;
import java.util.Date;
import java.util.Map;


public class EquipmentsExcelParser extends POIEntityParser<Equipment> {

    @Override
    public Equipment mapToEntity(Map<String, Object> map) {
        Equipment result = new Equipment();

        Object sn_temp = map.get("sn");
        if(sn_temp == null)
            return null;
        if(StringUtils.isNullOrEmpty(sn_temp.toString()))
            return null;

        try
        {
            result.setSn(cellDoubleToString(sn_temp));
            result.setCategorySn(cellDoubleToString(map.get("categorySn")));
            result.setName((String) map.get("name"));
            result.setModelNumber((String) map.get("modelNumber"));
            result.setSpecifications(map.get("specifications").toString());
            result.setUnitPrice(((Double) map.get("unitPrice")).floatValue());
            result.setVender((String) map.get("vender"));
            result.setFactoryNumber(cellDoubleToString(map.get("factoryNumber")));
            result.setAcquisitionDate(cellStringToDate(map.get("acquisitionDate")));

            String fundingSubjectName = (String) map.get("fundingSubject");
            if(!StringUtils.isNullOrEmpty(fundingSubjectName))
            {
                ClassifService serviceClassif = SysUtil.getBean("classifService", ClassifService.class);
                Integer fundingSubjectId = serviceClassif.getFundingSubjectIdByName(fundingSubjectName);
                result.setFundingSubjectId(fundingSubjectId);
            }

            String holderName = (String) map.get("holderName");
            if(!StringUtils.isNullOrEmpty(holderName))
            {
                UserService serviceUser = SysUtil.getBean("userService", UserService.class);
                Integer holderId = serviceUser.getUserIdByName(holderName);
                result.setHolder(holderId);
            }

            result.setLocation((String) map.get("location"));
//        result.setUseDirection((String) map.get("useDirection"));

            return result;
        }
        catch (java.lang.ClassCastException ex)
        {
            throw  new java.lang.ClassCastException("设备" + sn_temp + "转换错误");
        }
    }


    private String cellDoubleToString(Object value) {
        if (value == null)
            return null;
        if (value instanceof Double) {
            long result = Double.valueOf(value.toString()).longValue();
            return "" + result;

        }
        return value.toString();
    }


    private Date cellStringToDate(Object value) {
        if (value == null)
            return null;

        if (value instanceof String) {
            String str = value.toString();
            if(str.matches("[0-9]{4}\\.[0-9]{2}"))
            {
                str = str.replace(".","-");
                str += "-01";
            }
            Date date = java.sql.Date.valueOf(str);
            return date;
        }
        return java.sql.Date.valueOf(value.toString());
    }
}
