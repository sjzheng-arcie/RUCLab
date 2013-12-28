package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.AnnouncementService;
import edu.ruc.labmgr.service.ApplicationFormService;
import edu.ruc.labmgr.service.MessageService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.page.ObjectListPage;
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
        int currentUserId = userService.getCurrentUserId();

        //获取当前用户的申请列表
        mav.addObject("myApplyList", getMyApplyList(currentUserId));
        //获取当前用户需要进行审批的申请列表
        mav.addObject("pendingApplyList", getPendingApplyList(currentUserId));

        //获取通知列表

        mav.addObject("announcementList", getAnnouncementList());
        //获取消息列表
        MessageCriteria messageCriteria = new MessageCriteria();

        MessageCriteria.Criteria criteria2 = messageCriteria.createCriteria();
        criteria2.andReceiverIdEqualTo(currentUserId);
        messageCriteria.setOrderByClause("sendtime desc");
        List<Message> messageList = messageService.getMessageListByCriteia(messageCriteria);
        mav.addObject("messageList", messageList);

        return mav;
    }

    public List<ApplicationForm> getMyApplyList(int userId) {
        ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
        ApplicationFormCriteria.Criteria criteria = applicationFormCriteria.createCriteria();
        criteria.andApplicantIdEqualTo(userId);
        criteria.andStateIdNotEqualTo(34);
        List<ApplicationForm> myApplyList = applicationFormService.selectListByState(applicationFormCriteria);
        return myApplyList;
    }

    public List<ApplicationForm> getPendingApplyList(int userId) {
        ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
        ApplicationFormCriteria.Criteria criteria02 = applicationFormCriteria02.createCriteria();
        criteria02.andApproverIdEqualTo(userId);
        criteria02.andStateIdNotEqualTo(34);
        List<ApplicationForm> pendingApplyList = applicationFormService.selectListByState(applicationFormCriteria02);
        return pendingApplyList;
    }

    public List<Announcement> getAnnouncementList() {
        AnnouncementCriteria announcementCriteria = new AnnouncementCriteria();
        announcementCriteria.setOrderByClause("publish_time desc");
        AnnouncementCriteria.Criteria criteria1 = announcementCriteria.createCriteria();
        List<Announcement> announcementList = announcementService.getAnnouncementListByCriteriaForWelcome(announcementCriteria);
        return announcementList;
    }

    @RequestMapping("/admin_index")
    public ModelAndView admin_Index(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/equipment/admin_index");
        return mav;
    }

    @RequestMapping("/admin_top")
    public ModelAndView adminTop(HttpServletRequest request) {
        User currentUser = userService.getCurrentUser();

        MessageCriteria messageCriteria = new MessageCriteria();
        messageCriteria.setOrderByClause("sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUser.getId());
        criteria.andIfreadEqualTo(false);
        int count = messageService.getCount(messageCriteria);
        ModelAndView mav = new ModelAndView("/equipment/admin_top");
        mav.addObject("unreadCount", count);
        mav.addObject("user", currentUser);
        return mav;
    }

    @RequestMapping("/admin_welcome")
    public ModelAndView showAdminWelcome(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/equipment/admin_welcome");
        int currentUserId = userService.getCurrentUserId();

        //获取当前用户的申请列表
        mav.addObject("myApplyList", getMyApplyList(currentUserId));
        //获取当前用户需要进行审批的申请列表
        mav.addObject("pendingApplyList", getPendingApplyList(currentUserId));
        //获取通知列表

        mav.addObject("announcementList", getAnnouncementList());
        //获取消息列表
        MessageCriteria messageCriteria = new MessageCriteria();
        MessageCriteria.Criteria criteria2 = messageCriteria.createCriteria();
        criteria2.andReceiverIdEqualTo(currentUserId);
        messageCriteria.setOrderByClause("sendtime desc");
        List<Message> messageList = messageService.getMessageListByCriteia(messageCriteria);
        mav.addObject("messageList", messageList);

        return mav;
    }

    @RequestMapping("/teacher_index")
    public ModelAndView teacher_Index(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/equipment/teacher_index");
        return mav;
    }

    @RequestMapping("/left")
    public ModelAndView allLeft(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/equipment/left");
        return mav;
    }

    @RequestMapping("/teacher_top")
    public ModelAndView teacher_Top(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/equipment/teacher_top");
        return mav;
    }

    @RequestMapping("/teacher_welcome")
    public ModelAndView showTeacherWelcome(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/equipment/teacher_welcome");
        int currentUserId = userService.getCurrentUserId();

        //获取当前用户的申请列表
        mav.addObject("myApplyList", getMyApplyList(currentUserId));
        //获取通知列表
        mav.addObject("announcementList", getAnnouncementList());
        //获取消息列表

        MessageCriteria messageCriteria = new MessageCriteria();
        MessageCriteria.Criteria criteria2 = messageCriteria.createCriteria();
        criteria2.andReceiverIdEqualTo(currentUserId);
        messageCriteria.setOrderByClause("sendtime desc");

        List<Message> messageList = messageService.getMessageListByCriteia(messageCriteria);
        mav.addObject("messageList", messageList);

        return mav;
    }

    @RequestMapping("/leader_index")
    public ModelAndView leader_Index(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/equipment/leader_index");
        return mav;
    }

    @RequestMapping("/leader_top")
    public ModelAndView leader_Top(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/equipment/leader_top");
        return mav;
    }

    @RequestMapping("/leader_welcome")
    public ModelAndView showLeaderWelcome(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/equipment/leader_welcome");
        int currentUserId = userService.getCurrentUserId();

        //获取当前用户需要进行审批的申请列表
        mav.addObject("pendingApplyList", getPendingApplyList(currentUserId));
        //获取通知列表
        mav.addObject("announcementList", getAnnouncementList());
        //获取消息列表
        MessageCriteria messageCriteria = new MessageCriteria();
        MessageCriteria.Criteria criteria2 = messageCriteria.createCriteria();
        criteria2.andReceiverIdEqualTo(currentUserId);
        messageCriteria.setOrderByClause("sendtime desc");
        List<Message> messageList = messageService.getMessageListByCriteia(messageCriteria);
        mav.addObject("messageList", messageList);

        return mav;
    }
    @RequestMapping("/top")
    public ModelAndView showUnreadMessage() {
        User currentUser = userService.getCurrentUser();
        MessageCriteria messageCriteria = new MessageCriteria();
        messageCriteria.setOrderByClause("sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
		criteria.andSystemEqualTo(false);
        criteria.andReceiverIdEqualTo(currentUser.getId());
        criteria.andIfreadEqualTo(false);
        int count = messageService.getCount(messageCriteria);
        ModelAndView mav = new ModelAndView("/equipment/top");
        mav.addObject("unreadCount", count);
        mav.addObject("user", currentUser);
        return mav;
    }

    int currPage = 0;

    @RequestMapping("/welcome_message")
    public ModelAndView showMessage(HttpServletRequest request) {
        int currentUserId = userService.getCurrentUserId();

        currPage = request.getParameter("page") == null ?
                (currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));

        MessageCriteria messageCriteria = new MessageCriteria();
        messageCriteria.setOrderByClause(" sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUserId);


        ObjectListPage<Message> pageInfo = messageService.selectListPage(currPage, messageCriteria);
        ModelAndView mav = new ModelAndView("/equipment/welcome");
        mav.addObject("messageLists", pageInfo.getListObject());
        mav.addObject("page", pageInfo.getPageInfo());

        return mav;
    }

    @RequestMapping("/welcome_announcement")
    public ModelAndView showAnnouncement(HttpServletRequest request) {
        currPage = request.getParameter("page") == null ?
                (currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));

        AnnouncementCriteria announcementCriteria = new AnnouncementCriteria();
        AnnouncementCriteria.Criteria criteria = announcementCriteria.createCriteria();

        criteria.andPublishLimitEqualTo(0);
        announcementCriteria.or(criteria);
        ObjectListPage<Announcement> pageInfo = announcementService.selectListPage(currPage, announcementCriteria);
        System.out.print(pageInfo.getListObject().size());
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
        mav.addObject("announcementDetailFlag", announcement);
        return mav;
    }

    @RequestMapping("/messageDetail")
    public ModelAndView getMessage(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("messageDetailId"));
        Message message = messageService.selectById(id);
        message.setIfread(true);
        messageService.updateByMessage(message);
        showUnreadMessage();
        ModelAndView mav = new ModelAndView("/equipment/jsp/announcement/remind/messagedetail");
        mav.addObject("messageDetailFlag", message);
        return mav;
    }


}
