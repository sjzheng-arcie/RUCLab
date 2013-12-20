package edu.ruc.labmgr.web.controller;


import edu.ruc.labmgr.domain.Major;
import edu.ruc.labmgr.service.MajorService;
import edu.ruc.labmgr.service.MajorService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/laboratory/jsp/bas/major")
public class MajorController {
    @Autowired
    MajorService majorService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value = "searchName", required = false) String name,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("laboratory/jsp/bas/major/list");
        PageInfo<Major> pageInfo = majorService.selectListPage(name, page);
        mav.addObject("pageInfo", pageInfo);
        return mav;

    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("laboratory/jsp/bas/major/add");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Major major) {
        majorService.insert(major);
        return "redirect:/laboratory/jsp/bas/major/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        Major major = majorService.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/major/update");
        mav.addObject("major", major);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Major major) {
        majorService.update(major);
        return "redirect:/laboratory/jsp/bas/major/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        majorService.delete(items);
        return "redirect:/laboratory/jsp/bas/major/list";
    }
}
