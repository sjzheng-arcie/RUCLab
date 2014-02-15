package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.CurriculumSchedule;
import edu.ruc.labmgr.domain.CurriculumScheduleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CurriculumScheduleMapper {
    int countByCriteria(CurriculumScheduleCriteria criteria);

    int deleteByCriteria(CurriculumScheduleCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(CurriculumSchedule record);

    int insertSelective(CurriculumSchedule record);

    List<CurriculumSchedule> selectByCriteriaWithRowbounds(CurriculumScheduleCriteria criteria, RowBounds rowBounds);

    List<CurriculumSchedule> selectByCriteria(CurriculumScheduleCriteria criteria);
	List<CurriculumSchedule> getAllCurriculumNameList(CurriculumScheduleCriteria criteria);

    CurriculumSchedule selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") CurriculumSchedule record, @Param("criteria") CurriculumScheduleCriteria criteria);

    int updateByCriteria(@Param("record") CurriculumSchedule record, @Param("criteria") CurriculumScheduleCriteria criteria);

    int updateByPrimaryKeySelective(CurriculumSchedule record);

    int updateByPrimaryKey(CurriculumSchedule record);
}