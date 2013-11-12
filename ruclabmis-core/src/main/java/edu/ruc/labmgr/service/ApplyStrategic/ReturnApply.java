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

//归还申请
@SuppressWarnings("ALL")
@Component
public class ReturnApply extends BaseApply {
    @Autowired
    private EquipmentMapper mapperEquipment;
    @Autowired
    private ApplyWithEquipmentMapper mapperViewStore;

    @Override
    public PageInfo<Equipment> pageDeviceList(String sn, String name, int useDirect, int page) {
        int currUserId = super.serviceTeacher.getCurrentUserId();
        return super.serviceEquipment.getUserPageBorrowedEquipments(sn, name, useDirect, currUserId, page);
    }

    @Override
    public void addEquipmentsToApply(int applicationId, List<Integer> equipIds) {
        super.addEquipmentsToApply(applicationId, equipIds);
        for(Integer id : equipIds){
            //更新设备状态
            Equipment equipment = new Equipment();
            equipment.setId(id);
            equipment.setStateId(Types.EquipState.TOREURN.getValue());
            mapperEquipment.updateByPrimaryKeySelective(equipment);
        }
    }

    @Override
    public void processApply(int applicationId) {
        super.processApply(applicationId);

        ApplyWithEquipment applyWithEquipment = mapperViewStore.selectByApplyId(applicationId);
        for(Equipment equipment : applyWithEquipment.getEquipments())
        {
            equipment.setHolder(applyWithEquipment.getApplicantId());
            equipment.setStateId(Types.EquipState.NORMAL.getValue());
            mapperEquipment.updateByPrimaryKeySelective(equipment);
        }
    }
}
