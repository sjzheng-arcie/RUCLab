package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.CurriculumClass;
import edu.ruc.labmgr.domain.Experiment;
import edu.ruc.labmgr.service.CurriculumClassService;
import edu.ruc.labmgr.service.CurriculumService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * User: sjzheng
 * Date: 13-12-2
 * Time: 下午3:55
 * Des:
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/experiment/experiment")
public class ExperimentInfoController {
	@Autowired
	private CurriculumClassService classService;
	@Autowired
	private UserService userService;
	@Autowired
	private CurriculumService curriculumService;

	@RequestMapping(value = "/courselist",method = RequestMethod.GET)
	public ModelAndView courseList(@RequestParam int page){
		ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/experiment/courselist");
		Subject currentUser = SecurityUtils.getSubject();
		int id = userService.getCurrentUserId();
		PageInfo<CurriculumClass> pageInfo = null;
		if(currentUser.hasRole("student"))
			 pageInfo = classService.getPageClassbyPageNum(page,id, Types.Role.STUDENT);
		else if (currentUser.hasRole("administrators"))
			pageInfo = classService.getPageClassbyPageNum(page,id,Types.Role.ADMIN);
		else
			pageInfo = classService.getPageClassbyPageNum(page,id, Types.Role.TEACHER);
		mv.addObject("pageInfo", pageInfo);
		return mv;
	}
	@RequestMapping(value = "/myexperimentlist",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView experimentList(@RequestParam int page,@RequestParam("courseId") int curriumId
									   ){
		ModelAndView view = new ModelAndView("laboratory/jsp/experiment/experiment/myexperimentlist");
		PageInfo<Experiment> pageInfo = curriculumService.getExperimentbyClassId(curriumId,page);
		view.addObject("pageInfo",pageInfo);
		return view;
	}
    @RequestMapping(value = "/add",method = {RequestMethod.GET})
    public ModelAndView addExperiment(int cid,int instructId){
        ModelAndView mv = new ModelAndView("laboratory/jsp/experiment/experiment/add");
        Curriculum curriculum = curriculumService.getCurriculum(cid);
        mv.addObject("curriculum",curriculum);
        mv.addObject("instructId",instructId);
        return mv;
    }
    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public void addExperimentData(Experiment exp,MultipartFile file,HttpServletRequest request){
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename()+"_"+System.currentTimeMillis();
            String path = request.getSession().getServletContext().getRealPath("/")+"/data/";
            File local = new File(path+name);
            try {
                file.transferTo(local);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
