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

    });
    function queryscore(cid,stuId){
        window.location.href = "/experiment/virtual/scoreStudent?vcId="+cid+"&stuId="+stuId;
    }
    function viewExperiment(vcid,curriculumClassId){
        window.location.href = "/laboratory/jsp/experiment/experiment/sutdentexperimentlist?cid="+vcid+"&page=1&view=report"+"&curriculumClassId="+curriculumClassId;
    }


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
            <h3><a href="jsp/experiment/experiment/courselist?page=1&view=achievement">更多>></a><span>我的实验课程</span></h3>
            <table width="100%" border="0" cellspacing="0" style="border-color:#eeefff">
                <tr class="title">
                    <td height="24" align="center">序号</td>
                    <td align="center">班级名称</td>
                    <td align="center">课程名称</td>
                    <td align="center">学年</td>
                    <td align="center">任课老师</td>

                    <td align="center">查看成绩</td>
                    <td align="center">查看实验报告</td>
                </tr>
                <% int i=0;%>
                <c:forEach items="${curriculumClassList}" var="item">
                    <% i++; %>
                    <tr align="center">
                        <td><%=i%></td>
                        <td>${item.className}</td>
                        <td>${item.curriculumName}</td>
                        <td>${item.classYear}</td>
                        <td>${item.teacherName}</td>
                        <td>
                            <input type="button" onClick="queryscore('${item.id}','${userId}');"
                                   class="button" value="查询成绩"/>
                        </td>
                        <td>
                            <input type="button" onClick="viewExperiment('${item.id}','${item.id}');"
                                   class="button" value="查看实验报告"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    </div>
</body>
</html>
