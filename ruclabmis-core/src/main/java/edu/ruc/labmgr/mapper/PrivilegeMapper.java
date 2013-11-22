package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Privilege;
import edu.ruc.labmgr.domain.PrivilegeCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface PrivilegeMapper {
    int countByCriteria(PrivilegeCriteria criteria);

    int deleteByCriteria(PrivilegeCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Privilege record);

    int insertSelective(Privilege record);

    List<Privilege> selectByCriteriaWithRowbounds(PrivilegeCriteria criteria, RowBounds rowBounds);

    List<Privilege> selectByCriteria(PrivilegeCriteria criteria);

    Privilege selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Privilege record, @Param("criteria") PrivilegeCriteria criteria);

    int updateByCriteria(@Param("record") Privilege record, @Param("criteria") PrivilegeCriteria criteria);

    int updateByPrimaryKeySelective(Privilege record);

    int updateByPrimaryKey(Privilege record);
}