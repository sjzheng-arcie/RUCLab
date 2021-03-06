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
        <td class="title">教学实验管理 -&gt; 课程信息管理 -&gt; 课程基本信息</td>
    </tr>
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_nor" onclick="javascript:location.href='curriculum'">课表一览</td>
                                <td class="op_nor" onclick="javascript:location.href='listcommit'">课表信息</td>
                                <td class="op_nor" onclick="javascript:location.href='listapply'">实验室申请</td>
                                <td class="op_act" onclick="javascript:location.href='list'">课程基本信息</td>

                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="500">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto; display: none;">
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" style="margin-top:20px">
                                <tr>
                                    <td align="right" width="30%">实验名称：</td>
                                    <td width="70%"><input value="软中断程序设计实验" type="text" name="textfield"
                                                           id="textfield"/></td>
                                </tr>
                                <tr>
                                    <td align="right">课程名称：</td>
                                    <td><select name="select" id="select">
                                        <option>汇编语言程序设计</option>
                                        <option>编译原理</option>
                                        <option>面向对象程序设计基础</option>
                                        <option>软件工程</option>
                                        <option>实用组网技术</option>
                                    </select></td>
                                </tr>
                                <tr>
                                    <td align="right">实验类型：</td>
                                    <td><select name="select" id="selectInstructor">
                                        <option>操作</option>
                                        <option>验证</option>
                                        <option>设计</option>
                                        <option>综合</option>
                                    </select></td>
                                </tr>
                                <tr>
                                    <td align="right">申请类型：</td>
                                    <td><select name="select" id="selectType">
                                        <option>实验室</option>
                                        <option>工位</option>
                                    </select></td>
                                </tr>
                                <tr>
                                    <td align="right">实验内容：</td>
                                    <td><textarea name="textfield4" cols="60" rows="6" id="textfield4">熟悉中断发生时中断服务程序的执行过程；熟悉系统的中断向量表在内存中的位置、所占内存大小及所能存储的中断向量个数；掌握软中断服务程序的设计方法、中断向量的设置、保护和恢复现场。
                                    </textarea></td>
                                </tr>
                                <tr>
                                    <td align="right">备注信息：</td>
                                    <td><textarea name="textfield5" cols="60" rows="6" id="textfield5">课时：24&#13;学分：5
                                    </textarea></td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" style="margin-top:20px">
                                <tr>
                                    <td align="center"><input type="submit" value="保存"
                                                              onclick="javascript:location.href='curriculum'"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "1c");
                            dhxToolbar = dhxLayout.attachToolbar();
                            dhxToolbar.setIconsPath("/dhtmlx/dhtmlxToolbar/samples/dhtmlx/imgs/");
                            dhxToolbar.loadXML("common/toolbar.xml?" + new Date().getTime());
                            dhxToolbar.attachEvent("onClick", function (id) {
                                switch (id) {
                                    case 'save' :
                                        alert("保存当前数据!")
                                        break;
                                    case 'prev' :
                                        alert("已经是第一步!")
                                        break;
                                    case 'next' :
                                        window.location.href = 'listdate';
                                        break;
                                    default:
                                        alert("Button " + id + " was clicked!")
                                }
                            });
                            dhxLayout.cells("a").setText("创建预案");
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