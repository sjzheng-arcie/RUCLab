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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
        PageInfo<ExperimentInstructions> pageInfo = experimentInstructionsService.selectListPage(searchCurriculum, page);
        mav.addObject("pageInfo", pageInfo);

        List<Curriculum> curriculumList = curriculumService.selectAllCurriculums();
        mav.addObject("curriculumList", curriculumList);

        return mav;
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("laboratory/jsp/res/instruction/add");

        List<Curriculum> curriculumList = curriculumService.selectAllCurriculums();
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

    @RequestMapping(value = "/toAddSubject", method = RequestMethod.GET)
    public ModelAndView toAddSubject(@RequestParam("name") String name) {
        List<ExperimentSubject> subjects = subjectService.selectAllExperimentSubjects();
        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/instruction/addsubject");
        mav.addObject("subjects", subjects);
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
    public void downloadFile(@RequestParam("id") Integer id, HttpServletResponse response) throws Exception{
        ExperimentInstructions instruction = experimentInstructionsService.selectByPrimaryKey(id);
        String path = instruction.getDocumentPath();
        String fileName = instruction.getDocumentName();

        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setContentType("multipart/form-data");
        String strName = new String(fileName.getBytes("UTF-8"), "ISO_8859_1");
        String header = "attachment;fileName=" + strName;
        response.setHeader("Content-Disposition", header);

        File file=new File(path);
        System.out.println(file.getAbsolutePath());
        InputStream inputStream=new FileInputStream(file);
        OutputStream os=response.getOutputStream();
        byte[] b=new byte[2048];
        int length;
        while((length=inputStream.read(b))>0){
            os.write(b,0,length);
        }
        inputStream.close();
    }
}
