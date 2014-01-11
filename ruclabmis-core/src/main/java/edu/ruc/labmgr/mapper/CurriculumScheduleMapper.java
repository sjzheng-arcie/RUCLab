package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.CurriculumSchedule;
import edu.ruc.labmgr.domain.CurriculumScheduleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CurriculumScheduleMapper {
    int countByExample(CurriculumScheduleCriteria example);

    int deleteByExample(CurriculumScheduleCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CurriculumSchedule record);

    int insertSelective(CurriculumSchedule record);

    List<CurriculumSchedule> selectByExampleWithRowbounds(CurriculumScheduleCriteria example, RowBounds rowBounds);

    List<CurriculumSchedule> selectByExample(CurriculumScheduleCriteria example);
	List<CurriculumSchedule> getAllCurriculumNameList(CurriculumScheduleCriteria example);

    CurriculumSchedule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CurriculumSchedule record, @Param("example") CurriculumScheduleCriteria example);

    int updateByExample(@Param("record") CurriculumSchedule record, @Param("example") CurriculumScheduleCriteria example);

    int updateByPrimaryKeySelective(CurriculumSchedule record);

    int updateByPrimaryKey(CurriculumSchedule record);
}