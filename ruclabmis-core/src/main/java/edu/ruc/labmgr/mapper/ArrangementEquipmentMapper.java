package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ArrangementEquipmentCriteria;
import edu.ruc.labmgr.domain.ArrangementEquipmentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArrangementEquipmentMapper {
    int countByCriteria(ArrangementEquipmentCriteria criteria);

    int deleteByCriteria(ArrangementEquipmentCriteria criteria);

    int deleteByPrimaryKey(ArrangementEquipmentKey key);

    int insert(ArrangementEquipmentKey record);

    int insertSelective(ArrangementEquipmentKey record);

    List<ArrangementEquipmentKey> selectByCriteriaWithRowbounds(ArrangementEquipmentCriteria criteria, RowBounds rowBounds);

    List<ArrangementEquipmentKey> selectByCriteria(ArrangementEquipmentCriteria criteria);

    int updateByCriteriaSelective(@Param("record") ArrangementEquipmentKey record, @Param("criteria") ArrangementEquipmentCriteria criteria);

    int updateByCriteria(@Param("record") ArrangementEquipmentKey record, @Param("criteria") ArrangementEquipmentCriteria criteria);
}