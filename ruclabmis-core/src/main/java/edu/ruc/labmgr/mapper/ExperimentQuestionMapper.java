package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExperimentQuestion;
import edu.ruc.labmgr.domain.ExperimentQuestionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExperimentQuestionMapper {
    int countByCriteria(ExperimentQuestionCriteria criteria);

    int deleteByCriteria(ExperimentQuestionCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentQuestion record);

    int insertSelective(ExperimentQuestion record);

    List<ExperimentQuestion> selectByCriteriaWithRowbounds(ExperimentQuestionCriteria criteria, RowBounds rowBounds);

    List<ExperimentQuestion> selectByCriteria(ExperimentQuestionCriteria criteria);

    ExperimentQuestion selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") ExperimentQuestion record, @Param("criteria") ExperimentQuestionCriteria criteria);

    int updateByCriteria(@Param("record") ExperimentQuestion record, @Param("criteria") ExperimentQuestionCriteria criteria);

    int updateByPrimaryKeySelective(ExperimentQuestion record);

    int updateByPrimaryKey(ExperimentQuestion record);
}