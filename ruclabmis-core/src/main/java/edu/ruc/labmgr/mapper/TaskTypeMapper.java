package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.TaskType;
import edu.ruc.labmgr.domain.TaskTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TaskTypeMapper {
    int countByExample(TaskTypeCriteria example);

    int deleteByExample(TaskTypeCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskType record);

    int insertSelective(TaskType record);

    List<TaskType> selectByExampleWithRowbounds(TaskTypeCriteria example, RowBounds rowBounds);

    List<TaskType> selectByExample(TaskTypeCriteria example);

    TaskType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskType record, @Param("example") TaskTypeCriteria example);

    int updateByExample(@Param("record") TaskType record, @Param("example") TaskTypeCriteria example);

    int updateByPrimaryKeySelective(TaskType record);

    int updateByPrimaryKey(TaskType record);
}