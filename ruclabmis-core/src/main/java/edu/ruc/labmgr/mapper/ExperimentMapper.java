package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Experiment;
import edu.ruc.labmgr.domain.ExperimentCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ExperimentMapper {
    int countByCriteria(ExperimentCriteria criteria);

    int deleteByCriteria(ExperimentCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Experiment record);

    int insertSelective(Experiment record);

    List<Experiment> selectByCriteriaWithRowbounds(ExperimentCriteria criteria, RowBounds rowBounds);

    List<Experiment> selectByCriteria(ExperimentCriteria criteria);

    Experiment selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Experiment record, @Param("criteria") ExperimentCriteria criteria);

    int updateByCriteria(@Param("record") Experiment record, @Param("criteria") ExperimentCriteria criteria);

    int updateByPrimaryKeySelective(Experiment record);

    int updateByPrimaryKey(Experiment record);
}