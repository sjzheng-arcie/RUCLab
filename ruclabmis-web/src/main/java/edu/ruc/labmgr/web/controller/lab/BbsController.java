package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.CurriculumClass;
import edu.ruc.labmgr.service.CurriculumClassService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.Types;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping(value = "/left",method = RequestMethod.GET)
	public ModelAndView getLeftCouselist(){
		ModelAndView view = new ModelAndView("/laboratory/bbs/left");
		Subject currentUser = SecurityUtils.getSubject();
		int id = userService.getCurrentUserId();
		List<CurriculumClass>  courseList = new ArrayList<CurriculumClass>();
		if(currentUser.hasRole("student")){
			courseList =curriculumClassService.getClassByCriteriaUserIdAndRole(id, Types.Role.STUDENT);
		}else if (currentUser.hasRole("administrator")||currentUser.hasRole("lab_admin")){
			courseList = curriculumClassService.getClassByCriteriaUserIdAndRole(id, Types.Role.ADMIN);
		}else
			courseList = curriculumClassService.getClassByCriteriaUserIdAndRole(id, Types.Role.TEACHER);
		view.addObject("courseList",courseList);
		return  view;
	}


}
