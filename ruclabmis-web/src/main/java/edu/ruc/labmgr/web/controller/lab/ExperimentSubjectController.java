package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.ExperimentSubject;
import edu.ruc.labmgr.service.ExperimentSubjectService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/laboratory/jsp/res/experimentsubject")
public class ExperimentSubjectController {
    @Autowired
    ExperimentSubjectService experimentSubjectService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value = "searchName", required = false) String name,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("laboratory/jsp/res/experimentsubject/list");
        PageInfo<ExperimentSubject> pageInfo = experimentSubjectService.selectListPage(name,  page);
        mav.addObject("pageInfo", pageInfo);
        return mav;
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("laboratory/jsp/res/experimentsubject/add");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ExperimentSubject experimentSubject) {
        experimentSubjectService.insert(experimentSubject);
        return "redirect:/laboratory/jsp/res/experimentsubject/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        ExperimentSubject experimentSubject = experimentSubjectService.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/experimentsubject/update");
        mav.addObject("experimentSubject", experimentSubject);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ExperimentSubject experimentSubject) {
        experimentSubjectService.update(experimentSubject);
        return "redirect:/laboratory/jsp/res/experimentsubject/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        experimentSubjectService.delete(items);
        return "redirect:/laboratory/jsp/res/experimentsubject/list";
    }
}
