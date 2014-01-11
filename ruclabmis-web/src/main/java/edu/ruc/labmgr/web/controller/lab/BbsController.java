package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.BbsReply;
import edu.ruc.labmgr.domain.BbsTopic;
import edu.ruc.labmgr.domain.CurriculumClass;
import edu.ruc.labmgr.service.BbsService;
import edu.ruc.labmgr.service.CurriculumClassService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * User: sjzheng
 * Date: 13-12-16
 * Time: 下午2:41
 * Des:
 */
@Controller
@RequestMapping(value = "/laboratory/bbs")
public class BbsController {
	@Autowired
	CurriculumClassService curriculumClassService;
	@Autowired
	UserService userService;
	@Autowired
	BbsService bbsService;
	@RequestMapping(value = "/left",method = RequestMethod.GET)
	public ModelAndView getLeftCouselist(){
		ModelAndView view = new ModelAndView("/laboratory/bbs/left");
		Subject currentUser = SecurityUtils.getSubject();
		int id = userService.getCurrentUserId();
		List<CurriculumClass>  courseList = new ArrayList<CurriculumClass>();
		if(currentUser.hasRole("student")){
			courseList =curriculumClassService.getClassByCriteriaUserIdAndRole(id, Types.Role.STUDENT);
		}else if (currentUser.hasRole("administrators")||currentUser.hasRole("lab_admin")){
			courseList = curriculumClassService.getClassByCriteriaUserIdAndRole(id, Types.Role.ADMIN);
		}else
			courseList = curriculumClassService.getClassByCriteriaUserIdAndRole(id, Types.Role.TEACHER);
		view.addObject("courseList",courseList);
		return  view;
	}
	@RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getSessionList (@RequestParam(defaultValue = "1") int page,@RequestParam("courseId")int curricumClassId){
		ModelAndView view = new ModelAndView("/laboratory/bbs/list");
		PageInfo<BbsTopic> bbsTopicPageInfo = bbsService.getPageTopicbyCouseId(curricumClassId, page);

		view.addObject("pageInfo",bbsTopicPageInfo);
		String sessionTitle  = bbsService.getSessionTitleByCouseId(curricumClassId);
		view.addObject("title",sessionTitle);
		view.addObject("courseId",curricumClassId);
		return view;
	}
	@RequestMapping(value = "/frame",method = RequestMethod.GET)
	public ModelAndView getFrameTopicList(){

		ModelAndView view = new ModelAndView("/laboratory/bbs/frame");

		Subject currentUser = SecurityUtils.getSubject();
		int id = userService.getCurrentUserId();
		List<Integer> sids = null;
		if(currentUser.hasRole("student")){
			sids =curriculumClassService.getPrivateSessionIds(id, Types.Role.STUDENT);
		}else if (currentUser.hasRole("administrators")||currentUser.hasRole("lab_admin")){
			sids = curriculumClassService.getPrivateSessionIds(id, Types.Role.ADMIN);
		}else
			sids = curriculumClassService.getPrivateSessionIds(id, Types.Role.TEACHER);


		List<BbsTopic> daylyHotPostList = new ArrayList<BbsTopic>();
		List<BbsTopic> weeklyHotPostList = new ArrayList<BbsTopic>();
		List<BbsTopic> newestTopicList = new ArrayList<BbsTopic>();
		List<BbsTopic> lastReplylistList = new ArrayList<BbsTopic>();
		if(sids!=null && sids.size()>0){
			daylyHotPostList = bbsService.getTodayHotList(sids);
			weeklyHotPostList = bbsService.getWeekHotList(sids);
			newestTopicList = bbsService.getNewestCreatList(sids);
			lastReplylistList = bbsService.getNewestReplyList(sids);
		}

		view.addObject("daylyHotPostList",daylyHotPostList);
		view.addObject("weeklyHotPostList",weeklyHotPostList);
		view.addObject("newestTopicList",newestTopicList);
		view.addObject("lastReplylistList",lastReplylistList);
		return  view;
	}
	@RequestMapping(value = "/topost",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView toPostTopic(@RequestParam("courseId")int sessionId){
		ModelAndView view = new ModelAndView("/laboratory/bbs/post");
		view.addObject("courseId",sessionId);
		return  view;

	}
	@RequestMapping(value = "/postTopic", method = RequestMethod.POST)
	public String  PostTopic(BbsTopic topic ){
		int uid = userService.getCurrentUserId();
		topic.setUid(uid);
		bbsService.insertTopic(topic);
			int sessionid = topic.getSessionid();
	//	return  listSessionTopic(sessionid);
		return "redirect:/laboratory/bbs/list?courseId="+sessionid;
	}
	@RequestMapping(value = "/addReply",method = RequestMethod.POST)
	public  String  addReply(@RequestParam int topicId,BbsReply bbsReply,
								  @RequestParam  int sessionId){

		int replyuserId = userService.getCurrentUserId();
		bbsService.insertReply(bbsReply,topicId,replyuserId);
		return "redirect:/laboratory/bbs/list?courseId="+sessionId;

	}
	@RequestMapping(value = "/detail",method = RequestMethod.GET)
	public ModelAndView getTopicDetail(@RequestParam(value = "sessionId",required = false)int SessionId,
									   @RequestParam int topicId,
									   @RequestParam(required = false,defaultValue = "1")int page){
		ModelAndView view = new ModelAndView("/laboratory/bbs/detail");

		BbsTopic bbsTopic = bbsService.selectTopicByPrimaryKey(topicId);
		String sessionTitle  = bbsService.getSessionTitleByCouseId(bbsTopic.getSessionid());
		int posterId = bbsTopic.getUid();
		String poster = userService.getUserNamebyId(posterId);
		String userSn= userService.getUserSnbyId(posterId);
		PageInfo<BbsReply> pageInfo = bbsService.getPageReplyByTopicId(topicId,page);
		String currentSn = userService.getCurrentUser().getSn();
		view.addObject("bbsTopic",bbsTopic);
		view.addObject("sessionTitle",sessionTitle);
		view.addObject("poster",poster);
		view.addObject("role",userService.getUserbyId(posterId).getRole().getName());
		view.addObject("userSn",userSn);
		view.addObject("pageInfo",pageInfo);
		view.addObject("currentSn",currentSn);
		return view;

	}
	@RequestMapping(value = "/toupdatetopic",method = RequestMethod.GET)
	public ModelAndView toUpdateTopic(@RequestParam int topicId,@RequestParam int sessionId){
		ModelAndView view = new ModelAndView("/laboratory/bbs/update");
		BbsTopic bbsTopic = bbsService.selectTopicByPrimaryKey(topicId);
		 view.addObject("bbsTopic",bbsTopic);
		return  view;

	}
	@RequestMapping(value = "/toupdatereply",method = RequestMethod.GET)
	public ModelAndView toUpdateReply(@RequestParam int replyId,@RequestParam int topicId,
						@RequestParam int sessionId){
		ModelAndView view = new ModelAndView("/laboratory/bbs/updatereply");
		BbsReply reply = bbsService.selectReplyByPrimaryKey(replyId);
		view.addObject("bbsReply",reply);
		view.addObject("sessionId",sessionId);
		return  view;

	}

	@RequestMapping(value = "/updateTopic",method = RequestMethod.POST)
	public String  updateTopic(BbsTopic bbsTopic,@RequestParam int topicId){
		bbsTopic.setId(topicId);
		bbsService.updateTopicByPrimarySelective(bbsTopic);
		BbsTopic result = bbsService.selectTopicByPrimaryKey(topicId);
		int sessionid = result.getSessionid();
		return "redirect:/laboratory/bbs/list?courseId="+sessionid;


	}
	@RequestMapping(value = "/updateReply",method =  RequestMethod.POST)
	public String  updateReply(BbsReply bbsReply,@RequestParam int replyId,
									@RequestParam int sessionId){
		bbsReply.setId(replyId);
		bbsService.updateReplyByPrimarySelective(bbsReply);
		return "redirect:/laboratory/bbs/list?courseId="+sessionId;

	}
	@RequestMapping(value = "/deletetopic",method = RequestMethod.GET)
	public String  deleteTopic(@RequestParam int topicId,@RequestParam int sessionId){

		bbsService.deleteTopicAndReplyByPrimaryKey(topicId);
		return "redirect:/laboratory/bbs/list?courseId="+sessionId;

	}
	@RequestMapping(value ="/deletereply",method = RequestMethod.GET)
	public String  deleteReply(int replyId,int topicId,int sessionId){
		bbsService.deleteReplyByPrimaryKey(replyId);
		return "redirect:/laboratory/bbs/list?courseId="+sessionId;

	}
	@RequestMapping(value = "/laboratory/bbs/clickCount",method = RequestMethod.POST)
	public String  addClickCount(String topicUid){
		return topicUid;

	}
	@RequestMapping(value ="/index")
	public ModelAndView indexInIndex() {

		ModelAndView mav = new ModelAndView("/laboratory/bbs/index");
		return mav;
	}



}
