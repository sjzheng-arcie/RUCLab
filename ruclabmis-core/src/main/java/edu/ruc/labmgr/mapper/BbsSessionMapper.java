package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.BbsSession;
import edu.ruc.labmgr.domain.BbsSessionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BbsSessionMapper {
    int countByCriteria(BbsSessionCriteria example);

    int deleteByCriteria(BbsSessionCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsSession record);

    int insertSelective(BbsSession record);

    List<BbsSession> selectByCriteriaWithRowbounds(BbsSessionCriteria example, RowBounds rowBounds);

    List<BbsSession> selectByCriteria(BbsSessionCriteria example);

    BbsSession selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") BbsSession record, @Param("example") BbsSessionCriteria example);

    int updateByCriteria(@Param("record") BbsSession record, @Param("example") BbsSessionCriteria example);

    int updateByPrimaryKeySelective(BbsSession record);

    int updateByPrimaryKey(BbsSession record);
}