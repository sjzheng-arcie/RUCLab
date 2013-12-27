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

<body onload="doOnLoad();"style="background-color: #eef2fb">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0">
<tr>
<td valign="top" height="100%">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
    <td height="27">
        <table border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td class="op_act" onclick="javascript:location.href='setlab'">安排实验室</td>
            </tr>
        </table>
    </td>
</tr>
<tr>
<td valign="top" height="490">
<div id="zuoxi" style="width: 100%; height: 100%; overflow: auto; display: none;">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr bgcolor="#E3EFFF">
        <td width="20%">楼栋:<input type="text"></td>
        <td width="20%">房间:<input type="text"></td>
        <td width="20%"><input type="button" value="搜索"></td>
        <td width="20%"></td>
        <td width="20%"></td>
    </tr>

</table>
<table width="100%" border="0" cellspacing="1" cellpadding="0">
<tr>
    <td width="25%" height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
        style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><p><img src="/images/door_open.png" width="64"
                                                       height="64"/><br/>
                    <span class="title">101</span></p></td>
                <td><p>空闲<br/>
                    <br/>
                    <br/>
                    <br/>
                </p></td>
            </tr>
        </table>
    </td>
    <td width="25%" height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
        style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">102</span></td>
                <td><p>空闲<br/>
                    <br/>
                    <br/>
                    <br/>
                </p></td>
            </tr>
        </table>
    </td>
    <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">103</span></td>
                <td><p>已占用<br/>
                    子网划分实验<br/>
                    张磊<br/>
                    2013-2-26 13:00:00 至 <br/>
                    2013-2-28 17:00:00</p></td>
            </tr>
        </table>
    </td>
    <td width="25%" height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
        style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">104</span></td>
                <td><p>空闲<br/>
                    <br/>
                    <br/>
                    <br/>
                </p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
        style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">201</span></td>
                <td><p>空闲<br/>
                    <br/>
                    <br/>
                    <br/>
                </p></td>
            </tr>
        </table>
    </td>
    <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">202</span></td>
                <td><p>已占用<br/>
                    继承与接口<br/>
                    周慧<br/>
                    2013-2-25 13:00:00 至<br/>
                    2013-2-28 17:00:00</p></td>
            </tr>
        </table>
    </td>
    <td height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
        style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">203</span></td>
                <td><p>空闲<br/>
                    <br/>
                    <br/>
                    <br/>
                </p></td>
            </tr>
        </table>
    </td>
    <td height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
        style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">204</span></td>
                <td><p> 空闲<br/>
                    <br/>
                    <br/>
                    <br/>
                </p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">301</span></td>
                <td><p>已占用<br/>
                    网络监听与端口扫描<br/>
                    方浩<br/>
                    2013-2-24 13:00:00至<br/>
                    2013-2-28 17:00:00</p></td>
            </tr>
        </table>
    </td>
    <td height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
        style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">302</span></td>
                <td><p>空闲<br/>
                    <br/>
                    <br/>
                    <br/>
                </p></td>
            </tr>
        </table>
    </td>
    <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">303</span></td>
                <td><p>已占用<br/>
                    8255A并行口实验 输出方波<br/>
                    郑名明<br/>
                    2013-2-27 13:00:00至<br/>
                    2013-2-28 17:00:00</p></td>
            </tr>
        </table>
    </td>
    <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">304</span></td>
                <td><p> 已占用<br/>
                    基于Servlet的MVC模式<br/>
                    周敏<br/>
                    2013-2-26 13:00:00至<br/>
                    2013-2-30 17:00:00</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">401</span></td>
                <td><p>已占用<br/>
                    了解Linux内核及内核模块<br/>
                    王伟<br/>
                    2013-2-24 13:00:00至<br/>
                    2013-2-28 17:00:00</p></td>
            </tr>
        </table>
    </td>
    <td height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
        style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">402</span></td>
                <td><p>空闲<br/>
                    <br/>
                    <br/>
                    <br/>
                </p></td>
            </tr>
        </table>
    </td>
    <td height="110" bgcolor="#E4FFAA" onclick="javascript:location.href='curriculumclasslist'"
        style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">403</span></td>
                <td><p>空闲<br/>
                    <br/>
                    <br/>
                    <br/>
                </p></td>
            </tr>
        </table>
    </td>
    <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                    height="64"/><br/>
                    <span class="title">404</span></td>
                <td><p> 已占用<br/>
                    汇编语言程序的调试与运行<br/>
                    吴敬力<br/>
                    2013-2-26 13:00:00至<br/>
                    2013-2-30 17:00:00</p></td>
            </tr>
        </table>
    </td>
</tr>

</table>
</div>
<div id="parentId"
     style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
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
</body>
</html>