package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.BbsSession;
import edu.ruc.labmgr.domain.BbsSessionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BbsSessionMapper {
    int countByCriteria(BbsSessionCriteria criteria);

    int deleteByCriteria(BbsSessionCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsSession record);

    int insertSelective(BbsSession record);

    List<BbsSession> selectByCriteriaWithRowbounds(BbsSessionCriteria criteria, RowBounds rowBounds);

    List<BbsSession> selectByCriteria(BbsSessionCriteria criteria);

    BbsSession selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") BbsSession record, @Param("criteria") BbsSessionCriteria criteria);

    int updateByCriteria(@Param("record") BbsSession record, @Param("criteria") BbsSessionCriteria criteria);

    int updateByPrimaryKeySelective(BbsSession record);

    int updateByPrimaryKey(BbsSession record);
}