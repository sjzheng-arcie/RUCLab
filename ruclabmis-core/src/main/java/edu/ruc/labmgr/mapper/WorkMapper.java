package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Work;
import edu.ruc.labmgr.domain.WorkCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WorkMapper {
    int countByCriteria(WorkCriteria criteria);

    int deleteByCriteria(WorkCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByCriteriaWithRowbounds(WorkCriteria criteria, RowBounds rowBounds);

    List<Work> selectByCriteria(WorkCriteria criteria);

    Work selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Work record, @Param("criteria") WorkCriteria criteria);

    int updateByCriteria(@Param("record") Work record, @Param("criteria") WorkCriteria criteria);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}