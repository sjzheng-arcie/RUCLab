package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.BbsAttachment;
import edu.ruc.labmgr.domain.BbsAttachmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BbsAttachmentMapper {
    int countByCriteria(BbsAttachmentCriteria example);

    int deleteByCriteria(BbsAttachmentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsAttachment record);

    int insertSelective(BbsAttachment record);

    List<BbsAttachment> selectByCriteriaWithRowbounds(BbsAttachmentCriteria example, RowBounds rowBounds);

    List<BbsAttachment> selectByCriteria(BbsAttachmentCriteria example);

    BbsAttachment selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") BbsAttachment record, @Param("example") BbsAttachmentCriteria example);

    int updateByCriteria(@Param("record") BbsAttachment record, @Param("example") BbsAttachmentCriteria example);

    int updateByPrimaryKeySelective(BbsAttachment record);

    int updateByPrimaryKey(BbsAttachment record);
}