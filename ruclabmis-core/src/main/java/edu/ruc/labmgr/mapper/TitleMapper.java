package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Title;
import edu.ruc.labmgr.domain.TitleCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TitleMapper {
    int countByCriteria(TitleCriteria criteria);

    int deleteByCriteria(TitleCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Title record);

    int insertSelective(Title record);

    List<Title> selectByCriteriaWithRowbounds(TitleCriteria criteria, RowBounds rowBounds);

    List<Title> selectByCriteria(TitleCriteria criteria);

    Title selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Title record, @Param("criteria") TitleCriteria criteria);

    int updateByCriteria(@Param("record") Title record, @Param("criteria") TitleCriteria criteria);

    int updateByPrimaryKeySelective(Title record);

    int updateByPrimaryKey(Title record);
}