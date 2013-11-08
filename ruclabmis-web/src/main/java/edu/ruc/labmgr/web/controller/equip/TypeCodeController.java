package edu.ruc.labmgr.web.controller.equip;


import edu.ruc.labmgr.domain.Title;
import edu.ruc.labmgr.domain.Typecode;
import edu.ruc.labmgr.service.TypeCodeService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * User: sjzheng
 * Date: 13-11-4
 * Time: 下午5:30
 * Des:
 */
@Controller
@RequestMapping("/equipment/jsp/sys/typecode")
public class TypeCodeController {
	int currentPage = 1;
	@Autowired
	private TypeCodeService typeService;
	@RequestMapping(value = "/list")
	public ModelAndView list(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/equipment/jsp/sys/typecode/list");
		PageInfo<Typecode> pageInfo = typeService.selectListPage(null,null,currentPage);
		view.addObject("pageInfo",pageInfo);
		return view;
	}
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public ModelAndView pageList(@RequestParam("searchId")String code,@RequestParam("searchName")String name,
								 @RequestParam("page")int PageNum){
		currentPage = PageNum;
		ModelAndView view = new ModelAndView("/equipment/jsp/sys/typecode/list");
		PageInfo<Typecode> pageInfo = typeService.selectListPage(code,name,PageNum);
		view.addObject("pageInfo",pageInfo);
		return  view;
		}
	@RequestMapping(value = "/toAdd",method = RequestMethod.GET)
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/equipment/jsp/sys/typecode/add");
		return mav;
	}
	@RequestMapping(value= "/add",method = RequestMethod.POST)
	public String Add(Typecode typecode){
		typeService.insert(typecode);

		return "redirect:/equipment/jsp/sys/typecode/list" ;

	}
	@RequestMapping(value = "/toUpdate",method = RequestMethod.POST)
	public ModelAndView toUpdate(@RequestParam("id")int id){
		Typecode typecode = typeService.selectByPrimerKey(id);
		ModelAndView mav =  new ModelAndView("/equipment/jsp/sys/typecode/update");
		mav.addObject("typecode",typecode);
		return mav;

	}
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String  Update(Typecode title){
		typeService.update(title);
		return "redirect:/equipment/jsp/sys/typecode/list";
	}
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public String delete(@RequestParam("items")List<Integer> ids){
		typeService.delete(ids);
		return "redirect:/equipment/jsp/sys/typecode/list";

	}
}
