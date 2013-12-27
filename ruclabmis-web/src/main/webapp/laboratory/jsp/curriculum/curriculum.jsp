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

<body onload="doOnLoad();">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0">
    <tr>
        <td class="title">教学实验管理 -&gt; 课程信息管理 -&gt; 课表一览</td>
    </tr>
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_act" onclick="javascript:location.href='curriculum'">课表一览</td>
                                <td class="op_nor" onclick="javascript:location.href='listcommit'">课表信息</td>
                                <td class="op_nor" onclick="javascript:location.href='listapply'">实验室申请</td>
                                <td class="op_nor" onclick="javascript:location.href='list'">课程基本信息</td>

                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="800">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto; display: none;">
                            <table width="100%" border="0" cellpadding="0" cellspacing="0">

                                <tr height="25">

                                    <td width="12.5%" bgcolor="#E3EFFF">周次：<input type="text"/></td>
                                    <td width="12.5%" bgcolor="#E3EFFF">班级：<input type="text"/></td>
                                    <td width="12.5%" bgcolor="#E3EFFF"><input type="button" value="转到"/></td>
                                    <td width="12.5%" bgcolor="#E3EFFF"></td>
                                    <td width="12.5%" bgcolor="#E3EFFF"></td>
                                    <td width="12.5%" bgcolor="#E3EFFF"></td>
                                    <td width="12.5%" bgcolor="#E3EFFF"></td>
                                </tr>

                            </table>
                            <table width="100%" border="1" cellpadding="" cellspacing="0" style="font-size:25px;">
                                <tr height="40">
                                    <td colspan="5" align="center" bgcolor="#e3efff"><strong>课表一览</strong></td>
                                </tr>
                                <tr align="center" height="40">
                                    <td width="12.5%" bgcolor="#E3EFFF">序号</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">编号</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">班级</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">详细</td>
                                </tr>
                                <tr height="40" align="center">
                                    <td bgcolor="#F7F7F7">1</td>
                                    <td bgcolor="#F7F7F7">kb0001</td>
                                    <td bgcolor="#F7F7F7">网络工程09-1</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='listcommit'">点击查看</td>
                                </tr>
                                <tr height="40" align="center">
                                    <td bgcolor="#F7F7F7">2</td>
                                    <td bgcolor="#F7F7F7">kb0001</td>
                                    <td bgcolor="#F7F7F7">网络工程09-1</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='listcommit'">点击查看</td>
                                </tr>
                                <tr height="40" align="center">
                                    <td bgcolor="#F7F7F7">3</td>
                                    <td bgcolor="#F7F7F7">kb0001</td>
                                    <td bgcolor="#F7F7F7">网络工程09-1</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='listcommit'">点击查看</td>
                                </tr>
                                <tr height="40" align="center">
                                    <td bgcolor="#F7F7F7">4</td>
                                    <td bgcolor="#F7F7F7">kb0001</td>
                                    <td bgcolor="#F7F7F7">网络工程09-1</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='listcommit'">点击查看</td>
                                </tr>
                            </table>
                        </div>
                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "1c");

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