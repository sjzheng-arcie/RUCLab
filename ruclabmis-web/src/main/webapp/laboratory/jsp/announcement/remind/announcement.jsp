<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/util.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/page.js"></script>
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>

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
    <script type="text/javascript">
        function goPage(pageIndex, maxPage) {
            if (pageIndex <= 0) {
                alert("已到达首页！");
                return;
            }
            if (pageIndex > maxPage) {
                alert("已到达尾页！");
                return;
            }
            var curUrl = window.location.href;
            var flag = curUrl.indexOf('?'),
                    pageFlag = curUrl.indexOf("page=");
            curUrl = (flag == -1) ? (curUrl + "?page=" + pageIndex) :
                    ((pageFlag == -1) ? (curUrl + "&page=" + pageIndex) : (curUrl.replace(/page=\d+/, 'page=' + pageIndex)));

            document.forms[0].action = curUrl;
            document.forms[0].submit();
        }
    </script>

</head>
<body style="background-color: #EEF2FB">
<form name="listForm" method="post">
    <table border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td class="op_act" onclick="javascript:location.href='announcement'">公告</td>
            <td class="op_nor" onclick="javascript:location.href='message?page=1'">短消息</td>
            <shiro:lacksRole name="student">
            <td class="op_nor" onclick="javascript:location.href='toaddannouncement'">发布公告</td>
            </shiro:lacksRole>
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


                                                    <div style="border: 1px;background-color: #FFFFFF;">

                                                        <c:forEach items="${pageInfo.data}" var="item">
                                                            <div class="message"
                                                                 style="border: 1px;background-color: #FFFFFF">
                                                                <hr size="0"
                                                                    style="  border:none; border-bottom:1px dashed #ccc;">
                                                                <p align="left" style="margin: 10px;font-size: 12px">
                                                                <span>
                                                                    <a class="announcement"
                                                                       href="announcementDetail?announcementDetailId=${item.id}">
                                                                            ${item.title}
                                                                    </a>
                                                                </span>
                                                                    <span style="float:right">
                                                                        <fmt:formatDate pattern="yyyy-MM-dd" value="${item.publishTime}"></fmt:formatDate>
                                                                    </span>
                                                                            <c:if test="${currentUserInfo.id==item.publisherId}">
                                                                                <span style="float:right"> <a class="button" href="/laboratory/jsp/announcement/remind/laboratory/toUpdateAnnouncement?announcementId=${item.id}&page=${pageInfo.currentPage}">修改</a></span>
                                                                                <span style="float:right"><a class="button" href="/laboratory/jsp/announcement/remind/laboratory/deleteAnnouncement?announcementId=${item.id}&page=${pageInfo.currentPage}">删除</a></span>
                                                                            </c:if>

                                                            </div>
                                                        </c:forEach>
                                                        <hr size="0"
                                                            style="  border:none; border-bottom:1px dashed #ccc;">
                                                    </div>
                                                </td>
                                            </tr>
                                            <%@ include file="../../../../include/pagetable.jsp" %>
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
