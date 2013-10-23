package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.domain.EquipmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EquipmentMapper {
    int countByExample(EquipmentCriteria example);

    int deleteByExample(EquipmentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    List<Equipment> selectByExampleWithRowbounds(EquipmentCriteria example, RowBounds rowBounds);

    List<Equipment> selectByExample(EquipmentCriteria example);

    Equipment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Equipment record, @Param("example") EquipmentCriteria example);

    int updateByExample(@Param("record") Equipment record, @Param("example") EquipmentCriteria example);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}