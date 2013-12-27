package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.TermYear;
import edu.ruc.labmgr.domain.TermYearCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TermYearMapper {
    int countByCriteria(TermYearCriteria example);

    int deleteByCriteria(TermYearCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TermYear record);

    int insertSelective(TermYear record);

    List<TermYear> selectByCriteriaWithRowbounds(TermYearCriteria example, RowBounds rowBounds);

    List<TermYear> selectByCriteria(TermYearCriteria example);

    TermYear selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") TermYear record, @Param("example") TermYearCriteria example);

    int updateByCriteria(@Param("record") TermYear record, @Param("example") TermYearCriteria example);

    int updateByPrimaryKeySelective(TermYear record);

    int updateByPrimaryKey(TermYear record);
}