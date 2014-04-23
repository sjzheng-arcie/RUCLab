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
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
    function save(){
        if (!validator(document.listForm)) {
            return;
        }
        document.listForm.action="/laboratory/jsp/task/taskscore/rescore";
        document.listForm.submit();
    }
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="../../../../images/mail_leftbg.gif">
        <img src="../../../../images/left-top-right.gif" width="17" height="29"/>
    </td>
    <td valign="top" background="../../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
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
                        <tr bgcolor="#E3E9EE">
                            <td bgcolor="#E3E9EE">
                                <table cellpadding="10" cellspacing="1"
                                       style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                       border="0px" bgcolor="#000000">
                                    <input type="hidden" name="taskId" value="${taskInfo.id}"/>
                                    <tr height="" bgcolor="#ffffff">
                                        <td nowrap align="right">任务名称:</td>
                                        <td nowrap>
                                            ${taskInfo.taskname}
                                        </td>
                                        <td nowrap align="right">任务发起人:</td>
                                        <td nowrap>
                                            ${taskInfo.manager.name}
                                        </td>
                                    </tr>
                                    <tr bgcolor="#ffffff">
                                        <td nowrap align="right">截止时间:</td>
                                        <td nowrap>
                                            <fmt:formatDate value="${taskInfo.limitdate}"/>
                                        </td>
                                        <td nowrap align="right">完成时间时间:</td>
                                        <td nowrap>
                                            <fmt:formatDate value="${taskInfo.finishdate}"/>
                                        </td>
                                    </tr>
                                    <tr bgcolor="#ffffff">
                                        <td nowrap align="right">任务执行人:</td>
                                        <td nowrap colspan="3">
                                            <c:forEach items="${taskChargerList}" var="item">
                                                ${item.charger.name}、
                                            </c:forEach>
                                        </td>
                                        <%--<td nowrap align="right">完成时间时间:</td>--%>
                                        <%--<td nowrap>--%>
                                        <%--<fmt:formatDate value="${taskInfo.finishdate}"/>--%>
                                        <%--</td>--%>
                                    </tr>
                                    <c:if test="${taskInfo.ifscored==true}">
                                        <tr bgcolor="#ffffff">
                                            <td nowrap align="right">整体评分:</td>
                                            <td nowrap colspan="3">

                                                    ${taskInfo.overallscore}

                                            </td>
                                                <%--<td nowrap align="right">完成时间时间:</td>--%>
                                                <%--<td nowrap>--%>
                                                <%--<fmt:formatDate value="${taskInfo.finishdate}"/>--%>
                                                <%--</td>--%>
                                        </tr>
                                    </c:if>
                                    <tr bgcolor="#ffffff">
                                        <td nowrap align="right">完成度:</td>
                                        <td nowrap colspan="3">
                                            ${taskInfo.completely}%
                                        </td>
                                    </tr>
                                    <tr bgcolor="#ffffff">
                                        <td nowrap align="right">任务内容:</td>
                                        <td colspan="3">
                                            ${taskInfo.content}
                                        </td>
                                    </tr>
                                    <tr bgcolor="#ffffff">
                                        <td nowrap align="right">备注:</td>
                                        <td colspan="3">
                                            ${taskInfo.completion}
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
                                                    <td width="94%" valign="bottom"><span class="STYLE1">评分</span>
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
                                <table border="0" cellpadding="2" cellspacing="1"
                                       style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                       bgcolor="#E3E9EE">
                                    <input type="hidden" name="taskScoreId" value="${taskScoreInfo.id}"/>
                                    <tr>
                                        <td nowrap align="right">完成度评分:</td>
                                        <td nowrap>
                                            <input name="completelyScore" id="completelyScore" onblur="" class="text"
                                                   valid="isNum"
                                                   errmsg="完成度评分必须是正整数！"
                                                   style="width:154px" maxlength="20" value="${taskScoreInfo.completelyscore}" />
                                            <span style="color:red;">*</span>&nbsp;&nbsp;

                                        </td>
                                        <td nowrap align="right">即时度评分:</td>
                                        <td nowrap>
                                            <input name="timelyScore" id="timelyScore" onblur="" class="text"
                                                   valid="isNum"
                                                   errmsg="即时度评分必须是正整数！"
                                                   style="width:154px" maxlength="20" value="${taskScoreInfo.timelyscore}" />
                                            <span style="color:red;">*</span>&nbsp;&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td nowrap align="right">完成质量评分:</td>
                                        <td nowrap>
                                            <input name="qualityScore" id="qualityScore" onblur="" class="text"
                                                   valid="isNum"
                                                   errmsg="质量评分必须是正整数！"
                                                   style="width:154px" maxlength="20" value="${taskScoreInfo.qualityscore}" />
                                            <span style="color:red;">*</span>&nbsp;&nbsp;


                                        </td>
                                        <td nowrap align="right">花费资源评分:</td>
                                        <td nowrap>
                                            <input name="spentScore" id="spentScore" onblur="" class="text"
                                                   valid="isNum"
                                                   errmsg="花费资源评分必须是正整数！"
                                                   style="width:154px" maxlength="20" value="${taskScoreInfo.spentscore}" />
                                            <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_us_sname"></span>
                                        </td>

                                    </tr>
                                    <tr>

                                        <td nowrap align="right">任务整体评分:</td>
                                        <td nowrap>
                                            <input name="totalScore" id="totalScore" onblur="" class="text" valid="isNum"
                                                   errmsg="整体评分必须是正整数！"
                                                   style="width:154px" maxlength="20" value="${taskScoreInfo.overallscore}" />
                                            <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_total_score"></span>
                                        </td>
                                        <td nowrap align="right">评分人姓名:</td>
                                        <td nowrap>
                                            <input type="hidden" name ="markerId" id="makerId" value="${userInfo.id}">
                                            <input name="markerName" id="markerName" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   value="${userInfo.name}" readonly disabled="no"/>
                                            <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_manager_sname"></span>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td align="center">
                                <c:if test="${taskInfo.ifscored!=true}">
                                <input type="button" name="Submit" value="保存" class="button" onclick="save();"/>
                                </c:if>
                                <input type="button" name="return" value="返回" class="button"
                                       onclick="window.history.go(-1);"/>
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
</form>
</body>
</html>
