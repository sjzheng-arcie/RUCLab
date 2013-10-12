package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Role;
import edu.ruc.labmgr.domain.RoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RoleMapper {
    int countByCriteria(RoleCriteria criteria);

    int deleteByCriteria(RoleCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByCriteriaWithRowbounds(RoleCriteria criteria, RowBounds rowBounds);

    List<Role> selectByCriteria(RoleCriteria criteria);

    Role selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Role record, @Param("criteria") RoleCriteria criteria);

    int updateByCriteria(@Param("record") Role record, @Param("criteria") RoleCriteria criteria);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}