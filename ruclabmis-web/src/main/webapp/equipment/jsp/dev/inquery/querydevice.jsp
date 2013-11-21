<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script src="../../../../js/valid.js" type=text/javascript></script>
    <title>设备信息统计</title>

    <script>
    </script>
</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
<table width="98%" border="0" cellpadding="0" cellspacing="0">
<tr class="noprint">
    <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
            src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
    <td valign="top" background="../../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">设备信息查询 > 设备信息查询</div>
                </td>
            </tr>
        </table>
    </td>
    <td width="16" valign="top" background="../../../../images/mail_rightbg.gif"><img
            src="../../../../images/nav-right-bg.gif" width="16" height="29"/></td>
</tr>

<tr>
<td valign="middle" background="../../../../images/mail_leftbg.gif"></td>
<td valign="top" bgcolor="#F7F8F9">
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
<tr >
<td valign="top" class="STYLE10">
<div class="noprint" style="border: 1px solid;width:99%;">
    <table width="100%" border="0" cellpadding="0">
        <tr style="height: 30px;">
            <td align="center">设备编号</td>
            <td>
                <input name="sn" id="sn" onblur="" value="${searchEquipment.sn}" class="text"
                       style="width:154px" maxlength="20"
                       valid="isNumber"
                       errmsg="设备编号只能为数字"/>
            </td>
            <td align="center">设备名称</td>
            <td>
                <input name="name" id="name" onblur="" class="text"
                       value="${searchEquipment.name}"
                       style="width:154px" maxlength="20"/>
            </td>
            <td align="center">领用人</td>
            <td>
                <input name="holderName" id="holderName" onblur="" class="text"
                       value="${searchEquipment.holderName}"
                       style="width:154px" maxlength="20"/>
            </td>
        </tr>
        <tr style="height: 30px;">
            <td align="center">设备型号</td>
            <td>
                <input name="modelNumber" id="modelNumber" value="${searchEquipment.modelNumber}" onblur="" class="text"
                       style="width:154px" maxlength="20"
                       valid="isNumber"
                       errmsg="设备型号只能为数字"/>
            </td>
            <td align="center">设备规格</td>
            <td>
                <input name="specifications" id="specifications" value="${searchEquipment.specifications}" onblur="" class="text"
                       style="width:154px" maxlength="20"
                       valid="isNumber"
                       errmsg="设备规格只能为数字"/>
            </td>
            <td align="center">单价</td>
            <td>
                <input name="unitPrice" id="unitPrice" value="${searchEquipment.unitPrice}" onblur="" class="text"
                       style="width:154px" maxlength="20"
                       valid="required|isNumber"
                       errmsg="单价不能为空|单价只能为数字"/>
            </td>
        </tr>
        <tr style="height: 30px;">
            <td align="center">厂家</td>
            <td>
                <input name="vender" id="vender" value="${searchEquipment.vender}" onblur="" class="text"
                       style="width:154px" maxlength="20"/>
            </td>
            <td align="center">出厂号</td>
            <td>
                <input name="factoryNumber" id="factoryNumber" value="${searchEquipment.factoryNumber}" onblur="" class="text"
                       style="width:154px" maxlength="20"/>
            </td>
            <td align="center">国别</td>
            <td>
                <input name="country" id="country" value="${searchEquipment.country}" onblur="" class="text"
                       style="width:154px" maxlength="20"/>
            </td>
        <tr>
            <td nowrap align="center">设备状态</td>
            <td nowrap>
                <select name="stateId" id="stateId">
                    <option value="-1"> 所有 </option>
                    <c:forEach items="${states}" var="state">
                        <option value="${state.id}"
                                <c:if test="${state.id == searchEquipment.stateId}"> selected</c:if>>${state.value}
                        </option>
                    </c:forEach>
                </select>

            </td>
            <td nowrap align="center">经费科目</td>
            <td nowrap>
                <select name="fundingSubjectId" id="fundingSubjectId">
                    <option value="-1"> 所有 </option>
                    <c:forEach items="${fundingSubjects}" var="fundingSubject">
                        <option value="${fundingSubject.id}"
                                <c:if test="${fundingSubject.id == searchEquipment.fundingSubjectId}"> selected</c:if>>${fundingSubject.value}
                        </option>
                    </c:forEach>
                </select>
            </td>
            <td nowrap align="center">使用方向</td>
            <td nowrap>
                <select name="useDirectionId" id="useDirectionId">
                    <option value="-1"> 所有 </option>
                    <c:forEach items="${useDirections}" var="direction">
                        <option value="${direction.id}"
                                <c:if test="${direction.id == searchEquipment.useDirectionId}"> selected</c:if>>${direction.value}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr style="height: 30px;">
            <td align="center">分类</td>
            <td>
                <select name="categoryId" id="categoryId">
                    <option value="-1">所有</option>
                    <c:forEach items="${typecodes}" var="typeCode">
                        <option value="${typeCode.id}"
                                <c:if test="${typeCode.id == searchEquipment.categoryId}"> selected</c:if>>${typeCode.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="8" align="center">
                <input type="submit" value="查询" onclick="toFind('listForm');"></span>
            </td>
        </tr>
    </table>
</div>

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="30">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="24" bgcolor="#353c44">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td>
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="6%" height="19" valign="bottom">
                                                <div align="center"><img src="../../../../images/tb.gif" width="14"
                                                                         height="14"/></div>
                                            </td>
                                            <td width="94%" valign="bottom"><span class="STYLE1"
                                                                                  style="white-space:nowrap">设备信息列表</span>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <div align="right">
	            	<span class="STYLE1" style="white-space:nowrap">
<%--                        <a href="#" onclick="toHouseLay();"><img src="../../../../images/del_min.gif" width="10"
                                                                 height="10" border="0"/> <span class="STYLE1">导出</span></a>&nbsp;&nbsp;--%>
                        <a href="#" onclick="window.print()"><img src="../../../../images/del_min.gif" width="10" height="10"
                                                             border="0"/> <span class="STYLE1">打印</span></a>&nbsp;&nbsp;
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
                <table width="100%" class="table" id="table1" border="0" cellpadding="0" cellspacing="1"
                       bgcolor="#a8c7ce">
                    <tr>
                        <td width="80" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">仪器编号</span></div>
                        </td>
                        <td width="100" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">名称</span></div>
                        </td>
                        <td width="60" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">领用人</span></div>
                        </td>
                        <td width="60" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">使用人</span></div>
                        </td>
                        <td width="100" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">分类</span></div>
                        </td>
                        <td width="50" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">型号</span></div>
                        </td>
                        <td width="50" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">规格</span></div>
                        </td>
                        <td width="60" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">单价</span></div>
                        </td>
                        <td width="60" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">厂家</span></div>
                        </td>
                        <td width="60" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">出厂号</span></div>
                        </td>
                        <td width="60" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">出厂日期</span></div>
                        </td>
                        <td width="60" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">购置日期</span></div>
                        </td>
                        <td width="60" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">报废日期</span></div>
                        </td>
                        <td width="60" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">经费科目</span></div>
                        </td>
                        <td width="60" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">使用方向</span></div>
                        </td>
                        <td width="60" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">设备状态</span></div>
                        </td>
                    </tr>
                    <c:forEach items="${pageInfo.data}" var="item">
                        <tr bgcolor="#ffffff" align="center" class="STYLE19">
                            <td>${item.sn}</td>
                            <td>${item.name}</td>
                            <td>${item.holderName}</td>
                            <td>${item.user}</td>
                            <td>${item.categoryName}</td>
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

    <%@ include file="../../common/pagetable.jsp"%>

</table>

</td>
</tr>
</table>
</td>
<td background="../../../../images/mail_rightbg.gif"></td>
</tr>
<tr>
    <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img src="../../../../images/buttom_left2.gif"
                                                                          width="17" height="17"/></td>
    <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img src="../../../../images/buttom_bgs.gif"
                                                                         width="100%" height="17"/></td>
    <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img src="../../../../images/buttom_right2.gif"
                                                                           width="16" height="17"/></td>
</tr>
</table>
</form>
</body>
</html>
