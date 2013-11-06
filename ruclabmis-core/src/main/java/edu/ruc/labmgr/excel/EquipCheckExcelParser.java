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
        result.setSn((String)map.get("sn"));
        result.setName((String)map.get("name"));
        result.setAcquisitionDate((Date)map.get("acquisitionDate"));
        result.setCategoryId((String)map.get("categoryId"));
        result.setUser((String)map.get("user"));
        result.setFactoryNumber((String)map.get("factoryNumber"));
        result.setFundingSubject((String)map.get("fundingSubject"));
        result.setLocation((String)map.get("location"));
        result.setModelNumber((String)map.get("modelNumber"));
        result.setUnitPrice((float)map.get("unitPrice"));
        return result;
    }
}
