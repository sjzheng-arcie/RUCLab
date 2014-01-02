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


<body onload="doOnLoad();" style="background-color: #eef2fb">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0">
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_act" onclick="javascript:location.href='curriculumclasslist'">课程信息表一览</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="600">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto; display: none; ">
                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                <tr height="25">
                                    <td width="20px" bgcolor="#E3EFFF" >学年：
                                        <input name="schoolYear" type="text"/></td>
                                    <td width="20px" bgcolor="#E3EFFF" >老师：
                                        <input name="semester" type="text"/></td>
                                    <td width="20px" bgcolor="#E3EFFF" >房间：
                                        <input name="major" type="text"/></td>
                                    <td width="20px" bgcolor="#E3EFFF" >班级：
                                        <input name="class" type="text"/></td>
                                    <td width="20px" bgcolor="#E3EFFF" >
                                        <input type="button"  value="  查询"/></td>
                                </tr>

                            </table>
                            <table width="100%" border="1" cellpadding="" cellspacing="0" style="font-size:25px;">
                                <tr height="40">
                                    <td colspan="7" align="center" bgcolor="#e3efff"><strong>课表内容信息一览</strong></td>
                                </tr>
                                <tr align="center" height="40">
                                    <td width="12.5%" bgcolor="#E3EFFF">学年</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">学期</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">专业</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">班级</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">课程</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">教师</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">详细</td>
                                </tr>
                                <tr height="40" align="center">
                                    <td bgcolor="#F7F7F7">2012</td>
                                    <td bgcolor="#F7F7F7">1</td>
                                    <td bgcolor="#F7F7F7">网络工程</td>
                                    <td bgcolor="#F7F7F7">网络工程09-1</td>
                                    <td bgcolor="#F7F7F7">江湖入门基础</td>
                                    <td bgcolor="#F7F7F7">李三刀</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='curriculumview'">点击安排实验室</td>
                                </tr>
                                <c:forEach items="${pageInfo.data}" var="item">
                                    <tr>
                                        <td bgcolor="#F7F7F7">${item.classYear}</td>
                                        <td bgcolor="#F7F7F7">${item.c}</td>
                                        <td bgcolor="#F7F7F7">${item.major}</td>
                                        <td bgcolor="#F7F7F7">${item.className}</td>
                                        <td bgcolor="#F7F7F7" onclick="javascript:location.href='curriculumview?scheduleId=${item.id}'">点击安排实验室</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "1c");
                            dhxToolbar = dhxLayout.attachToolbar();
                            dhxToolbar.setIconsPath("${pageContext.request.contextPath}/dhtmlx/dhtmlxToolbar/samples/common/imgs/");
                            dhxToolbar.loadXML("common/toolbar_fayl.xml?" + new Date().getTime());
                            dhxToolbar.attachEvent("onClick", function (id) {
                                switch (id) {
                                    case 'new' :
                                        alert("新建课表信息!")
                                        window.location.href = 'newcurriculumschedule';
                                        break;
                                    case 'save' :
                                        alert("保存当前数据")
                                        break;
                                    case 'tijiao' :
                                        alert("方案已提交相关领导审批!")
                                        window.location.href = 'listapply';
                                        break;
                                    case 'prev' :
                                        window.location.href = 'listdeviceapply';
                                        break;
                                    case 'next' :
                                        alert("已经到最后一步!")
                                        break;
                                    default:
                                        alert("Button " + id + " was clicked!")
                                }
                            });
                            dhxLayout.cells("a").setText("课表一览");
                            dhxLayout.cells("a").attachObject("zuoxi");
                        }</script>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>