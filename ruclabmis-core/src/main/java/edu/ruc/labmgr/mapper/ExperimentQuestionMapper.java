package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExperimentQuestion;

public interface ExperimentQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentQuestion record);

    int insertSelective(ExperimentQuestion record);

    ExperimentQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExperimentQuestion record);

    int updateByPrimaryKey(ExperimentQuestion record);
}