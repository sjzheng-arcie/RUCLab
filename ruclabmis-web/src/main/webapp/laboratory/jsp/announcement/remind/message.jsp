<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/util.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/page.js"></script>
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>
    <link href="${pageContext.request.contextPath}/laboratory/jsp/curriculum/css/style.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        .message {
            border: 1px solid #cbcbcb;
            background-color: #ffffff;
        }
        .hr1 {
            color: #aaaaaa;
            height: 1px;
            border: 0px;
            border-top: 1px solid #efeeea;
            margin: 8px;
            margin-top: 8px;
            margin-bottom: 8px;
            padding: 0px;
            overflow: hidden;
        }
        .hr2 {
            color: #ffffff;
            height: 1px;
            border: 0px;
            border-top: 1px solid #ffffff;
            margin: 0px;
            margin-top: 8px;
            margin-bottom: 8px;
            padding: 0px;
            overflow: hidden;
        }
        a.A_See:link {
            text-decoration: none;
            color: #376189;
        }
        a.A_See:visited {
            text-decoration: none;
            color: #376189;
        }
        a.A_See:hover {
            text-decoration: none;
            color: #376189;
        }
        a.A_See:active {
            text-decoration: none;
            color: #376189;
        }
    </style>
    <title>消息通知</title>
    <script>
        var replyFlag = "${replySn}";
    </script>
</head>
<body  style="background-color:#EEF2FB;">
<form name="mainForm" method="get">
    <table border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td class="op_nor" onclick="javascript:location.href='announcement'">公告</td>
            <td class="op_act" onclick="javascript:location.href='message'">短消息</td>
            <td class="op_nor" onclick="javascript:location.href='toaddannouncement'">发布公告</td>
            <td class="op_nor" onclick="javascript:location.href='sendmessage'">发送短消息</td>
        </tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">

        <tr>
            <td valign="top" bgcolor="#EEF2FB">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">

                    <tr valign="top">
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#a8c7ce">
                                <tr align="center" bgcolor="#E3E9EE" style=" height: 10px;background-color: #E3E9EE">
                                    <td bgcolor="#E3E9EE"></td>
                                </tr>
                                <tr bgcolor="#E3E9EE">

                                    <td align="center" bgcolor="#E3E9EE">
                                        <table border="0" cellpadding="2" cellspacing="1"
                                               style="width:99%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#E3E9EE">
                                            <tr>
                                                <td align="center">

                                                    <div style="border: 1px; background:#FFFFFF;margin: 10px ;">
                                                        <div class="message"
                                                             style="border: 1px;background-color: #FFFFFF ;margin: 10px ;">
                                                            <p align="left" style="font-size: 12px">
                                                                <a class="A_See"
                                                                   href="/messagecenter/laboratory/jsp/announcement/remind/message?page=0&&fatherPage=message">全部消息</a>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
                                                                <a class="A_See"
                                                                   href="/messagecenter/laboratory/jsp/announcement/remind/unreadmessage?page=0&&fatherPage=unreadmessage">未读消息</a>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
                                                                <a class="A_See"
                                                                   href="/messagecenter/laboratory/jsp/announcement/remind/readmessage?page=0&&fatherPage=readmessage">已读消息</a>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
                                                                <a class="A_See"
                                                                   href="/messagecenter/laboratory/jsp/announcement/remind/mysendmessage?page=0&&fatherPage=mysendmessage">我发送的消息</a>
                                                            </p>
                                                        </div>
                                                        <hr size="0" class="hr1">
                                                        <c:choose>
                                                            <c:when test="${mode==null}">
                                                                <c:forEach items="${pageInfo.data}" var="item">
                                                                    <div class="message"
                                                                         style="border: 1px ;background-color: #FFFFFF ;margin: 10px ;">
                                                                        <p align="left"><span
                                                                                style="font-size: 16px;color: #316491;font-weight: bold;">${item.sender.name
                                                                                } </span> <span style="color: #A3A3A1">
                                                                            <fmt:formatDate
                                                                                    pattern="yyyy-MM-dd HH:mm:ss"
                                                                                    value="${item.sendtime}"></fmt:formatDate></span>
                                                                        </p>
                                                                        <c:if test="${item.ifread==true}">

                                                                            <p align="left">${item.content}</p>
                                                                        </c:if>
                                                                        <c:if test="${item.ifread==false}">
                                                                            <p align="left"
                                                                               style="font-weight: bold ">${item.content}</p>
                                                                        </c:if>
                                                                        <p align="left" style="font-size: 12px">
                                                                            <a class="A_See"
                                                                               href="/messagecenter/laboratory/jsp/announcement/remind/messageDetail?messageDetailId=${item.id}&&fatherPage=${fatherPage}">查看详细></a>
                                                                            &nbsp&nbsp&nbsp&nbsp&nbsp<a class="A_See"
                                                                                                        target="_parent"
                                                                                                        href="/messagecenter/laboratory/jsp/announcement/remind/replyMessage?replyFlag=${item.sender.sn}">回复</a>
                                                                            &nbsp&nbsp&nbsp&nbsp&nbsp<a class="A_See"
                                                                                                        target="_parent"
                                                                                                        href="/messagecenter/laboratory/jsp/announcement/remind/deleteMessage?deleteMessageId=${item.id}">删除该条信息</a>
                                                                        </p>
                                                                        <hr size="0"
                                                                            style="  border:none; border-bottom:1px dashed #ccc;">
                                                                    </div>
                                                                </c:forEach>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <c:forEach items="${pageInfo.data}" var="item">
                                                                    <div class="message"
                                                                         style="border: 1px;background-color: #FFFFFF;margin: 10px ;">
                                                                        <p align="left"><span
                                                                                style="font-size: 16px;color: #ccc;;">收信人：</span><span
                                                                                style="font-size: 16px;color: #316491;font-weight: bold;">${item.receiver.name}</span> <span
                                                                                style="color: #A3A3A1">
                                                                         <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                                                         value="${item.sendtime}"></fmt:formatDate></span>
                                                                        </p>
                                                                        <p align="left">${item.content}</p>
                                                                        <p align="left" style="font-size: 12px"><a
                                                                                class="A_See"
                                                                                href="/messagecenter/laboratory/jsp/announcement/remind/messageDetail?messageDetailId=${item.id}">查看详细></a>
                                                                            &nbsp&nbsp&nbsp&nbsp&nbsp
                                                                            <a class="A_See"
                                                                               href="/messagecenter/laboratory/jsp/announcement/remind/deleteMessage?deleteMessageId=${item.id}">删除该条信息</a>
                                                                        </p>
                                                                        <hr size="0"
                                                                            style="  border:none; border-bottom:1px dashed #ccc;">
                                                                    </div>
                                                                </c:forEach>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <hr size="0" class="hr2">
                                                    </div>

                                                </td>
                                            </tr>
                                            <%@ include file="/js/pagetableformessage.jsp" %>
                                        </table>
                                    </td>
                                </tr>
                                <tr align="center" bgcolor="#E3E9EE" style=" height: 10px;background-color: #E3E9EE">
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
</html>
