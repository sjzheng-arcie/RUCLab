package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.ApplyWithEquipment;
import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import edu.ruc.labmgr.service.ApplyStrategic.ApplyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class ApplicationFormController {
    @Autowired
    ClassifService serviceClassif;
    @Autowired
    ApplyWithEquipmentService serviceApply;
    @Autowired
    UserService serviceUser;
    @Autowired
    MessageService serviceMessage;

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/applyList")
    public ModelAndView applyList(@RequestParam("formType")String formType,
                                  @PathVariable("applyType")String applyType) {
        return pageApplyList("", 0, 1, formType, applyType);
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/applyList", method = RequestMethod.POST)
    public ModelAndView pageApplyList(@RequestParam("searchSN") String sn, @RequestParam("searchState") Integer stateId,
                                      @RequestParam("page") Integer page,@RequestParam("formType")String formType,
                                      @PathVariable("applyType")String applyType) {
        ModelAndView result = new ModelAndView();
        result.setViewName("/equipment/jsp/dev/"+applyType+"/applylist");

        List<Classif> states = serviceClassif.getItemsByParentID(Types.ClassifType.APPLY_STATE.getValue());

        PageInfo<ApplicationForm> pageInfo = new PageInfo<ApplicationForm>();

        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        if(formType.equalsIgnoreCase("apply"))
            pageInfo = applyContext.pageApplicationList(sn, stateId, page);
        else if(formType.equalsIgnoreCase("review") || formType.equalsIgnoreCase("process"))
            pageInfo = applyContext.pageApplicationProcessList(sn, stateId, page);
        else if(formType.equalsIgnoreCase("history"))
            pageInfo = applyContext.pageApplicationHistoryList(sn, stateId, page);

        result.addObject("formType", formType);
        result.addObject("pageInfo", pageInfo);
        result.addObject("states", states);
        return result;
    }


    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/toUpdateApplication", method = RequestMethod.GET)
    public ModelAndView toUpdateApplication(@RequestParam("application_id") int applicationId,
                                            @RequestParam("formType") String formType,
                                            @PathVariable("applyType") String applyType) {
        ApplyWithEquipment apply = serviceApply.selectApplyById(applicationId);

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/"+applyType+"/updateapply");

        if(Types.ApplyType.ALLOT.getName().equalsIgnoreCase(applyType)){
            if(!StringUtils.isNullOrEmpty(apply.getAnnex())){
                String target = serviceUser.selectByPrimaryKey(Integer.parseInt(apply.getAnnex())).getName();
                mav.addObject("target", target);
            }
        }

        mav.addObject("formType", formType);
        mav.addObject("apply", apply);
        return mav;
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/updateApplication", method = RequestMethod.POST)
    public ModelAndView updateApplication(ApplicationForm apply, @PathVariable("applyType") String applyType,
                                          HttpServletRequest request) throws Exception {
        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        applyContext.updateApplication(apply);

        //发送表单提交消息
        String path = request.getRequestURL().toString();
        path = path.replace("updateApplication", "toUpdateApplication");
        path+= "?application_id=" + apply.getId();
        path+= "&formType=review";
        serviceMessage.sendUpdateApplyMessage(apply, type, path);

        return applyList("apply", applyType);
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/toApply", method = RequestMethod.POST)
    public ModelAndView toApply(@RequestParam("items") List<Integer> items,
                                @PathVariable("applyType")String applyType) {
        ApplicationForm apply = new ApplicationForm();

        Date now = new Date();
        String sn = String.format("%d", now.getTime()) ;
        apply.setSn(sn);
        apply.setType(Types.ApplyType.getApplyTypeFromStr(applyType).getValue());
        apply.setStateId(Types.ApplyState.WAITING.getValue());
        apply.setApplyTime(new Date());
        apply.setApplicantId(serviceUser.getCurrentUserId());

        serviceApply.insertApply(apply);

        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        applyContext.addEquipmentsToApply(apply.getId(), items);

        return toUpdateApplication(apply.getId(), "apply", applyType);
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/addEquipmentsToApply", method = RequestMethod.POST)
    public ModelAndView addEquipmentsToApply(@RequestParam("application_id") int applicationId,
                                             @RequestParam("items") List<Integer> items,
                                             @PathVariable("applyType")String applyType) {
        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        applyContext.addEquipmentsToApply(applicationId, items);

        return toUpdateApplication(applicationId, "apply", applyType);
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/removeEquipmentFromApply", method = RequestMethod.GET)
    public ModelAndView removeEquipmentFromApply(@RequestParam("application_id") int applicationId,
                                                 @RequestParam("equipment_id") int equipmentId,
                                                 @PathVariable("applyType")String applyType) {
        serviceApply.removeEquipmentFromApply(applicationId, equipmentId);
        return toUpdateApplication(applicationId, "apply", applyType);
    }

    //审批通过
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/approve", method = RequestMethod.POST)
    public ModelAndView approve(@RequestParam("items") List<Integer> appIds,
                                @PathVariable("applyType")String applyType,
                                HttpServletRequest request) {
        serviceApply.approveApplys(appIds);

        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        //发送表单批准消息
        for(int appId : appIds){
            String path = request.getRequestURL().toString();
            path = path.replace("approve", "toUpdateApplication");
            path+= "?application_id=" + appId;
            path+= "&formType=review";
            serviceMessage.sendApproveApplyMessage(appId, type, path, true);
        }

        return applyList("review",applyType);
    }

    //审批拒绝
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/reject", method = RequestMethod.POST)
    public ModelAndView reject(@RequestParam("items") List<Integer> appIds,
                               @PathVariable("applyType")String applyType,
                               HttpServletRequest request) {
        serviceApply.rejectApplys(appIds);

        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        //发送表单拒绝消息
        for(int appId : appIds){
            String path = request.getRequestURL().toString();
            path = path.replace("reject", "toUpdateApplication");
            path+= "?application_id=" + appId;
            path+= "&formType=review";
            serviceMessage.sendApproveApplyMessage(appId, type, path, false);
        }

        return applyList("review",applyType);
    }

    //执行申请
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/process", method = RequestMethod.GET)
    public ModelAndView process(@RequestParam("application_id") int applicationId,
                                @PathVariable("applyType")String applyType,
                                HttpServletRequest request) {
        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        applyContext.processApply(applicationId);

        //发送表单执行消息
        String path = request.getRequestURL().toString();
        path = path.replace("process", "toUpdateApplication");
        path+= "?application_id=" + applicationId;
        path+= "&formType=review";
        serviceMessage.sendProcessApplyMessage(applicationId, type, path);

        return applyList("process",applyType);
    }

    //执行报废
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/scrap", method = RequestMethod.GET)
    public ModelAndView processScrap(@RequestParam("application_id") int applicationId,
                                     @PathVariable("applyType")String applyType,
                                     HttpServletRequest request) {
        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        applyContext.processApply(applicationId, Types.EquipState.BROKEN);

        //发送表单执行消息
        String path = request.getRequestURL().toString();
        path = path.replace("process", "toUpdateApplication");
        path+= "?application_id=" + applicationId;
        path+= "&formType=review";
        serviceMessage.sendProcessApplyMessage(applicationId, type, path);

        return applyList("process",applyType);
    }

    //删除申请
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/delete", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam("items") List<Integer> appIds,
                               @PathVariable("applyType")String applyType) {
        serviceApply.deleteApplys(appIds);
        return applyList("apply",applyType);
    }

}
