package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.ViewStore;
import edu.ruc.labmgr.domain.ViewStoreCriteria;
import edu.ruc.labmgr.mapper.ApplicationFormMapper;
import edu.ruc.labmgr.mapper.EquipmentMapper;
import edu.ruc.labmgr.mapper.RoleMapper;
import edu.ruc.labmgr.mapper.ViewStoreMapper;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class StoreService {
    @Autowired
    private ViewStoreMapper mapperForm;

    public ObjectListPage<ViewStore> selectListPage(int currentPage, ViewStoreCriteria criteria) {
        ObjectListPage<ViewStore> retList = null;
        try {
            String count = SysUtil.getConfigValue("showCount", "10");

            int limit = Integer.valueOf(count);
            int currentResult = (currentPage - 1) * limit;
            int totleCount = mapperForm.countByCriteria(criteria);
            int pageCount = (totleCount % limit == 0) ? (totleCount / limit) : (1 + totleCount / limit);

            PageInfo pageInfo = new PageInfo();
            pageInfo.setTotalResult(totleCount);
            pageInfo.setTotalPage(pageCount);
            pageInfo.setCurrentPage(currentPage);

            RowBounds bounds = new RowBounds(currentResult, limit);
            List<ViewStore> stores = mapperForm.selectByCriteriaWithRowbounds(criteria, bounds);

            retList = new ObjectListPage<ViewStore>(pageInfo, stores);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retList;
    }
}
