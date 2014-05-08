package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
    private CurriculumClassService curriculumClassService;
    @Autowired
    MajorService serviceMajor;
    @Autowired
    ClassifService serviceClassif;
    @Autowired
    TeacherService serviceTeacher;
	@Autowired
	UserService  userService;
	@RequestMapping(value = "/list", produces = "application/json")
	public @ResponseBody List<Curriculum> list(String name) {
		int uid = userService.getCurrentUser().getId();
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.hasRole("teacher")){
			 return curriculumService.getCurriculum(name,uid,true);
		}else
		return curriculumService.getCurriculum(name,uid,false);
	}
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
        List<Teacher> teacherList = serviceTeacher.getRoleTeacherList(Types.Role.TEACHER);
        mav.addObject("teacherList", teacherList);
        mav.addObject("majors", majors);
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Curriculum curriculum,@RequestParam("classSn") String classSn, @RequestParam("className") String className ) {
        curriculumService.insert(curriculum);
        CurriculumClass cclass = new CurriculumClass();
        cclass.setId(curriculum.getId());
        cclass.setClassSn(classSn);
        cclass.setClassName(className);
        curriculumClassService.addCurriculumClass(cclass);
        return "redirect:/laboratory/jsp/bas/curriculum/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        Curriculum curriculum = curriculumService.selectByPrimaryKey(id);
        CurriculumClass cclass = curriculumClassService.getVirtualClass(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/curriculum/update");
        List<Major> majors = serviceMajor.selectAllMajors();
        List<Classif> examTypes = serviceClassif.getItemsByParentID(Types.ClassifType.EXAM_TYPE.getValue());
        List<Teacher> teacherList = serviceTeacher.getRoleTeacherList(Types.Role.TEACHER);
        mav.addObject("teacherList", teacherList);
        mav.addObject("majors", majors);
        mav.addObject("curriculum", curriculum);
        mav.addObject("cclass", cclass);
        mav.addObject("examTypes", examTypes);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Curriculum curriculum,@RequestParam("classSn") String classSn, @RequestParam("className") String className ) {
        curriculumService.update(curriculum);
        CurriculumClass cclass = new CurriculumClass();
        cclass.setId(curriculum.getId());
        cclass.setClassSn(classSn);
        cclass.setClassName(className);
        curriculumClassService.updateCurriculumClass(cclass);
        return "redirect:/laboratory/jsp/bas/curriculum/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        curriculumService.delete(items);
        return "redirect:/laboratory/jsp/bas/curriculum/list";
    }
}