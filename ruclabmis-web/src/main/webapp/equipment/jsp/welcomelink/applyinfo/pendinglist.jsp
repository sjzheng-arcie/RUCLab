<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        var baseHref = '/equipment/jsp/welcomelink/myapplyinfo/searchpendinglist';
    </script>
</head>

<body onload="getwidth()" onresize="getwidth()">

<form name="listForm" method="post">
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="/equipment/images/mail_leftbg.gif"><img
                    src="/equipment/images/left-top-right.gif" width="17" height="29"/></td>
            <td valign="top" background="/equipment/images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">待审批申请</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="/equipment/images/mail_rightbg.gif"><img
                    src="/equipment/images/nav-right-bg.gif" width="16" height="29"/></td>
        </tr>

        <tr>
            <td valign="middle" background="/equipment/images/mail_leftbg.gif">&nbsp;</td>
            <td valign="top" bgcolor="#F7F8F9">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
                    <tr>
                        <td valign="top" class="STYLE10">

                            <span style="white-space:nowrap">&nbsp;&nbsp;申请编号:<input type="text" name="applyNo"
                                                                                     id="applyNo" value=""
                                                                                     style="width:100px;"/></span>
		<span style="white-space:nowrap">&nbsp;&nbsp;申请类型:<select id="formType" name="formType">
            <option value="0">请选择</option>
            <option value="21">报增申请</option>
            <option value="22">报减申请</option>
            <option value="23">借出申请</option>
            <option value="24">归还申请</option>

        </select></span>
                            <span style="white-space:nowrap">&nbsp;&nbsp;
                                <a href="javascript:void(0)" onclick="toFind('listForm');">
                                <img src="/equipment/images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>


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
                                                                                style="white-space:nowrap">设备转移申请列表</span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td>
                                                                <div align="right">
	            	<span class="STYLE1" style="white-space:nowrap">
						<a href="exameapply.html"><img src="/equipment/images/add_min.gif" width="10" height="10"
                                                       border="0"/> <span class="STYLE1">批准申请</span></a>&nbsp;
      					<a href="" onclick="toUpdate();"><img src="/equipment/images/edit_min.gif" width="10" height="10"
                                                              border="0"/> <span class="STYLE1">申请未通过</span></a>&nbsp;
      											<a href="apply.html"><img src="/equipment/images/add_min.gif" width="10"
                                                                          height="10" border="0"/> <span class="STYLE1">查看详细</span></a>&nbsp;
                        <a href="#" onclick="toRoom();"><img src="/equipment/images/del_min.gif" width="10" height="10"
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
                                            <table width="100%" class="table" id="table1" border="0" cellpadding="0"
                                                   cellspacing="1" bgcolor="#a8c7ce">
                                                <tr>
                                                    <td width="40" height="20" bgcolor="d3eaef" class="STYLE10">
                                                        <div align="center">
                                                            <input type="checkbox" name="checkbox" id="checkbox"
                                                                   onclick="checkAll(this);"/>
                                                        </div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">申请编号</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">申请类型</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">申请人</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">经办人</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">审批人</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">表单状态</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">提交时间</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">审批时间</span></div>
                                                    </td>

                                                </tr>
                                                <c:forEach items="${pageInfo.data}" var="item">
                                                     <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                        <td height="20"><input name="idcheckbox" type="checkbox"
                                                                               value="admin" onclick="checkOne(this)"/></td>

                                                            <td>${item.sn}</td>
                                                         <td>${item.formType.value}</td>
                                                         <td>${item.applicant.name}</td>
                                                         <td>${item.operator.name}</td>
                                                         <td>${item.approver.name}</td>
                                                         <td>${item.state.value}</td>
                                                         <td>  <fmt:formatDate  value="${item.applyTime}"></fmt:formatDate></td>
                                                         <td>$<fmt:formatDate  value="${item.processTime}"></fmt:formatDate></td>

                                                    </tr>
                                                </c:forEach>
                                                <tr height="16px"></tr>
                                            </table>
                                        </div>
                                    </td>
                                </tr>
                                <%@ include file="../../common/pagetable.jsp"%>

                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td background="/equipment/images/mail_rightbg.gif">&nbsp;</td>
        </tr>
        <tr>
            <td valign="bottom" background="/equipment/images/mail_leftbg.gif"><img src="/equipment/images/buttom_left2.gif"
                                                                                  width="17" height="17"/></td>
            <td valign="bottom" background="/equipment/images/buttom_bgs.gif"><img src="/equipment/images/buttom_bgs.gif"
                                                                                 width="100%" height="17"/></td>
            <td valign="bottom" background="/equipment/images/mail_rightbg.gif"><img
                    src="/equipment/images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>
