<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
    <TITLE>实验交流论坛--发布帖子</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=gbk">
    <Link rel="stylesheet" type="text/css" href="style/style.css"/>
    <script type="text/javascript">
        function check() {
            if (document.postForm.title.value == "") {
                alert("标题不能为空");
                return false;
            }
            if (document.postForm.content.value == "") {
                alert("内容不能为空");
                return false;
            }
            if (document.postForm.content.value.length > 1000) {
                alert("长度不能大于1000");
                return false;
            }
        }
    </script>
</HEAD>

<BODY>
<DIV>
    <div id="banner" style="background-image:url('images/default/banner_mole_bg.jpg');border:0;position:relative;">
        <div left:0px
        ; top:0px; z-index:99px;"><img src="images/default/banner_mole_left.jpg" style="margin-left:0px;"/></div>
</DIV>
<!--      用户信息、登录、注册        -->

<DIV class="h">
    您尚未　<a href="login.jsp">登录</a>
    &nbsp;| &nbsp; <A href="reg.jsp">注册</A> |
</DIV>


<!--      主体        -->
<DIV><BR/>
    <!--      导航        -->
    <DIV>
        &gt;&gt;<B><a href="index.html">论坛首页</a></B>&gt;&gt;
        <B><a href="list.html">C语言</a></B>
    </DIV>
    <BR/>

    <DIV>
        <FORM name="postForm" onsubmit="return check()" action="manage/doPost.jsp" method="POST">
            <INPUT type="hidden" name="boardId" value="4"/>
            <INPUT type="hidden" name="topicId" value=""/>

            <DIV class="t">
                <TABLE cellSpacing="0" cellPadding="0" align="center">
                    <TR>
                        <TD class="h" colSpan="3"><B>发表帖子</B></TD>
                    </TR>

                    <TR class="tr3">
                        <TH width="20%"><B>标题</B></TH>
                        <TH><INPUT class="input" style="PADDING-LEFT: 2px; FONT: 14px Tahoma" tabIndex="1" size="60"
                                   name="title"></TH>
                    </TR>

                    <TR class="tr3">
                        <TH vAlign=top>
                            <DIV><B>内容</B></DIV>
                        </TH>
                        <TH colSpan=2>
                            <DIV>
                                <span><textarea style="WIDTH: 500px;" name="content" rows="20" cols="90"
                                                tabIndex="2"></textarea></span>
                            </DIV>
                            (不能大于:<FONT color="blue">1000</FONT>字)
                        </TH>
                    </TR>
                </TABLE>
            </DIV>

            <DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
                <INPUT class="btn" tabIndex="3" type="submit" value="提 交">
                <INPUT class="btn" tabIndex="4" type="reset" value="重 置">
            </DIV>
        </FORM>
    </DIV>
</DIV>
<!--      声明        -->
</BODY>
</HTML>
