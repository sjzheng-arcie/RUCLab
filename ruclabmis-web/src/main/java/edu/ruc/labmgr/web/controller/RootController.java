package edu.ruc.labmgr.web.controller;


import edu.ruc.labmgr.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/equipment")
public class RootController {
    private static Logger logger = LoggerFactory.getLogger(RootController.class);
    @Autowired
    private UserService userService;



    /**
     * 跳转至登录页
     *
     * @param request
     * @return
     */
    @RequestMapping("/equipment/gotoindex")
    public String gotoIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
        logger.debug("来自IP[" + request.getRemoteHost() + "]的访问");
        return "/equipment/index";
    }
	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/equipment/index");
		return mav;
	}




}
