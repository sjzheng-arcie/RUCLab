package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.CurriculumSchedule;
import edu.ruc.labmgr.domain.CurriculumScheduleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CurriculumScheduleMapper {
    int countByCriteria(CurriculumScheduleCriteria example);

    int deleteByCriteria(CurriculumScheduleCriteria example);

    int insert(CurriculumSchedule record);

    int insertSelective(CurriculumSchedule record);

    List<CurriculumSchedule> selectByCriteriaWithRowbounds(CurriculumScheduleCriteria example, RowBounds rowBounds);

    List<CurriculumSchedule> selectByCriteria(CurriculumScheduleCriteria example);

    int updateByCriteriaSelective(@Param("record") CurriculumSchedule record, @Param("example") CurriculumScheduleCriteria example);

    int updateByCriteria(@Param("record") CurriculumSchedule record, @Param("example") CurriculumScheduleCriteria example);
}