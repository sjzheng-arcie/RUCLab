package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.domain.EquipmentCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface EquipmentMapper {
    int countByCriteria(EquipmentCriteria criteria);

    int deleteByCriteria(EquipmentCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    List<Equipment> selectByCriteriaWithRowbounds(EquipmentCriteria criteria, RowBounds rowBounds);

    List<Equipment> selectByCriteria(EquipmentCriteria criteria);

    Equipment selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Equipment record, @Param("criteria") EquipmentCriteria criteria);

    int updateByCriteria(@Param("record") Equipment record, @Param("criteria") EquipmentCriteria criteria);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

    Integer selectIdBySn(@Param("sn") String sn);

    List<Equipment> selectInventoryProfitWithRowbounds(RowBounds rowBounds);

    int countInventoryProfit();
}