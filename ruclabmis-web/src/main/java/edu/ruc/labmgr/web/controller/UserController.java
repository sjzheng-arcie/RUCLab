package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.MajorService;
import edu.ruc.labmgr.service.RoleService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.MD5.CipherUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/equipment/jsp/sys/user")
public class UserController {
    @Autowired
    UserService serviceUser;
    @Autowired
    RoleService serviceRole;
    @Autowired
    MajorService serviceMajor;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value="searchSN", required = false, defaultValue = "")String sn,
                                 @RequestParam(value="searchName", required = false, defaultValue = "")String name,
                                 @RequestParam(value="page", required = false, defaultValue = "1") int page){
        ModelAndView result = new ModelAndView();
        result.setViewName("/equipment/jsp/sys/user/list");

        PageInfo<User> pageInfo = serviceUser.selectListPage(sn, name, page);
        result.addObject("pageInfo",pageInfo);
        return result;
    }

    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    public ModelAndView toAdd() {
        List<Role> roles = serviceRole.listAll();
        List<Major> majors = serviceMajor.listAll();

        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/add");
        mav.addObject("roles", roles);
        mav.addObject("majors", majors);
        return mav;
    }

    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public String add(User user) {
        serviceUser.insert(user);
        return "redirect:/equipment/jsp/sys/user/list";
    }

    @RequestMapping(value = "/toUpdate",method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id")int id) {
        User user = serviceUser.selectByPrimaryKey(id);
        List<Role> roles = serviceRole.listAll();
        List<Major> majors = serviceMajor.listAll();

        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/update");
        mav.addObject("user", user);
        mav.addObject("roles", roles);
        mav.addObject("majors", majors);
        return mav;
    }

    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public String update(User user) {
        serviceUser.update(user);
        return "redirect:/equipment/jsp/sys/user/list";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("items")List<Integer> items) {
        for(int id : items){
            serviceUser.delete(id);
        }
        return "redirect:/equipment/jsp/sys/user/list";
    }

    @RequestMapping(value = "/toUpdatePassword",method = RequestMethod.GET)
    public ModelAndView toUpdatePassword(@RequestParam("id")int id) {
        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/password");
        mav.addObject("id",id);
        return mav;
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(@RequestParam("id")int id,
                                       @RequestParam("oriPassword")String oriPassword,
                                       @RequestParam("newPassword")String newPassword) {
        serviceUser.updatePassword(id, oriPassword, newPassword);
        return "redirect:/equipment/jsp/sys/user/list";
    }
}
