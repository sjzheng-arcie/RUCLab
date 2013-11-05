package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.*;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ApplyWithEquipmentService {
    @Autowired
    private ApplyWithEquipmentMapper mapperViewStore;
    @Autowired
    private EquipmentMapper mapperEquipment;
    @Autowired
    private ApplicationFormMapper mapperApply;
    @Autowired
    private EquipmentApplicationFormMapper mapperEA;
    @Autowired
    private UserService userService;

    //按类型取得所有已关闭的表单
    public PageInfo<ApplicationForm> selectPageHistoryApply(String sn,int stateId, int pageNum, Types.ApplyType type){
        ApplicationFormCriteria criteria = new ApplicationFormCriteria();
        criteria.setOrderByClause("apply_time desc");

        ApplicationFormCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (stateId > 0)
            ec.andStateIdEqualTo(stateId);

        if(type != null)
            ec.andTypeEqualTo(type.getValue());

        ec.andStateIdEqualTo(Types.ApplyState.CLOSE.getValue());

        return getPageUserByCriteria(pageNum,criteria);
    }

    //按用户和类型取得所有已关闭的表单
    public PageInfo<ApplicationForm> selectUserPageHistoryApply(String sn,int stateId, int pageNum,
                                                                     Types.ApplyType type, int userId){
        ApplicationFormCriteria criteria = new ApplicationFormCriteria();
        criteria.setOrderByClause("apply_time desc");

        ApplicationFormCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (stateId > 0)
            ec.andStateIdEqualTo(stateId);

        if(userId > 0)
            ec.andApplicantIdEqualTo(userId);

        if(type != null)
            ec.andTypeEqualTo(type.getValue());

        ec.andStateIdEqualTo(Types.ApplyState.CLOSE.getValue());

        return getPageUserByCriteria(pageNum,criteria);
    }

    //管理员按类型取得所有表单
    public PageInfo<ApplicationForm> selectPageApplyForAdmin(String sn,int stateId, int pageNum, Types.ApplyType type){
        ApplicationFormCriteria criteria = new ApplicationFormCriteria();
        criteria.setOrderByClause("apply_time desc");

        ApplicationFormCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (stateId > 0)
            ec.andStateIdEqualTo(stateId);

        if(type != null)
            ec.andTypeEqualTo(type.getValue());

        ec.andStateIdNotEqualTo(Types.ApplyState.CLOSE.getValue());

        return getPageUserByCriteria(pageNum,criteria);
    }

    //设备管理员显示所有已批准的订单
    public PageInfo<ApplicationForm> selectPageApplyForEquipAdmin(String sn,int stateId, int pageNum,
                                                                  Types.ApplyType type){
        ApplicationFormCriteria criteria = new ApplicationFormCriteria();
        criteria.setOrderByClause("apply_time desc");

        ApplicationFormCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (stateId > 0)
            ec.andStateIdEqualTo(stateId);

        if(type != null)
            ec.andTypeEqualTo(type.getValue());

        ec.andStateIdNotEqualTo(Types.ApplyState.CLOSE.getValue());

        return getPageUserByCriteria(pageNum,criteria);
    }

    //领导显示所有待审批的订单
    public PageInfo<ApplicationForm> selectPageApplyForLeader(String sn,int stateId, int pageNum, Types.ApplyType type){
        ApplicationFormCriteria criteria = new ApplicationFormCriteria();
        criteria.setOrderByClause("apply_time desc");

        ApplicationFormCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");

        if (stateId > 0)
            ec.andStateIdEqualTo(stateId);

        if(type != null)
            ec.andTypeEqualTo(type.getValue());

        ec.andStateIdEqualTo(Types.ApplyState.WAITING.getValue());

        return getPageUserByCriteria(pageNum,criteria);
    }

    //教师只显示自己提交且未关闭的订单
    public PageInfo<ApplicationForm> selectPageApplyForTeacher(String sn,int stateId, int pageNum,
                                                               Types.ApplyType type, int userId){
        ApplicationFormCriteria criteria = new ApplicationFormCriteria();
        criteria.setOrderByClause("apply_time desc");

        ApplicationFormCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (stateId > 0)
            ec.andStateIdEqualTo(stateId);

        if(type != null)
            ec.andTypeEqualTo(type.getValue());

        if(userId > 0)
            ec.andApplicantIdEqualTo(userId);

        ec.andStateIdNotEqualTo(Types.ApplyState.CLOSE.getValue());

        return getPageUserByCriteria(pageNum,criteria);
    }

    private PageInfo<ApplicationForm> getPageUserByCriteria(int pageNum,ApplicationFormCriteria criteria){
        int totalCount = mapperApply.countByCriteria(criteria);
        PageInfo<ApplicationForm> page = new PageInfo<>(totalCount,-1,pageNum);
        List<ApplicationForm> data = mapperApply.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(),page.getPageSize()));
        page.setData(data);
        return page;
    }

    public ApplyWithEquipment selectByApplyId(int id) {
        ApplyWithEquipment applyWithEquipment = null;
        applyWithEquipment = mapperViewStore.selectByApplyId(id);

        return applyWithEquipment;
    }

    public void insertApply(ApplicationForm apply) {
        mapperApply.insert(apply);
    }

    public void updateApply(ApplicationForm apply) {
        mapperApply.updateByPrimaryKeySelective(apply);
    }

    public void deleteApplys(List<Integer> appIds) {
        for(Integer id : appIds){
            ApplyWithEquipment applyWithEquipmen = mapperViewStore.selectByApplyId(id);
            for(Equipment equipment : applyWithEquipmen.getEquipments())
            {
                //删除关联
                EquipmentApplicationFormKey key = new EquipmentApplicationFormKey();
                key.setApplicationFormId(id);
                key.setEquipmentId(equipment.getId());
                mapperEA.deleteByPrimaryKey(key);

                //更新设备状态
                equipment.setStateId(Types.EquipState.NORMAL.getValue());
                mapperEquipment.updateByPrimaryKeySelective(equipment);
            }

            mapperApply.deleteByPrimaryKey(id);
        }
    }

    public Equipment selectEquipmentByPrimaryKey(int id) {
        Equipment equipment = null;
        equipment = mapperEquipment.selectByPrimaryKey(id);

        return equipment;
    }

    public int updateEquipmentByPrimaryKey(Equipment equipment) {
        int retVal = 0;
        retVal = mapperEquipment.updateByPrimaryKey(equipment);

        return retVal;
    }


    public void insertEquipmentWithApply( int applicationId, Equipment equipment) {
        mapperEquipment.insert(equipment);

        EquipmentApplicationFormKey record = new EquipmentApplicationFormKey();
        record.setEquipmentId(equipment.getId());
        record.setApplicationFormId(applicationId);
        mapperEA.insert(record);
    }

    public void addEquipmentsToApply(int applicationId, List<Integer> equipIds,  Types.EquipState newEuipState) {
        for(Integer id : equipIds){
            //更新设备状态
            Equipment equipment = new Equipment();
            equipment.setId(id);
            equipment.setStateId(newEuipState.getValue());
            mapperEquipment.updateByPrimaryKeySelective(equipment);

            //关联设备与申请单
            EquipmentApplicationFormKey record = new EquipmentApplicationFormKey();
            record.setEquipmentId(id);
            record.setApplicationFormId(applicationId);
            mapperEA.insert(record);
        }
    }

    public void deleteEquipmentWithApply(int applicationId, int equipmentId) {
        EquipmentApplicationFormKey key = new EquipmentApplicationFormKey();
        key.setEquipmentId(equipmentId);
        key.setApplicationFormId(applicationId);
        mapperEA.deleteByPrimaryKey(key);

        mapperEquipment.deleteByPrimaryKey(equipmentId);
    }

    public void removeEquipmentFromApply(int applicationId, int equipmentId) {
        EquipmentApplicationFormKey key = new EquipmentApplicationFormKey();
        key.setEquipmentId(equipmentId);
        key.setApplicationFormId(applicationId);
        mapperEA.deleteByPrimaryKey(key);

        //更新设备状态
        Equipment equipment = new Equipment();
        equipment.setId(equipmentId);
        equipment.setStateId(Types.EquipState.NORMAL.getValue());
        mapperEquipment.updateByPrimaryKeySelective(equipment);
    }

    //批准表单
    public void approveApplys(List<Integer> appIds) {
        for(Integer id : appIds){
            //更新表单状态
            ApplicationForm form = new ApplicationForm();
            form.setId(id);
            form.setApproveTime(new Date());
            form.setStateId(Types.ApplyState.PASS.getValue());
            form.setApproverId(userService.getCurrentUserId());

            mapperApply.updateByPrimaryKeySelective(form);

            ApplyWithEquipment applyWithEquipment = mapperViewStore.selectByApplyId(id);
            for(Equipment equipment : applyWithEquipment.getEquipments())
            {
                //更新设备状态
                equipment.setStateId(Types.EquipState.TOUSE.getValue());
                mapperEquipment.updateByPrimaryKeySelective(equipment);
            }
        }
    }

    //驳回表单
    public void rejectApplys(List<Integer> appIds) {
        for(Integer id : appIds){
            //更新表单状态
            ApplicationForm form = new ApplicationForm();
            form.setId(id);
            form.setApproveTime(new Date());
            form.setStateId(Types.ApplyState.REJECT.getValue());
            form.setApproverId(userService.getCurrentUserId());

            mapperApply.updateByPrimaryKeySelective(form);

            ApplyWithEquipment applyWithEquipment = mapperViewStore.selectByApplyId(id);
            for(Equipment equipment : applyWithEquipment.getEquipments())
            {
                //更新设备状态
                equipment.setStateId(Types.EquipState.NORMAL.getValue());
                mapperEquipment.updateByPrimaryKeySelective(equipment);
            }
        }
    }

    //处理表单
    public void processApply(int application_id) {
        //更新表单状态
        ApplicationForm form = new ApplicationForm();
        form.setId(application_id);
        form.setProcessTime(new Date());
        form.setStateId(Types.ApplyState.CLOSE.getValue());
        form.setOperatorId(userService.getCurrentUserId());

        mapperApply.updateByPrimaryKeySelective(form);

        ApplyWithEquipment applyWithEquipment = mapperViewStore.selectByApplyId(application_id);
        for(Equipment equipment : applyWithEquipment.getEquipments())
        {
            //更新设备状态
            equipment.setStateId(Types.EquipState.USED.getValue());
            mapperEquipment.updateByPrimaryKeySelective(equipment);
        }
    }
}
