package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExperimentInstructions;
import edu.ruc.labmgr.domain.ExperimentInstructionsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExperimentInstructionsMapper {
    int countByExample(ExperimentInstructionsCriteria example);

    int deleteByExample(ExperimentInstructionsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentInstructions record);

    int insertSelective(ExperimentInstructions record);

    List<ExperimentInstructions> selectByExampleWithRowbounds(ExperimentInstructionsCriteria example, RowBounds rowBounds);

    List<ExperimentInstructions> selectByExample(ExperimentInstructionsCriteria example);

    ExperimentInstructions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExperimentInstructions record, @Param("example") ExperimentInstructionsCriteria example);

    int updateByExample(@Param("record") ExperimentInstructions record, @Param("example") ExperimentInstructionsCriteria example);

    int updateByPrimaryKeySelective(ExperimentInstructions record);

    int updateByPrimaryKey(ExperimentInstructions record);
}