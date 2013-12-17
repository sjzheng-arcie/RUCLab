<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
<link href="../../../../js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>

<script src="../../../../js/valid.js" type=text/javascript></script>
<script type="text/javascript" src="../../../../js/autocomplete/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../../../../js/chosen/chosen.jquery.min.js"></script>

<script>
    function save() {
        if (!validator(document.mainForm)) {
            return;
        }
        document.mainForm.action = "add";
        document.mainForm.submit();
    }

    $(document).ready(function () {
        $("#teacherId").chosen({
            no_results_text: "没有找到"
        });
    });
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
                            <div class="titlebt">系统管理 > 课程信息管理</div>
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
                                                                    class="STYLE1">课程信息添加</span></td>
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
                                            <tr>
                                                <td nowrap align="right">课程名称:</td>
                                                <td nowrap>
                                                    <input name="name" id="name" value="" onblur="" class="text"
                                                           style="width:154px" maxlength="20"
                                                           valid="required"
                                                           errmsg="课程名称不能为空!"/>
                                                    <span style="color:red;">*</span>
                                                </td>
                                                <td nowrap align="right">任课教师:</td>
                                                <td nowrap>
                                                    <select id="teacherId" name="teacherId"
                                                            style="width: 252px;height: 22px"
                                                            data-placeholder="选择教师...">
                                                        <c:forEach items="${teacherList}" var="teacher">
                                                        <option value="${teacher.id}">${teacher.name}(${teacher.sn})</option>
                                                        </c:forEach>
                                                    </select>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">专业：</td>
                                                <td nowrap align="left">
                                                    <select name="majorId" id="majorId">
                                                        <c:forEach items="${majors}" var="item">
                                                            <option value="${item.id}">${item.name}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                <td nowrap align="right">考查方式:</td>
                                                <td nowrap>
                                                    <select name="examType" id="examType">
                                                        <option value="82" selected>考试</option>
                                                        <option value="81">考查</option>
                                                    </select>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">课程学时:</td>
                                                <td nowrap>
                                                    <input name="period" id="period" value="" onblur=""
                                                           class="text"
                                                           style="width:154px" maxlength="20"
                                                           valid="required|isNumber"
                                                           errmsg="课程学时不能为空!|课程学时只能为数字"/>
                                                    <span style="color:red;">*</span>
                                                </td>
                                                <td nowrap align="right">课程学分:</td>
                                                <td nowrap>
                                                    <input name="score" id="score" class="text"
                                                           style="width:154px"
                                                           valid="required|isNumber"
                                                           errmsg="课程学分不能为空!|课程学分只能为数字"/>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">课程简介：</td>
                                                <td nowrap align="left">
                                                    <textarea name="profile" id="profile"></textarea>
                                                </td>
                                                <td nowrap align="right">备注：</td>
                                                <td nowrap align="left">
                                                    <textarea name="comments" id="comments"></textarea>
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