package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Laboratory;
import edu.ruc.labmgr.domain.LaboratoryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LaboratoryMapper {
    int countByCriteria(LaboratoryCriteria criteria);

    int deleteByCriteria(LaboratoryCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Laboratory record);

    int insertSelective(Laboratory record);

    List<Laboratory> selectByCriteriaWithRowbounds(LaboratoryCriteria criteria, RowBounds rowBounds);

    List<Laboratory> selectByCriteria(LaboratoryCriteria criteria);

    Laboratory selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Laboratory record, @Param("criteria") LaboratoryCriteria criteria);

    int updateByCriteria(@Param("record") Laboratory record, @Param("criteria") LaboratoryCriteria criteria);

    int updateByPrimaryKeySelective(Laboratory record);

    int updateByPrimaryKey(Laboratory record);
}