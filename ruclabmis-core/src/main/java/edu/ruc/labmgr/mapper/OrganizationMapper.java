package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Organization;
import edu.ruc.labmgr.domain.OrganizationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OrganizationMapper {
    int countByCriteria(OrganizationCriteria criteria);

    int deleteByCriteria(OrganizationCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Organization record);

    int insertSelective(Organization record);

    List<Organization> selectByCriteriaWithRowbounds(OrganizationCriteria criteria, RowBounds rowBounds);

    List<Organization> selectByCriteria(OrganizationCriteria criteria);

    Organization selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Organization record, @Param("criteria") OrganizationCriteria criteria);

    int updateByCriteria(@Param("record") Organization record, @Param("criteria") OrganizationCriteria criteria);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}