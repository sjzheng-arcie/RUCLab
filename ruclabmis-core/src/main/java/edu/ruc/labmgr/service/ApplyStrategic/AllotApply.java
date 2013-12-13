package edu.ruc.labmgr.service.ApplyStrategic;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.ApplicationFormMapper;
import edu.ruc.labmgr.mapper.ApplyWithEquipmentMapper;
import edu.ruc.labmgr.mapper.EquipmentApplicationFormMapper;
import edu.ruc.labmgr.mapper.EquipmentMapper;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//转移申请
@SuppressWarnings("ALL")
@Component
public class AllotApply extends BaseApply {
    @Autowired
    private ApplyWithEquipmentMapper mapperViewStore;
    @Autowired
    private EquipmentMapper mapperEquipment;
    @Autowired
    private EquipmentApplicationFormMapper mapperEA;
    @Autowired
    private ApplicationFormMapper mapperApply;

    @Override
    public PageInfo<Equipment> pageDeviceList(String sn, String name, int useDirect, int page) {
        int currUserId = super.serviceTeacher.getCurrentUserId();
        return super.serviceEquipment.getUserPageBorrowedEquipments(sn, name, useDirect, currUserId, page);
    }

    private void setAllotTarget(PageInfo<ApplicationForm> pageInfo) {
        //转移申请时，取出接受者名字
        for (ApplicationForm apply : pageInfo.getData()) {
            if (!StringUtils.isNullOrEmpty(apply.getAnnex())) {
                User user = serviceTeacher.selectByPrimaryKey(Integer.parseInt(apply.getAnnex()));
                String target =user.getName();
                apply.setTarget(target);
            }
        }
    }

    @Override
    public PageInfo<ApplicationForm> pageApplicationList(String sn, int stateId, int pageNum, Types.ApplyType type) {
        PageInfo<ApplicationForm> pageInfo = super.pageApplicationList(sn, stateId, pageNum, type);
        setAllotTarget(pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo<ApplicationForm> pageApplicationHistoryList(String sn, int stateId, int pageNum, Types.ApplyType type) {
        PageInfo<ApplicationForm> pageInfo = super.pageApplicationHistoryList(sn, stateId, pageNum, type);

        setAllotTarget(pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo<ApplicationForm> pageApplicationProcessList(String sn, int stateId, int pageNum, Types.ApplyType type) {
        PageInfo<ApplicationForm> pageInfo = super.pageApplicationProcessList(sn, stateId, pageNum, type);

        setAllotTarget(pageInfo);
        return pageInfo;
    }

    @Override
    public void addEquipmentsToApply(int applicationId, List<Integer> equipIds) {
        super.addEquipmentsToApply(applicationId, equipIds);
        for (Integer id : equipIds) {
            //更新设备状态
            Equipment equipment = new Equipment();
            equipment.setId(id);
            equipment.setStateId(Types.EquipState.TOALLOT.getValue());
            mapperEquipment.updateByPrimaryKeySelective(equipment);

        }
    }

    //转移申请,更改领用人为转移对象,更新设备状态为已借用
    @Override
    public void processApply(int applicationId) {
        super.processApply(applicationId);

        ApplyWithEquipment applyWithEquipment = mapperViewStore.selectByApplyId(applicationId);

        for (Equipment equipment : applyWithEquipment.getEquipments()) {
            equipment.setHolder(Integer.parseInt(applyWithEquipment.getAnnex()));
            equipment.setStateId(Types.EquipState.USED.getValue());
            mapperEquipment.updateByPrimaryKeySelective(equipment);
        }
    }

    //删除捐赠申请，更新设备状态为已借用
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
