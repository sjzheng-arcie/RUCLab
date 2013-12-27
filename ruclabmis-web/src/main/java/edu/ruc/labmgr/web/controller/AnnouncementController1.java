package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.AnnouncementService;
import edu.ruc.labmgr.service.MessageService;
import edu.ruc.labmgr.service.TeacherService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/equipment/jsp/announcementd/remind")
public class AnnouncementController1 {
	@Autowired
	AnnouncementService serviceAnnouncement;
	@Autowired
	MessageService messageService;
	@Autowired
	private TeacherService userService;

	private int currPage = 0;

	@RequestMapping("/remind")
	public ModelAndView pageList(HttpServletRequest request) {
		currPage = request.getParameter("page") == null ?
				(currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));
		String tabId = request.getParameter("id");

		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");

		mav.addObject("tabId", tabId);
		return mav;
	}

	@RequestMapping("/message")
	public ModelAndView showMessage(HttpServletRequest request) {
		int currentUserId = userService.getCurrentUserId();
		currPage = request.getParameter("page") == null ?
				(currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));

		String fatherPage = request.getParameter("fatherPage");
		MessageCriteria messageCriteria = new MessageCriteria();
		messageCriteria.setOrderByClause(" sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(currentUserId);


		PageInfo<Message> pageInfo = messageService.selectListPage(messageCriteria, currPage);

		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/message");
		//mav.addObject("messageLists", pageInfo.getListObject());
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("fatherPage", fatherPage);
		return mav;
	}

	@RequestMapping("/unreadmessage")
	public ModelAndView showUnreadMessage(HttpServletRequest request) {
		int userId = userService.getCurrentUserId();

		currPage = request.getParameter("page") == null ?
				(currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));
		String fatherPage = request.getParameter("fatherPage");
		MessageCriteria messageCriteria = new MessageCriteria();
		messageCriteria.setOrderByClause(" sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(userId);
		criteria.andIfreadEqualTo(false);

		PageInfo<Message> pageInfo = messageService.selectListPage(messageCriteria, currPage);
		if (pageInfo.getTotalPage() < currPage) {
			pageInfo = messageService.selectListPage(messageCriteria, currPage - 1);
		}
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/message");
		//mav.addObject("messageLists", pageInfo.getListObject());
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("fatherPage", fatherPage);
		return mav;
	}

	@RequestMapping("/readmessage")
	public ModelAndView showReadMessage(HttpServletRequest request) {
		int currentUserId = userService.getCurrentUserId();
		;
		currPage = request.getParameter("page") == null ?
				(currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));
		String fatherPage = request.getParameter("fatherPage");
		MessageCriteria messageCriteria = new MessageCriteria();
		messageCriteria.setOrderByClause(" sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(currentUserId);
		criteria.andIfreadEqualTo(true);

		PageInfo<Message> pageInfo = messageService.selectListPage(messageCriteria, currPage);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/message");
		//mav.addObject("messageLists", pageInfo.getListObject());
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("fatherPage", fatherPage);
		return mav;
	}

	@RequestMapping("/replyMessage")
	public ModelAndView replyMessage(HttpServletRequest request) {
		String replySn = request.getParameter("replyFlag");
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");
		mav.addObject("tabId", 3);
		mav.addObject("replySn", replySn);

		return mav;
	}

	@RequestMapping("/mysendmessage")
	public ModelAndView showMySendMessage(HttpServletRequest request) {
		int currentUserId = userService.getCurrentUserId();

		currPage = request.getParameter("page") == null ?
				(currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));
		String fatherPage = request.getParameter("fatherPage");
		MessageCriteria messageCriteria = new MessageCriteria();
		messageCriteria.setOrderByClause(" sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andSenderIdEqualTo(currentUserId);
		criteria.andIfreadEqualTo(true);

		PageInfo<Message> pageInfo = messageService.selectListPage(messageCriteria, currPage);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/message");
		//mav.addObject("messageLists", pageInfo);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("mode", "mode");
		mav.addObject("fatherPage", fatherPage);
		return mav;
	}

	@RequestMapping("/announcement")
	public ModelAndView showAnnouncement(HttpServletRequest request) {
		currPage = request.getParameter("page") == null ?
				(currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));

		AnnouncementCriteria announcementCriteria = new AnnouncementCriteria();
		AnnouncementCriteria.Criteria criteria = announcementCriteria.createCriteria();

		announcementCriteria.setOrderByClause(" publish_time desc");
		PageInfo<Announcement> pageInfo = serviceAnnouncement.selectListPage(announcementCriteria, currPage);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/announcement");
		mav.addObject("pageInfo", pageInfo);

		return mav;
	}

	@RequestMapping("/toaddannouncement")
	public ModelAndView toaddAnnouncement(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/addannouncement");
		return mav;
	}

	@RequestMapping("/sendmessage")
	public ModelAndView sendMessage(HttpServletRequest request) {
		String replySn = request.getParameter("replyFlag");
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/sendmessage");
		if (replySn != null && replySn != "")
			mav.addObject("replySn", replySn);
		List<Teacher> teacherList = userService.getAllTeacherList();
		mav.addObject("teacherList", teacherList);
		return mav;
	}


	@RequestMapping("/addAnnouncement")
	public ModelAndView addAnnouncement(HttpServletRequest request) {
		Announcement announcement = initFromRequest(request);
		int result = serviceAnnouncement.insert(announcement);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");
		mav.addObject("tabId", 0);
		return mav;
	}

	@RequestMapping("/announcementDetail")
	public ModelAndView getAnnouncement(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("announcementDetailId"));
		Announcement announcement = serviceAnnouncement.getAnnouncementById(id);

		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/announcementdetail");
		mav.addObject("announcementDetailFlag", announcement);
		return mav;
	}

	@RequestMapping("/messageDetail")
	public ModelAndView getMessage(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("messageDetailId"));
		currPage = request.getParameter("page") == null ?
				(currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));
		String fatherPage = request.getParameter("fatherPage");
		Message message = messageService.selectById(id);
		message.setIfread(true);
		messageService.updateByMessage(message);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/messagedetail");
		mav.addObject("messageDetailFlag", message);
		mav.addObject("fatherPage", fatherPage);
		mav.addObject("page", currPage);
		return mav;
	}

	@RequestMapping("/addMessage")
	public ModelAndView addMessage(HttpServletRequest request) {
		Message message = insertMessageIntoDB(request);
		int result = messageService.insert(message);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");
		mav.addObject("tabId", 1);
		return mav;
	}

	@RequestMapping("/deleteMessage")
	public ModelAndView deleteMessage(HttpServletRequest request) {
		int messageId = Integer.parseInt(request.getParameter("deleteMessageId"));
		messageService.deleteById(messageId);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");
		mav.addObject("tabId", 1);
		return mav;
	}

	private Announcement initFromRequest(HttpServletRequest request) {
		int currentUserId = userService.getCurrentUserId();
		Announcement announcement = new Announcement();
		announcement.setContent(request.getParameter("content"));
		announcement.setPublisherId(currentUserId);
		if (request.getParameter("limit") != null) {
			announcement.setPublishLimit(Integer.parseInt(request.getParameter("limit")));
		} else {
			announcement.setPublishLimit(0);
		}
		announcement.setTitle(request.getParameter("title"));
		announcement.setPublishTime(new Date());
		return announcement;
	}

	private Message insertMessageIntoDB(HttpServletRequest request) {
		int currentUserId = userService.getCurrentUserId();

		int targetId = Integer.parseInt(request.getParameter("target"));

		Message message = new Message();
		if (!StringUtils.isNullOrEmpty(request.getParameter("id")))
			message.setId(Integer.parseInt(request.getParameter("id")));
		message.setContent(request.getParameter("content"));
		message.setIfread(false);
		message.setReceiverId(targetId);
		message.setSenderId(currentUserId);
		message.setSendtime(new Date());
		return message;
	}

	public ModelAndView showUnreadMessage() {
		User currentUser = userService.getCurrentUser();

		MessageCriteria messageCriteria = new MessageCriteria();
		messageCriteria.setOrderByClause("sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(currentUser.getId());
		criteria.andIfreadEqualTo(false);
		int count = messageService.getCount(messageCriteria);
		ModelAndView mav = new ModelAndView("/equipment/top");
		mav.addObject("unreadCount", count);
		mav.addObject("user", currentUser);
		return mav;
	}


}