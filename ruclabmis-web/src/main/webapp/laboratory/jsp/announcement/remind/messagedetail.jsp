<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script src="../../../../js/valid.js" type=text/javascript></script>
    <script>
        function save() {

            document.form1.action = "/equipment/jsp/announcement/remind/${fatherPage}?page=0&&fatherPage=${fatherPage}";
            document.form1.submit();
        }
        function displayClass(value) {

            if (value == "2") {
                document.getElementById('scopeDiv').style.display = '';
            } else {
                document.getElementById('scopeDiv').style.display = 'none';
            }

        }

    </script>

</head>
<body style="background-color: #ffffff">
<form name="form1" method="post" target="_self"
      action="/equipment/jsp/announcement/remind/${fatherPage}?page=0&&fatherPage=${fatherPage}">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif">

            </td>
            <td valign="top" background="../../../../images/content-bg.gif">

            </td>
            <td width="16" valign="top" background="../../../../images/mail_rightbg.gif">

            </td>
        </tr>
        <tr>
            <td valign="middle" background="../../../../images/mail_leftbg.gif">&nbsp;</td>
            <td valign="top" bgcolor="#F7F8F9">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

                    <tr valign="top">
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF"
                                   style="margin: 10px">
                                <tr bgcolor="#FFFFFF">
                                    <td align="center" bgcolor="#FFFFFF">
                                        <table border="0" cellpadding="2" cellspacing="1"
                                               style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#FFFFFF">
                                            <tr>
                                                <td align="center">
                                                    <div class="message"
                                                         style="border: 1px;background: #FFFFFF ;height: 600px ;width: 95%">
                                                        <p style="height:30px">

                                                        <p>

                                                        <h1 style="text-align: left;margin: 20px">详细信息：</h1>

                                                        <p style="margin: 30px" align="left">
                                                            <span>接收人 :  </span><span>${messageDetailFlag.sender.name}</span>
                                                            <span style="float:right"><fmt:formatDate
                                                                    value="${messageDetailFlag.sendtime}"></fmt:formatDate></span>
                                                            <span style="float:right;">发送时间 :  </span></p>
                                                        <hr style="margin: 30px">
                                                        <div style="margin: 30px;text-align: left">${messageDetailFlag.content}</div>
                                                        <hr style="margin:30px">
                                                        <p style="margin: 30px" align="left">
                                                            <span>发送人 :  </span><span>${messageDetailFlag.sender.name}</span>
                                                        </p>

                                                    </div>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">

                                <tr>
                                    <td align="center">
                                        <input type="button" name="Submit2" value="返回" class="button" onclick="save()"/>
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
    <input type="hidden" name="us_sreplyby" value=""/>
</form>
</body>
