package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.BbsSessionMapper;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
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

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Controller
@RequestMapping(value = "/laboratory/jsp/bas/curriculum")
public class CurriculumController {
    @Autowired
    private CurriculumService curriculumService;
    @Autowired
    BbsService bbsService;
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
    @Autowired
    @Qualifier(value = "singleThreadPool")
    private ExecutorService singleTreadPool;

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
        BbsSession record = new BbsSession();
        record.setId(curriculum.getId());
        record.setDescription(curriculum.getName());
        record.setReplycount(0);
        record.setTopiccount(0);
        bbsService.insertSession(record);
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


    @RequestMapping(value = "/importCurriculums", method = RequestMethod.GET)
    public ModelAndView importCurriculums(RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("/laboratory/jsp/bas/curriculum/importCurriculums");
        Map<String, ?> flashMap = redirectAttributes.getFlashAttributes();
        if (flashMap != null && flashMap.get("error") != null) {
            mv.addObject("error", flashMap.get("error"));
        }
        return mv;
    }

    @RequestMapping(value = "/importCurriculums", method = RequestMethod.POST)
    public String importCurriculums(boolean clean, MultipartFile file, RedirectAttributes redirectAttributes)
            throws IOException, ExecutionException, InterruptedException {
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            File local = new File(System.getProperty("java.io.tmpdir") + name);
            file.transferTo(local);
            edu.ruc.labmgr.excel.CurriculumImportTask task = new edu.ruc.labmgr.excel.CurriculumImportTask(local, clean);
            Future<Boolean> result = singleTreadPool.submit(task);
            boolean success = result.get();
            local.delete();
            if (success) {
                return "redirect:/laboratory/jsp/bas/curriculum/list";
            }
        }
        redirectAttributes.addFlashAttribute("error", "数据文件上传错误或数据导入出错!");
        return "redirect:/laboratory/jsp/bas/curriculum/importCurriculums";
    }
}