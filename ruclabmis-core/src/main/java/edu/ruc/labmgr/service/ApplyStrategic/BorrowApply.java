package edu.ruc.labmgr.service.ApplyStrategic;


import edu.ruc.labmgr.domain.ApplyWithEquipment;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.mapper.ApplyWithEquipmentMapper;
import edu.ruc.labmgr.mapper.EquipmentMapper;
import edu.ruc.labmgr.service.MessageService;
import edu.ruc.labmgr.utils.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("ALL")
//借用申请
@Component
public class BorrowApply extends BaseApply {
    @Autowired
    private ApplyWithEquipmentMapper mapperViewStore;
    @Autowired
    private EquipmentMapper mapperEquipment;

    @Override
    public void addEquipmentsToApply(int applicationId, List<Integer> equipIds) {
        super.addEquipmentsToApply(applicationId, equipIds);
        for(Integer id : equipIds){
            //更新设备状态
            Equipment equipment = new Equipment();
            equipment.setId(id);
            equipment.setStateId(Types.EquipState.TOUSE.getValue());
            mapperEquipment.updateByPrimaryKeySelective(equipment);
        }
    }

   //借用申请,更改领用人为申请人,更新设备状态为已借用
    @Override
    public void processApply(int applicationId) {
        super.processApply(applicationId);

        ApplyWithEquipment applyWithEquipment = mapperViewStore.selectByApplyId(applicationId);
        for(Equipment equipment : applyWithEquipment.getEquipments())
        {
            equipment.setHolder(applyWithEquipment.getApplicantId());
            equipment.setStateId(Types.EquipState.USED.getValue());
            mapperEquipment.updateByPrimaryKeySelective(equipment);
        }
    }
}