<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
            <h3><a href="/laboratory/jsp/announcement/remind/laboratory/message?page=1" target="">更多>></a><span>消息中心</span></h3>

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
        <div class="indextrends indexNews">
            <h3><a href="javascript:void(0)">更多>></a><span>我的申请单</span></h3>
            <table width="100%" border="0" cellspacing="0" style="border-color:#eeefff">
                <tr class="title">
                    <td width="8%" height="24" align="center">序号</td>
                    <td width="32%" align="center">单据名称</td>
                    <td width="20%" align="center">单据类型</td>
                    <td width="20%" align="center">提交日期</td>
                    <td align="center">状态</td>
                </tr>
                <tr>
                    <td height="24" align="center">1</td>
                    <td align="center">名称</td>
                    <td align="center">类型</td>
                    <td align="center">2013年5月6日</td>
                    <td align="center">填写</td>
                </tr>
                <tr>
                    <td height="24" align="center">2</td>
                    <td align="center">单据名称</td>
                    <td align="center">类型</td>
                    <td align="center">2013年4月25日</td>
                    <td align="center">填写</td>
                </tr>
                <tr>
                    <td height="24" align="center">3</td>
                    <td align="center">名称</td>
                    <td align="center">类型</td>
                    <td align="center">2013年4月23日</td>
                    <td align="center">填写</td>
                </tr>
                <tr>
                    <td height="24" align="center">4</td>
                    <td align="center">单据名称</td>
                    <td align="center">类型</td>
                    <td align="center">2013年4月16日</td>
                    <td align="center">填写</td>
                </tr>
            </table>


        </div>
        <div class="indexNotice">
            <h3><a href="javascript:void(0)">更多>></a><span>审批单据</span></h3>
            <table width="100%" border="0" cellspacing="0" style="border-color:#eeefff">
                <tr class="title">
                    <td width="8%" height="24" align="center">序号</td>
                    <td width="32%" align="center">单据名称</td>
                    <td width="20%" align="center">单据类型</td>
                    <td width="20%" align="center">提交日期</td>
                    <td align="center">状态</td>
                </tr>
                <tr>
                    <td height="24" align="center">1</td>
                    <td align="center">名称</td>
                    <td align="center">类型</td>
                    <td align="center">2013年5月7日</td>
                    <td align="center">填写</td>
                </tr>
                <tr>
                    <td height="24" align="center">2</td>
                    <td align="center">单据名称</td>
                    <td align="center">类型</td>
                    <td align="center">2013年4月26日</td>
                    <td align="center">填写</td>
                </tr>
                <tr>
                    <td height="24" align="center">3</td>
                    <td align="center">名称</td>
                    <td align="center">类型</td>
                    <td align="center">2013年4月24日</td>
                    <td align="center">填写</td>
                </tr>
                <tr>
                    <td height="24" align="center">4</td>
                    <td align="center">单据名称</td>
                    <td align="center">类型</td>
                    <td align="center">2013年4月17日</td>
                    <td align="center">填写</td>
                </tr>
            </table>

        </div>
    </div>
</body>
</html>
