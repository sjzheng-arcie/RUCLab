package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ArrangementDeskCriteria;
import edu.ruc.labmgr.domain.ArrangementDeskKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArrangementDeskMapper {
    int countByCriteria(ArrangementDeskCriteria criteria);

    int deleteByCriteria(ArrangementDeskCriteria criteria);

    int deleteByPrimaryKey(ArrangementDeskKey key);

    int insert(ArrangementDeskKey record);

    int insertSelective(ArrangementDeskKey record);

    List<ArrangementDeskKey> selectByCriteriaWithRowbounds(ArrangementDeskCriteria criteria, RowBounds rowBounds);

    List<ArrangementDeskKey> selectByCriteria(ArrangementDeskCriteria criteria);

    int updateByCriteriaSelective(@Param("record") ArrangementDeskKey record, @Param("criteria") ArrangementDeskCriteria criteria);

    int updateByCriteria(@Param("record") ArrangementDeskKey record, @Param("criteria") ArrangementDeskCriteria criteria);
}