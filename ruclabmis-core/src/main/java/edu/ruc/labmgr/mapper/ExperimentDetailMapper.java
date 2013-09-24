package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExperimentDetail;

public interface ExperimentDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentDetail record);

    int insertSelective(ExperimentDetail record);

    ExperimentDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExperimentDetail record);

    int updateByPrimaryKeyWithBLOBs(ExperimentDetail record);

    int updateByPrimaryKey(ExperimentDetail record);
}