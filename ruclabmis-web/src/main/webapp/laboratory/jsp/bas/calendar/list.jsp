<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        var baseHref = '/laboratory/jsp/bas/calendar/list';
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
                        <div class="titlebt">基础信息管理 > 校历信息设置</div>
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
                                <td height="40">
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
                                                                    <td width="94%" valign="bottom"><span class="STYLE1"
                                                                                                          style="white-space:nowrap">校历信息管理</span>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                        <td>
                                                            <div align="right">
                                                                <span class="STYLE1" style="white-space:nowrap">
                                                                    <a href="/laboratory/jsp/bas/calendar/toAdd" class="txt_bt" ><img src="../../../../images/add_min.gif" width="10" height="10" border="0"/>
                                                                        <span class="STYLE1">新增</span></a>&nbsp;
                                                                     <a href="javascript:;" onclick="toDelete('listForm', 'idcheckbox');" class="txt_bt"><img src="../../../../images/del_min.gif" width="10"
                                                                                                           height="10"
                                                                                                           border="0"/> <span class="STYLE1">删除</span></a>&nbsp;&nbsp;
     <%--                                                               <a href="javascript:;" onclick="toHouseDy();"><img src="../../../../images/del_min.gif" width="10"
                                                                                                            height="10"
                                                                                                            border="0"/> <span class="STYLE1">导入</span></a>&nbsp;&nbsp;
                                                                    <a href="javascript:;" onclick="toHouseLay();"><img src="../../../../images/del_min.gif" width="10"
                                                                                                             height="10" border="0"/> <span class="STYLE1">导出</span></a>&nbsp;&nbsp;
                                           <a href="javascript:;" onclick="toRoom();"><img src="../../../../images/del_min.gif" width="10" height="10"
                                                                 border="0"/> <span class="STYLE1">打印</span></a>&nbsp;&nbsp;--%>
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
                                                <td width="40" height="20" bgcolor="d3eaef" class="STYLE10">
                                                    <div align="center">
                                                        <input type="checkbox" name="checkbox" id="checkbox"
                                                               onclick="checkAll(this);"/>
                                                    </div>
                                                </td>
                                                <td width="100" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">学期名称</span></div>
                                                </td>
                                                <td width="60" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">开始周</span></div>
                                                </td>
                                                <td width="60" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">结束周</span></div>
                                                </td>

                                                <td width="100" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">学期首日</span></div>
                                                </td>
                                                <td width="100" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">学年</span></div>
                                                </td>


                                            </tr>

                                            <c:forEach items="${pageInfo.data}" var="item">
                                                <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                    <td height="20"><input name="idcheckbox" type="checkbox"
                                                                           value="${item.id}"
                                                                           onclick="checkOne('listForm', 'idcheckbox')"/>
                                                    </td>
                                                    <td> <a href="toUpdate?id=${item.id}">${item.name}</a></td>
                                                    <td>${item.startweek}</td>
                                                    <td>${item.endweek}</td>
                                                    <td><fmt:formatDate value="${item.begindate}"
                                                                        pattern="yyyy-MM-dd"/></td>
                                                    <td>${item.year}</td>

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
        <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img src="../../../../images/buttom_bgs.gif"
                                                                                width="100%" height="17"/></td>
        <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
    </tr>
</table>
</form>
</body>
</html>
