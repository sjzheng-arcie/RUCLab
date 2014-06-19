package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.TaskscoreMapper;
import edu.ruc.labmgr.service.*;
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
	@Autowired
	TaskChargerService taskChargerService;
	@Autowired
	TaskTypeService taskTypeService;

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
		modelAndView.addObject("taskChargerList",taskChargerService.getTaskChargerByTaskId(taskId));
		return modelAndView;
	}
	@RequestMapping(value = "/taskscorelist", method = (RequestMethod.GET))
	public ModelAndView getScoreList(@RequestParam(value = "page", required = false, defaultValue = "1") int page){

		TaskCriteria taskCriteria = new TaskCriteria();
		TaskCriteria.Criteria criteria =taskCriteria.createCriteria();
		criteria.andIfworkEqualTo(false);
		criteria.andIfscoredEqualTo(false);
		criteria.andIfcompletedEqualTo(true);
		criteria.andManageridNotEqualTo(userService.getCurrentUserId());
		List<Integer> makerIdList = taskScoreService.getTaskIdListByMarkerId(userService.getCurrentUserId());
		if(makerIdList!=null && makerIdList.size()>0)
			criteria.andIdNotIn(makerIdList);
		List<Integer> chargerIdList = taskChargerService.getTaskIdListByChagerId(userService.getCurrentUserId());
		if(chargerIdList!=null && chargerIdList.size()>0)
			criteria.andIdNotIn(chargerIdList);
		PageInfo<Task> pageInfo =taskService.selectListPage(taskCriteria, page);



		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/taskscore/taskscorelist");
		modelAndView.addObject("pageInfo",pageInfo);
		List<Teacher> managerList= teacherService.getAllTeacherList();
		modelAndView.addObject("managerList",managerList);
		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());
		return modelAndView;
	}




	@RequestMapping(value = "/taskscorelist", method = ( RequestMethod.POST))
	public ModelAndView getScoreList(@RequestParam(value="taskName", required = false,defaultValue = "") String taskName,
									 @RequestParam(value="typeId", required = true,defaultValue = "0") int typeId,
									 @RequestParam(value="ifCompleted", required = false,defaultValue = "3") int ifCompleted,
									 @RequestParam(value="managerId", required = false,defaultValue = "0") int managerId,
									 @RequestParam(value = "page", required = false, defaultValue = "1") int page){

		TaskCriteria taskCriteria = new TaskCriteria();
		TaskCriteria.Criteria criteria =taskCriteria.createCriteria();
		criteria.andIfworkEqualTo(false);
		criteria.andIfcompletedEqualTo(true);
		criteria.andManageridNotEqualTo(userService.getCurrentUserId());
		if(taskName!=null){
		criteria.andTasknameLike("%"+taskName+"%");
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
		if(typeId!=0){
			criteria.andTypeEqualTo(typeId);
		}
		criteria.andManageridNotEqualTo(userService.getCurrentUserId());
		List<Integer> makerIdList = taskScoreService.getTaskIdListByMarkerId(userService.getCurrentUserId());
		if(makerIdList!=null && makerIdList.size()>0)
			criteria.andIdNotIn(makerIdList);
		List<Integer> chargerIdList = taskChargerService.getTaskIdListByChagerId(userService.getCurrentUserId());
		if(chargerIdList!=null && chargerIdList.size()>0)
			criteria.andIdNotIn(chargerIdList);
		List<Teacher> managerList= teacherService.getAllTeacherList();
		PageInfo<Task> pageInfo =taskService.selectListPage(taskCriteria, page);

		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/taskscore/taskscorelist");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("managerList",managerList);
		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());
//		modelAndView.addObject("taskScoreList",taskScoreList);
		return modelAndView;
	}

	@RequestMapping(value = "/mytaskscorelist", method = (RequestMethod.GET))
	public ModelAndView getMyScoreList(@RequestParam(value = "page", required = false, defaultValue = "1") int page){

		TaskscoreCriteria taskscoreCriteria= new TaskscoreCriteria();
		TaskscoreCriteria.Criteria criteria =taskscoreCriteria.createCriteria();
		criteria.andMarkeridEqualTo(userService.getCurrentUserId());

		//criteria.andIdNotIn(taskScoreService.getTaskIdListByMarkerId(userService.getCurrentUserId()));
		PageInfo<Taskscore> pageInfo =taskScoreService.selectListPage(taskscoreCriteria, page);



		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/taskscore/mytaskscorelist");
		modelAndView.addObject("pageInfo",pageInfo);
		List<Teacher> managerList= teacherService.getAllTeacherList();
		modelAndView.addObject("managerList",managerList);
		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());
		return modelAndView;
	}
	@RequestMapping(value = "/mytaskscorelist", method = (RequestMethod.POST))
	public ModelAndView getMyScoreListPost(@RequestParam(value = "page", required = false, defaultValue = "1") int page){

		TaskscoreCriteria taskscoreCriteria= new TaskscoreCriteria();
		TaskscoreCriteria.Criteria criteria =taskscoreCriteria.createCriteria();
		criteria.andMarkeridEqualTo(userService.getCurrentUserId());
		PageInfo<Taskscore> pageInfo =taskScoreService.selectListPage(taskscoreCriteria, page);



		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/taskscore/mytaskscorelist");
		modelAndView.addObject("pageInfo",pageInfo);
		List<Teacher> managerList= teacherService.getAllTeacherList();
		modelAndView.addObject("managerList",managerList);
		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());
		return modelAndView;
	}
	//	@RequestMapping(value = "/mytaskscorelist", method = (RequestMethod.GET))
//	public ModelAndView getMyScoreList(@RequestParam(value = "page", required = false, defaultValue = "1") int page){
//
//		TaskCriteria taskCriteria = new TaskCriteria();
//		TaskCriteria.Criteria criteria =taskCriteria.createCriteria();
//		criteria.andIfworkEqualTo(false);
//		criteria.andIfscoredEqualTo(false);
//		criteria.andManageridNotEqualTo(userService.getCurrentUserId());
//		//criteria.andIdNotIn(taskScoreService.getTaskIdListByMarkerId(userService.getCurrentUserId()));
//		criteria.andIdIn(taskChargerService.getTaskIdListByChagerId(userService.getCurrentUserId()));
//		PageInfo<Task> pageInfo =taskService.selectListPage(taskCriteria, page);
//
//
//
//		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/taskscore/taskscorelist");
//		modelAndView.addObject("pageInfo",pageInfo);
//		List<Teacher> managerList= teacherService.getAllTeacherList();
//		modelAndView.addObject("managerList",managerList);
//		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());
//		return modelAndView;
//	}





	@RequestMapping(value = "/toscore", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toScore(@RequestParam(value="taskId", required = true,defaultValue = "0") int taskId){
		Task task = taskService.getTaskById(taskId);
		User user = userService.getCurrentUser();

		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/taskscore/score");
		modelAndView.addObject("taskInfo",task);
		modelAndView.addObject("userInfo",user);
		modelAndView.addObject("taskChargerList",taskChargerService.getTaskChargerByTaskId(taskId));
		return  modelAndView;
	}

	@RequestMapping(value = "/torescore", method = (RequestMethod.GET))
	public ModelAndView toRescore(@RequestParam(value="taskScoreId", required = true,defaultValue = "0") int taskScoreId){

		User user = userService.getCurrentUser();


		//Taskscore taskScoreInfo= taskScoreService.getListByMarkerAndTask(taskId,user.getId());
		Taskscore taskscore= new Taskscore();
		taskscore=taskScoreService.getTasckScoreById(taskScoreId);
		Task task = taskService.getTaskById(taskscore.getTaskid());
		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/taskscore/rescore");

		modelAndView.addObject("taskInfo",task);
		modelAndView.addObject("userInfo",user);
		modelAndView.addObject("taskScoreInfo",taskscore);
		modelAndView.addObject("taskChargerList",taskChargerService.getTaskChargerByTaskId(taskscore.getTaskid()));
		return  modelAndView;
	}
//	@RequestMapping(value = "/rescore", method = (RequestMethod.POST))
//	public ModelAndView reScore(@RequestParam(value="taskScoreId", required = true,defaultValue = "0") int taskScoreId,
//							  @RequestParam(value="completelyScore", required = true,defaultValue = "0") int completelyScore,
//							  @RequestParam(value="spentScore", required = true,defaultValue = "0") int spentScore,
//							  @RequestParam(value="timelyScore", required = true,defaultValue = "0") int timelyScore,
//							  @RequestParam(value="qualityScore", required = true,defaultValue = "0") int qualityScore,
//							  @RequestParam(value="totalScore", required = true,defaultValue = "0") int totalScore){
//
//		Taskscore taskscore = taskScoreService.getTasckScoreById(taskScoreId);
//		taskscore.setCompletelyscore(completelyScore);
//		taskscore.setOverallscore(totalScore);
//		taskscore.setQualityscore(qualityScore);
//		taskscore.setSpentscore(spentScore);
//		taskscore.setTimelyscore(timelyScore);
//
//		taskScoreService.update(taskscore);
//		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/taskscore/taskscorelist");
//		return  modelAndView;
//	}
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
		modelAndView.addObject("taskChargerList",taskChargerService.getTaskChargerByTaskId(taskId));
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
