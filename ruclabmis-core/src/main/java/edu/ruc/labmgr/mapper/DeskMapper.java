package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Desk;

public interface DeskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Desk record);

    int insertSelective(Desk record);

    Desk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Desk record);

    int updateByPrimaryKey(Desk record);
}