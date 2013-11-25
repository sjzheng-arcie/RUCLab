<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script src="../../../../js/valid.js" type=text/javascript></script>
    <script>
        function save() {
            document.form1.action = "/add";
            document.form1.submit();
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
                            <div class="titlebt">资源管理 > 试题管理</div>
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
                                                                    class="STYLE1">添加题目资源</span></td>
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
                            <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                                <tr bgcolor="#FFFFFF">
                                    <td bgcolor="#FFFFFF">
                                        <table border="0" cellpadding="2" cellspacing="1"
                                               style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#E3E9EE">
                                            <tr>
                                                <td nowrap align="right">题目名字:</td>
                                                <td nowrap>
                                                    <input name="questionName" class="text" style="width:154px"
                                                           maxlength="20"
                                                           valid="required|isAccount"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_us_sno"></span>
                                                </td>

                                            </tr>
                                            <tr>

                                                <td nowrap align="right">所属科目:</td>
                                                <td nowrap>
                                                    <input name="theCourse" onblur="" class="text" style="width:154px"
                                                           maxlength="20" valid="required|isAccount"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">题目类型:</td>
                                                <td nowrap>
                                                    <select name="questionType">
                                                        <option value="0"></option>
                                                        <c:forEach items="${typelist}" var="item">
                                                            <option value="${item.id}">${item.value} </option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">难易程度:</td>
                                                <td nowrap>
                                                    <select name="difficulty">
                                                        <option value="0"></option>
                                                        <c:forEach items="${difficultyList}" var="item">
                                                            <option value="${item.id}">${item.value}</option>
                                                        </c:forEach>
                                                    </select>

                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">题目内容:</td>
                                                <td nowrap>
                                                    <textarea name="questionContent" style="width: 50%;height:100px">
                                                    </textarea>
                                                    <span style="color:red;"> *</span> &nbsp;&nbsp;
                                                    <span style="color:red;"></span>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td nowrap align="right">答案:</td>
                                                <td nowrap>
                                                    <textarea name="answerContent" style="width: 50%;height:100px">
                                                    </textarea>
                                                    <span style="color:red;"> *</span> &nbsp;&nbsp;
                                                    <span style="color:red;"></span>
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
                                        <input type="reset" name="Submit3" value="重置" class="button"
                                               onclick="reset();"/>
                                        <input type="button" name="Submit2" value="返回" class="button"
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
    <input type="hidden" name="us_sreplyby" value=""/>
</form>
</body>
