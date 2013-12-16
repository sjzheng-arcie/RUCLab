package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.Major;
import edu.ruc.labmgr.domain.Teacher;
import edu.ruc.labmgr.service.ClassifService;
import edu.ruc.labmgr.service.CurriculumService;
import edu.ruc.labmgr.service.MajorService;
import edu.ruc.labmgr.service.TeacherService;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/laboratory/jsp/bas/curriculum")
public class CurriculumController {
    @Autowired
    private CurriculumService curriculumService;
    @Autowired
    MajorService serviceMajor;
    @Autowired
    ClassifService serviceClassif;
    @Autowired
    TeacherService serviceTeacher;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value = "searchName", required = false) String name,
                                 @RequestParam(value = "searchMajor", required = false) Integer majorId,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("laboratory/jsp/bas/curriculum/list");

        PageInfo<Curriculum> pageInfo = curriculumService.selectListPage(name, majorId, page);

        List<Major> majors = serviceMajor.selectAllMajors();
        List<Classif> examTypes = serviceClassif.getItemsByParentID(Types.ClassifType.EXAM_TYPE.getValue());
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("majors", majors);
        mav.addObject("examTypes", examTypes);
        return mav;
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("laboratory/jsp/bas/curriculum/add");
        List<Major> majors = serviceMajor.selectAllMajors();
        List<Teacher> teacherList = serviceTeacher.getAllTeacherList();
        mav.addObject("teacherList", teacherList);
        mav.addObject("majors", majors);
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Curriculum curriculum) {
        curriculumService.insert(curriculum);
        return "redirect:/laboratory/jsp/bas/curriculum/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        Curriculum curriculum = curriculumService.selectByPrimerKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/curriculum/update");
        List<Major> majors = serviceMajor.selectAllMajors();
        List<Classif> examTypes = serviceClassif.getItemsByParentID(Types.ClassifType.EXAM_TYPE.getValue());
        List<Teacher> teacherList = serviceTeacher.getAllTeacherList();
        mav.addObject("teacherList", teacherList);
        mav.addObject("majors", majors);
        mav.addObject("curriculum", curriculum);
        mav.addObject("examTypes", examTypes);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Curriculum curriculum) {
        curriculumService.update(curriculum);
        return "redirect:/laboratory/jsp/bas/curriculum/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        curriculumService.delete(items);
        return "redirect:/laboratory/jsp/bas/curriculum/list";
    }
}