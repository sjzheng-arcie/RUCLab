package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.page.PageInfo;
import edu.ruc.labmgr.web.controller.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
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
	UserService userService;
	@Autowired
	OrganizationService serviceOrganization;
	@Autowired
	TaskScoreService taskScoreService;
	@Autowired
	TaskChargerService taskChargerService;
	@Autowired
	TaskTypeService taskTypeService;


//	@RequestMapping(value="/fileUpload")
//	public @ResponseBody
//	String fileUpload( @RequestParam MultipartFile file,
//					   HttpServletRequest request) throws IOException {
//
//
//		String path = "/WEB-INF/upload_task/" + userService.getCurrentUser().getSn();
//		String realPath = request.getSession().getServletContext().getRealPath(path);
//		String fullFilePath = realPath+"\\"+file.getOriginalFilename();
//		String result = file.getOriginalFilename();
//		File newFile = new File(fullFilePath);
//		if (!newFile.getParentFile().exists()) {
//			newFile.getParentFile().mkdirs();
//		}
//		try {
//			file.transferTo(newFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//			result = "附件上传失败!";
//			return result;
//		}
//		return result;
//	}

	@RequestMapping(value="/downloadFile",method=RequestMethod.GET)
	public void downloadFile(@RequestParam("id") Integer id, HttpServletResponse response,HttpServletRequest request) throws Exception{
		Task task = taskService.getTaskById(id);
		String path = task.getAnnexpath();
		String fileName = task.getAnnexname();
		File file = new File(path);

		response.setContentType("text/html;charset=utf-8");
		// 完美解决IE浏览器下载中文乱码的问题,兼容IE,Firefox,Chorme
		String agent = request.getHeader("User-Agent");
		boolean isMSIE = (agent != null && agent.indexOf("MSIE") != -1);
		String fileName1 = null;
		if (isMSIE) {
			fileName1 = URLEncoder.encode(fileName, "UTF-8");
		} else {
			fileName1 = new String(fileName.getBytes("UTF-8"),
					"ISO-8859-1");
		}

		try {
			long fileLength = file.length();
			response.addHeader("Content-Length", "" + fileLength);
			response.setContentType("application/octet-stream;charset=UTF-8");
			// response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName1);
			response.setHeader("Content-Length", String.valueOf(fileLength));

			InputStream inputStream = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			byte[] data = new byte[2048];
			int length;
			while ((length = inputStream.read(data)) > 0) {
				os.write(data, 0, length);}
			inputStream.close();
			os.close();
		} catch (IOException e) {
			throw new ServletException(e.getMessage(), e);
		}

	}
	@RequestMapping(value = "/delete", method = (RequestMethod.GET))
	public ModelAndView deleteTaskByTaskId(@RequestParam(value="taskId") int taskId){
		int managerId=taskService.getTaskById(taskId).getManagerid();
		TaskscoreCriteria taskscoreCriteria = new TaskscoreCriteria();
		TaskscoreCriteria.Criteria criteria=taskscoreCriteria.createCriteria();
		criteria.andTaskidEqualTo(taskId);
		taskChargerService.deleteByTaskId(taskId);
		taskScoreService.deleteByCriteria(taskscoreCriteria);
		taskService.deleteById(taskId);


		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/task/tasklist?teacherId="+managerId);
		return modelAndView;
	}



	@RequestMapping(value = "/tasklist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getList(@RequestParam(value="teacherId", required = true,defaultValue = "0") int teacherId,
								@RequestParam(value="typeId", required = true,defaultValue = "0") int typeId,
								@RequestParam(value="taskName", required = false,defaultValue = "") String taskName,
								@RequestParam(value="ifCompleted", required = false,defaultValue = "3") int ifCompleted,
								@RequestParam(value = "page", required = false, defaultValue = "1") int page){
		TaskCriteria taskCriteria = new TaskCriteria();
		TaskCriteria.Criteria criteria=taskCriteria.createCriteria();
		taskCriteria.setOrderByClause("publishDate desc");
		criteria.andManageridEqualTo(teacherId);
		criteria.andTasknameLike("%"+taskName+"%");
		criteria.andIfworkEqualTo(false);
		if(ifCompleted==0){
			criteria.andIfcompletedEqualTo(false);
		}else if(ifCompleted==1){
			criteria.andIfcompletedEqualTo(true);
		}
		if(typeId!=0){
			criteria.andTypeEqualTo(typeId);
		}
		Teacher teacherInfo= serviceTeacher.selectByPrimaryKey(teacherId);
		PageInfo<Task> pageInfo =taskService.selectListPage(taskCriteria, page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/task/tasklist");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("teacherInfo",teacherInfo);
		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());
		return modelAndView;
	}

	@RequestMapping(value = "/mylist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(@RequestParam(value="page",required = false,defaultValue = "1")int page,
							 @RequestParam(value="typeId",required = false,defaultValue = "0")int typeId,
							 @RequestParam(value="taskName",required = false,defaultValue = "")String taskName,
							 @RequestParam(value="ifCompleted",required = false,defaultValue = "3")int ifCompleted,
							 @RequestParam(value="ifScored",required = false,defaultValue = "3")int ifScored
	){





		PageInfo<TaskCharger> taskChargerPageInfo= taskChargerService.selectListPage("%"+taskName+"%",userService.getCurrentUserId(),typeId,ifCompleted,ifScored,page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/mytask/list");
		modelAndView.addObject("pageInfo",taskChargerPageInfo);
		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());
		return  modelAndView;
	}
	@RequestMapping(value = "/oneslist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView oneslist(@RequestParam(value="page",required = false,defaultValue = "1")int page,
							 @RequestParam(value="teacherId",required = true)int chargerId,
							 @RequestParam(value="typeId",required = false,defaultValue = "0")int typeId,
							 @RequestParam(value="taskName",required = false,defaultValue = "")String taskName,
							 @RequestParam(value="ifCompleted",required = false,defaultValue = "3")int ifCompleted,
							 @RequestParam(value="ifScored",required = false,defaultValue = "3")int ifScored){

		PageInfo<TaskCharger> taskChargerPageInfo= taskChargerService.selectListPage("%"+taskName+"%",chargerId,typeId,ifCompleted,ifScored,page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/task/list");
		modelAndView.addObject("pageInfo",taskChargerPageInfo);
		modelAndView.addObject("teacherInfo",serviceTeacher.selectByPrimaryKey(chargerId));
		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());
		return  modelAndView;
	}



	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getTaskList(@RequestParam(value="taskName", required = false,defaultValue = "") String taskName,
								@RequestParam(value="ifCompleted", required = false,defaultValue = "3") int ifCompleted,
								@RequestParam(value="typeId", required = false,defaultValue = "0") int typeId,
								@RequestParam(value="ifScored", required = false,defaultValue = "3") int ifScored,
								@RequestParam(value = "page", required = false, defaultValue = "1") int page){
		TaskCriteria taskCriteria = new TaskCriteria();
		TaskCriteria.Criteria criteria=taskCriteria.createCriteria();
		taskCriteria.setOrderByClause("publishDate desc");
		criteria.andTasknameLike("%"+taskName+"%");
		criteria.andIfworkEqualTo(false);
		if(ifCompleted==0){
			criteria.andIfcompletedEqualTo(false);
		}else if(ifCompleted==1){
			criteria.andIfcompletedEqualTo(true);
		}else{

		}
		if(ifScored==0){
			criteria.andIfscoredEqualTo(false);
		}else if(ifScored==1){
			criteria.andIfscoredEqualTo(true);
		}else{

		}
		if(typeId!=0){
			criteria.andTypeEqualTo(typeId);
		}
		PageInfo<Task> pageInfo =taskService.selectListPage(taskCriteria, page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/task/task/tasklist");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());

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

	@RequestMapping(value = "/toadd", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toAddTask(){



		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/task/add");
		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addTask(HttpServletRequest request,
								@RequestParam(value = "taskName", required = true, defaultValue = "") String taskName,
								@RequestParam(value = "documentName", required = false, defaultValue = "") String documentName,
								@RequestParam(value = "taskContent", required = true, defaultValue = "") String taskContent,
								@RequestParam(value = "limitDate", required = true ) Date limitDate,
								@RequestParam(value = "typeId", required = true,defaultValue = "0") int typeId ,
								int[] userIdList){

		String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
		String uploadPath = request.getSession().getServletContext().getRealPath(path);
		String fullFilePath = uploadPath + "\\" + documentName;



		Task task = new Task();
		task.setTaskname(taskName);
		task.setManagerid(userService.getCurrentUserId());
		task.setContent(taskContent);
		task.setLimitdate(limitDate);
		task.setIfcompleted(false);
		task.setPublishdate(new Date());
		task.setType(typeId);
		task.setPublisherid(userService.getCurrentUserId());
		task.setIfwork(false);
		task.setCompletely(0);
		task.setScore(0);
		task.setAnnexname(documentName);
		task.setAnnexpath(fullFilePath);
		task.setSpentscore(0);
		task.setQualityscore(0);
		task.setTimelyscore(0);
		task.setSpentscore(0);
		task.setCompletelyscore(0);
		task.setOverallscore(0);
		task.setIfscored(false);
		taskService.insert(task);

		for(int id:userIdList){
			TaskCharger taskCharger= new TaskCharger();
			taskCharger.setChargerid(id);
			taskCharger.setTaskid(task.getId());
			taskCharger.setScore(0);
			taskChargerService.insert(taskCharger);

		}

		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/task/list");
		return modelAndView;
	}


	@RequestMapping(value = "/toaddones", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toAddTaskForOnes(int teacherId){

		Teacher teacher=serviceTeacher.selectByPrimaryKey(teacherId);
		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/task/addforones");
		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());
		modelAndView.addObject("teacherId",teacherId);
		modelAndView.addObject("teacherInfo",teacher);
		return modelAndView;
	}

	@RequestMapping(value = "/addones", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addTaskForOnes(HttpServletRequest request,
								@RequestParam(value = "taskName", required = true, defaultValue = "") String taskName,
								@RequestParam(value = "documentName", required = false, defaultValue = "") String documentName,
								@RequestParam(value = "taskContent", required = true, defaultValue = "") String taskContent,
								@RequestParam(value = "limitDate", required = true ) Date limitDate,
								@RequestParam(value = "typeId", required = true,defaultValue = "0") int typeId ,
								int teacherId){

		String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
		String uploadPath = request.getSession().getServletContext().getRealPath(path);
		String fullFilePath = uploadPath + "\\" + documentName;



		Task task = new Task();
		task.setTaskname(taskName);
		task.setManagerid(userService.getCurrentUserId());
		task.setContent(taskContent);
		task.setLimitdate(limitDate);
		task.setIfcompleted(false);
		task.setPublishdate(new Date());
		task.setType(typeId);
		task.setPublisherid(userService.getCurrentUserId());
		task.setIfwork(false);
		task.setCompletely(0);
		task.setScore(0);
		task.setAnnexname(documentName);
		task.setAnnexpath(fullFilePath);
		task.setSpentscore(0);
		task.setQualityscore(0);
		task.setTimelyscore(0);
		task.setSpentscore(0);
		task.setCompletelyscore(0);
		task.setOverallscore(0);
		task.setIfscored(false);
		taskService.insert(task);


			TaskCharger taskCharger= new TaskCharger();
			taskCharger.setChargerid(teacherId);
			taskCharger.setTaskid(task.getId());
			taskCharger.setScore(0);
			taskChargerService.insert(taskCharger);



		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/task/oneslist?teacherId="+teacherId);
		return modelAndView;
	}




	@RequestMapping(value = "/toupdate", method = (RequestMethod.GET))
	public ModelAndView toUpdateTask(@RequestParam(value = "taskId", required = false, defaultValue = "") int taskId) {

		Task task = taskService.getTaskById(taskId);
		Teacher teacher = serviceTeacher.selectByPrimaryKey(task.getManagerid());

		ModelAndView modelAndView = new ModelAndView("/laboratory/jsp/task/task/update");
		List<TaskCharger> taskChargerList=taskChargerService.getTaskChargerByTaskId(taskId);
		if(taskChargerList!=null){
			StringBuffer sb = new StringBuffer();
			for(TaskCharger taskCharger:taskChargerList){
				sb.append(taskCharger.getChargerid()+",");
			}
			modelAndView.addObject("userIdListToBody",sb.toString());
		}

		modelAndView.addObject("teacherInfo",teacher);
		modelAndView.addObject("taskInfo",task);
		modelAndView.addObject("taskChargerList",taskChargerList);
		modelAndView.addObject("taskTypeList",taskTypeService.getTaskTypeList());
		return modelAndView;
	}
	@RequestMapping(value = "/update", method = ( RequestMethod.POST))
	public ModelAndView updateTask(HttpServletRequest request,
								   @RequestParam(value = "taskName", required = false) String taskName,
								@RequestParam(value = "taskId", required = true ) int taskId,
								@RequestParam(value = "documentName", required = false, defaultValue = "") String documentName,
								@RequestParam(value = "taskContent", required = false) String taskContent,
								@RequestParam(value = "taskTypeId", required = false) int taskTypeId,
								@RequestParam(value = "limitDate", required = false ) Date limitDate,
								int[] userIdList){
		String path = "/WEB-INF/upload_task/" + userService.getCurrentUser().getSn();
		String uploadPath = request.getSession().getServletContext().getRealPath(path);
		String fullFilePath = uploadPath + "\\" + documentName;

		Task task = taskService.getTaskById(taskId);
		if(taskName!=null){
			task.setTaskname(taskName);
		}
		if(taskContent!=null){
			task.setContent(taskContent);
		}
		if(limitDate!=null){
			task.setLimitdate(limitDate);
		}
		if(documentName!=null){
			task.setAnnexname(documentName);
			task.setAnnexpath(fullFilePath);
		}
		if(taskTypeId!=0){
			task.setType(taskTypeId);
		}
		taskChargerService.deleteByTaskId(taskId);
		for(int id:userIdList){
			TaskCharger taskCharger= new TaskCharger();
			taskCharger.setChargerid(id);
			taskCharger.setTaskid(task.getId());
			taskCharger.setScore(0);
			taskChargerService.insert(taskCharger);

		}
		taskService.updateByPrimaryKey(task);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/task/tasklist?teacherId="+task.getManagerid());
		return modelAndView;
	}

	@RequestMapping(value = "/mytasklist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getMyTaskList(@RequestParam(value="taskName", required = false,defaultValue = "") String taskName,
								@RequestParam(value="ifCompleted", required = false,defaultValue = "3") int ifCompleted,
								@RequestParam(value = "page", required = false, defaultValue = "1") int page){

		User user = userService.getCurrentUser();
		TaskCriteria taskCriteria = new TaskCriteria();
		TaskCriteria.Criteria criteria=taskCriteria.createCriteria();
		criteria.andManageridEqualTo(user.getId());
		criteria.andIfworkEqualTo(false);
		criteria.andTasknameLike("%"+taskName+"%");
		if(ifCompleted==0){
			criteria.andIfcompletedEqualTo(false);
		}else if(ifCompleted==1){
			criteria.andIfcompletedEqualTo(true);
		}else{

		}
		Teacher teacherInfo= serviceTeacher.selectByPrimaryKey(user.getId());
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
	@RequestMapping(value = "/updatecompletely", method = (RequestMethod.POST))
	public ModelAndView updateCompletely(@RequestParam(value = "taskId", required = false, defaultValue = "")int taskId,
										 @RequestParam(value = "completely", required = false, defaultValue = "")int completely,
										@RequestParam(value = "completion", required = false, defaultValue = "") String completion) {

		Task task = taskService.getTaskById(taskId);
		if(completely>100){
			task.setCompletely(completely/100);
		}else{
			task.setCompletely(completely);
		}
		task.setCompletion(completion);
		taskService.updateByPrimaryKey(task);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/task/mylist?teacherId="+task.getManagerid());
		return modelAndView;
	}
	@RequestMapping(value = "/finishtask", method = (RequestMethod.GET))
	public ModelAndView finishTask(@RequestParam(value = "taskId", required = true)int taskId) {

		Task task = taskService.getTaskById(taskId);
		task.setFinishdate(new Date());
		task.setIfcompleted(true);
		taskService.updateByPrimaryKey(task);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/task/mylist?teacherId="+task.getManagerid());
		return modelAndView;
	}
	@RequestMapping(value = "/finishtask", method = RequestMethod.POST)
	public ModelAndView finishTask(@RequestParam(value = "taskId", required = true)int taskId,
								   @RequestParam(value = "completely", required = false,defaultValue = "0")int completely,
								   @RequestParam(value = "completion", required = false,defaultValue = "") String completion) {

		Task task = taskService.getTaskById(taskId);
		if(completion!=null){
			task.setCompletion(completion);
		}
		if(completely>100){
			task.setCompletely(completely/100);
		}else{
			task.setCompletely(completely);
		}
		task.setFinishdate(new Date());
		task.setIfcompleted(true);
		taskService.updateByPrimaryKey(task);
		ModelAndView modelAndView = new ModelAndView("redirect:/laboratory/jsp/task/task/mylist?teacherId="+task.getManagerid());
		return modelAndView;
	}

	@RequestMapping(value = "/userlist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView userList(@RequestParam(value = "searchSN", required = false, defaultValue = "") String sn,
								 @RequestParam(value = "searchName", required = false, defaultValue = "") String name,
								 @RequestParam(value = "searchMajor", required = false, defaultValue = "") Integer major,
								 @RequestParam(value = "searchOrg", required = false, defaultValue = "") Integer org,
								 int[] userIdList,
								 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		ModelAndView result = new ModelAndView();
		result.setViewName("/laboratory/jsp/task/task/userlist");
		List<Major> majors = serviceMajor.selectAllMajors();
		List<Organization> organizations = serviceOrganization.selectAllOrganizations();

		PageInfo<Teacher> pageInfo = serviceTeacher.selectTeacherListPage(sn, name, major, org,userIdList, page);


		result.addObject("pageInfo", pageInfo);
		result.addObject("majors", majors);
		result.addObject("organizations", organizations);
		return result;
	}
}
