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
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        function save(){
            document.listForm.action="/laboratory/jsp/task/task/save?taskId=${taskInfo.id}";
            document.listForm.submit();
        }
        function back(){
            document.location.href="/laboratory/jsp/task/task/tasklist?taskId=${taskInfo.id}";
        }
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
<table width="98%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="../../../../images/mail_leftbg.gif">
        <img src="../../../../images/left-top-right.gif" width="17" height="29"/>
    </td>
    <td valign="top" background="../../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg">
            <tr>
                <td height="31">
                    <div class="titlebt">考核管理 > 任务评分</div>
                </td>
            </tr>
        </table>
    </td>
    <td width="16" valign="top" background="../../../../images/mail_rightbg.gif">
        <img src="../../../../images/nav-right-bg.gif" width="16" height="29"/>
    </td>
</tr>
<tr>
    <td valign="middle" background="../../../../images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
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
                                                        <div align="center"><img src="../../../../images/tb.gif"
                                                                                 width="14" height="14"/></div>
                                                    </td>
                                                    <td width="94%" valign="bottom"><span class="STYLE1">任务信息</span>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <div align="right"><span class="STYLE1">&nbsp;</span><span
                                                    class="STYLE1"> &nbsp;</span></div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr valign="top">
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                        <tr bgcolor="#FFFFFF">
                            <td bgcolor="#FFFFFF">
                                <table cellpadding="10" cellspacing="1"
                                       style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                       border="0px" bgcolor="#000000">
                                    <input type="hidden" name="taskId" value="${taskInfo.id}"/>
                                    <tr height="" bgcolor="#ffffff">
                                        <td nowrap align="right">任务名称:</td>
                                        <td nowrap>
                                            <input disabled="no" value="${taskInfo.taskname}"/>
                                        </td>
                                        <td nowrap align="right">负责人:</td>
                                        <td nowrap>
                                            <input disabled="no" value="${taskInfo.manager.name}"/>
                                        </td>
                                    </tr>
                                    <tr bgcolor="#ffffff">
                                        <td nowrap align="right">截止时间:</td>
                                        <td nowrap>
                                            <input disabled="no" value="<fmt:formatDate value="${taskInfo.limitdate}"/>"/>
                                        </td>
                                        <td nowrap align="right">完成时间时间:</td>
                                        <td nowrap>
                                            <input disabled="no" value="<fmt:formatDate value="${taskInfo.finishdate}"/>"/>
                                        </td>
                                    </tr>
                                    <tr bgcolor="#ffffff">
                                        <td nowrap align="right">完成度:</td>
                                        <td nowrap colspan="3">
                                            <input disabled="no" value="${taskInfo.completely}%"/>
                                        </td>
                                    </tr>
                                    <tr bgcolor="#ffffff">
                                        <td nowrap align="right">任务内容:</td>
                                        <td colspan="3">
                                            <textarea disabled="no" style="width:70%;height: 100px">${taskInfo.content}</textarea>
                                        </td>
                                    </tr>
                                    <tr bgcolor="#ffffff">
                                        <td nowrap align="right">完成情况:</td>
                                        <td colspan="3">
                                            <textarea disabled="no" style="width:70%;height: 100px"> ${taskInfo.completion}</textarea>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>

                </td>
            </tr>
        </table>
    </td>
    <td background="../../../../images/mail_rightbg.gif">&nbsp;</td>
</tr>
<tr>
    <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img src="../../../../images/buttom_left2.gif"
                                                                             width="17" height="17"/></td>
    <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img src="../../../../images/buttom_bgs.gif"
                                                                            width="100%" height="17"></td>
    <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img src="../../../../images/buttom_right2.gif"
                                                                              width="16" height="17"/></td>
</tr>
</table>
<table width="98%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
                src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
        <td valign="top" background="../../../../images/content-bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                <tr>
                    <td height="31">
                        <div class="titlebt">考核管理 > 教师间任务评分情况</div>
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
                                                                    <td width="94%" valign="bottom">
                                                                        <span class="STYLE1" style="white-space:nowrap">
                                                                            组织结构
                                                                        </span>
                                                                    </td>
                                                                </tr>
                                                            </table>
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
                                        <table width="100%" border="0" cellpadding="0" cellspacing="1"
                                               bgcolor="#a8c7ce">
                                            <tr>
                                                <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">评分人</span></div>
                                                </td>
                                                <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">完成度</span></div>
                                                </td>
                                                <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">即时度</span></div>
                                                </td>
                                                <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">完成质量</span></div>
                                                </td>
                                                <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">花费资源</span></div>
                                                </td>
                                                <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">整体评分</span></div>
                                                </td>
                                            </tr>
                                            <c:forEach items="${pageInfo.data}" var="item">
                                                <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                    <td>${item.manager.name}</td>
                                                    <td>${item.completelyscore}</td>
                                                    <td>${item.timelyscore}</td>
                                                    <td>${item.qualityscore}</td>
                                                    <td>${item.spentscore}</td>
                                                    <td>${item.overallscore}</td>
                                                </tr>
                                            </c:forEach>
                                            <tr height="16px"></tr>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            <%@ include file="../../common/pagetable.jsp" %>

                        </table>
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td align="center">
                                    <input type="button" name="return" value="返回" class="button"
                                           onclick="back();"/>
                                </td>
                            </tr>
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
