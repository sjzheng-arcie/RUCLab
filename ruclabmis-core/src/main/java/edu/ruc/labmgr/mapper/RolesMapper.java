package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Roles;

public interface RolesMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
}