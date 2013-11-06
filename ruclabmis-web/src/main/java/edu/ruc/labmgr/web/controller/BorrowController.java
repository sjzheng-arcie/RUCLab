package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.ApplyWithEquipment;
import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.service.ApplyWithEquipmentService;
import edu.ruc.labmgr.service.ClassifService;
import edu.ruc.labmgr.service.EquipmentService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping("/equipment/jsp/dev/borrow")
public class BorrowController {
//    @Autowired
//    EquipmentService serviceEquipment;
//    @Autowired
//    ClassifService serviceClassif;
//    @Autowired
//    ApplyWithEquipmentService serviceApply;
//    @Autowired
//    UserService serviceUser;
//
//    @RequestMapping(value = "/applyList")
//    public ModelAndView applyList(@RequestParam("formType")String formType) {
//        return pageApplyList(null, 0, 1, formType);
//    }
//
//    @RequestMapping(value = "/applyList", method = RequestMethod.POST)
//    public ModelAndView pageApplyList(@RequestParam("searchSN") String sn, @RequestParam("searchState") Integer stateId,
//                                      @RequestParam("page") Integer page,@RequestParam("formType")String formType) {
//        ModelAndView result = new ModelAndView();
//        result.setViewName("/equipment/jsp/dev/borrow/applylist");
//
//        List<Classif> states = serviceClassif.getItemsByParentID(Types.ClassifType.APPLY_STATE.getValue());
//
//        Subject currentUser = SecurityUtils.getSubject();
//        PageInfo<ApplicationForm> pageInfo = new PageInfo<ApplicationForm>();
//        //管理员则显示所有未关闭订单
//        if(currentUser.hasRole(Types.Role.ADMIN.getValue()) ) {
//            if(formType.endsWith("history"))
//                pageInfo = serviceApply.selectPageHistoryApply(sn, stateId, page, Types.ApplyType.BORROW);
//            else
//                pageInfo = serviceApply.selectPageApplyForAdmin(sn, stateId, page, Types.ApplyType.BORROW);
//        }
//        //领导显示待审批的订单
//        else if(currentUser.hasRole(Types.Role.LEADER.getValue())){
//            if(formType.endsWith("apply"))
//                pageInfo = serviceApply.selectPageApplyForTeacher(sn, stateId, page,
//                        Types.ApplyType.BORROW, serviceUser.getCurrentUserId());
//            else if(formType.endsWith("review"))
//                pageInfo = serviceApply.selectPageApplyForLeader(sn, stateId, page, Types.ApplyType.BORROW);
//            else if(formType.endsWith("history"))
//                pageInfo = serviceApply.selectPageHistoryApply(sn, stateId, page, Types.ApplyType.BORROW);
//        }
//        //教师只显示自己提交的未关闭订单
//        else if(currentUser.hasRole(Types.Role.TEACHER.getValue())){
//            if(formType.endsWith("history"))
//                pageInfo = serviceApply.selectUserPageHistoryApply(sn, stateId, page,
//                        Types.ApplyType.BORROW, serviceUser.getCurrentUserId());
//            else
//                pageInfo = serviceApply.selectPageApplyForTeacher(sn, stateId, page,
//                        Types.ApplyType.BORROW, serviceUser.getCurrentUserId());
//        }
//        //设备管理员显示所有未关闭的订单
//        else if(currentUser.hasRole(Types.Role.EQUIPMENT_ADMIN.getValue())){
//            if(formType.endsWith("history"))
//                pageInfo = serviceApply.selectPageHistoryApply(sn, stateId, page,
//                        Types.ApplyType.BORROW);
//            else
//                pageInfo = serviceApply.selectPageApplyForEquipAdmin(sn, stateId, page,
//                        Types.ApplyType.BORROW);
//        }
//
//        result.addObject("formType", formType);
//        result.addObject("pageInfo", pageInfo);
//        result.addObject("states", states);
//        return result;
//    }
//
//    @RequestMapping(value = "/deviceList")
//    public ModelAndView deviceList() {
//        return pageDeviceList(null, null, 0, 1);
//    }
//
//    @RequestMapping(value = "/deviceList", method = RequestMethod.POST)
//    public ModelAndView pageDeviceList(@RequestParam("searchSN")String sn,@RequestParam("searchName")String name,
//                                       @RequestParam("searchDirect")int useDirect,
//                                       @RequestParam("page") int page) {
//        ModelAndView result = new ModelAndView();
//        result.setViewName("/equipment/jsp/dev/borrow/devicelist");
//
//        List<Classif> useDirections = serviceClassif.getItemsByParentID(Types.ClassifType.USE_DIRECTION.getValue());
//
//        PageInfo<Equipment> pageInfo = serviceEquipment.getPageAvaiableEquipments(sn, name, useDirect, page);
//
//        result.addObject("pageInfo", pageInfo);
//        result.addObject("useDirections", useDirections);
//        return result;
//    }
//
//    @RequestMapping(value = "/toUpdateApplication", method = RequestMethod.GET)
//    public ModelAndView toUpdateApplication(@RequestParam("application_id") int applicationId,
//                                      @RequestParam("formType")String formType) {
//        ApplyWithEquipment apply = serviceApply.selectByApplyId(applicationId);
//
//        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/borrow/updateapply");
//        mav.addObject("formType", formType);
//        mav.addObject("apply", apply);
//        return mav;
//    }
//
//    @RequestMapping(value = "/updateApplication", method = RequestMethod.POST)
//    public ModelAndView updateApplication(ApplicationForm apply) {
//        serviceApply.updateApplication(apply);
//        return applyList("apply");
//    }
//
//    @RequestMapping(value = "/toBorrow", method = RequestMethod.POST)
//    public ModelAndView toBorrow(@RequestParam("items") List<Integer> items) {
//        ApplicationForm apply = new ApplicationForm();
//
//        Date now = new Date();
//        String sn = String.format("%d", now.getTime()) ;
//        apply.setSn(sn);
//        apply.setType(Types.ApplyType.BORROW.getValue());
//        apply.setStateId(Types.ApplyState.WAITING.getValue());
//        apply.setApplyTime(new java.util.Date());
//        apply.setApplicantId(serviceUser.getCurrentUserId());
//
//        serviceApply.insertApply(apply);
//
//        serviceApply.addEquipmentsToApply(apply.getId(), items, Types.EquipState.TOUSE);
//
//        return toUpdateApplication(apply.getId(), "apply");
//    }
//
//    @RequestMapping(value = "/addEquipment", method = RequestMethod.POST)
//    public ModelAndView addEquipment(@RequestParam("application_id") int applicationId,
//                                     @RequestParam("items") List<Integer> appIds) {
//        serviceApply.addEquipmentsToApply(applicationId, appIds,  Types.EquipState.TOUSE);
//        return toUpdateApplication(applicationId, "apply");
//    }
//
//    @RequestMapping(value = "/removeEquipment", method = RequestMethod.GET)
//    public ModelAndView removeEquipment(@RequestParam("application_id") int applicationId,
//                                        @RequestParam("equipment_id") int equipmentId) {
//        serviceApply.removeEquipmentFromApply(applicationId, equipmentId);
//        return toUpdateApplication(applicationId, "apply");
//    }
//
//    @RequestMapping(value = "/approve", method = RequestMethod.POST)
//    public ModelAndView approve(@RequestParam("items") List<Integer> appIds) {
//        serviceApply.approveApplys(appIds);
//        return applyList("review");
//    }
//
//    @RequestMapping(value = "/reject", method = RequestMethod.POST)
//    public ModelAndView reject(@RequestParam("items") List<Integer> appIds) {
//        serviceApply.rejectApplys(appIds);
//        return applyList("review");
//    }
//
//    @RequestMapping(value = "/process", method = RequestMethod.GET)
//    public ModelAndView process(@RequestParam("application_id") int applicationId) {
//        serviceApply.processApply(applicationId);
//        return applyList("process");
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public ModelAndView delete(@RequestParam("items") List<Integer> appIds) {
//        serviceApply.deleteApplys(appIds);
//        return applyList("apply");
//    }

}
