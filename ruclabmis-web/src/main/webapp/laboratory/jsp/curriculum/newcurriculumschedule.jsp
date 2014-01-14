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

<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxToolbar/codebase/skins/dhtmlxtoolbar_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxToolbar/codebase/dhtmlxtoolbar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/valid.js"></script>

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
        var a = window.document.getElementById("beginWeek").value;
        var b = window.document.getElementById("endWeek").value;
        if(a>b){
            alert("结束时间不能早于开始时间！");
            return;
        }
        document.mainForm.action="addcurriculumschedule";
        document.mainForm.submit();
    }
</script>

<body onload="doOnLoad();" style="background-color: #eef2fb">
<form name="mainForm" action="addcurriculumschedule" method="post">
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
                <tr bgcolor="">
                    <td valign="top" height="500">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto;background-color: #e3efff">

                            <table width="100%" border="0" cellpadding="1" cellspacing="1" style="margin-top:20px;background-color:#e3efff ">

                                <tr>
                                    <td align="right">学期学年：</td>
                                    <td>
                                        <select id="termYear" name="termYearId"
                                                style="width: 252px;height: 22px" valid="requierd" errmsg="请选择学年"
                                                data-placeholder="选择学年学期...">
                                            <c:forEach items="${termYearList}" var="termYear">
                                                <option value="${termYear.id}">${termYear.name}(${termYear.year}年)</option>
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
                                                    <option value="${curriculumClass.id}">${curriculumClass.className}(${curriculumClass.classSn})</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">星期：</td>
                                    <td>
                                        <select name="weekDay">
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
                                    <td align="right" width="30%">节次：</td>
                                    <td>
                                        <select name="classSection">
                                            <option value="1">上午一二节</option>
                                            <option value="2" >上午三四节</option>
                                            <option value="3">下午五六节</option>
                                            <option value="4">下午七八节</option>
                                            <option value="5">晚上九十节</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">开始时间：</td>
                                    <td width="70%">第<select  id ="beginWeek"  name="beginWeek">
                                        <c:forEach var="temp" begin="1" end="26" step="1">
                                            <option value="${temp}">${temp}</option>
                                        </c:forEach>
                                    </select>周</td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">结束时间：</td>
                                    <td width="70%">第<select id="endWeek" name="endWeek">
                                        <c:forEach var="temp" begin="1" end="26" step="1">
                                            <option value="${temp}">${temp}</option>
                                        </c:forEach>
                                    </select>周</td>
                                </tr>


                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" style="margin-top:20px">
                                <tr>
                                    <td align="center"><input type="button" name="return" value="返回" class="button"
                                                              onclick="window.history.go(-1);"/></td>
                                    <td align=""><input type="submit" value="保存"onclick="add();"/>
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