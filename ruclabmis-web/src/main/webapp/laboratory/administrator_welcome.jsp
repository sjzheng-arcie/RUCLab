﻿<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>welcome</title>
    <link rel="stylesheet" href="../css/main.css" type="text/css"/>
</head>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
    $(function () {
        var indexMainCon_height = pageHeight();
        $(".indexMainCon").height(indexMainCon_height);
        $(".indexNews").height(indexMainCon_height / 2 - 12);
        $(".indexteacherapply").height(indexMainCon_height / 2 - 12);
        $(".indexNotice").height(indexMainCon_height / 2 - 12);
        $(window).resize(function () {
            $(".indexMainCon").height(pageHeight());
        });

        function pageHeight() {
            if ($.browser.msie) {
                return document.compatMode == "CSS1Compat" ? document.documentElement.clientHeight :
                        document.body.clientHeight;
            } else {
                return self.innerHeight;
            }
        }

    })


</script>

<body style="width:100%;">
<div class="indexMainCon">
    <div class="indexMainCon">
        <div class="indexNews">
            <h3><a href="/laboratory/jsp/announcement/remind/laboratory/announcement" target="">更多>></a><span>系统公告</span></h3>

            <div class="indexNewsCon">
                <ul>
                    <c:forEach items="${announcementList}" var="item">
                        <li><span><fmt:formatDate value="${item.publishTime}"></fmt:formatDate></span>
                            <a style="max-width: 200px"
                               href="/laboratory/jsp/announcement/remind/laboratory/announcementDetail?announcementDetailId=${item.id}">${item.title}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="indexNotice">
            <h3><a href="/laboratory/jsp/announcement/remind/laboratory/message?page=1" target="">更多>></a><span>消息通知</span></h3>

            <div class="indexNoticeCon">
                <ul>
                    <c:forEach items="${messageList}" var="item">
                        <li><span><fmt:formatDate value="${item.sendtime}"></fmt:formatDate></span>
                            <a style="max-width: 200px"href="/laboratory/jsp/announcement/remind/laboratory/messageDetail?messageDetailId=${item.id}">${item.content}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="indextrends indexteacherapply">
            <h3><a href="javascript:void(0)">更多>></a><span>待审核的预约</span></h3>
            <table width="100%" border="0" cellspacing="0" style="border-color:#eeefff">
                <tr class="title">
                    <td height="24" align="center">序号</td>
                    <td align="center">预约类型</td>
                    <td align="center">用途</td>
                    <td align="center">日期</td>
                    <td align="center">实验室房间</td>
                    <td align="center">状态</td>
                    <td align="center">申请人</td>
                    <td align="center"><a href="new/pages_miyl/miyl01_ylsj/dateinfo.html">详细</a></td>
                </tr>
                <tr>
                    <td height="24" align="center">1</td>
                    <td align="center">实验室预约</td>
                    <td align="center">C语言编程实验</td>
                    <td align="center">2013年5月6日</td>
                    <td align="center">J11-122</td>
                    <td align="center">已批准</td>
                    <td align="center">曹孟德</td>
                    <td align="center"><a href="new/pages_miyl/miyl01_ylsj/dateinfo.html">详细</a></td>

                </tr>
                <tr>
                    <td height="24" align="center">2</td>
                    <td align="center">实验室预约</td>
                    <td align="center">C语言编程实验</td>
                    <td align="center">2013年5月6日</td>
                    <td align="center">J11-122</td>
                    <td align="center">已批准</td>
                    <td align="center">郭奉孝</td>
                    <td align="center"><a href="new/pages_miyl/miyl01_ylsj/dateinfo.html">详细</a></td>

                </tr>
                <tr>
                    <td height="24" align="center">3</td>
                    <td align="center">实验室预约</td>
                    <td align="center">C语言编程实验</td>
                    <td align="center">2013年5月6日</td>
                    <td align="center">J11-122</td>
                    <td align="center">已批准</td>
                    <td align="center">姜伯约</td>
                    <td align="center"><a href="new/pages_miyl/miyl01_ylsj/dateinfo.html">详细</a></td>

                </tr>
                <tr>
                    <td height="24" align="center">4</td>
                    <td align="center">实验室预约</td>
                    <td align="center">C语言编程实验</td>
                    <td align="center">2013年5月6日</td>
                    <td align="center">J11-122</td>
                    <td align="center">已批准</td>
                    <td align="center"> 陆伯言</td>
                    <td align="center"><a href="new/pages_miyl/miyl01_ylsj/dateinfo.html">详细</a></td>

                </tr>
            </table>
        </div>
    </div>
</body>
</html>
