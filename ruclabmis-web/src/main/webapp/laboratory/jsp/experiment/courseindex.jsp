<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<head>
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <script type="text/javascript">
        function onLoad(){
             location.href = "myexperimentlist?cid="+${curriculumId}+"&page=1";
        }
    </script>
    <title>消息通知</title>

</head>
<body style="background-color: #EEF2FB" onload="onLoad()">
<form name="mainForm" method="get">
    <table border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td class="op_nor" onclick="javascript:location.href='myexperimentlist?cid='+${curriculumId}+'&page=1'">实验信息</td>
            <td class="op_nor" onclick="javascript:location.href='/laboratory/jsp/res/instruction/courselist?searchCurriculum='+${curriculumId}">实验指导书</td>
            <td class="op_nor" onclick="javascript:location.href='myexperimentlist?cid='+${curriculumId}+'&page=1&view=report&curriculumClassId='+${curriculumId}">实验报告</td>
            <td class="op_act" onclick="javascript:location.href='/experiment/virtual/classStudentScore?vcId='+${curriculumId}+'&page=1&view=achievement'">学期成绩评定</td>
        </tr>
    </table>
</form>
</body>

</html>
