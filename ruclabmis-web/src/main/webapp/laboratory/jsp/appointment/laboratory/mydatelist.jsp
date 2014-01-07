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
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxGrid/codebase/dhtmlxgrid.css">
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxGrid/codebase/skins/dhtmlx   grid_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxGrid/codebase/dhtmlxcommon.js"></script>
<script src="/dhtmlx/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>
<script src="/dhtmlx/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>
<script src="/dhtmlx/dhtmlxGrid/codebase/excells/dhtmlxgrid_excell_link.js"></script>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxToolbar/codebase/skins/dhtmlxtoolbar_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxToolbar/codebase/dhtmlxtoolbar.js"></script>


<body onload="doOnLoad();">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0">
    <tr>
        <td class="title">预约管理 -&gt; 实验室预约 -&gt; 实验室预约申请</td>
    </tr>
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td valign="top" height="420">
                        <div id="objId" style="width: 100%; height: 100%; overflow: auto; display: none; padding:0px;">
                            <table width="100%" border="0" cellpadding="1" cellspacing="1">
                                <tr height="25">
                                    <td width="10%" align="right" bgcolor="#e3efff">实验名称：</td>
                                    <td width="20%" bgcolor="#f7f7f7"><input type="text" name="textfield" id="textfield"
                                                                             style="width:120px"></td>
                                    <td width="10%" align="right" bgcolor="#e3efff">实验类型：</td>
                                    <td width="20%" bgcolor="#f7f7f7"><select name="select" id="select"
                                                                              style="width:120px">
                                        <option>操作</option>
                                        <option>验证</option>
                                        <option>设计</option>
                                        <option>综合</option>
                                    </select></td>
                                    <td width="10%" align="right" bgcolor="#e3efff">审核状态：</td>
                                    <td width="20%" bgcolor="#f7f7f7"><select name="select2" id="select2"
                                                                              style="width:120px">
                                        <option>全部</option>
                                        <option>已审核</option>
                                        <option>未审核</option>
                                    </select></td>
                                    <td width="10%" align="center" bgcolor="#f7f7f7">
                                        <button><img src="../../images/ico/16x16/zoom.png" width="16" height="16"
                                                     align="absmiddle"/> 查询
                                        </button>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>

                        <script>var dhxLayout, dhxToolbar, dhxGrid,dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "2E");
                            dhxToolbar = dhxLayout.attachToolbar();
                            dhxToolbar.setIconsPath("/dhtmlx/dhtmlxToolbar/samples/common/imgs/");
                            dhxToolbar.loadXML("common/toolbar_list.xml?" + new Date().getTime());
                            dhxToolbar.attachEvent("onClick", function (id) {
                                switch (id) {
                                    case 'new' :
                                        window.location.href = 'appointmentbaseinfo';
                                        break;
                                    case 'del' :
                                        alert("删除选中的数据!")
                                        break;
                                    default:
                                        alert("Button " + id + " was clicked!")
                                }
                            });

                            dhxLayout.cells("a").setText("查询条件");
                            dhxLayout.cells("a").setHeight("62");
                            dhxLayout.cells("a").attachObject("objId");

                            dhxLayout.cells("b").setText("查询结果");
                            dhxGrid = dhxLayout.cells("b").attachGrid();
                            dhxGrid.setImagePath("/dhtmlx/dhtmlxGrid/codebase/imgs/");
                            dhxGrid.setHeader("选择,实验名称,实验类型,预约时间,申请时间,申请人,审核状态,编辑,审核");
                            dhxGrid.setInitWidths("50,*,100,100,100,100,100,50,50")
                            dhxGrid.setColAlign("center,left,left,left,left,left,left,center,center");
                            dhxGrid.setColTypes("ch,ed,ed,ed,ed,ed,ed,link,link");
                            dhxGrid.init();
                            dhxGrid.loadXML("common/grid_yagl.xml?etc=" + new Date().getTime());
                        }</script>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>