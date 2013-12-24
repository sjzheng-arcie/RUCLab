package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.AnnouncementService;
import edu.ruc.labmgr.service.MessageService;
import edu.ruc.labmgr.service.StudentService;
import edu.ruc.labmgr.service.TeacherService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/messagecenter")
public class MessageCenterController {
    @Autowired
    AnnouncementService serviceAnnouncement;
    @Autowired
    MessageService messageService;
    @Autowired
    private TeacherService userService;

    private int currPage = 0;

	@RequestMapping("/{system}/jsp/announcement/remind/message")
    public ModelAndView showMessage(@PathVariable String system,HttpServletRequest request) {
        int currentUserId = userService.getCurrentUserId();
        currPage = request.getParameter("page") == null ?
                (currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));
		currPage=currPage > 0 ? currPage : 1;
        String fatherPage = request.getParameter("fatherPage");
        MessageCriteria messageCriteria = new MessageCriteria();
        messageCriteria.setOrderByClause(" sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUserId);
		if(system.equals("laboratory")){
			criteria.andSystemEqualTo(true);
		}else {
			criteria.andSystemEqualTo(false);
		}
        PageInfo<Message> pageInfo = messageService.selectListPage(messageCriteria, currPage);

        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/message");
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("fatherPage", fatherPage);
        return mav;
    }

    @RequestMapping("/{system}/jsp/announcement/remind/unreadmessage")
    public ModelAndView showUnreadMessage(@PathVariable String system,HttpServletRequest request) {
        int userId = userService.getCurrentUserId();

        currPage = request.getParameter("page") == null ?
                (currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));
		currPage=currPage > 0 ? currPage : 1;
        String fatherPage = request.getParameter("fatherPage");
        MessageCriteria messageCriteria = new MessageCriteria();
        messageCriteria.setOrderByClause(" sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(userId);
        criteria.andIfreadEqualTo(false);
		if(system.equals("laboratory")){
			criteria.andSystemEqualTo(true);
		}else {
			criteria.andSystemEqualTo(false);
		}

        PageInfo<Message> pageInfo = messageService.selectListPage(messageCriteria, currPage);
        if (pageInfo.getTotalPage() < currPage) {
            pageInfo = messageService.selectListPage(messageCriteria, currPage - 1);
        }
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/message");
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("fatherPage", fatherPage);
        return mav;
    }
    @RequestMapping("/{system}/jsp/announcement/remind/readmessage")
    public ModelAndView showReadMessage(@PathVariable String system,HttpServletRequest request) {
        int currentUserId = userService.getCurrentUserId();
        currPage = request.getParameter("page") == null ?
                (currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));
		currPage=currPage > 0 ? currPage : 1;
        String fatherPage = request.getParameter("fatherPage");
        MessageCriteria messageCriteria = new MessageCriteria();
        messageCriteria.setOrderByClause(" sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUserId);
        criteria.andIfreadEqualTo(true);
		if(system.equals("laboratory")){
			criteria.andSystemEqualTo(true);
		}else {
			criteria.andSystemEqualTo(false);
		}
        PageInfo<Message> pageInfo = messageService.selectListPage(messageCriteria, currPage);
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/message");
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("fatherPage", fatherPage);
        return mav;
    }
    @RequestMapping("/{system}/jsp/announcement/remind/replyMessage")
    public ModelAndView replyMessage(@PathVariable String system,HttpServletRequest request) {
        String replySn = request.getParameter("replyFlag");
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/sendmessage");
        mav.addObject("tabId", 3);
        mav.addObject("replySn", replySn);
        return mav;
    }
    @RequestMapping("/{system}/jsp/announcement/remind/mysendmessage")
    public ModelAndView showMySendMessage(@PathVariable String system,HttpServletRequest request) {
        int currentUserId = userService.getCurrentUserId();

        currPage = request.getParameter("page") == null ?
                (currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));
		currPage=currPage > 0 ? currPage : 1;
        String fatherPage = request.getParameter("fatherPage");
        MessageCriteria messageCriteria = new MessageCriteria();
        messageCriteria.setOrderByClause(" sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andSenderIdEqualTo(currentUserId);
        criteria.andIfreadEqualTo(true);
		if(system.equals("laboratory")){
			criteria.andSystemEqualTo(true);
		}else {
			criteria.andSystemEqualTo(false);
		}
        PageInfo<Message> pageInfo = messageService.selectListPage(messageCriteria, currPage);
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/message");
		mav.addObject("pageInfo", pageInfo);
        mav.addObject("mode", "mode");
        mav.addObject("fatherPage", fatherPage);
        return mav;
    }
    @RequestMapping("/{system}/jsp/announcement/remind/announcement")
    public ModelAndView showAnnouncement(@PathVariable String system,HttpServletRequest request) {
        currPage = request.getParameter("page") == null ?
                (currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));
		currPage=currPage > 0 ? currPage : 1;
        AnnouncementCriteria announcementCriteria = new AnnouncementCriteria();
        AnnouncementCriteria.Criteria criteria = announcementCriteria.createCriteria();
		if(system.equals("laboratory")){
			criteria.andSystemEqualTo(true);
		}else {
			criteria.andSystemEqualTo(false);
		}
        announcementCriteria.setOrderByClause(" publish_time desc");
		PageInfo<Announcement> pageInfo = serviceAnnouncement.selectListPage(announcementCriteria, currPage);
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/announcement");
        mav.addObject("pageInfo", pageInfo);
        return mav;
    }

    @RequestMapping("/{system}/jsp/announcement/remind/toaddannouncement")
    public ModelAndView toaddAnnouncement(@PathVariable String system,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/addannouncement");
        return mav;
    }

    @RequestMapping("/{system}/jsp/announcement/remind/sendmessage")
    public ModelAndView sendMessage(@PathVariable String system,HttpServletRequest request) {
        String replySn = request.getParameter("replyFlag");
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/sendmessage");
        if (replySn != null && replySn != "")
            mav.addObject("replySn", replySn);
        List<Teacher> teacherList = userService.getAllTeacherList();
        mav.addObject("teacherList", teacherList);
        return mav;
    }


    @RequestMapping("/{system}/jsp/announcement/remind/addAnnouncement")
    public ModelAndView addAnnouncement(@PathVariable String system,HttpServletRequest request) {
        Announcement announcement = initFromRequest(request,system);
        int result = serviceAnnouncement.insert(announcement);
        ModelAndView mav = new ModelAndView("redirect:/messagecenter/"+system+"/jsp/announcement/remind/announcement");
        return mav;
    }

    @RequestMapping("/{system}/jsp/announcement/remind/announcementDetail")
    public ModelAndView getAnnouncement(@PathVariable String system,HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("announcementDetailId"));
        Announcement announcement = serviceAnnouncement.getAnnouncementById(id);

        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/announcementdetail");
        mav.addObject("announcementDetailFlag", announcement);
        return mav;
    }

    @RequestMapping("/{system}/jsp/announcement/remind/messageDetail")
    public ModelAndView getMessage(@PathVariable String system,HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("messageDetailId"));
        currPage = request.getParameter("page") == null ?
                (currPage > 0 ? currPage : 1) : Integer.parseInt(request.getParameter("page"));
		currPage=currPage > 0 ? currPage : 1;
        String fatherPage = request.getParameter("fatherPage");
        Message message = messageService.selectById(id);
        message.setIfread(true);
        messageService.updateByMessage(message);
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/messagedetail");
        mav.addObject("messageDetailFlag", message);
        mav.addObject("fatherPage", fatherPage);
        mav.addObject("page", currPage);
        return mav;
    }

    @RequestMapping("/{system}/jsp/announcement/remind/addMessage")
    public ModelAndView addMessage(@PathVariable String system,HttpServletRequest request) {
        Message message = insertMessageIntoDB(request,system);
        messageService.insert(message);
        ModelAndView mav = new ModelAndView("redirect:/messagecenter/"+system+"/jsp/announcement/remind/message");
        return mav;
    }

    @RequestMapping("/{system}/jsp/announcement/remind/deleteMessage")
    public ModelAndView deleteMessage(@PathVariable String system,HttpServletRequest request) {
        int messageId = Integer.parseInt(request.getParameter("deleteMessageId"));
        messageService.deleteById(messageId);
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/message");
        mav.addObject("tabId", 1);
        return mav;
    }

    private Announcement initFromRequest(HttpServletRequest request,String system) {
        int currentUserId = userService.getCurrentUserId();
        Announcement announcement = new Announcement();
        announcement.setContent(request.getParameter("content"));
        announcement.setPublisherId(currentUserId);
        if (request.getParameter("limit") != null) {
            announcement.setPublishLimit(Integer.parseInt(request.getParameter("limit")));
        } else {
            announcement.setPublishLimit(0);
        }
		if(system.equals("laboratory")){
			announcement.setSystem(true);
		}else{
			announcement.setSystem(false);
		}
        announcement.setTitle(request.getParameter("title"));
        announcement.setPublishTime(new Date());
        return announcement;
    }

    private Message insertMessageIntoDB(HttpServletRequest request,String system) {
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
		if(system.equals("laboratory")){
			message.setSystem(true);
		}else{
			message.setSystem(false);
		}
        return message;
    }

    public ModelAndView showUnreadMessage(String system) {
        User currentUser = userService.getCurrentUser();

        MessageCriteria messageCriteria = new MessageCriteria();
        messageCriteria.setOrderByClause("sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUser.getId());
        criteria.andIfreadEqualTo(false);
		if(system.equals("laboratory")){
			criteria.andSystemEqualTo(true);
		}else {
			criteria.andSystemEqualTo(false);
		}
        int count = messageService.getCount(messageCriteria);
        ModelAndView mav = new ModelAndView("/"+system+"/top");
        mav.addObject("unreadCount", count);
        mav.addObject("user", currentUser);
        return mav;
    }


}
