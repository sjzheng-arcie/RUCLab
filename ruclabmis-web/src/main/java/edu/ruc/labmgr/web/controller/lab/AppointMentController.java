package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.Arrangement;
import edu.ruc.labmgr.domain.CurriculumSchedule;
import edu.ruc.labmgr.service.ArrangementService;
import edu.ruc.labmgr.service.CurriculumScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: sjzheng
 * Date: 14-1-2
 * Time: 下午3:31
 * Des:
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/appointment")
@SessionAttributes({"arrange","schedule"})
public class AppointMentController {
	@Autowired
	CurriculumScheduleService curriculumScheduleService;
	@Autowired
	ArrangementService arrangementService;


	@RequestMapping
	public String step1(final ModelMap modelMap){
		modelMap.addAttribute("arrange", new Arrangement());
		modelMap.addAttribute("schedule", new CurriculumSchedule());
		return "step1";
	}



	@RequestMapping(params = "_step=2")
	public String step2(final @ModelAttribute("arrange") Arrangement arrangement,
						final @ModelAttribute("schedule")CurriculumSchedule  curriculumSchedule,
						final Errors errors){
		return "step2";
	}

	@RequestMapping(params = "_finish")
	public String processFinish( @ModelAttribute("arrange") Arrangement arrangement,
								 @ModelAttribute("schedule")CurriculumSchedule  curriculumSchedule,
								 final Errors errors,
								 final ModelMap modelMap,
								 final SessionStatus status){

		//	beanService.add(bean);
		status.setComplete();
		return "success";
	}

	@RequestMapping(params = "_cancel")
	public String processCancel(final HttpServletRequest request,
								final HttpServletResponse response,
								final SessionStatus status){
		status.setComplete();
		return "cancel";
	}


	@RequestMapping(value = "/laboratory/appointmentbaseinfo")
	public ModelAndView appointmentBaseInfo() {
		ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentbaseinfo");
		return mav;
	}
	@RequestMapping(value ="/laboratory/appointmentdate",method = RequestMethod.GET)
	public ModelAndView appointdate(){
		ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentdate");
		return mav;
	}
	@RequestMapping(value ="/laboratory/appointmentdatecontent",method = RequestMethod.GET)
		 public ModelAndView appointmentdatecontent(){
		ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentdatecontent");
		return mav;
	}
	@RequestMapping(value ="/laboratory/laboratoryapply",method = RequestMethod.GET)
	public ModelAndView laboratoryapply(){
		ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/laboratoryapply");
		return mav;
	}
	@RequestMapping(value ="/laboratory/appointmentinfosubmit",method = RequestMethod.GET)
		 public ModelAndView appointmentinfosubmit(){
		ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentinfosubmit");
		return mav;
	}
	@RequestMapping(value ="/laboratory/mydatelist",method = RequestMethod.GET)
	public ModelAndView mydatelist(){
		ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/mydatelist");
		return mav;
	}

}
