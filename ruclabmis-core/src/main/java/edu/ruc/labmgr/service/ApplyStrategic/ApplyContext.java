package edu.ruc.labmgr.service.ApplyStrategic;

import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;

import java.util.List;

public class ApplyContext {

    private BaseApply apply;
    Types.ApplyType applyType;

    private ApplyContext(){}

    public ApplyContext(BaseApply apply) {
        this.apply = apply;
    }

    public ApplyContext(Types.ApplyType applyType){
        this.applyType = applyType;
        BaseApply apply;
        switch (applyType){
            case BORROW:
                apply = SysUtil.getBean("borrowApply",BorrowApply.class);
                break;
            case RETURN:
                apply = SysUtil.getBean("returnApply",ReturnApply.class);
                break;
            case ALLOT:
                apply = SysUtil.getBean("allotApply",AllotApply.class);
                break;
            case DONATE:
                apply = SysUtil.getBean("donateApply",DonateApply.class);
                break;
            case REPAIR:
                apply = SysUtil.getBean("repairApply",RepairApply.class);
                break;
            case DEFICIT:
                apply = SysUtil.getBean("deficitApply",DeficitApply.class);
                break;
            case INFO:
                apply = SysUtil.getBean("infoApply",InfoApply.class);
                break;
            default:
                apply = SysUtil.getBean("baseApply",BaseApply.class);
                break;

        }
        this.apply = apply;
    }

    public PageInfo<Equipment> pageDeviceList(String sn,String name, int useDirect,int page){
        return apply.pageDeviceList(sn, name, useDirect, page);
    }

    //申请表单列表
    public PageInfo<ApplicationForm> pageApplicationList(String sn,int stateId, int pageNum){
        return apply.pageApplicationList(sn, stateId, pageNum, applyType);
    }

    //审批/执行表单列表
    public PageInfo<ApplicationForm> pageApplicationProcessList(String sn,int stateId, int pageNum){
        return apply.pageApplicationProcessList(sn, stateId, pageNum, applyType);
    }

    //历史表单列表
    public PageInfo<ApplicationForm> pageApplicationHistoryList(String sn,int stateId, int pageNum){
        return apply.pageApplicationHistoryList(sn, stateId, pageNum, applyType);
    }

    public void updateApplication(ApplicationForm applyForm) throws Exception {
        apply.updateApplication(applyForm);
    }

    public void addEquipmentsToApply(int applicationId, List<Integer> equipIds) {
        apply.addEquipmentsToApply(applicationId, equipIds);
    }

    public void processApply(int applicationId) {
        apply.processApply(applicationId);
    }

    public void processApply(int applicationId, Types.EquipState state) {
        apply.processApply(applicationId, state);
    }

    public void deleteApplys( List<Integer> appIds){
        apply.deleteApplys(appIds);
    }
}
