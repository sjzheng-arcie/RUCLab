package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.TaskscoreMapper;
import edu.ruc.labmgr.service.TaskScoreService;
import edu.ruc.labmgr.service.TaskService;
import edu.ruc.labmgr.service.TeacherService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
	TeacherService teacherService;
	@Autowired
	UserService userService;
	@Autowired
	TaskService taskService;

	@RequestMapping(value = "/teacherscorelist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getList(@RequestParam(value="taskId", required = true,defaultValue = "0") int taskId,
								@RequestParam(value = "page", required = false, defaultValue = "1") int page){
		TaskscoreCriteria taskCriteria = new TaskscoreCriteria();
		TaskscoreCriteria.Criteria criteria=taskCriteria.createCriteria();
		criteria.andTaskidEqualTo(taskId);
		Task task = taskService.getTaskById(taskId);
		PageInfo<Taskscore> pageInfo =taskScoreService.selectListPage(taskCriteria, page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/taskscore/teacherscorelist");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("taskInfo",task);
		return modelAndView;
	}
	@RequestMapping(value = "/taskscorelist", method = (RequestMethod.GET))
	public ModelAndView getScoreList(@RequestParam(value = "page", required = false, defaultValue = "1") int page){

		TaskCriteria taskCriteria = new TaskCriteria();
		TaskCriteria.Criteria criteria =taskCriteria.createCriteria();
		criteria.andIfworkEqualTo(false);
		criteria.andManageridNotEqualTo(userService.getCurrentUserId());
		List<Taskscore> taskScoreList=taskScoreService.getListByMarkerId(userService.getCurrentUserId());
		List<Teacher> managerList= teacherService.getAllTeacherList();
		PageInfo<Task> pageInfo =taskService.selectListPage(taskCriteria, page);
		List<Task> taskList=pageInfo.getData();
		for(int i=0;i<taskList.size();i++){
			taskList.get(i).setIfcompleted(false);
			for(int j=0;j<taskScoreList.size();j++){
				if (taskList.get(i).getId().equals(taskScoreList.get(j).getTaskid())){
					taskList.get(i).setIfcompleted(true);
					break;
				}
			}
		}
		pageInfo.setData(taskList);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/taskscore/taskscorelist");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("managerList",managerList);
		//modelAndView.addObject("taskScoreList",taskScoreList);
		return modelAndView;
	}
	@RequestMapping(value = "/taskscorelist", method = ( RequestMethod.POST))
	public ModelAndView getScoreList(@RequestParam(value="taskName", required = false,defaultValue = "") String taskName,
									 @RequestParam(value="ifCompleted", required = false,defaultValue = "3") int ifCompleted,
									 @RequestParam(value="managerId", required = false,defaultValue = "0") int managerId,
									 @RequestParam(value = "page", required = false, defaultValue = "1") int page){

		TaskCriteria taskCriteria = new TaskCriteria();
		TaskCriteria.Criteria criteria =taskCriteria.createCriteria();
		criteria.andIfworkEqualTo(false);
		criteria.andManageridNotEqualTo(userService.getCurrentUserId());
		if(taskName!=null){
		criteria.andTasknameLike(taskName);
		}
		if(managerId!=0){
			criteria.andManageridEqualTo(managerId);
		}
		if(ifCompleted==1){
			criteria.andIfcompletedEqualTo(true);
		}else if(ifCompleted==0){
			criteria.andIfcompletedEqualTo(false);
		}else{

		}
		List<Taskscore> taskScoreList=taskScoreService.getListByMarkerId(userService.getCurrentUserId());
		List<Teacher> managerList= teacherService.getAllTeacherList();
		PageInfo<Task> pageInfo =taskService.selectListPage(taskCriteria, page);
		List<Task> taskList=pageInfo.getData();
		for(int i=0;i<taskList.size();i++){
			taskList.get(i).setIfcompleted(false);
			for(int j=0;j<taskScoreList.size();j++){
				if (taskList.get(i).getId()==taskScoreList.get(j).getTaskid()){
					taskList.get(i).setIfcompleted(true);
					break;
				}
			}
		}
		pageInfo.setData(taskList);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/taskscore/taskscorelist");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("managerList",managerList);
//		modelAndView.addObject("taskScoreList",taskScoreList);
		return modelAndView;
	}
	@RequestMapping(value = "/toscore", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toScore(@RequestParam(value="taskId", required = true,defaultValue = "0") int taskId){
		Task task = taskService.getTaskById(taskId);
		User user = userService.getCurrentUser();

		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/taskscore/score");
		modelAndView.addObject("taskInfo",task);
		modelAndView.addObject("userInfo",user);
		return  modelAndView;
	}

	@RequestMapping(value = "/torescore", method = (RequestMethod.GET))
	public ModelAndView toRescore(@RequestParam(value="taskId", required = true,defaultValue = "0") int taskId){
		Task task = taskService.getTaskById(taskId);
		User user = userService.getCurrentUser();

		Taskscore taskScoreInfo= taskScoreService.getListByMarkerAndTask(taskId,user.getId());
		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/taskscore/rescore");
		modelAndView.addObject("taskInfo",task);
		modelAndView.addObject("userInfo",user);
		modelAndView.addObject("taskScoreInfo",taskScoreInfo);
		return  modelAndView;
	}
	@RequestMapping(value = "/rescore", method = (RequestMethod.POST))
	public ModelAndView reScore(@RequestParam(value="taskScoreId", required = true,defaultValue = "0") int taskScoreId,
							  @RequestParam(value="completelyScore", required = true,defaultValue = "0") int completelyScore,
							  @RequestParam(value="spentScore", required = true,defaultValue = "0") int spentScore,
							  @RequestParam(value="timelyScore", required = true,defaultValue = "0") int timelyScore,
							  @RequestParam(value="qualityScore", required = true,defaultValue = "0") int qualityScore,
							  @RequestParam(value="totalScore", required = true,defaultValue = "0") int totalScore){

		Taskscore taskscore = taskScoreService.getTasckScoreById(taskScoreId);
		taskscore.setCompletelyscore(completelyScore);
		taskscore.setOverallscore(totalScore);
		taskscore.setQualityscore(qualityScore);
		taskscore.setSpentscore(spentScore);
		taskscore.setTimelyscore(timelyScore);

		taskScoreService.update(taskscore);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/taskscore/taskscorelist");
		return  modelAndView;
	}
	@RequestMapping(value = "/score", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Score(@RequestParam(value="taskId", required = true,defaultValue = "0") int taskId,
							  @RequestParam(value="completelyScore", required = true,defaultValue = "0") int completelyScore,
							  @RequestParam(value="spentScore", required = true,defaultValue = "0") int spentScore,
							  @RequestParam(value="timelyScore", required = true,defaultValue = "0") int timelyScore,
							  @RequestParam(value="qualityScore", required = true,defaultValue = "0") int qualityScore,
							  @RequestParam(value="totalScore", required = true,defaultValue = "0") int totalScore){

		Taskscore taskscore = new Taskscore();
		taskscore.setTaskid(taskId);
		taskscore.setMarkerid(userService.getCurrentUserId());
		taskscore.setCompletelyscore(completelyScore);
		taskscore.setOverallscore(totalScore);
		taskscore.setQualityscore(qualityScore);
		taskscore.setSpentscore(spentScore);
		taskscore.setTimelyscore(timelyScore);

		taskScoreService.add(taskscore);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/taskscore/taskscorelist");
		return  modelAndView;
	}
	@RequestMapping(value = "/leaderscore", method = (RequestMethod.GET))
	public ModelAndView leaderScore(@RequestParam(value="taskId", required = true,defaultValue = "0") int taskId){
		Task task = taskService.getTaskById(taskId);
		User user = userService.getCurrentUser();

		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/taskscore/leaderscore");
		modelAndView.addObject("taskInfo",task);
		modelAndView.addObject("userInfo",user);
		return  modelAndView;
	}

	@RequestMapping(value = "/leaderscore", method = (RequestMethod.POST))
	public ModelAndView leaderScore(@RequestParam(value="taskId", required = true,defaultValue = "0") int taskId,
							  @RequestParam(value="completelyScore", required = true,defaultValue = "0") int completelyScore,
							  @RequestParam(value="spentScore", required = true,defaultValue = "0") int spentScore,
							  @RequestParam(value="timelyScore", required = true,defaultValue = "0") int timelyScore,
							  @RequestParam(value="qualityScore", required = true,defaultValue = "0") int qualityScore,
							  @RequestParam(value="totalScore", required = true,defaultValue = "0") int totalScore){

		Task task=taskService.getTaskById(taskId);
		task.setIfscored(true);
		task.setMarkerid(userService.getCurrentUserId());
		task.setCompletelyscore(completelyScore);
		task.setOverallscore(totalScore);
		task.setQualityscore(qualityScore);
		task.setSpentscore(spentScore);
		task.setTimelyscore(timelyScore);

		taskService.updateByPrimaryKey(task);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/task/tasklist");
		modelAndView.addObject("teacherId",task.getManagerid());
		return  modelAndView;
	}
	@RequestMapping(value = "/delete", method = (RequestMethod.GET))
	public void deleteTaskScoreByTaskId(@RequestParam(value="taskId", required = true,defaultValue = "0") int taskId){
		TaskscoreCriteria taskscoreCriteria = new TaskscoreCriteria();
		TaskscoreCriteria.Criteria criteria=taskscoreCriteria.createCriteria();
		criteria.andTaskidEqualTo(taskId);
		taskScoreService.deleteByCriteria(taskscoreCriteria);
	}

}
