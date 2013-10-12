package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.domain.ClassifCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClassifMapper {
    int countByCriteria(ClassifCriteria criteria);

    int deleteByCriteria(ClassifCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Classif record);

    int insertSelective(Classif record);

    List<Classif> selectByCriteriaWithRowbounds(ClassifCriteria criteria, RowBounds rowBounds);

    List<Classif> selectByCriteria(ClassifCriteria criteria);

    Classif selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Classif record, @Param("criteria") ClassifCriteria criteria);

    int updateByCriteria(@Param("record") Classif record, @Param("criteria") ClassifCriteria criteria);

    int updateByPrimaryKeySelective(Classif record);

    int updateByPrimaryKey(Classif record);
}