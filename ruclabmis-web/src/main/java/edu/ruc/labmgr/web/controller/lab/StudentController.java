package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/laboratory/jsp/bas/student")
public class StudentController {
    @Autowired
    StudentService serviceStudent;
    @Autowired
    MajorService serviceMajor;
    @Autowired
    @Qualifier(value = "singleThreadPool")
    private ExecutorService singleTreadPool;


    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value = "searchSN", required = false, defaultValue = "") String sn,
                                 @RequestParam(value = "searchName", required = false, defaultValue = "") String name,
                                 @RequestParam(value = "searchMajor", required = false, defaultValue = "") String major,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView result = new ModelAndView();
        result.setViewName("/laboratory/jsp/bas/student/list");
        List<Major> majors = serviceMajor.selectAllMajors();
        PageInfo<Student> pageInfo = serviceStudent.getPageStudent(page, sn, name, major);

        result.addObject("pageInfo", pageInfo);
        result.addObject("majors", majors);
        return result;
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        List<Major> majors = serviceMajor.selectAllMajors();

        ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/student/add");
        mav.addObject("majors", majors);

        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Student student) {
        serviceStudent.insert(student);
        return "redirect:/laboratory/jsp/bas/student/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        Student student = serviceStudent.selectByPrimaryKey(id);
        List<Major> majors = serviceMajor.selectAllMajors();

        ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/student/update");
        mav.addObject("student", student);
        mav.addObject("majors", majors);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Student student) {
        serviceStudent.update(student);
        return "redirect:/laboratory/jsp/bas/student/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        for (int id : items) {
            serviceStudent.delete(id);
        }
        return "redirect:/laboratory/jsp/bas/student/list";
    }

    @RequestMapping(value = "/toUpdatePassword", method = RequestMethod.GET)
    public ModelAndView toUpdatePassword(@RequestParam(value = "id", required = false, defaultValue = "-1") int id) {
        //没有传进id则取出当前登录用户id
        if (id == -1) {
            id = serviceStudent.getCurrentUserId();
        }
        ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/student/password");
        mav.addObject("id", id);
        return mav;
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(@RequestParam("id") int id,
                                 @RequestParam(value = "oriPassword", required = false) String oriPassword,
                                 @RequestParam("newPassword") String newPassword) throws Exception {
        serviceStudent.updatePassword(id, oriPassword, newPassword);
        return "redirect:/laboratory/jsp/bas/student/list";
    }

    @RequestMapping(value = "/importStudents", method = RequestMethod.GET)
    public ModelAndView importStudents(RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("/laboratory/jsp/bas/student/importStudents");
        Map<String, ?> flashMap = redirectAttributes.getFlashAttributes();
        if (flashMap != null && flashMap.get("error") != null) {
            mv.addObject("error", flashMap.get("error"));
        }
        return mv;
    }

    @RequestMapping(value = "/importStudents", method = RequestMethod.POST)
    public String importStudents(boolean clean, MultipartFile file, RedirectAttributes redirectAttributes)
            throws IOException, ExecutionException, InterruptedException {
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            File local = new File(System.getProperty("java.io.tmpdir") + name);
            file.transferTo(local);
            edu.ruc.labmgr.excel.StudentImportTask task = new edu.ruc.labmgr.excel.StudentImportTask(local, clean);
            Future<Boolean> result = singleTreadPool.submit(task);
            boolean success = result.get();
            local.delete();
            if (success) {
                return "redirect:/laboratory/jsp/bas/student/list";
            }
        }
        redirectAttributes.addFlashAttribute("error", "数据文件上传错误或数据导入出错!");
        return "redirect:/laboratory/jsp/bas/student/importStudents";
    }
}
