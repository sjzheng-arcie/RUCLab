package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.BbsAttachment;
import edu.ruc.labmgr.domain.BbsAttachmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BbsAttachmentMapper {
    int countByCriteria(BbsAttachmentCriteria criteria);

    int deleteByCriteria(BbsAttachmentCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsAttachment record);

    int insertSelective(BbsAttachment record);

    List<BbsAttachment> selectByCriteriaWithRowbounds(BbsAttachmentCriteria criteria, RowBounds rowBounds);

    List<BbsAttachment> selectByCriteria(BbsAttachmentCriteria criteria);

    BbsAttachment selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") BbsAttachment record, @Param("criteria") BbsAttachmentCriteria criteria);

    int updateByCriteria(@Param("record") BbsAttachment record, @Param("criteria") BbsAttachmentCriteria criteria);

    int updateByPrimaryKeySelective(BbsAttachment record);

    int updateByPrimaryKey(BbsAttachment record);
}