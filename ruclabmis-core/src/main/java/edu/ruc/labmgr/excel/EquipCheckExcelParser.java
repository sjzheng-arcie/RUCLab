package edu.ruc.labmgr.excel;

import edu.ruc.labmgr.domain.EquipmentCheck;

import java.util.Date;
import java.util.Map;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
public class EquipCheckExcelParser extends POIEntityParser<EquipmentCheck>{
    @Override
    public EquipmentCheck mapToEntity(Map<String, Object> map) {
        EquipmentCheck result = new EquipmentCheck();
		Object sn_temp = map.get("sn");
        result.setSn(cellDoubletoString(sn_temp));
        result.setName((String)map.get("name"));
        result.setAcquisitionDate((Date)map.get("acquisitionDate"));
        result.setCategoryId(cellDoubletoString(map.get("categoryId")));
        result.setUser((String)map.get("user"));
        result.setFactoryNumber(cellDoubletoString(map.get("factoryNumber")));
        result.setFundingSubject((String)map.get("fundingSubject"));
        result.setLocation((String)map.get("location"));
        result.setModelNumber((String)map.get("modelNumber"));
        result.setUnitPrice(((Double)map.get("unitPrice")).floatValue());
        return result;
    }
	private String cellDoubletoString(Object value ){
		if(value==null)
			return null;
		if(value instanceof  Double){
			long result = Double.valueOf(value.toString()).longValue();
			return  ""+result;

		}
		return  value.toString();

	}
}
