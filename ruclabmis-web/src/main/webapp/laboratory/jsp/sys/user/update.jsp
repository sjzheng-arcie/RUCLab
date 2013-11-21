<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script src="../../../../js/valid.js" type=text/javascript></script>
    <script>
        function update() {
            if(!validator(document.mainForm)){
                return;
            }

            document.mainForm.action = "update";
            document.mainForm.submit();
        }
    </script>
</head>
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
                            <div class="titlebt">系统管理 > 用户管理</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="../../../../images/mail_rightbg.gif">
                <img src="../../../../images/nav-right-bg.gif" width="16" height="29"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" background="../../../../images/mail_leftbg.gif">&nbsp;</td>
            <td valign="top" bgcolor="#F7F8F9">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="30">
                            <table width="100%" border="" cellspacing="0" cellpadding="0">
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
                                                                    class="STYLE1">修改用户</span></td>
                                                        </tr>
                                                    </table>
                                                </td>
                                                <td>
                                                    <div align="right"><span class="STYLE1">&nbsp;</span><span
                                                            class="STYLE1"> &nbsp;</span></div>
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
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#a8c7ce">
                                <tr bgcolor="#FFFFFF">
                                    <td bgcolor="#FFFFFF">
                                        <table border="0" cellpadding="2" cellspacing="1"
                                               style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#E3E9EE">
                                            <input name="id" id="id" type="hidden" value="${user.id}">
                                            <tr>
                                                <td nowrap align="right">用户账号:</td>
                                                <td nowrap>
                                                    <input name="sn" id="sn" class="text" style="width:154px"
                                                           maxlength="20"
                                                           valid="required|isAccount"
                                                           errmsg="用户账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位"
                                                           value="${user.sn}"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                </td>
                                                <td nowrap align="right">用户名:</td>
                                                <td nowrap>
                                                    <input name="name" id="name" class="text" style="width:154px"
                                                           maxlength="20"
                                                           valid="required|isEnglishChinese"
                                                           errmsg="用户名不能为空!|用户名只能为中英文字符"
                                                           value="${user.name}"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">邮箱：</td>
                                                <td nowrap align="left">
                                                    <input name="email" id="email" type="text"
                                                           valid="isEmail"
                                                           errmsg="邮箱格式不正确!"
                                                           value="${user.email}">
                                                </td>
                                                <td nowrap align="right">电话：</td>
                                                <td nowrap align="left">
                                                    <input name="phoneNum" id="phoneNum" type="text"
                                                           value="${user.phoneNum}">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">用户角色:</td>
                                                <td nowrap>
                                                    <select name="roleId" id="roleId">
                                                        <c:forEach items="${roles}" var="item">
                                                            <option value="${item.id}"
                                                                    <c:if test="${item.id == user.roleId}"> selected</c:if>>${item.name}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                <td nowrap align="right">所属专业：</td>
                                                <td nowrap align="left">
                                                    <select name="majorId" id="majorId">
                                                        <c:forEach items="${majors}" var="item">
                                                            <option value="${item.id}"
                                                                    <c:if test="${item.id == user.majorId}"> selected</c:if>>${item.name}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">备注：</td>
                                                <td nowrap align="left">
                                                    <textarea name="comment" id=comment>${user.comment}</textarea>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="center">
                                        <input type="button" name="save" value="保存" class="button" onclick="update();"/>
                                        <input type="reset" name="reset" value="重置" class="button"/>
                                        <input type="button" name="return" value="返回" class="button"
                                               onclick="window.history.go(-1);"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td background="../../../../images/mail_rightbg.gif">&nbsp;</td>
        </tr>
        <tr>
            <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img src="../../../../images/buttom_left2.gif"
                                                                                  width="17" height="17"/></td>
            <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img src="../../../../images/buttom_bgs.gif"
                                                                                 width="100%" height="17"></td>
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
    <input type="hidden" name="us_sreplyby" value=""/>
</form>
</body>
