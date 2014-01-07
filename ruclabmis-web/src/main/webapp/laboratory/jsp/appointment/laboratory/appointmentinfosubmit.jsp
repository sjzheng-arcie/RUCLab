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
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_nor" >预约基本信息</td>
                                <td class="op_nor" >预约日程</td>
                                <td class="op_nor" >实验室申请</td>
                                <td class="op_nor" >实验设备申请</td>
                                <td class="op_act" >预约信息提交</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="420">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto; display: none;">
                            <table width="100%" border="0" cellpadding="1" cellspacing="1">
                                <tr height="25">
                                    <td colspan="4" align="center" bgcolor="#e3efff"><strong>预约信息</strong></td>
                                </tr>
                                <tr height="25">
                                    <td width="15%" align="right" bgcolor="#e3efff">实验名称：</td>
                                    <td width="35%" bgcolor="#f7f7f7">软中断程序设计实验</td>
                                    <td width="15%" align="right" bgcolor="#e3efff">申请类型：</td>
                                    <td width="35%" bgcolor="#f7f7f7">实验室</td>
                                </tr>
                                <tr height="25">
                                    <td width="15%" align="right" bgcolor="#e3efff">课程名称：</td>
                                    <td width="35%" bgcolor="#f7f7f7">汇编语言程序设计</td>
                                    <td width="15%" align="right" bgcolor="#e3efff">实验类型：</td>
                                    <td width="35%" bgcolor="#f7f7f7">操作</td>
                                </tr>
                                <tr height="25">
                                    <td align="right" bgcolor="#e3efff">申请人：</td>
                                    <td bgcolor="#f7f7f7">高芳芳</td>
                                    <td align="right" bgcolor="#e3efff">申请日期：</td>
                                    <td bgcolor="#f7f7f7">2013-3-14</td>
                                </tr>
                                <tr height="25">
                                    <td align="right" bgcolor="#e3efff">预约时间：</td>
                                    <td bgcolor="#f7f7f7">2013-3-15 13:30:00 至 2013-3-18 11:30:00</td>
                                    <td align="right" bgcolor="#e3efff">预约实验室：</td>
                                    <td bgcolor="#f7f7f7">301</td>
                                </tr>
                                <tr height="25">
                                    <td align="right" bgcolor="#e3efff">实验内容：</td>
                                    <td colspan="3" bgcolor="#f7f7f7">
                                        熟悉中断发生时中断服务程序的执行过程；熟悉系统的中断向量表在内存中的位置、所占内存大小及所能存储的中断向量个数；掌握软中断服务程序的设计方法、中断向量的设置、保护和恢复现场。
                                    </td>
                                </tr>
                                <tr height="25">
                                    <td align="right" bgcolor="#e3efff">预约试验台：</td>
                                    <td colspan="3" bgcolor="#f7f7f7">A1 A2 A3 A4 A5 A6 B1 B4 B5 B6 C1 C2 C5 C6 D1 D2 D3
                                        D4 D6
                                    </td>
                                </tr>
                                <tr height="25">
                                    <td align="right" bgcolor="#e3efff">备注信息：</td>
                                    <td colspan="3" bgcolor="#f7f7f7">课时：24&#13;学分：5</td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1">
                                <tr height="25">
                                    <td colspan="4" align="center" bgcolor="#e3efff"><strong>预约设备</strong></td>
                                </tr>
                                <tr height="25">
                                    <td width="25%" bgcolor="#E3EFFF">设备名称</td>
                                    <td width="25%" bgcolor="#E3EFFF">设备类型</td>
                                    <td width="25%" bgcolor="#E3EFFF">库存数量</td>
                                    <td width="25%" bgcolor="#E3EFFF">预约数量</td>
                                </tr>
                                <tr height="25">
                                    <td bgcolor="#F7F7F7">联想 ThinkPad X220i</td>
                                    <td bgcolor="#F7F7F7">笔记本</td>
                                    <td bgcolor="#F7F7F7">6</td>
                                    <td bgcolor="#F7F7F7">3</td>
                                </tr>
                                <tr height="25">
                                    <td bgcolor="#F7F7F7">JIANWU-1646</td>
                                    <td bgcolor="#F7F7F7">交换机</td>
                                    <td bgcolor="#F7F7F7">4</td>
                                    <td bgcolor="#f7f7f7">1</td>
                                </tr>
                                <tr height="25">
                                    <td bgcolor="#F7F7F7">iPad2</td>
                                    <td bgcolor="#F7F7F7">移动终端</td>
                                    <td bgcolor="#F7F7F7">30</td>
                                    <td bgcolor="#f7f7f7">20</td>
                                </tr>
                                <tr height="25">
                                    <td bgcolor="#F7F7F7">iPad mini</td>
                                    <td bgcolor="#F7F7F7">移动终端</td>
                                    <td bgcolor="#F7F7F7">30</td>
                                    <td bgcolor="#f7f7f7">20</td>
                                </tr>
                            </table>
                        </div>
                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "1c");
                            dhxToolbar = dhxLayout.attachToolbar();
                            dhxToolbar.setIconsPath("/dhtmlx/dhtmlxToolbar/samples/common/imgs/");
                            dhxToolbar.loadXML("common/toolbar_fayl.xml?" + new Date().getTime());
                            dhxToolbar.attachEvent("onClick", function (id) {
                                switch (id) {
                                    case 'save' :
                                        alert("保存当前数据")
                                        break;
                                    case 'tijiao' :
                                        alert("方案已提交相关领导审批!")
                                        window.location.href = 'page01_ylya.html';
                                        break;
                                    case 'prev' :
                                        window.location.href = 'page01_ylya_zy.html';
                                        break;
                                    case 'next' :
                                        alert("已经到最后一步!")
                                        break;
                                    default:
                                        alert("Button " + id + " was clicked!")
                                }
                            });

                            dhxLayout.cells("a").setText("预案预览");
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