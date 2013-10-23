package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ViewStore;
import edu.ruc.labmgr.domain.ViewStoreCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ViewStoreMapper {
    int countByCriteria(ViewStoreCriteria criteria);

    int deleteByCriteria(ViewStoreCriteria criteria);

    int insert(ViewStore record);

    int insertSelective(ViewStore record);

    List<ViewStore> selectByCriteriaWithRowbounds(ViewStoreCriteria criteria, RowBounds rowBounds);

    List<ViewStore> selectByCriteria(ViewStoreCriteria criteria);

    int updateByCriteriaSelective(@Param("record") ViewStore record, @Param("criteria") ViewStoreCriteria criteria);

    int updateByCriteria(@Param("record") ViewStore record, @Param("criteria") ViewStoreCriteria criteria);
}