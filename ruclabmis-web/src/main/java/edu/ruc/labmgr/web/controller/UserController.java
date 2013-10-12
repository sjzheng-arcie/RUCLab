package edu.ruc.labmgr.web.controller;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Role;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.service.RoleService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/equipment/jsp/sys/user")
public class UserController {
    @Autowired
    UserService serviceUser;
    @Autowired
    RoleService serviceRole;

    @RequestMapping("/list")
    public ModelAndView pageList(HttpServletRequest request,HttpServletResponse response){
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

        ObjectListPage<User> pageInfo = serviceUser.selectUserListPage(currentPage, criteria);

        ModelAndView mav = new ModelAndView("/equipment/jsp/sys/user/list");
        mav.addObject("users",pageInfo.getListObject());
        mav.addObject("page",pageInfo.getPageInfo());
        return mav;
    }
}
