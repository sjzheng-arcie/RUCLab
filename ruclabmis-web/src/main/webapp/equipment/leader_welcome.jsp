<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>welcome</title>
    <link rel="stylesheet" href="css/mian.css" type="text/css"/>
</head>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
    $(function () {
        var indexMainCon_height = pageHeight();
        $(".indexMainCon").height(indexMainCon_height);
        $(".indexNews").height(indexMainCon_height / 2 - 12);
        $(".indexteacherapply").height(indexMainCon_height/2-12);
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
    <div class="indexNews">
        <h3><a href="javascript:void(0)">更多>></a><span>系统公告</span></h3>

        <div class="indexNewsCon">
            <ul>
                <c:forEach items="${announcementList}" var="item">
                    <li><span><fmt:formatDate value="${item.publishTime}"></fmt:formatDate></span><a href="/equipment/jsp/announcement/remind/announcementDetail?announcementDetailId=${item.id}">${item.title}</a></li>

                </c:forEach>


            </ul>
        </div>
    </div>
    <div class="indexNotice">
        <h3><span>个人通知</span></h3>

        <div class="indexNoticeCon">
            <ul>
                <c:forEach items="${messageList}" var="item">
                    <li><span><fmt:formatDate value="${item.sendtime}"></fmt:formatDate></span><a href="/equipment/jsp/announcement/remind/messageDetail?messageDetailId=${item.id}">${item.content}</a></li>

                </c:forEach>

            </ul>
        </div>
    </div>

    <div class="indextrends indexteacherapply">
        <h3><a href="javascript:void(0)">更多>></a><span>待审批单据</span></h3>
        <table width="100%" border="0" cellspacing="0" style="border-color:#eeefff">
            <tr class="title">
                <td width="8%" height="24" align="center">序号</td>
                <td width="32%" align="center">单据类型</td>
                <td width="20%" align="center">状态</td>
                <td width="20%" align="center">提交日期</td>
                <td align="center">详细</td>
            </tr>
            <c:forEach items="${pendingApplyList}" var="item">
                <tr>
                    <td height="24" align="center">1</td>
                    <td align="center">${item.formType.value}</td>

                    <td align="center">${item.state.value}</td>
                    <td align="center"><fmt:formatDate value="${item.applyTime}"></fmt:formatDate></td>
                    <td align="center">详细</td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>
</body>
</html>
