package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExamItemPool;
import edu.ruc.labmgr.domain.ExamItemPoolCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExamItemPoolMapper {
    int countByCriteria(ExamItemPoolCriteria criteria);

    int deleteByCriteria(ExamItemPoolCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamItemPool record);

    int insertSelective(ExamItemPool record);

    List<ExamItemPool> selectByCriteriaWithRowbounds(ExamItemPoolCriteria criteria, RowBounds rowBounds);

    List<ExamItemPool> selectByCriteria(ExamItemPoolCriteria criteria);

    ExamItemPool selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") ExamItemPool record, @Param("criteria") ExamItemPoolCriteria criteria);

    int updateByCriteria(@Param("record") ExamItemPool record, @Param("criteria") ExamItemPoolCriteria criteria);

    int updateByPrimaryKeySelective(ExamItemPool record);

    int updateByPrimaryKey(ExamItemPool record);
}