package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Experiment;

public interface ExperimentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Experiment record);

    int insertSelective(Experiment record);

    Experiment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Experiment record);

    int updateByPrimaryKey(Experiment record);
}