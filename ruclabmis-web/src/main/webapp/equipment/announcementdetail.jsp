<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>
    <script>
        function save() {

            document.mainForm.action = "addAnnouncement";
            document.mainForm.submit();
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
<body>
<form name="mainForm" method="post" target="_parent">
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
                            <div class="titlebt">通知公告管理</div>
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
                                                                    class="STYLE1">通知公告</span></td>
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
                            <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce"
                                   style="margin: 10px">
                                <tr bgcolor="#FFFFFF">
                                    <td align="center" bgcolor="#FFFFFF">
                                        <table border="0" cellpadding="2" cellspacing="1"
                                               style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#E3E9EE">
                                            <tr>
                                                <td align="center">
                                                    <div class="message"
                                                         style="border: 1px;background: #FFFFFF ;height: 1004px ;width: 95%">
                                                        <p style="height:30px">

                                                        <p>

                                                        <h1 style="text-align: center;margin: 20px">${announcementDetailFlag.title}</h1>
                                                        <hr style="margin: 30px">
                                                        <p style="margin: 30px" align="left">
                                                            <span>发送人 :  </span><span>${announcementDetailFlag.user.name}</span>
                                                            <span style="float:right"><fmt:formatDate
                                                                    value="${announcementDetailFlag.publishTime}"></fmt:formatDate></span>
                                                            <span style="float:right;">发布时间 :  </span></p>
                                                        <hr style="margin: 30px">
                                                        <div style="margin: 30px;text-align: left">${announcementDetailFlag.content}</div>
                                                        <hr style="margin:30px">

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
                                        <input type="button" name="return" value="返回" class="button"
                                               onclick="window.location.go(-1);"/>
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
