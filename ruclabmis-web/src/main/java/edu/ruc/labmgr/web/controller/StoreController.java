package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.ViewStore;
import edu.ruc.labmgr.domain.ViewStoreCriteria;
import edu.ruc.labmgr.service.StoreService;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/equipment/jsp/dev/store")
public class StoreController {
    @Autowired
    StoreService serviceStore;


    private int currPage = 0;

    @RequestMapping("/applylist")
    public ModelAndView pageList(HttpServletRequest request) {
        currPage = request.getParameter("page") == null   ?
                (currPage > 0 ? currPage:1) : Integer.parseInt(request.getParameter("page"));

        ViewStoreCriteria viewStoreCriteria =  new ViewStoreCriteria();
        ViewStoreCriteria.Criteria criteria = viewStoreCriteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(request.getParameter("searchSN"))) {
            criteria.andApplicationSnLike("%" + request.getParameter("searchSN") + "%");
        }
        if (!StringUtils.isNullOrEmpty(request.getParameter("searchName"))) {
            criteria.andNameLike("%" + request.getParameter("searchName") + "%");
        }

        ObjectListPage<ViewStore> pageInfo = serviceStore.selectListPage(currPage, viewStoreCriteria);

        ModelAndView mav = new ModelAndView("/equipment/jsp/dev/store/applylist");
        mav.addObject("stores", pageInfo.getListObject());
        mav.addObject("page", pageInfo.getPageInfo());
        return mav;
    }
//
//    @RequestMapping("/toAdd")
//    public ModelAndView toAdd(HttpServletRequest request) {
//        List<Role> roles = serviceRole.listAll();
//        List<Major> majors = serviceMajor.listAll();
//
//        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/add");
//        mav.addObject("roles", roles);
//        mav.addObject("majors", majors);
//        return mav;
//    }
//
//    @RequestMapping("/add")
//    public ModelAndView add(HttpServletRequest request) {
//        User user = initFromRequest(request);
//        int result = serviceUser.insert(user);
//        if (result > 0) {
//            return pageList(request);
//        } else {
//            return null;
//        }
//    }
//
//    @RequestMapping("/toUpdate")
//    public ModelAndView toUpdate(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        User user = serviceUser.selectByPrimaryKey(id);
//        List<Role> roles = serviceRole.listAll();
//        List<Major> majors = serviceMajor.listAll();
//
//        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/update");
//        mav.addObject("user", user);
//        mav.addObject("roles", roles);
//        mav.addObject("majors", majors);
//        return mav;
//    }
//
//    @RequestMapping("/update")
//    public ModelAndView update(HttpServletRequest request) {
//        User user = initFromRequest(request);
//        int result = serviceUser.update(user);
//        if (result > 0) {
//            return pageList(request);
//        } else {
//            return null;
//        }
//    }
//
//    @RequestMapping("/delete")
//    public ModelAndView delete(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        int result = serviceUser.delete(id);
//
//        if (result > 0) {
//            return pageList(request);
//        } else {
//            return null;
//        }
//    }
//
//    @RequestMapping("/toUpdatePassword")
//    public ModelAndView toUpdatePassword(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/password");
//        mav.addObject("id",id);
//
//        return mav;
//    }
//
//    @RequestMapping("/updatePassword")
//    public ModelAndView updatePassword(HttpServletRequest request) {
//        String oriPassword = request.getParameter("oriPassword");
//        String newPassword = request.getParameter("newPassword");
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        int result = serviceUser.updatePassword(id, oriPassword, newPassword);
//        if (result > 0) {
//            return pageList(request);
//        } else if (result == -1) {
//            ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/password");
//            mav.addObject("id",id);
//            mav.addObject("errMsg","原密码输入不一致，请重新输入!");
//            return mav;
//        } else {
//            return null;
//        }
//    }
//
//    private User initFromRequest(HttpServletRequest req) {
//        User user = new User();
//        if (!StringUtils.isNullOrEmpty(req.getParameter("id")))
//            user.setId(Integer.parseInt(req.getParameter("id")));
//
//        user.setSn(req.getParameter("sn"));
//
//        if (!StringUtils.isNullOrEmpty(req.getParameter("password"))){
//            String passwordMD5 = CipherUtil.generatePassword(req.getParameter("password"));
//            user.setPassword(passwordMD5);
//        }
//        user.setName(req.getParameter("name"));
//        user.setPhoneNum(req.getParameter("phoneNum"));
//        user.setEmail(req.getParameter("email"));
//        user.setComment(req.getParameter("comment"));
//        user.setRoleId(Integer.parseInt(req.getParameter("role")));
//        user.setMajorId(Integer.parseInt(req.getParameter("major")));
//        return user;
//    }
}
