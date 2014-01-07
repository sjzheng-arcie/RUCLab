package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Arrangement;
import edu.ruc.labmgr.domain.ArrangementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArrangementMapper {
    int countByCriteria(ArrangementCriteria example);

    int deleteByCriteria(ArrangementCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Arrangement record);

    int insertSelective(Arrangement record);

    List<Arrangement> selectByCriteriaWithRowbounds(ArrangementCriteria example, RowBounds rowBounds);

    List<Arrangement> selectByCriteria(ArrangementCriteria example);

    Arrangement selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Arrangement record, @Param("example") ArrangementCriteria example);

    int updateByCriteria(@Param("record") Arrangement record, @Param("example") ArrangementCriteria example);

    int updateByPrimaryKeySelective(Arrangement record);

    int updateByPrimaryKey(Arrangement record);
}