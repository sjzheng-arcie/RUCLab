<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <TITLE>实验交流论坛--发布帖子</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=UTF-8">
    <Link rel="stylesheet" type="text/css" href="style/style.css"/>
    <script src="../../../../js/valid.js" type=text/javascript></script>
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
        <div style="left:0px; top:0px; z-index:99px;"><img src="images/default/banner_mole_left.jpg" style="margin-left:0px;"/></div>
        </div>
</DIV>
<DIV>
    <DIV>
        <FORM name="postForm" onsubmit="return check()" action="manage/doPost.jsp" method="POST">
            <INPUT type="hidden" name="courseId" value="${courseId}"/>
            <DIV class="t">
                <TABLE cellSpacing="0" cellPadding="0" align="center">
                    <TR>
                        <TD class="h" colSpan="3"><B>发布帖子</B></TD>
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
                            <div id="innerId">
                                                <span><textarea id="content" style="WIDTH: 500px; height: 300px"
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
                </TABLE>
            </DIV>
            <DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
                <INPUT class="btn" tabIndex="3" type="submit" value="提 交">
                <INPUT class="btn" tabIndex="4" type="reset" value="重 置">
            </DIV>
        </FORM>
    </DIV>
</DIV>
</BODY>
</HTML>
