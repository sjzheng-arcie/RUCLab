package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.EquipmentApplicationFormCriteria;
import edu.ruc.labmgr.domain.EquipmentApplicationFormKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface EquipmentApplicationFormMapper {
    int countByCriteria(EquipmentApplicationFormCriteria criteria);

    int deleteByCriteria(EquipmentApplicationFormCriteria criteria);

    int deleteByPrimaryKey(EquipmentApplicationFormKey key);

    int insert(EquipmentApplicationFormKey record);

    int insertSelective(EquipmentApplicationFormKey record);

    List<EquipmentApplicationFormKey> selectByCriteriaWithRowbounds(EquipmentApplicationFormCriteria criteria, RowBounds rowBounds);

    List<EquipmentApplicationFormKey> selectByCriteria(EquipmentApplicationFormCriteria criteria);

    int updateByCriteriaSelective(@Param("record") EquipmentApplicationFormKey record, @Param("criteria") EquipmentApplicationFormCriteria criteria);

    int updateByCriteria(@Param("record") EquipmentApplicationFormKey record, @Param("criteria") EquipmentApplicationFormCriteria criteria);
}