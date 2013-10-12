package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.UserRoleCriteria;
import edu.ruc.labmgr.domain.UserRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserRoleMapper {
    int countByCriteria(UserRoleCriteria criteria);

    int deleteByCriteria(UserRoleCriteria criteria);

    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    List<UserRoleKey> selectByCriteriaWithRowbounds(UserRoleCriteria criteria, RowBounds rowBounds);

    List<UserRoleKey> selectByCriteria(UserRoleCriteria criteria);

    int updateByCriteriaSelective(@Param("record") UserRoleKey record, @Param("criteria") UserRoleCriteria criteria);

    int updateByCriteria(@Param("record") UserRoleKey record, @Param("criteria") UserRoleCriteria criteria);
}