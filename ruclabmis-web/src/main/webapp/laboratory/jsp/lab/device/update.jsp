<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>
<script>
    function save() {
        document.mainForm.action = "devicelist";
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
                            <div class="titlebt">设备信息管理 >设备信息管理</div>
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
                                                                    class="STYLE1">设备信息修改</span></td>
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
                                            <tr heigt="25px">
                                                <td nowrap align="right">设备编号:</td>
                                                <td nowrap>
                                                    <input type="text" name="deviceName" value="${device.no}">
                                                </td>
                                                <td nowrap align="right">设备名称:</td>
                                                <td nowrap>
                                                    <input type="text" name="deviceName" value="${device.name}">
                                                </td>
                                            </tr>
                                            <tr heigt="25px">
                                                <td nowrap align="right">设备类型:</td>
                                                <td nowrap>
                                                    <select name="deviceType">
                                                        <c:forEach items="${deviceTypeList}" var="item">
                                                            <c:choose>
                                                                <c:when test="${item.id==device.deviceType.id}">
                                                                    <option id="${item.id}" selected>${item.value}</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option id="${item.id}">${item.value}</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>

                                                </td>
                                                <td nowrap align="right">是否存在故障:</td>
                                                <td nowrap>

                                                    <select name="ifBroken">
                                                            <c:choose>
                                                                <c:when test="${device.ifBroken==true}">
                                                                    <option value="1" selected >是</option>
                                                                    <option value="0">否</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="1"  >是</option>
                                                                    <option value="0" selected >否</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr heigt="25px">
                                                <td nowrap align="right">存放位置:</td>
                                                <td nowrap>
                                                    <select name="theRoom">
                                                        <c:forEach items="${roomList}" var="item">
                                                            <c:choose>
                                                                <c:when test="${item.id==device.theRoom.id}">
                                                                    <option id="${item.id}" selected>${item.value}</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option id="${item.id}">${item.value}</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                <td nowrap align="right">所属部门:</td>
                                                <td nowrap>
                                                    <select name="theDepartment">
                                                        <c:forEach items="${departmentList}" var="item">
                                                            <c:choose>
                                                                <c:when test="${item.id==device.theDepartment.id}">
                                                                    <option id="${item.id}" selected>${item.value}</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option id="${item.id}">${item.value}</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>
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
</html>
