package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.RelatedResources;
import edu.ruc.labmgr.service.CurriculumService;
import edu.ruc.labmgr.service.RelatedResourceService;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/laboratory/jsp/res/book")
public class RelatedResourceController {
    @Autowired
    RelatedResourceService relatedResourceService;
    @Autowired
    CurriculumService curriculumService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value = "searchName", required = false) String name,
                                 @RequestParam(value = "searchCurriculumId", required = false) Integer curriculumId,
                                 @RequestParam(value = "searchUserId", required = false) Integer userId,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("laboratory/jsp/res/book/list");
        PageInfo<RelatedResources> pageInfo = relatedResourceService.selectListPage(name, curriculumId, userId, page);
        mav.addObject("pageInfo", pageInfo);

        List<Curriculum> curriculumList = curriculumService.selectAllCurriculums();
        mav.addObject("curriculumList", curriculumList);

        return mav;
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("laboratory/jsp/res/book/add");

        List<Curriculum> curriculumList = curriculumService.selectAllCurriculums();
        mav.addObject("curriculumList", curriculumList);

        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(RelatedResources relatedResource, HttpServletRequest request) {
        String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
        String uploadPath = request.getSession().getServletContext().getRealPath(path);
        String fullFilePath = uploadPath + "\\" + relatedResource.getDocumentName();

        relatedResource.setDocumentPath(fullFilePath);

        relatedResource.setUploadPerson(userService.getCurrentUserId());
        relatedResource.setUploadDate(new Date());

        relatedResourceService.insert(relatedResource);
        return "redirect:/laboratory/jsp/res/book/list";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        RelatedResources relatedResource = relatedResourceService.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/book/update");

        List<Curriculum> curriculumList = curriculumService.selectAllCurriculums();
        mav.addObject("curriculumList", curriculumList);

        mav.addObject("relatedResource", relatedResource);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(RelatedResources relatedResource,  HttpServletRequest request) {
        String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
        String uploadPath = request.getSession().getServletContext().getRealPath(path);
        String fullFilePath = uploadPath + "\\" + relatedResource.getDocumentName();
        relatedResource.setDocumentPath(fullFilePath);

        relatedResource.setUploadPerson(userService.getCurrentUserId());
        relatedResource.setUploadDate(new Date());

        relatedResourceService.update(relatedResource);
        return "redirect:/laboratory/jsp/res/book/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        relatedResourceService.delete(items);
        return "redirect:/laboratory/jsp/res/book/list";
    }


    @RequestMapping(value="/downloadFile",method=RequestMethod.GET)
    public void downloadFile(@RequestParam("id") Integer id, HttpServletResponse response) throws Exception{
        RelatedResources relatedResource = relatedResourceService.selectByPrimaryKey(id);
        String path = relatedResource.getDocumentPath();

        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setContentType("multipart/form-data");
        String strName = new String(relatedResource.getDocumentName().getBytes("GB2312"), "ISO_8859_1");

        String header = "attachment;fileName="+ strName;
        response.setHeader("Content-Disposition", header);

            File file = new File(path);
            System.out.println(file.getAbsolutePath());
            InputStream inputStream=new FileInputStream(file);
            OutputStream os=response.getOutputStream();
            byte[] b=new byte[2048];
            int length;
            while((length=inputStream.read(b))>0){
                os.write(b,0,length);
            }
            inputStream.close();

    }
}
