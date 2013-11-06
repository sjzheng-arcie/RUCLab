<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>

    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title></title>
    <script>
        var baseHref = '/equipment/jsp/dev/borrow/deviceList';

        function toApply()
        {
            var id = "${param.application_id}";
            var selectedItems = getAllSelected('listForm', 'idcheckbox');
            if(selectedItems.length <= 0 )
            {
                alert("请选择要申请的设备！");
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
                            <div class="titlebt">可申请设备</div>
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
                                                                            style="white-space:nowrap">可用设备信息列表</span>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                        <td>
                                                            <div align="right">
	            	<span class="STYLE1" style="white-space:nowrap">
						<a href="javascript:void(0);" onclick="toApply();return false;">
                            <img src="/equipment/images/add_min.gif" width="10" height="10" border="0"/>
                            <span class="STYLE1">申 请</span>
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
                            <tr>
                                <td>
                                    <div id="divwidth" style="overflow:auto;overflow-y:hidden;">
                                        <table width="100%" class="table" id="table1" border="0" cellpadding="0"
                                               cellspacing="1" bgcolor="#a8c7ce">
                                            <tr>
                                                <td width="40" height="20" bgcolor="d3eaef" class="STYLE10">
                                                    <div align="center">
                                                        <input type="checkbox" name="checkbox" id="checkbox"
                                                               onclick="checkAll(this,'listForm', 'idcheckbox');"/>
                                                    </div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">仪器编号</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">名称</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">分类号</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">型号</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">规格</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">单价</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">厂家</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">出厂号</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">出厂日期</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">购置日期</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">报废日期</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">经费科目</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">使用方向</span></div>
                                                </td>
                                                <td width="80" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">设备状态</span></div>
                                                </td>
                                            </tr>
                                            <c:forEach items="${pageInfo.data}" var="item">
                                                <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                    <td height="20"><input name="idcheckbox" type="checkbox"
                                                                           value="${item.id}" onclick="checkOne(this)"/></td>
                                                    <td>${item.sn}</td>
                                                    <td>${item.name}</td>
                                                    <td>${item.categoryId}</td>
                                                    <td>${item.modelNumber}</td>
                                                    <td>${item.specifications}</td>
                                                    <td>${item.unitPrice}</td>
                                                    <td>${item.vender}</td>
                                                    <td>${item.factoryNumber}</td>
                                                    <td><fmt:formatDate value="${item.manufactureDate}" pattern="yyyy-MM-dd"/></td>
                                                    <td><fmt:formatDate value="${item.acquisitionDate}" pattern="yyyy-MM-dd"/></td>
                                                    <td><fmt:formatDate value="${item.scrapDate}" pattern="yyyy-MM-dd"/></td>
                                                    <td>${item.fundingSubject}</td>
                                                    <td>${item.useDirection}</td>
                                                    <td>${item.state}</td>
                                                </tr>
                                            </c:forEach>
                                            <tr height="16px"></tr>
                                        </table>
                                    </div>
                                </td>
                            </tr>

                            <%@ include file="pagetable.jsp"%>

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
