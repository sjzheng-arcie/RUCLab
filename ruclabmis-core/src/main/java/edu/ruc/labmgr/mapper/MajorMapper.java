package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Major;
import edu.ruc.labmgr.domain.MajorCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MajorMapper {
    int countByCriteria(MajorCriteria criteria);

    int deleteByCriteria(MajorCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    int insertSelective(Major record);

    List<Major> selectByCriteriaWithRowbounds(MajorCriteria criteria, RowBounds rowBounds);

    List<Major> selectByCriteria(MajorCriteria criteria);

    Major selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Major record, @Param("criteria") MajorCriteria criteria);

    int updateByCriteria(@Param("record") Major record, @Param("criteria") MajorCriteria criteria);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}