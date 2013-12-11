<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script src="../../../../js/valid.js" type=text/javascript></script>

</head>
<body style="background-color: #EEF2FB">
<form name="mainForm" method="post" target="_parent">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">

        <tr>
            <td valign="top" bgcolor="#EEF2FB">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

                    <tr valign="top">
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#a8c7ce">
                                <tr align="center" bgcolor="#EEF2FB" style=" height: 10px;background-color: #E3E9EE">
                                    <td bgcolor="#EEF2FB"></td>
                                </tr>
                                <tr bgcolor="#EEF2FB">

                                    <td align="center" bgcolor="#EEF2FB">
                                        <table border="0" cellpadding="2" cellspacing="1"
                                               style="width:99%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#EEF2FB">
                                            <tr>
                                                <td align="center">
                                                    <div class="message"
                                                         style="border: 1px;background: #FFFFFF;width: 95%">
                                                        <span style="float: right">&nbsp;&nbsp;<a value="返回"
                                                                                                  class="buttson"
                                                                                                  onclick="window.history.go(-1);"><img
                                                                src="../../../../images/close_ico.ico"></a></span>

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
                                                        <p style="height:30px">

                                                        <p>
                                                    </div>
                                                </td>
                                            </tr>


                                        </table>
                                    </td>

                                </tr>
                                <tr align="center" bgcolor="#EEF2FB" style=" height: 10px;background-color: #EEF2FB">
                                    <td align="center">
                                        <input type="button" name="return" value="返回" class="button"
                                               onclick="window.history.go(-1);"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>

        </tr>

    </table>

</form>
</body>