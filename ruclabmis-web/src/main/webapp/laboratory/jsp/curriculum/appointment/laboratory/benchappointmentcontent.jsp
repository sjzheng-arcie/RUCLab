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
<script src="../../js/main.js" type="text/javascript"></script>
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
<link rel="stylesheet" type="text/css" href="../../common/dhtmlxWindows/codebase/dhtmlxwindows.css">
<link rel="stylesheet" type="text/css" href="../../common/dhtmlxWindows/codebase/skins/dhtmlxwindows_dhx_skyblue.css">
<script src="../../common/dhtmlxWindows/codebase/dhtmlxwindows.js"></script>

<body onload="doOnLoad();">
<div id="winVP" style="position:relative; padding:0px; margin:0px;">
<table width="100%" border="0" cellspacing="1" cellpadding="0">
<tr>
    <td width="16%" height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">A1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td width="16%" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">A2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td width="16%" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">A3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td width="16%" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">A4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td width="16%" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">A5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td width="16%" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">A6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">B1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">B2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">B3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">B4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">B5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">B6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">C1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">C2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">C3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">C4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">C5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">C6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">D1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">D2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">D3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">D4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">D5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">D6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">E1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">E2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">E3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">E4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">E5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">E6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">F1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">F2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">F3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">F4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">F5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">F6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">G1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">G2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">G3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">G4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">G5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">G6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">H1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">H2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">H3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">H4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">H5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">H6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">I1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">I2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">I3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">I4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">I5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">I6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">J1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">J2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">J3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">J4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">J5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">J6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">K1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">K2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">K3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">K4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">K5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">K6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">L1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">L2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">L3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">L4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">L5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">L6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">M1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">M2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">M3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">M4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">M5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">M6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <td height="75" bgcolor="#e4ffaa" style="cursor:hand" onclick="selectTable();">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">N1</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">N2</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">N3</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">N4</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">N5</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
    <td bgcolor="#e4ffaa" onclick="selectTable();" style="cursor:hand">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" align="center"><img src="../../images/ico/table.png" width="64" height="64" alt=""/>
                </td>
                <td><p><span class="title">N6</span><br/>
                    空闲</p></td>
            </tr>
        </table>
    </td>
</tr>
</table>
</div>
<div style="display:none">
    <div id="name_flt_box"><input type="text" style="width: 100%; border:1px solid gray;"
                                  onClick="(arguments[0]||window.event).cancelBubble=true;" onKeyUp="filterBy()"></div>
    <div id="fenju_flt_box"><select style="width:100%" onclick="(arguments[0]||window.event).cancelBubble=true;"
                                    onChange="filterBy()"></select></div>
    <div id="keshi_flt_box"><select style="width:100%" onclick="(arguments[0]||window.event).cancelBubble=true;"
                                    onChange="filterBy()"></select></div>
</div>
<input id="win_t" type="text" style="display:none" value="选择人员">
<script>
    var dhxWins, dhxToolbar, dhxGrid, dhxTree;
    function doOnLoad() {
        dhxWins = new dhtmlXWindows();
        dhxWins.enableAutoViewport(false);
        dhxWins.attachViewportTo("winVP");
        dhxWins.setImagePath("../../common/dhtmlxWindows/codebase/codebase/imgs/");
    }
    var idPrefix = 1;
    function selectTable() {
        window.location.href = 'page01_ylya_zx2_cont2.html';
    }
</script>
</body>
</html>