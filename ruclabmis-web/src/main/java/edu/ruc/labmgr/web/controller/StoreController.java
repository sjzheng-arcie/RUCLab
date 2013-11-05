package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.ApplyWithEquipment;
import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.service.ClassifService;
import edu.ruc.labmgr.service.ApplyWithEquipmentService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/equipment/jsp/dev/store")
public class StoreController {
    @Autowired
    ApplyWithEquipmentService serviceApply;
    @Autowired
    ClassifService serviceClassif;
    @Autowired
    UserService serviceUser;


    @RequestMapping(value = "/list")
    public ModelAndView list() {
        return pageList(null, 0, 1);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ModelAndView pageList(@RequestParam("searchSN") String sn, @RequestParam("searchState") int stateId,
                                 @RequestParam("page") int page) {
        ModelAndView result = new ModelAndView();
        result.setViewName("/equipment/jsp/dev/store/applylist");

        List<Classif> applyStates = serviceClassif.getItemsByParentID(Types.ClassifType.APPLY_STATE.getValue());

        PageInfo<ApplicationForm> pageInfo = serviceApply.selectListPageForAdmin(sn, stateId, page, Types.ApplyType.ADD);
        result.addObject("pageInfo", pageInfo);
        result.addObject("applyStates", applyStates);
        return result;
    }

    @RequestMapping(value = "/toAddApply", method = RequestMethod.GET)
    public ModelAndView toAddApply() {
        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/addapply");
        ApplyWithEquipment store = new ApplyWithEquipment();
        mav.addObject("store", store);
        return mav;
    }

    @RequestMapping(value = "/addApply", method = RequestMethod.POST)
    public ModelAndView addApply(ApplicationForm apply) {
        apply.setType(Types.ApplyType.ADD.getValue());
        apply.setStateId(Types.ApplyState.WAITING.getValue());
        apply.setApplyTime(new java.util.Date());
        apply.setApplicantId(serviceUser.getCurrentUserId());

        serviceApply.insertApply(apply);
        return list();
    }

    @RequestMapping(value = "/toUpdateApply", method = RequestMethod.GET)
    public ModelAndView toUpdateApply(@RequestParam("application_id") int applicationId) {
        ApplyWithEquipment store = serviceApply.selectByApplyId(applicationId);

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/updateapply");
        mav.addObject("store", store);
        return mav;
    }

    @RequestMapping(value = "/updateApply", method = RequestMethod.POST)
    public ModelAndView updateApply(ApplicationForm apply) {
        serviceApply.updateApply(apply);
        return list();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam("items") List<Integer> appIds) {
        serviceApply.deleteApplys(appIds);
        return list();
    }

    @RequestMapping(value = "/toAddEquipment", method = RequestMethod.POST)
    public ModelAndView toAddEquipment(ApplicationForm apply) {
        if (apply.getId() == null) {
            apply.setType(Types.ApplyType.ADD.getValue());
            apply.setStateId(Types.ApplyState.WAITING.getValue());
            apply.setApplyTime(new java.util.Date());
            apply.setApplicantId(serviceUser.getCurrentUserId());

            serviceApply.insertApply(apply);
        }

        List<Classif> fundingSubjects = serviceClassif.getItemsByParentID(Types.ClassifType.FUNDING_SUBJECT.getValue());
        List<Classif> useDirections = serviceClassif.getItemsByParentID(Types.ClassifType.USE_DIRECTION.getValue());

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/adddevice");
        mav.addObject("applicationId", apply.getId());
        mav.addObject("useDirections", useDirections);
        mav.addObject("fundingSubjects", fundingSubjects);
        return mav;
    }

    @RequestMapping(value = "/addEquipment", method = RequestMethod.POST)
    public ModelAndView addEquipment(Equipment equipment, @RequestParam("application_id") int applicationId) {
        equipment.setStateId(Types.ClassifType.EQUIPMENT_STATE.getValue());
        serviceApply.insertEquipmentWithApply(applicationId, equipment);
        return toUpdateApply(applicationId);
    }

    @RequestMapping(value = "/toEditEquipment", method = RequestMethod.GET)
    public ModelAndView toEditEquipment(@RequestParam("application_id") int applicationId,
                                        @RequestParam("equipment_id") int equipmentId) {
        Equipment equipment = serviceApply.selectEquipmentByPrimaryKey(equipmentId);

        List<Classif> fundingSubjects = serviceClassif.getItemsByParentID(Types.ClassifType.FUNDING_SUBJECT.getValue());
        List<Classif> useDirections = serviceClassif.getItemsByParentID(Types.ClassifType.USE_DIRECTION.getValue());

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/editdevice");
        mav.addObject("applicationId", applicationId);
        mav.addObject("equipment", equipment);
        mav.addObject("useDirections", useDirections);
        mav.addObject("fundingSubjects", fundingSubjects);
        return mav;
    }

    @RequestMapping(value = "/editEquipment", method = RequestMethod.POST)
    public ModelAndView editEquipment(Equipment equipment, @RequestParam("application_id") int applicationId) {
        serviceApply.updateEquipmentByPrimaryKey(equipment);
        return toUpdateApply(applicationId);
    }

    @RequestMapping(value = "/deleteEquipment", method = RequestMethod.GET)
    public ModelAndView deleteEquipment(@RequestParam("application_id") int applicationId,
                                        @RequestParam("equipment_id") int equipmentId) {
        serviceApply.deleteEquipmentWithApply(applicationId, equipmentId);
        return toUpdateApply(applicationId);
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public ModelAndView approve(@RequestParam("items") List<Integer> appIds) {
        serviceApply.approveApplys(appIds);
        return list();
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public ModelAndView reject(@RequestParam("items") List<Integer> appIds) {
        serviceApply.rejectApplys(appIds);
        return list();
    }

}
