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
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script src="../../../../js/DatePicker/WdatePicker.js" type=text/javascript></script>
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>
    <title></title>

    <script>
        function save(){
            if (!validator(document.mainForm)) {
                return;
            }
            document.mainForm.action="update";
            document.mainForm.submit();
        }

    </script>
</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="mainForm" method="POST">

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
                            <div class="titlebt">考核管理 > 任务详情</div>
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
                                        <input type="hidden" name="taskId" value="${taskInfo.id}"/>
                                        <table border="0" cellpadding="2" cellspacing="1"
                                               style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#E3E9EE">
                                            <tr>
                                                <td nowrap align="right">任务名称:</td>
                                                <td nowrap>
                                                    <input name="taskName" id="taskName" class="text"
                                                           valid="required" errmsg="请输入任务名！"
                                                           value="${taskInfo.taskname}" />
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_task_name"></span>
                                                </td>
                                                <td nowrap align="right">执行人:</td>
                                                <td nowrap>
                                                    <input name="operator" id="operator" onblur="" class="text"
                                                           style="width:154px" maxlength="20" readonly disabled="no"
                                                           value="${teacherInfo.name}"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_task_no"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">完成进度:</td>
                                                <td nowrap>
                                                    <input name="completeness" id="" onblur="" class="text"
                                                           style="text-align: right;"size="2" valid="required|isNum"
                                                           errmsg="请输入完成进度（1~100之间的整数）|必须是1~100之间的整数！"
                                                           value="${taskInfo.completely}" readonly/>%
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_us_sno"></span>
                                                </td>
                                                <td nowrap align="right">完成时间:</td>
                                                <td nowrap>
                                                    <input class="text" name="limitDate"
                                                           value="<fmt:formatDate value="${taskInfo.limitdate}"/>"
                                                            style="width:154px" maxlength="20" valid="isDate|required"
                                                            errmsg="日期只能为：XXXX-XX-XX|请填写日期"
                                                            onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_limit_time"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">任务内容:</td>
                                                <td colspan="3"><textarea name="taskContent" style="width:70%;height:100px" value="">${taskInfo.content}</textarea>
                                                    <span style="color:red;"> *</span> &nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_task_content"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">完成情况:</td>
                                                <td colspan="3"><textarea name="note" style="width:70%;height:100px" value="" disabled="no">${taskInfo.completion}</textarea>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="center">
                                        <input type="button" name="Submit" value="保存" class="button" onclick="save();"/>
                                        <input type="reset" name="reset" value="清空" class="button"  onclick="reset();"/>
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
