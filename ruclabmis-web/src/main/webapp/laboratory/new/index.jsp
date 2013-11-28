<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>实验室教学管理系统</title>
    <style>
        body {
            background: #eef2fb;
        }
    </style>
    <meta http-equiv=Content-Type content=text/html;charset=UTF-8>
</head>
<frameset rows="103,*" frameborder="NO" border="0" framespacing="0">
    <frame src="admin_top" noresize="noresize" frameborder="NO" name="topFrame" scrolling="no" marginwidth="0"
           marginheight="0" target="main"/>
    <frameset cols="202,*" rows="2000,*" id="frame">
        <frame src="left" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0"
               scrolling="no" target="main"/>
        <frame src="right" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"
               target="_self"/>
    </frameset>
    <script type="text/javascript">

    </script>
</frameset>
</html>
