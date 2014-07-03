<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <title></title>
    <script>
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
                            <div class="titlebt">预约申请管理</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/nav-right-bg.gif" width="16" height="29"/></td>
        </tr>

        <tr>
            <td valign="middle" background="../../../../images/mail_leftbg.gif"></td>
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
                                                                                style="white-space:nowrap">申请信息列表</span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td>
                                                                <div align="right">
	            	            	<span class="STYLE1" style="white-space:nowrap">
                                        <c:if test="${formType!='history'}">
                                            <shiro:hasAnyRoles name="administrators,lab_admin">
                                                <a href="javascript:void(0);" class="txt_bt"
                                                   onclick="toApprove('listForm', 'idcheckbox');return false;">
                                                    <img src="../../../../images/add_min.gif" width="10" height="10"
                                                         border="0"/>
                                                    <span class="STYLE1">批准申请</span></a>
                                                <a href="javascript:void(0);" class="txt_bt"
                                                   onclick="toReject('listForm', 'idcheckbox');return false;">
                                                    <img src="../../../../images/edit_min.gif" width="10" height="10"
                                                         border="0"/>
                                                    <span class="STYLE1">驳回申请</span></a>
                                            </shiro:hasAnyRoles>

                                            <shiro:hasAnyRoles name="administrators,teacher,equipment_admin,student">
                                                <a href="javascript:void(0);" class="txt_bt"
                                                   onclick="toDelete('listForm', 'idcheckbox');return false;">
                                                    <img src="../../../../images/del_min.gif" width="10" height="10"
                                                         border="0"/>
                                                    <span class="STYLE1">删除申请</span></a>
                                            </shiro:hasAnyRoles>
                                        </c:if>
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
                                        <div id="divwidth" style="overflow:auto;overflow-y:hidden;">
                                            <table width="100%" class="table" id="table1" border="0" cellpadding="0"
                                                   cellspacing="1" bgcolor="#a8c7ce">
                                                <tr>
                                                    <c:if test="${formType!='history'}">
                                                        <td width="40" height="20" bgcolor="d3eaef" class="STYLE10">
                                                            <div align="center">
                                                                <input type="checkbox" name="checkbox" id="checkbox"
                                                                       onclick="checkAll(this,'listForm', 'idcheckbox');"/>
                                                            </div>
                                                        </td>
                                                    </c:if>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">申请编号</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">申请房间</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">申请人</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">联系电话</span></div>
                                                    </td>
                                                    <td width="40" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">状态</span></div>
                                                    </td>
                                                    <td width="160" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">申请时间</span></div>
                                                    </td>
                                                    <td width="60" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">周次</span></div>
                                                    </td>
                                                    <td width="60" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">星期</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">申请类型</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">申请描述</span></div>
                                                    </td>
                                                    <c:if test="${formType=='history'}">
                                                        <td width="100" bgcolor="d3eaef">
                                                            <div align="center"><span class="STYLE10">处理人</span></div>
                                                        </td>
                                                    </c:if>
                                                </tr>
                                                <c:forEach items="${pageInfo.data}" var="item">
                                                    <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                        <c:if test="${formType!='history'}">
                                                            <td height="20"><input name="idcheckbox" type="checkbox"
                                                                                   value="${item.id}"
                                                                                   onclick="checkOne('listForm', 'idcheckbox')"/>
                                                            </td>
                                                        </c:if>
                                                        <td><a href="toMultiUpdate?id=${item.id}">${item.id}</a></td>
                                                        <td>${item.room.name}</td>
                                                        <td>${item.user.name}</td>
                                                        <td>${item.phoneNum}</td>
                                                        <td>${item.stateClassif.value}</td>
                                                        <td><fmt:formatDate value="${item.meetSTime}" pattern=" HH:mm"/>
                                                         - <fmt:formatDate value="${item.meetETime}" pattern=" HH:mm"/></td>
                                                        <td>${item.beginWeek}-${item.endWeek}</td>
                                                        <td>
                                                            <c:if test="${item.weekDay==1}">一</c:if>
                                                            <c:if test="${item.weekDay==2}">二</c:if>
                                                            <c:if test="${item.weekDay==3}">三</c:if>
                                                            <c:if test="${item.weekDay==4}">四</c:if>
                                                            <c:if test="${item.weekDay==5}">五</c:if>
                                                            <c:if test="${item.weekDay==6}">六</c:if>
                                                            <c:if test="${item.weekDay==7}">天</c:if></td>
                                                        <td>${item.type}</td>
                                                        <td>${item.description}</td>
                                                        <c:if test="${formType=='history'}">
                                                            <td>${item.approval.name}</td>
                                                        </c:if>
                                                    </tr>
                                                </c:forEach>
                                                <tr height="16px"></tr>
                                            </table>
                                        </div>
                                    </td>
                                </tr>

                                <%@ include file="../../../../include/pagetable.jsp" %>

                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td background="../../../../images/mail_rightbg.gif"></td>
        </tr>
        <tr>
            <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/buttom_left2.gif"
                    width="17" height="17"/></td>
            <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img src="../../../../images/buttom_bgs.gif"
                                                                                    width="100%" height="17"/></td>
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>
