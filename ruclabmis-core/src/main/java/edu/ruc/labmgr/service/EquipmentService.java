package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.domain.EquipmentCriteria;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.mapper.EquipmentMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    private PageInfo<Equipment> getPageEquipmentByCriteria(int pageNum,EquipmentCriteria criteria){
        int totalCount = equipmentMapper.countByCriteria(criteria);
        PageInfo<Equipment> page = new PageInfo<>(totalCount,-1,pageNum);
        List<Equipment> data = equipmentMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(),page.getPageSize()));
        page.setData(data);
        return page;
    }

    //分页过滤可借用设备
    public PageInfo<Equipment> getPageAvaiableEquipments(String sn,String name,int useDirect,int pageNum){
        EquipmentCriteria criteria = new EquipmentCriteria();
        criteria.setOrderByClause("sn");
        EquipmentCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        if (useDirect>0){
            ec.andUseDirectionIdEqualTo(useDirect);
        }
        ec.andStateIdEqualTo(Types.EquipState.NORMAL.getValue());
        return getPageEquipmentByCriteria(pageNum, criteria);
    }

    //分页过滤数据
    public PageInfo<Equipment> getPageEquipments(String sn,String name,int useDirect,int pageNum){
        EquipmentCriteria criteria = new EquipmentCriteria();
        criteria.setOrderByClause("sn");
        EquipmentCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");
        if (useDirect>0){
            ec.andUseDirectionIdEqualTo(useDirect);
        }
        return getPageEquipmentByCriteria(pageNum,criteria);
    }


}
