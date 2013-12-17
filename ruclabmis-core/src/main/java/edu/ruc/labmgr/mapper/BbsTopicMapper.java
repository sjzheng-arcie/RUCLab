package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.BbsTopic;
import edu.ruc.labmgr.domain.BbsTopicCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BbsTopicMapper {
    int countByCriteria(BbsTopicCriteria example);

    int deleteByCriteria(BbsTopicCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsTopic record);

    int insertSelective(BbsTopic record);

    List<BbsTopic> selectByCriteriaWithRowbounds(BbsTopicCriteria example, RowBounds rowBounds);

    List<BbsTopic> selectByCriteria(BbsTopicCriteria example);

    BbsTopic selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") BbsTopic record, @Param("example") BbsTopicCriteria example);

    int updateByCriteria(@Param("record") BbsTopic record, @Param("example") BbsTopicCriteria example);

    int updateByPrimaryKeySelective(BbsTopic record);

    int updateByPrimaryKey(BbsTopic record);
}