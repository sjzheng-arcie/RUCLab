<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script type="text/javascript">

        function score(vcid){
            window.location.href = "/experiment/virtual/classStudentScore?vcId="+vcid+"&page=1&view=achievement";
        }
        function queryscore(cid,stuId){
            window.location.href = "/experiment/virtual/scoreStudent?vcId="+cid+"&stuId="+stuId;
        }
        function editorClass(vcid,curricumname,instructName) {
            window.location.href = "myexperimentlist?cid="+vcid+"&cName="+curricumname+"+&page=1";
        }
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">
<table border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td class="op_nor" onclick="javascript:location.href='/experiment/virtual/listbycource?page=1&curriculumId='+${curriculumId}">虚拟班级管理</td>
        <td class="op_nor" onclick="javascript:location.href='/laboratory/jsp/experiment/experiment/listbycourse?page=1&view=experiment&curriculumId='+${curriculumId}">实验信息管理</td>
        <td class="op_nor" onclick="javascript:location.href='/laboratory/jsp/experiment/experiment/listbycourse?page=1&view=report&curriculumId='+${curriculumId}">实验报告管理</td>
        <td class="op_act" onclick="javascript:location.href='/laboratory/jsp/experiment/experiment/listbycourse?page=1&view=achievement&curriculumId='+${curriculumId}">学期成绩评定</td>
    </tr>
</table>
<form name="listForm" method="post">
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
            <td valign="top" background="../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">实验成绩管理> 成绩评定</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/nav-right-bg.gif" width="16" height="29"/></td>
        </tr>

        <tr>
            <td valign="middle" background="../../../../images/mail_leftbg.gif">&nbsp;</td>
            <td valign="top" bgcolor="#F7F8F9">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
                    <tr>
                        <td valign="top" class="STYLE10">


                            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td height="30">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td height="24" bgcolor="#353c44">
                                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                        <tr>
                                                            <td>
                                                                <table width="100%" border="0" cellspacing="0"
                                                                       cellpadding="0">
                                                                    <tr>
                                                                        <td width="6%" height="19" valign="bottom">
                                                                            <div align="center"><img
                                                                                    src="../../../../images/tb.gif"
                                                                                    width="14" height="14"/></div>
                                                                        </td>
                                                                        <td width="94%" valign="bottom"><span
                                                                                class="STYLE1"
                                                                                style="white-space:nowrap">课程列表</span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td>
                                                                <div align="right">

                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="divwidth" style="overflow:auto;overflow-y:hidden;">
                                            <table width="100%" class="table" id="table1" border="0" cellpadding="0"
                                                   cellspacing="1" bgcolor="#a8c7ce">
                                                <tr>
                                                    <td width="150" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">班级名称</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">课程名称</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">学年</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">任课老师</span></div>
                                                    </td>
                                                    <shiro:hasRole name="student">
                                                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                            <div align="center"><span class="STYLE10">查看实验</span></div>
                                                        </td>
                                                    </shiro:hasRole>


                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">成绩</span></div>
                                                    </td>


                                                </tr>
                                                <c:forEach items="${pageInfo.data}" var="item">
                                                    <tr bgcolor="#ffffff" align="center" class="STYLE19">

                                                        <td>${item.className}</td>
                                                        <td>${item.curriculumName}</td>
                                                        <td>${item.classYear}</td>
                                                        <td>${item.teacherName}</td>

                                                        <shiro:hasRole name="student">
                                                        <td>
                                                            <input type="button" onClick="editorClass('${item.curriculumId}','${item.curriculumName}');"
                                                                   class="button"
                                                                   value="查看所属实验"/>
                                                        </td>
                                                        </shiro:hasRole>


                                                            <td>
                                                                <shiro:hasRole name="teacher">
                                                                <input type="button" onClick="score(${item.id});"
                                                                       class="button" value="评定成绩"/>
                                                                </shiro:hasRole>
                                                                <shiro:hasRole name="student">
                                                                <input type="button" onClick="queryscore('${item.id}','${userId}');"
                                                                       class="button" value="查询成绩"/>
                                                                </shiro:hasRole>
                                                            </td>




                                                    </tr>
                                                </c:forEach>
                                                <tr height="16px"></tr>
                                            </table>
                                        </div>
                                    </td>
                                </tr>
                                <%@include file="../../common/pagetable.jsp" %>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td background="../../../../images/mail_rightbg.gif">&nbsp;</td>
        </tr>
        <tr>
            <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/buttom_left2.gif"
                    width="17" height="17"/></td>
            <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img
                    src="../../../../images/buttom_bgs.gif"
                    width="100%" height="17"/></td>
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>