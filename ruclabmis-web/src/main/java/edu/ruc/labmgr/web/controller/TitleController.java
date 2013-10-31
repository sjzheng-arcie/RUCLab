package edu.ruc.labmgr.web.controller;


import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Title;
import edu.ruc.labmgr.domain.TitleCriteria;
import edu.ruc.labmgr.service.TitleService;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: sjzheng
 * Date: 13-10-25
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/prototype/jsp/bas/post")
public class TitleController {
	@Autowired
	TitleService titleService;
	private int currPage = 0;

	@RequestMapping(value = "/list")
	public ModelAndView list(){
		return pageList(null, null, 1);
	}
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public ModelAndView pageList(@RequestParam("searchName")String name,
								 @RequestParam("searchRank")String rank,@RequestParam("page")int page) {


		ModelAndView mav = new ModelAndView("prototype/jsp/bas/post/list");
		PageInfo<Title> pageInfo =  titleService.selectListPage(name,rank,page);
		mav.addObject("pageInfo",pageInfo);
		return  mav;

	}
	@RequestMapping(value = "/toAdd",method = RequestMethod.GET)
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("prototype/jsp/bas/post/add");
		return mav;
	}
	@RequestMapping(value= "/add",method = RequestMethod.POST)
	public ModelAndView Add(Title title){
		titleService.insert(title);
		return  pageList(null,null,1);

	}
	@RequestMapping(value = "/toUpdate",method = RequestMethod.POST)
	public ModelAndView toUpdate(@RequestParam("id")int id){
		Title title = titleService.selectByPrimerKey(id);
		ModelAndView mav =  new ModelAndView("/prototype/jsp/bas/post/update");
		mav.addObject("title",title);
		return mav;

	}
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public ModelAndView Update(Title title){
		titleService.update(title);
		return pageList(null,null,1);
	}
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("id")int id){
		titleService.delete(id);
		return pageList(null,null,1);

	}
}
