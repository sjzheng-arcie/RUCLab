package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExperimentDetail;
import edu.ruc.labmgr.domain.ExperimentDetailCriteria;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExperimentDetailMapper {
    int countByExample(ExperimentDetailCriteria example);

    int countStudentExperiment(@Param("eid")Integer eid);

    int deleteByExample(ExperimentDetailCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentDetail record);

    int insertSelective(ExperimentDetail record);

    List<ExperimentDetail> selectByExampleWithRowbounds(ExperimentDetailCriteria example, RowBounds rowBounds);

    List<Map<String,?>> selectStudentExperimentsWithRowbound(@Param("eid") Integer eid,RowBounds rowBounds);
	List<Map<String,?>> selectExperimentDetailByStuId(@Param("eid")Integer eid,@Param("stuId")Integer stuId);


//	List<Map<String,?>> selectStudentExperimentsWithRowbound(@Param("eid") Integer eid,RowBounds rowBounds);

    List<ExperimentDetail> selectByExample(ExperimentDetailCriteria example);

    ExperimentDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExperimentDetail record, @Param("example") ExperimentDetailCriteria example);

    int updateByExample(@Param("record") ExperimentDetail record, @Param("example") ExperimentDetailCriteria example);

    int updateByPrimaryKeySelective(ExperimentDetail record);

    int updateByPrimaryKey(ExperimentDetail record);
}