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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
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

		String currentUserSn = userService.getCurrentUser().getSn();
		mav.addObject("currentUserSn",currentUserSn);

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
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public String delete(@RequestParam("items") int id) {
		relatedResourceService.delete(id);
		return "redirect:/laboratory/jsp/res/book/list";
	}

    @RequestMapping(value="/downloadFile",method=RequestMethod.GET)
    public void downloadFile(@RequestParam("id") Integer id, HttpServletResponse response,HttpServletRequest request) throws Exception{
        RelatedResources relatedResource = relatedResourceService.selectByPrimaryKey(id);
        String path = relatedResource.getDocumentPath();
		String fileName = relatedResource.getDocumentName();
		File file = new File(path);

		response.setContentType("text/html;charset=utf-8");
		// 完美解决IE浏览器下载中文乱码的问题,兼容IE,Firefox,Chorme
		String agent = request.getHeader("User-Agent");
		boolean isMSIE = (agent != null && agent.indexOf("MSIE") != -1);
		String fileName1 = null;
		if (isMSIE) {
			fileName1 = URLEncoder.encode(fileName, "UTF-8");
		} else {
			fileName1 = new String(fileName.getBytes("UTF-8"),
					"ISO-8859-1");
		}

		try {
			long fileLength = file.length();
			response.addHeader("Content-Length", "" + fileLength);
			response.setContentType("application/octet-stream;charset=UTF-8");
			// response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName1);
			response.setHeader("Content-Length", String.valueOf(fileLength));

			InputStream inputStream = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			byte[] data = new byte[2048];
			int length;
			while ((length = inputStream.read(data)) > 0) {
				os.write(data, 0, length);}
			inputStream.close();
			os.close();
		} catch (IOException e) {
			throw new ServletException(e.getMessage(), e);
		}

    }
}
