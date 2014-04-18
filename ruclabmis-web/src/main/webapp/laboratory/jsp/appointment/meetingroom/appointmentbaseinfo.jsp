<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:useBean id="now" class="java.util.Date"/>
<link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>
<script src="../../../../js/DatePicker/WdatePicker.js" type=text/javascript></script>

<script>
    function seekStatus()
    {
        if (!validator(document.mainForm)) {
            return;
        }

        var arrStart = document.getElementById('stime').value.split(":");
        var arrEnd = document.getElementById('etime').value.split(":");

        if(arrStart[0] > arrEnd[0])
        {
            alert('结束时间必须大于开始时间，请检查');
            return;
        }
        else if(arrStart[0] == arrEnd[0])
        {
            if(arrStart[1] >= arrEnd[1])
            {
                alert('结束时间必须大于开始时间，请检查');
                return;
            }
        }

        var getStr =  "/laboratory/jsp/appointment/meetingroom/roomstatus?";
        getStr +=  "meetDate=" + document.getElementById('meetDate').value;
        getStr +=  "&stime=" + document.getElementById('stime').value;
        getStr +=  "&etime=" +document.getElementById('etime').value;

        parent.statusFrame.location = getStr;
    }
</script>
<body onload="seekStatus()">
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
            <td valign="top" bgcolor="#E3E9EE"  width="100%">
                <table  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#a8c7ce">
                    <tr valign="top">
                        <td>
                            <table  style="width:100%;height:370px"  border="0" cellpadding="2" cellspacing="2" bgcolor="#E3E9EE">
                                <tr bgcolor="#E3E9EE" width="100%">
                                    <td bgcolor="#E3E9EE" width="100%">
                                        <table border="0" cellpadding="10" cellspacing="10"
                                               style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#E3E9EE">
                                            <tr>
                                                <td  width="100" align="right" >预约日期：</td>
                                                <td>
                                                    <c:set var="scrapDateVal"
                                                           value="<%=new Date()%>"></c:set>
                                                    <input name="meetDate" id="meetDate"
                                                           value="<fmt:formatDate value="${scrapDateVal}" pattern="yyyy-MM-dd"/>"
                                                           onblur="" class="Mdate" style="width:154px" maxlength="10"
                                                           valid="isDate" errmsg="日期只能为：XXXX-XX-XX"
                                                           onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="100"  align="right" >预约时间段：</td>
                                                <td width="100">
                                                    <select id="stime" name="stime" style="width: 60px;height: 22px">
                                                        <option value="07:00">07:00</option>
                                                        <option value="07:30">07:30</option>
                                                        <option value="08:00">08:00</option>
                                                        <option value="08:30">08:30</option>
                                                        <option value="09:00">09:00</option>
                                                        <option value="09:30">09:30</option>
                                                        <option value="10:00">10:00</option>
                                                        <option value="10:30">10:30</option>
                                                        <option value="11:00">11:00</option>
                                                        <option value="11:30">11:30</option>
                                                        <option value="12:00">12:00</option>
                                                        <option value="12:30">12:30</option>
                                                        <option value="13:00">13:00</option>
                                                        <option value="13:30">13:30</option>
                                                        <option value="14:00">14:00</option>
                                                        <option value="14:30">14:30</option>
                                                        <option value="15:00">15:00</option>
                                                        <option value="15:30">15:30</option>
                                                        <option value="16:00">16:00</option>
                                                        <option value="16:30">16:30</option>
                                                        <option value="17:00">17:00</option>
                                                        <option value="17:30">17:30</option>
                                                        <option value="18:00">18:00</option>
                                                        <option value="18:30">18:30</option>
                                                    </select> -  <select id="etime" name="etime" style="width: 60px;height: 22px">
                                                    <option value="07:30">07:30</option>
                                                    <option value="08:00">08:00</option>
                                                    <option value="08:30">08:30</option>
                                                    <option value="09:00">09:00</option>
                                                    <option value="09:30">09:30</option>
                                                    <option value="10:00">10:00</option>
                                                    <option value="10:30">10:30</option>
                                                    <option value="11:00">11:00</option>
                                                    <option value="11:30">11:30</option>
                                                    <option value="12:00">12:00</option>
                                                    <option value="12:30">12:30</option>
                                                    <option value="13:00">13:00</option>
                                                    <option value="13:30">13:30</option>
                                                    <option value="14:00">14:00</option>
                                                    <option value="14:30">14:30</option>
                                                    <option value="15:00">15:00</option>
                                                    <option value="15:30">15:30</option>
                                                    <option value="16:00">16:00</option>
                                                    <option value="16:30">16:30</option>
                                                    <option value="17:00">17:00</option>
                                                    <option value="17:30">17:30</option>
                                                    <option value="18:00">18:00</option>
                                                    <option value="18:30">18:30</option>
                                                </select>
                                                </td>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td colspan="4" align="center" >
                                        <a href="#" onclick="seekStatus()">
                                            <img src="../../../../images/back.gif" width="20" height="15" border="0"/>
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
