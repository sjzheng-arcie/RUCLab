package edu.ruc.labmgr.web.controller.lab;


import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.ExperimentInstructions;
import edu.ruc.labmgr.domain.ExperimentSubject;
import edu.ruc.labmgr.service.CurriculumService;
import edu.ruc.labmgr.service.ExperimentInstructionsService;
import edu.ruc.labmgr.service.ExperimentSubjectService;
import edu.ruc.labmgr.service.UserService;
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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/laboratory/jsp/res/instruction")
public class ExperimentInstructionsController {
    @Autowired
    ExperimentInstructionsService experimentInstructionsService;
    @Autowired
    CurriculumService curriculumService;
    @Autowired
    UserService userService;
    @Autowired
    ExperimentSubjectService subjectService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value = "searchCurriculum", required = false) Integer searchCurriculum,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("laboratory/jsp/res/instruction/list");
		List<Curriculum> curriculumList =null;
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.hasRole("teacher")){
			curriculumList =curriculumService.getCurriculum(null,userService.getCurrentUserId(),true);
		}else{
			curriculumList=curriculumService.getCurriculum(null,userService.getCurrentUserId(),false);
		}
        PageInfo<ExperimentInstructions> pageInfo = experimentInstructionsService.selectListPage(searchCurriculum, page,curriculumList);
        mav.addObject("pageInfo", pageInfo);

        mav.addObject("curriculumList", curriculumList);

        return mav;
    }

    @RequestMapping(value = "/courselist", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView courseList(@RequestParam(value = "searchCurriculum", required = false) Integer searchCurriculum,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("laboratory/jsp/res/instruction/courselist");
        List<Curriculum> curriculumList =null;
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.hasRole("teacher")){
            curriculumList =curriculumService.getCurriculum(null,userService.getCurrentUserId(),true);
        }else{
            curriculumList=curriculumService.getCurriculum(null,userService.getCurrentUserId(),false);
        }
        PageInfo<ExperimentInstructions> pageInfo = experimentInstructionsService.selectListPage(searchCurriculum, page,curriculumList);
        mav.addObject("pageInfo", pageInfo);

        mav.addObject("curriculumList", curriculumList);
        mav.addObject("curriculumId", searchCurriculum);
        mav.addObject("curriculumName", curriculumService.getCurriculum(searchCurriculum).getName());
        return mav;
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("laboratory/jsp/res/instruction/add");
		List<Curriculum> curriculumList =null;
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.hasRole("teacher")){
			curriculumList =curriculumService.getCurriculum(null,userService.getCurrentUserId(),true);
		}else{
			curriculumList=curriculumService.getCurriculum(null,userService.getCurrentUserId(),false);
		}
        mav.addObject("curriculumList", curriculumList);

        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ExperimentInstructions experimentInstructions, HttpServletRequest request) {
        String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
        String uploadPath = request.getSession().getServletContext().getRealPath(path);
        String fullFilePath = uploadPath + "\\" + experimentInstructions.getDocumentName();
        experimentInstructions.setDocumentPath(fullFilePath);

        experimentInstructionsService.insert(experimentInstructions);
        return "redirect:/laboratory/jsp/res/instruction/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        ExperimentInstructions instruction = experimentInstructionsService.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/instruction/update");
        mav.addObject("instruction", instruction);

        List<Curriculum> curriculumList = curriculumService.selectAllCurriculums();
        mav.addObject("curriculumList", curriculumList);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ExperimentInstructions experimentInstructions, HttpServletRequest request) {
        String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
        String uploadPath = request.getSession().getServletContext().getRealPath(path);
        String fullFilePath = uploadPath + "\\" + experimentInstructions.getDocumentName();
        experimentInstructions.setDocumentPath(fullFilePath);

        experimentInstructionsService.update(experimentInstructions);
        return "redirect:/laboratory/jsp/res/instruction/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        experimentInstructionsService.delete(items);
        return "redirect:/laboratory/jsp/res/instruction/list";
    }

    @RequestMapping(value = "/toAddSubject", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView toAddSubject(@RequestParam("name") String name,@RequestParam(required = false,defaultValue = "")String questionName,
									 @RequestParam(required = false, defaultValue = "1")int page) {
		PageInfo<ExperimentSubject> pageInfo = subjectService.selectListPage(questionName,page);

        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/instruction/addsubject");
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("instructionName", name);

        return mav;
    }

    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public  @ResponseBody Result addSubject(String instructionName, String structIds, HttpServletRequest request,HttpServletResponse response){
        Result result = null;
        if(StringUtils.isNullOrEmpty(structIds))
            return result;

        response.setHeader("content-type", "text/html;charset=UTF-8");

        try {
            String[] subjectIdArr = structIds.split(",");
            List<Integer> subjectIdList = new ArrayList<>();
            for(String idStr:subjectIdArr){
                subjectIdList.add(Integer.valueOf(idStr));
            }

            String strName = new String(instructionName.getBytes("ISO-8859-1"),"UTF-8");
            String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
            String uploadPath = request.getSession().getServletContext().getRealPath(path);
            String fileName = "实验-" + strName + "-指导书.doc";
            String fullFilePath = uploadPath + "\\" + fileName;
            subjectService.generateDocument(fullFilePath, subjectIdList);

            result = new Result(true, fileName);
        }
        catch (Exception e){
            result = new Result(false,"实验指导书生成失败!");
        }
        return result;

    }

    @RequestMapping(value="/deleteFile",method=RequestMethod.GET)
    public String deleteFile(@RequestParam("id") Integer id) throws Exception{
        ExperimentInstructions instruction = experimentInstructionsService.selectByPrimaryKey(id);
        String path = instruction.getDocumentPath();

        File file = new File(path);
        if (!file.exists()) {
            return "redirect:/laboratory/jsp/res/instruction/toUpdate?id=" + id;
        }
        file.delete();

        instruction.setDocumentPath("");
        instruction.setDocumentName("");
        experimentInstructionsService.update(instruction);

        return "redirect:/laboratory/jsp/res/instruction/toUpdate?id=" + id;
    }

    @RequestMapping(value="/downloadFile",method=RequestMethod.GET)
    public void downloadFile(@RequestParam("id") Integer id, HttpServletResponse response,HttpServletRequest request) throws Exception{
        ExperimentInstructions instruction = experimentInstructionsService.selectByPrimaryKey(id);
        String path = instruction.getDocumentPath();
        String fileName = instruction.getDocumentName();

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
}
