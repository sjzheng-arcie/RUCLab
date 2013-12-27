package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Experiment;
import edu.ruc.labmgr.domain.ExperimentCriteria;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExperimentMapper {
    int countByExample(ExperimentCriteria example);

    int deleteByExample(ExperimentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Experiment record);

    int insertSelective(Experiment record);

    List<Experiment> selectByExampleWithRowbounds(ExperimentCriteria example, RowBounds rowBounds);

    List<Experiment> selectByExample(ExperimentCriteria example);

    List<Map<String,?>> selectStudentClassExpInfo(Map<String,?> param);

    Experiment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Experiment record, @Param("example") ExperimentCriteria example);

    int updateByExample(@Param("record") Experiment record, @Param("example") ExperimentCriteria example);

    int updateByPrimaryKeySelective(Experiment record);

    int updateByPrimaryKey(Experiment record);
}