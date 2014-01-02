<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>
    <script>
        function save(){
            if (!validator(document.mainForm)) {
                return;
            }
            document.mainForm.action="addAnnouncement";
            document.mainForm.submit();
        }
    </script>
    <title>消息通知</title>
    <style type="text/css">
        .message {
            width: 100%;
            border: 1px solid #cbcbcb;
            background-color: #ffffff;
        }
        .hr1 {
            color: #efeeea;
            height: 1px;
            border: 0px;
            border-top: 1px solid #efeeea;
            margin: 0px;
            margin-top: 8px;
            margin-bottom: 8px;
            padding: 0px;
            overflow: hidden;
        }
        a.announcement:link {
            text-decoration: none;
            color: #000000;
        }
        a.announcement:visited {
            text-decoration: none;
            color: #000000;
        }
        a.announcement:hover {
            text-decoration: none;
            color: #FF0000;
        }
        a.announcement:active {
            text-decoration: none;
            color: #000000;
        }
    </style>
</head>
<body style="background-color: #EEF2FB">
<form name="mainForm" method="post">
    <table border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td class="op_nor" onclick="javascript:location.href='announcement'">通知</td>
            <td class="op_nor" onclick="javascript:location.href='message?page=1'">短消息</td>
            <td class="op_act" onclick="javascript:location.href='toaddannouncement'">发布公告</td>
            <td class="op_nor" onclick="javascript:location.href='sendmessage'">发送短消息</td>
        </tr>
    </table>
    <table width="100%"  border="0" cellpadding="0" cellspacing="0" >

        <tr>
            <td valign="top" bgcolor="#EEF2FB">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

                    <tr valign="top">
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
                                <tr bgcolor="#FFFFFF" >
                                    <td  align="center"  bgcolor="#FFFFFF" >
                                        <table border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
                                            <tr>
                                                <td nowrap align="right"  >通知标题:</td>
                                                <td nowrap >
                                                    <input id="announcementTitle" name="announcementTitle" value="${announcementInfo.title}" style="width:154px" maxlength="20"
                                                           valid="required" errmsg="标题不能为空"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">通知内容:</td>
                                                <td nowrap align="left">
                                                    <div id="innerId">
                                                        <span>
                                                            <textarea id= "content" valid="required" errmsg="通知内容不能为空" style="WIDTH: 500px; height: 300px" name="content" rows="20" cols="90"tabIndex="2">${announcementInfo.content}</textarea>
                                                        </span>
                                                        <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.config.js"></script>
                                                        <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.all.js"></script>
                                                        <link type="text/css" href="${pageContext.request.contextPath}/js/ueditor/themes/default/css/ueditor.css"/>
                                                        <script type="text/javascript" charset="utf-8">
                                                            var editor = new baidu.editor.ui.Editor();
                                                            editor.render('content');
                                                        </script>
                                                        <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    </div>

                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td  align="center">
                                                    <input type="button" name="Submit" value="发布" class="button" onclick="save();"/>
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
        </tr>
    </table>

</form>
</body>

</html>
