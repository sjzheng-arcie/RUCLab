package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExamItemPool;

public interface ExamItemPoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamItemPool record);

    int insertSelective(ExamItemPool record);

    ExamItemPool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamItemPool record);

    int updateByPrimaryKey(ExamItemPool record);
}