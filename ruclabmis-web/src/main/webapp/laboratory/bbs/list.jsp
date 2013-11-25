<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <TITLE>实验交流论坛--帖子列表</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=UTF-8">
    <Link rel="stylesheet" type="text/css" href="style/style.css"/>
</HEAD>
<BODY>
<DIV>
    <div id="banner" style="background-image:url('images/default/banner_mole_bg.jpg');border:0;position:relative;">
        <div style="left:0px ; top:0px; z-index:99px;">
            <img src="images/default/banner_mole_left.jpg" style="margin-left:0px;"/>
        </div>
    </div>
</DIV>
<DIV class="h">
    <p style="font-size: 26px;margin-top: 0px;margin-bottom: 0px">
        &gt;&gt;<B><a href="frame">论坛首页</a></B>&gt;&gt;
        <B><a href="list?courseId=${courseId}">C语言实验课</a></B>
        <span style="float:right">
            <A href="post?courseId=${courseId}"><IMG src="images/post.gif" name="td_post" border="0" id=td_post></A>
        </span>
    </p>
</DIV>
<DIV>
    <%@ include file="../jsp/common/toppagetable.jsp" %>
    <DIV class="t">

        <TABLE cellSpacing="0" cellPadding="0" width="100%">

            <TR class="tr2">
                <TD>&nbsp;</TD>
                <TD style="WIDTH: 80%" align="center">标题</TD>
                <TD style="WIDTH: 10%" align="center">作者</TD>
                <TD style="WIDTH: 10%" align="center">回复</TD>
            </TR>
            <TR class="tr3">
                <TD><IMG src="images/topic.gif" border=0></TD>
                <TD style="FONT-SIZE: 15px">
                    <A href="detail">C语言实验课开课了</A>
                </TD>
                <TD align="center">t</TD>
                <TD align="center">2</TD>
            </TR>
            <c:forEach items="${pageInfo.data}" var="item">
                <TR class="tr3">
                    <TD><IMG src="images/topic.gif" border=0></TD>
                    <TD style="FONT-SIZE: 15px">
                        <A href="detail?postId=${item.id}">${item.title}</A>
                    </TD>
                    <TD align="center">${item.publisher.name}</TD>
                    <TD align="center">${item.replyNum}</TD>
                </TR>
            </c:forEach>
        </TABLE>
    </DIV>
    <%@ include file="../jsp/common/toppagetable.jsp" %>
</DIV>
</BODY>
</HTML>
