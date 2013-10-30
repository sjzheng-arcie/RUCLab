package edu.ruc.labmgr.web.controller.equip;

import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.service.EquipmentService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
@Controller
@RequestMapping(value = "/equip")
public class EquipmentController {
    @Autowired
    private EquipmentService equipServicce;

    @RequestMapping(value = "/list/{pg}",method= RequestMethod.GET)
    public ModelAndView list(@PathVariable("pg") int pg){
        ModelAndView result = new ModelAndView();
        result.setViewName("equipment/jsp/dev/borrow/devicelist");

        PageInfo<Equipment> page = equipServicce.getPageAvaiableEquipments(pg);
        result.addObject("page",page);
        return result;
    }

    @RequestMapping(value = "/query/{pg}",method = RequestMethod.POST)
    public ModelAndView query(@RequestParam("sn")String sn,@RequestParam("name")String name,
                              @RequestParam("useDirect")int useDirect,@PathVariable("pg") int pg){
        ModelAndView result = new ModelAndView();
        result.setViewName("equipment/jsp/dev/borrow/devicelist");

        PageInfo<Equipment> page = equipServicce.getPageEquipments(sn,name,useDirect,pg);
        result.addObject("page",page);
        return result;
    }


}
