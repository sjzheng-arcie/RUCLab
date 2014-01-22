<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>

    <script>
        function selectTable() {
            window.location.href = 'page01_ylya_zx2_cont2.html';
        }
    </script>

</head>

<body>
<table width="100%" border="0" cellspacing="1" cellpadding="0">
    <%--<c:forEach items="${rooms}" var="room" varStatus="status">--%>
    <c:forEach var="row" begin="0" end="${rooms.size()%4==0?rooms.size()/4-1:rooms.size()/4}">
        <tr>
            <c:forEach var="col" begin="1" end="4">
                <c:if test="${row*4+col < rooms.size()}">
                    <c:set var="currRoom" value="${rooms.get(row*4+col-1)}" />
                    <c:set var="index" value="-1" />
                    <c:forEach var="roomId" items="${occupiedRoomIds}" varStatus="status">
                        <c:if test="${roomId eq currRoom.getId()}">
                            <c:set var="index" value="${status.index}" />
                        </c:if>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${index >= 0}">
                            <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="40%" align="center">
                                            <img src="/images/door.png" width="64" height="64"/><br/>
                                            <span class="title">${currRoom.getName()}</span>
                                        </td>
                                        <td>
                                            已占用<br/>
                                            ${schedules.get(index).getCurriculum().getName()}<br/>
                                            ${schedules.get(index).getTeacher().getName()}<br/>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td width="25%" height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='page01_ylya_zx2.html'"
                                style="cursor:hand;">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="40%" align="center">
                                            <img src="/images/door_open.png" width="64" height="64"/><br/>
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

</body>
</html>