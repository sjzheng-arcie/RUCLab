package edu.ruc.labmgr.web.controller;


import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Title;
import edu.ruc.labmgr.domain.TitleCriteria;
import edu.ruc.labmgr.service.TitleService;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/list")
	public ModelAndView pageList(HttpServletRequest request) {
		currPage = request.getParameter("page") == null   ?
				(currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));
		TitleCriteria titleCriteria =  new TitleCriteria();
		TitleCriteria.Criteria criteria = titleCriteria.createCriteria();
		if (!StringUtils.isNullOrEmpty(request.getParameter("searchName"))) {
			criteria.andNameLike("%" + request.getParameter("searchName") + "%");
		}
		if (!StringUtils.isNullOrEmpty(request.getParameter("searchRank"))) {
			criteria.andGradeLike("%" + request.getParameter("searchRank") + "%");
		}
		ObjectListPage<Title> pageinfo =  titleService.selectListPage(currPage,titleCriteria);
		ModelAndView mav = new ModelAndView("prototype/jsp/bas/post/list");
		mav.addObject("titles",pageinfo.getListObject());
		mav.addObject("page",pageinfo.getPageInfo());
		return  mav;

	}
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("prototype/jsp/bas/post/toAdd");
		return mav;
	}
	@RequestMapping("/add")
	public ModelAndView Add(HttpServletRequest request){
		Title title = initFromRequest(request);
		int result = titleService.insert(title);
		if (result>0)
			return pageList(request);
		else
			return  null;

	}
	private Title initFromRequest(HttpServletRequest request){
		Title title = new Title();
		if (!StringUtils.isNullOrEmpty(request.getParameter("id")))
			title.setId(Integer.parseInt(request.getParameter("id")));
		if (!StringUtils.isNullOrEmpty(request.getParameter("name")))
			title.setName(request.getParameter("name"));
		if (!StringUtils.isNullOrEmpty(request.getParameter("grade")))
			title.setGrade(request.getParameter("grade"));
		title.setShortName(request.getParameter("shortname"));
		title.setDescription(request.getParameter("description"));

		return  title;
	}
}
