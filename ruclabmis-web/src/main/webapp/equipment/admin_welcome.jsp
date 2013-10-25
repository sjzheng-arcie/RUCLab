﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <div class="indexNews">
        <h3><a href="javascript:void(0)">更多>></a><span>系统公告</span></h3>

        <div class="indexNewsCon">
            <ul>
                <li><span>[2013年5月8日]</span><a href="remind.html">网络整改通知</a></li>
                <li><span>[2012年4月27日]</span><a href="remind.html">虚拟化实验室配电整改通知</a></li>


            </ul>
        </div>
    </div>
    <div class="indexNotice">
        <h3><span>个人通知</span></h3>

        <div class="indexNoticeCon">
            <ul>
                <li><span>[2013年3月6日]</span><a href="remind.html">系统操作规范</a></li>
                <li><span>[2013年3月6日]</span><a href="remind.html">大修业务流程查阅</a></li>
                <li><span>[2013年3月6日]</span><a href="remind.html">巡检制度查阅</a></li>
                <li><span>[2013年3月6日]</span><a href="remind.html">更新改造查阅</a></li>
                <li><span>[2013年3月6日]</span><a href="remind.html">住宅专项制度查阅</a></li>
                <li><span>[2013年3月6日]</span><a href="remind.html">系统操作手册下载</a></li>

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
                <td align="center">详细</td>
            </tr>
            <c:forEach items="${myApplyList}" var="item">
                <tr>
                    <td height="24" align="center">1</td>
                    <td align="center">${item.user.name}</td>
                    <td align="center">${item.id}</td>
                    <td align="center">${item.id}</td>
                    <td align="center">${item.id}</td>
                    <td align="center">${item.id}</td>
                </tr>
            </c:forEach>
            <tr>
                <td height="24" align="center">2</td>
                <td align="center">单据名称</td>
                <td align="center">类型</td>
                <td align="center">2013年4月25日</td>
                <td align="center">未批准</td>
                <td align="center"><a href="jsp/dev/store/applyinfo.html"></a> 详细</td>
            </tr>
            <tr>
                <td height="24" align="center">3</td>
                <td align="center">名称</td>
                <td align="center">类型</td>
                <td align="center">2013年4月23日</td>
                <td align="center">未审批</td>
                <td align="center"><a href="jsp/dev/store/applyinfo.html"></a> 详细</td>
            </tr>
            <tr>
                <td height="24" align="center">4</td>
                <td align="center">单据名称</td>
                <td align="center">类型</td>
                <td align="center">2013年4月16日</td>
                <td align="center">已批准</td>
                <td align="center"><a href="jsp/dev/store/applyinfo.html"></a> 详细</td>
            </tr>
        </table>


    </div>
    <div class="indexNotice">
        <h3><a href="javascript:void(0)">更多>></a><span>待审批单据</span></h3>
        <table width="100%" border="0" cellspacing="0" style="border-color:#eeefff">
            <tr class="title">
                <td width="8%" height="24" align="center">序号</td>
                <td width="32%" align="center">单据名称</td>
                <td width="20%" align="center">单据类型</td>
                <td width="20%" align="center">提交日期</td>
                <td align="center">详细</td>
            </tr>
            <c:forEach items="${pendingApplyList}" var="item">
                <tr>
                    <td height="24" align="center">1</td>
                    <td align="center">${item.user.name}</td>
                    <td align="center">${item.id}</td>
                    <td align="center">${item.id}</td>
                    <td align="center">${item.id}</td>

                </tr>
            </c:forEach>




            <tr>
                <td height="24" align="center">1</td>
                <td align="center">设备报增单</td>
                <td align="center">设备管理</td>
                <td align="center">2013年5月7日</td>
                <td align="center"><a href="jsp/dev/store/examapply.html"></a> 详细</td>
            </tr>
            <tr>
                <td height="24" align="center">2</td>
                <td align="center">单据名称</td>
                <td align="center">类型</td>
                <td align="center">2013年4月26日</td>
                <td align="center"><a href="jsp/dev/store/examapply.html"></a> 详细</td>
            </tr>
            <tr>
                <td height="24" align="center">3</td>
                <td align="center">名称</td>
                <td align="center">类型</td>
                <td align="center">2013年4月24日</td>
                <td align="center"><a href="jsp/dev/store/examapply.html"></a> 详细</td>
            </tr>
            <tr>
                <td height="24" align="center">4</td>
                <td align="center">单据名称</td>
                <td align="center">类型</td>
                <td align="center">2013年4月17日</td>
                <td align="center"><a href="jsp/dev/store/examapply.html"></a> 详细</td>
            </tr>
        </table>

    </div>
</div>
</body>
</html>
