<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script src="../../../../../js/valid.js" type=text/javascript></script>
    <script>
        function commit() {
            if (!validator(document.mainForm)) {
                return;
            }

            document.mainForm.action = "updatePassword";
            document.mainForm.submit();
        }

        function checkErrMag() {
            var errMsg = "${errMsg}";
            if (errMsg.length <= 0 || errMsg.length == "") {
                return;
            }
            alert(errMsg);
        }

    </script>
</head>

<body onload="checkErrMag()">
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
                            <div class="titlebt">系统管理 > 修改密码</div>
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
                            <table width="100%" border="" cellspacing="0" cellpadding="0">
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
                                                                    class="STYLE1">修改密码</span></td>
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
                        <td align="center">
                            <table align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
                                   bgcolor="#a8c7ce">
                                <tr bgcolor="#E3E9EE">
                                    <td bgcolor="#E3E9EE">
                                        <table align="center" border="0" cellpadding="2" cellspacing="1"
                                               style="width:50%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#E3E9EE">
                                            <input name="id" id="id" type="hidden"
                                                   value="${id}"/>
                                            <tr>
                                                <td nowrap align="right">原密码:</td>
                                                <td nowrap>
                                                    <input name="oriPassword" id="oriPassword" class="text"
                                                           type="password"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                </td>

                                            </tr>

                                            <tr>
                                                <td nowrap align="right">新密码:</td>
                                                <td nowrap>
                                                    <input type="password" name="newPassword" id="newPassword"
                                                           class="text"
                                                           valid="required|isPassword"
                                                           errmsg="密码不能为空!|密码只能以字母数字下划线组成6至16位!"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                </td>

                                            </tr>
                                            <tr>
                                                <td nowrap align="right">确认新密码:</td>
                                                <td nowrap>
                                                    <input type="password" name="checkPassword" id="checkPassword"
                                                           class="text"
                                                           valid="required|equal"
                                                           equalName="newPassword" errmsg="确认密码不能为空!|两次密码不同!"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                </td>

                                            </tr>

                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="center">
                                        <input type="button" name="Submit" value="保存" class="button" onclick="commit();"/>
                                        <input type="reset" name="reset" value="重置" class="button"/>
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
            <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/buttom_left2.gif"
                    width="17" height="17"/></td>
            <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img
                    src="../../../../images/buttom_bgs.gif"
                    width="100%" height="17"></td>
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
