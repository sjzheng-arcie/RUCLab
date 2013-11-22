package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.AnnouncementService;
import edu.ruc.labmgr.service.ApplicationFormService;
import edu.ruc.labmgr.service.MessageService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.MD5.CipherUtil;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    @RequestMapping("/administrator_top")
    public ModelAndView adminTop(HttpServletRequest request) {
        User currentUser = userService.getCurrentUser();

        MessageCriteria messageCriteria=  new MessageCriteria();
        messageCriteria.setOrderByClause("sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUser.getId());
        criteria.andIfreadEqualTo(false);
        int count=messageService.getCount(messageCriteria);
        ModelAndView mav = new ModelAndView("/laboratory/administrator_top");
        mav.addObject("unreadCount", count);
        mav.addObject("user",currentUser);
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
    @RequestMapping("/teacher_index")
    public ModelAndView teacher_Index(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/teacher_index");
        return mav;
    }
    @RequestMapping("/teacher_left")
    public ModelAndView teacher_Left(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/teacher_left");
        return mav;
    }
    @RequestMapping("/teacher_top")
    public ModelAndView teacher_top(HttpServletRequest request) {
        User currentUser = userService.getCurrentUser();

        MessageCriteria messageCriteria=  new MessageCriteria();
        messageCriteria.setOrderByClause("sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUser.getId());
        criteria.andIfreadEqualTo(false);
        int count=messageService.getCount(messageCriteria);
        ModelAndView mav = new ModelAndView("/laboratory/teacher_top");
        mav.addObject("unreadCount", count);
        mav.addObject("user",currentUser);
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
    @RequestMapping("student_index")
    public ModelAndView student_Index(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/student_index");
        return mav;
    }
    @RequestMapping("/student_left")
    public ModelAndView student_Left(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/student_left");
        return mav;
    }

    @RequestMapping("/student_top")
    public ModelAndView leader_Top(HttpServletRequest request) {
        User currentUser = userService.getCurrentUser();

        MessageCriteria messageCriteria=  new MessageCriteria();
        messageCriteria.setOrderByClause("sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUser.getId());
        criteria.andIfreadEqualTo(false);
        int count=messageService.getCount(messageCriteria);
        ModelAndView mav = new ModelAndView("/laboratory/student_top");
        mav.addObject("unreadCount", count);
        mav.addObject("user",currentUser);
        return mav;
    }

    @RequestMapping("/student_welcome")
    public ModelAndView showLeaderWelcome(HttpServletRequest request) {
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

    @RequestMapping("/login")
    public String toLogin() {

        return "/laboratory/login";
    }
    @RequestMapping("/excutelogin")
    public String login(HttpServletRequest request) {
        String result = "/login";
        String userSn = request.getParameter("username");
        String password = CipherUtil.generatePassword(request.getParameter("password"));

        UsernamePasswordToken token = new UsernamePasswordToken(userSn, password);

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            token.setRememberMe(false);
            try {
                currentUser.login(token);
            }catch(UnknownAccountException e){
                request.setAttribute("userNameNotExist","* 用户名不存在");
                request.setAttribute("preUserName",userSn);

                result="/laboratory/login";
            }catch (IncorrectCredentialsException e){
                request.setAttribute("passwordNotMatch","* 密码错误");
                request.setAttribute("preUserName",userSn);
                result="/laboratory/login";
            }
        }
        if (currentUser.hasRole(Types.Role.ADMIN.getName())) {


            result = "redirect:index";
        } else if (currentUser.hasRole("teacher")){

            result = "redirect:teacher_index";
        }else if (currentUser.hasRole("student")){

            result = "redirect:student_index";
        }else if (currentUser.hasRole("equipment_admin")){

            result = "redirect:admin_index";
        }

        return result;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        String result = "/laboratory/login";
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return result;
    }

    @RequestMapping("/top")
    public ModelAndView showUnreadMessage(HttpServletRequest request) {
        User currentUser = userService.getCurrentUser();

        MessageCriteria messageCriteria=  new MessageCriteria();
        messageCriteria.setOrderByClause("sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUser.getId());
        criteria.andIfreadEqualTo(false);
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




    @RequestMapping("jsp/experiment/achievement/myscore")
    public ModelAndView myScore(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/achievement/myscore");
        return mav;
    }
    @RequestMapping("jsp/experiment/report/uploadreport")
    public ModelAndView myCourseList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/report/uploadreport");
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

    @RequestMapping("jsp/experiment/experiment/paperinfo")
    public ModelAndView paperInfo(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("laboratory/jsp/experiment/experiment/detail");
        return mav;
    }
    @RequestMapping("jsp/experiment/experiment/editpaper")
    public ModelAndView editpaper(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/experiment/editpaper");
        return mav;
    }
    @RequestMapping("jsp/experiment/experiment/update")
    public ModelAndView updatePaper(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("laboratory/jsp/experiment/experiment/update");
        return mav;
    }
    @RequestMapping("jsp/experiment/experiment/toupdate")
    public ModelAndView updateToUpdate(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("laboratory/jsp/experiment/experiment/update");
        return mav;
    }

    @RequestMapping("jsp/experiment/experiment/addtopaper")
    public ModelAndView add(HttpServletRequest request) {


        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/experiment/addtopaper");
        return mav;
    }
    @RequestMapping("jsp/experiment/experiment/detail")
    public ModelAndView detail(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/experiment/detail");
        return mav;
    }
    @RequestMapping("jsp/experiment/experiment/toadd")
    public ModelAndView addPaper(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("laboratory/jsp/experiment/experiment/add");
        return mav;
    }
    @RequestMapping("jsp/experiment/report/courselist")
    public ModelAndView courseList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/report/courselist");
        return mav;
    }
    @RequestMapping("jsp/experiment/experiment/courselist")
    public ModelAndView courseListForExperiment(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/experiment/courselist");
        return mav;
    }
    @RequestMapping("jsp/experiment/report/list")
    public ModelAndView reportList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/report/list");
        return mav;
    }
    @RequestMapping("jsp/experiment/report/experimentlist")
    public ModelAndView markReport(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("laboratory/jsp/experiment/report/experimentlist");
        return mav;
    }
    @RequestMapping("jsp/experiment/report/maintain")
    public ModelAndView maintain(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/report/maintain");
        return mav;
    }

    @RequestMapping("jsp/experiment/report/studentlist")
    public ModelAndView markStudentList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/report/studentlist");
        return mav;
    }
    @RequestMapping("jsp/experiment/achievement/scorelist")
    public ModelAndView scoreList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/achievement/scorelist");
        return mav;
    }
    @RequestMapping("jsp/experiment/achievement/score")
    public ModelAndView achievementScore(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/achievement/score");
        return mav;
    }
    @RequestMapping("jsp/experiment/achievement/courselist")
    public ModelAndView achievementCourseList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/achievement/courselist");
        return mav;
    }
    @RequestMapping("jsp/experiment/achievement/toscore")
    public ModelAndView toAchievementCourseList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/experiment/achievement/score");
        return mav;
    }
    @RequestMapping("jsp/res/paper/list")
    public ModelAndView paperList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/paper/list");
        return mav;
    }
    @RequestMapping("jsp/res/paper/editpaper")
    public ModelAndView editPaper(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/paper/editpaper");
        return mav;
    }
    @RequestMapping("jsp/res/paper/addtopaper")
    public ModelAndView addToPaper(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/paper/addtopaper");
        return mav;
    }
    @RequestMapping("jsp/res/paper/addpaper")
    public ModelAndView paperAdd(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/paper/addpaper");
        return mav;
    }
    @RequestMapping("jsp/res/paper/paperinfo")
    public ModelAndView paperPaperInfo(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/paper/paperinfo");
        return mav;
    }
    @RequestMapping("jsp/res/question/list")
    public ModelAndView questionList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/question/list");
        return mav;
    }
    @RequestMapping("jsp/res/question/detail")
    public ModelAndView questionDetail(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/question/detail");
        return mav;
    }
    @RequestMapping("jsp/res/question/add")
    public ModelAndView questionAdd(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/question/add");
        return mav;
    }
    @RequestMapping("jsp/res/question/toadd")
    public ModelAndView questionToAdd(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/question/list");
        return mav;
    }
    @RequestMapping("jsp/res/question/edit")
    public ModelAndView questionEdit(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/question/edit");
        return mav;
    }
    @RequestMapping("jsp/res/experimentquestion/list")
    public ModelAndView experimentQuestionList(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/experimentquestion/list");
        return mav;
    }
    @RequestMapping("jsp/res/experimentquestion/detail")
    public ModelAndView experimentQuestionDetail(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/experimentquestion/detail");
        return mav;
    }
    @RequestMapping("jsp/res/experimentquestion/add")
    public ModelAndView experimentQuestionAdd(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/experimentquestion/add");
        return mav;
    }
    @RequestMapping("jsp/res/experimentquestion/toadd")
    public ModelAndView experimentQuestionToAdd(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/experimentquestion/list");
        return mav;
    }
    @RequestMapping("jsp/res/experimentquestion/edit")
    public ModelAndView experimentQuestionEdit(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/experimentquestion/edit");
        return mav;
    }
	@RequestMapping("bbs/index")
	public ModelAndView indexInIndex(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/index");
		return mav;
	}
	@RequestMapping("bbs/left")
	public ModelAndView bbsLeft(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/left");
		return mav;
	}
	@RequestMapping("bbs/frame")
	public ModelAndView bbsWelcome(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/frame");
		return mav;
	}
	@RequestMapping("bbs/list")
	public ModelAndView bbsList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/list");
		return mav;
	}
	@RequestMapping("bbs/answer")
	public ModelAndView bbsAnswer(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/answwer");
		return mav;
	}
	@RequestMapping("bbs/detail")
	public ModelAndView bbsDetail(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/detail");
		return mav;
	}

	@RequestMapping("bbs/list-cad")
	public ModelAndView bbsListCad(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/list-cad");
		return mav;
	}
	@RequestMapping("bbs/list-dl")
	public ModelAndView bbsListDl(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/list-dl");
		return mav;
	}
	@RequestMapping("bbs/list-gswl")
	public ModelAndView bbsListGswl(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/list-gswl");
		return mav;
	}
	@RequestMapping("bbs/list-mndl")
	public ModelAndView bbsListMndl(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/list-mndl");
		return mav;
	}
	@RequestMapping("bbs/post")
	public ModelAndView bbsListPost(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/post");
		return mav;
	}
	@RequestMapping("bbs/update")
	public ModelAndView bbsListUpdate(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/update");
		return mav;
	}
}
