package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Announcement;
import edu.ruc.labmgr.domain.AnnouncementCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface AnnouncementMapper {
    int countByCriteria(AnnouncementCriteria Criteria);

    int deleteByCriteria(AnnouncementCriteria Criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    List<Announcement> selectByCriteriaWithRowbounds(AnnouncementCriteria Criteria, RowBounds rowBounds);

    List<Announcement> selectByCriteria(AnnouncementCriteria Criteria);

    Announcement selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Announcement record, @Param("Criteria") AnnouncementCriteria Criteria);

    int updateByCriteria(@Param("record") Announcement record, @Param("Criteria") AnnouncementCriteria Criteria);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKey(Announcement record);
}