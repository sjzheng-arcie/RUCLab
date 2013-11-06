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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

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

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView list(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                             @RequestParam("page") int pg) {
        PageInfo<EquipmentCheck> page = equipCheckService.getPageEquipmentCheckByName(name, pg);
        ModelAndView mv = new ModelAndView("equipment/jsp/dev/check/list");
        mv.addObject("pageInfo", page);
        return mv;
    }

    @RequestMapping(value = "/profitList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView profitList(@RequestParam("page") int page) {
        PageInfo<Equipment> pageInfo = equipCheckService.getPageInventoryProfit(page);
        ModelAndView mv = new ModelAndView("equipment/jsp/dev/check/profit-list");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }

    @RequestMapping(value = "/loseList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView lostList(@RequestParam("page") int page) {
        PageInfo<EquipmentCheck> pageInfo = equipCheckService.getPageInventoryLose(page);
        ModelAndView mv = new ModelAndView("equipment/jsp/dev/check/lost-list");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }

    @RequestMapping(value = "/importRealCheck", method = RequestMethod.GET)
    public String importRealCheck() {
        return "equipment/jsp/dev/check/import-realcheck";
    }

    @RequestMapping(value = "/importRealCheck", method = RequestMethod.POST)
    public String importRealCheck(boolean clean, MultipartFile file) throws IOException{
        if (!file.isEmpty()){
            String name = file.getOriginalFilename();
            File local = new File(System.getProperty("java.io.tmpdir")+name);
            file.transferTo(local);
            System.out.println("上传文件成功!");
        }
        return "forward:/equipCheck/list?page=1";
    }
}
