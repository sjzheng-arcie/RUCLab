package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.CurriculumClass;
import edu.ruc.labmgr.domain.CurriculumClassCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CurriculumClassMapper {
    int countByCriteria(CurriculumClassCriteria example);

    int deleteByCriteria(CurriculumClassCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CurriculumClass record);

    int insertSelective(CurriculumClass record);

    List<CurriculumClass> selectByCriteriaWithRowbounds(CurriculumClassCriteria example, RowBounds rowBounds);

    List<CurriculumClass> selectByCriteria(CurriculumClassCriteria example);

    CurriculumClass selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") CurriculumClass record, @Param("example") CurriculumClassCriteria example);

    int updateByCriteria(@Param("record") CurriculumClass record, @Param("example") CurriculumClassCriteria example);

    int updateByPrimaryKeySelective(CurriculumClass record);

    int updateByPrimaryKey(CurriculumClass record);
}