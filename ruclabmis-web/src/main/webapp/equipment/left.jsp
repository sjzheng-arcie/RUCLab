<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>管理页面</title>

    <script src="../js/prototype.lite.js" type="text/javascript"></script>
    <script src="../js/moo.fx.js" type="text/javascript"></script>
    <script src="../js/moo.fx.pack.js" type="text/javascript"></script>
    <link href="css/left.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        //选择中标签变色
        var selectedid = null;
        function toFocus(id) {
            if (selectedid) {
                toBlur(selectedid);
            }
            selectedid = id;
            id.style.color = '#006600';
        }
        function toBlur(id) {
            id.style.color = '#000000';
        }
    </script>
</head>

<body>
<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#eef2fb">
<tr>
<td width="182" valign="top">
<div id="container">

<shiro:hasAnyRoles name="administrators,equipment_admin">
    <h1 class="type"><a href="javascript:void(0)">系统管理</a></h1>
    <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
            </tr>
        </table>
        <ul class="MM">
            <shiro:hasRole name="administrators">
                <li><a href="jsp/sys/user/list" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;用户管理</a>
                </li>
                <li><a href="jsp/sys/role/list.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;角色管理</a>
                </li>
                <li><a href="jsp/sys/permission/list.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;权限管理</a>
                </li>
            </shiro:hasRole>
            <li><a href="jsp/sys/typecode/list.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;分类及分类号</a>
            </li>
        </ul>
    </div>
</shiro:hasAnyRoles>

<shiro:hasAnyRoles name="administrators,equipment_admin">
    <h1 class="type"><a href="javascript:void(0)">设备库管理</a></h1>
    <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
            </tr>
        </table>
        <ul class="MM">
            <li><a href="jsp/dev/info/devicelist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备信息库管理</a>
            </li>
        </ul>
    </div>
</shiro:hasAnyRoles>

<h1 class="type"><a href="javascript:void(0)">验收管理</a></h1>

<div class="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
        </tr>
    </table>
    <ul class="MM">

        <li><a href="jsp/dev/store/list" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;我的设备入库申请</a>
        </li>

        <li><a href="jsp/dev/store/list" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备入库审批</a>
        </li>

    </ul>
</div>


<h1 class="type"><a href="javascript:void(0)">设备借用管理</a></h1>

<div class="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
        </tr>
    </table>
    <ul class="MM">
        <shiro:hasAnyRoles name="administrators,teacher,leader">
            <li><a href="jsp/dev/borrow/deviceList" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;可借用设备</a>
            </li>
        </shiro:hasAnyRoles>
        <shiro:hasAnyRoles name="administrators,teacher,leader">
            <li><a href="jsp/dev/borrow/applyList?formType=apply" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备借用申请</a>
            </li>
        </shiro:hasAnyRoles>
        <shiro:hasAnyRoles name="administrators,leader">
            <li><a href="jsp/dev/borrow/applyList?formType=review" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备借用审核</a>
            </li>
        </shiro:hasAnyRoles>
        <shiro:hasAnyRoles name="administrators,equipment_admin">
            <li><a href="jsp/dev/borrow/applyList?formType=process" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备借用执行</a>
            </li>
        </shiro:hasAnyRoles>
        <li><a href="jsp/dev/borrow/applyList?formType=history" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备借用历史</a>
        </li>
    </ul>
</div>

<h1 class="type"><a href="javascript:void(0)">设备归还管理</a></h1>

<div class="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
        </tr>
    </table>
    <ul class="MM">

        <li><a href="jsp/dev/return/myusingdevicelist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;我使用中的设备</a>
        </li>
        <li><a href="jsp/dev/return/myapplylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;我的设备归还申请</a>
        </li>

        <li><a href="jsp/dev/return/applylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备归还审核</a>
        </li>

    </ul>
</div>

<h1 class="type"><a href="javascript:void(0)">设备转移管理</a></h1>

<div class="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
        </tr>
    </table>
    <ul class="MM">

        <li><a href="jsp/dev/allot/myapplylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备转移申请</a>
        </li>
        <li><a href="jsp/dev/allot/leaderapplylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备转移审核</a>
        </li>
        <li><a href="jsp/dev/allot/adminapplylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备转移分配</a>
        </li>

    </ul>
</div>


<h1 class="type"><a href="javascript:void(0)">设备捐赠管理</a></h1>

<div class="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
        </tr>
    </table>
    <ul class="MM">
        <li><a href="jsp/dev/donate/myapplylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备捐赠申请</a>
        </li>
        <li><a href="jsp/dev/donate/leaderapplylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备捐赠审核</a>
        </li>
        <li><a href="jsp/dev/donate/adminapplylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备捐赠执行</a>
        </li>

    </ul>
</div>

<h1 class="type"><a href="javascript:void(0)">设备维修保养</a></h1>

<div class="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
        </tr>
    </table>
    <ul class="MM">
        <li><a href="jsp/dev/repair/myapplylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;我的设备维修申请</a>
        </li>
        <li><a href="jsp/dev/repair/applylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备维修审核</a>
        </li>
        <li><a href="jsp/dev/repair/upkeepapplylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备维修费申请</a>
        </li>
        <li><a href="jsp/dev/repair/upkeeplist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备维修费用审核</a>
        </li>
        <li><a href="jsp/dev/repair/resultlist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备维修结果</a>
        </li>
    </ul>
</div>

<h1 class="type"><a href="javascript:void(0)">设备报减销账</a></h1>

<div class="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
        </tr>
    </table>
    <ul class="MM">
        <li><a href="jsp/dev/deficit/myapplylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;我的设备报减申请</a>
        </li>
        <li><a href="jsp/dev/deficit/applylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备报废审核</a>
        </li>
    </ul>
</div>


<h1 class="type"><a href="javascript:void(0)">设备增减值</a></h1>

<div class="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
        </tr>
    </table>
    <ul class="MM">
        <li><a href="jsp/dev/value/myapplylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备增减值申请</a>
        </li>
        <li><a href="jsp/dev/value/applylist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备增减值审核</a>
        </li>
    </ul>
</div>
<h1 class="type"><a href="javascript:void(0)">固定资产盘点</a></h1>

<div class="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
        </tr>
    </table>
    <ul class="MM">
        <li><a href="jsp/dev/check/list.html" onfocus="toFocus(this)" target="main">
            &nbsp;&nbsp;&nbsp;&nbsp;固定资产盘点</a></li>

    </ul>
</div>

<h1 class="type"><a href="javascript:void(0)">信息查询</a></h1>

<div class="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5"/></td>
        </tr>
    </table>
    <ul class="MM">
        <li><a href="jsp/dev/inquery/devicelist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备统计查询</a>
        </li>
        <li><a href="jsp/dev/inquery/repairlist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备维修查询</a>
        </li>
        <li><a href="jsp/dev/inquery/allotlist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;设备转移查询</a>
        </li>
        <li><a href="jsp/dev/inquery/scraplist.html" onfocus="toFocus(this)" target="main">&nbsp;&nbsp;&nbsp;&nbsp;报废统计查询</a>
        </li>
    </ul>
</div>


</div>
<script type="text/javascript">
    var contents = document.getElementsByClassName('content');
    var toggles = document.getElementsByClassName('type');

    var myAccordion = new fx.Accordion(
            toggles, contents, {opacity: true, duration: 400}
    );
    myAccordion.showThisHideOpen(contents[0]);
    var windowHeight = document.documentElement.clientHeight;
    window.parent.document.getElementById("frame").rows = "2000,*";

</script>
</td>
</tr>
</table>
</body>
</html>