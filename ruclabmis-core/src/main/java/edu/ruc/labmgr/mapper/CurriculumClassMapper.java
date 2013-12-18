package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.CurriculumClass;
import edu.ruc.labmgr.domain.CurriculumClassCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CurriculumClassMapper {
    int countByCriteria(CurriculumClassCriteria criteria);
	int countByCriteriaByJoinIncludeCS(CurriculumClassCriteria criteria);
	int countByCriteriaJoinNotIncludeCS(CurriculumClassCriteria criteria);

    int deleteByCriteria(CurriculumClassCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(CurriculumClass record);

    int insertSelective(CurriculumClass record);

    List<CurriculumClass> selectByCriteriaWithRowbounds(CurriculumClassCriteria criteria, RowBounds rowBounds);

    List<CurriculumClass> selectByCriteria(CurriculumClassCriteria criteria);
	List<CurriculumClass> selectByCriteriaAndClsStudentWithRowbounds(CurriculumClassCriteria criteria, RowBounds rowBounds);

	List<CurriculumClass> selectByCriteriaAndClsStudent(CurriculumClassCriteria criteria);

    CurriculumClass selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") CurriculumClass record, @Param("criteria") CurriculumClassCriteria criteria);

    int updateByCriteria(@Param("record") CurriculumClass record, @Param("criteria") CurriculumClassCriteria criteria);

    int updateByPrimaryKeySelective(CurriculumClass record);

    int updateByPrimaryKey(CurriculumClass record);
}