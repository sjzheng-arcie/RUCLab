package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.CurriculumCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CurriculumMapper {
    int countByCriteria(CurriculumCriteria example);

    int deleteByCriteria(CurriculumCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Curriculum record);

    int insertSelective(Curriculum record);

    List<Curriculum> selectByCriteriaWithRowbounds(CurriculumCriteria example, RowBounds rowBounds);

    List<Curriculum> selectByCriteria(CurriculumCriteria example);

    Curriculum selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Curriculum record, @Param("example") CurriculumCriteria example);

    int updateByCriteria(@Param("record") Curriculum record, @Param("example") CurriculumCriteria example);

    int updateByPrimaryKeySelective(Curriculum record);

    int updateByPrimaryKey(Curriculum record);
}