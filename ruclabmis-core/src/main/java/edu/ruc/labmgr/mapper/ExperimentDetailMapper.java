package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExperimentDetail;
import edu.ruc.labmgr.domain.ExperimentDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExperimentDetailMapper {
    int countByCriteria(ExperimentDetailCriteria example);

    int deleteByCriteria(ExperimentDetailCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentDetail record);

    int insertSelective(ExperimentDetail record);

    List<ExperimentDetail> selectByCriteriaWithRowbounds(ExperimentDetailCriteria example, RowBounds rowBounds);

    List<ExperimentDetail> selectByCriteria(ExperimentDetailCriteria example);

    ExperimentDetail selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") ExperimentDetail record, @Param("example") ExperimentDetailCriteria example);

    int updateByCriteria(@Param("record") ExperimentDetail record, @Param("example") ExperimentDetailCriteria example);

    int updateByPrimaryKeySelective(ExperimentDetail record);

    int updateByPrimaryKey(ExperimentDetail record);
}