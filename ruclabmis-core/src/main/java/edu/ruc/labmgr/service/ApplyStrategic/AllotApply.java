package edu.ruc.labmgr.service.ApplyStrategic;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.ApplyWithEquipment;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.mapper.ApplyWithEquipmentMapper;
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

    @Override
    public PageInfo<Equipment> pageDeviceList(String sn, String name, int useDirect, int page) {
        int currUserId = super.serviceTeacher.getCurrentUserId();
        return super.serviceEquipment.getUserPageBorrowedEquipments(sn, name, useDirect, currUserId, page);
    }

    private void setAllotTarget(PageInfo<ApplicationForm> pageInfo) {
        //转移申请时，取出接受者名字
        for(ApplicationForm apply : pageInfo.getData()){
            if(!StringUtils.isNullOrEmpty(apply.getAnnex())){
                String target = serviceTeacher.selectByPrimaryKey(Integer.parseInt(apply.getAnnex())).getUser().getName();
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
        PageInfo<ApplicationForm> pageInfo =  super.pageApplicationHistoryList(sn, stateId, pageNum, type);

        setAllotTarget(pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo<ApplicationForm> pageApplicationProcessList(String sn, int stateId, int pageNum, Types.ApplyType type) {
        PageInfo<ApplicationForm> pageInfo =  super.pageApplicationProcessList(sn, stateId, pageNum, type);

        setAllotTarget(pageInfo);
        return pageInfo;
    }

    @Override
    public void updateApplication(ApplicationForm applyForm) throws Exception {
        String targetName = applyForm.getTarget();
        String userSn =  targetName.substring(targetName.indexOf('(')+1, targetName.indexOf(')'));
        int id = serviceTeacher.getUserIdBySn(userSn);
        if(id < 0) {
            throw(new Exception("接收人不存在，请检查后重新输入"));
        }

        applyForm.setAnnex(Integer.toString(id));

        super.updateApplication(applyForm);
    }

    @Override
    public void addEquipmentsToApply(int applicationId, List<Integer> equipIds) {
        super.addEquipmentsToApply(applicationId, equipIds);
        for(Integer id : equipIds){
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

        for(Equipment equipment : applyWithEquipment.getEquipments())
        {
            equipment.setHolder(Integer.parseInt(applyWithEquipment.getAnnex()));
            equipment.setStateId(Types.EquipState.USED.getValue());
            mapperEquipment.updateByPrimaryKeySelective(equipment);
        }
    }
}
