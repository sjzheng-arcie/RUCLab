package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Calendar;
import edu.ruc.labmgr.domain.CalendarCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CalendarMapper {
    int countByCriteria(CalendarCriteria criteria);

    int deleteByCriteria(CalendarCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Calendar record);

    int insertSelective(Calendar record);

    List<Calendar> selectByCriteriaWithRowbounds(CalendarCriteria criteria, RowBounds rowBounds);

    List<Calendar> selectByCriteria(CalendarCriteria criteria);

    Calendar selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Calendar record, @Param("criteria") CalendarCriteria criteria);

    int updateByCriteria(@Param("record") Calendar record, @Param("criteria") CalendarCriteria criteria);

    int updateByPrimaryKeySelective(Calendar record);

    int updateByPrimaryKey(Calendar record);
}