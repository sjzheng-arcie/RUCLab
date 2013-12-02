package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Announcement;
import edu.ruc.labmgr.domain.AnnouncementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AnnouncementMapper {
    int countByCriteria(AnnouncementCriteria example);

    int deleteByExample(AnnouncementCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    List<Announcement> selectByCriteriaWithRowbounds(AnnouncementCriteria example, RowBounds rowBounds);

    List<Announcement> selectByExample(AnnouncementCriteria example);

    Announcement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Announcement record, @Param("example") AnnouncementCriteria example);

    int updateByExample(@Param("record") Announcement record, @Param("example") AnnouncementCriteria example);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKey(Announcement record);
}