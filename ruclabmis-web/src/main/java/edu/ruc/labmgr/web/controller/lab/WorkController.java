package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.Work;
import edu.ruc.labmgr.domain.WorkCriteria;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.service.WorkService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-27
 * Time: 上午9:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/laboratory/jsp/task/work/")
public class WorkController {
	@Autowired
	UserService userService;
	@Autowired
	WorkService workService;

	@RequestMapping(value = "/myworklist", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView MyWorkList(@RequestParam(value="workTitle",required = false,defaultValue = "") String workTitle,
								   @RequestParam(value="page",required = false,defaultValue = "1") int page){

		WorkCriteria workCriteria = new WorkCriteria();
		WorkCriteria.Criteria criteria= workCriteria.createCriteria();
		criteria.andWorkeridEqualTo(userService.getCurrentUserId());
		criteria.andTitleLike("%"+workTitle+"%");
		workCriteria.setOrderByClause("publishTime desc");
		PageInfo<Work> pageInfo = workService.selectListPage(workCriteria,page);

		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/work/myworklist");
		modelAndView.addObject("pageInfo",pageInfo);
		return modelAndView;
	}
	@RequestMapping(value = "/allworklist", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView workList(@RequestParam(value="workTitle",required = false,defaultValue = "") String workTitle,
								 @RequestParam(value="page",required = false,defaultValue = "1") int page){

		WorkCriteria workCriteria = new WorkCriteria();
		WorkCriteria.Criteria criteria= workCriteria.createCriteria();
		criteria.andTitleLike("%"+workTitle+"%");
		workCriteria.setOrderByClause("publishTime desc");
		PageInfo<Work> pageInfo = workService.selectListPage(workCriteria,page);

		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/work/allworklist");
		modelAndView.addObject("pageInfo",pageInfo);
		return modelAndView;
	}
	@RequestMapping(value = "/toadd", method = (RequestMethod.GET))
	public ModelAndView addWork(){

		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/work/add");
		return modelAndView;
	}
	@RequestMapping(value = "/add", method = (RequestMethod.POST))
	public ModelAndView addWork(@RequestParam(value="workTitle") String workTitle,
								@RequestParam(value="workContent") String workContent){

		Work work = new Work();
		work.setTitle(workTitle);
		work.setIfread(false);
		work.setPublishtime(new Date());
		work.setContent(workContent);
		work.setWorkerid(userService.getCurrentUserId());
		workService.insert(work);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/work/myworklist");
		return modelAndView;
	}
	@RequestMapping(value = "/delete", method = (RequestMethod.GET))
	public String delete(@RequestParam(value="workId") int workId){
		workService.deleteById(workId);
		return 	"redirect:/laboratory/jsp/task/work/myworklist";
	}
	@RequestMapping(value = "/update", method = (RequestMethod.POST))
	public String updateWork(@RequestParam(value="workTitle") String workTitle,
							 @RequestParam(value="workId") int workId,
							 @RequestParam(value="workContent") String workContent){

		Work work = workService.getWorkById(workId);
		work.setTitle(workTitle);
		work.setContent(workContent);
		workService.update(work);
		return 	"redirect:/laboratory/jsp/task/work/myworklist";
	}
	@RequestMapping(value = "/toupdate", method = (RequestMethod.GET))
	public ModelAndView toUpdate(@RequestParam(value="workId") int workId){

		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/work/update");
		modelAndView.addObject("workInfo",workService.getWorkById(workId));
		return modelAndView;
	}
	@RequestMapping(value = "/info", method = (RequestMethod.GET))
	public ModelAndView workInfo(@RequestParam(value="workId") int workId){
		Work work=workService.getWorkById(workId);
		work.setIfread(true);
		workService.update(work);
		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/work/info");
		modelAndView.addObject("workInfo",work);
		return modelAndView;
	}


}
