package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ArrangementSchedule;
import edu.ruc.labmgr.domain.ArrangementScheduleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArrangementScheduleMapper {
    int countByCriteria(ArrangementScheduleCriteria example);

    int deleteByCriteria(ArrangementScheduleCriteria example);

    int insert(ArrangementSchedule record);

    int insertSelective(ArrangementSchedule record);

    List<ArrangementSchedule> selectByCriteriaWithRowbounds(ArrangementScheduleCriteria example, RowBounds rowBounds);

    List<ArrangementSchedule> selectByCriteria(ArrangementScheduleCriteria example);

    int updateByCriteriaSelective(@Param("record") ArrangementSchedule record, @Param("example") ArrangementScheduleCriteria example);

    int updateByCriteria(@Param("record") ArrangementSchedule record, @Param("example") ArrangementScheduleCriteria example);
}