package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.ExamItemPool;
import edu.ruc.labmgr.service.ExamItemPoolService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/laboratory/jsp/res/question")
public class ExamItemPoolController {
    @Autowired
    ExamItemPoolService examItemPoolService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value = "searchName", required = false) String name,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("laboratory/jsp/res/question/list");
        PageInfo<ExamItemPool> pageInfo = examItemPoolService.selectListPage(name,  page);
        mav.addObject("pageInfo", pageInfo);
        return mav;
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("laboratory/jsp/res/question/add");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ExamItemPool examItemPool) {
        examItemPoolService.insert(examItemPool);
        return "redirect:/laboratory/jsp/res/question/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        ExamItemPool examItemPool = examItemPoolService.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/question/update");
        mav.addObject("examItemPool", examItemPool);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ExamItemPool examItemPool) {
        examItemPoolService.update(examItemPool);
        return "redirect:/laboratory/jsp/res/question/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        examItemPoolService.delete(items);
        return "redirect:/laboratory/jsp/res/question/list";
    }
}
