package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ArrangementEquipmentKey;

public interface ArrangementEquipmentMapper {
    int deleteByPrimaryKey(ArrangementEquipmentKey key);

    int insert(ArrangementEquipmentKey record);

    int insertSelective(ArrangementEquipmentKey record);
}