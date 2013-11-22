package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Announcement;
import edu.ruc.labmgr.domain.AnnouncementCriteria;
import edu.ruc.labmgr.mapper.AnnouncementMapper;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-10-16
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */

@SuppressWarnings("ALL")
@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementMapper mapperAnnouncement;

    public ObjectListPage<Announcement> selectListPage(int currentPage, AnnouncementCriteria criteria) {


        ObjectListPage<Announcement> retList = null;
        try {
            String count = SysUtil.getConfigValue("", "6");

            int limit = 16;
            int currentResult = (currentPage - 1) * limit;
            int totalCount = mapperAnnouncement.countByCriteria(criteria);
            int pageCount = (totalCount % limit == 0) ? (totalCount / limit) : (1 + totalCount / limit);

            PageInfo pageInfo = new PageInfo();
            pageInfo.setTotalResult(totalCount);
            pageInfo.setTotalPage(pageCount);
            pageInfo.setCurrentPage(currentPage);

            RowBounds bounds = new RowBounds(currentResult, limit);
            List<Announcement> announcementList = mapperAnnouncement.selectByCriteriaWithRowbounds(criteria, bounds);

            retList = new ObjectListPage(pageInfo, announcementList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retList;
    }

    public int insert(Announcement announcement) {
        int result = 0;
        try {
            result = mapperAnnouncement.insert(announcement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Announcement getAnnouncementById(int announcementId) {
        Announcement announcement = new Announcement();
        try {
            announcement = mapperAnnouncement.selectByPrimaryKey(announcementId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return announcement;
    }

    public List<Announcement> getAnnouncementListByCriteria(AnnouncementCriteria announcementCriteria) {
        List<Announcement> announcementList = null;
        try {
            RowBounds bounds = new RowBounds(0, 16);
            announcementList = mapperAnnouncement.selectByCriteriaWithRowbounds(announcementCriteria, bounds);
            //announcementList=mapperAnnouncement.selectByCriteria(announcementCriteria);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return announcementList;
    }

    public List<Announcement> getAnnouncementListByCriteriaForWelcome(AnnouncementCriteria announcementCriteria) {
        List<Announcement> announcementList = null;
        try {
            RowBounds bounds = new RowBounds(0, 6);
            announcementList = mapperAnnouncement.selectByCriteriaWithRowbounds(announcementCriteria, bounds);
            //announcementList=mapperAnnouncement.selectByCriteria(announcementCriteria);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return announcementList;
    }

    public PageInfo<Announcement> selectListPage(AnnouncementCriteria criteria, int pageNum) {
        int totalCount = mapperAnnouncement.countByCriteria(criteria);
        PageInfo<Announcement> page = new PageInfo<>(totalCount, -1, pageNum);
        List<Announcement> data = mapperAnnouncement.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }
}
