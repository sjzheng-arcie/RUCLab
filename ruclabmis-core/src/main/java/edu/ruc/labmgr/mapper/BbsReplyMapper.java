package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.BbsReply;
import edu.ruc.labmgr.domain.BbsReplyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BbsReplyMapper {
    int countByCriteria(BbsReplyCriteria criteria);

    int deleteByCriteria(BbsReplyCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsReply record);

    int insertSelective(BbsReply record);

    List<BbsReply> selectByCriteriaWithRowbounds(BbsReplyCriteria criteria, RowBounds rowBounds);

    List<BbsReply> selectByCriteria(BbsReplyCriteria criteria);

    BbsReply selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") BbsReply record, @Param("criteria") BbsReplyCriteria criteria);

    int updateByCriteria(@Param("record") BbsReply record, @Param("criteria") BbsReplyCriteria criteria);

    int updateByPrimaryKeySelective(BbsReply record);

    int updateByPrimaryKey(BbsReply record);
}