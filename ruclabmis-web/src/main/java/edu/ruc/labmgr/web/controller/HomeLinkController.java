package edu.ruc.labmgr.web.controller;

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
@RequestMapping("/equipment/jsp/welcomelink/myapplyinfo")
public class HomeLinkController {

    @Autowired
    private ApplicationFormService applicationFormService;
    @Autowired
    private StudentService teacherService;
    @Autowired
    private UserService userService;
    @Autowired
    private ClassifService classifService;


    @RequestMapping(value = "/myapplylist",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView searchAllMyApplyList(@RequestParam(value="page",required = false,defaultValue = "1") int page,
                                             @RequestParam(value="applyNo",required = false,defaultValue = "") String applyNo,
                                             @RequestParam(value="formType",required = false,defaultValue = "0") int formType) {
        ModelAndView mav = new ModelAndView("equipment/jsp/welcomelink/applyinfo/myapplylist");
        int currentUserId = userService.getCurrentUserId();
        ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
        ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
        criteria.andApplicantIdEqualTo(currentUserId);

        if(applyNo!=null&&applyNo!=""){
            criteria.andSnLike("%"+applyNo+"%");
        }
        if(formType!=0){
            criteria.andTypeEqualTo(formType);
        }
        applicationFormCriteria.setOrderByClause(" apply_time desc");
        List<Classif> classifList= classifService.getItemsByParentID(2);
        PageInfo<ApplicationForm> pageInfo =  applicationFormService.selectListPage( applicationFormCriteria,page);
        mav.addObject("pageInfo",pageInfo);
        mav.addObject("classifList",classifList);
        return mav;
    }

    @RequestMapping(value = "/pendinglist",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView showAllPendingList(@RequestParam(value="page",required = false,defaultValue = "1") int page,
                                           @RequestParam(value="applyNo",required = false,defaultValue = "") String applyNo,
                                           @RequestParam(value="formType",required = false,defaultValue = "0") int formType) {

        ModelAndView mav = new ModelAndView("/equipment/jsp/welcomelink/applyinfo/pendinglist");
        int currentUserId = userService.getCurrentUserId();

        ApplicationFormCriteria applicationFormCriteria = new ApplicationFormCriteria();
        ApplicationFormCriteria.Criteria criteria=applicationFormCriteria.createCriteria();
        criteria.andApproverIdEqualTo(currentUserId);
        criteria.andStateIdNotEqualTo(34);
        if(applyNo!=null&&applyNo!=""&&!applyNo.equals("")){
            criteria.andSnLike("%"+applyNo+"%");
        }
        if(formType!=0){
            criteria.andTypeEqualTo(formType);
        }
        applicationFormCriteria.setOrderByClause(" apply_time desc");
        PageInfo<ApplicationForm> pageInfo =  applicationFormService.selectListPage( applicationFormCriteria,page);
        List<Classif> classifList= classifService.getItemsByParentID(2);
        mav.addObject("classifList",classifList);
        mav.addObject("pageInfo",pageInfo);
        return mav;
    }



}
