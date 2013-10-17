package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Major;
import edu.ruc.labmgr.domain.Role;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.service.MajorService;
import edu.ruc.labmgr.service.RoleService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.MD5.CipherUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    private int currPage = 0;

    @RequestMapping("/list")
    public ModelAndView pageList(HttpServletRequest request) {
        currPage = request.getParameter("page") == null   ?
                (currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));

        UserCriteria userCriteria =  new UserCriteria();
        UserCriteria.Criteria criteria = userCriteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(request.getParameter("searchSN"))) {
            criteria.andSnLike("%" + request.getParameter("searchSN") + "%");
        }
        if (!StringUtils.isNullOrEmpty(request.getParameter("searchName"))) {
            criteria.andNameLike("%" + request.getParameter("searchName") + "%");
        }

        ObjectListPage<User> pageInfo = serviceUser.selectListPage(currPage, userCriteria);

        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/list");
        mav.addObject("users", pageInfo.getListObject());
        mav.addObject("page", pageInfo.getPageInfo());
        return mav;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request) {
        List<Role> roles = serviceRole.listAll();
        List<Major> majors = serviceMajor.listAll();

        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/add");
        mav.addObject("roles", roles);
        mav.addObject("majors", majors);
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request) {
        User user = initFromRequest(request);
        int result = serviceUser.insert(user);
        if (result > 0) {
            return pageList(request);
        } else {
            return null;
        }
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        User user = serviceUser.selectByPrimaryKey(id);
        List<Role> roles = serviceRole.listAll();
        List<Major> majors = serviceMajor.listAll();

        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/update");
        mav.addObject("user", user);
        mav.addObject("roles", roles);
        mav.addObject("majors", majors);
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request) {
        User user = initFromRequest(request);
        int result = serviceUser.update(user);
        if (result > 0) {
            return pageList(request);
        } else {
            return null;
        }
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        int result = serviceUser.delete(id);

        if (result > 0) {
            return pageList(request);
        } else {
            return null;
        }
    }

    private User initFromRequest(HttpServletRequest req) {
        User user = new User();
        if (!StringUtils.isNullOrEmpty(req.getParameter("id")))
            user.setId(Integer.parseInt(req.getParameter("id")));

        user.setSn(req.getParameter("sn"));

        if (!StringUtils.isNullOrEmpty(req.getParameter("password"))){
            String passwordMD5 = CipherUtil.generatePassword(req.getParameter("password"));
            user.setPassword(passwordMD5);
        }
        user.setName(req.getParameter("name"));
        user.setPhoneNum(req.getParameter("phoneNum"));
        user.setEmail(req.getParameter("email"));
        user.setComment(req.getParameter("comment"));
        user.setRoleId(Integer.parseInt(req.getParameter("role")));
        user.setMajorId(Integer.parseInt(req.getParameter("major")));
        return user;
    }
}
