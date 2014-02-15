package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Announcement;
import edu.ruc.labmgr.domain.AnnouncementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AnnouncementMapper {
    int countByCriteria(AnnouncementCriteria criteria);

    int deleteByCriteria(AnnouncementCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    List<Announcement> selectByCriteriaWithRowbounds(AnnouncementCriteria criteria, RowBounds rowBounds);

    List<Announcement> selectByCriteria(AnnouncementCriteria criteria);

    Announcement selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Announcement record, @Param("criteria") AnnouncementCriteria criteria);

    int updateByCriteria(@Param("record") Announcement record, @Param("criteria") AnnouncementCriteria criteria);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKey(Announcement record);
}