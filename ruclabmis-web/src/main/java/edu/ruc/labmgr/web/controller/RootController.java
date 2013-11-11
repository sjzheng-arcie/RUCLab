package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.AnnouncementService;
import edu.ruc.labmgr.service.ApplicationFormService;
import edu.ruc.labmgr.service.MessageService;
import edu.ruc.labmgr.service.UserService;

import edu.ruc.labmgr.utils.MD5.CipherUtil;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/equipment")
public class RootController {

	@Autowired
	private ApplicationFormService applicationFormService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private AnnouncementService announcementService;


	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/index");
		return mav;
	}
	@RequestMapping("/tops")
	public ModelAndView top(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/top");
		return mav;
	}
	private int stateId = 1;
	@RequestMapping("/welcome")
	public ModelAndView showWelcome(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/welcome");
		User user = new User();
		String loginName=SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		//获取当前用户的申请列表
		ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
		criteria.andApplicantIdEqualTo(user.getId());
		applicationFormCriteria.or(criteria);
		List<ApplicationForm> myApplyList = applicationFormService.selectListByState( applicationFormCriteria);
		mav.addObject("myApplyList",myApplyList );
		//获取当前用户需要进行审批的申请列表
		ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria02=applicationFormCriteria02.createCriteria();
		criteria02.andApproverIdEqualTo(user.getId());
		applicationFormCriteria.or(criteria);
		List<ApplicationForm> pendingApplyList = applicationFormService.selectListByState(applicationFormCriteria02);
		mav.addObject("pendingApplyList", pendingApplyList );

		//获取通知列表
		AnnouncementCriteria announcementCriteria = new AnnouncementCriteria();
		announcementCriteria.setOrderByClause("publish_time desc");
		AnnouncementCriteria.Criteria criteria1=announcementCriteria.createCriteria();
		List<Announcement> announcementList = announcementService.getAnnouncementListByCriteriaForWelcome(announcementCriteria);
		mav.addObject("announcementList",announcementList );
		//获取消息列表
		MessageCriteria messageCriteria = new MessageCriteria();

		MessageCriteria.Criteria criteria2 = messageCriteria.createCriteria();
		criteria2.andReceiverIdEqualTo(user.getId());
		messageCriteria.setOrderByClause("sendtime desc");
		List<Message> messageList = messageService.getMessageListByCriteia(messageCriteria);
		mav.addObject("messageList",messageList);

		return mav;
	}

	@RequestMapping("/admin_index")
	public ModelAndView admin_Index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/admin_index");
		return mav;
	}
	@RequestMapping("/admin_top")
	public ModelAndView adminTop(HttpServletRequest request) {
		User currentUser = new User();
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		currentUser=userService.getUserByLoginSn(loginName);
		MessageCriteria messageCriteria=  new MessageCriteria();
		messageCriteria.setOrderByClause("sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(currentUser.getId());
		criteria.andIfreadEqualTo(false);
		int count=messageService.getCount(messageCriteria);
		ModelAndView mav = new ModelAndView("/equipment/admin_top");
		mav.addObject("unreadCount", count);
		mav.addObject("user",currentUser);
		return mav;
	}
	@RequestMapping("/admin_welcome")
	public ModelAndView showAdminWelcome(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/equipment/admin_welcome");
		User user = new User();
		String loginName=SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		//获取当前用户的申请列表
		ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
		criteria.andApplicantIdEqualTo(user.getId());
		applicationFormCriteria.or(criteria);
		List<ApplicationForm> myApplyList = applicationFormService.selectListByState( applicationFormCriteria);
		mav.addObject("myApplyList",myApplyList );
		//获取当前用户需要进行审批的申请列表
		ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria02=applicationFormCriteria02.createCriteria();
		criteria02.andApproverIdEqualTo(user.getId());
		applicationFormCriteria.or(criteria);
		List<ApplicationForm> pendingApplyList = applicationFormService.selectListByState(applicationFormCriteria02);
		mav.addObject("pendingApplyList", pendingApplyList );

		//获取通知列表
		AnnouncementCriteria announcementCriteria = new AnnouncementCriteria();
		announcementCriteria.setOrderByClause("publish_time desc");
		List<Announcement> announcementList = announcementService.getAnnouncementListByCriteriaForWelcome(announcementCriteria);
		mav.addObject("announcementList",announcementList );
		//获取消息列表
		MessageCriteria messageCriteria = new MessageCriteria();
		messageCriteria.setOrderByClause("sendtime desc");
		List<Message> messageList = messageService.getMessageListByCriteia(messageCriteria);
		mav.addObject("messageList",messageList);

		return mav;
	}
	@RequestMapping("/teacher_index")
	public ModelAndView teacher_Index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/teacher_index");
		return mav;
	}
	@RequestMapping("/teacher_top")
	public ModelAndView teacher_top(HttpServletRequest request) {

		User currentUser = new User();
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		currentUser=userService.getUserByLoginSn(loginName);
		MessageCriteria messageCriteria=  new MessageCriteria();
		messageCriteria.setOrderByClause("sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(currentUser.getId());
		criteria.andIfreadEqualTo(false);
		int count=messageService.getCount(messageCriteria);
		ModelAndView mav = new ModelAndView("/equipment/teacher_top");
		mav.addObject("unreadCount", count);
		mav.addObject("user",currentUser);
		return mav;
	}
	@RequestMapping("/teacher_welcome")
	public ModelAndView showTeacherWelcome(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/teacher_welcome");
		User user = new User();
		String loginName=SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		//获取当前用户的申请列表
		ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
		criteria.andApplicantIdEqualTo(user.getId());
		applicationFormCriteria.or(criteria);
		List<ApplicationForm> myApplyList = applicationFormService.selectListByState( applicationFormCriteria);
		mav.addObject("myApplyList",myApplyList );
		//获取通知列表
		AnnouncementCriteria announcementCriteria = new AnnouncementCriteria();
		announcementCriteria.setOrderByClause("publish_time desc");
		List<Announcement> announcementList = announcementService.getAnnouncementListByCriteriaForWelcome(announcementCriteria);
		mav.addObject("announcementList",announcementList );
		//获取消息列表
		MessageCriteria messageCriteria = new MessageCriteria();
		messageCriteria.setOrderByClause("sendtime desc");
		List<Message> messageList = messageService.getMessageListByCriteia(messageCriteria);
		mav.addObject("messageList",messageList);

		return mav;
	}
	@RequestMapping("/leader_index")
	public ModelAndView leader_Index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/leader_index");
		return mav;
	}

	@RequestMapping("/leader_top")
	public ModelAndView leader_Top(HttpServletRequest request) {

		User currentUser = new User();
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		currentUser=userService.getUserByLoginSn(loginName);
		MessageCriteria messageCriteria=  new MessageCriteria();
		messageCriteria.setOrderByClause("sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(currentUser.getId());
		criteria.andIfreadEqualTo(false);
		int count=messageService.getCount(messageCriteria);
		ModelAndView mav = new ModelAndView("/equipment/leader_top");
		mav.addObject("unreadCount", count);
		mav.addObject("user",currentUser);
		return mav;
	}

	@RequestMapping("/leader_welcome")
	public ModelAndView showLeaderWelcome(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/equipment/leader_welcome");
		User user = new User();
		String loginName=SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);

		//获取当前用户需要进行审批的申请列表
		ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria02=applicationFormCriteria02.createCriteria();
		criteria02.andApproverIdEqualTo(user.getId());
		List<ApplicationForm> pendingApplyList = applicationFormService.selectListByState(applicationFormCriteria02);
		mav.addObject("pendingApplyList", pendingApplyList );

		//获取通知列表
		AnnouncementCriteria announcementCriteria = new AnnouncementCriteria();
		announcementCriteria.setOrderByClause("publish_time desc");
		List<Announcement> announcementList = announcementService.getAnnouncementListByCriteriaForWelcome(announcementCriteria);
		mav.addObject("announcementList",announcementList );
		//获取消息列表
		MessageCriteria messageCriteria = new MessageCriteria();
		messageCriteria.setOrderByClause("sendtime desc");
		List<Message> messageList = messageService.getMessageListByCriteia(messageCriteria);
		mav.addObject("messageList",messageList);

		return mav;
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		String result = "/login";
		String userSn = request.getParameter("username");
		String password = CipherUtil.generatePassword(request.getParameter("password"));

		UsernamePasswordToken token = new UsernamePasswordToken(userSn, password);

		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.isAuthenticated()) {
			token.setRememberMe(true);
			try {
				currentUser.login(token);
				result = "redirect:index";
			} catch (Exception e) {
				result = "/equipment/login";
			}
		}
		if (currentUser.hasRole(Types.Role.ADMIN.getName())) {


			result = "redirect:index";
		} else if (currentUser.hasRole("teacher")){

			result = "redirect:teacher_index";
		}else if (currentUser.hasRole("leader")){

			result = "redirect:leader_index";
		}else if (currentUser.hasRole("equipment_admin")){

			result = "redirect:admin_index";
		}

		return result;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		String result = "redirect:login";
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return result;
	}

	@RequestMapping("/top")
	public ModelAndView showUnreadMessage(HttpServletRequest request) {
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

	int currPage=0;

	@RequestMapping("/welcome_message")
	public ModelAndView showMessage(HttpServletRequest request) {
		User user = new User();
		String loginName= SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);

		currPage = request.getParameter("page") == null   ?
				(currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));

		MessageCriteria messageCriteria=  new MessageCriteria();
		messageCriteria.setOrderByClause(" sendtime desc");
		MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andReceiverIdEqualTo(user.getId());


		ObjectListPage<Message> pageInfo = messageService.selectListPage(currPage,messageCriteria );
		ModelAndView mav = new ModelAndView("/equipment/welcome");
		mav.addObject("messageLists", pageInfo.getListObject());
		mav.addObject("page", pageInfo.getPageInfo());

		return mav;
	}

	@RequestMapping("/welcome_announcement")
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
		ObjectListPage<Announcement> pageInfo = announcementService.selectListPage(currPage, announcementCriteria);
		System.out.print(pageInfo .getListObject().size());
		ModelAndView mav = new ModelAndView("/equipment/welcome");
		mav.addObject("announcementLists", pageInfo.getListObject());
		mav.addObject("page", pageInfo.getPageInfo());

		return mav;
	}
	@RequestMapping("/announcementDetail")
	public ModelAndView getAnnouncement(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("announcementDetailId"));
		Announcement announcement = announcementService.getAnnouncementById(id);

		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/announcementdetail");
		mav.addObject("announcementDetailFlag",announcement);
		return mav;
	}

	@RequestMapping("/messageDetail")
	public ModelAndView getMessage(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("messageDetailId"));
		Message message= messageService.selectById(id);

		ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/messagedetail");
		mav.addObject("messageDetailFlag",message);
		return mav;
	}


}
