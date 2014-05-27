<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <title></title>
</head>
<link href="/css/style.css" rel="stylesheet" type="text/css"/>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxToolbar/codebase/skins/dhtmlxtoolbar_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxToolbar/codebase/dhtmlxtoolbar.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxTree/codebase/dhtmlxtree.css">
<script src="/dhtmlx/dhtmlxTree/codebase/dhtmlxtree.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxGrid/codebase/dhtmlxgrid.css">
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>
<script src="/dhtmlx/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxEditor/codebase/skins/dhtmlxeditor_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxEditor/codebase/dhtmlxeditor.js"></script>
<script type="text/javascript" src="../../../js/page.js"></script>
<link href="${pageContext.request.contextPath}/js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/chosen/chosen.jquery.min.js"></script>



<script>

    $(document).ready(function () {
        $("#roomId").chosen({
            no_results_text: "没有找到"
        });

    });
    function setTheLab(roomId){
        document.mainForm.action="setlab?roomId="+roomId;
        document.mainForm.submit();
    };

    function toApply(roomId,roomName) {
        window.opener.setLab(roomId,roomName);
        window.close();
    };

    function searchRoom(){

        document.mainForm.action="toSearchroombyId";
        document.mainForm.submit();
    };

</script>
<body onload="doOnLoad();"style="background-color: #eef2fb">
<form name="mainForm" method="post">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0">
<tr>
<td valign="top" height="100%">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
    <td height="27">
        <table border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td class="op_act" >安排实验室</td>
            </tr>
        </table>
    </td>
</tr>
<tr>
<td valign="top" height="490">
<div id="zuoxi" style="width: 100%; height: 100%; overflow: auto; background-color: #e3efff">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr bgcolor="#E3EFFF">

        <td >房间:
            <select id="roomId" name="roomId"
                    style="width: 200px;height: 22px"
                    data-placeholder="选择房间...">
                <c:forEach items="${roomList}" var="room">
                    <option  value="${room.id}">${room.name}</option>
                </c:forEach>
            </select>
        </td>
        <td ><input type="button" value="搜索" onclick="searchRoom();"></td>

    </tr>
</table>
    <input type="hidden" name="curriculumScheduleId" value="${curriculumSchedule.id}">
<table width="100%" border="0" cellspacing="1" cellpadding="0">
        <c:forEach items="${listRoomList}" var="roomList">
            <tr>
                <c:forEach items="${roomList}" var="item">
                    <td height="110" width="25%" bgcolor="#aae4ff" onclick="toApply('${item.id}','${item.name}');" style="cursor:hand;width: 25%;">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                                    height="64"/><br/>
                                    <span class="title">房间号</span></td>
                                    <td>
                                        ${item.name}<br/>
                                        ${item.description}<br/>
                                    </td>
                            </tr>
                        </table>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
</table>
</div>
<div id="parentId"
     style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; border: #B5CDE4 1px solid;"></div>
<script>var dhxLayout, dhxToolbar, dhxTree, editor;
function doOnLoad() {
    dhxLayout = new dhtmlXLayoutObject("parentId", "1C");
    dhxLayout.cells("a").setText("选择教室");
    dhxLayout.cells("a").attachObject("zuoxi");

}</script>
</td>
</tr>
</table>
</td>
</tr>
</table>
</form>
</body>
</html>