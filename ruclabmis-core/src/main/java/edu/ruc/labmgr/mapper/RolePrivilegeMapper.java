package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.RolePrivilegeCriteria;
import edu.ruc.labmgr.domain.RolePrivilegeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RolePrivilegeMapper {
    int countByCriteria(RolePrivilegeCriteria criteria);

    int deleteByCriteria(RolePrivilegeCriteria criteria);

    int deleteByPrimaryKey(RolePrivilegeKey key);

    int insert(RolePrivilegeKey record);

    int insertSelective(RolePrivilegeKey record);

    List<RolePrivilegeKey> selectByCriteriaWithRowbounds(RolePrivilegeCriteria criteria, RowBounds rowBounds);

    List<RolePrivilegeKey> selectByCriteria(RolePrivilegeCriteria criteria);

    int updateByCriteriaSelective(@Param("record") RolePrivilegeKey record, @Param("criteria") RolePrivilegeCriteria criteria);

    int updateByCriteria(@Param("record") RolePrivilegeKey record, @Param("criteria") RolePrivilegeCriteria criteria);
}