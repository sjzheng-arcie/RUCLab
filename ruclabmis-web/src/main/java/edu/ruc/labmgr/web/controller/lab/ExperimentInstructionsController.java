package edu.ruc.labmgr.web.controller.lab;


import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.ExperimentInstructions;
import edu.ruc.labmgr.service.CurriculumService;
import edu.ruc.labmgr.service.ExperimentInstructionsService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
    public String add(ExperimentInstructions experimentInstructions) {
        experimentInstructionsService.insert(experimentInstructions);
        return "redirect:/laboratory/jsp/res/instruction/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        ExperimentInstructions instruction = experimentInstructionsService.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/instruction/update");
        mav.addObject("instruction", instruction);

        if(!StringUtils.isNullOrEmpty(instruction.getDocumentPath()))
        {
            String[] strArray =  instruction.getDocumentPath().split("\\|\\|");
            for(int i = 0 ; i < strArray.length ; i++)
            {
                strArray[i] = strArray[i].substring(strArray[i].lastIndexOf('\\')+1);
            }
            mav.addObject("documents", strArray);
        }

        List<Curriculum> curriculumList = curriculumService.selectAllCurriculums();
        mav.addObject("curriculumList", curriculumList);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ExperimentInstructions experimentInstructions) {
        experimentInstructionsService.update(experimentInstructions);
        return "redirect:/laboratory/jsp/res/instruction/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        experimentInstructionsService.delete(items);
        return "redirect:/laboratory/jsp/res/instruction/list";
    }

    @RequestMapping(value="/uploadFile",method=RequestMethod.POST)
    public String uploadFile(@RequestParam("id") Integer id, MultipartFile file, HttpServletRequest request) throws Exception{
        if (!file.isEmpty()) {
            ExperimentInstructions instruction = experimentInstructionsService.selectByPrimaryKey(id);

            String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
            String uploadPath=request.getSession().getServletContext().getRealPath(path);

            String fullFilePath = uploadPath+"\\"+file.getOriginalFilename();
            File dir = new File(fullFilePath);
            if (!dir.getParentFile().exists()) {
                dir.getParentFile().mkdirs();
            }

            FileOutputStream fileOS = new FileOutputStream(fullFilePath);

            fileOS.write(file.getBytes());
            fileOS.close();

            System.out.println("upload file path :" + fullFilePath);

            String currDocPath = instruction.getDocumentPath();
            String documentPath =  StringUtils.isNullOrEmpty(currDocPath) ? fullFilePath : currDocPath + "||" + fullFilePath;
            instruction.setDocumentPath(documentPath);
            experimentInstructionsService.update(instruction);
        }
        return "redirect:/laboratory/jsp/res/instruction/toUpdate?id=" + id;
    }

    @RequestMapping(value="/deleteFile",method=RequestMethod.POST)
    public String deleteFile(@RequestParam("id") Integer id, MultipartFile file, HttpServletRequest request) throws Exception{
        if (!file.isEmpty()) {
            ExperimentInstructions instruction = experimentInstructionsService.selectByPrimaryKey(id);

            String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
            String uploadPath=request.getSession().getServletContext().getRealPath(path);

            String fullFilePath = uploadPath+"\\"+file.getOriginalFilename();
            File dir = new File(fullFilePath);
            if (!dir.getParentFile().exists()) {
                dir.getParentFile().mkdirs();
            }

            FileOutputStream fileOS = new FileOutputStream(fullFilePath);

            fileOS.write(file.getBytes());
            fileOS.close();

            System.out.println("upload file path :" + fullFilePath);

            String currDocPath = instruction.getDocumentPath();
            String documentPath =  StringUtils.isNullOrEmpty(currDocPath) ? fullFilePath : currDocPath + "||" + fullFilePath;
            instruction.setDocumentPath(documentPath);
            experimentInstructionsService.update(instruction);
        }
        return "redirect:/laboratory/jsp/res/instruction/toUpdate?id=" + id;
    }
}
