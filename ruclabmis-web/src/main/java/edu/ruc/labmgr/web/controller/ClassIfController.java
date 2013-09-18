package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.ClassIf;
import edu.ruc.labmgr.service.ClassIfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/classif")
public class ClassIfController {

    @Autowired
    ClassIfService service;

    @RequestMapping("/list")
    public ModelAndView listall(HttpServletRequest request, HttpServletResponse response) {
        List<ClassIf> items = service.getAllItems();
        //制定视图，也就是list.jsp
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("items", items);
        return mav;
    }
}
