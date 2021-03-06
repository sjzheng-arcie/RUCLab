package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.MD5.CipherUtil;
import edu.ruc.labmgr.utils.Types;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/{system}/login")
    public String showUser(@PathVariable String system, HttpServletRequest request) {
        return "/"+system+"/login";
    }
    @RequestMapping("/{system}/excutelogin")
    public String login(@PathVariable String system,HttpServletRequest request) {
        String result = system+"/login";
        String userSn = request.getParameter("username");
        String password = CipherUtil.generatePassword(request.getParameter("password"));
        UsernamePasswordToken token = new UsernamePasswordToken(userSn, password);
        Subject currentUser = SecurityUtils.getSubject();
        if(system.equals("equipment")){
            token.setRememberMe(false);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException e) {
                request.setAttribute("userNameNotExist", "* 用户名不存在");
                request.setAttribute("nonexistUserName", userSn);
                result = "equipment/login";
                return result;
            } catch (IncorrectCredentialsException e) {
                request.setAttribute("passwordNotMatch", "* 密码错误");
                request.setAttribute("nonexistUserName", userSn);
                result = "equipment/login";
                return result;
            }

            if (currentUser.hasRole(Types.Role.ADMIN.getName())) {
                result = "redirect:/equipment/index";
            } else if (currentUser.hasRole("teacher")) {
                result = "redirect:/equipment/teacher_index";
            } else if (currentUser.hasRole("leader")) {
                result = "redirect:/equipment/leader_index";
            } else if (currentUser.hasRole("equipment_admin")) {
                result = "redirect:/equipment/admin_index";
            }else{
				request.setAttribute("userNameNotExist","* 您无权进入本系统");
			}
        }else {
            token.setRememberMe(false);
            try {
                currentUser.login(token);
            }catch(UnknownAccountException e){
                request.setAttribute("userNameNotExist","* 用户名不存在");
                request.setAttribute("preUserName",userSn);

                result="laboratory/login";
                return result;
            }catch (IncorrectCredentialsException e){
                request.setAttribute("passwordNotMatch","* 密码错误");
                request.setAttribute("preUserName",userSn);
                result="laboratory/login";
                return result;
            }
            if (currentUser.hasRole(Types.Role.ADMIN.getName())) {
                result = "redirect:/laboratory/index";
            } else if (currentUser.hasRole(Types.Role.EQUIPMENT_ADMIN.getName())){
                result = "redirect:/laboratory/index";
            }else if (currentUser.hasRole(Types.Role.STUDENT.getName())){
                result = "redirect:/laboratory/index";
            }else if (currentUser.hasRole(Types.Role.TEACHER.getName())){
                result = "redirect:/laboratory/index";
            }else if (currentUser.hasRole(Types.Role.LEADER.getName())){
                result = "redirect:/laboratory/index";
            }else if (currentUser.hasRole(Types.Role.LAB_ADMIN.getName())){
                result = "redirect:/laboratory/index";
            }else{
				request.setAttribute("userNameNotExist","* 您无权进入本系统");
			}
        }
        return result;
    }
    @RequestMapping("/{system}/logout")
    public String logout(@PathVariable String system,HttpServletRequest request) {
        String result = "redirect:/login/"+system+"/login";
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return result;
    }
}
