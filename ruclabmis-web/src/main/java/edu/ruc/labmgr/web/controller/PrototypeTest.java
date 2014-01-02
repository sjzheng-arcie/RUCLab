package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.AnnouncementService;
import edu.ruc.labmgr.service.ApplicationFormService;
import edu.ruc.labmgr.service.MessageService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/laboratory")
public class PrototypeTest {


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

        ModelAndView mav = new ModelAndView("/laboratory/index");
        return mav;
    }

    @RequestMapping("/left")
    public ModelAndView left(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/left");
        return mav;
    }
    @RequestMapping("/admin_top")
    public ModelAndView top(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/admin_top");
        return mav;
    }
    private int stateId = 1;
    @RequestMapping("/welcome")
    public ModelAndView showWelcome(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/laboratory/welcome");
        int currentUserId = userService.getCurrentUserId();

        //获取当前用户的申请列表
        ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
        ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
        criteria.andApplicantIdEqualTo(currentUserId);
        applicationFormCriteria.or(criteria);
        List<ApplicationForm> myApplyList = applicationFormService.selectListByState( applicationFormCriteria);
        mav.addObject("myApplyList",myApplyList );
        //获取当前用户需要进行审批的申请列表
        ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
        ApplicationFormCriteria.Criteria criteria02=applicationFormCriteria02.createCriteria();
        criteria02.andApproverIdEqualTo(currentUserId);
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
        criteria2.andReceiverIdEqualTo(currentUserId);
        messageCriteria.setOrderByClause("sendtime desc");
        List<Message> messageList = messageService.getMessageListByCriteia(messageCriteria);
        mav.addObject("messageList",messageList);

        return mav;
    }

    @RequestMapping("/administrator_index")
    public ModelAndView admin_Index(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/administrator_index");
        return mav;
    }
    @RequestMapping("/administrator_left")
    public ModelAndView admin_Left(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/administrator_left");
        return mav;
    }
	@RequestMapping("/administrator_leftmenu")
	public ModelAndView admin_leftmenu(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("laboratory/administrator_leftmenuresource");
		return mav;
	}
	@RequestMapping("/administrator_leftmenubasinfo")
	public ModelAndView admin_Leftmenubasinfo(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/administrator_leftmenubasinfo");
		return mav;
	}
	@RequestMapping("/administrator_leftmenulab")
	public ModelAndView admin_Leftmenulab(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/administrator_leftmenulab");
		return mav;
	}
	@RequestMapping("/administrator_leftmenusys")
	public ModelAndView admin_Leftmenusys(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/administrator_leftmenusys");
		return mav;
	}
	@RequestMapping("//administrator_leftmenuorder")
	public ModelAndView administrator_leftmenuorder(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/administrator_leftmenuorder");
		return mav;
	}
	@RequestMapping("/administrator_leftmenutask")
	public ModelAndView admin_Leftmenutask(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/administrator_leftmenutask");
		return mav;
	}
	@RequestMapping("/administrator_leftmenuteach")
	public ModelAndView admin_Leftmenuteach(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/administrator_leftmenuteach");
		return mav;
	}
    @RequestMapping("/administrator_welcome")
    public ModelAndView showAdminWelcome(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/laboratory/administrator_welcome");
        int currentUserId = userService.getCurrentUserId();

        //获取当前用户的申请列表
        ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
        ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
        criteria.andApplicantIdEqualTo(currentUserId);
        applicationFormCriteria.or(criteria);
        List<ApplicationForm> myApplyList = applicationFormService.selectListByState( applicationFormCriteria);
        mav.addObject("myApplyList",myApplyList );
        //获取当前用户需要进行审批的申请列表
        ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
        ApplicationFormCriteria.Criteria criteria02=applicationFormCriteria02.createCriteria();
        criteria02.andApproverIdEqualTo(currentUserId);
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
	@RequestMapping("/leader_welcome")
	public ModelAndView showLeaderWelcome(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/laboratory/leader_welcome");
		int currentUserId = userService.getCurrentUserId();

		//获取当前用户的申请列表
		ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
		criteria.andApplicantIdEqualTo(currentUserId);
		applicationFormCriteria.or(criteria);
		List<ApplicationForm> myApplyList = applicationFormService.selectListByState( applicationFormCriteria);
		mav.addObject("myApplyList",myApplyList );
		//获取当前用户需要进行审批的申请列表
		ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria02=applicationFormCriteria02.createCriteria();
		criteria02.andApproverIdEqualTo(currentUserId);
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
    @RequestMapping("/teacher_welcome")
    public ModelAndView showTeacherWelcome(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/laboratory/teacher_welcome");

        int currentUserId = userService.getCurrentUserId();
        //获取当前用户的申请列表
        ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
        ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
        criteria.andApplicantIdEqualTo(currentUserId);
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
    @RequestMapping("/student_welcome")
    public ModelAndView showStudentWelcome(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/laboratory/student_welcome");

        int currentUserId = userService.getCurrentUserId();

        //获取当前用户需要进行审批的申请列表
        ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
        ApplicationFormCriteria.Criteria criteria02=applicationFormCriteria02.createCriteria();
        criteria02.andApproverIdEqualTo(currentUserId);
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
    @RequestMapping("/top")
    public ModelAndView showUnreadMessage(HttpServletRequest request) {
        User currentUser = userService.getCurrentUser();

        MessageCriteria messageCriteria=  new MessageCriteria();
        messageCriteria.setOrderByClause("sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUser.getId());
        criteria.andIfreadEqualTo(false);
		criteria.andSystemEqualTo(true);
        int count=messageService.getCount(messageCriteria);
        ModelAndView mav = new ModelAndView("/laboratory/top");
        mav.addObject("unreadCount", count);
        mav.addObject("user",currentUser);
        return mav;
    }

    int currPage=0;

    @RequestMapping("welcome_message")
    public ModelAndView showMessage(HttpServletRequest request) {
        int currentUserId = userService.getCurrentUserId();

        currPage = request.getParameter("page") == null   ?
                (currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));

        MessageCriteria messageCriteria=  new MessageCriteria();
        messageCriteria.setOrderByClause(" sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUserId);

        ObjectListPage<Message> pageInfo = messageService.selectListPage(currPage,messageCriteria );
        ModelAndView mav = new ModelAndView("/laboratory/welcome");
        mav.addObject("messageLists", pageInfo.getListObject());
        mav.addObject("page", pageInfo.getPageInfo());

        return mav;
    }

    @RequestMapping("welcome_announcement")
    public ModelAndView showAnnouncement(HttpServletRequest request) {
        currPage = request.getParameter("page") == null   ?
                (currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));

        AnnouncementCriteria announcementCriteria =  new AnnouncementCriteria();
        AnnouncementCriteria.Criteria criteria = announcementCriteria.createCriteria();

        criteria.andPublishLimitEqualTo(0);
        announcementCriteria.or(criteria);
        ObjectListPage<Announcement> pageInfo = announcementService.selectListPage(currPage, announcementCriteria);
        System.out.print(pageInfo .getListObject().size());
        ModelAndView mav = new ModelAndView("/laboratory/welcome");
        mav.addObject("announcementLists", pageInfo.getListObject());
        mav.addObject("page", pageInfo.getPageInfo());

        return mav;
    }
    @RequestMapping("announcementDetail")
    public ModelAndView getAnnouncement(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("announcementDetailId"));
        Announcement announcement = announcementService.getAnnouncementById(id);

        ModelAndView mav = new ModelAndView("/laboratory/jsp/announcement/remind/announcementdetail");
        mav.addObject("announcementDetailFlag",announcement);
        return mav;
    }

    @RequestMapping("messageDetail")
    public ModelAndView getMessage(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("messageDetailId"));
        Message message= messageService.selectById(id);

        ModelAndView mav = new ModelAndView("/laboratory/jsp/announcement/remind/messagedetail");
        mav.addObject("messageDetailFlag",message);
        return mav;
    }


    @RequestMapping("jsp/experiment/experiment/myexperimentlist")
    public ModelAndView myExperimentList(HttpServletRequest request) {

        PageInfo<Experiment> pageInfo=null;
        List<Classif>courseList=null;
        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/experiment/myexperimentlist");
        mav.addObject("pageInfo",pageInfo);
        mav.addObject("courseList",courseList);

        return mav;


    }


	@RequestMapping("jsp/curriculum/curriculum/mycurriculumschedule")
	public ModelAndView myCurriculumSchedule() {
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/experiment/curriculum/mycurriculumschedule");
		return mav;
	}
	@RequestMapping("jsp/curriculum/experiment/curriculum/listdeviceapply")
	public ModelAndView listDeviceApply() {
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/experiment/curriculum/listdeviceapply");
		return mav;
	}
	@RequestMapping("jsp/curriculum/experiment/curriculum/curriculumclasslist")
	public ModelAndView curriculumClassList() {
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/curriculumclasslist");
		return mav;
	}
	@RequestMapping("jsp/curriculum/experiment/curriculum/curriculumview")
	public ModelAndView curriculumViewView() {
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/experiment/curriculum/curriculumview");
		return mav;
	}
	@RequestMapping("jsp/curriculum/experiment/curriculum/setcurriculum")
	public ModelAndView setcurriculum() {
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/experiment/curriculum/setcurriculum");
		return mav;
	}
	@RequestMapping("jsp/curriculum/experiment/curriculum/createcurriculum")
	public ModelAndView createCurriculum() {
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/experiment/curriculum/createcurriculum");
		return mav;
	}
	@RequestMapping("jsp/curriculum/experiment/curriculum/importcurriculum")
	public ModelAndView importCurriculum() {
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/experiment/curriculum/importcurriculum");
		return mav;
	}
	@RequestMapping("jsp/curriculum/experiment/curriculum/addlession")
	public ModelAndView addLession() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/experiment/curriculum/addlession");
		return mav;
	}
	@RequestMapping("jsp/curriculum/experiment/curriculum/toaddlession")
	public ModelAndView toAddLession() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/experiment/curriculum/toaddlession");
		return mav;
	}
	@RequestMapping("jsp/curriculum/experiment/curriculum/setlab")
	public ModelAndView setLab() {
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/experiment/curriculum/setlab");
		return mav;
	}


}
