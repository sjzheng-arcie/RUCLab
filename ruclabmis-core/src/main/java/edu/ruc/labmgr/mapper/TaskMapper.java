package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Task;
import edu.ruc.labmgr.domain.TaskCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TaskMapper {
    int countByExample(TaskCriteria example);

    int deleteByExample(TaskCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExampleWithRowbounds(TaskCriteria example, RowBounds rowBounds);

    List<Task> selectByExample(TaskCriteria example);

    Task selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskCriteria example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskCriteria example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}