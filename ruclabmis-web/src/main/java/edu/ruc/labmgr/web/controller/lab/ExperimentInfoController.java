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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/myexperimentlist", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView experimentList(@RequestParam int page, Integer cid, String view,@RequestParam(required = false) String curriculumClassId) {
        ModelAndView mv = null;
        if (view == null) {
            mv = new ModelAndView("laboratory/jsp/experiment/experiment/myexperimentlist");
        } else if (view.equals("report")) {
            mv = new ModelAndView("laboratory/jsp/experiment/report/myexperimentlist");
        }
        PageInfo<Experiment> pageInfo = experimentService.getCurriculumExperiment(cid, page);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("cid", cid);
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
            String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String path = request.getSession().getServletContext().getRealPath("/") + "/data/" + name;
            File local = new File(path);
            try {
                file.transferTo(local);
                if (exp.getId() == null) {
                    exp.setTemplatePath(path);
                    experimentService.addExperiment(exp);
                } else {
                    experimentService.updateExperiment(exp, path);
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
    public void downloadTemplate(Integer eid, HttpServletResponse resp) {
        Experiment exp = experimentService.getExperiment(eid);
        if (exp != null) {
            String path = exp.getTemplatePath();
            String fileName = path.substring(path.indexOf("_") + 1);
            download(path,fileName,resp);
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
    public ModelAndView experimentDetailForReport(Integer cid, Integer eid) {
        ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/report/maintain");
        Experiment e = experimentService.getExperiment(eid);
        Curriculum c = curriculumService.getCurriculum(cid);
        mv.addObject("exp", e);
        mv.addObject("cur", c);
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
    public void downloadStudentExpReport(int eid,int stuId,HttpServletResponse resp){
         ExperimentDetail detail = experimentService.getStudentExpDetail(eid,stuId);
         if (detail!=null){
             String path = detail.getReportPath();
             String fileName = path.substring(path.indexOf("_") + 1);
             download(path,fileName,resp);
         }
    }

    private void download(String path,String fileName,HttpServletResponse resp){
        Path fp = Paths.get(path);
        if (Files.exists(fp)) {
            //String fileName = path.substring(path.indexOf("_") + 1);
            resp.setHeader("content-type", "text/html;charset=UTF-8");
            resp.setContentType("multipart/form-data");
            String header = "attachment;fileName=\"" + fileName + "\"";
            resp.setHeader("Content-Disposition", header);

            byte[] buffer = new byte[1024];
            int read = 0;
            try (FileInputStream fis = new FileInputStream(new File(path));
                 InputStream is = new BufferedInputStream(fis);
                 OutputStream os = resp.getOutputStream();) {
                while ((read = is.read(buffer)) > 0) {
                    os.write(buffer, 0, read);
                }
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
