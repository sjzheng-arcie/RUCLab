package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.BbsTopic;
import edu.ruc.labmgr.domain.BbsTopicCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BbsTopicMapper {
    int countByCriteria(BbsTopicCriteria criteria);

    int deleteByCriteria(BbsTopicCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsTopic record);

    int insertSelective(BbsTopic record);

    List<BbsTopic> selectByCriteriaWithRowbounds(BbsTopicCriteria criteria, RowBounds rowBounds);

    List<BbsTopic> selectByCriteria(BbsTopicCriteria criteria);

    BbsTopic selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") BbsTopic record, @Param("criteria") BbsTopicCriteria criteria);

    int updateByCriteria(@Param("record") BbsTopic record, @Param("criteria") BbsTopicCriteria criteria);

    int updateByPrimaryKeySelective(BbsTopic record);

    int updateByPrimaryKey(BbsTopic record);
}