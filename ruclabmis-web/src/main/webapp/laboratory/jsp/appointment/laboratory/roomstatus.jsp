<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>
<script>
    function selectTable(roomIndex) {
        var getStr =  "/laboratory/jsp/appointment/laboratory/toAdd?";
        getStr +=  "startTime=" + "${startTime}";
        getStr +=  "&endTime=" + "${endTime}";
        getStr +=  "&roomId=" +roomIndex;

        window.location.href = getStr;
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
                            <div class="positionbt">房间占用情况</div>
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
                <table width="100%" border="0" align="center" >
                    <tr valign="top">
                        <td>
                            <table width="100%" border="0"  bgcolor="#a8c7ce">
                                <tr bgcolor="#FFFFFF">
                                    <td bgcolor="#FFFFFF">
                                        <div style="width:100%; height:380px; overflow:scroll;">
                                            <table border="0" bgcolor="#E3E9EE"
                                                   style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;">
                                                <c:forEach var="row" begin="0" end="${rooms.size()%4==0?rooms.size()/4-1:rooms.size()/4}">
                                                    <tr>
                                                        <c:forEach var="col" begin="1" end="4">
                                                            <c:if test="${row*4+col <= rooms.size()}">
                                                                <c:set var="currRoom" value="${rooms.get(row*4+col-1)}" />
                                                                <c:set var="index" value="-1" />
                                                                <c:forEach var="roomId" items="${occupiedRoomIds}" varStatus="status">
                                                                    <c:if test="${roomId eq currRoom.getId()}">
                                                                        <c:set var="index" value="${status.index}" />
                                                                    </c:if>
                                                                </c:forEach>

                                                                <c:choose>
                                                                    <c:when test="${index >= 0}">
                                                                        <td height="110" bgcolor="#aae4ff">
                                                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                                                <tr>
                                                                                    <td width="40%" align="center">
                                                                                        <img src="/images/door.png" width="64" height="64" style="cursor:pointer;"
                                                                                             onclick="javascript:alert('当前教室已被占用!')"/><br/>
                                                                                        <span class="title">${currRoom.getName()}</span>
                                                                                    </td>
                                                                                    <td> 已占用<br/>
                                                                                            ${schedules.get(index).getCurriculum().getName()}<br/>
                                                                                            ${schedules.get(index).getTeacher().getName()}<br/>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <td width="25%" height="110" bgcolor="#e4ffaa">
                                                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                                                <tr>
                                                                                    <td width="40%" align="center">
                                                                                        <img src="/images/door_open.png" width="64" height="64"  style="cursor:pointer;"
                                                                                             onclick="selectTable(${currRoom.getId()})"/><br/>
                                                                                        <span class="title">${currRoom.getName()}</span>
                                                                                    </td>
                                                                                    <td>
                                                                                        <p>空闲<br/> <br/> <br/> <br/>
                                                                                        </p>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:if>
                                                        </c:forEach>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </div>
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
