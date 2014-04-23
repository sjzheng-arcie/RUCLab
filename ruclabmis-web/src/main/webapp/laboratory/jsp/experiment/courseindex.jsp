<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>
    <script>
        function load_init(){
            location.href = "/experiment/virtual/listbycource?page=1&curriculumId=" + ${curriculumId};
        }
    </script>
    <title>消息通知</title>

</head>
<body style="background-color: #EEF2FB" onload="load_init()">
<form name="mainForm" method="get">
    <table border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td class="op_nor" onclick="javascript:location.href='/experiment/virtual/listbycource?page=1&curriculumId='+${curriculumId}">虚拟班级管理</td>
            <td class="op_nor" onclick="javascript:location.href='/laboratory/jsp/experiment/experiment/listbycourse?page=1&view=experiment&curriculumId='+${curriculumId}">实验信息管理</td>
            <td class="op_act" onclick="javascript:location.href='/laboratory/jsp/experiment/experiment/listbycourse?page=1&view=report&curriculumId='+${curriculumId}">实验报告管理</td>
            <td class="op_nor" onclick="javascript:location.href='/laboratory/jsp/experiment/experiment/listbycourse?page=1&view=achievement&curriculumId='+${curriculumId}">学期成绩评定</td>
        </tr>
    </table>
</form>
</body>

</html>
