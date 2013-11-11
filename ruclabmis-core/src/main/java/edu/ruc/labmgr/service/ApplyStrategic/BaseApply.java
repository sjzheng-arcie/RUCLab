package edu.ruc.labmgr.service.ApplyStrategic;

import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.service.ApplyWithEquipmentService;
import edu.ruc.labmgr.service.EquipmentService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("ALL")
@Component
public class BaseApply {
    @Autowired
    protected ApplyWithEquipmentService serviceApply;
    @Autowired
    protected EquipmentService serviceEquipment;
    @Autowired
    protected UserService serviceUser;

    //默认返回所有可用设备列表
    public PageInfo<Equipment> pageDeviceList(String sn,String name, int useDirect, int page){
        return serviceEquipment.getPageAvaiableEquipments(sn, name, useDirect, page);
    }

    //默认返回申请人下所有未关闭表单
    public  PageInfo<ApplicationForm> pageApplicationList(String sn,int stateId, int pageNum, Types.ApplyType type){
        Subject currentUser = SecurityUtils.getSubject();
        int currUserId = serviceUser.getCurrentUserId();
        return   serviceApply.selectPageUserApplyNotClosed(sn, stateId, pageNum, type, currUserId);
    }

    //默认返回所有未关闭表单
    public PageInfo<ApplicationForm> pageApplicationProcessList(String sn,int stateId, int pageNum, Types.ApplyType type){
        return   serviceApply.selectPageApplyNotClosed(sn, stateId, pageNum, type);
    }

    public PageInfo<ApplicationForm> pageApplicationHistoryList(String sn,int stateId, int pageNum, Types.ApplyType type){
        Subject currentUser = SecurityUtils.getSubject();
        //教师只看到自己的历史
        if(currentUser.hasRole(Types.Role.TEACHER.getName())) {
            int currUserId = serviceUser.getCurrentUserId();
            return   serviceApply.selectPageUserHistoryApply(sn, stateId, pageNum, type, currUserId);
        }//其他角色看到所有人的历史
        else
            return   serviceApply.selectPageHistoryApply(sn, stateId, pageNum, type);
    }

    public void updateApplication(ApplicationForm applyForm) throws Exception {
        serviceApply.updateApplication(applyForm);
    }

    public void addEquipmentsToApply(int applicationId, List<Integer> equipIds) {
        serviceApply.addEquipmentsToApply(applicationId,equipIds);
    }

    public void processApply(int applicationId) {
        serviceApply.processApply(applicationId);
    }

    public void processApply(int applicationId, Types.EquipState state){
        serviceApply.processApply(applicationId, state);
    };
}
