package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.Major;
import edu.ruc.labmgr.domain.TermYear;
import edu.ruc.labmgr.service.SchoolCalenderService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * User: sjzheng
 * Date: 13-12-26
 * Time: 下午2:32
 * Des:
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/bas/calendar")
public class SchoolCalenderController {
	@Autowired
	private SchoolCalenderService schoolCalenderService;

	@RequestMapping(value ="/list",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getPageCalenderList(@RequestParam(required = false,defaultValue = "1")int page){
		ModelAndView view = new ModelAndView("/laboratory/jsp/bas/calendar/list");
		PageInfo<TermYear>  pageInfo = schoolCalenderService.getPageListbyNum(page);
		view.addObject("pageInfo",pageInfo);
		return view;
	}
	@RequestMapping(value = "toUpdate",method = RequestMethod.GET)
	public ModelAndView toUpdateCalender(@RequestParam int id){
		ModelAndView view = new ModelAndView("/laboratory/jsp/bas/calendar/update");
		TermYear termYear = schoolCalenderService.getTermYearByPk(id);
		view.addObject("termYear",termYear);
		return  view;

	}
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(TermYear termYear){
		schoolCalenderService.updateTermYear(termYear);
		return "redirect:/laboratory/jsp/bas/calendar/list";
	}
	@RequestMapping(value = "/toAdd", method = RequestMethod.GET)
	public ModelAndView toAdd() {
		ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/calendar/add");
				return mav;
	}
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String addTermYear(TermYear termYear){
		schoolCalenderService.addTerYear(termYear);
		return "redirect:/laboratory/jsp/bas/calendar/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("items") List<Integer> items) {
		for (int id : items) {
			schoolCalenderService.deleteTermYear(id);
		}
		return "redirect:/laboratory/jsp/bas/calendar/list";
	}

}
