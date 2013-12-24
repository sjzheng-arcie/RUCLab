package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.Task;
import edu.ruc.labmgr.domain.TaskCriteria;
import edu.ruc.labmgr.domain.Taskscore;
import edu.ruc.labmgr.domain.TaskscoreCriteria;
import edu.ruc.labmgr.mapper.TaskscoreMapper;
import edu.ruc.labmgr.service.TaskScoreService;
import edu.ruc.labmgr.service.TaskService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-24
 * Time: 上午9:23
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/laboratory/jsp/task/taskscore/")
public class TaskScoreController {
	@Autowired
	TaskScoreService taskScoreService;
	@Autowired
	TaskService taskService;

	@RequestMapping(value = "/scorelist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getList(@RequestParam(value="teacherId", required = true,defaultValue = "0") int teacherId,
								@RequestParam(value="taskName", required = false,defaultValue = "") String taskName,
								@RequestParam(value="ifCompleted", required = false,defaultValue = "3") int ifCompleted,
								@RequestParam(value = "page", required = false, defaultValue = "1") int page){
		TaskscoreCriteria taskCriteria = new TaskscoreCriteria();
		TaskscoreCriteria.Criteria criteria=taskCriteria.createCriteria();

		PageInfo<Taskscore> pageInfo =taskScoreService.selectListPage(taskCriteria, page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/task/scorelist");
		modelAndView.addObject("pageInfo",pageInfo);
		return modelAndView;
	}
	@RequestMapping(value = "/toscore", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toScore(@RequestParam(value="taskId", required = true,defaultValue = "0") int taskId){
		Task task = taskService.getTaskById(taskId);
		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/taskscore/score");
		modelAndView.addObject("taskInfo",task);
		return  modelAndView;
	}
}
