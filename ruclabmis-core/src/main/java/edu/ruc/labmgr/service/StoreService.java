package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.*;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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

    public ObjectListPage<ViewStore> selectListPage(int currentPage, ViewStoreCriteria criteria) {
        ObjectListPage<ViewStore> retList = null;

        String count = SysUtil.getConfigValue("showCount", "10");

        int limit = Integer.valueOf(count);
        int currentResult = (currentPage - 1) * limit;
        int totleCount = mapperViewStore.countByCriteria(criteria);
        int pageCount = (totleCount % limit == 0) ? (totleCount / limit) : (1 + totleCount / limit);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalResult(totleCount);
        pageInfo.setTotalPage(pageCount);
        pageInfo.setCurrentPage(currentPage);

        RowBounds bounds = new RowBounds(currentResult, limit);
        List<ViewStore> stores = mapperViewStore.selectByCriteriaWithRowbounds(criteria, bounds);

        retList = new ObjectListPage<ViewStore>(pageInfo, stores);

        return retList;
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
        mapperApply.updateByPrimaryKey(apply);
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
}
