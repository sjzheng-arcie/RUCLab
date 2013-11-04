package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.*;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class StoreService {
    @Autowired
    private ViewStoreMapper mapperViewStore;
    @Autowired
    private EquipmentMapper mapperEquipment;
    @Autowired
    private ApplicationFormMapper mapperApply;
    @Autowired
    private EquipmentApplicationFormMapper mapperEA;
    @Autowired
    private UserService userService;


    public PageInfo<ApplicationForm> selectListPage(String sn,int stateId, int pageNum){
        ApplicationFormCriteria criteria = new ApplicationFormCriteria();
        criteria.setOrderByClause("apply_time");

        ApplicationFormCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (stateId > 0)
            ec.andStateIdEqualTo(stateId);

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

    public ViewStore selectByApplyId(int id) {
        ViewStore store = null;
        store = mapperViewStore.selectByApplyId(id);

        return store;
    }

    public void insertApply(ApplicationForm apply) {
        mapperApply.insert(apply);
    }

    public void updateApply(ApplicationForm apply) {
        mapperApply.updateByPrimaryKeySelective(apply);
    }

    public void deleteApply(int id) {
        ViewStore store = new ViewStore();
        store = mapperViewStore.selectByApplyId(id);
        for(Equipment equipment : store.getEquipments())
        {
            EquipmentApplicationFormKey key = new EquipmentApplicationFormKey();
            key.setApplicationFormId(id);
            key.setEquipmentId(equipment.getId());
            mapperEA.deleteByPrimaryKey(key);

            mapperEquipment.deleteByPrimaryKey(equipment.getId());
        }

        mapperApply.deleteByPrimaryKey(id);
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


    public void insertEquipmentWithApply(Equipment equipment, int applicationId) {
        mapperEquipment.insert(equipment);

        EquipmentApplicationFormKey record = new EquipmentApplicationFormKey();
        record.setEquipmentId(equipment.getId());
        record.setApplicationFormId(applicationId);
        mapperEA.insert(record);
    }


    public void deleteEquipmentWithApply(int equipmentId, int applicationId) {
        EquipmentApplicationFormKey key = new EquipmentApplicationFormKey();
        key.setEquipmentId(equipmentId);
        key.setApplicationFormId(applicationId);
        mapperEA.deleteByPrimaryKey(key);

        mapperEquipment.deleteByPrimaryKey(equipmentId);
    }


    public void approveApply(int applicationId) {
        ApplicationForm form = new ApplicationForm();
        form.setId(applicationId);
        form.setProcessTime(new Date());
        form.setStateId(Types.ApplyState.PASS.getValue());

        form.setApproverId(userService.getCurrentUserId());

        mapperApply.updateByPrimaryKeySelective(form);
    }


    public void rejectApply(int applicationId) {
        ApplicationForm form = new ApplicationForm();
        form.setId(applicationId);
        form.setProcessTime(new Date());
        form.setStateId(Types.ApplyState.REJECT.getValue());

        form.setApproverId(userService.getCurrentUserId());

        mapperApply.updateByPrimaryKeySelective(form);
    }
}
