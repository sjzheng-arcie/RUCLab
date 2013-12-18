package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Desk;
import edu.ruc.labmgr.domain.DeskCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DeskMapper {
    int countByExample(DeskCriteria example);

    int deleteByExample(DeskCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Desk record);

    int insertSelective(Desk record);

    List<Desk> selectByExampleWithRowbounds(DeskCriteria example, RowBounds rowBounds);

    List<Desk> selectByExample(DeskCriteria example);

    Desk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Desk record, @Param("example") DeskCriteria example);

    int updateByExample(@Param("record") Desk record, @Param("example") DeskCriteria example);

    int updateByPrimaryKeySelective(Desk record);

    int updateByPrimaryKey(Desk record);
}