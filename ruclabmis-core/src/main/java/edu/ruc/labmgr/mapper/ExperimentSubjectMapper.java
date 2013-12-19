package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExperimentSubject;
import edu.ruc.labmgr.domain.ExperimentSubjectCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ExperimentSubjectMapper {
    int countByCriteria(ExperimentSubjectCriteria criteria);

    int deleteByCriteria(ExperimentSubjectCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentSubject record);

    int insertSelective(ExperimentSubject record);

    List<ExperimentSubject> selectByCriteriaWithRowbounds(ExperimentSubjectCriteria criteria, RowBounds rowBounds);

    List<ExperimentSubject> selectByCriteria(ExperimentSubjectCriteria criteria);

    ExperimentSubject selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") ExperimentSubject record, @Param("criteria") ExperimentSubjectCriteria criteria);

    int updateByCriteria(@Param("record") ExperimentSubject record, @Param("criteria") ExperimentSubjectCriteria criteria);

    int updateByPrimaryKeySelective(ExperimentSubject record);

    int updateByPrimaryKey(ExperimentSubject record);
}