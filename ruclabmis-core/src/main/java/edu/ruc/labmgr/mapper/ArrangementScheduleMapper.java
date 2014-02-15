package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ArrangementSchedule;
import edu.ruc.labmgr.domain.ArrangementScheduleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArrangementScheduleMapper {
    int countByCriteria(ArrangementScheduleCriteria criteria);

    int deleteByCriteria(ArrangementScheduleCriteria criteria);

    int insert(ArrangementSchedule record);

    int insertSelective(ArrangementSchedule record);

    List<ArrangementSchedule> selectByCriteriaWithRowbounds(ArrangementScheduleCriteria criteria, RowBounds rowBounds);

    List<ArrangementSchedule> selectByCriteria(ArrangementScheduleCriteria criteria);

    int updateByCriteriaSelective(@Param("record") ArrangementSchedule record, @Param("criteria") ArrangementScheduleCriteria criteria);

    int updateByCriteria(@Param("record") ArrangementSchedule record, @Param("criteria") ArrangementScheduleCriteria criteria);
}