<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script type="text/javascript">
        function downloadFile(resourceId) {
            window.location.href = "downloadFile?id=" + resourceId;
        }
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
<table width="98%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
            src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
    <td valign="top" background="../../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">考核管理 > 任务管理</div>
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

                    <span style="white-space:nowrap">
                        任务名<input type="text" name="taskName"
                                  id="taskName" value=""
                                  style="width:100px;"/>
                    </span>
                    <span style="white-space:nowrap">
                        是否完成：
                        <select name="ifCompleted">
                            <option value="3">全部</option>
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </span>


        <span style="white-space:nowrap">&nbsp;&nbsp;
            <a href="javascript:void(0)" onclick="toFind('listForm');" class="txt_bt">
                <img src="../../../../images/zoom.png" width="15" height="15" border="0"/> 查询
            </a>
        </span>


<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="30">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="24" bgcolor="#353c44">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td>
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="6%" height="19" valign="bottom">
                                                <div align="center"><img src="../../../../images/tb.gif" width="14"
                                                                         height="14"/></div>
                                            </td>
                                            <td width="94%" valign="bottom"><span class="STYLE1"
                                                                                  style="white-space:nowrap">任务信息</span>
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
            <div id="divwidth"  style="overflow:auto;overflow-y:hidden;overflow-x: auto;">
                <table id="treeTable" class="table" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                    <tr>
                        <td width="40" height="20" bgcolor="d3eaef">
                        </td>

                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">任务名称</span></div>
                        </td>

                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">完成期限</span></div>
                        </td>
                        <td width="60" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">完成度</span></div>
                        </td>
                        <td width="60" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">完成情况</span></div>
                        </td>
                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">完成时间</span></div>
                        </td>
                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">评分</span></div>
                        </td>
                        <td width="120" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">更新进度</span></div>
                        </td>
                    </tr>
                    <% int temp=1; %>
                    <c:forEach items="${pageInfo.data}" var="item">
                        <tr bgcolor="#ffffff" align="center" class="STYLE19">
                            <td height="20">
                                <%=temp++%>
                            </td>

                            <td height="20">${item.task.taskname}</td>
                            <td><fmt:formatDate value="${item.task.limitdate}"></fmt:formatDate></td>
                            <td>${item.task.completely}%</td>
                            <td>${item.task.completion}</td>
                            <td><fmt:formatDate value="${item.task.finishdate}"/></td>
                            <td height="20">
                                <c:choose>
                                    <c:when test="${item.task.ifscored==true}">
                                        ${item.task.overallscore}
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${item.task.ifcompleted==true}">
                                                尚未评分
                                            </c:when>
                                            <c:otherwise>
                                                尚未完成
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><a href="/laboratory/jsp/task/task/mytask?taskId=${item.task.id}">
                                <img src="../../../../images/edit_min.gif" width="10"
                                     height="10" border="0"/>
                            </a></td>
                        </tr>
                    </c:forEach>

                    <tr height="16px"></tr>
                </table>

            </div>
        </td>
    </tr>
    <%@ include file="../../common/pagetable.jsp" %>
</table>
</td>
</tr>
</table>
</td>
<td background="../../../../images/mail_rightbg.gif">&nbsp;</td>
</tr>
    <tr>
        <td valign="bottom" background="../../../../images/mail_leftbg.gif">
            <img src="../../../../images/buttom_left2.gif"width="17" height="17"/>
        </td>
        <td valign="bottom" background="../../../../images/buttom_bgs.gif">
            <img src="../../../../images/buttom_bgs.gif" width="100%" height="17"/>
        </td>
        <td valign="bottom" background="../../../../images/mail_rightbg.gif">
            <img src="../../../../images/buttom_right2.gif"width="16" height="17"/>
        </td>
    </tr>
</table>
</form>
</body>
</html>
