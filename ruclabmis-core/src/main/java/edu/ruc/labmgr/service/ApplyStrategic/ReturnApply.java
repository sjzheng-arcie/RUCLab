package edu.ruc.labmgr.service.ApplyStrategic;

import edu.ruc.labmgr.domain.ApplyWithEquipment;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.domain.EquipmentApplicationFormKey;
import edu.ruc.labmgr.mapper.ApplicationFormMapper;
import edu.ruc.labmgr.mapper.ApplyWithEquipmentMapper;
import edu.ruc.labmgr.mapper.EquipmentApplicationFormMapper;
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
    @Autowired
    private EquipmentApplicationFormMapper mapperEA;
    @Autowired
    private ApplicationFormMapper mapperApply;

    @Override
    public PageInfo<Equipment> pageDeviceList(String sn, String name, int useDirect, int page) {
        int currUserId = super.serviceTeacher.getCurrentUserId();
        return super.serviceEquipment.getUserPageBorrowedEquipments(sn, name, useDirect, currUserId, page);
    }

    @Override
    public void addEquipmentsToApply(int applicationId, List<Integer> equipIds) {
        super.addEquipmentsToApply(applicationId, equipIds);

        for (Integer id : equipIds) {
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
        for (Equipment equipment : applyWithEquipment.getEquipments()) {
            equipment.setHolder(null);
            equipment.setStateId(Types.EquipState.NORMAL.getValue());
            mapperEquipment.updateByPrimaryKey(equipment);
        }
    }

    //删除归还申请，更新设备状态为已借用
    @Override
    public void deleteApplys(List<Integer> appIds) {
        for (Integer id : appIds) {
            ApplyWithEquipment applyWithEquipmen = mapperViewStore.selectByApplyId(id);
            for (Equipment equipment : applyWithEquipmen.getEquipments()) {
                //删除关联
                EquipmentApplicationFormKey key = new EquipmentApplicationFormKey();
                key.setApplicationFormId(id);
                key.setEquipmentId(equipment.getId());
                mapperEA.deleteByPrimaryKey(key);

                //更新设备状态
                equipment.setStateId(Types.EquipState.USED.getValue());
                mapperEquipment.updateByPrimaryKeySelective(equipment);
            }

            mapperApply.deleteByPrimaryKey(id);
        }
    }
}
