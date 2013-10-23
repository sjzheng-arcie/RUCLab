package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.EquipmentApplicationFormCriteria;
import edu.ruc.labmgr.domain.EquipmentApplicationFormKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EquipmentApplicationFormMapper {
    int countByExample(EquipmentApplicationFormCriteria example);

    int deleteByExample(EquipmentApplicationFormCriteria example);

    int deleteByPrimaryKey(EquipmentApplicationFormKey key);

    int insert(EquipmentApplicationFormKey record);

    int insertSelective(EquipmentApplicationFormKey record);

    List<EquipmentApplicationFormKey> selectByExampleWithRowbounds(EquipmentApplicationFormCriteria example, RowBounds rowBounds);

    List<EquipmentApplicationFormKey> selectByExample(EquipmentApplicationFormCriteria example);

    int updateByExampleSelective(@Param("record") EquipmentApplicationFormKey record, @Param("example") EquipmentApplicationFormCriteria example);

    int updateByExample(@Param("record") EquipmentApplicationFormKey record, @Param("example") EquipmentApplicationFormCriteria example);
}