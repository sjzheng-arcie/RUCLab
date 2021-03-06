package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.CurriculumClass;
import edu.ruc.labmgr.domain.Experiment;
import edu.ruc.labmgr.domain.ExperimentDetail;
import edu.ruc.labmgr.service.CurriculumClassService;
import edu.ruc.labmgr.service.CurriculumService;
import edu.ruc.labmgr.service.ExperimentService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import edu.ruc.labmgr.web.controller.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * User: sjzheng
 * Date: 13-12-2
 * Time: 下午3:55
 * Des:
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/experiment/experiment")
public class ExperimentInfoController {
    @Autowired
    private CurriculumClassService classService;
    @Autowired
    private UserService userService;
    @Autowired
    private CurriculumService curriculumService;
    @Autowired
    private ExperimentService experimentService;
    @Autowired
    @Qualifier(value = "singleThreadPool")
    private ExecutorService singleTreadPool;

    @RequestMapping(value = "/courselist", method = RequestMethod.GET)
    public ModelAndView courseList(@RequestParam int page, String view) {
        ModelAndView mv = null;
        if (view == null) {
            mv = new ModelAndView("laboratory/jsp/experiment/experiment/courselist");
        } else if (view.equals("report")) {
            mv = new ModelAndView("laboratory/jsp/experiment/report/courselist");
        } else if(view.equals("achievement")){
            mv = new ModelAndView("laboratory/jsp/experiment/achievement/courselist");
        }
        Subject currentUser = SecurityUtils.getSubject();
        int id = userService.getCurrentUserId();
        PageInfo<CurriculumClass> pageInfo = null;
        if (currentUser.hasRole("student"))
            pageInfo = classService.getPageClassbyPageNum(page, id, Types.Role.STUDENT);
        else if (currentUser.hasRole("administrators"))
            pageInfo = classService.getPageClassbyPageNum(page, id, Types.Role.ADMIN);
        else
            pageInfo = classService.getPageClassbyPageNum(page, id, Types.Role.TEACHER);
        mv.addObject("pageInfo", pageInfo);
		mv.addObject("userId",id);
        return mv;
    }

    @RequestMapping(value = "/listbycourse", method = RequestMethod.GET)
    public ModelAndView courseListByCourse(int page, Integer curriculumId) {
        if(page <= 0 )
            page = 1;
        ModelAndView mv = null;
        mv = new ModelAndView("laboratory/jsp/experiment/courselist");

        Subject currentUser = SecurityUtils.getSubject();
        int id = userService.getCurrentUserId();
        PageInfo<CurriculumClass> pageInfo = null;
        if (currentUser.hasRole("student"))
            pageInfo = classService.getPageCourseClassbyPageNum(page, id, curriculumId, Types.Role.STUDENT);
        else if (currentUser.hasRole("administrators"))
            pageInfo = classService.getPageCourseClassbyPageNum(page, id, curriculumId, Types.Role.ADMIN);
        else
            pageInfo = classService.getPageCourseClassbyPageNum(page, id, curriculumId, Types.Role.TEACHER);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("userId",id);
        mv.addObject("curriculumId",curriculumId);

        return mv;
    }

    @RequestMapping(value = "/myexperimentlist", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView experimentList(@RequestParam int page, Integer cid, String view,@RequestParam(required = false) String curriculumClassId) {
        ModelAndView mv = null;
        if (view == null) {
            mv = new ModelAndView("laboratory/jsp/experiment/experiment/myexperimentlist");
        } else if (view.equals("report")) {
            mv = new ModelAndView("laboratory/jsp/experiment/report/myexperimentlist");
        }
		PageInfo<Experiment> pageInfo = null;
		String role = userService.getCurrentUserRole().getName();
		if(role.equals("student")){
			int stuId = userService.getCurrentUserId();
			pageInfo = experimentService.getCurriculumExperiment(cid, page,stuId);

		}else{
			pageInfo = experimentService.getCurriculumExperiment(cid, page,null);

		}
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("cid", cid);
        mv.addObject("curriculumId", cid);
        mv.addObject("curriculumName", classService.getVirtualClass(cid).getCurriculumName());
		if(curriculumClassId!=null)
			mv.addObject("curriculumClassId",curriculumClassId);
        return mv;
    }

    @RequestMapping(value = "/sutdentexperimentlist", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView studentExperimentList(@RequestParam int page, Integer cid, String view,@RequestParam(required = false) String curriculumClassId) {
        ModelAndView mv = null;
        if (view == null) {
            mv = new ModelAndView("laboratory/jsp/experiment/experiment/studentexperimentlist");
        } else if (view.equals("report")) {
            mv = new ModelAndView("laboratory/jsp/experiment/report/studentexperimentlist");
        }
		PageInfo<Experiment> pageInfo = null;
		String role = userService.getCurrentUserRole().getName();
		if(role.equals("student")){
			int stuId = userService.getCurrentUserId();
			pageInfo = experimentService.getCurriculumExperiment(cid, page,stuId);

		}else{
			pageInfo = experimentService.getCurriculumExperiment(cid, page,null);

		}
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("cid", cid);
        mv.addObject("curriculumId", cid);
        mv.addObject("curriculumName", classService.getVirtualClass(cid).getCurriculumName());
        if(curriculumClassId!=null)
            mv.addObject("curriculumClassId",curriculumClassId);
        return mv;
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView list(@RequestParam int page, Integer cid, @RequestParam(required = false) String curriculumClassId) {
        ModelAndView mv = null;
        mv = new ModelAndView("laboratory/jsp/experiment/experiment/list");
		PageInfo<Experiment> pageInfo = null;
		String role = userService.getCurrentUserRole().getName();
		if(role.equals("student")){
			int stuId = userService.getCurrentUserId();
			pageInfo = experimentService.getCurriculumExperiment(cid, page,stuId);

		}else{
			pageInfo = experimentService.getCurriculumExperiment(cid, page,null);

		}
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("cid", cid);
        mv.addObject("curriculumId", cid);
        mv.addObject("curriculumName", classService.getVirtualClass(cid).getCurriculumName());
        if(curriculumClassId!=null)
            mv.addObject("curriculumClassId",curriculumClassId);
        return mv;
    }

    @RequestMapping(value = "/studentClassExpList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView studentExpList(Integer cid,Integer stuId){
        ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/achievement/myexperimentlist");
        List<Map<String,?>> pageInfo = experimentService.getStudentClassExperimentInfo(cid, stuId);
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    @RequestMapping(value = "/courseindex", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView courseIndex(Integer curriculumId){
        ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/courseindex");
        mv.addObject("curriculumId",curriculumId);
        return mv;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public ModelAndView addExperiment(Integer cid) {
        ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/experiment/add");
        Curriculum curriculum = curriculumService.getCurriculum(cid);
        mv.addObject("curriculum", curriculum);
        return mv;
    }

    @RequestMapping(value = {"/add", "/update"}, method = {RequestMethod.POST})
    public String addExperimentData(Experiment exp, MultipartFile file,
                                    final RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (!file.isEmpty()) {
			String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
			String realPath = request.getSession().getServletContext().getRealPath(path);
			String fullFilePath = realPath+"\\"+file.getOriginalFilename();

			File newFile = new File(fullFilePath);
			if (!newFile.getParentFile().exists()) {
				newFile.getParentFile().mkdirs();
			}
            try {
                file.transferTo(newFile);
                if (exp.getId() == null) {
                    exp.setTemplatePath(fullFilePath);
                    experimentService.addExperiment(exp);
                } else {
                    experimentService.updateExperiment(exp, fullFilePath);
                }
                return "redirect:/laboratory/jsp/experiment/experiment/myexperimentlist?page=1&cid=" + exp.getCurriculumId();
            } catch (IOException e) {
                String msg = e.getMessage() == null ? "添加实验失败！" : e.getMessage();
                redirectAttributes.addFlashAttribute("error", msg);
                return "redirect:/laboratory/jsp/experiment/experiment/add?cid=" + exp.getCurriculumId();
            }
        } else {
            if (exp.getId() == null) {
                experimentService.addExperiment(exp);
            } else {
                experimentService.updateExperiment(exp, null);
            }
            return "redirect:/laboratory/jsp/experiment/experiment/myexperimentlist?page=1&cid=" + exp.getCurriculumId();
        }
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST}, produces = "application/json")
    public @ResponseBody Result deleteExperiment(String items) {
        Result r = null;
        if (items != null) {
            String[] idArr = items.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String idStr : idArr) {
                idList.add(Integer.valueOf(idStr));
            }
            try {
                experimentService.deleteExperiment(idList);
                r = new Result(true, "成功删除实验!");
            } catch (Exception e) {
                r = new Result(false, "删除实验失败!");
            }
        } else {
            r = new Result(true, "删除实验执行成功!");
        }
        return r;
    }

    @RequestMapping(value = "/downloadTemplate", method = {RequestMethod.POST})
    public void downloadTemplate(Integer eid, HttpServletResponse resp,HttpServletRequest request)throws Exception {
        Experiment exp = experimentService.getExperiment(eid);
        if (exp != null) {
            String path = exp.getTemplatePath();
            String fileName = path.substring(path.lastIndexOf("\\") + 1);
            download(path,fileName,resp,request);
        }
    }

    @RequestMapping(value = {"/detail", "/edit"}, method = RequestMethod.GET)
    public ModelAndView experimentDetail(Integer eid, String ac) {
        ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/experiment/detail");
        Experiment e = experimentService.getExperiment(eid);
        mv.addObject("exp", e);
        mv.addObject("ac", ac);
        return mv;
    }

    @RequestMapping(value = {"/editExpRep"}, method = RequestMethod.GET)
    public ModelAndView experimentDetailForReport(Integer cid, Integer eid,@RequestParam(required = false) String curriculumClassId) {
        ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/report/maintain");
        Experiment e = experimentService.getExperiment(eid);
        Curriculum c = curriculumService.getCurriculum(cid);
        mv.addObject("exp", e);
        mv.addObject("cur", c);
		if(curriculumClassId!=null)
			mv.addObject("curriculumClassId",curriculumClassId);
        return mv;
    }

    @RequestMapping(value = {"/updateExpRep"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody  Result experimentUpdateForReport(Experiment exp) {
        Result r = null;
        try {
            experimentService.updateExperiment(exp);
            r = new Result(true, "保存成功!");
        } catch (Exception e) {
            r = new Result(false, "保存失败!");
        }
        return r;
    }

    @RequestMapping(value = {"/publishExpRep"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Result experimentPublishForReport(String ids) {
        Result r = null;
        String[] idArr = ids.split(",");
        try {
            for (String id : idArr) {
                Experiment exp = new Experiment();
                exp.setId(Integer.valueOf(id));
                exp.setStatus(true);
                experimentService.updateExperiment(exp);
            }
            r = new Result(true, "保存成功!");
        } catch (Exception e) {
            r = new Result(false, "保存失败!");
        }
        return r;
    }

    @RequestMapping(value = "/studentExpDetail", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView listStudentExperimentDetail(int eid, int page) {
        ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/report/list");
        PageInfo<Map<String,?>> pageInfo = experimentService.getStudentExperimentDetail(eid,page);
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
	@RequestMapping(value = "/studentUploadExpDetail")
	public @ResponseBody Result  uploadExperimentDetail( int eid, String filename,
										  int curriculumClassId,  int curriculumId ,HttpServletRequest request){
		Subject currentUser = SecurityUtils.getSubject();
		int stuId = userService.getCurrentUserId();
		String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
		String uploadPath = request.getSession().getServletContext().getRealPath(path);
		String fullFilePath = uploadPath + "\\" + filename;

		if(currentUser.hasRole("student")){
			experimentService.addExperimentDetail(stuId,curriculumClassId,eid,fullFilePath);
		}
		Result result = new Result(true,"文件上传成功");
		return result;
	}
    @RequestMapping(value = "/studentAllExpDetail", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView listStudentAllExperimentDetail(int stuId,int page){
        //TODO
        return null;
    }

    @RequestMapping(value = "/setStudentExpScore", method = RequestMethod.POST,produces = "application/json")
    public @ResponseBody Result setStudentExpScore(String scores){
        Result r = null;
        String[] scoreArr = scores.split(",");
        try {
            for (int i = 0; i < scoreArr.length; i = i + 2) {
                ExperimentDetail detail = new ExperimentDetail();
                detail.setId(Integer.valueOf(scoreArr[i]));
                detail.setScore(Short.valueOf(scoreArr[i + 1]));
                experimentService.updateExperimentDetail(detail);
            }
            r = new Result(true, "");
        } catch (Exception e) {
            r = new Result(false, e.getMessage());
        }
        return r;
    }
    @RequestMapping(value = "/downloadStuExpReport",method = RequestMethod.POST)
    public void downloadStudentExpReport(int eid,int stuId,HttpServletResponse resp,HttpServletRequest request)throws Exception{
         ExperimentDetail detail = experimentService.getStudentExpDetail(eid,stuId);
         if (detail!=null){
             String path = detail.getReportPath();
             String fileName = path.substring(path.indexOf("_") + 1);
             download(path,fileName,resp,request);
         }
    }

    private void download(String path,String fileName,HttpServletResponse response,HttpServletRequest request)throws Exception{
        Path fp = Paths.get(path);
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

    @RequestMapping(value = "/importCurriculumClass", method = RequestMethod.GET)
    public ModelAndView importCurriculums(Integer vcId, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("/laboratory/jsp/experiment/importCurriculumClass");
        Map<String, ?> flashMap = redirectAttributes.getFlashAttributes();
        if (flashMap != null && flashMap.get("error") != null) {
            mv.addObject("error", flashMap.get("error"));
        }
        mv.addObject("vcId", vcId);
        return mv;
    }

    @RequestMapping(value = "/importCurriculumClass", method = RequestMethod.POST)
    public String importCurriculums(Integer vcId, boolean clean, MultipartFile file, RedirectAttributes redirectAttributes)
            throws IOException, ExecutionException, InterruptedException {
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            File local = new File(System.getProperty("java.io.tmpdir") + name);
            file.transferTo(local);
            edu.ruc.labmgr.excel.ClassStudentImportTask task = new edu.ruc.labmgr.excel.ClassStudentImportTask(local, clean, vcId);
            Future<Boolean> result = singleTreadPool.submit(task);
            boolean success = result.get();
            local.delete();
            if (success) {
                return "redirect:/experiment/virtual/editClass?vcId=" + vcId;
            }
        }
        redirectAttributes.addFlashAttribute("error", "数据文件上传错误或数据导入出错!");
        return "redirect:/laboratory/jsp/experiment/experiment/importCurriculumClass";
    }
}
