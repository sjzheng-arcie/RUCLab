package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.CurriculumExamination;
import edu.ruc.labmgr.domain.CurriculumExaminationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CurriculumExaminationMapper {
    int countByExample(CurriculumExaminationCriteria example);

    int deleteByExample(CurriculumExaminationCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CurriculumExamination record);

    int insertSelective(CurriculumExamination record);

    List<CurriculumExamination> selectByExampleWithRowbounds(CurriculumExaminationCriteria example, RowBounds rowBounds);

    List<CurriculumExamination> selectByExample(CurriculumExaminationCriteria example);

    CurriculumExamination selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CurriculumExamination record, @Param("example") CurriculumExaminationCriteria example);

    int updateByExample(@Param("record") CurriculumExamination record, @Param("example") CurriculumExaminationCriteria example);

    int updateByPrimaryKeySelective(CurriculumExamination record);

    int updateByPrimaryKey(CurriculumExamination record);
}