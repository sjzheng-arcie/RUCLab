package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.CurriculumExamination;
import edu.ruc.labmgr.domain.CurriculumExaminationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CurriculumExaminationMapper {
    int countByCriteria(CurriculumExaminationCriteria criteria);

    int deleteByCriteria(CurriculumExaminationCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(CurriculumExamination record);

    int insertSelective(CurriculumExamination record);

    List<CurriculumExamination> selectByCriteriaWithRowbounds(CurriculumExaminationCriteria criteria, RowBounds rowBounds);

    List<CurriculumExamination> selectByCriteria(CurriculumExaminationCriteria criteria);

    CurriculumExamination selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") CurriculumExamination record, @Param("criteria") CurriculumExaminationCriteria criteria);

    int updateByCriteria(@Param("record") CurriculumExamination record, @Param("criteria") CurriculumExaminationCriteria criteria);

    int updateByPrimaryKeySelective(CurriculumExamination record);

    int updateByPrimaryKey(CurriculumExamination record);
}