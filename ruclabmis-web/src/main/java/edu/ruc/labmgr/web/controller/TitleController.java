package edu.ruc.labmgr.web.controller;


import edu.ruc.labmgr.domain.Title;
import edu.ruc.labmgr.service.TitleService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/laboratory/jsp/bas/title")
public class TitleController {
    @Autowired
    TitleService titleService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value = "searchName", required = false) String name,
                                 @RequestParam(value = "searchRank", required = false) String rank,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("laboratory/jsp/bas/title/list");
        PageInfo<Title> pageInfo = titleService.selectListPage(name, rank, page);
        mav.addObject("pageInfo", pageInfo);
        return mav;

    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/title/add");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Title title) {
        titleService.insert(title);
        return "redirect:list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        Title title = titleService.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/title/update");
        mav.addObject("title", title);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Title title) {
        titleService.update(title);
        return "redirect:/laboratory/jsp/bas/title/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        titleService.delete(items);
        return "redirect:/laboratory/jsp/bas/title/list";
    }
}
