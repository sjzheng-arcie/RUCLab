package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.CurriculumClass;
import edu.ruc.labmgr.domain.Student;
import edu.ruc.labmgr.service.CurriculumClassService;
import edu.ruc.labmgr.service.StudentService;
import edu.ruc.labmgr.utils.page.PageInfo;
import edu.ruc.labmgr.web.controller.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
@Controller
@RequestMapping(value = "/experiment/virtual")
public class VirtualClassController {

    @Autowired
    private CurriculumClassService classService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView classList(@RequestParam int page,
                                  @RequestParam(value = "sn", required = false, defaultValue = "") String sn,
                                  @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/virtual/list");

        PageInfo<CurriculumClass> pageInfo = classService.getPageClasses(page, sn, name);
        mv.addObject("pageInfo", pageInfo);
		return mv;
    }

    @RequestMapping(value = "/showAdd", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView addClass(int page, String sn, String name, String major, CurriculumClass vclass) {
        ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/virtual/addtoclass");
        PageInfo<Student> pageInfo = studentService.getPageStudent(page, sn, name, major);
        mv.addObject("pageInfo", pageInfo);
        if (vclass == null) {
            vclass = new CurriculumClass();
        }
        mv.addObject("vclass", vclass);
        return mv;
    }

    @RequestMapping(value = "/editClass", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editClass(int vcId, String sn, String name, String major) {
        ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/virtual/editclass");
        CurriculumClass vClass = classService.getVirtualClass(vcId);
        List<Student> students = classService.getClassStudents(vcId, sn, name, major);
        mv.addObject("vClass", vClass);
        mv.addObject("students", students);
        return mv;
    }

    @RequestMapping(value = "/updateClass", method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    Result updateClass(CurriculumClass clazz) {
        Result result = null;
        try {
            classService.updateCurriculumClass(clazz);
            result = new Result(true, "更新班级信息成功!");
        } catch (Exception e) {
            result = new Result(false, "更新班级失败!");
        }
        return result;
    }

    @RequestMapping(value = "/removeClass", method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    Result removeClass(String ids) {
        Result result = null;
        if (StringUtils.isNotEmpty(ids)) {
            String[] idArr = ids.split(",");
            int[] idiArr = new int[idArr.length];
            for (int i = 0; i < idArr.length; i++) {
                idiArr[i] = Integer.valueOf(idArr[i]);
            }
            try {
                classService.deleteClass(idiArr);
                result = new Result(true, "删除班级成功!");
            } catch (Exception e) {
                result = new Result(false, "删除班级失败!");
            }
        } else {
            result = new Result(true, "请求执行成功!");
        }
        return result;
    }

    @RequestMapping(value = "/addClass", method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    Result addClass(CurriculumClass newClass, String sidStr) {
        Result r = null;
        try {
            List<Integer> sids = null;
            if (StringUtils.isNotEmpty(sidStr)) {
                String[] sidArr = sidStr.split(",");
                sids = new ArrayList<Integer>();
                for (String sid : sidArr) {
                    sids.add(Integer.valueOf(sid));
                }
            }
            classService.addCurriculumClass(newClass, sids);
            r = new Result(true, "添加班级成功!");
        } catch (Exception e) {
            r = new Result(false, "添加班级失败!\n" + e.getMessage());
        }
        return r;
    }

    @RequestMapping(value = "/removeStudent", method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    Result removeStudents(Integer vcId, String stIds) {
        String[] stIdArr = stIds.split(",");
        int[] stiArr = new int[stIdArr.length];
        for (int i = 0; i < stIdArr.length; i++) {
            stiArr[i] = Integer.valueOf(stIdArr[i]);
        }
        Result r = null;
        try {
            classService.deleteClassStudent(vcId, stiArr);
            r = new Result(true, "删除班级学生成功!");
        } catch (Exception e) {
            r = new Result(true, "删除班级学生失败!");
            e.printStackTrace();
        }
        return r;
    }
}
