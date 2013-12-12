package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Experiment;
import edu.ruc.labmgr.domain.ExperimentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExperimentMapper {
    int countByCriteria(ExperimentCriteria example);

    int deleteByCriteria(ExperimentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Experiment record);

    int insertSelective(Experiment record);

    List<Experiment> selectByCriteriaWithRowbounds(ExperimentCriteria example, RowBounds rowBounds);

    List<Experiment> selectByCriteria(ExperimentCriteria example);

    Experiment selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Experiment record, @Param("example") ExperimentCriteria example);

    int updateByCriteria(@Param("record") Experiment record, @Param("example") ExperimentCriteria example);

    int updateByPrimaryKeySelective(Experiment record);

    int updateByPrimaryKey(Experiment record);
}