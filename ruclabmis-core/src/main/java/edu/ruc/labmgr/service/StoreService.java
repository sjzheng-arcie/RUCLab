package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.EquipmentApplicationFormMapper;
import edu.ruc.labmgr.mapper.EquipmentMapper;
import edu.ruc.labmgr.mapper.RoleMapper;
import edu.ruc.labmgr.mapper.ViewStoreMapper;
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
    EquipmentApplicationFormMapper mapperEA;

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


    public ViewStore selectByPrimaryKey(int id) {
        ViewStore store = null;
        store = mapperViewStore.selectByPrimaryKey(id);

        return store;
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


    public int insertEquipmentWithApplication(Equipment equipment, int applicationId) {
        int retVal = 0;

        retVal = mapperEquipment.insert(equipment);

        EquipmentApplicationFormKey record = new EquipmentApplicationFormKey();
        record.setEquipmentId(equipment.getId());
        record.setApplicationFormId(applicationId);
        retVal = mapperEA.insert(record);

        return retVal;
    }
}
