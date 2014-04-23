<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>

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
                        员工编号<input type="text" name="searchSN"
                                 id="searchSN" value=""
                                 style="width:100px;"/>
                    </span>
                    <span style="white-space:nowrap">
                        用户名<input type="text" name="searchName"
                                  id="searchName" value=""
                                  style="width:100px;"/>
                    </span>
                    <span style="white-space:nowrap">
                        专业<select name="searchMajor" id="searchMajor">
                        <option value="">所有</option>
                        <c:forEach items="${majors}" var="item">
                            <option value="${item.id}"
                                    <c:if test="${item.id == param.searchMajor}"> selected</c:if>>${item.name}
                            </option>
                        </c:forEach>
                    </select>

                    </span>
                    <span style="white-space:nowrap">
                        部门 <select name="searchOrg" id="searchOrg">
                        <option value="-1">所有</option>
                        <c:forEach items="${organizations}" var="item">
                            <option value="${item.id}"
                                    <c:if test="${item.id == param.searchOrg}"> selected</c:if>>${item.name}
                            </option>
                        </c:forEach>
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
                                                                                  style="white-space:nowrap">教职工信息</span>
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
            <div id="divwidth"  style="overflow:auto;overflow-y:hidden;">
                <table id="treeTable" class="TABLE" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                    <tr>
                        <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">序号</span></div>
                        </td>
                        <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">教职工编号</span></div>
                        </td>
                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">姓名</span></div>
                        </td>
                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">专业</span></div>
                        </td>
                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">职位</span></div>
                        </td>
                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">职称</span></div>
                        </td>
                        <td width="50" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">查看任务</span></div>
                        </td>
                    </tr>
                    <% int temp=1; %>
                    <c:forEach items="${pageInfo.data}" var="item">
                        <tr bgcolor="#ffffff" align="center" class="STYLE19">
                            <td height="20">
                                <%=temp++%>
                            </td>
                            <td height="20">${item.sn}</td>
                            <td height="20">${item.name}</td>
                            <td>${item.major.name}</td>
                            <td>${item.positionName}</td>
                            <td>${item.titleName}</td>
                            <td><a href="/laboratory/jsp/task/task/oneslist?teacherId=${item.id}" class="button"> 查看任务</a></td>

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
