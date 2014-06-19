<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>
<script>
    window.UEDITOR_HOME_URL = "/js/ueditor/";

    function save() {
        document.mainForm.action = "update";
        document.mainForm.submit();
    }

</script>
<body>
<form name="mainForm" method="post">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif">
                <img src="../../../../images/left-top-right.gif" width="17" height="29"/>
            </td>
            <td valign="top" background="../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">教学资源管理 > 考试题管理</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="../../../../images/mail_rightbg.gif">
                <img src="../../../../images/nav-right-bg.gif" width="16" height="29"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" background="../../../../images/mail_leftbg.gif"></td>
            <td valign="top" bgcolor="#F7F8F9">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="30">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td height="24" bgcolor="#353c44">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td>
                                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                        <tr>
                                                            <td width="6%" height="19" valign="bottom">
                                                                <div align="center"><img src="../../../../images/tb.gif"
                                                                                         width="14" height="14"/></div>
                                                            </td>
                                                            <td width="94%" valign="bottom"><span
                                                                    class="STYLE1">考试题修改</span></td>
                                                        </tr>
                                                    </table>
                                                </td>
                                                <td>
                                                    <div align="right"><span class="STYLE1"></span><span
                                                            class="STYLE1"> </span></div>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr valign="top">
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                                <tr bgcolor="#FFFFFF">
                                    <td bgcolor="#FFFFFF">
                                        <table border="0" cellpadding="2" cellspacing="1"
                                               style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#E3E9EE">
                                            <input name="id" id="id" type="hidden" value="${examItemPool.id}">
                                            <tr>
                                                <td  nowrap align="right" >考试题名称:</td>
                                                <td >
                                                    <input name="name" id="name" value="${examItemPool.name}" onblur="" class="text"
                                                           style="width:300px"/>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td  nowrap align="right">考试题难度:</td>
                                                <td  >
                                                    <select id="difficulty" name="difficulty" style="width: 80px">
                                                        <option value="1" <c:if test="${examItemPool.difficulty == 1}">selected</c:if> >难</option>
                                                        <option value="2" <c:if test="${examItemPool.difficulty == 2}">selected</c:if> >中</option>
                                                        <option value="3" <c:if test="${examItemPool.difficulty == 3}">selected</c:if> >易</option>
                                                    </select>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td  nowrap align="right">考试题类型:</td>
                                                <td  >
                                                    <select id="itemType" name="itemType" style="width: 80px">
                                                        <option value="1" <c:if test="${examItemPool.itemType == 1}">selected</c:if> >单选</option>
                                                        <option value="2" <c:if test="${examItemPool.itemType == 2}">selected</c:if> >多选</option>
                                                        <option value="3" <c:if test="${examItemPool.itemType == 3}">selected</c:if> >判断</option>
                                                        <option value="4" <c:if test="${examItemPool.itemType == 4}">selected</c:if> >填空</option>
                                                        <option value="5" <c:if test="${examItemPool.itemType == 5}">selected</c:if> >简答</option>
                                                    </select>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">考试题内容:</td>
                                                <td  align="left" colspan="3">
                                                    <div id="innerId">
                                                        <span>
                                                            <textarea id= "substance" name="substance"
                                                                      style="WIDTH: 90%; height: 100px"
                                                                      rows="20" cols="90">${examItemPool.substance}</textarea>
                                                        </span>
                                                        <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.config.js"></script>
                                                        <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.all.js"></script>
                                                        <link type="text/css" href="${pageContext.request.contextPath}/js/ueditor/themes/default/css/ueditor.css"/>
                                                        <script type="text/javascript" charset="utf-8">
                                                            var editor = new baidu.editor.ui.Editor();
                                                            editor.render('substance');
                                                        </script>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">考试题答案:</td>
                                                <td  align="left" colspan="3">
                                                    <div>
                                                        <span>
                                                            <textarea id= "answer" name="answer"
                                                                      style="WIDTH: 95%; height: 80px"
                                                                      rows="20" cols="90">${examItemPool.answer}</textarea>
                                                        </span>
                                                    </div>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="center">
                                        <input type="button" name="Submit" value="保存" class="button" onclick="save();"/>
                                        <input type="reset" name="reset" value="重置" class="button"
                                               onclick="reset();"/>
                                        <input type="button" name="return" value="返回" class="button"
                                               onclick="window.history.go(-1);"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td background="../../../../images/mail_rightbg.gif"></td>
        </tr>
        <tr>
            <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/buttom_left2.gif"
                    width="17" height="17"/></td>
            <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img
                    src="../../../../images/buttom_bgs.gif"
                    width="100%" height="17"></td>
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>

</form>
</body>
