package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.ClassifService;
import edu.ruc.labmgr.service.StoreService;
import edu.ruc.labmgr.utils.Consts;
import edu.ruc.labmgr.utils.page.ObjectListPage;
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

    @RequestMapping("/applyList")
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
    public ModelAndView toAdd(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/addapply");

        return mav;
    }

    @RequestMapping("/toAddEquipmentToApply")
    public ModelAndView toAddEquipmentToApply(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/addapply");

        return mav;
    }


    //
//    @RequestMapping("/add")
//    public ModelAndView add(HttpServletRequest request) {
//        equipment equipment = initFromRequest(request);
//        int result = serviceequipment.insert(equipment);
//        if (result > 0) {
//            return pageList(request);
//        } else {
//            return null;
//        }
//    }
//
    @RequestMapping("/toAddEquipment")
    public ModelAndView toAddEquipment(HttpServletRequest request) {
//        Equipment equipment = initEquipmentFromRequest(request);
//        int applyId = request.getParameter("name");
//        int result = serviceStore.insertEquipmentIntoApply(equipment);
//        if (result > 0) {
//            return pageList(request);
//        } else {
        return null;
//        }
    }

    @RequestMapping("/toEditEquipment")
    public ModelAndView toEditEquipment(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        Equipment equipment = serviceStore.selectEquipmentByPrimaryKey(id);
        List<Classif> fundingSubjects = serviceClassif.getItemsByParentID(Consts.CLASSIF_FUNDING_SUBJECT);
        List<Classif> useDirections = serviceClassif.getItemsByParentID(Consts.CLASSIF_USE_DIRECTION);

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/editdevice");
        mav.addObject("equipment", equipment);
        mav.addObject("useDirections", useDirections);
        mav.addObject("fundingSubjects", fundingSubjects);
        return mav;
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        ViewStore store = serviceStore.selectByPrimaryKey(id);

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/updateapply");
        mav.addObject("store", store);
        return mav;
    }

    @RequestMapping("/editEquipment")
    public ModelAndView update(HttpServletRequest request) {
        Equipment equipment = initEquipmentFromRequest(request);
        int result = serviceStore.updateEquipmentByPrimaryKey(equipment);
        if (result > 0) {
            return pageList(request);
        } else {
            return null;
        }
    }
    //
//    @RequestMapping("/update")
//    public ModelAndView update(HttpServletRequest request) {
//        equipment equipment = initFromRequest(request);
//        int result = serviceequipment.update(equipment);
//        if (result > 0) {
//            return pageList(request);
//        } else {
//            return null;
//        }
//    }
//
//    @RequestMapping("/delete")
//    public ModelAndView delete(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        int result = serviceequipment.delete(id);
//
//        if (result > 0) {
//            return pageList(request);
//        } else {
//            return null;
//        }
//    }
//
//    @RequestMapping("/toUpdatePassword")
//    public ModelAndView toUpdatePassword(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/equipment/password");
//        mav.addObject("id",id);
//
//        return mav;
//    }
//
//    @RequestMapping("/updatePassword")
//    public ModelAndView updatePassword(HttpServletRequest request) {
//        String oriPassword = request.getParameter("oriPassword");
//        String newPassword = request.getParameter("newPassword");
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        int result = serviceequipment.updatePassword(id, oriPassword, newPassword);
//        if (result > 0) {
//            return pageList(request);
//        } else if (result == -1) {
//            ModelAndView mav = new ModelAndView("/equipment/jsp/sys/equipment/password");
//            mav.addObject("id",id);
//            mav.addObject("errMsg","原密码输入不一致，请重新输入!");
//            return mav;
//        } else {
//            return null;
//        }
//    }
//
//    private equipment initFromRequest(HttpServletRequest req) {
//        equipment equipment = new equipment();
//        if (!StringUtils.isNullOrEmpty(req.getParameter("id")))
//            equipment.setId(Integer.parseInt(req.getParameter("id")));
//
//        equipment.setSn(req.getParameter("sn"));
//
//        if (!StringUtils.isNullOrEmpty(req.getParameter("password"))){
//            String passwordMD5 = CipherUtil.generatePassword(req.getParameter("password"));
//            equipment.setPassword(passwordMD5);
//        }
//        equipment.setName(req.getParameter("name"));
//        equipment.setPhoneNum(req.getParameter("phoneNum"));
//        equipment.setEmail(req.getParameter("email"));
//        equipment.setComment(req.getParameter("comment"));
//        equipment.setRoleId(Integer.parseInt(req.getParameter("role")));
//        equipment.setMajorId(Integer.parseInt(req.getParameter("major")));
//        return equipment;
//    }
    private Equipment initEquipmentFromRequest(HttpServletRequest req) {
        Equipment equipment = new Equipment();
        if (!StringUtils.isNullOrEmpty(req.getParameter("id")))
            equipment.setId(Integer.parseInt(req.getParameter("id")));

        equipment.setSn(req.getParameter("sn"));
        equipment.setName(req.getParameter("name"));
        equipment.setCategoryId(Short.parseShort(req.getParameter("category_id")));
        equipment.setName(req.getParameter("name"));
        equipment.setModelNumber(req.getParameter("model_number"));
        equipment.setSpecifications(req.getParameter("specifications"));
        equipment.setUnitPrice(Float.parseFloat(req.getParameter("unit_price")));
        equipment.setFactoryNumber(req.getParameter("factory_number"));
        equipment.setManufactureDate(Date.valueOf(req.getParameter("manufacture_date")));
        equipment.setAcquisitionDate(Date.valueOf(req.getParameter("acquisition_date")));
        equipment.setCountry(req.getParameter("country"));
        equipment.setFundingSubjectId(Integer.parseInt(req.getParameter("funding_subject")));
        equipment.setUseDirectionId(Integer.parseInt(req.getParameter("use_direction")));
        equipment.setStateId(Integer.parseInt(req.getParameter("state")));

        return equipment;
    }
}
