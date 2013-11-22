package edu.ruc.labmgr.excel;

import edu.ruc.labmgr.domain.Equipment;

import java.util.Date;
import java.util.Map;

public class EquipmentsExcelParser extends POIEntityParser<Equipment> {
    @Override
    public Equipment mapToEntity(Map<String, Object> map) {
        Equipment result = new Equipment();

        Object sn_temp = map.get("sn");
        result.setSn(cellDoubleToString(sn_temp));
        result.setCategorySn((String) map.get("categorySn"));
        result.setName((String) map.get("name"));
        result.setModelNumber((String) map.get("modelNumber"));
        result.setSpecifications(map.get("specifications").toString());
        result.setUnitPrice(((Double) map.get("unitPrice")).floatValue());
        result.setCountry((String) map.get("country"));
        result.setVender((String) map.get("vender"));
        result.setFactoryNumber(cellDoubleToString(map.get("factoryNumber")));
        result.setAcquisitionDate((Date) map.get("acquisitionDate"));
        result.setFundingSubject((String) map.get("fundingSubject"));
        result.setUseDirection((String) map.get("useDirection"));

        return result;
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

}
