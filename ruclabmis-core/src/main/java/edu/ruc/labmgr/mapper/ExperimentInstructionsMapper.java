package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExperimentInstructions;
import edu.ruc.labmgr.domain.ExperimentInstructionsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExperimentInstructionsMapper {
    int countByCriteria(ExperimentInstructionsCriteria criteria);

    int deleteByCriteria(ExperimentInstructionsCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentInstructions record);

    int insertSelective(ExperimentInstructions record);

    List<ExperimentInstructions> selectByCriteriaWithRowbounds(ExperimentInstructionsCriteria criteria, RowBounds rowBounds);

    List<ExperimentInstructions> selectByCriteria(ExperimentInstructionsCriteria criteria);

    ExperimentInstructions selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") ExperimentInstructions record, @Param("criteria") ExperimentInstructionsCriteria criteria);

    int updateByCriteria(@Param("record") ExperimentInstructions record, @Param("criteria") ExperimentInstructionsCriteria criteria);

    int updateByPrimaryKeySelective(ExperimentInstructions record);

    int updateByPrimaryKey(ExperimentInstructions record);
}