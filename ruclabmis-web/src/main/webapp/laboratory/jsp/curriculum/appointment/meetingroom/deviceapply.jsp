<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <title></title>
</head>
<link href="../../css/style.css" rel="stylesheet" type="text/css"/>
<script src="../../common/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="../../common/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>

<link rel="stylesheet" type="text/css" href="../../common/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="../../common/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="../../common/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>

<link rel="stylesheet" type="text/css" href="../../common/dhtmlxToolbar/codebase/skins/dhtmlxtoolbar_dhx_skyblue.css">
<script src="../../common/dhtmlxToolbar/codebase/dhtmlxtoolbar.js"></script>

<link rel="stylesheet" type="text/css" href="../../common/dhtmlxTree/codebase/dhtmlxtree.css">
<script src="../../common/dhtmlxTree/codebase/dhtmlxtree.js"></script>

<link rel="stylesheet" type="text/css" href="../../common/dhtmlxGrid/codebase/dhtmlxgrid.css">
<link rel="stylesheet" type="text/css" href="../../common/dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_skyblue.css">
<script src="../../common/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>
<script src="../../common/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>

<link rel="stylesheet" type="text/css" href="../../common/dhtmlxEditor/codebase/skins/dhtmlxeditor_dhx_skyblue.css">
<script src="../../common/dhtmlxEditor/codebase/dhtmlxeditor.js"></script>

<body onload="doOnLoad();">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0">
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_nor" onclick="javascript:location.href='appointmentbaseinfo'">预约基本信息</td>
                                <td class="op_nor" onclick="javascript:location.href='appointmentdate'">预约日程</td>
                                <td class="op_nor" onclick="javascript:location.href='meetingroomapply'">会议室申请</td>
                                <td class="op_act" onclick="javascript:location.href='deviceapply'">会议设备申请</td>
                                <td class="op_nor" onclick="javascript:location.href='appointmentinfocommit'">预约信息提交</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="420">
                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "2E");
                            dhxToolbar = dhxLayout.attachToolbar();
                            dhxToolbar.setIconsPath("../../common/dhtmlxToolbar/samples/common/imgs/");
                            dhxToolbar.loadXML("common/toolbar.xml?" + new Date().getTime());
                            dhxToolbar.attachEvent("onClick", function (id) {
                                switch (id) {
                                    case 'save' :
                                        alert("保存当前数据!")
                                        break;
                                    case 'prev' :
                                        window.location.href = 'deviceapply';
                                        break;
                                    case 'next' :
                                        window.location.href = 'appointmentinfocommit';
                                        break;
                                    default:
                                        alert("Button " + id + " was clicked!")
                                }
                            });


                            dhxLayout.cells("a").setText("会议设备");
                            dhxGrid = dhxLayout.cells("a").attachGrid();
                            dhxGrid.setImagePath("../../common/dhtmlxGrid/codebase/imgs/");
                            dhxGrid.setHeader("设备名称,设备类型,库存数量,使用数量,选择");
                            dhxGrid.setColAlign("left,left,left,left,left");
                            dhxGrid.setColTypes("ed,ed,ed,ed,ch");
                            dhxGrid.init();
                            dhxGrid.loadXML("common/grid_bgsb.xml?etc=" + new Date().getTime());

                            dhxLayout.cells("b").setText("备注说明");
                            dhxLayout.cells("b").setHeight("150");
                            dhtmlx.image_path = "../../common/dhtmlxEditor/codebase/imgs/";
                            dhxEditor = dhxLayout.cells("b").attachEditor();
                        }</script>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>