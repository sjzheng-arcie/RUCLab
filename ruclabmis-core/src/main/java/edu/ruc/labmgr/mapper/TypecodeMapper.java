package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Typecode;
import edu.ruc.labmgr.domain.TypecodeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TypecodeMapper {
    int countByCriteria(TypecodeCriteria criteria);

    int deleteByCriteria(TypecodeCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Typecode record);

    int insertSelective(Typecode record);

    List<Typecode> selectByCriteriaWithRowbounds(TypecodeCriteria criteria, RowBounds rowBounds);

    List<Typecode> selectByCriteria(TypecodeCriteria criteria);

    Typecode selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Typecode record, @Param("criteria") TypecodeCriteria criteria);

    int updateByCriteria(@Param("record") Typecode record, @Param("criteria") TypecodeCriteria criteria);

    int updateByPrimaryKeySelective(Typecode record);

    int updateByPrimaryKey(Typecode record);
}