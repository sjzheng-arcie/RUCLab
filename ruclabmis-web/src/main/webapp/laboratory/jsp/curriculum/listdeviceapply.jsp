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
        <td class="title">教学实验管理 -&gt; 课程信息管理 -&gt; 课表添加管理</td>
    </tr>
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_nor" onclick="javascript:location.href='list.html'">课程基本信息</td>
                                <td class="op_nor" onclick="javascript:location.href='listdate'">预约日程</td>
                                <td class="op_nor" onclick="javascript:location.href='listapply'">实验室申请</td>
                                <td class="op_act" onclick="javascript:location.href='listdeviceapply'">实验设备申请</td>
                                <td class="op_nor" onclick="javascript:location.href='listcommit'">课表信息</td>
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
                            dhxToolbar.setIconsPath("/dhtmlx/dhtmlxToolbar/samples/dhtmlx/imgs/");
                            dhxToolbar.loadXML("common/toolbar.xml?" + new Date().getTime());
                            dhxToolbar.attachEvent("onClick", function (id) {
                                switch (id) {
                                    case 'save' :
                                        alert("保存当前数据!")
                                        break;
                                    case 'prev' :
                                        window.location.href = 'listapply';
                                        break;
                                    case 'next' :
                                        window.location.href = 'listcommit';
                                        break;
                                    default:
                                        alert("Button " + id + " was clicked!")
                                }
                            });


                            dhxLayout.cells("a").setText("课表信息");
                            dhxGrid = dhxLayout.cells("a").attachGrid();
                            dhxGrid.setImagePath("/dhtmlx/dhtmlxGrid/codebase/imgs/");
                            dhxGrid.setHeader("设备名称,设备类型,库存数量,使用数量,选择");
                            dhxGrid.setColAlign("left,left,left,left,left");
                            dhxGrid.setColTypes("ed,ed,ed,ed,ch");
                            dhxGrid.init();
                            dhxGrid.loadXML("common/grid_bgsb.xml?etc=" + new Date().getTime());

                            dhxLayout.cells("b").setText("备注说明");
                            dhxLayout.cells("b").setHeight("150");
                            dhtmlx.image_path = "/dhtmlx/dhtmlxEditor/codebase/imgs/";
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