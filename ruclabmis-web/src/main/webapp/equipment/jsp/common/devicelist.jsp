<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="../../../../js/page.js"></script>
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

