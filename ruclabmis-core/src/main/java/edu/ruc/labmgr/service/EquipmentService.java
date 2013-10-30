package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.domain.EquipmentCriteria;
import edu.ruc.labmgr.domain.Types;
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
@Service
public class EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    public PageInfo<Equipment> getPageEquipments(int pageNum){
        EquipmentCriteria criteria = new EquipmentCriteria();
        criteria.setOrderByClause("sn");
        return getPageEquipmentByCriteria(pageNum,criteria);
    }

    public PageInfo<Equipment> getPageAvaiableEquipments(int pageNum){
        EquipmentCriteria criteria = new EquipmentCriteria();
        criteria.setOrderByClause("sn");
        criteria.createCriteria().andStateIdEqualTo(Types.EquipStat.UNUSED.getValue());
        return getPageEquipmentByCriteria(pageNum,criteria);
    }

    /**
     * 按基本条件查询获得分页的设备数据
     * @param sn
     * @param name
     * @param useDirec
     * @param pageNum
     * @return
     */
    public PageInfo<Equipment> getPageEquipments(String sn,String name,int useDirec,int pageNum){
        EquipmentCriteria criteria = new EquipmentCriteria();
        criteria.setOrderByClause("sn");
        EquipmentCriteria.Criteria ec = criteria.createCriteria();
        if (StringUtils.isNotEmpty(sn))
            ec.andSnLike(sn);
        if (StringUtils.isNotEmpty(name))
            ec.andNameLike(name);
        if (useDirec>0){
            ec.andUseDirectionIdEqualTo(useDirec);
        }
        return getPageEquipmentByCriteria(pageNum,criteria);
    }

    private PageInfo<Equipment> getPageEquipmentByCriteria(int pageNum,EquipmentCriteria criteria){
        int totalCount = equipmentMapper.countByCriteria(criteria);
        PageInfo<Equipment> page = new PageInfo<>(totalCount,-1,pageNum);
        List<Equipment> data = equipmentMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(),page.getPageSize()));
        page.setData(data);
        return page;
    }
}
