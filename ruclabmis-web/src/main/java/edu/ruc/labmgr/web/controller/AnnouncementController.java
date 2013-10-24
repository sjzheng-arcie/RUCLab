package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.AnnouncementService;
import edu.ruc.labmgr.service.MessageService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import org.apache.shiro.SecurityUtils;
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
	@Autowired
	MessageService messageService;
	@Autowired
	private UserService userService;




	private int currPage = 0;
	@RequestMapping("/remind")
	public ModelAndView pageList(HttpServletRequest request) {
		currPage = request.getParameter("page") == null   ?
				(currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));
		String tabId=request.getParameter("id");

		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");

		mav.addObject("tabId", tabId);
		return mav;
	}
	@RequestMapping("/message")
	public ModelAndView showMessage(HttpServletRequest request) {
		User user = new User();
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);

		currPage = request.getParameter("page") == null   ?
				(currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));

		MessageCriteria messageCriteria=  new MessageCriteria();
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(user.getId());

		ObjectListPage<Message> pageInfo = messageService.selectListPage(currPage,messageCriteria );
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/message");
		mav.addObject("messageLists", pageInfo.getListObject());
		mav.addObject("page", pageInfo.getPageInfo());

		return mav;
	}
	@RequestMapping("/announcement")
	public ModelAndView showAnnouncement(HttpServletRequest request) {
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		User user = new User();
		user=userService.getUserByLoginSn(loginName);
		currPage = request.getParameter("page") == null   ?
				(currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));

		AnnouncementCriteria announcementCriteria =  new AnnouncementCriteria();
		AnnouncementCriteria.Criteria criteria = announcementCriteria.createCriteria();

		criteria.andPublishLimitEqualTo(0);
		announcementCriteria.or(criteria);
		ObjectListPage<Announcement> pageInfo = serviceAnnouncement.selectListPage(currPage, announcementCriteria);
		System.out.print(pageInfo .getListObject().size());
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/announcement");
		mav.addObject("announcementLists", pageInfo.getListObject());
		mav.addObject("page", pageInfo.getPageInfo());

		return mav;
	}
	@RequestMapping("/toaddannouncement")
	public ModelAndView toaddAnnouncement(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/addannouncement");
		return mav;
	}
	@RequestMapping("/sendmessage")
	public ModelAndView sendMessage(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/sendmessage");
		return mav;
	}


	@RequestMapping("/addAnnouncement")
	public ModelAndView addAnnouncement(HttpServletRequest request) {
		Announcement announcement = initFromRequest(request);
		int result = serviceAnnouncement.insert(announcement);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");
		return mav;
	}
	@RequestMapping("/addMessage")
	public ModelAndView addMessage(HttpServletRequest request) {
		Message message= insertMessageIntoDB(request);
		int result = messageService.insert(message);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");
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
	private Message insertMessageIntoDB(HttpServletRequest request) {

		User user = new User();
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		User receiverUser = new User();
		receiverUser=userService.getUserByLoginSn(request.getParameter("receiver"));

		Message message= new Message();
		if (!StringUtils.isNullOrEmpty(request.getParameter("id")))
			message.setId(Integer.parseInt(request.getParameter("id")));
		message.setContent(request.getParameter("content"));
		message.setIfread(Boolean.parseBoolean(request.getParameter("ifRead")));
		message.setReceiverId(receiverUser.getId());
		message.setSenderId(user.getId());
		message.setSendtime(new Date());
		return message;
	}
}
