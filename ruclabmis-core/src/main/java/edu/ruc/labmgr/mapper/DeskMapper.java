package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Desk;
import edu.ruc.labmgr.domain.DeskCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DeskMapper {
    int countByCriteria(DeskCriteria criteria);

    int deleteByCriteria(DeskCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Desk record);

    int insertSelective(Desk record);

    List<Desk> selectByCriteriaWithRowbounds(DeskCriteria criteria, RowBounds rowBounds);

    List<Desk> selectByCriteria(DeskCriteria criteria);

    Desk selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Desk record, @Param("criteria") DeskCriteria criteria);

    int updateByCriteria(@Param("record") Desk record, @Param("criteria") DeskCriteria criteria);

    int updateByPrimaryKeySelective(Desk record);

    int updateByPrimaryKey(Desk record);
}