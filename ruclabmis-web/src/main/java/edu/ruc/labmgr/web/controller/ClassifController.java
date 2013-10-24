package edu.ruc.labmgr.web.controller;

import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.service.ClassifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/classif")
public class ClassifController {

    @Autowired
    ClassifService service;

    @RequestMapping("/list")
    public ModelAndView listAllCategories(HttpServletRequest request, HttpServletResponse response) {
        List<Classif> items = service.getItemsByParentID(0);
        //制定视图，也就是list.jsp
        ModelAndView mav = new ModelAndView("views/list");
        mav.addObject("items", items);
        return mav;
    }
}
