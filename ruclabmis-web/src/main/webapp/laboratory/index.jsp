<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>人大信息学院实验室管理平台</title>
    <style>
        body {
            background: #eef2fb;
        }
    </style>
    <meta http-equiv=Content-Type content=text/html;charset=UTF-8>
</head>
<frameset rows="103,*" frameborder="NO" border="0" framespacing="0" name="mainFrame">
    <frame src="top" noresize="noresize" frameborder="NO" name="topFrame" scrolling="no" marginwidth="0"
           marginheight="0" target="main"/>
    <frameset cols="202,*" rows="2000,*" id="frame">
        <frame src="left" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0"
               scrolling="no" target="main"/>
        <shiro:hasRole name="teacher">
            <frame src="teacher_welcome" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"
                   target="_self"/>
        </shiro:hasRole>
        <shiro:hasRole name="student">
            <frame src="student_welcome" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"
                   target="_self"/>
        </shiro:hasRole>
        <shiro:hasRole name="administrators">
            <frame src="welcome" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"
                   target="_self"/>
        </shiro:hasRole>
        <shiro:hasRole name="leader">
            <frame src="welcome" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"
                   target="_self"/>
        </shiro:hasRole>
    </frameset>
</frameset>
<script type="text/javascript">

</script>
</html>
