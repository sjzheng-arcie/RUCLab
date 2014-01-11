package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Announcement;
import edu.ruc.labmgr.domain.AnnouncementCriteria;
import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.mapper.AnnouncementMapper;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
	@Autowired
	private CurriculumService curriculumService;
	@Autowired
	private  CurriculumClassService curriculumClassService;

    public ObjectListPage<Announcement> selectListPage(int currentPage, AnnouncementCriteria criteria,
													   Types.Role role,int uid,boolean isLaborEquip) {


        ObjectListPage<Announcement> retList = null;

        try {

			if (isLaborEquip){
				List<Integer> limits = new ArrayList<>();

				limits =curriculumClassService.getPrivateCurricumClassIds(uid,role);
				if(role.equals(Types.Role.ADMIN)||role.equals(Types.Role.LAB_ADMIN)||role.equals(Types.Role.TEACHER)){
					limits.add(-1);
				}
				limits.add(0);

				criteria.or().andPublishLimitIn(limits);

			}else{
				criteria.or().andPublishLimitEqualTo(0);
			}
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

	public int update(Announcement announcement) {
		int result = 0;
		try {
			result = mapperAnnouncement.updateByPrimaryKey(announcement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public void deleteAnnouncementById(int id){
		mapperAnnouncement.deleteByPrimaryKey(id);
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
	/**
	 *
	 * @param isLaborEquip false:设备 true: 实验室
	 * @return
	 */
    public List<Announcement> getAnnouncementListByCriteriaForWelcome(AnnouncementCriteria announcementCriteria,boolean isLaborEquip) {
        List<Announcement> announcementList = null;
        try {
            RowBounds bounds = new RowBounds(0, 6);
			announcementCriteria.or().andSystemEqualTo(isLaborEquip);
            announcementList = mapperAnnouncement.selectByCriteriaWithRowbounds(announcementCriteria, bounds);
            //announcementList=mapperAnnouncement.selectByCriteria(announcementCriteria);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return announcementList;
    }
	/**
	 *
	 * @param isLaborEquip false:设备 true: 实验室
	 * @return
	 */
	public List<Announcement> getAnnounceListByUserForWelcome(AnnouncementCriteria announcementCriteria,
											Types.Role role,int uid,boolean isLaborEquip) {
		List<Announcement> announcementList = null;
		try {
			RowBounds bounds = new RowBounds(0, 6);
			AnnouncementCriteria.Criteria c = announcementCriteria.or();
			c.andSystemEqualTo(isLaborEquip);
			if (isLaborEquip){
				List<Integer> limits = new ArrayList<>();

				limits =curriculumClassService.getPrivateCurricumClassIds(uid,role);
				if(role.equals(Types.Role.ADMIN)||role.equals(Types.Role.LAB_ADMIN)||role.equals(Types.Role.TEACHER)){
					limits.add(-1);
				}
				limits.add(0);

				c.andPublishLimitIn(limits);
			}else
				c.andPublishLimitEqualTo(0);

			announcementList = mapperAnnouncement.selectByCriteriaWithRowbounds(announcementCriteria, bounds);


			//announcementList=mapperAnnouncement.selectByCriteria(announcementCriteria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return announcementList;
	}

    public PageInfo<Announcement> selectListPage(AnnouncementCriteria criteria, int pageNum,
												 Types.Role role,int uid,boolean isLaborEquip) {
		AnnouncementCriteria.Criteria c = criteria.or();
		c.andSystemEqualTo(isLaborEquip);
		if (isLaborEquip){
			List<Integer> limits = new ArrayList<>();

			limits =curriculumClassService.getPrivateCurricumClassIds(uid,role);
			if(role.equals(Types.Role.ADMIN)||role.equals(Types.Role.LAB_ADMIN)||role.equals(Types.Role.TEACHER)){
				limits.add(-1);
			}
			limits.add(0);

			c.andPublishLimitIn(limits);
		}else{
			criteria.or().andPublishLimitEqualTo(0);
		}

        int totalCount = mapperAnnouncement.countByCriteria(criteria);
        PageInfo<Announcement> page = new PageInfo<>(totalCount, -1, pageNum);
        List<Announcement> data = mapperAnnouncement.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }
}
