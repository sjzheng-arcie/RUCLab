package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Laboratory;
import edu.ruc.labmgr.domain.LaboratoryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LaboratoryMapper {
    int countByExample(LaboratoryCriteria example);

    int deleteByExample(LaboratoryCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Laboratory record);

    int insertSelective(Laboratory record);

    List<Laboratory> selectByExampleWithRowbounds(LaboratoryCriteria example, RowBounds rowBounds);

    List<Laboratory> selectByExample(LaboratoryCriteria example);

    Laboratory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Laboratory record, @Param("example") LaboratoryCriteria example);

    int updateByExample(@Param("record") Laboratory record, @Param("example") LaboratoryCriteria example);

    int updateByPrimaryKeySelective(Laboratory record);

    int updateByPrimaryKey(Laboratory record);
}