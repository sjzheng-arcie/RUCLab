package edu.ruc.labmgr.web.controller.equip;

import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.service.ApplyStrategic.ApplyContext;
import edu.ruc.labmgr.service.ClassifService;
import edu.ruc.labmgr.service.EquipmentService;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EquipmentController {
    @Autowired
    private EquipmentService serviceEquipment;
    @Autowired
    ClassifService serviceClassif;

    //备选设备列表
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/deviceList")
    public ModelAndView deviceList(@PathVariable("applyType")String applyType) {
        return pageDeviceList("", "", 0, applyType, 1);
    }

    //备选设备列表
    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/deviceList", method = RequestMethod.POST)
    public ModelAndView pageDeviceList(@RequestParam("searchSN")String sn,@RequestParam("searchName")String name,
                                       @RequestParam("searchDirect")int useDirect,@PathVariable("applyType")String applyType,
                                       @RequestParam("page") int page) {
        ModelAndView result = new ModelAndView();
        result.setViewName("/equipment/jsp/common/devicelist");

        List<Classif> useDirections = serviceClassif.getItemsByParentID(Types.ClassifType.USE_DIRECTION.getValue());

        Types.ApplyType type = Types.ApplyType.getApplyTypeFromStr(applyType);
        ApplyContext applyContext = new ApplyContext(type);

        PageInfo<Equipment> pageInfo = applyContext.pageDeviceList(sn, name, useDirect, page);
//        result.addObject("applyType", applyType);
        result.addObject("pageInfo", pageInfo);
        result.addObject("useDirections", useDirections);
        return result;
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/returnEquipments", method = RequestMethod.POST)
    public ModelAndView returnEquipments(@RequestParam("items") List<Integer> items,
                                @PathVariable("applyType")String applyType) {
        serviceEquipment.returnEquipments(items);
        return deviceList(applyType);
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        List<Classif> fundingSubjects = serviceClassif.getItemsByParentID(Types.ClassifType.FUNDING_SUBJECT.getValue());
        List<Classif> useDirections = serviceClassif.getItemsByParentID(Types.ClassifType.USE_DIRECTION.getValue());
        List<Classif> states = serviceClassif.getItemsByParentID(Types.ClassifType.EQUIPMENT_STATE.getValue());

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/info/adddevice");
        mav.addObject("useDirections", useDirections);
        mav.addObject("states", states);
        mav.addObject("fundingSubjects", fundingSubjects);
        return mav;
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/insert", method = RequestMethod.POST)
    public ModelAndView insert(Equipment equipment, @PathVariable("applyType")String applyType) {
        serviceEquipment.insertEquipment(equipment);
        return deviceList(applyType);
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id,
                                          @PathVariable("applyType")String applyType) {
        Equipment equipment = serviceEquipment.selectByPrimaryKey(id);

        List<Classif> fundingSubjects = serviceClassif.getItemsByParentID(Types.ClassifType.FUNDING_SUBJECT.getValue());
        List<Classif> useDirections = serviceClassif.getItemsByParentID(Types.ClassifType.USE_DIRECTION.getValue());
        List<Classif> states = serviceClassif.getItemsByParentID(Types.ClassifType.EQUIPMENT_STATE.getValue());

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/info/editdevice");
        mav.addObject("equipment", equipment);
        mav.addObject("useDirections", useDirections);
        mav.addObject("states", states);
        mav.addObject("fundingSubjects", fundingSubjects);
        return mav;
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/update", method = RequestMethod.POST)
    public ModelAndView update(Equipment equipment, @PathVariable("applyType")String applyType) throws Exception {
        serviceEquipment.updateEquipment(equipment);
        return deviceList(applyType);
    }

    @RequestMapping(value = "/equipment/jsp/dev/{applyType}/deleteEquipments", method = RequestMethod.POST)
    public ModelAndView delete( @RequestParam("items") List<Integer> items,
                                          @PathVariable("applyType")String applyType) {
        serviceEquipment.deleteEquipments(items);
        return deviceList(applyType);
    }

}
