package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.domain.EquipmentCheck;
import edu.ruc.labmgr.domain.EquipmentCheckCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EquipmentCheckMapper {
    int countByCriteria(EquipmentCheckCriteria criteria);

    int deleteByCriteria(EquipmentCheckCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentCheck record);

    int insertSelective(EquipmentCheck record);

    List<EquipmentCheck> selectByCriteriaWithRowbounds(EquipmentCheckCriteria criteria, RowBounds rowBounds);

    List<EquipmentCheck> selectByCriteria(EquipmentCheckCriteria criteria);

    EquipmentCheck selectByPrimaryKey(Integer id);

    List<EquipmentCheck> selectInventoryLoseWithRowbounds(RowBounds rowBounds);

    int countInventoryLose();

    int updateByCriteriaSelective(@Param("record") EquipmentCheck record, @Param("criteria") EquipmentCheckCriteria criteria);

    int updateByCriteria(@Param("record") EquipmentCheck record, @Param("criteria") EquipmentCheckCriteria criteria);

    int updateByPrimaryKeySelective(EquipmentCheck record);

    int updateByPrimaryKey(EquipmentCheck record);

    Integer selectIdBySn(@Param("sn")String sn);
}