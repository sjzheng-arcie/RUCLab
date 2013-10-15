package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Arrangement;
import edu.ruc.labmgr.domain.ArrangementCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ArrangementMapper {
    int countByCriteria(ArrangementCriteria criteria);

    int deleteByCriteria(ArrangementCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Arrangement record);

    int insertSelective(Arrangement record);

    List<Arrangement> selectByCriteriaWithRowbounds(ArrangementCriteria criteria, RowBounds rowBounds);

    List<Arrangement> selectByCriteria(ArrangementCriteria criteria);

    Arrangement selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Arrangement record, @Param("criteria") ArrangementCriteria criteria);

    int updateByCriteria(@Param("record") Arrangement record, @Param("criteria") ArrangementCriteria criteria);

    int updateByPrimaryKeySelective(Arrangement record);

    int updateByPrimaryKey(Arrangement record);
}