package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.CipherUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/views")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    /**
     * 测试springmvc与mybatis整合成功
     *
     * @param sn
     * @param request
     * @return
     */
    @RequestMapping("/{sn}/showUser")
    public String showUser(@PathVariable String sn, HttpServletRequest request) {
        User user = userService.getUserByLoginSn(sn);
        System.out.println(user.getName());
        request.setAttribute("user", user);
        return "/views/showUser";
    }

    /**
     * 跳转至登录页
     *
     * @param request
     * @return
     */
    @RequestMapping("/tologin")
    public String tologin(HttpServletRequest request, HttpServletResponse response, Model model) {
        logger.debug("来自IP[" + request.getRemoteHost() + "]的访问");
        return "login";
    }

    /**
     * 登录示例
     *
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        String result = "/login";
        // 此处默认有值
        String userSn = request.getParameter("userSn");
        //MD5加密
        String password = CipherUtil.generatePassword(request.getParameter("password")).toLowerCase();
        //String password = request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(userSn, password);

        Subject currentUser = SecurityUtils.getSubject();
        try {
            System.out.println("----------------------------");
            if (!currentUser.isAuthenticated()) {
                token.setRememberMe(false);
                currentUser.login(token);
            }
            System.out.println("result: " + result);
            result = "redirect:/";
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = "login";
        }
        return result;
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout() {

        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        String result = "redirect:/";
        return result;
    }

    /**
     * 检查
     *
     * @return
     */
    @RequestMapping(value = "/chklogin", method = RequestMethod.POST)
    @ResponseBody
    public String chkLogin() {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            return "false";
        }
        return "true";
    }
}
