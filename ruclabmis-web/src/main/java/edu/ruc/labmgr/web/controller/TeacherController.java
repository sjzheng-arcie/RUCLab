package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/equipment/jsp/sys/user")
public class TeacherController {
    @Autowired
    TeacherService serviceTeacher;
    @Autowired
    RoleService serviceRole;
    @Autowired
    MajorService serviceMajor;
    @Autowired
    TitleService serviceTitle;
    @Autowired
    PositionService servicePosition;
    @Autowired
    OrganizationService serviceOrganization;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value = "searchSN", required = false, defaultValue = "") String sn,
                                 @RequestParam(value = "searchName", required = false, defaultValue = "") String name,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView result = new ModelAndView();
        result.setViewName("/equipment/jsp/sys/user/list");

        PageInfo<Teacher> pageInfo = serviceTeacher.selectListPage(sn, name, page);
        result.addObject("pageInfo", pageInfo);
        return result;
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        List<Role> roles = serviceRole.listAllWithoutStudent();
        List<Major> majors = serviceMajor.listAll();
        List<Title> titles = serviceTitle.selectAllTitles();
        List<Position> positions = servicePosition.selectAllPositions();
        List<Organization> organizations = serviceOrganization.selectAllOrganizations();

        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/add");
        mav.addObject("roles", roles);
        mav.addObject("majors", majors);
        mav.addObject("titles", titles);
        mav.addObject("positions", positions);
        mav.addObject("organizations", organizations);

        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Teacher teacher) {
        serviceTeacher.insert(teacher);
        return "redirect:/equipment/jsp/sys/user/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        Teacher teacher = serviceTeacher.selectByPrimaryKey(id);
        List<Role> roles = serviceRole.listAllWithoutStudent();
        List<Major> majors = serviceMajor.listAll();
        List<Title> titles = serviceTitle.selectAllTitles();
        List<Position> positions = servicePosition.selectAllPositions();
        List<Organization> organizations = serviceOrganization.selectAllOrganizations();

        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/update");
        mav.addObject("teacher", teacher);
        mav.addObject("roles", roles);
        mav.addObject("majors", majors);
        mav.addObject("titles", titles);
        mav.addObject("positions", positions);
        mav.addObject("organizations", organizations);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Teacher teacher) {
        serviceTeacher.update(teacher);
        return "redirect:/equipment/jsp/sys/user/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        for (int id : items) {
            serviceTeacher.delete(id);
        }
        return "redirect:/equipment/jsp/sys/user/list";
    }

    @RequestMapping(value = "/toUpdatePassword", method = RequestMethod.GET)
    public ModelAndView toUpdatePassword(@RequestParam(value = "id", required = false, defaultValue = "-1") int id) {
        //没有传进id则取出当前登录用户id
        if (id == -1) {
            id = serviceTeacher.getCurrentUserId();
        }
        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/password");
        mav.addObject("id", id);
        return mav;
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(@RequestParam("id") int id,
                                 @RequestParam(value = "oriPassword", required = false) String oriPassword,
                                 @RequestParam("newPassword") String newPassword) throws Exception {
        serviceTeacher.updatePassword(id, oriPassword, newPassword);
        return "redirect:/equipment/jsp/sys/user/list";
    }

    @RequestMapping(value = "/autoFillUserName", produces = "application/json")
    public
    @ResponseBody
    List<Teacher> getUsersByName(
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String name = request.getParameter("param");
        return serviceTeacher.getTeacherListNameLike(name);
    }
}
