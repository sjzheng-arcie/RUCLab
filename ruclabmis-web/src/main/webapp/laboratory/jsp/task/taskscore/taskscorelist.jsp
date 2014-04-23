<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <link href="${pageContext.request.contextPath}/js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/chosen/chosen.jquery.min.js"></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        $(document).ready(function () {
            $("#managerId").chosen({
                no_results_text: "没有找到"
            });
        });
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

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
                            <div class="titlebt">任务管理 > 任务评分</div>
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

                            <span style="white-space:nowrap">&nbsp;&nbsp;任务名称:<input type="text" name="taskName" id="taskName" value=""
                                                                                     style="width:100px;"/></span>

                            <%--<span style="white-space:nowrap">&nbsp;&nbsp;负责人:--%>
                            <%--<select id="managerId" name="managerId"--%>
                                    <%--style="width: 252px;height: 22px"--%>
                                    <%--data-placeholder="选择负责人...">--%>
                                <%--<option value=""></option>--%>
                                <%--<c:forEach items="${managerList}" var="manager">--%>
                                    <%--<option value="${manager.id}">${manager.name}(${manager.sn})</option>--%>
                                <%--</c:forEach>--%>
                            <%--</select>--%>
                            <%--</span>--%>
                            <span style="white-space:nowrap">
                        任务类型：
                        <select name="typeId" id="typeId">
                            <option ></option>
                            <c:forEach items="${taskTypeList}" var="taskType">
                                <option value="${taskType.id}"> ${taskType.typeName}</option>
                            </c:forEach>
                        </select>
                    </span>

                            <span style="white-space:nowrap">&nbsp;&nbsp; 是否已完成:
                            <select name="ifCompleted">
                                <option value="3"></option>
                                <option value="1">已完成</option>
                                <option value="0">未完成</option>
                            </select>
                            </span>
                            <span style="white-space:nowrap">&nbsp;&nbsp;  <a href="javascript:void(0)" onclick="toFind('listForm');" class="txt_bt">
                                <img src="../../../../images/zoom.png" width="15" height="15" border="0"/> 查询
                            </a></span>
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
                                                                                    width="14"
                                                                                    height="14"/></div>
                                                                        </td>
                                                                        <td width="94%" valign="bottom">
                                                                            <span class="STYLE1" style="white-space:nowrap">待评分任务列表</span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td>
                                                                <div align="right">
                                                                    <span class="STYLE1" style="white-space:nowrap">
                                                                    </span>
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
                                        <div id="divwidth" style="overflow:auto;overflow-y:hidden;overflow-x: auto;">
                                            <table id="table1" width="100%" class="table" border="0" cellpadding="0"
                                                   cellspacing="1" bgcolor="#a8c7ce">
                                                <tr>
                                                    <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">序号</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">任务名称</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">类型</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">任务发起人</span></div>
                                                    </td>
                                                    <td width="80" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">完成时间</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">任务内容</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">评分</span></div>
                                                    </td>
                                                </tr>
                                                <% int i = 1; %>
                                                <c:forEach items="${pageInfo.data}" var="item">
                                                    <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                        <td height="20">
                                                            <%=i++%>
                                                        </td>
                                                        <td>${item.taskname}</td>
                                                        <td>${item.taskType.typeName}</td>
                                                        <td>${item.manager.name}</td>
                                                        <td><fmt:formatDate value="${item.limitdate}"/></td>
                                                        <td>${item.content}</td>
                                                        <td>
                                                            <c:choose>
                                                                <c:when test="${item.ifscored==true}">
                                                                    <a class="button" href="/laboratory/jsp/task/taskscore/torescore?taskId=${item.id}">查看</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a class="button" href="/laboratory/jsp/task/taskscore/toscore?taskId=${item.id}">评分</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
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
