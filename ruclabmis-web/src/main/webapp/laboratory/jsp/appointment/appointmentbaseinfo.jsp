<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title></title>

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
</head>

<body onload="seekStatus()">
<table width="100%" border="0" cellpadding="1" cellspacing="1">

    <tr height="25">
        <td colspan="4" align="center" bgcolor="#e3efff"><strong>填写预约申请基本信息</strong></td>
    </tr>

    <tr>
        <td  width="100" align="right" bgcolor="#e3efff">学期学年：</td>
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
        <td width="100"  align="right" bgcolor="#e3efff">第几周：</td>
        <td width="100">
            <select id="week" name="week" style="width: 180px;height: 22px">
                <c:forEach begin="0" end ="22" var="i">
                    <option value="${i}" <c:if test="${i==currWeek}"> selected</c:if>>${i}</option>
                </c:forEach>
            </select></td>
    </tr>

    <tr>
        <td  width="100"  align="right" bgcolor="#e3efff">星期：</td>
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
        <td  align="right" bgcolor="#e3efff" width="100">时间段：</td>
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
        <td align="right"  align="right" bgcolor="#e3efff">申请类型：</td>
        <td><select name="type" id="type" style="width: 180px;height: 22px">
            <option value= "0">实验室</option>
            <option value= "1">会议室</option>
            <option>工位</option>
        </select></td>
    </tr>
    <tr>
        <td align="right"  align="right" bgcolor="#e3efff">申请内容描述：</td>
        <td><textarea name="textfield4" id="textfield4"
                      cols="60" rows="10" style="width: 100%;height: 100%">熟悉中断发生时中断服务程序的执行过程；熟悉系统的中断向量表在内存中的位置、所占内存大小及所能存储的中断向量个数；掌握软中断服务程序的设计方法、中断向量的设置、保护和恢复现场。
        </textarea></td>
    </tr>
    <tr>
        <td colspan="4" align="center" bgcolor="#e3efff">
            <a href="#" onclick="seekStatus()">
                <img src="../../../images/back.gif" width="20" height="15" border="0"/>
                <span class="txt_bt">查看房间占用</span>
            </a>
        </td>
    </tr>
</table>
</body>
</html>