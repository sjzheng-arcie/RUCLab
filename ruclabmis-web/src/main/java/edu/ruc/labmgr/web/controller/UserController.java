package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.service.RoleService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/equipment/jsp/sys/user")
public class UserController {
    @Autowired
    UserService serviceUser;
    @Autowired
    RoleService serviceRole;

    @RequestMapping("/list")
    public ModelAndView pageList(HttpServletRequest request){
        int currentPage = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
        UserCriteria criteria = new UserCriteria();
        if(!StringUtils.isNullOrEmpty(request.getParameter("snLike")))
        {
            criteria.createCriteria().andSnLike("%"+request.getParameter("snLike")+"%");
        }
        if(!StringUtils.isNullOrEmpty(request.getParameter("nameLike")))
        {
            criteria.createCriteria().andNameLike("%"+request.getParameter("nameLike")+"%");
        }

        ObjectListPage<User> pageInfo = serviceUser.selectListPage(currentPage, criteria);

        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/list");
        mav.addObject("users",pageInfo.getListObject());
        mav.addObject("page",pageInfo.getPageInfo());
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request){
        User user = initFromRequest(request);
        int result = serviceUser.insert(user);
        if( result > 0 )
        {
            return pageList(request);
        }
        else
        {
            return null;
        }
    }

    @RequestMapping("/detail")
    public ModelAndView detail(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));

        User user =  serviceUser.selectByPrimaryKey(id);

        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/update");
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request){
        User user =  initFromRequest(request);
        int result = serviceUser.update(user);
        if( result > 0 )
        {
            return pageList(request);
        }
        else
        {
            return null;
        }
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        int result = serviceUser.delete(id);

        if( result > 0 )
        {
            return pageList(request);
        }
        else
        {
            return null;
        }
    }

    private User initFromRequest(HttpServletRequest req){
        User user = new User();
        if(!StringUtils.isNullOrEmpty(req.getParameter("id")))
            user.setId(Integer.parseInt(req.getParameter("id")));
        user.setSn(req.getParameter("sn"));
        user.setPassword(req.getParameter("password"));
        user.setName(req.getParameter("name"));
        user.setSex(Boolean.parseBoolean(req.getParameter("sex")));
        user.setPhoneNum(req.getParameter("phoneNum"));
        user.setEmail(req.getParameter("email"));
        //userreq.getParameter("roleID");
        user.setComment(req.getParameter("comment"));

        return user;
    }
}
