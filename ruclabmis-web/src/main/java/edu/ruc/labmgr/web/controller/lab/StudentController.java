package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/laboratory/jsp/bas/student")
public class StudentController {
    @Autowired
    StudentService serviceStudent;
    @Autowired
    MajorService serviceMajor;


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

}
