package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.CurriculumClass;
import edu.ruc.labmgr.service.CurriculumClassService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: sjzheng
 * Date: 13-12-2
 * Time: 下午3:55
 * Des:
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/experiment/experiment")
public class ExperimentInfoController {
	@Autowired
	private CurriculumClassService classService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/courselist",method = RequestMethod.GET)
	public ModelAndView courseList(@RequestParam int page){
		ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/experiment/courselist");
		Subject currentUser = SecurityUtils.getSubject();
		int id = userService.getCurrentUserId();
		PageInfo<CurriculumClass> pageInfo = null;
		if(currentUser.hasRole("student"))
			 pageInfo = classService.getPageClassbyPageNum(page,id,true);
		else
			pageInfo = classService.getPageClassbyPageNum(page,id,false);
		mv.addObject("pageInfo", pageInfo);
		return mv;
	}
}
