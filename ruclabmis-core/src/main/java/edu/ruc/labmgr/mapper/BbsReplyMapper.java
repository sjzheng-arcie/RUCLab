package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.BbsReply;
import edu.ruc.labmgr.domain.BbsReplyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BbsReplyMapper {
    int countByExample(BbsReplyCriteria example);

    int deleteByExample(BbsReplyCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsReply record);

    int insertSelective(BbsReply record);

    List<BbsReply> selectByExampleWithRowbounds(BbsReplyCriteria example, RowBounds rowBounds);

    List<BbsReply> selectByExample(BbsReplyCriteria example);

    BbsReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BbsReply record, @Param("example") BbsReplyCriteria example);

    int updateByExample(@Param("record") BbsReply record, @Param("example") BbsReplyCriteria example);

    int updateByPrimaryKeySelective(BbsReply record);

    int updateByPrimaryKey(BbsReply record);
}