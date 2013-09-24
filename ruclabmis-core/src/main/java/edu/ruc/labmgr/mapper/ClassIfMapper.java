package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Classif;

import java.util.List;

public interface ClassifMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classif record);

    int insertSelective(Classif record);

    Classif selectByPrimaryKey(Integer id);

    List<Classif> selectByParentKey(Integer parentid);

    int updateByPrimaryKeySelective(Classif record);

    int updateByPrimaryKey(Classif record);
}