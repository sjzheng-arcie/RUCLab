package edu.ruc.labmgr.web.controller.lab;


import edu.ruc.labmgr.domain.Organization;
import edu.ruc.labmgr.service.OrganizationService;
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
@RequestMapping("/laboratory/jsp/bas/org")
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList() {
        ModelAndView mav = new ModelAndView("laboratory/jsp/bas/org/list");
        List<Organization> organizations = organizationService.selectListPage();
        mav.addObject("organizations", organizations);
        return mav;

    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        List<Organization> organizations = organizationService.selectAllOrganizations();
        ModelAndView mav = new ModelAndView("laboratory/jsp/bas/org/add");
        mav.addObject("organizations", organizations);
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Organization organization) {
        organizationService.insert(organization);
        return "redirect:/laboratory/jsp/bas/org/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        List<Organization> organizations = organizationService.selectAllOrganizations();
        Organization organization = organizationService.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/bas/org/update");
        mav.addObject("organization", organization);
        mav.addObject("organizations", organizations);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Organization organization) {
        organizationService.update(organization);
        return "redirect:/laboratory/jsp/bas/org/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("items") List<Integer> items) {
        organizationService.delete(items);
        return "redirect:/laboratory/jsp/bas/org/list";
    }
}
