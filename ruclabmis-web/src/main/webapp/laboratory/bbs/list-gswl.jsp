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
        <div style="left:0px; top:0px; z-index:99px;">
            <img src="images/default/banner_mole_left.jpg" style="margin-left:0px;"/>
        </div>
    </div>
</DIV>
<!--      用户信息、登录、注册        -->

<DIV class="h">
    您尚未　<a href="">登录</a>
    &nbsp;| &nbsp; <A href="">注册</A> |
</DIV>


<!--      主体        -->
<DIV>
    <!--      导航        -->
    <br/>

    <DIV>
        &gt;&gt;<B><a href="index">论坛首页</a></B>&gt;&gt;
        <B><a href="list">高速网络实验课</a></B>
    </DIV>
    <br/>
    <!--      新帖        -->
    <DIV>
        <A href="post"><IMG src="images/post.gif" name="td_post" border="0" id=td_post></A>
    </DIV>
    <!--         翻 页         -->
    <DIV>
        <a href="list">上一页</a>|
        <a href="list">下一页</a>
    </DIV>

    <DIV class="t">
        <TABLE cellSpacing="0" cellPadding="0" width="100%">
            <TR>
                <TH class="h" style="WIDTH: 100%" colSpan="4"><SPAN>&nbsp;</SPAN></TH>
            </TR>
            <!--       表 头           -->
            <TR class="tr2">
                <TD>&nbsp;</TD>
                <TD style="WIDTH: 80%" align="center">文章</TD>
                <TD style="WIDTH: 10%" align="center">作者</TD>
                <TD style="WIDTH: 10%" align="center">回复</TD>
            </TR>
            <!--         主 题 列 表        -->

            <TR class="tr3">
                <TD><IMG src="images/topic.gif" border=0></TD>
                <TD style="FONT-SIZE: 15px">
                    <A href="detail">灌水</A>
                </TD>
                <TD align="center">t</TD>
                <TD align="center">2</TD>
            </TR>

            <TR class="tr3">
                <TD><IMG src="images/topic.gif" border=0></TD>
                <TD style="FONT-SIZE: 15px">
                    <A href="detail">哈哈</A>
                </TD>
                <TD align="center">abc</TD>
                <TD align="center">1</TD>
            </TR>

            <TR class="tr3">
                <TD><IMG src="images/topic.gif" border=0></TD>
                <TD style="FONT-SIZE: 15px">
                    <A href="detail">发水了</A>
                </TD>
                <TD align="center">abc</TD>
                <TD align="center">0</TD>
            </TR>

            <TR class="tr3">
                <TD><IMG src="images/topic.gif" border=0></TD>
                <TD style="FONT-SIZE: 15px">
                    <A href="detail">发水</A>
                </TD>
                <TD align="center">abc</TD>
                <TD align="center">0</TD>
            </TR>

            <TR class="tr3">
                <TD><IMG src="images/topic.gif" border=0></TD>
                <TD style="FONT-SIZE: 15px">
                    <A href="detail">笑话5则</A>
                </TD>
                <TD align="center">abc</TD>
                <TD align="center">0</TD>
            </TR>

            <TR class="tr3">
                <TD><IMG src="images/topic.gif" border=0></TD>
                <TD style="FONT-SIZE: 15px">
                    <A href="detail">最新大片</A>
                </TD>
                <TD align="center">abc</TD>
                <TD align="center">0</TD>
            </TR>

            <TR class="tr3">
                <TD><IMG src="images/topic.gif" border=0></TD>
                <TD style="FONT-SIZE: 15px">
                    <A href="detail">纯净水</A>
                </TD>
                <TD align="center">abc</TD>
                <TD align="center">0</TD>
            </TR>

            <TR class="tr3">
                <TD><IMG src="images/topic.gif" border=0></TD>
                <TD style="FONT-SIZE: 15px">
                    <A href="detail">这边风景好</A>
                </TD>
                <TD align="center">abc</TD>
                <TD align="center">0</TD>
            </TR>

        </TABLE>
    </DIV>
    <!--            翻 页          -->
    <DIV>
        <a href="list">上一页</a>|
        <a href="list">下一页</a>
    </DIV>
</DIV>
<!--             声 明          -->

</BODY>
</HTML>
