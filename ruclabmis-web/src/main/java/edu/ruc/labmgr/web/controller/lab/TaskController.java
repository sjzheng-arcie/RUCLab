package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.MajorService;
import edu.ruc.labmgr.service.OrganizationService;
import edu.ruc.labmgr.service.TaskService;
import edu.ruc.labmgr.service.TeacherService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-21
 * Time: 上午9:19
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/laboratory/jsp/task/task/")
public class TaskController {
	@Autowired
	TaskService taskService;
	@Autowired
	MajorService serviceMajor;
	@Autowired
	TeacherService serviceTeacher;
	@Autowired
	OrganizationService serviceOrganization;

	@RequestMapping(value = "/tasklist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getList(@RequestParam(value="teacherId", required = true,defaultValue = "0") int teacherId,
								@RequestParam(value="taskName", required = false,defaultValue = "") String taskName,
								@RequestParam(value="ifCompleted", required = false,defaultValue = "0") int ifCompleted,
								@RequestParam(value = "page", required = false, defaultValue = "1") int page){
		TaskCriteria taskCriteria = new TaskCriteria();
		TaskCriteria.Criteria criteria=taskCriteria.createCriteria();
		criteria.andManageridEqualTo(teacherId);
		criteria.andTasknameLike("%"+taskName+"%");
		if(ifCompleted==0){
			criteria.andIfcompletedEqualTo(false);
		}else if(ifCompleted==1){
			criteria.andIfcompletedEqualTo(true);
		}else{

		}
		Teacher teacherInfo= serviceTeacher.selectByPrimaryKey(teacherId);
		PageInfo<Task> pageInfo =taskService.selectListPage(taskCriteria, page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/task/tasklist");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("teacherInfo",teacherInfo);
		return modelAndView;
	}
	@RequestMapping(value = "/teacherlist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView pageList(@RequestParam(value = "searchSN", required = false, defaultValue = "") String sn,
								 @RequestParam(value = "searchName", required = false, defaultValue = "") String name,
								 @RequestParam(value = "searchMajor", required = false, defaultValue = "") Integer major,
								 @RequestParam(value = "searchOrg", required = false, defaultValue = "") Integer org,
								 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		ModelAndView result = new ModelAndView();
		result.setViewName("/laboratory/jsp/task/task/teacherlist");
		List<Major> majors = serviceMajor.selectAllMajors();
		List<Organization> organizations = serviceOrganization.selectAllOrganizations();

		PageInfo<Teacher> pageInfo = serviceTeacher.selectListPage(sn, name, major, org, page);

		result.addObject("pageInfo", pageInfo);
		result.addObject("majors", majors);
		result.addObject("organizations", organizations);
		return result;
	}
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toDeleteTask(@RequestParam(value = "taskId", required = false, defaultValue = "") int taskId,
									 @RequestParam(value = "teacherId", required = false, defaultValue = "") int teacherId){
		serviceTeacher.delete(taskId);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/task/tasklist?teacherId="+teacherId);
		return modelAndView;
	}
	@RequestMapping(value = "/toadd", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toAddTask(@RequestParam(value = "teacherId", required = false, defaultValue = "") int teacherId){
		Teacher teacher = serviceTeacher.selectByPrimaryKey(teacherId);
		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/task/add");
		modelAndView.addObject("teacherInfo",teacher);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addTask(@RequestParam(value = "taskName", required = true, defaultValue = "") String taskName,
								@RequestParam(value = "teacherId", required = true, defaultValue = "0") int teacherId,
								@RequestParam(value = "taskContent", required = true, defaultValue = "") String taskContent,
								@RequestParam(value = "limitDate", required = true ) Date limitDate){

		Task task = new Task();
		task.setTaskname(taskName);
		task.setManagerid(teacherId);
		task.setContent(taskContent);
		task.setLimitdate(limitDate);
		task.setIfcompleted(false);
		taskService.insert(task);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/task/tasklist?teacherId="+teacherId);
		return modelAndView;
	}
	@RequestMapping(value = "/toupdate", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toUpdateTask(@RequestParam(value = "teacherId", required = false, defaultValue = "")int teacherId,
			@RequestParam(value = "taskId", required = false, defaultValue = "") int taskId) {
		Teacher teacher = serviceTeacher.selectByPrimaryKey(teacherId);
		Task task = taskService.getTaskById(taskId);
		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/task/update");
		modelAndView.addObject("teacherInfo",teacher);
		modelAndView.addObject("taskInfo",task);
		return modelAndView;
	}
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateTask(@RequestParam(value = "taskName", required = true, defaultValue = "") String taskName,
								@RequestParam(value = "teacherId", required = true, defaultValue = "0") int teacherId,
								@RequestParam(value = "ifCompleted", required = false, defaultValue = "0") int ifCompleted,
								@RequestParam(value = "taskContent", required = true, defaultValue = "") String taskContent,
								@RequestParam(value = "limitDate", required = true ) Date limitDate){

		Task task = new Task();
		task.setTaskname(taskName);
		task.setManagerid(teacherId);
		task.setContent(taskContent);
		task.setLimitdate(limitDate);
		if(ifCompleted==0){
			task.setIfcompleted(false);
		}else if(ifCompleted==1){
			task.setIfcompleted(true);
		}else{

		}
		taskService.updateByPrimaryKey(task);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/task/tasklist?teacherId="+teacherId);
		return modelAndView;
	}

	@RequestMapping(value = "/mytasklist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getMyTaskList(@RequestParam(value="teacherId", required = false,defaultValue = "0") int teacherId,
								@RequestParam(value="taskName", required = false,defaultValue = "") String taskName,
								@RequestParam(value="ifCompleted", required = false,defaultValue = "0") int ifCompleted,
								@RequestParam(value = "page", required = false, defaultValue = "1") int page){
		TaskCriteria taskCriteria = new TaskCriteria();
		TaskCriteria.Criteria criteria=taskCriteria.createCriteria();
		criteria.andManageridEqualTo(teacherId);
		criteria.andTasknameLike("%"+taskName+"%");
		if(ifCompleted==0){
			criteria.andIfcompletedEqualTo(false);
		}else if(ifCompleted==1){
			criteria.andIfcompletedEqualTo(true);
		}else{

		}
		Teacher teacherInfo= serviceTeacher.selectByPrimaryKey(teacherId);
		PageInfo<Task> pageInfo =taskService.selectListPage(taskCriteria, page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/mytask/mytasklist");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("teacherInfo",teacherInfo);
		return modelAndView;
	}
	@RequestMapping(value = "/mytask", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toMyTask(@RequestParam(value = "taskId", required = false, defaultValue = "") int taskId) {

		Task task = taskService.getTaskById(taskId);
		Teacher teacher = serviceTeacher.selectByPrimaryKey(task.getManagerid());
		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/mytask/mytask");
		modelAndView.addObject("teacherInfo",teacher);
		modelAndView.addObject("taskInfo",task);
		return modelAndView;
	}
}