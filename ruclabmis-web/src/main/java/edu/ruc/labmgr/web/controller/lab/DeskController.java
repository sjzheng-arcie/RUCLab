package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.Desk;
import edu.ruc.labmgr.domain.DeskCriteria;
import edu.ruc.labmgr.service.DeskService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-18
 * Time: 上午9:59
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping(value = "/laboratory/jsp/lab/desk")
public class DeskController {
	@Autowired
	private DeskService deskService;


	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(@RequestParam(required = false,defaultValue = "") String deskName,
							 @RequestParam(value = "page", required = false, defaultValue = "1") int page){
		DeskCriteria roomCriteria=new DeskCriteria();
		DeskCriteria.Criteria criteria=roomCriteria.createCriteria();
		criteria.andNameLike("%"+deskName+"%");

		PageInfo<Desk> pageInfo =deskService.selectListPage(roomCriteria,page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/desk/list");
		modelAndView.addObject("pageInfo",pageInfo);
		return modelAndView;
	}
}
