package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.RelatedResources;

public interface RelatedResourcesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RelatedResources record);

    int insertSelective(RelatedResources record);

    RelatedResources selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RelatedResources record);

    int updateByPrimaryKey(RelatedResources record);
}