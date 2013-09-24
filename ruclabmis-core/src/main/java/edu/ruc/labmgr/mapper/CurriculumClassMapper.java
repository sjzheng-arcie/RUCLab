package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.CurriculumClass;

public interface CurriculumClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CurriculumClass record);

    int insertSelective(CurriculumClass record);

    CurriculumClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CurriculumClass record);

    int updateByPrimaryKey(CurriculumClass record);
}