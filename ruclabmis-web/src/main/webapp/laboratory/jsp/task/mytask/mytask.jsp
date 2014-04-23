<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>
    <script type="text/javascript" src="../../../../js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="../../../../js/ajaxfileupload.js"></script>
    <script src="../../../../js/DatePicker/WdatePicker.js" type=text/javascript></script>

    <title></title>

    <script>
        function save(){
            if (!validator(document.mainForm)) {
                return;
            }
            document.mainForm.action="updatecompletely";
            document.mainForm.submit();
        }
        function finish(){
            if (!validator(document.mainForm)) {
                return;
            }
            document.mainForm.action="finishtask";
            document.mainForm.submit();
        }
        function downloadFile(resourceId) {
            window.location.href = "downloadFile?id=" + resourceId;
        }
    </script>
</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="mainForm" method="post">

    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif">
                <img src="../../../../images/left-top-right.gif" width="17" height="29"/>
            </td>
            <td valign="top" background="../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">考核管理 > 我的任务详细</div>
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
                                                            <td width="94%" valign="bottom"><span
                                                                    class="STYLE1">任务详情</span></td>
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
                                               style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;" bgcolor="#E3E9EE">

                                            <input type="hidden" name="teacherId"value="${teacherInfo.id}"/>
                                            <input type="hidden" name="taskId"value="${taskInfo.id}"/>
                                            <tr>
                                                <td nowrap align="right">任务名称:</td>
                                                <td nowrap>
                                                    <input name="taskName" id="taskName" onblur="" class="text"disabled="no"
                                                           style="width:154px" maxlength="20"  value="${taskInfo.taskname}"/>
                                                </td>
                                                <td nowrap align="right">任务发起人:</td>
                                                <td nowrap>
                                                    <input name="operator" id="operator" onblur="" class="text"
                                                           style="width:154px" maxlength="20" readonly disabled="no"
                                                           value="${teacherInfo.name}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">截止时间:</td>
                                                <td nowrap>
                                                    <input name="limitDate" value="<fmt:formatDate value="${taskInfo.limitdate}"/>" readonly disabled="no">
                                                </td>
                                                <td nowrap align="right">完成进度</td>
                                                <td nowrap>
                                                   <input class="text" style="text-align: right;" size="2" name="completely" id="completely"

                                                          <c:if test="${taskInfo.ifcompleted==true}">
                                                                readonly disabled="no"
                                                          </c:if>

                                                          value="${taskInfo.completely}"
                                                          valid="required" errmsg="请填写任务完成进度（0~100之间的整数）！"/>%
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_task_completely" ></span>
                                                </td>
                                            </tr>
                                                <c:if test="${taskInfo.annexname!=null&&taskInfo.annexname!=''}">
                                                    <tr>
                                                        <td  nowrap align="right">附件:</td>
                                                        <td  nowrap><input type="text" value="${taskInfo.annexname}" disabled="no"/> </td>
                                                        <td  nowrap><input type="button" onClick="downloadFile(${taskInfo.id})" value="下载"/></td>
                                                        <td  nowrap></td>
                                                    </tr>
                                                </c:if>
                                            <tr>
                                                <td nowrap align="right">任务内容:</td>
                                                <td colspan="3"><textarea name="taskContent" style="width:70%;height:100px" readonly disabled="no">${taskInfo.content}</textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">完成情况:</td>
                                                <td colspan="3"><textarea name="completion"
                                                        <c:if test="${taskInfo.ifcompleted}">
                                                            readonly disabled="no"
                                                        </c:if>
                                                                          style="width:70%;height:100px">${taskInfo.completion}</textarea>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="center">
                                        <c:if test="${taskInfo.ifcompleted!=true}">
                                            <input type="button" name="Submit" value="保存进度" class="button" onclick="save();"/>
                                            <input type="reset" name="reset" value="完成任务" class="button"  onclick="finish();"/>
                                        </c:if>
                                        <input type="button" name="return" value="返回" class="button" onclick="window.history.go(-1);"/>
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
                    src="../../../../images/buttom_left2.gif" width="17" height="17"/></td>
            <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img
                    src="../../../../images/buttom_bgs.gif" width="100%" height="17"></td>
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>
