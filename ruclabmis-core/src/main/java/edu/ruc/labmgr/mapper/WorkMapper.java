package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Work;
import edu.ruc.labmgr.domain.WorkCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WorkMapper {
    int countByExample(WorkCriteria example);

    int deleteByExample(WorkCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExampleWithRowbounds(WorkCriteria example, RowBounds rowBounds);

    List<Work> selectByExample(WorkCriteria example);

    Work selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkCriteria example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkCriteria example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}