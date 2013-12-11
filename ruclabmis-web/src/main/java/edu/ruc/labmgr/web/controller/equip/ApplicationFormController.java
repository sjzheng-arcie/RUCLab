package edu.ruc.labmgr.web.controller.equip;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.service.ApplyStrategic.ApplyContext;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ApplicationFormController {
    @Autowired
    ClassifService serviceClassif;
    @Autowired
    ApplyWithEquipmentService serviceApplyWithEquipment;
    @Autowired
    ApplicationFormService serviceApply;
    @Autowired
    TeacherService serviceTeacher;
    @Autowired
    MessageService serviceMessage;

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/applyList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageApplyList(@RequestParam(value = "searchSN", required = false, defaultValue = "") String sn,
                                      @RequestParam(value = "searchState", required = false, defaultValue = "0") Integer stateId,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam("formType") String formType,
                                      @PathVariable("applyType") String applyType) {
        ModelAndView result = new ModelAndView();
        result.setViewName("/equipment/jsp/dev/" + applyType + "/applylist");

        List<Classif> states = serviceClassif.getItemsByParentID(Types.ClassifType.APPLY_STATE.getValue());

        PageInfo<ApplicationForm> pageInfo = new PageInfo<ApplicationForm>();

        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        if (formType.equalsIgnoreCase("apply"))
            pageInfo = applyContext.pageApplicationList(sn, stateId, page);
        else if (formType.equalsIgnoreCase("review") || formType.equalsIgnoreCase("process"))
            pageInfo = applyContext.pageApplicationProcessList(sn, stateId, page);
        else if (formType.equalsIgnoreCase("history"))
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
        ApplyWithEquipment apply = serviceApplyWithEquipment.selectApplyById(applicationId);

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/" + applyType + "/updateapply");

        if (Types.ApplyType.ALLOT.getName().equalsIgnoreCase(applyType)) {
            if (!StringUtils.isNullOrEmpty(apply.getAnnex())) {
                List<Teacher> teacherList = serviceTeacher.getAllTeacherList();
                mav.addObject("teacherList", teacherList);
            }
        }

        mav.addObject("formType", formType);
        mav.addObject("apply", apply);
        return mav;
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/updateApplication", method = RequestMethod.POST)
    public String updateApplication(ApplicationForm apply, @PathVariable("applyType") String applyType,
                                    HttpServletRequest request) throws Exception {
        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        applyContext.updateApplication(apply);

        //发送表单提交消息
        String path = request.getRequestURL().toString();
        serviceMessage.sendUpdateApplyMessage(apply, type, path);

        return "redirect:/equipment/jsp/dev/" + applyType + "/applyList?formType=apply";
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/toApply", method = RequestMethod.POST)
    public String toApply(@RequestParam("items") List<Integer> items,
                          @PathVariable("applyType") String applyType) {
        ApplicationForm apply = new ApplicationForm();

        Date now = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dateString = format.format(now);
        String sn = String.format("14101-%s-%d", dateString, serviceApply.selectCurrentSnIndex());
        apply.setSn(sn);
        apply.setType(Types.ApplyType.getApplyTypeFromStr(applyType).getValue());
        apply.setStateId(Types.ApplyState.WAITING.getValue());
        apply.setApplyTime(new Date());
        apply.setApplicantId(serviceTeacher.getCurrentUserId());

        serviceApplyWithEquipment.insertApply(apply);

        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        applyContext.addEquipmentsToApply(apply.getId(), items);

        return "redirect:/equipment/jsp/dev/" + applyType + "/toUpdateApplication?formType=apply&application_id=" + apply.getId();
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/addEquipmentsToApply", method = RequestMethod.POST)
    public String addEquipmentsToApply(@RequestParam("application_id") int applicationId,
                                       @RequestParam("items") List<Integer> items,
                                       @PathVariable("applyType") String applyType) {
        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        applyContext.addEquipmentsToApply(applicationId, items);

        return "redirect:/equipment/jsp/dev/" + applyType +
                "/toUpdateApplication?formType=apply&application_id=" +
                Integer.toString(applicationId);
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/removeEquipmentFromApply", method = RequestMethod.GET)
    public String removeEquipmentFromApply(@RequestParam("application_id") int applicationId,
                                           @RequestParam("equipment_id") int equipmentId,
                                           @PathVariable("applyType") String applyType) {
        serviceApplyWithEquipment.removeEquipmentFromApply(applicationId, equipmentId);
        return "redirect:/equipment/jsp/dev/" + applyType +
                "/toUpdateApplication?formType=apply&application_id=" +
                Integer.toString(applicationId);
    }

    //审批通过
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/approve", method = RequestMethod.POST)
    public String approve(@RequestParam("items") List<Integer> appIds,
                          @PathVariable("applyType") String applyType,
                          HttpServletRequest request) {
        serviceApplyWithEquipment.approveApplys(appIds);

        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        //发送表单批准消息
        for (int appId : appIds) {
            String path = request.getRequestURL().toString();
            serviceMessage.sendApproveApplyMessage(appId, type, path, true);
        }

        return "redirect:/equipment/jsp/dev/" + applyType + "/applyList?formType=review";
    }

    //审批拒绝
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/reject", method = RequestMethod.POST)
    public String reject(@RequestParam("items") List<Integer> appIds,
                         @PathVariable("applyType") String applyType,
                         HttpServletRequest request) {
        serviceApplyWithEquipment.rejectApplys(appIds);

        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        //发送表单拒绝消息
        for (int appId : appIds) {
            String path = request.getRequestURL().toString();
            serviceMessage.sendApproveApplyMessage(appId, type, path, false);
        }

        return "redirect:/equipment/jsp/dev/" + applyType + "/applyList?formType=review";
    }

    //执行申请
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/process", method = RequestMethod.GET)
    public String process(@RequestParam("application_id") int applicationId,
                          @PathVariable("applyType") String applyType,
                          HttpServletRequest request) {
        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        applyContext.processApply(applicationId);

        //发送表单执行消息
        String path = request.getRequestURL().toString();
        serviceMessage.sendProcessApplyMessage(applicationId, type, path);

        return "redirect:/equipment/jsp/dev/" + applyType + "/applyList?formType=process";
    }

    //执行报废
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/scrap", method = RequestMethod.GET)
    public String processScrap(@RequestParam("application_id") int applicationId,
                               @PathVariable("applyType") String applyType,
                               HttpServletRequest request) {
        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        applyContext.processApply(applicationId, Types.EquipState.BROKEN);

        //发送表单执行消息
        String path = request.getRequestURL().toString();
        serviceMessage.sendProcessApplyMessage(applicationId, type, path);

        return "redirect:/equipment/jsp/dev/" + applyType + "/applyList?formType=process";
    }

    //删除申请
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> appIds, @PathVariable("applyType") String applyType) {
        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        applyContext.deleteApplys(appIds);

        return "redirect:/equipment/jsp/dev/" + applyType + "/applyList?formType=apply";
    }

}
