package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.CurriculumCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CurriculumMapper {
    int countByCriteria(CurriculumCriteria criteria);

    int deleteByCriteria(CurriculumCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Curriculum record);

    int insertSelective(Curriculum record);

    List<Curriculum> selectByCriteriaWithRowbounds(CurriculumCriteria criteria, RowBounds rowBounds);

    List<Curriculum> selectByCriteria(CurriculumCriteria criteria);

    Integer selectIdBySn(@Param("curriculumSn") String curriculumSn, @Param("classSn") String classSn);

    Curriculum selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Curriculum record, @Param("criteria") CurriculumCriteria criteria);

    int updateByCriteria(@Param("record") Curriculum record, @Param("criteria") CurriculumCriteria criteria);

    int updateByPrimaryKeySelective(Curriculum record);

    int updateByPrimaryKey(Curriculum record);
}