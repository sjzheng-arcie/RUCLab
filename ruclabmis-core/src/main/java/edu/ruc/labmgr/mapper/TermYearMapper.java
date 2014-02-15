package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.TermYear;
import edu.ruc.labmgr.domain.TermYearCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TermYearMapper {
    int countByCriteria(TermYearCriteria criteria);

    int deleteByCriteria(TermYearCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(TermYear record);

    int insertSelective(TermYear record);

    List<TermYear> selectByCriteriaWithRowbounds(TermYearCriteria criteria, RowBounds rowBounds);

    List<TermYear> selectByCriteria(TermYearCriteria criteria);

    TermYear selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") TermYear record, @Param("criteria") TermYearCriteria criteria);

    int updateByCriteria(@Param("record") TermYear record, @Param("criteria") TermYearCriteria criteria);

    int updateByPrimaryKeySelective(TermYear record);

    int updateByPrimaryKey(TermYear record);
}