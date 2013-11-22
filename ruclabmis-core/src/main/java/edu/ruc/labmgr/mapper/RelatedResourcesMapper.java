package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.RelatedResources;
import edu.ruc.labmgr.domain.RelatedResourcesCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface RelatedResourcesMapper {
    int countByCriteria(RelatedResourcesCriteria criteria);

    int deleteByCriteria(RelatedResourcesCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(RelatedResources record);

    int insertSelective(RelatedResources record);

    List<RelatedResources> selectByCriteriaWithRowbounds(RelatedResourcesCriteria criteria, RowBounds rowBounds);

    List<RelatedResources> selectByCriteria(RelatedResourcesCriteria criteria);

    RelatedResources selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") RelatedResources record, @Param("criteria") RelatedResourcesCriteria criteria);

    int updateByCriteria(@Param("record") RelatedResources record, @Param("criteria") RelatedResourcesCriteria criteria);

    int updateByPrimaryKeySelective(RelatedResources record);

    int updateByPrimaryKey(RelatedResources record);
}