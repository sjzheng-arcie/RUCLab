package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Taskscore;
import edu.ruc.labmgr.domain.TaskscoreCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TaskscoreMapper {
    int countByExample(TaskscoreCriteria example);

    int deleteByExample(TaskscoreCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Taskscore record);

    int insertSelective(Taskscore record);

    List<Taskscore> selectByExampleWithRowbounds(TaskscoreCriteria example, RowBounds rowBounds);

    List<Taskscore> selectByExample(TaskscoreCriteria example);

    Taskscore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Taskscore record, @Param("example") TaskscoreCriteria example);

    int updateByExample(@Param("record") Taskscore record, @Param("example") TaskscoreCriteria example);

    int updateByPrimaryKeySelective(Taskscore record);

    int updateByPrimaryKey(Taskscore record);
}