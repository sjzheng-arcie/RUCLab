﻿<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>人大信息学院实验室管理平台登录</title>
    <style type="text/css">

        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            background-color: #1D3647;
        }

    </style>
    <script language="JavaScript">
        function correctPNG() {
            var arVersion = navigator.appVersion.split("MSIE")
            var version = parseFloat(arVersion[1])
            if ((version >= 5.5) && (document.body.filters)) {
                for (var j = 0; j < document.images.length; j++)
                {
                    var img = document.images[j]
                    var imgName = img.src.toUpperCase()
                    if (imgName.substring(imgName.length - 3, imgName.length) == "PNG") {
                        var imgID = (img.id) ? "id='" + img.id + "' " : ""
                        var imgClass = (img.className) ? "class='" + img.className + "' " : ""
                        var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
                        var imgStyle = "display:inline-block;" + img.style.cssText
                        if (img.align == "left") imgStyle = "float:left;" + imgStyle
                        if (img.align == "right") imgStyle = "float:right;" + imgStyle
                        if (img.parentElement.href) imgStyle = "cursor:pointer;" + imgStyle
                        var strNewHTML = "<span " + imgID + imgClass + imgTitle
                                + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
                                + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"
                                + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>"
                        img.outerHTML = strNewHTML
                        j = j - 1
                    }
                }
            }
        }
        if (window.attachEvent) {
            window.attachEvent("onload", correctPNG);
            //window.attachEvent("onresize",  iframeAutoFit);
        }
        else if (window.addEventListener) {
            window.addEventListener('load', correctPNG, false);
            //window.addEventListener('resize',  iframeAutoFit,  false);
        }
    </script>


    <link href="${pageContext.request.contextPath}/images/skin.css" rel="stylesheet" type="text/css">
</head>


<body>
<table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td height="42" valign="top">
            <table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
                <tr>
                    <td width="1%" height="21">&nbsp;</td>
                    <td height="42">&nbsp;</td>
                    <td width="17%">&nbsp;</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td valign="top">
            <table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
                <tr>
                    <td width="49%" align="right">
                        <table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
                            <tr>
                                <td height="138" valign="top">
                                    <table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td height="149">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td height="200" align="right" valign="top"><img src="${pageContext.request.contextPath}/images/logo_lab.png"
                                                                                            width="279" height="68">
                                            </td>
                                    </table>
                                </td>
                            </tr>

                        </table>
                    </td>
                    <td width="1%">&nbsp;</td>
                    <td width="50%" valign="bottom">
                        <table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="4%">&nbsp;</td>
                                <td width="96%" height="38"><span class="login_txt_bt">登录人大信息学院实验室管理平台</span></td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td height="21">
                                    <table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211"
                                           height="328">
                                        <tr>
                                            <td height="164" colspan="2" align="middle">
                                                <form name="myform" action="/login/laboratory/excutelogin" method="post">
                                                    <table cellSpacing="0" cellPadding="0" width="100%" border="0"
                                                           height="143" id="table212">
                                                        <tr>
                                                            <td width="13%" height="38" class="top_hui_text"><span
                                                                    class="login_txt">用 &nbsp; 户： </span></td>
                                                            <td height="38" colspan="2" class="top_hui_text"><input
                                                                    name="username" class="editbox4"
                                                                    value="${preUserName}" size="20">
                                                                <span style="color: #ff0000">${userNameNotExist}</span>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td width="13%" height="35" class="top_hui_text"><span
                                                                    class="login_txt">密 &nbsp; 码：  </span></td>
                                                            <td height="35" colspan="2" class="top_hui_text"><input
                                                                    class="editbox4" type="password" size="20"
                                                                    name="password">
                                                                <span style="color: #ff0000">${passwordNotMatch}</span>
                                                            </td>
                                                        </tr>

                                                        <tr>
                                                            <td height="35">&nbsp;</td>
                                                            <td width="20%" height="35"><input name="Submit"
                                                                                               type="submit"
                                                                                               class="button"
                                                                                               id="Submit" value="登 录">
                                                            </td>
                                                            <td width="67%" class="top_hui_text"><input name="cs"
                                                                                                        type="button"
                                                                                                        class="button"
                                                                                                        id="cs"
                                                                                                        value="取 消"
                                                                                                        onClick="showConfirmMsg1()">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                    <br>
                                                </form>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="433" height="164" align="right" valign="bottom"><img
                                                    src="${pageContext.request.contextPath}/images/login-wel.gif" width="242" height="138"></td>
                                            <td width="57" align="right" valign="bottom">&nbsp;</td>
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
        <td height="20">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
                <tr>
                    <td align="center"><span class="login-buttom-txt">Copyright &copy; 2009-2014 </span></td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<html>
