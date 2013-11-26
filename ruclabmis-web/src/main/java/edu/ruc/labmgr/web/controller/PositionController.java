package edu.ruc.labmgr.web.controller;


import edu.ruc.labmgr.domain.Position;
import edu.ruc.labmgr.domain.Position;
import edu.ruc.labmgr.service.PositionService;
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
@RequestMapping("/laboratory/jsp/bas/position")
public class PositionController {
    @Autowired
    PositionService positionService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value = "searchName", required = false) String name,
                                 @RequestParam(value = "searchRank", required = false) String rank,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("laboratory/jsp/bas/position/list");
        PageInfo<Position> pageInfo = positionService.selectListPage(name, rank, page);
        mav.addObject("pageInfo", pageInfo);
        return mav;

    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("laboratory/jsp/bas/position/add");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Position position) {
        positionService.insert(position);
        return "redirect:/laboratory/jsp/bas/position/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        Position position = positionService.selectByPrimerKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/position/update");
        mav.addObject("position", position);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Position position) {
        positionService.update(position);
        return "redirect:/laboratory/jsp/bas/position/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        positionService.delete(items);
        return "redirect:/laboratory/jsp/bas/position/list";
    }
}
