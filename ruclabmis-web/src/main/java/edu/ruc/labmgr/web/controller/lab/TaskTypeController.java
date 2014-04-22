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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 14-4-21
 * Time: 上午9:09
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/laboratory/jsp/task/tasktype")
public class TaskTypeController {

	@Autowired
	TaskTypeService taskTypeService;


	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value="page",required = false,defaultValue = "1")int page,
							 @RequestParam(value="taskTypeName",required = false,defaultValue = "")String taskTypeName
							 ){


		PageInfo<TaskType> taskTypePageInfo= taskTypeService.selectListPage(taskTypeName,page);

		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/tasktype/list");
		modelAndView.addObject("pageInfo",taskTypePageInfo);
		return  modelAndView;
	}

	@RequestMapping(value = "/toadd", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toAddTask(){
		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/tasktype/add");
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addTask(@RequestParam(value = "typeName", required = true, defaultValue = "") String typeName){

		TaskType taskType= new TaskType();
		taskType.setTypeName(typeName);
		taskTypeService.insert(taskType);

		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/tasktype/list");
		return modelAndView;
	}
	@RequestMapping(value = "/toupdate", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toupdate(@RequestParam(value = "id", required = true, defaultValue = "") int  id){


		TaskType taskType= taskTypeService.getTaskTypeByIf(id);

		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/tasktype/update");
		modelAndView.addObject("taskTypeInfo",taskType);
		return modelAndView;
	}
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView update(@RequestParam(value = "id", required = true, defaultValue = "") int  id,
							   @RequestParam(value = "typeName", required = true, defaultValue = "typeName") String  typeName){


		TaskType taskType= taskTypeService.getTaskTypeByIf(id);
		taskType.setTypeName(typeName);
		taskTypeService.update(taskType);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/tasktype/list");
		return modelAndView;
	}
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView delete(@RequestParam(value = "id", required = true, defaultValue = "0") int  id){


		taskTypeService.delete(id);

		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/tasktype/list");
		return modelAndView;
	}




}
