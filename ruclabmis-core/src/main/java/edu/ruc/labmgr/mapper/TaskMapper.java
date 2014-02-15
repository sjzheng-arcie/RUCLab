package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Task;
import edu.ruc.labmgr.domain.TaskCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TaskMapper {
    int countByCriteria(TaskCriteria criteria);

    int deleteByCriteria(TaskCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByCriteriaWithRowbounds(TaskCriteria criteria, RowBounds rowBounds);

    List<Task> selectByCriteria(TaskCriteria criteria);

    Task selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Task record, @Param("criteria") TaskCriteria criteria);

    int updateByCriteria(@Param("record") Task record, @Param("criteria") TaskCriteria criteria);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}