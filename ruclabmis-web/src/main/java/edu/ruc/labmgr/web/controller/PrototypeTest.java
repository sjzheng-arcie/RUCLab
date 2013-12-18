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
    public ModelAndView courseListOfReport(HttpServletRequest request) {

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
    public ModelAndView achievementCourseList() {

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
    public ModelAndView editPaper() {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/paper/editpaper");
        return mav;
    }
    @RequestMapping("jsp/res/paper/addtopaper")
    public ModelAndView addToPaper(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/paper/addtopaper");
        return mav;
    }
    @RequestMapping("jsp/res/paper/addpaper")
    public ModelAndView paperAdd() {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/paper/addpaper");
        return mav;
    }
    @RequestMapping("jsp/res/paper/paperinfo")
    public ModelAndView paperPaperInfo(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/paper/paperinfo");
        return mav;
    }
    @RequestMapping("jsp/res/question/list")
    public ModelAndView questionList() {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/question/list");
        return mav;
    }
    @RequestMapping("jsp/res/question/detail")
    public ModelAndView questionDetail() {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/question/detail");
        return mav;
    }
	@RequestMapping("jsp/res/instructor/list")
	public ModelAndView instructorList() {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/res/instructor/list");
		return mav;
	}
	@RequestMapping("jsp/res/instructor/add")
	public ModelAndView instructorAdd() {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/res/instructor/add");
		return mav;
	}
	@RequestMapping("jsp/res/instructor/addpaper")
	public ModelAndView instructorAddPaperList() {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/res/instructor/addpaper");
		return mav;
	}
	@RequestMapping("jsp/res/instructor/addtopaper")
	public ModelAndView instructorAddToPaper() {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/res/instructor/addtopaper");
		return mav;
	}
	@RequestMapping("jsp/res/instructor/editpaper")
	public ModelAndView instructorEditPaper() {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/res/instructor/editpaper");
		return mav;
	}
	@RequestMapping("jsp/res/instructor/editupload")
	public ModelAndView editupload(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/res/instructor/editupload");
		return mav;
	}
	@RequestMapping("jsp/res/instructor/paperinfo")
	public ModelAndView instructorPaperInfo() {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/res/instructor/paperinfo");
		return mav;
	}


    @RequestMapping("jsp/res/question/add")
    public ModelAndView questionAdd() {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/question/add");
        return mav;
    }
    @RequestMapping("jsp/res/question/toadd")
    public ModelAndView questionToAdd() {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/question/list");
        return mav;
    }
    @RequestMapping("jsp/res/question/edit")
    public ModelAndView questionEdit() {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/question/edit");
        return mav;
    }
    @RequestMapping("jsp/res/experimentquestion/list")
    public ModelAndView experimentQuestionList() {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/experimentquestion/list");
        return mav;
    }
    @RequestMapping("jsp/res/experimentquestion/detail")
    public ModelAndView experimentQuestionDetail() {

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/experimentquestion/detail");
        return mav;
    }
    @RequestMapping("jsp/res/experimentquestion/add")
    public ModelAndView experimentQuestionAdd() {

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
/*	@RequestMapping("bbs/left")
	public ModelAndView bbsLeft(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/left");
		return mav;
	}*/
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
	@RequestMapping("jsp/bas/teachingmaterial/list")
	public ModelAndView teachingMaterialList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/teachingmaterial/list");
		return mav;
	}
	@RequestMapping("new/left")
	public ModelAndView newLeft(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/new/left");
		return mav;
	}
	@RequestMapping("new/index")
	public ModelAndView newIndex(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/new/index");
		return mav;
	}
	@RequestMapping("jsp/bas/student/list")
	public ModelAndView studentList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/student/list");
		return mav;
	}
	@RequestMapping("jsp/bas/class/list")
	public ModelAndView classList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/class/list");
		return mav;
	}
	@RequestMapping("jsp/bas/course/list")
	public ModelAndView courseList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/course/list");
		return mav;
	}
	@RequestMapping("jsp/bas/course/add")
	public ModelAndView courseAdd(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/course/add");
		return mav;
	}
	@RequestMapping("jsp/bas/majorcourse/list")
	public ModelAndView majorCourseList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/majorcourse/list");
		return mav;
	}

	@RequestMapping("jsp/bas/major/list")
	public ModelAndView majorList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/major/list");
		return mav;
	}
	@RequestMapping("jsp/bas/major/add")
	public ModelAndView addList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/major/add");
		return mav;
	}
	@RequestMapping("jsp/bas/calendar/list")
	public ModelAndView calenderList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/calendar/list");
		return mav;
	}
	@RequestMapping("jsp/task/mytask/mytasklist")
	public ModelAndView taskList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/task/mytask/mytasklist");
		return mav;
	}
	@RequestMapping("jsp/task/mytask/toUpdate")
	public ModelAndView toUpdateMyTask(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/task/mytask/update");
		return mav;
	}
	@RequestMapping("jsp/task/mytask/toAdd")
	public ModelAndView toAddTask(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/task/mytask/add");
		return mav;
	}
	@RequestMapping("jsp/task/work/myworklist")
	public ModelAndView workList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("laboratory/jsp/task/work/myworklist");
		return mav;
	}
	@RequestMapping("jsp/task/work/toUpdate")
	 public ModelAndView toUpdateWork(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/task/work/update");
		return mav;
	}
	@RequestMapping("jsp/task/work/toAdd")
	public ModelAndView toAddWork(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/task/work/add");
		return mav;
	}
	@RequestMapping("jsp/task/task/leaderlist")
	public ModelAndView leaderTaskList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/task/task/leaderlist");
		return mav;
	}
	@RequestMapping("jsp/task/task/update")
	public ModelAndView toUpdateTask(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/task/task/update");
		return mav;
	}
	@RequestMapping("jsp/task/task/saveupdate")
	public ModelAndView toSaveUpdateTask(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/task/task/leaderlist");
		return mav;
	}
	@RequestMapping("jsp/task/task/deleteTask")
	public ModelAndView toDeleteTask(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/task/task/leaderlist");
		return mav;
	}
	@RequestMapping("jsp/task/task/toScore")
	public ModelAndView toScore(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/task/task/leaderscore");
		return mav;
	}
	@RequestMapping("jsp/task/task/save")
	public ModelAndView toSaveScore(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/task/task/leaderlist");
		return mav;
	}
	@RequestMapping("jsp/res/book/list")
	public ModelAndView bookList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/res/book/list");
		return mav;
	}
	@RequestMapping("jsp/res/book/toUpload")
	public ModelAndView bookUpload(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/res/book/upload");
		return mav;
	}
	@RequestMapping("jsp/res/book/toUpdate")
	public ModelAndView bookToUpdate(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/laboratory/jsp/res/book/update");
		return mav;
	}
	@RequestMapping("jsp/curriculum/experiment/curriculum/mycurriculumschedule")
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
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/experiment/curriculum/curriculumclasslist");
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
	@RequestMapping("/administrator_leftmenuorder")
	public ModelAndView leftMenuOrder() {
		ModelAndView mav = new ModelAndView("/laboratory/administrator_leftmenuorder");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/laboratory/appointmentbaseinfo")
	public ModelAndView appointmentBaseInfo() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/laboratory/appointmentbaseinfo");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/laboratory/appointmentdate")
	public ModelAndView appointmentDate() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/laboratory/appointmentdate");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/laboratory/appointmentdatecontent")
	public ModelAndView appointmentDateContent() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/laboratory/appointmentdatecontent");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/laboratory/appointmentinfosubmit")
	public ModelAndView appointmentInfoSubmit() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/laboratory/appointmentinfosubmit");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/laboratory/deviceapply")
	public ModelAndView deviceApply() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/laboratory/deviceapply");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/laboratory/laboratoryapply")
	public ModelAndView laboratoryApply() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/laboratory/laboratoryapply");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/laboratory/benchappointment")
	public ModelAndView benchAppointment() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/laboratory/benchappointment");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/laboratory/benchappointmentcontent")
	public ModelAndView benchAppointmentContent() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/laboratory/benchappointmentcontent");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/laboratory/mydatelist")
	public ModelAndView myDateList() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/laboratory/mydatelist");
		return mav;
	}

	@RequestMapping("jsp/curriculum/appointment/meetingroom/appointmentdate")
	public ModelAndView meetingRoomAppointmentDate() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/meetingroom/appointmentdate");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/meetingroom/appointmentdatecontent")
	public ModelAndView meetingRoomAppointmentDateContent() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/meetingroom/appointmentdatecontent");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/meetingroom/appointmentinfocommit")
	public ModelAndView appointmentInfoCommit() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/meetingroom/appointmentinfocommit");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/meetingroom/deviceapply")
	public ModelAndView meetingRoomDeviceApply() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/meetingroom/deviceapply");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/meetingroom/meetingroomappointment")
	public ModelAndView meetingRoomAppointment() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/meetingroom/meetingroomappointment");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/meetingroom/meetingroomapply")
	public ModelAndView meetingRoomApply() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/meetingroom/meetingroomapply");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/meetingroom/meetingroomappointmentbaseinfo")
	public ModelAndView meetingRoomAppointmentBaseInfo() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/meetingroom/meetingroomappointmentbaseinfo");
		return mav;
	}
	@RequestMapping("jsp/curriculum/appointment/meetingroom/appointmentbaseinfo")
	public ModelAndView meetingAppointmentBaseInfo() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/appointment/meetingroom/appointmentbaseinfo");
		return mav;
	}
	@RequestMapping("jsp/lab/org/list")
	public ModelAndView orgList() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/org/list");
		return mav;
	}
	@RequestMapping("jsp/lab/org/add")
	public ModelAndView orgAdd() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/org/add");
		return mav;
	}
	@RequestMapping("jsp/lab/org/toUpdate")
	public ModelAndView orgUpdate() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/org/update");
		return mav;
	}
	@RequestMapping("jsp/lab/device/devicelist")
	public ModelAndView deviceList() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/device/devicelist");
		return mav;
	}
	@RequestMapping("jsp/lab/device/add")
	public ModelAndView deviceAdd() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/device/add");
		return mav;
	}
	@RequestMapping("jsp/lab/device/toUpdate")
	public ModelAndView deviceUpdate() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/device/update");
		return mav;
	}

	@RequestMapping("jsp/lab/lab/list")
	public ModelAndView labList() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/lab/list");
		return mav;
	}
	@RequestMapping("jsp/lab/lab/add")
	public ModelAndView labAdd() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/lab/add");
		return mav;
	}
	@RequestMapping("jsp/lab/lab/toUpdate")
	public ModelAndView labUpdate() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/lab/update");
		return mav;
	}
	@RequestMapping("jsp/lab/lab/addtolaboratory")
	public ModelAndView laboratoryAddRoomToLaboratory() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/lab/addtolaboratory");
		return mav;
	}
	@RequestMapping("jsp/lab/lab/addroom")
	public ModelAndView addRoom() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/lab/addroom");
		return mav;
	}
	@RequestMapping("jsp/lab/desk/list")
	public ModelAndView deskList() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/desk/list");
		return mav;
	}
	@RequestMapping("jsp/lab/desk/add")
	public ModelAndView deskAdd() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/desk/add");
		return mav;
	}
	@RequestMapping("jsp/lab/desk/toUpdate")
	public ModelAndView deskUpdate() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/desk/toupdate");
		return mav;
	}
	@RequestMapping("jsp/lab/desk/addequipment")
	public ModelAndView deskAddEquipment() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/desk/addequipment");
		return mav;
	}
	@RequestMapping("jsp/lab/desk/deskinfo")
	public ModelAndView deskInfo() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/desk/deskinfo");
		return mav;
	}
	@RequestMapping("jsp/lab/desk/addtodesk")
	public ModelAndView deskAddEquipmentToDesk() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/desk/addtodesk");
		return mav;
	}
	@RequestMapping("jsp/lab/desk/toadd")
	public ModelAndView toAddDesk() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/desk/toadd");
		return mav;
	}
	@RequestMapping("jsp/lab/desk/toupdate")
	public ModelAndView toUpdateDesk() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/desk/toupdate");
		return mav;
	}

	@RequestMapping("jsp/lab/emp/list")
		 public ModelAndView empList() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/emp/list");
		return mav;
	}
	@RequestMapping("jsp/lab/emp/add")
	public ModelAndView empAdd() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/emp/add");
		return mav;
	}
	@RequestMapping("jsp/lab/post/list")
	public ModelAndView postList() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/post/list");
		return mav;
	}
	@RequestMapping("jsp/lab/post/add")
	public ModelAndView postAdd() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/lab/post/add");
		return mav;
	}
}
