<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title></title>

    <script>
        function save(){
            document.mainForm.href="jsp/task/task/add";
            document.mainForm.submit();
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
                            <div class="titlebt">考核管理 > 工作任务考核</div>
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
                                                                    class="STYLE1">编辑任务</span></td>
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
                                            <tr>

                                                <td nowrap align="right">任务名称:</td>
                                                <td nowrap>
                                                    <input name="taskName" id="taskName" onblur="" class="text"
                                                           style="width:154px" maxlength="20" valid="required|isAccount"
                                                           value="${work.name}" readonly/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_task_name"></span>
                                                </td>
                                                <td nowrap align="right">附件:</td>
                                                <td nowrap>
                                                    <input name="annex" id="annex" onblur="" class="text"
                                                           style="width:154px" maxlength="20" valid="required|isAccount"
                                                           value="${work.annex}"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_task_annex"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">完成度:</td>
                                                <td nowrap>
                                                    <input name="completeness" id="" onblur="" class="text"
                                                           style="width:154px" maxlength="20" valid="required|isAccount"
                                                           value="${work.completeness}" />
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_us_sno"></span>
                                                </td>
                                                <td nowrap align="right">完成时间:</td>
                                                <td nowrap>
                                                    <input name="limiteTime" id="limitTime" onblur="" class="text"
                                                           style="width:154px" maxlength="20" valid="required|isAccount"
                                                           value="${work.limitTime}" readonly/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_limit_time"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">任务内容:</td>
                                                <td colspan="3"><textarea name="taskContent" style="width:70%;height:100px" value="${work.content}" readonly></textarea>
                                                    <span style="color:red;"> *</span> &nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_task_content"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">备注:</td>
                                                <td colspan="3"><textarea name="note" style="width:70%;height:100px" value="${work.note}"></textarea>
                                                    <span style="color:red;"> *</span> &nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_task_note"></span>
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
                                        <input type="reset" name="reset" value="重置" class="button"  onclick="reset();"/>
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
