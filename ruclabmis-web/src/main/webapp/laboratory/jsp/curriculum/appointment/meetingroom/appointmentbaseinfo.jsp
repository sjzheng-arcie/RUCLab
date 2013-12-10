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
        <td class="title">预约管理 -&gt; 会议室预约 -&gt; 会议室预约申请</td>
    </tr>
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_act" onclick="javascript:location.href='page02_hysyy_new.html'">预约基本信息
                                </td>
                                <td class="op_nor" onclick="javascript:location.href='page02_hysyy_rc.html'">预约日程</td>
                                <td class="op_nor" onclick="javascript:location.href='page02_hysyy_zx.html'">会议室申请</td>
                                <td class="op_nor" onclick="javascript:location.href='page02_hysyy_zy.html'">会议设备申请</td>
                                <td class="op_nor" onclick="javascript:location.href='page02_hysyy_yl.html'">预约信息提交</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="420">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto; display: none;">
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" style="margin-top:20px">
                                <tr>
                                    <td align="right" width="30%">会议名称：</td>
                                    <td width="70%"><input value="新系统上线启动会" type="text" name="textfield"
                                                           id="textfield"/></td>
                                </tr>
                                <tr>
                                    <td align="right">会议类型：</td>
                                    <td><select name="select" id="selectInstructor">
                                        <option>全体大会</option>
                                        <option>研讨会</option>
                                        <option>专题讨论会</option>
                                        <option>讲座</option>
                                        <option>综合</option>
                                    </select></td>
                                </tr>
                                <tr>
                                    <td align="right">会议内容：</td>
                                    <td><textarea name="textfield4" cols="60" rows="6" id="textfield4">新实验室管理系统上线启动会议，演示新系统特性，动员大家积极使用。
                                    </textarea></td>
                                </tr>
                                <tr>
                                    <td align="right">备注信息：</td>
                                    <td><textarea name="textfield5" cols="60" rows="6" id="textfield5">全体成员参加。
                                    </textarea></td>
                                </tr>
                            </table>
                        </div>

                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "1c");
                            dhxToolbar = dhxLayout.attachToolbar();
                            dhxToolbar.setIconsPath("../../common/dhtmlxToolbar/samples/common/imgs/");
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
                                        window.location.href = 'appointmentdate';
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