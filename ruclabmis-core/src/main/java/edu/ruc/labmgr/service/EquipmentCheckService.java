package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.domain.EquipmentCheck;
import edu.ruc.labmgr.domain.EquipmentCheckCriteria;
import edu.ruc.labmgr.mapper.EquipmentCheckMapper;
import edu.ruc.labmgr.mapper.EquipmentMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
@SuppressWarnings("ALL")
@Service
public class EquipmentCheckService {

    @Autowired
    private EquipmentCheckMapper equipCheckMapper;
    @Autowired
    private EquipmentMapper equipMapper;

    public PageInfo<EquipmentCheck> getPageEquipmentCheckByName(String name, int pageNum) {
        EquipmentCheckCriteria criteria = new EquipmentCheckCriteria();
        criteria.setOrderByClause("id desc");
        if (!StringUtils.isEmpty(name)) {
            criteria.createCriteria().andNameLike("%" + name + "%");
        }
        return getPageEquipmentByCriteria(pageNum, criteria);
    }

    public void saveOrUpdateEquipChecks(boolean clean, List<EquipmentCheck> checks) {
        if (clean) {
            deleteAll();
            insertEquipChecks(checks);
        } else {
            saveOrUpdate(checks);
        }
    }

    public PageInfo<Equipment> getPageInventoryProfit(int pageNum) {
        int totalCount = equipMapper.countInventoryProfit();
        PageInfo<Equipment> page = new PageInfo<Equipment>(totalCount, -1, pageNum);
        List<Equipment> data = equipMapper.selectInventoryProfitWithRowbounds(new RowBounds(
                page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public PageInfo<EquipmentCheck> getPageInventoryLose(int pageNum) {
        int totalCount = equipCheckMapper.countInventoryLose();
        PageInfo<EquipmentCheck> page = new PageInfo<EquipmentCheck>(totalCount, -1, pageNum);
        List<EquipmentCheck> data = equipCheckMapper.selectInventoryLoseWithRowbounds(new RowBounds(
                page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    private PageInfo<EquipmentCheck> getPageEquipmentByCriteria(int pageNum, EquipmentCheckCriteria criteria) {
        int totalCount = equipCheckMapper.countByCriteria(criteria);
        PageInfo<EquipmentCheck> page = new PageInfo<>(totalCount, -1, pageNum);
        List<EquipmentCheck> data = equipCheckMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    private void deleteAll() {
        EquipmentCheckCriteria criteria = new EquipmentCheckCriteria();
        criteria.createCriteria();
        equipCheckMapper.deleteByCriteria(criteria);
    }

    private void insertEquipChecks(List<EquipmentCheck> checks) {
        if (checks != null) {
            for (EquipmentCheck check : checks) {
                equipCheckMapper.insert(check);
            }
        }
    }

    private void saveOrUpdate(List<EquipmentCheck> checks) {
        if (checks != null) {
            for (EquipmentCheck check : checks) {
                String sn = check.getSn();
                if (!StringUtils.isEmpty(sn)) {
                    Integer id = equipCheckMapper.selectIdBySn(sn);
                    if (id != null && id > 0) {
                        check.setId(id);
                        equipCheckMapper.updateByPrimaryKey(check);
                    } else {
                        equipCheckMapper.insert(check);
                    }
                }
            }
        }
    }
}
