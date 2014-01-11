<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <title></title>
</head>
<link href="${pageContext.request.contextPath}/js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/chosen/chosen.jquery.min.js"></script>
<link href="/css/style.css" rel="stylesheet" type="text/css"/>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>

<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>
<script>


    $(document).ready(function () {
        $("#target").chosen({
            no_results_text: "没有找到"
        });
        $("#termYear").chosen({
            no_results_text: "没有找到"
        });
    });
    function add(){
        document.mainForm.action="updatecurriculumschdedule";
        document.mainForm.submit();
    }
</script>

<body onload="doOnLoad();">
<form name="mainForm" action="updatecurriculumschedule" method="post">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0" >
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0"  cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_act" onclick="javascript:location.href='list'">创建课表信息</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="500">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto;bgcolor:#ffffff;">

                            <table width="100%" border="0" cellpadding="1" cellspacing="1" style="margin-top:20px">

                                <tr>
                                    <td align="right">学期学年：</td>
                                    <td>
                                        <select id="termYear" name="termYearId"
                                                style="width: 252px;height: 22px"
                                                data-placeholder="选择学年学期...">
                                            <c:forEach items="${termYearList}" var="termYear">
                                                <option value="${termYear.id}"
                                                <c:if test="${curriculumSchedule.termYearid==termYear.id}">selected </c:if>>
                                                ${termYear.name}(${termYear.year}年)
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">班级：</td>
                                    <td>
                                        <select id="target" name="curriculumClassId"
                                                style="width: 252px;height: 22px"
                                                data-placeholder="选择班级...">
                                            <c:forEach items="${curriculumClassList}" var="curriculumClass">
                                                    <option value="${curriculumClass.id}"
                                                            <c:if test="${curriculumSchedule.curriculumId==curriculumClass.id}">selected </c:if> >
                                                            ${curriculumClass.className}(${curriculumClass.classSn})
                                                    </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">星期：</td>
                                    <td>
                                        <select name="weekDay">
                                            <option <c:if test="${curriculumSchedule.weekday==1}" >selected</c:if> value="1">星期一</option>
                                            <option <c:if test="${curriculumSchedule.weekday==2}" >selected</c:if> value="2">星期二</option>
                                            <option <c:if test="${curriculumSchedule.weekday==3}" >selected</c:if> value="3">星期三</option>
                                            <option <c:if test="${curriculumSchedule.weekday==4}" >selected</c:if> value="4">星期四</option>
                                            <option <c:if test="${curriculumSchedule.weekday==5}" >selected</c:if> value="5">星期五</option>
                                            <option <c:if test="${curriculumSchedule.weekday==6}" >selected</c:if> value="6">星期六</option>
                                            <option <c:if test="${curriculumSchedule.weekday==7}" >selected</c:if> value="7">星期天</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">节次：</td>
                                    <td>
                                        <select name="classSection">
                                            <option
                                                    <c:if test="${curriculumSchedule.amPm==1}" >selected</c:if> value="1">上午一二节</option>
                                            <option  <c:if test="${curriculumSchedule.amPm==2}" >selected</c:if> value="2" >上午三四节</option>
                                            <option <c:if test="${curriculumSchedule.amPm==3}" >selected</c:if> value="3">下午五六节</option>
                                            <option <c:if test="${curriculumSchedule.amPm==4}" >selected</c:if> value="4">下午七八节</option>
                                            <option  <c:if test="${curriculumSchedule.amPm==5}" >selected</c:if> value="5">晚上九十节</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">周次：</td>
                                    <td width="70%">第<select name="beginWeek">
                                        <c:forEach var="temp" begin="1" end="26" step="1">
                                            <option
                                                    <c:if test="${curriculumSchedule.week==temp}" >selected</c:if>
                                                    value="${temp}">
                                                    ${temp}
                                            </option>
                                        </c:forEach>
                                    </select>周</td>
                                </tr>

                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" style="margin-top:20px">
                                <tr>
                                    <td align="center"><input type="submit" value="保存"onclick="add();"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "1c");
                            dhxLayout.cells("a").setText("创建课表信息");
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