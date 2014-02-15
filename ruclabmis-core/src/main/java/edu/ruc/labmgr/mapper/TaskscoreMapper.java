package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Taskscore;
import edu.ruc.labmgr.domain.TaskscoreCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TaskscoreMapper {
    int countByCriteria(TaskscoreCriteria criteria);

    int deleteByCriteria(TaskscoreCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Taskscore record);

    int insertSelective(Taskscore record);

    List<Taskscore> selectByCriteriaWithRowbounds(TaskscoreCriteria criteria, RowBounds rowBounds);

    List<Taskscore> selectByCriteria(TaskscoreCriteria criteria);

    Taskscore selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Taskscore record, @Param("criteria") TaskscoreCriteria criteria);

    int updateByCriteria(@Param("record") Taskscore record, @Param("criteria") TaskscoreCriteria criteria);

    int updateByPrimaryKeySelective(Taskscore record);

    int updateByPrimaryKey(Taskscore record);
}