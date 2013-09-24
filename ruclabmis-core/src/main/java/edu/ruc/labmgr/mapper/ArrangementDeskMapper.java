package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ArrangementDeskKey;

public interface ArrangementDeskMapper {
    int deleteByPrimaryKey(ArrangementDeskKey key);

    int insert(ArrangementDeskKey record);

    int insertSelective(ArrangementDeskKey record);
}