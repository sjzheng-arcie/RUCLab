package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.RolesPrivilegeKey;

public interface RolesPrivilegeMapper {
    int deleteByPrimaryKey(RolesPrivilegeKey key);

    int insert(RolesPrivilegeKey record);

    int insertSelective(RolesPrivilegeKey record);
}