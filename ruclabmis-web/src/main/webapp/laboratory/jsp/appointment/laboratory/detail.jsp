<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>

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
                            <div class="titlebt">预约申请</div>
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
                                                                    class="STYLE1">预约详细信息</span></td>
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
                                                <td  width="100" align="right" >预约日期：</td>
                                                <td>
                                                    <input name="meetDate" id="meetDate"
                                                           value="<fmt:formatDate value="${arrangement.meetSTime}" pattern="yyyy-MM-dd"/>" onblur=""
                                                           class="text" readonly style="width:154px;color:#aaaaaa"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="100"  align="right" >预约时间段：</td>
                                                <td width="100">
                                                    <input name="stime" id="stime" value="<fmt:formatDate value="${arrangement.meetSTime}" pattern="HH:mm"/>" onblur=""
                                                           class="text" readonly style="width:80px;color:#aaaaaa"/> -
                                                    <input name="etime" id="etime" value="<fmt:formatDate value="${arrangement.meetETime}" pattern="HH:mm"/>" onblur=""
                                                                        class="text" readonly style="width:80px;color:#aaaaaa"/>
                                                </td>
                                            <tr>
                                                <td nowrap align="right">预约房间:</td>
                                                <td nowrap>
                                                    <input name="roomName" id="roomName" value="${arrangement.room.getName()}" onblur=""
                                                           class="text" readonly style="width:154px;color:#aaaaaa"/>
                                                </td>
                                                <td nowrap align="right">申请人:</td>
                                                <td nowrap>
                                                    <input name="user" id="user" value="${arrangement.user.getName()}" onblur=""
                                                           class="text" readonly style="width:154px;color:#aaaaaa"/>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="100"  align="right" >预约类型：</td>
                                                <td >
                                                    <input name="type" id="type" value="${arrangement.type}" onblur=""
                                                           class="text" readonly style="width:154px;color:#aaaaaa"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="right"  align="right">申请内容描述：</td>
                                                <td  colspan="4">
                                                    <textarea name="description" id="description"
                                                              cols="60" rows="10"
                                                              style="width: 90%;height: 350">${arrangement.description}</textarea>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="center">
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
