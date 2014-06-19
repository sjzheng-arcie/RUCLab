<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <TITLE>实验交流论坛--回复</TITLE>
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
        function save() {
            if (!validator(document.updateForm)) {
                return;
            }

            document.updateForm.action = "updateReply";
            document.updateForm.submit();
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
        <FORM name="updateForm"  action="post" method="POST">
            <INPUT type="hidden" name="replyId" value="${bbsReply.id}"/>
            <INPUT type="hidden" name="sessionId" value="${sessionId}"/>
            <DIV class="t">
                <TABLE cellSpacing="0" cellPadding="0" align="center">
                    <TR>
                        <TD class="h" colSpan="3"><B>修改回复</B></TD>
                    </TR>
                    <TR class="tr3">
                        <TH width="20%"><B>标题</B></TH>
                        <TH><INPUT class="input" style="PADDING-LEFT: 2px; FONT: 14px Tahoma" tabIndex="1" size="60"
                                   name="title" value = "${bbsReply.title}" valid="required"
                                   errmsg="标题不能为空!" > </TH>
                    </TR>
                    <TR class="tr3">
                        <TH vAlign=top>
                            <DIV><B>内容</B></DIV>
                        </TH>
                        <TH colSpan=2>
                            <div id="innerId">
                                                <span>
                                                    <textarea id="content" style="WIDTH: 500px; height: 300px"
                                                                name="content" rows="20" cols="90"
                                                                tabIndex="2" valid="required"
                                                                errmsg="帖子内容不能为空!">${bbsReply.content}</textarea></span>
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
                <INPUT class="btn" tabIndex="3" type="submit" value="提 交" onclick="save();">
                <INPUT class="btn" tabIndex="4" type="reset" value="重 置" onclick="reset();">
                <input type="button" name="return" value="返回" class="btn"
                       onclick="window.history.go(-1);"/>
            </DIV>
        </FORM>
    </DIV>
</DIV>
</BODY>
</HTML>
