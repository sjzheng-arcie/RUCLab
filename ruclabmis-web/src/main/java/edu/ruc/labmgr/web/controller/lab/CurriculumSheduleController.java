package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-31
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/curriculum")
public class CurriculumSheduleController {
	@Autowired
	UserService userService;
	@Autowired
	CurriculumScheduleService curriculumScheduleService;
	@Autowired
	CurriculumClassService curriculumClassService;
	@Autowired
	SchoolCalenderService schoolCalenderService;



	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("items") List<Integer> items) {
		return "redirect:/laboratory/jsp/bas/curriculum/list";
	}
	@RequestMapping(value = "/curriculumclasslist", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView curriculumClassList(@RequestParam(required = false,defaultValue = "") String roomName,
											@RequestParam(value="page",required = false,defaultValue = "1") int page){

		PageInfo<CurriculumClass> pageInfo=curriculumClassService.getPageClasses(page, null, null);
		List<CurriculumClass> curriculumClassList=pageInfo.getData();
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/curriculumclasslist");
		mav.addObject("curriculumClassList",curriculumClassList);
		return mav;
	}
	@RequestMapping(value = "/newcurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView newCurriculumSchedule(@RequestParam(value="page",required = false,defaultValue = "1") int page){

		List<CurriculumClass> curriculumClassList=curriculumClassService.getAllCurriculumClass();
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();

		//List<TermYear> termYearList=schoolCalenderService.getPageListbyNum()
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/newcurriculumschedule");
		mav.addObject("curriculumClassList",curriculumClassList);
		mav.addObject("termYearList",termYearList);
		return mav;
	}
	@RequestMapping(value = "/addlession", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addLession(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/addlession");
		return mav;
	}
	@RequestMapping(value = "/createcurriculum", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView createCurriculum(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/createcurriculum");
		return mav;
	}

	@RequestMapping(value = "/curriculum", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView Curriculum(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/curriculum");
		return mav;
	}
	@RequestMapping(value = "/curriculumclasslist-bak", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView curriculumClassListBak(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/curriculumclasslist-bak");
		return mav;
	}

	@RequestMapping(value = "/curriculumview", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView curriculumview(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/curriculumview");
		return mav;
	}

	@RequestMapping(value = "/importcurriculum", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView importcurriculum(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/importcurriculum");
		return mav;
	}

	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView list(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/list");
		return mav;
	}

	@RequestMapping(value = "/listapply", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView listApply(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/listapply");
		return mav;
	}

	@RequestMapping(value = "/listcommit", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView listCommit(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/listcommit");
		return mav;
	}

	@RequestMapping(value = "/mycurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mycurriculumschedule(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/mycurriculumschedule");
		return mav;
	}

	@RequestMapping(value = "/setcurriculum", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView setcurriculum(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/setcurriculum");
		return mav;
	}

	@RequestMapping(value = "/setlab", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView setlab(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/setlab");
		return mav;
	}

	@RequestMapping(value = "/toaddlession", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView toaddlession(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/toaddlession");
		return mav;
	}
	@RequestMapping(value = "/view", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView view(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/view");
		return mav;
	}
}

