<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <title></title>
    <script>
        var baseHref = '/equipment/jsp/dev/borrow/deviceList';

        function toApply()
        {
            var id = "${param.application_id}";
            var selectedItems = getAllSelected('listForm', 'idcheckbox');
            if(selectedItems.length <= 0 )
            {
                alert("请选择要转移的设备！");
                return;
            }

            if( id != "") //有父窗体则刷新父窗体，关闭自己
            {
                document.forms["listForm"].action = "addEquipment?application_id="+id+"&items=" + selectedItems;
                document.forms["listForm"].submit();

                window.opener.location.href=window.opener.location.href;
                window.close();
            }
            else //无父窗体则跳转至表单页面
            {
                document.forms["listForm"].action = "toApply?items=" + selectedItems;
                document.forms["listForm"].submit();
            }

        }


    </script>
</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <input name="application_id" id="application_id" type="hidden" value="${application_id}">
        <tr>
            <td width="17" valign="top" background="/equipment/images/mail_leftbg.gif">
                <img src="/equipment/images/left-top-right.gif" width="17" height="29"/>
            </td>
            <td valign="top" background="/equipment/images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">设备借用管理 > 可借用设备</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="/equipment/images/mail_rightbg.gif">
                <img src="/equipment/images/nav-right-bg.gif" width="16" height="29"/>
            </td>
        </tr>

        <tr>
            <td valign="middle" background="/equipment/images/mail_leftbg.gif">&nbsp;</td>
            <td valign="top" bgcolor="#F7F8F9">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
                    <tr><td valign="top" class="STYLE10">
                        <span style="white-space:nowrap">&nbsp;&nbsp;设备编号:
                            <input type="text" name="searchSN" id="searchSN" value="${param.searchSN}" style="width:100px;"/>
                        </span>
                        <span style="white-space:nowrap">&nbsp;&nbsp;设备名称:
                            <input type="text" name="searchName"id="searchName" value="${param.searchName}" style="width:100px;"/>
                        </span>
                        <span style="white-space:nowrap">&nbsp;&nbsp;使用方向:
                            <select id="searchDirect" name="searchDirect">
                                <option value="0">全部</option>
                                <c:forEach items="${useDirections}" var="item">
                                    <option value="${item.id}"
                                            <c:if test="${item.id == param.searchDirect}"> selected</c:if>>${item.value}
                                    </option>
                                </c:forEach>
                            </select>
                        </span>
                        <span style="white-space:nowrap">&nbsp;&nbsp;
                            <a href="javascript:void(0);" style="cursor:hand" onclick="toFind('listForm');">
                                <img src="/equipment/images/zoom.png" width="15" height="15" border="0"/> 查询
                            </a>
                         </span>
                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td height="30">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td height="24" bgcolor="#353c44">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td>
                                                            <table width="100%" border="0" cellspacing="0"
                                                                   cellpadding="0">
                                                                <tr>
                                                                    <td width="6%" height="19" valign="bottom">
                                                                        <div align="center"><img
                                                                                src="/equipment/images/tb.gif"
                                                                                width="14" height="14"/></div>
                                                                    </td>
                                                                    <td width="94%" valign="bottom"><span
                                                                            class="STYLE1"
                                                                            style="white-space:nowrap">可借用设备信息列表</span>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                        <td>
                                                            <div align="right">
	            	<span class="STYLE1" style="white-space:nowrap">
						<a href="javascript:void(0);" onclick="toApply();return false;">
                            <img src="/equipment/images/add_min.gif" width="10" height="10" border="0"/>
                            <span class="STYLE1">申请转移</span>
                        </a>
	                </span>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <%@ include file="../../common/devicelist.jsp"%>

                        </table>
                    </td></tr>
                </table>
            </td>
            <td background="/equipment/images/mail_rightbg.gif">&nbsp;</td>
        </tr>
        <tr>
            <td valign="bottom" background="/equipment/images/mail_leftbg.gif">
                <img src="/equipment/images/buttom_left2.gif" width="17" height="17"/>
            </td>
            <td valign="bottom" background="/equipment/images/buttom_bgs.gif">
                <img src="/equipment/images/buttom_bgs.gif" width="100%" height="17"/>
            </td>
            <td valign="bottom" background="/equipment/images/mail_rightbg.gif">
                <img src="/equipment/images/buttom_right2.gif" width="16" height="17"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>