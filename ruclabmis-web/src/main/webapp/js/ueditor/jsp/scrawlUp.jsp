<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="utf-8" %>
<%@ page import="ueditor.Uploader" %>

<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    String param = request.getParameter("action");
    Uploader up = new Uploader(request);
    String documentPath = "upload";
    up.setSavePath(documentPath);
    String[] fileType = {".gif", ".png", ".jpg", ".jpeg", ".bmp"};
    up.setAllowFiles(fileType);
    up.setMaxSize(10000); //单位KB

    if (param != null && param.equals("tmpImg")) {
        up.upload();
        out.print("<script>parent.ue_callback('" + up.getUrl() + "','" + up.getState() + "')</script>");
    } else {
        up.uploadBase64("content");
        response.getWriter().print("{'url':'" + up.getUrl() + "',state:'" + up.getState() + "'}");
    }

%>
