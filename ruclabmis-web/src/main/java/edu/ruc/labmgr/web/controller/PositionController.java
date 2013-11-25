package edu.ruc.labmgr.web.controller;


import edu.ruc.labmgr.domain.Position;
import edu.ruc.labmgr.service.PositionService;
import edu.ruc.labmgr.service.PositionService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/laboratory/jsp/bas/position")
public class PositionController {
    @Autowired
    PositionService positionService;
    private int currPage = 0;

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        return pageList(null, null, 1);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ModelAndView pageList(@RequestParam("searchName") String name,
                                 @RequestParam("searchRank") String rank, @RequestParam("page") int page) {


        ModelAndView mav = new ModelAndView("laboratory/jsp/bas/position/list");
        PageInfo<Position> pageInfo = positionService.selectListPage(name, rank, page);
        mav.addObject("pageInfo", pageInfo);
        return mav;

    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("laboratory/jsp/bas/position/add");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView Add(Position Position) {
        positionService.insert(Position);
        return pageList(null, null, 1);

    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.POST)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        Position Position = positionService.selectByPrimerKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/position/update");
        mav.addObject("Position", Position);
        return mav;

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView Update(Position Position) {
        positionService.update(Position);
        return pageList(null, null, 1);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam("id") int id) {
        positionService.delete(id);
        return pageList(null, null, 1);

    }
}
