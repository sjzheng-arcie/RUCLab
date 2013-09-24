package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.TeacherRolesKey;

public interface TeacherRolesMapper {
    int deleteByPrimaryKey(TeacherRolesKey key);

    int insert(TeacherRolesKey record);

    int insertSelective(TeacherRolesKey record);
}