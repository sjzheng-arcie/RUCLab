package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Position;
import edu.ruc.labmgr.domain.PositionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PositionMapper {
    int countByCriteria(PositionCriteria criteria);

    int deleteByCriteria(PositionCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByCriteriaWithRowbounds(PositionCriteria criteria, RowBounds rowBounds);

    List<Position> selectByCriteria(PositionCriteria criteria);

    Position selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Position record, @Param("criteria") PositionCriteria criteria);

    int updateByCriteria(@Param("record") Position record, @Param("criteria") PositionCriteria criteria);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}