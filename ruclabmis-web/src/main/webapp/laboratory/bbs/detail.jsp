<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<HTML>
<HEAD>
    <TITLE>实验交流论坛--看贴</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=UTF-8">
    <Link rel="stylesheet" type="text/css" href="style/style.css"/>
    <script>
        function reply(){
            document.mainForm.action="reply";
            document.mainForm.submit();
        }
    </script>

</HEAD>

<BODY>
<form name="mainForm" method="post">
<DIV>
    <div id="banner" style="background-image:url('images/default/banner_mole_bg.jpg');border:0;position:relative;">
        <div style=" left:0px; top:0px; z-index:99px;"><img src="images/default/banner_mole_left.jpg" style="margin-left:0px;"/>
        </div>
    </div>
</DIV>
    <DIV>
    <DIV class="h" >
        <p style="font-size: 26px;margin-top: 0px;margin-bottom: 0px">&gt;&gt;<B><a href="frame">论坛首页</a></B>&gt;&gt;<B>
            <a href="list?courseId=${courseId}">${post.course.name}</a></B>
            <span style="float:right">
                <A href="post?courseId=${courseId}"><IMG src="images/post.gif" border="0" id=td_post></A>
                <A href="upTop?postId=${postId}"><IMG src="images/uptop.gif" border="0" id=td_uptop></A>
                <A href="delete?postId=${postId}"><IMG src="images/del.gif" border="0" id=td_del></A>
            </span>
        </p>
    </DIV>
    <DIV>
        <TABLE cellSpacing="0" cellPadding="0" width="100%">
            <%@ include file="../jsp/common/toppagetable.jsp" %>
            <TR class="tr2">
                <TD>
                    <a href="detail">上一页</a>|<a href="detail">下一页</a>
                </TD>
            </TR>
            <TR>
                <TH class="h">${post.title}</TH>
            </TR>

        </TABLE>
    </DIV>
    <DIV class="t">
        <TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed" cellSpacing="0" cellPadding="0" width="100%">
            <TR class="tr1">
                <TH style="WIDTH: 20%">
                    <B>t</B><BR/>
                    <img src="images/head/2.gif"/><BR/>
                    注册:2007-07-27<BR/>
                </TH>
                <TH>
                    <H4>鼓掌啊，终于 开通了</H4>
                    <DIV>rt</DIV>
                    <DIV class="tipad gray">
                        发表：[2007-07-30 08:37] &nbsp;
                        最后修改:[2007-07-30 08:37]
                    </DIV>
                </TH>
            </TR>
            <c:forEach items="${replyList}" var="item">
                <TR class="tr1">
                    <TH style="WIDTH: 20%">
                        <B>${item.name}</B><BR/>
                        <img src="${item.portrait}"/><BR/>
                        ${item.registTime}<BR/>
                    </TH>
                    <TH>
                        <H4>${item.replyContent}</H4>
                        <DIV>rt</DIV>
                        <DIV class="tipad gray">
                            发表：[${item.replyTime}] &nbsp;
                            最后修改:[${item.lastUpdateTime}]
                        </DIV>
                    </TH>
                </TR>

            </c:forEach>
        </TABLE>
    </DIV>
    <DIV>
        <TABLE cellSpacing="0" cellPadding="0" width="100%">
            <TR class="tr2">
                <TD>
                    <a href="detail">上一页</a>|<a href="detail">下一页</a>
                </TD>
            </TR>
            <%@ include file="../jsp/common/toppagetable.jsp" %>
        </TABLE>
    </DIV>
</DIV>
<DIV>
        <INPUT type="hidden" name="boardId" value="4"/>
        <INPUT type="hidden" name="topicId" value=""/>

        <DIV class="t">
            <TABLE cellSpacing="0" cellPadding="0" align="center">
                <TR>
                    <TD class="h" colSpan="3"><B>回复</B></TD>
                </TR>
                <TR class="tr3">
                    <TH vAlign=top>
                        <DIV><B>内容</B></DIV>
                    </TH>
                    <TH colSpan=2>
                        <div id="innerId">
                                                <span><textarea id="content" style="WIDTH: 90%; height: 300px"
                                                                name="content" rows="20" cols="90"
                                                                tabIndex="2"></textarea></span>
                            <script type="text/javascript"
                                    src="../../js/ueditor/ueditor.config.js"></script>

                            <script type="text/javascript"
                                    src="../../js/ueditor/ueditor.all.js"></script>

                            <link type="text/css"
                                  href="../../js/ueditor/themes/default/css/ueditor.css"/>

                            <script type="text/javascript" charset="utf-8">
                                var editor = new baidu.editor.ui.Editor();
                                editor.render('content');
                            </script>
                        </div>
                    </TH>
                </TR>
                <TR class="tr3">
                    <TH vAlign=top>

                    </TH>
                    <TH colSpan=2>
                        <DIV style="MARGIN: 15px 0px; TEXT-ALIGN: left">
                            <INPUT class="btn" name="replySubmit"tabIndex="3" type="button" onclick="reply()" value="回 复">
                            <INPUT class="btn" tabIndex="4" type="reset" value="重 置">
                        </DIV>
                    </TH>
                </TR>

            </TABLE>
        </DIV>

</DIV>
</form>
</BODY>
</HTML>
