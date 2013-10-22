package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Announcement;
import edu.ruc.labmgr.domain.AnnouncementCriteria;
import edu.ruc.labmgr.service.AnnouncementService;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-10-16
 * Time: 下午4:35
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/equipment/jsp/announcement/remind")
public class AnnouncementController {
	@Autowired
	AnnouncementService serviceAnnouncement;


	private int currPage = 0;
	@RequestMapping("/remind")
	public ModelAndView pageList(HttpServletRequest request) {
		currPage = request.getParameter("page") == null   ?
				(currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));
		String tabId=request.getParameter("id");
		AnnouncementCriteria announcementCriteria =  new AnnouncementCriteria();
		AnnouncementCriteria.Criteria criteria = announcementCriteria.createCriteria();

		ObjectListPage<Announcement> pageInfo = serviceAnnouncement.selectListPage(currPage, announcementCriteria);
        System.out.print(pageInfo .getListObject().size());
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");
		mav.addObject("announcementLists", pageInfo.getListObject());
		mav.addObject("page", pageInfo.getPageInfo());
		mav.addObject("tabId", tabId);
		return mav;
	}
	@RequestMapping("/message")
	public ModelAndView showMessage(HttpServletRequest request) {

		currPage = request.getParameter("page") == null   ?
				(currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));

		AnnouncementCriteria announcementCriteria =  new AnnouncementCriteria();
		AnnouncementCriteria.Criteria criteria = announcementCriteria.createCriteria();

		ObjectListPage<Announcement> pageInfo = serviceAnnouncement.selectListPage(currPage, announcementCriteria);
		System.out.print(pageInfo .getListObject().size());
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/message");
		mav.addObject("announcementLists", pageInfo.getListObject());
		mav.addObject("page", pageInfo.getPageInfo());

		return mav;
	}
	@RequestMapping("/addannouncement")
	public ModelAndView addAnnouncement(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/addannouncement");
		return mav;
	}
	@RequestMapping("/sendmessage")
	public ModelAndView sendMessage(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/sendmessage");
		return mav;
	}


	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request) {
		Announcement announcement = initFromRequest(request);
		int result = serviceAnnouncement.insert(announcement);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/addannouncement");
		return mav;
	}
	private Announcement initFromRequest(HttpServletRequest request) {

		Announcement announcement = new Announcement();
		if (!StringUtils.isNullOrEmpty(request.getParameter("id")))
			announcement.setId(Integer.parseInt(request.getParameter("id")));
		announcement.setContent(request.getParameter("content"));
		announcement.setPublisherId(Integer.parseInt(request.getParameter("publisher_id")));
		announcement.setPublishLimit(Integer.parseInt(request.getParameter("limit")));
		announcement.setTitle(request.getParameter("title"));
		announcement.setPublishTime(new Date());
		return announcement;
	}
}
