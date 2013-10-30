package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.ClassifService;
import edu.ruc.labmgr.service.StoreService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.Consts;
import edu.ruc.labmgr.utils.MD5.CipherUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/equipment/jsp/dev/store")
public class StoreController {
    @Autowired
    StoreService serviceStore;
    @Autowired
    ClassifService serviceClassif;

    private int currPage = 0;

    @RequestMapping("/listApply")
    public ModelAndView pageList(HttpServletRequest request) {
        currPage = request.getParameter("page") == null   ?
                (currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));

        ViewStoreCriteria viewStoreCriteria =  new ViewStoreCriteria();
        ViewStoreCriteria.Criteria criteria = viewStoreCriteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(request.getParameter("searchSN"))) {
            criteria.andApplicationSnLike("%" + request.getParameter("searchSN") + "%");
        }
        if (!StringUtils.isNullOrEmpty(request.getParameter("searchName"))) {
            criteria.andNameLike("%" + request.getParameter("searchName") + "%");
        }

        ObjectListPage<ViewStore> pageInfo = serviceStore.selectListPage(currPage, viewStoreCriteria);

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/applylist");
        mav.addObject("stores", pageInfo.getListObject());
        mav.addObject("page", pageInfo.getPageInfo());
        return mav;
    }

    @RequestMapping("/toAddApply")
    public ModelAndView toAddApply(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/addapply");
        ViewStore store = new ViewStore();
        mav.addObject("store", store);
        return mav;
    }

    @RequestMapping("/addApply")
    public ModelAndView addApply(HttpServletRequest request) {
        ApplicationForm apply = initApplyFromRequest(request);

        serviceStore.insertApply(apply);

        return pageList(request);
    }

    @RequestMapping("/toUpdateApply")
    public ModelAndView toUpdateApply(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("application_id"));

        ViewStore store = serviceStore.selectByApplyId(id);

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/updateapply");
        mav.addObject("store", store);
        return mav;
    }

    @RequiresUser
    @RequestMapping("/updateApply")
    public ModelAndView updateApply(HttpServletRequest request) {
        ApplicationForm apply = initApplyFromRequest(request);
        serviceStore.updateApply(apply);
        return pageList(request);
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceStore.deleteApply(id);

        return pageList(request);
    }

    @RequestMapping("/toAddEquipment")
    public ModelAndView toAddEquipment(HttpServletRequest request) {
        ApplicationForm apply = initApplyFromRequest(request);
        if (apply.getId() == null)
        {
            serviceStore.insertApply(apply);
        }
        int applicationId = apply.getId();;
        List<Classif> fundingSubjects = serviceClassif.getItemsByParentID(Consts.CLASSIF_FUNDING_SUBJECT);
        List<Classif> useDirections = serviceClassif.getItemsByParentID(Consts.CLASSIF_USE_DIRECTION);

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/adddevice");
        mav.addObject("applicationId", applicationId);
        mav.addObject("useDirections", useDirections);
        mav.addObject("fundingSubjects", fundingSubjects);
        return mav;
    }

    @RequestMapping("/addEquipment")
    public ModelAndView addEquipment(HttpServletRequest request) {
        int applicationId = Integer.parseInt(request.getParameter("application_id"));
        Equipment equipment = initEquipmentFromRequest(request);

        serviceStore.insertEquipmentWithApply(equipment, applicationId);

        return toUpdateApply(request);
    }

    @RequestMapping("/toEditEquipment")
    public ModelAndView toEditEquipment(HttpServletRequest request) {
        int applicationId = Integer.parseInt(request.getParameter("application_id"));
        int equipmentId = Integer.parseInt(request.getParameter("equipment_id"));

        Equipment equipment = serviceStore.selectEquipmentByPrimaryKey(equipmentId);
        List<Classif> fundingSubjects = serviceClassif.getItemsByParentID(Consts.CLASSIF_FUNDING_SUBJECT);
        List<Classif> useDirections = serviceClassif.getItemsByParentID(Consts.CLASSIF_USE_DIRECTION);

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/editdevice");
        mav.addObject("applicationId", applicationId);
        mav.addObject("equipment", equipment);
        mav.addObject("useDirections", useDirections);
        mav.addObject("fundingSubjects", fundingSubjects);
        return mav;
    }

    @RequestMapping("/editEquipment")
    public ModelAndView editEquipment(HttpServletRequest request) {
        Equipment equipment = initEquipmentFromRequest(request);
        serviceStore.updateEquipmentByPrimaryKey(equipment);

        return toUpdateApply(request);
    }

    @RequestMapping("/deleteEquipment")
    public ModelAndView deleteEquipment(HttpServletRequest request) {
        int applicationId = Integer.parseInt(request.getParameter("application_id"));
        int equipmentId = Integer.parseInt(request.getParameter("equipment_id"));

        serviceStore.deleteEquipmentWithApply(equipmentId, applicationId);

        return toUpdateApply(request);
    }

    @RequestMapping("/approve")
    public ModelAndView approve(HttpServletRequest request) {
        int applicationId = Integer.parseInt(request.getParameter("application_id"));

        serviceStore.approveApply(applicationId);

        return pageList(request);
    }


    @RequestMapping("/reject")
    public ModelAndView reject(HttpServletRequest request) {
        int applicationId = Integer.parseInt(request.getParameter("application_id"));

        serviceStore.rejectApply(applicationId);

        return pageList(request);
    }


    private ApplicationForm initApplyFromRequest(HttpServletRequest req) {
        ApplicationForm apply = new ApplicationForm();
        if (!StringUtils.isNullOrEmpty(req.getParameter("application_id")))
            apply.setId(Integer.parseInt(req.getParameter("application_id")));

        apply.setSn(req.getParameter("sn"));
        apply.setType(Consts.APPLY_TYPE_ADD);

        if (!StringUtils.isNullOrEmpty(req.getParameter("state_id")))
            apply.setStateId(Integer.parseInt(req.getParameter("state_id")));
        else
            apply.setStateId(Consts.APPLY_STATE_WAITING);

        apply.setApplyTime(new java.util.Date());

        return apply;
    }

    private Equipment initEquipmentFromRequest(HttpServletRequest req) {
        Equipment equipment = new Equipment();
        if (!StringUtils.isNullOrEmpty(req.getParameter("equipment_id")))
            equipment.setId(Integer.parseInt(req.getParameter("equipment_id")));
        equipment.setSn(req.getParameter("sn"));
        equipment.setName(req.getParameter("name"));
        if (!StringUtils.isNullOrEmpty(req.getParameter("category_id")))
            equipment.setCategoryId(Short.parseShort(req.getParameter("category_id")));
        equipment.setName(req.getParameter("name"));
        equipment.setModelNumber(req.getParameter("model_number"));
        equipment.setSpecifications(req.getParameter("specifications"));
        if (!StringUtils.isNullOrEmpty(req.getParameter("unit_price")))
            equipment.setUnitPrice(Float.parseFloat(req.getParameter("unit_price")));
        equipment.setVender(req.getParameter("vender"));
        equipment.setFactoryNumber(req.getParameter("factory_number"));
        if (!StringUtils.isNullOrEmpty(req.getParameter("manufacture_date")))
            equipment.setManufactureDate(Date.valueOf(req.getParameter("manufacture_date")));
        if (!StringUtils.isNullOrEmpty(req.getParameter("acquisition_date")))
            equipment.setAcquisitionDate(Date.valueOf(req.getParameter("acquisition_date")));
        if (!StringUtils.isNullOrEmpty(req.getParameter("scrap_date")))
            equipment.setScrapDate(Date.valueOf(req.getParameter("scrap_date")));
        equipment.setCountry(req.getParameter("country"));
        if (!StringUtils.isNullOrEmpty(req.getParameter("funding_subject")))
            equipment.setFundingSubjectId(Integer.parseInt(req.getParameter("funding_subject")));
        if (!StringUtils.isNullOrEmpty(req.getParameter("use_direction")))
            equipment.setUseDirectionId(Integer.parseInt(req.getParameter("use_direction")));
        if (!StringUtils.isNullOrEmpty(req.getParameter("state")))
            equipment.setStateId(Integer.parseInt(req.getParameter("state")));

        return equipment;
    }
}
