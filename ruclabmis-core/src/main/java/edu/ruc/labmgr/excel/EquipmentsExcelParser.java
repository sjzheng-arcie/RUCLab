package edu.ruc.labmgr.excel;

import edu.ruc.labmgr.domain.Equipment;

import java.util.Date;
import java.util.Map;

public class EquipmentsExcelParser extends POIEntityParser<Equipment>{
    @Override
    public Equipment mapToEntity(Map<String, Object> map) {
        Equipment result = new Equipment();
		Object sn_temp = map.get("sn");
        result.setSn(cellDoubleToString(sn_temp));
        result.setName((String)map.get("name"));
        result.setAcquisitionDate((Date)map.get("acquisitionDate"));

        result.setUser((String)map.get("user"));
        result.setFactoryNumber(cellDoubleToString(map.get("factoryNumber")));
        result.setFundingSubject((String)map.get("fundingSubject"));
        result.setModelNumber((String)map.get("modelNumber"));
        result.setUnitPrice(((Double)map.get("unitPrice")).floatValue());
		result.setSpecifications(map.get("specifications").toString());
		result.setVender(map.get("vender").toString());
        return result;
    }

	private String cellDoubleToString(Object value ){
		if(value==null)
			return null;
		if(value instanceof  Double){
			long result = Double.valueOf(value.toString()).longValue();
			return  ""+result;

		}
		return  value.toString();
	}

}
