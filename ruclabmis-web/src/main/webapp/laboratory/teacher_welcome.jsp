﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            <h3><a href="jsp/announcement/remind/remind?id=0&&page=0 "  target="">更多>></a><span>系统公告</span></h3>

            <div class="indexNewsCon">
                <ul>
                    <c:forEach items="${announcementList}" var="item">
                        <li><span><fmt:formatDate value="${item.publishTime}"></fmt:formatDate></span>
                            <a style="max-width: 200px" href="/equipment/jsp/announcement/remind/announcementDetail?announcementDetailId=${item.id}">${item.title}</a></li>

                    </c:forEach>


                </ul>
            </div>
        </div>
        <div class="indexNotice">
            <h3><span>个人通知</span></h3>

            <div class="indexNoticeCon">
                <ul>
                    <c:forEach items="${messageList}" var="item">
                        <li><span><fmt:formatDate value="${item.sendtime}"></fmt:formatDate></span>

                            <a id="aa" style="max-width: 200px" href="/equipment/jsp/announcement/remind/messageDetail?messageDetailId=${item.id}">${item.content}</a>

                        </li>

                    </c:forEach>

                </ul>
            </div>
        </div>
    <div class="indextrends indexNews">
        <h3><a href="javascript:void(0)">更多>></a><span>我的课程单</span></h3>
        <table width="100%" border="0" cellspacing="0" style="border-color:#eeefff">
            <tr class="title">
                <td width="8%" height="24" align="center">序号</td>
                <td width="32%" align="center">课程编号</td>
                <td width="32%" align="center">课程名称</td>
                <td width="20%" align="center">所有实验</td>

                <td align="center">详细</td>
            </tr>
            <tr>
                <td height="24" align="center">1</td>
                <td align="center">RJ0001</td>
                <td align="center">软件工程</td>
                <td align="center"><a href="jsp/experiment/experimentpaper/list.html">所有实验</a></td>
                <td align="center"><a href="jsp/dev/store/applyinfo.html"/> 详细</td>
            </tr>
            <tr>
                <td height="24" align="center">2</td>
                <td align="center">RJ0002</td>
                <td align="center">软件测试</td>
                <td align="center"><a href="jsp/experiment/experimentpaper/list.html">所有实验</a></td>
                <td align="center"><a href="jsp/dev/store/applyinfo.html"/> 详细</td>
            </tr>
            <tr>
                <td height="24" align="center">3</td>
                <td align="center">RJ0003</td>
                <td align="center">软件工具</td>
                <td align="center"><a href="jsp/experiment/experimentpaper/list.html">所有实验</a></td>
                <td align="center"><a href="jsp/dev/store/applyinfo.html"/> 详细</td>
            </tr>
            <tr>
                <td height="24" align="center">4</td>
                <td align="center">RJ0004</td>
                <td align="center">软件工程导论</td>
                <td align="center"><a href="jsp/experiment/experimentpaper/list.html">所有实验</a></td>
                <td align="center"><a href="jsp/dev/store/applyinfo.html"/> 详细</td>
            </tr>
        </table>


    </div>
    <div class="indexNotice">
        <h3><a href="javascript:void(0)">更多>></a><span>实验报告管理</span></h3>
        <table width="100%" border="0" cellspacing="0" style="border-color:#eeefff">
            <tr class="title">
                <td width="8%" height="24" align="center">序号</td>
                <td width="32%" align="center">实验</td>
                <td width="20%" align="center">所属课程</td>
                <td width="20%" align="center">提交截止日期</td>
                <td align="center">查看</td>
            </tr>
            <tr>
                <td height="24" align="center">1</td>
                <td align="center">C语言编程实验一</td>
                <td align="center">编程语言</td>
                <td align="center">2012-02-12</td>
                <td align="center"><a href="jsp/experiment/report/list.html"/> 查看</td>
            </tr>
            <tr>
                <td height="24" align="center">2</td>
                <td align="center">面向对象实验二</td>
                <td align="center">Java入门</td>
                <td align="center">2012-02-12</td>
                <td align="center"><a href="jsp/experiment/report/list.html"/> 查看</td>
            </tr>
            <tr>
                <td height="24" align="center">3</td>
                <td align="center">用例图实画</td>
                <td align="center">软件测试</td>
                <td align="center">2012-02-12</td>
                <td align="center"><a href="jsp/experiment/report/list.html"/> 查看</td>
            </tr>
            <tr>
                <td height="24" align="center">4</td>
                <td align="center">水晶头接线实验</td>
                <td align="center">网络工程</td>
                <td align="center">2012-02-12</td>
                <td align="center"><a href="jsp/experiment/report/list.html"/> 查看</td>
            </tr>
        </table>

    </div>
</div>
</body>
</html>