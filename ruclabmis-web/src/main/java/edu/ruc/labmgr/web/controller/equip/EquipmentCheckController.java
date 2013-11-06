package edu.ruc.labmgr.web.controller.equip;

import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.domain.EquipmentCheck;
import edu.ruc.labmgr.service.EquipmentCheckService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
@Controller
@RequestMapping(value = "/equipCheck")
public class EquipmentCheckController {
    @Autowired
    private EquipmentCheckService equipCheckService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView list(@RequestParam(value = "name",required = false,defaultValue = "") String name,
                             @RequestParam("page") int pg) {
        PageInfo<EquipmentCheck> page = equipCheckService.getPageEquipmentCheckByName(name,pg);
        ModelAndView mv = new ModelAndView("equipment/jsp/dev/check/list");
        mv.addObject("pageInfo", page);
        return mv;
    }
    @RequestMapping(value = "/profitList",method = RequestMethod.GET)
    public ModelAndView profitList(@RequestParam("page") int pg){
        PageInfo<Equipment> page = equipCheckService.getPageInventoryProfit(pg);
        ModelAndView mv = new ModelAndView("equipment/jsp/dev/check/profit-list");
        mv.addObject("pageInfo", page);
        return mv;
    }
    @RequestMapping(value = "/loseList",method = RequestMethod.GET)
    public ModelAndView lostList(@RequestParam("page") int pg){
        PageInfo<EquipmentCheck> page = equipCheckService.getPageInventoryLose(pg);
        ModelAndView mv = new ModelAndView("equipment/jsp/dev/check/lost-list");
        mv.addObject("pageInfo", page);
        return mv;
    }
}
