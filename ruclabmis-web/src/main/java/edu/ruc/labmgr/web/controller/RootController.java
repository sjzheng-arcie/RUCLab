package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.service.UserService;

import edu.ruc.labmgr.utils.MD5.CipherUtil;
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

	//@Autowired
//	private ApplicationFormService applicationFormService;
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/index");
		return mav;
	}
	@RequestMapping("/top")
	public ModelAndView top(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/top");
		return mav;
	}
	private int stateId = 1;
//	@RequestMapping("/welcome")
//	public ModelAndView showWelcome(HttpServletRequest request) {
//
//		ModelAndView mav = new ModelAndView("/equipment/welcome");
//		User user = new User();
//		String loginName=SecurityUtils.getSubject().getPrincipal().toString();
//		user=userService.getUserByLoginSn(loginName);
//
//		ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
//		ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
//		criteria.andStateIdEqualTo(2);
//		criteria.andUserIdEqualTo(user.getId());
//		applicationFormCriteria.or(criteria);
//		List<ApplicationForm> myApplyList = applicationFormService.selectListByState( applicationFormCriteria);
//		mav.addObject("myApplyList",myApplyList );
//
//		ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
//		ApplicationFormCriteria.Criteria criteria02=applicationFormCriteria02.createCriteria();
//		criteria02.andStateIdEqualTo(0);
//		criteria02.andUserIdEqualTo(user.getId());
//		applicationFormCriteria.or(criteria);
//		List<ApplicationForm> pendingApplyList = applicationFormService.selectListByState(applicationFormCriteria02);
//		mav.addObject("pendingApplyList", pendingApplyList );
//		return mav;
//	}

	@RequestMapping("/admin_index")
	public ModelAndView admin_Index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/admin_index");
		return mav;
	}
	@RequestMapping("/admin_top")
	public ModelAndView adminTop(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/admin_top");
		return mav;
	}
//	@RequestMapping("/admin_welcome")
//	public ModelAndView showAdminWelcome(HttpServletRequest request) {
//		ModelAndView mav = new ModelAndView("/equipment/welcome");
//		User user = new User();
//		String loginName=SecurityUtils.getSubject().getPrincipal().toString();
//		user=userService.getUserByLoginSn(loginName);
//
//		ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
//		ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
//		criteria.andStateIdEqualTo(2);
//		criteria.andUserIdEqualTo(user.getId());
//		applicationFormCriteria.or(criteria);
//		List<ApplicationForm> myApplyList = applicationFormService.selectListByState( applicationFormCriteria);
//		mav.addObject("myApplyList",myApplyList );
//
//		ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
//		ApplicationFormCriteria.Criteria criteria02=applicationFormCriteria02.createCriteria();
//		criteria02.andStateIdEqualTo(0);
//		criteria02.andUserIdEqualTo(user.getId());
//		applicationFormCriteria.or(criteria);
//		List<ApplicationForm> pendingApplyList = applicationFormService.selectListByState(applicationFormCriteria02);
//		mav.addObject("pendingApplyList", pendingApplyList );
//		return mav;
//	}
	@RequestMapping("/teacher_index")
	public ModelAndView teacher_Index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/teacher_index");
		return mav;
	}
	@RequestMapping("/teacher_top")
	public ModelAndView teacher_top(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/teacher_top");
		return mav;
	}
//	@RequestMapping("/teacher_welcome")
//	public ModelAndView showTeacherWelcome(HttpServletRequest request) {
//
//		ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
//
//		ApplicationFormCriteria.Criteria criteria02=applicationFormCriteria02.createCriteria();
//
//		ModelAndView mav = new ModelAndView("/equipment/teacher_welcome");
//		criteria02.andStateIdEqualTo(0);
//		List<ApplicationForm> pendingApplyList = applicationFormService.selectListByState(applicationFormCriteria02);
//		mav.addObject("pendingApplyList", pendingApplyList );
//		return mav;
//	}
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

//	@RequestMapping("/leader_welcome")
//	public ModelAndView showLeaderWelcome(HttpServletRequest request) {
//		ModelAndView mav = new ModelAndView("/equipment/leader_welcome");
//		User user = new User();
//		String loginName=SecurityUtils.getSubject().getPrincipal().toString();
//		user=userService.getUserByLoginSn(loginName);
//
//		ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
//		ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
//		criteria.andStateIdEqualTo(2);
//		criteria.andUserIdEqualTo(user.getId());
//		applicationFormCriteria.or(criteria);
//		List<ApplicationForm> myApplyList = applicationFormService.selectListByState( applicationFormCriteria);
//		mav.addObject("myApplyList",myApplyList );
//
//		ApplicationFormCriteria applicationFormCriteria02 = new ApplicationFormCriteria();
//		ApplicationFormCriteria.Criteria criteria02=applicationFormCriteria02.createCriteria();
//		criteria02.andStateIdEqualTo(0);
//		criteria02.andUserIdEqualTo(user.getId());
//		applicationFormCriteria.or(criteria);
//		List<ApplicationForm> pendingApplyList = applicationFormService.selectListByState(applicationFormCriteria02);
//		mav.addObject("pendingApplyList", pendingApplyList );
//		return mav;
//	}

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
		if (currentUser.hasRole("administrators")) {


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


}
