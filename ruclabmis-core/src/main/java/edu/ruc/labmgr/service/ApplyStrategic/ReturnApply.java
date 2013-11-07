package edu.ruc.labmgr.service.ApplyStrategic;

import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.mapper.EquipmentMapper;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//归还申请
@SuppressWarnings("ALL")
@Component
public class ReturnApply extends BaseApply {
    @Autowired
    private EquipmentMapper mapperEquipment;


    @Override
    PageInfo<Equipment> pageDeviceList(String sn, String name, int useDirect, int page) {
        int currUserId = super.serviceUser.getCurrentUserId();
        return super.serviceEquipment.getUserPageBorrowedEquipments(sn, name, useDirect, currUserId, page);
    }

    @Override
    void addEquipmentsToApply(int applicationId, List<Integer> equipIds) {
        super.addEquipmentsToApply(applicationId, equipIds);
        for(Integer id : equipIds){
            //更新设备状态
            Equipment equipment = new Equipment();
            equipment.setId(id);
            equipment.setStateId(Types.EquipState.TOREURN.getValue());
            mapperEquipment.updateByPrimaryKeySelective(equipment);
        }
    }
}
