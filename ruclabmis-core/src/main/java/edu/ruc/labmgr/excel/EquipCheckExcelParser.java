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
        result.setSn(map.get("sn").toString());
        result.setName((String)map.get("name"));
        result.setAcquisitionDate((Date)map.get("acquisitionDate"));
        result.setCategoryId(map.get("categoryId").toString());
        result.setUser((String)map.get("user"));
        result.setFactoryNumber(map.get("factoryNumber").toString());
        result.setFundingSubject((String)map.get("fundingSubject"));
        result.setLocation((String)map.get("location"));
        result.setModelNumber((String)map.get("modelNumber"));
        result.setUnitPrice(((Double)map.get("unitPrice")).floatValue());
        return result;
    }
}
