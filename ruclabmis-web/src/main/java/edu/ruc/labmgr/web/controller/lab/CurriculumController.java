package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
@Controller
@RequestMapping(value = "/curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    @RequestMapping(value = "/list", produces = "application/json")
    public
    @ResponseBody
    List<Curriculum> list(String name) {
        return curriculumService.getCurriculum(name);
    }
}
