package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ApplyWithEquipment;
import edu.ruc.labmgr.domain.ApplyWithEquipmentCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ApplyWithEquipmentMapper {
    int countByCriteria(ApplyWithEquipmentCriteria criteria);

    int deleteByCriteria(ApplyWithEquipmentCriteria criteria);

    int insert(ApplyWithEquipment record);

    int insertSelective(ApplyWithEquipment record);

    List<ApplyWithEquipment> selectByCriteriaWithRowbounds(ApplyWithEquipmentCriteria criteria, RowBounds rowBounds);

    List<ApplyWithEquipment> selectByCriteria(ApplyWithEquipmentCriteria criteria);

    ApplyWithEquipment selectByApplyId(int id);

    int updateByCriteriaSelective(@Param("record") ApplyWithEquipment record, @Param("criteria") ApplyWithEquipmentCriteria criteria);

    int updateByCriteria(@Param("record") ApplyWithEquipment record, @Param("criteria") ApplyWithEquipmentCriteria criteria);
}