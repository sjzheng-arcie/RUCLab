package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.AnnouncementService;
import edu.ruc.labmgr.service.ApplicationFormService;
import edu.ruc.labmgr.service.MessageService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.MD5.CipherUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/equipment/jsp/welcomelink/myapplyinfo")
public class HomeLinkController {

	@Autowired
	private ApplicationFormService applicationFormService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private AnnouncementService announcementService;


		@RequestMapping(value = "/searchmyapplylist",method = RequestMethod.POST)
	public ModelAndView searchAllMyApplyList(@RequestParam("page") int page,@RequestParam("applyNo") String applyNo,@RequestParam("formType") int formType) {
		ModelAndView mav = new ModelAndView("/equipment/jsp/welcomelink/applyinfo/myapplyList");
		User user = new User();
		String loginName=SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
		criteria.andApplicantIdEqualTo(user.getId());
		if(applyNo!=null&&applyNo!=""){
			criteria.andSnLike(applyNo);
		}
		if(formType!=0){
			criteria.andTypeEqualTo(formType);
		}
		applicationFormCriteria.setOrderByClause(" apply_time desc");

		PageInfo<ApplicationForm> pageInfo =  applicationFormService.selectListPage( applicationFormCriteria,page);

		mav.addObject("pageInfo",pageInfo);
		return mav;
	}
	@RequestMapping(value = "/allmyapplylist",method = RequestMethod.GET)
	public ModelAndView showAllMyApplyList(HttpServletRequest request) {

		int page=1;

		ModelAndView mav = new ModelAndView("/equipment/jsp/welcomelink/applyinfo/myapplyList");
		User user = new User();
		String loginName=SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
		criteria.andApplicantIdEqualTo(user.getId());
		applicationFormCriteria.setOrderByClause(" apply_time desc");
		PageInfo<ApplicationForm> pageInfo =  applicationFormService.selectListPage( applicationFormCriteria,page);

		mav.addObject("pageInfo",pageInfo);
		return mav;
	}
	@RequestMapping(value = "/allpendinglist",method = RequestMethod.GET)
	public ModelAndView showAllPendingList(HttpServletRequest request) {

		int page=1;

		ModelAndView mav = new ModelAndView("/equipment/jsp/welcomelink/applyinfo/pendinglist");
		User user = new User();
		String loginName=SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
		criteria.andApproverIdEqualTo(user.getId());
		criteria.andStateIdEqualTo(32);

		applicationFormCriteria.setOrderByClause(" apply_time desc");
		PageInfo<ApplicationForm> pageInfo =  applicationFormService.selectListPage( applicationFormCriteria,page);

		mav.addObject("pageInfo",pageInfo);
		return mav;
	}
	@RequestMapping(value = "/searchpendinglist",method = RequestMethod.POST)
	public ModelAndView searchAllPendingList(@RequestParam("page") int page,@RequestParam("applyNo") String applyNo,@RequestParam("formType") int formType) {
		ModelAndView mav = new ModelAndView("/equipment/jsp/welcomelink/applyinfo/pendinglist");
		User user = new User();
		String loginName=SecurityUtils.getSubject().getPrincipal().toString();
		user=userService.getUserByLoginSn(loginName);
		ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
		ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
		criteria.andApproverIdEqualTo(user.getId());
		criteria.andStateIdEqualTo(32);
		if(applyNo!=null&&applyNo!=""){
			criteria.andSnLike(applyNo);
		}
		if(formType!=0){
			criteria.andTypeEqualTo(formType);
		}
		applicationFormCriteria.setOrderByClause(" apply_time desc");
		PageInfo<ApplicationForm> pageInfo =  applicationFormService.selectListPage( applicationFormCriteria,page);

		mav.addObject("pageInfo",pageInfo);
		return mav;
	}


}
