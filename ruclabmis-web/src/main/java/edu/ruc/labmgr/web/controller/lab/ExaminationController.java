package edu.ruc.labmgr.web.controller.lab;


import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.page.PageInfo;
import edu.ruc.labmgr.web.controller.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/laboratory/jsp/res/examination")
public class ExaminationController {
    @Autowired
    CurriculumExaminationService examinationService;
    @Autowired
    UserService userService;
    @Autowired
    ExamItemPoolService examItemPoolService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList(@RequestParam(value = "searchName", required = false) String searchName,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("laboratory/jsp/res/examination/list");
        PageInfo<CurriculumExamination> pageInfo = examinationService.selectListPage(searchName, page);
		Subject currentUser = SecurityUtils.getSubject();
		List<String> adminroles = new ArrayList<String>();
		adminroles.add("administrators");
		adminroles.add("lab_admin");
		if (!(currentUser.hasRole("administrators")||currentUser.hasRole("lab_admin"))){
			if (pageInfo.getData().size()>0){
				int curId = userService.getCurrentUserId();
				List<CurriculumExamination> trimdates = pageInfo.getData();
				List<CurriculumExamination>  realdatas = new ArrayList<>();
				for(CurriculumExamination ce:trimdates){
					if(ce.getTeacherId().equals(curId+"")){
						realdatas.add(ce);
					}
				}
				pageInfo.setData(realdatas);
			}
		}

        mav.addObject("pageInfo", pageInfo);

        return mav;

    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        CurriculumExamination examination = examinationService.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/examination/update");
        mav.addObject("examination", examination);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(CurriculumExamination curriculumExamination, HttpServletRequest request) {
        String filePath = "/WEB-INF/upload/examination/";
        String uploadPath = request.getSession().getServletContext().getRealPath(filePath);
        String fullFilePath = uploadPath + "\\" + curriculumExamination.getDocumentName();
        curriculumExamination.setDocumentPath(fullFilePath);

        examinationService.insertOrUpdate(curriculumExamination);
        return "redirect:/laboratory/jsp/res/examination/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        examinationService.delete(items);
        return "redirect:/laboratory/jsp/res/examination/list";
    }

    @RequestMapping(value = "/toAddSubject", method = RequestMethod.GET)
    public ModelAndView toAddSubject(@RequestParam("name") String name) {
        List<ExamItemPool> subjects = examItemPoolService.selectAllExamItemPools();
        ModelAndView mav = new ModelAndView("/laboratory/jsp/res/examination/addsubject");
        mav.addObject("subjects", subjects);
        mav.addObject("name", name);

        return mav;
    }

    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public  @ResponseBody Result addSubject(String name, String structIds, HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        Result result = null;
        if(StringUtils.isNullOrEmpty(structIds))
            return result;

        request.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        try {
            String[] subjectIdArr = structIds.split(",");
            List<Integer> subjectIdList = new ArrayList<>();
            for(String idStr:subjectIdArr){
                subjectIdList.add(Integer.valueOf(idStr));
            }

            String strName = new String(name.getBytes("ISO-8859-1"),"UTF-8");
            String filePath = "/WEB-INF/upload/examination/";
            String uploadPath = request.getSession().getServletContext().getRealPath(filePath);
            String fileName = "实验-" + strName + "-试题.doc";
            String fullFilePath = uploadPath + "\\" + fileName;
            examItemPoolService.generateDocument(fullFilePath, subjectIdList);

            result = new Result(true, fileName);
        }
        catch (Exception e){
            result = new Result(false,"实验试题生成失败!");
        }
        return result;

    }

    @RequestMapping(value="/deleteFile",method=RequestMethod.GET)
    public String deleteFile(@RequestParam("id") Integer id) throws Exception{
        CurriculumExamination examination = examinationService.selectByPrimaryKey(id);
        String path = examination.getDocumentPath();

        File file = new File(path);
        if (!file.exists()) {
            return "redirect:/laboratory/jsp/res/examination/toUpdate?id=" + id;
        }
        file.delete();

        examination.setDocumentPath("");
        examination.setDocumentName("");
        examinationService.update(examination);

        return "redirect:/laboratory/jsp/res/examination/toUpdate?id=" + id;
    }

    @RequestMapping(value="/downloadFile",method=RequestMethod.GET)
    public void downloadFile(@RequestParam("id") Integer id, HttpServletResponse response) throws Exception{
        CurriculumExamination examination = examinationService.selectByPrimaryKey(id);
        String path = examination.getDocumentPath();
        String fileName = examination.getDocumentName();

        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setContentType("multipart/form-data");
        String strName = new String(fileName.getBytes("UTF-8"), "ISO_8859_1");
        String header = "attachment;fileName=" + strName;
        response.setHeader("Content-Disposition", header);

        File file=new File(path);
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
