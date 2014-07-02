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
<link href="${pageContext.request.contextPath}/js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/chosen/chosen.jquery.min.js"></script>

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

        var beginWeekFlag=Number(document.getElementById('beginWeek').value);

        var endWeekFlag=Number(document.getElementById('endWeek').value);
        if(beginWeekFlag>endWeekFlag){
            alert("起始周次必须小于等于结束周次！");
            return ;
        }

        var getStr =  "/laboratory/jsp/appointment/laboratory/multiroomstatus?";
//        getStr +=  "meetDate=" + document.getElementById('meetDate').value;

        getStr +=  "&stime=" + document.getElementById('stime').value;
        getStr +=  "&etime=" + document.getElementById('etime').value;

        getStr +=  "&weekDay=" + document.getElementById('weekDay').value;

        getStr +=  "&beginWeek=" + document.getElementById('beginWeek').value;
        getStr +=  "&endWeek=" + document.getElementById('endWeek').value;
        getStr +=  "&appointmentType=" + document.getElementById('appointmentType').value;

        getStr +=  "&termYearId=" + document.getElementById('termYearId').value;

        parent.statusFrame.location = getStr;
    }
        $(document).ready(function () {

            $("#termYearId").chosen({
                no_results_text: "没有找到"
            });
        });

    function changeWeekNum(){

        var obj=document.getElementById("termYearId");
        var beginWeek=$("#termYearId").find("option:selected").attr("beginFlag");
        var endWeek=$("#termYearId").find("option:selected").attr("endFlag");

        var begin=" 第<select  id ='beginWeek'  name='beginWeek'>";
        var end=" 第<select  id ='endWeek'  name='endWeek'>";
        var item="";
        var i=0;
        for(i=beginWeek;i<=endWeek;i++){
            item=item+  "<option value='"+i+"'>"+i+"</option>";
        }
        item=item+"周";

        begin=begin+item;
        end=end+item;
        document.getElementById("beginDiv").innerHTML=begin;

        document.getElementById("endDiv").innerHTML=end;


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
                                                <td align="right">学期学年：</td>
                                                <td>
                                                    <select id="termYearId" name="termYearId"
                                                            style="width: 140px;height: 22px" valid="required" errmsg="请选择学年学期!"
                                                            onchange="changeWeekNum();"
                                                            data-placeholder="选择学年学期...">
                                                        <c:forEach items="${termYearList}" var="termYear">
                                                            <option   value="${termYear.id}" beginFlag="${termYear.startweek}" endFlag="${termYear.endweek}">${termYear.name}(${termYear.year}年)</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="right" width="30%">星期：</td>
                                                <td>
                                                    <select id="weekDay"name="weekDay">
                                                        <option value="1">星期一</option>
                                                        <option value="2">星期二</option>
                                                        <option value="3">星期三</option>
                                                        <option value="4">星期四</option>
                                                        <option value="5">星期五</option>
                                                        <option value="6">星期六</option>
                                                        <option value="7">星期天</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="right" width="30%">周次：</td>
                                                <td width="70%"><div name="beginDiv" id="beginDiv">
                                                    第<select  id ="beginWeek"  name="beginWeek">
                                                    <c:forEach var="temp" begin="1" end="26" step="1">
                                                        <option value="${temp}">${temp}</option>
                                                    </c:forEach>
                                                </select>周</div>
                                                    -
                                                    <div name="endDiv" id="endDiv">第<select id="endWeek" name="endWeek">
                                                        <c:forEach var="temp" begin="1" end="26" step="1">
                                                            <option value="${temp}">${temp}</option>
                                                        </c:forEach>
                                                    </select>周</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="100"  align="right" >预约类型：</td>
                                                <td >
                                                    <select id="appointmentType" name="appointmentType" style="width: 150px;height: 22px">
                                                        <option value="multiLaboratory">实验预约</option>
                                                        <option value="multiMeeting">会议预约</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="100"  align="right" >预约时间段：</td>
                                                <td width="100">
                                                    <select id="stime" name="stime" style="width: 60px;height: 22px">
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
                                                        <option value="18:30">19:00</option>
                                                        <option value="18:30">19:30</option>
                                                        <option value="18:30">20:00</option>
                                                        <option value="18:30">20:30</option>
                                                        <option value="18:30">21:00</option>
                                                        <option value="18:30">21:30</option>
                                                    </select> -  <select id="etime" name="etime" style="width: 60px;height: 22px">
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
                                                    <option value="18:30">19:00</option>
                                                    <option value="18:30">19:30</option>
                                                    <option value="18:30">20:00</option>
                                                    <option value="18:30">20:30</option>
                                                    <option value="18:30">21:00</option>
                                                    <option value="18:30">21:30</option>
                                                    <option value="18:30">22:00</option>
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
                                        <a href="javascript:;" onclick="seekStatus()">
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
