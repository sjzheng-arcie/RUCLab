<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>
    <script>
        function back() {

            document.mainForm.action = "/messagecenter/laboratory/jsp/announcement/remind/${fatherPage}?page=0&&fatherPage=${fatherPage}";
            document.mainForm.submit();
        }

    </script>

</head>
<body style="background-color: #EEF2FB">
<form name="mainForm" method="post" target="_self"
      action="/messagecenter/laboratory/jsp/announcement/remind/${fatherPage}?page=0&&fatherPage=${fatherPage}">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <tr>
            <td width="17" valign="top" background="${pageContext.request.contextPath}/images/mail_leftbg.gif">

            </td>
            <td valign="top" background="${pageContext.request.contextPath}/images/content-bg.gif">

            </td>
            <td width="16" valign="top" background="${pageContext.request.contextPath}/images/mail_rightbg.gif">

            </td>
        </tr>
        <tr>
            <td valign="middle" background="${pageContext.request.contextPath}/images/mail_leftbg.gif">&nbsp;</td>
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
                                        <input type="button" name="return" value="返回" class="button" onclick="back()"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td background="${pageContext.request.contextPath}/images/mail_rightbg.gif">&nbsp;</td>
        </tr>
        <tr>
            <td valign="bottom" background="${pageContext.request.contextPath}/images/mail_leftbg.gif"><img
                    src="${pageContext.request.contextPath}/images/buttom_left2.gif" width="17" height="17"/></td>
            <td valign="bottom" background="${pageContext.request.contextPath}/images/buttom_bgs.gif"><img
                    src="${pageContext.request.contextPath}/images/buttom_bgs.gif" width="100%" height="17"></td>
            <td valign="bottom" background="${pageContext.request.contextPath}/images/mail_rightbg.gif"><img
                    src="${pageContext.request.contextPath}/images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>

</form>
</body>
