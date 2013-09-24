package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.StudentRolesKey;

public interface StudentRolesMapper {
    int deleteByPrimaryKey(StudentRolesKey key);

    int insert(StudentRolesKey record);

    int insertSelective(StudentRolesKey record);
}