package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/laboratory")
public class MessageCenterController {
    @Autowired
    AnnouncementService serviceAnnouncement;
    @Autowired
    MessageService messageService;
    @Autowired
    private UserService userService;
	@Autowired
	private CurriculumService curriculumService;

    private int currPage = 0;

	@RequestMapping(value = "/jsp/announcement/remind/{system}/message", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView showMessage(@PathVariable String system,
									@RequestParam(value = "page", required = true) int page) {
        int currentUserId = userService.getCurrentUserId();
        MessageCriteria messageCriteria = new MessageCriteria();
        messageCriteria.setOrderByClause(" sendtime desc");
        MessageCriteria.Criteria criteria = messageCriteria.createCriteria();
        criteria.andReceiverIdEqualTo(currentUserId);
		if(system.equals("laboratory")){
			criteria.andSystemEqualTo(true);
		}else {
			criteria.andSystemEqualTo(false);
		}
        PageInfo<Message> pageInfo = messageService.selectListPage(messageCriteria, page);


        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/message");
        mav.addObject("pageInfo", pageInfo);
		mav.addObject("fatherPage", "message");
        return mav;
    }

    @RequestMapping("/jsp/announcement/remind/{system}/unreadmessage")
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
    @RequestMapping("/jsp/announcement/remind/{system}/readmessage")
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
    @RequestMapping("/jsp/announcement/remind/{system}/replyMessage")
    public ModelAndView replyMessage(@PathVariable String system,HttpServletRequest request) {
        String replySn = request.getParameter("replyFlag");
		User userInfo= userService.getUserByLoginSn(replySn);
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/sendmessage");
        mav.addObject("replySn", replySn);
		mav.addObject("userInfo", userInfo);
        return mav;
    }
    @RequestMapping("/jsp/announcement/remind/{system}/mysendmessage")
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
    @RequestMapping("/jsp/announcement/remind/{system}/announcement")
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
		User currentUserInfo=userService.getCurrentUser();
        announcementCriteria.setOrderByClause(" publish_time desc");
		PageInfo<Announcement> pageInfo = serviceAnnouncement.selectListPage(announcementCriteria, currPage);
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/announcement");
        mav.addObject("pageInfo", pageInfo);
		mav.addObject("currentUserInfo", currentUserInfo);
        return mav;
    }

    @RequestMapping("/jsp/announcement/remind/{system}/toaddannouncement")
    public ModelAndView toaddAnnouncement(@PathVariable String system,HttpServletRequest request) {
		User user= userService.getCurrentUser();


        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/addannouncement");
		if(user.getRole().getName().equals("teacher")){
			List<Curriculum>curriculumList=curriculumService.getCurriculum("",user.getId(),true);
			mav.addObject("curriculumList",curriculumList);
		}
        return mav;
    }

    @RequestMapping("/jsp/announcement/remind/{system}/sendmessage")
    public ModelAndView sendMessage(@PathVariable String system,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/sendmessage");
		List<User> userList =userService.getAllUserList();
		mav.addObject("teacherList", userList);
        return mav;
    }


    @RequestMapping("/jsp/announcement/remind/{system}/addAnnouncement")
    public ModelAndView addAnnouncement(@PathVariable String system,HttpServletRequest request) {
        Announcement announcement = initFromRequest(request,system);
        int result = serviceAnnouncement.insert(announcement);
        ModelAndView mav = new ModelAndView("redirect:/laboratory/jsp/announcement/remind/"+system+"/announcement");
        return mav;
    }

    @RequestMapping("/jsp/announcement/remind/{system}/announcementDetail")
    public ModelAndView getAnnouncement(@PathVariable String system,HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("announcementDetailId"));
        Announcement announcement = serviceAnnouncement.getAnnouncementById(id);

        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/announcementdetail");
        mav.addObject("announcementDetailFlag", announcement);
        return mav;
    }
	@RequestMapping("/jsp/announcement/remind/{system}/toUpdateAnnouncement")
	public ModelAndView toUpdateAnnouncement(@PathVariable String system,HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("announcementId"));
		Announcement announcement = serviceAnnouncement.getAnnouncementById(id);
		ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/updateannouncement");
		mav.addObject("announcementInfo", announcement);
		return mav;
	}
	@RequestMapping("/jsp/announcement/remind/{system}/updateAnnouncement")
	public ModelAndView updateAnnouncement(@PathVariable String system,HttpServletRequest request) {
		int announcementId =Integer.parseInt(request.getParameter("announcementId"));
		String announcementTitle=request.getParameter("announcementTitle");
		String announcementContent = request.getParameter("content");
		Announcement announcement = serviceAnnouncement.getAnnouncementById(announcementId);
		announcement.setContent(announcementContent);
		announcement.setTitle(announcementTitle);
		announcement.setPublishTime(new Date());
		serviceAnnouncement.update(announcement);

		ModelAndView mav = new ModelAndView("redirect:/laboratory/jsp/announcement/remind/"+system+"/announcement");
		return mav;
	}

    @RequestMapping("/jsp/announcement/remind/{system}/messageDetail")
    public ModelAndView getMessage(@PathVariable String system,@RequestParam int messageDetailId,
								   @RequestParam(required = false,defaultValue = "1") int page,
								   @RequestParam(required = false,defaultValue = "message") String fatherPage) {
        Message message = messageService.selectById(messageDetailId);
        message.setIfread(true);
        messageService.updateByMessage(message);
        ModelAndView mav = new ModelAndView("/"+system+"/jsp/announcement/remind/messagedetail");
        mav.addObject("messageDetailFlag", message);
        mav.addObject("fatherPage", fatherPage);
        mav.addObject("page", page);
        return mav;
    }

    @RequestMapping("/jsp/announcement/remind/{system}/addMessage")
    public ModelAndView addMessage(@PathVariable String system,HttpServletRequest request) {
        Message message = insertMessageIntoDB(request,system);
        messageService.insert(message);
        ModelAndView mav = new ModelAndView("redirect:/laboratory/jsp/announcement/remind/"+system+"/message?page=1");
        return mav;
    }

    @RequestMapping("/jsp/announcement/remind/{system}/deleteMessage")
    public ModelAndView deleteMessage(@PathVariable String system,HttpServletRequest request) {
        int messageId = Integer.parseInt(request.getParameter("deleteMessageId"));
		String fatherPage=request.getParameter("fatherPage");
		int page =Integer.parseInt(request.getParameter("page"));
        messageService.deleteById(messageId);
        ModelAndView mav = new ModelAndView("redirect:/laboratory/jsp/announcement/remind/"+system+"/"+fatherPage+"?page="+page);
        return mav;
    }
	@RequestMapping("/jsp/announcement/remind/{system}/deleteAnnouncement")
	public ModelAndView deleteAnnouncement(@PathVariable String system,HttpServletRequest request) {
		int announcementId = Integer.parseInt(request.getParameter("announcementId"));
		int page =Integer.parseInt(request.getParameter("page"));
		serviceAnnouncement.deleteAnnouncementById(announcementId);
		ModelAndView mav = new ModelAndView("redirect:/laboratory/jsp/announcement/remind/"+system+"/announcement?page="+page);
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
        announcement.setTitle(request.getParameter("announcementTitle"));
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
