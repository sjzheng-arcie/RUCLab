package edu.ruc.labmgr.web.controller;


import edu.ruc.labmgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/fileUploadControllerReturnPath")
public class FileUploadControllerReturnPath {
    @Autowired
    UserService userService;

    @RequestMapping(value="/fileUpload")
    public void fileUpload( @RequestParam MultipartFile file,
                      HttpServletRequest request,HttpServletResponse response) throws IOException {
        Result result = null;

        String path = "/WEB-INF/upload/" + userService.getCurrentUser().getSn();
        String realPath = request.getSession().getServletContext().getRealPath(path);
        String fullFilePath = realPath+"\\"+file.getOriginalFilename();

        File newFile = new File(fullFilePath);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }

        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
            result = new Result(false, "文件上传失败!");

        }
		result = new Result(true,file.getOriginalFilename());
		response.setContentType("text/html");
		String json = "{success:true,message:'"+file.getOriginalFilename()+"'}";
		response.getOutputStream().write(json.getBytes());
		response.getOutputStream().flush();
    }
}