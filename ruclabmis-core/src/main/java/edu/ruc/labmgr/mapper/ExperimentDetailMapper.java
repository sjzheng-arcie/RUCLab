package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExperimentDetail;
import edu.ruc.labmgr.domain.ExperimentDetailCriteria;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExperimentDetailMapper {
    int countByCriteria(ExperimentDetailCriteria criteria);

    int countStudentExperiment(@Param("eid")Integer eid);

    int deleteByCriteria(ExperimentDetailCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentDetail record);

    int insertSelective(ExperimentDetail record);

    List<ExperimentDetail> selectByCriteriaWithRowbounds(ExperimentDetailCriteria criteria, RowBounds rowBounds);

    List<Map<String,?>> selectStudentExperimentsWithRowbound(@Param("eid") Integer eid,RowBounds rowBounds);
	List<Map<String,?>> selectExperimentDetailByStuId(@Param("eid")Integer eid,@Param("stuId")Integer stuId);


//	List<Map<String,?>> selectStudentExperimentsWithRowbound(@Param("eid") Integer eid,RowBounds rowBounds);

    List<ExperimentDetail> selectByCriteria(ExperimentDetailCriteria criteria);

    ExperimentDetail selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") ExperimentDetail record, @Param("criteria") ExperimentDetailCriteria criteria);

    int updateByCriteria(@Param("record") ExperimentDetail record, @Param("criteria") ExperimentDetailCriteria criteria);

    int updateByPrimaryKeySelective(ExperimentDetail record);

    int updateByPrimaryKey(ExperimentDetail record);
}