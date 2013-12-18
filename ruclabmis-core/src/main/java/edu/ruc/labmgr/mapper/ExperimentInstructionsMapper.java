package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ExperimentInstructions;
import edu.ruc.labmgr.domain.ExperimentInstructionsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExperimentInstructionsMapper {
    int countByCriteria(ExperimentInstructionsCriteria example);

    int deleteByCriteria(ExperimentInstructionsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentInstructions record);

    int insertSelective(ExperimentInstructions record);

    List<ExperimentInstructions> selectByCriteriaWithRowbounds(ExperimentInstructionsCriteria example, RowBounds rowBounds);

    List<ExperimentInstructions> selectByCriteria(ExperimentInstructionsCriteria example);

    ExperimentInstructions selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") ExperimentInstructions record, @Param("example") ExperimentInstructionsCriteria example);

    int updateByCriteria(@Param("record") ExperimentInstructions record, @Param("example") ExperimentInstructionsCriteria example);

    int updateByPrimaryKeySelective(ExperimentInstructions record);

    int updateByPrimaryKey(ExperimentInstructions record);
}