package edu.ruc.labmgr.service.ApplyStrategic;


import edu.ruc.labmgr.domain.ApplyWithEquipment;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.mapper.ApplyWithEquipmentMapper;
import edu.ruc.labmgr.mapper.EquipmentMapper;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("ALL")
//借用申请
@Component
public class InfoApply extends BaseApply {
    @Autowired
    private ApplyWithEquipmentMapper mapperViewStore;
    @Autowired
    private EquipmentMapper mapperEquipment;

    @Override
    PageInfo<Equipment> pageDeviceList(String sn, String name, int useDirect, int page) {
        return serviceEquipment.getPageEquipments(sn, name, useDirect, page);
    }
}
