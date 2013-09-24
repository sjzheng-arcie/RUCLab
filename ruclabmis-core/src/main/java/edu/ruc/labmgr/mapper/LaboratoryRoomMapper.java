package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.LaboratoryRoomKey;

public interface LaboratoryRoomMapper {
    int deleteByPrimaryKey(LaboratoryRoomKey key);

    int insert(LaboratoryRoomKey record);

    int insertSelective(LaboratoryRoomKey record);
}