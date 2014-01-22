<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <title></title>
</head>
<link href="../../../css/style.css" rel="stylesheet" type="text/css"/>

<script src="../../../../dhtmlx/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="../../../../dhtmlx/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>

<link rel="stylesheet" type="text/css" href="../../../../dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="../../../../dhtmlx/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="../../../../dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>


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


                            <div id="parentId"
                                 style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                            <script>

                                var dhxLayout;
                                function doOnLoad() {
                                    dhxLayout = new dhtmlXLayoutObject("parentId", "2U");

                                    dhxLayout.cells("a").setText("预约信息");
                                    dhxLayout.cells("a").attachURL("appointmentbaseinfo.jsp");

                                    dhxLayout.cells("b").setText("房间情况");
                                    dhxLayout.cells("b").attachURL("page01_ylya_zx2_cont.html");
                                }

                            </script>
                            </tr>

                    </td>
                </tr>
            </table>
</table>
</body>
</html>