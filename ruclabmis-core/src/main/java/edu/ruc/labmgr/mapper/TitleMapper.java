package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Title;

public interface TitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Title record);

    int insertSelective(Title record);

    Title selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Title record);

    int updateByPrimaryKey(Title record);
}