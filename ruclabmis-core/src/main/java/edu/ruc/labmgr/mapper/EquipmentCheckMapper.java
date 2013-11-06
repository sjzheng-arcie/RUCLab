package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.EquipmentCheck;
import edu.ruc.labmgr.domain.EquipmentCheckCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EquipmentCheckMapper {
    int countByCriteria(EquipmentCheckCriteria example);

    int deleteByCriteria(EquipmentCheckCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentCheck record);

    int insertSelective(EquipmentCheck record);

    List<EquipmentCheck> selectByCriteriaWithRowbounds(EquipmentCheckCriteria example, RowBounds rowBounds);

    List<EquipmentCheck> selectByCriteria(EquipmentCheckCriteria example);

    EquipmentCheck selectByPrimaryKey(Integer id);

    List<EquipmentCheck> selectInventoryLoseWithRowbounds(RowBounds rowBounds);

    int countInventoryLose();

    int updateByCriteriaSelective(@Param("record") EquipmentCheck record, @Param("example") EquipmentCheckCriteria example);

    int updateByCriteria(@Param("record") EquipmentCheck record, @Param("example") EquipmentCheckCriteria example);

    int updateByPrimaryKeySelective(EquipmentCheck record);

    int updateByPrimaryKey(EquipmentCheck record);
}