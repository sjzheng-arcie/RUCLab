package edu.ruc.labmgr.web.controller.equip;


import edu.ruc.labmgr.domain.Typecode;
import edu.ruc.labmgr.service.TypeCodeService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: sjzheng
 * Date: 13-11-4
 * Time: 下午5:30
 * Des:
 */
@Controller
@RequestMapping("/equipment/jsp/sys/typecode")
public class TypeCodeController {
	@Autowired
	private TypeCodeService typeService;
	@RequestMapping(value = "/list")
	public ModelAndView list(){
		return pageList(null,null,1);
	}
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public ModelAndView pageList(@RequestParam("searchId")String code,@RequestParam("searchName")String name,
								 @RequestParam("page")int PageNum){
		ModelAndView view = new ModelAndView("/equipment/jsp/sys/typecode/list");
		PageInfo<Typecode> pageInfo = typeService.selectListPage(code,name,PageNum);
		view.addObject("pageInfo",pageInfo);
		return  view;


	}
}
