<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <title></title>
</head>
<link href="..//css/style.css" rel="stylesheet" type="text/css"/>
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
                                <td class="op_act" onclick="javascript:location.href='curriculumview'">课表信息</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="626">
                        <div id="zuoxi" style="width: 100%; overflow: auto; display: none;">
                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                <tr height="25">
                                    <td width="12.5%" bgcolor="#E3EFFF">周次：<input type="text"/><input type="button" value="转到"/></td>
                                </tr>
                            </table>
                            <table width="100%" border="1" cellpadding="10" cellspacing="0">
                                <tr height="25" align="center">
                                    <td colspan="9" align="center" bgcolor="#e3efff"><strong>软件工程09-1课程表</strong></td>
                                </tr>
                                <tr height="25" align="center">

                                    <td width="10%" bgcolor="#E3EFFF"></td>
                                    <td width="10%" bgcolor="#E3EFFF">节次</td>
                                    <td width="10%" bgcolor="#E3EFFF">周一</td>
                                    <td width="10%" bgcolor="#E3EFFF">周二</td>
                                    <td width="10%" bgcolor="#E3EFFF">周三</td>
                                    <td width="10%" bgcolor="#E3EFFF">周四</td>
                                    <td width="10%" bgcolor="#E3EFFF">周五</td>
                                    <td width="10%" bgcolor="#E3EFFF">周六</td>
                                    <td width="10%" bgcolor="#E3EFFF">周天</td>
                                </tr>
                                <tr height="100" align="center">
                                    <td bgcolor="#F7F7F7" rowspan="2">上午</td>
                                    <td bgcolor="#F7F7F7">一、二节</td>


                                    <td bgcolor="#F7F7F7">网络工程 王晓静 网络工程实验题一</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7">软件工程 孙红梅 软件工程实验题一</td>
                                    <td bgcolor="#F7F7F7">网络工程 王晓静 网络工程实验题二</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                </tr>
                                <tr height="100" align="center">

                                    <td bgcolor="#F7F7F7">三、四节</td>
                                    <td bgcolor="#F7F7F7">软件工程 孙红梅 软件工程实验题一</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>

                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7">网络工程 王晓静 网络工程实验题二</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                </tr>
                                <tr height="100" align="center">
                                    <td bgcolor="#F7F7F7" rowspan="2">下午</td>
                                    <td bgcolor="#F7F7F7">五、六节</td>
                                    <td bgcolor="#F7F7F7">软件工程 孙红梅 软件工程实验题一</td>

                                    <td bgcolor="#F7F7F7">网络工程 王晓静 网络工程实验题一</td>
                                    <td bgcolor="#F7F7F7">网络工程 王晓静 网络工程实验题一</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7">网络工程 王晓静 网络工程实验题二</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                </tr>
                                <tr height="100" align="center">

                                    <td bgcolor="#F7F7F7">七、八节</td>
                                    <td bgcolor="#F7F7F7">软件工程 孙红梅 软件工程实验题一</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>

                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7">网络工程 王晓静 网络工程实验题二</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                </tr>
                                <tr height="100" align="center">
                                    <td bgcolor="#F7F7F7" >晚上</td>
                                    <td bgcolor="#F7F7F7">九、十节</td>
                                    <td bgcolor="#F7F7F7">软件工程 孙红梅 软件工程实验题一</td>

                                    <td bgcolor="#F7F7F7">网络工程 王晓静 网络工程实验题一</td>
                                    <td bgcolor="#F7F7F7">网络工程 王晓静 网络工程实验题一</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7">网络工程 王晓静 网络工程实验题二</td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                    <td bgcolor="#F7F7F7" onclick="javascript:location.href='addlession'"></td>
                                </tr>
                            </table>
                        </div>


                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "1c");
                            dhxLayout.cells("a").setText("课表信息");
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