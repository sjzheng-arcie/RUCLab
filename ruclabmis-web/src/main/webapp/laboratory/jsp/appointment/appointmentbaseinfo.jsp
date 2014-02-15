<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>
<script>
    function seekStatus()
    {
        var getStr =  "/laboratory/jsp/appointment/roomstatus?";
        getStr +=  "year=" + document.getElementById('year').value;
        getStr +=  "&week=" + document.getElementById('week').value;
        getStr +=  "&wDay=" +document.getElementById('day').value;
        getStr +=  "&section=" +document.getElementById('section').value;

        parent.statusFrame.location = getStr;
    }
</script>
<body>
<form name="mainForm" method="post">
    <table style="width:100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif">
                <img src="../../../../images/left-top-right.gif" width="17" height="29"/>
            </td>
            <td valign="top" background="../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="positionbt">预约申请信息</div>
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
                <table  border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr valign="top">
                        <td>
                            <table  style="width:100%;height:370px"  border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                                <tr bgcolor="#FFFFFF">
                                    <td bgcolor="#FFFFFF">
                                        <table border="0" cellpadding="2" cellspacing="1"
                                               style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#E3E9EE">
                                            <input name="id" id="id" type="hidden" value="${major.id}">
                                            <tr>
                                                <td  width="100" align="right" >学期学年：</td>
                                                <td  width="300" >
                                                    <select id="year" name="year"
                                                            style="width: 180px;height: 22px"
                                                            data-placeholder="选择学年学期...">
                                                        <c:forEach items="${years}" var="var">
                                                            <c:if test="${var.year >= currYear}">
                                                                <option value="${var.id}">${var.name}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="100"  align="right" >第几周：</td>
                                                <td width="100">
                                                    <select id="week" name="week" style="width: 180px;height: 22px">
                                                        <c:forEach begin="0" end ="22" var="i">
                                                            <option value="${i}" <c:if test="${i==currWeek}"> selected</c:if>>${i}</option>
                                                        </c:forEach>
                                                    </select></td>
                                            </tr>

                                            <tr>
                                                <td  width="100"  align="right" >星期：</td>
                                                <td width="100">
                                                    <select id="day" name="day" style="width: 180px;height: 22px">
                                                        <option value="1"<c:if test="${2==currDay}"> selected</c:if>>星期一</option>
                                                        <option value="2"<c:if test="${3==currDay}"> selected</c:if>>星期二</option>
                                                        <option value="3"<c:if test="${4==currDay}"> selected</c:if>>星期三</option>
                                                        <option value="4"<c:if test="${5==currDay}"> selected</c:if>>星期四</option>
                                                        <option value="5"<c:if test="${6==currDay}"> selected</c:if>>星期五</option>
                                                        <option value="6"<c:if test="${7==currDay}"> selected</c:if>>星期六</option>
                                                        <option value="7"<c:if test="${1==currDay}"> selected</c:if>>星期日</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td  align="right"  width="100">时间段：</td>
                                                <td width="100">
                                                    <select id="section" name="section" style="width: 180px;height: 22px">
                                                        <option value="1">上午一二节</option>
                                                        <option value="2">上午三四节</option>
                                                        <option value="3">下午五六节</option>
                                                        <option value="4">下午七八节</option>
                                                        <option value="5">晚上九十节</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="right"  align="right" >申请类型：</td>
                                                <td><select name="type" id="type" style="width: 180px;height: 22px">
                                                    <option value= "0">实验室</option>
                                                    <option value= "1">会议室</option>
                                                    <option>工位</option>
                                                </select></td>
                                            </tr>

                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td colspan="4" align="center" >
                                        <a href="#" onclick="seekStatus()">
                                            <img src="../../../images/back.gif" width="20" height="15" border="0"/>
                                            <span class="txt_bt">查看房间占用</span>
                                        </a>
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
