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
<script src="../../../../dhtmlx/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="../../../../dhtmlx/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>

<link rel="stylesheet" type="text/css" href="../../../../dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="../../../../dhtmlx/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="../../../../dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>

<link rel="stylesheet" type="text/css" href="../../../../dhtmlx/dhtmlxToolbar/codebase/skins/dhtmlxtoolbar_dhx_skyblue.css">
<script src="../../../../dhtmlx/dhtmlxToolbar/codebase/dhtmlxtoolbar.js"></script>

<link rel="stylesheet" type="text/css" href="../../../../dhtmlx/dhtmlxTree/codebase/dhtmlxtree.css">
<script src="../../../../dhtmlx/dhtmlxTree/codebase/dhtmlxtree.js"></script>

<link rel="stylesheet" type="text/css" href="../../../../dhtmlx/dhtmlxGrid/codebase/dhtmlxgrid.css">
<link rel="stylesheet" type="text/css" href="../../../../dhtmlx/dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_skyblue.css">
<script src="../../../../dhtmlx/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>
<script src="../../../../dhtmlx/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>

<link rel="stylesheet" type="text/css" href="../../../../dhtmlx/dhtmlxEditor/codebase/skins/dhtmlxeditor_dhx_skyblue.css">
<script src="../../../../dhtmlx/dhtmlxEditor/codebase/dhtmlxeditor.js"></script>

<body onload="doOnLoad();">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0">
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_act" >预约基本信息</td>
                                <td class="op_nor" curor="pointer" onclick="javascript:location.href='laboratoryapply'" >房间申请</td>
                                  <td class="op_nor"  onclick="javascript:location.href='appointmentinfosubmit'" >预约信息提交</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="420">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto; display: none;">
                            <table width="100%" border="0" cellpadding="1" cellspacing="1">
                                <tr height="25">
                                    <td colspan="4" align="center" bgcolor="#e3efff"><strong>填写预约申请基本信息</strong></td>
                                </tr>

                                <tr>
                                    <td  width="15%" align="right" bgcolor="#e3efff">学期学年：</td>
                                    <td  width="35%" >
                                        <select id="termYear" name="termYearId"
                                                style="width: 252px;height: 22px"
                                                data-placeholder="选择学年学期...">
                                            <c:forEach items="${termYearList}" var="termYear">
                                                <option value="${termYear.id}">${termYear.name}(${termYear.year}年)</option>
                                            </c:forEach>
                                        </select>
                                    </td>


                                </tr>
                                <tr>
                                    <td width="15%"  align="right" bgcolor="#e3efff">第几周：</td>
                                    <td width="35%"><select name="endWeek">
                                        <c:set var="weekNum" value="22"></c:set>
                                        <c:forEach begin="0" end ="22" var="i">
                                            <option value="i">${i}</option>
                                        </c:forEach>
                                    </select></td>
                                </tr>

                                <tr>
                                    <td  width="15%"  align="right" bgcolor="#e3efff">星期：</td>
                                    <td width="35%">
                                        <select name="weekDay">
                                            <option value="1">星期一</option>
                                            <option value="2">星期二</option>
                                            <option value="3">星期三</option>
                                            <option value="4">星期四</option>
                                            <option value="5">星期五</option>
                                            <option value="6">星期六</option>
                                            <option value="7">星期日</option>
                                        </select>
                                    </td>



                                </tr>
                                <tr>
                                    <td  align="right" bgcolor="#e3efff" width="15%">时间段：</td>
                                    <td width="35%">
                                        <select name="classSection">
                                            <option value="1">上午一二节</option>
                                            <option value="2" >上午三四节</option>
                                            <option value="3">下午五六节</option>
                                            <option value="4">下午七八节</option>
                                            <option value="5">晚上九十节</option>
                                        </select>
                                    </td>
                                </tr>
                                  <tr>
                                    <td align="right"  align="right" bgcolor="#e3efff">申请类型：</td>
                                    <td><select name="select" id="selectType">
                                        <option value= "0">实验室</option>
                                        <option value= "1">会议室</option>
                                        <option>工位</option>
                                    </select></td>
                                </tr>
                                <tr>
                                    <td align="right"  align="right" bgcolor="#e3efff">申请内容描述：</td>
                                    <td><textarea name="textfield4" cols="60" rows="6" id="textfield4">熟悉中断发生时中断服务程序的执行过程；熟悉系统的中断向量表在内存中的位置、所占内存大小及所能存储的中断向量个数；掌握软中断服务程序的设计方法、中断向量的设置、保护和恢复现场。
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
                            dhxToolbar.setIconsPath("../../../../dhtmlx/dhtmlxToolbar/samples/common/imgs/");
                            dhxToolbar.loadXML("common/toolbar.xml?" + new Date().getTime());
                            dhxToolbar.attachEvent("onClick", function (id) {
                                switch (id) {
                                    case 'save' :
                                        alert("保存当前数据!");
                                        break;
                                    case 'prev' :
                                        alert("已经是第一步!");
                                        break;
                                    case 'next' :
                                        window.location.href = 'laboratoryapply';
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