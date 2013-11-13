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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

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
		String fatherPage=request.getParameter("fatherPage");
		MessageCriteria messageCriteria=  new MessageCriteria();
		messageCriteria.setOrderByClause(" sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(user.getId());


		ObjectListPage<Message> pageInfo = messageService.selectListPage(currPage,messageCriteria );
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/message");
		mav.addObject("messageLists", pageInfo.getListObject());
		mav.addObject("page", pageInfo.getPageInfo());
		mav.addObject("fatherPage", fatherPage);
		return mav;
	}
	@RequestMapping("/unreadmessage")
	public ModelAndView showUnreadMessage(HttpServletRequest request) {
		User user = new User();
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		currPage = request.getParameter("page") == null   ?
				(currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));
		String fatherPage=request.getParameter("fatherPage");
		MessageCriteria messageCriteria=  new MessageCriteria();
		messageCriteria.setOrderByClause(" sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(user.getId());
		criteria.andIfreadEqualTo(false);

		ObjectListPage<Message> pageInfo = messageService.selectListPage(currPage,messageCriteria );
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/message");
		mav.addObject("messageLists", pageInfo.getListObject());
		mav.addObject("page", pageInfo.getPageInfo());
		mav.addObject("fatherPage", fatherPage);
		return mav;
	}

	@RequestMapping("/readmessage")
	public ModelAndView showReadMessage(HttpServletRequest request) {
		User user = new User();
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		currPage = request.getParameter("page") == null   ?
				(currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));
		String fatherPage=request.getParameter("fatherPage");
		MessageCriteria messageCriteria=  new MessageCriteria();
		messageCriteria.setOrderByClause(" sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(user.getId());
		criteria.andIfreadEqualTo(true);

		ObjectListPage<Message> pageInfo = messageService.selectListPage(currPage,messageCriteria );
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/message");
		mav.addObject("messageLists", pageInfo.getListObject());
		mav.addObject("page", pageInfo.getPageInfo());
		mav.addObject("fatherPage", fatherPage);
		return mav;
	}
	@RequestMapping("/replyMessage")
	public ModelAndView replyMessage(HttpServletRequest request) {
		String replySn = request.getParameter("replyFlag");
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");
		mav.addObject("tabId",3);
		mav.addObject("replySn",replySn);

		return mav;
	}
	@RequestMapping("/mysendmessage")
	public ModelAndView showMySendMessage(HttpServletRequest request) {
		User user = new User();
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		currPage = request.getParameter("page") == null   ?
				(currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));
		String fatherPage=request.getParameter("fatherPage");
		MessageCriteria messageCriteria=  new MessageCriteria();
		messageCriteria.setOrderByClause(" sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andSenderIdEqualTo(user.getId());
		criteria.andIfreadEqualTo(true);

		ObjectListPage<Message> pageInfo = messageService.selectListPage(currPage,messageCriteria );
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/message");
		mav.addObject("messageLists", pageInfo.getListObject());
		mav.addObject("page", pageInfo.getPageInfo());
		mav.addObject("mode", "mode");
		mav.addObject("fatherPage", fatherPage);
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

		//criteria.andPublishLimitEqualTo(0);

		announcementCriteria.setOrderByClause(" publish_time desc");
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

		String replySn=request.getParameter("replyFlag");
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/sendmessage");
		if(replySn!=null&&replySn!="")
			mav.addObject("replySn",replySn);
		return mav;
	}


	@RequestMapping("/addAnnouncement")
	public ModelAndView addAnnouncement(HttpServletRequest request) {
		Announcement announcement = initFromRequest(request);
		int result = serviceAnnouncement.insert(announcement);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");
		mav.addObject("tabId",0);
		return mav;
	}
	@RequestMapping("/announcementDetail")
	public ModelAndView getAnnouncement(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("announcementDetailId"));
		Announcement announcement = serviceAnnouncement.getAnnouncementById(id);

		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/announcementdetail");
		mav.addObject("announcementDetailFlag",announcement);
		return mav;
	}
	@RequestMapping("/messageDetail")
	public ModelAndView getMessage(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("messageDetailId"));
		String fatherPage=request.getParameter("fatherPage");
		Message message= messageService.selectById(id);
		message.setIfread(true);
		messageService.updateByMessage(message);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/messagedetail");
		mav.addObject("messageDetailFlag",message);
		mav.addObject("fatherPage",fatherPage);
		return mav;
	}
	@RequestMapping("/addMessage")
	public ModelAndView addMessage(HttpServletRequest request) {
		Message message= insertMessageIntoDB(request);
		int result = messageService.insert(message);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");
		mav.addObject("tabId",1);
		return mav;
	}
	@RequestMapping("/deleteMessage")
	public ModelAndView deleteMessage(HttpServletRequest request) {
		int messageId = Integer.parseInt(request.getParameter("deleteMessageId"));
		messageService.deleteById(messageId);
		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/remind");
		mav.addObject("tabId",1);
		return mav;
	}
	private Announcement initFromRequest(HttpServletRequest request) {

		User user = new User();
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		Announcement announcement = new Announcement();
		announcement.setContent(request.getParameter("content"));
		announcement.setPublisherId(user.getId());
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
		receiverUser=userService.getUserByLoginSn(request.getParameter("param"));

		Message message= new Message();
		if (!StringUtils.isNullOrEmpty(request.getParameter("id")))
			message.setId(Integer.parseInt(request.getParameter("id")));
		message.setContent(request.getParameter("content"));
		message.setIfread(false);
		message.setReceiverId(receiverUser.getId());
		message.setSenderId(user.getId());
		message.setSendtime(new Date());
		return message;
	}



	@RequestMapping(value="/getUserSno",produces = "application/json")
	public @ResponseBody List<User> doRegister(
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{



		String param=request.getParameter("param");
		List<User> userList = null;
		UserCriteria userCriteria= new UserCriteria();
		UserCriteria.Criteria criteria= userCriteria.createCriteria();
		criteria.andSnLike("%"+param+"%");
		userList= userService.getUserList(userCriteria);
		return userList;


	}

	public ModelAndView showUnreadMessage() {
		User currentUser = new User();
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		currentUser=userService.getUserByLoginSn(loginName);
		MessageCriteria messageCriteria=  new MessageCriteria();
		messageCriteria.setOrderByClause("sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(currentUser.getId());
		criteria.andIfreadEqualTo(false);
		int count=messageService.getCount(messageCriteria);
		ModelAndView mav = new ModelAndView("/equipment/top");
		mav.addObject("unreadCount", count);
		mav.addObject("user",currentUser);
		return mav;
	}



}
