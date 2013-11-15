package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.CurriculumClass;
import edu.ruc.labmgr.domain.CurriculumClassCriteria;
import edu.ruc.labmgr.domain.Student;
import edu.ruc.labmgr.service.CurriculumClassService;
import edu.ruc.labmgr.service.StudentService;
import edu.ruc.labmgr.utils.page.PageInfo;
import edu.ruc.labmgr.web.controller.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView classList(@RequestParam int page, @RequestParam(value = "sn", required = false, defaultValue = "") String sn,
                                  @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        ModelAndView mv = new ModelAndView("prototype/jsp/experiment/virtual/list");
        PageInfo<CurriculumClass> pageInfo = classService.getPageClasses(page, sn, name);
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }

    @RequestMapping(value = "/showAdd", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView addClass(int page,String sn,String name,String major) {
        ModelAndView mv = new ModelAndView("prototype/jsp/experiment/virtual/addtoclass");
        PageInfo<Student> pageInfo = studentService.getPageStudent(page, sn, name,major);
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
    @RequestMapping(value="/addClass",method = RequestMethod.POST,produces = "application/json")
    public @ResponseBody
    Result addClass(CurriculumClass newClass,String sidStr){
        Result r = null;
        try{
            List<Integer> sids = null;
            if (!StringUtils.isNotEmpty(sidStr)){
               String[] sidArr = sidStr.split(",");
               sids = new ArrayList<Integer>();
               for (String sid :sidArr){
                   sids.add(Integer.valueOf(sid));
               }
            }
            classService.addCurriculumClass(newClass,sids);
            r = new Result(true,"添加班级成功!");
        }catch (Exception e){
            r = new Result(false,"添加班级失败!\n"+e.getMessage());
        }
        return r;
    }
}
