package edu.ruc.labmgr.web.controller.lab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: sjzheng
 * Date: 14-1-2
 * Time: 下午3:31
 * Des:
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/appointment")
public class AppointMentController {


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
