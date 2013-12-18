package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.BbsReply;
import edu.ruc.labmgr.domain.BbsReplyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BbsReplyMapper {
    int countByCriteria(BbsReplyCriteria example);

    int deleteByCriteria(BbsReplyCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsReply record);

    int insertSelective(BbsReply record);

    List<BbsReply> selectByCriteriaWithRowbounds(BbsReplyCriteria example, RowBounds rowBounds);

    List<BbsReply> selectByCriteria(BbsReplyCriteria example);

    BbsReply selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") BbsReply record, @Param("example") BbsReplyCriteria example);

    int updateByCriteria(@Param("record") BbsReply record, @Param("example") BbsReplyCriteria example);

    int updateByPrimaryKeySelective(BbsReply record);

    int updateByPrimaryKey(BbsReply record);
}