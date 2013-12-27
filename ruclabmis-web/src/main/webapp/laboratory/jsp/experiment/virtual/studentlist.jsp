<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>学生列表</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/autocomplete/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/util.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/page.js"></script>
    <script>
        function addStudentToClass() {
            var idArr = new Array();
            $.each($("input[name='stCheckbox']:checked"), function (idx, data) {
                idArr.push($(data).val());
            });
            $.post("/experiment/virtual/addStudentToClass", {
                'vcId': $('#vcId').val(),
                'stIds': idArr.join(",")
            }, function (data) {
                if (data.success) {
                    window.opener.refresh();
                    window.close();
                } else {
                    alert(data.message);
                }
            });
        }

    </script>
</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
    <input type="hidden" name="vcId" id="vcId" value="${vcId}"/>
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="${pageContext.request.contextPath}/images/mail_leftbg.gif"><img
                    src="${pageContext.request.contextPath}/images/left-top-right.gif" width="17" height="29"/></td>
            <td valign="top" background="${pageContext.request.contextPath}/images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">基础信息管理 > 学生信息管理</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="${pageContext.request.contextPath}/images/mail_rightbg.gif"><img
                    src="${pageContext.request.contextPath}/images/nav-right-bg.gif" width="16" height="29"/></td>
        </tr>

        <tr>
            <td valign="middle" background="${pageContext.request.contextPath}/images/mail_leftbg.gif">&nbsp;</td>
            <td valign="top" bgcolor="#F7F8F9">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
                    <tr>
                        <td valign="top" class="STYLE10">
                    <span style="white-space:nowrap">&nbsp;&nbsp;学号:<input type="text" name="sn" id="sn"
                                                                           value="" style="width:100px;"/></span>

                    <span style="white-space:nowrap">&nbsp;&nbsp;名称:<input type="text" name="name" id="name"
                                                                           value="" style="width:100px;"/></span>

                    <span style="white-space:nowrap">&nbsp;&nbsp;所属专业:<input type="text" name="major"
                                                                             id="major" value=""
                                                                             style="width:100px;"/></span>
                    <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);"
                                                                    style="cursor:hand"
                                                                    onclick="toFind('listForm')"><img
                            src="${pageContext.request.contextPath}/images/zoom.png" width="15" height="15"
                            border="0"/> 查询</a></span>
                    <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);" class="txt_bt" style="cursor:hand"
                                                                    onclick="addStudentToClass();"><img
                            src="/laboratory/../images/add_min.gif" width="15" height="15" border="0"/>
                        添加学生</a></span>


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
                                                                                    src="${pageContext.request.contextPath}/images/tb.gif"
                                                                                    width="14" height="14"/></div>
                                                                        </td>
                                                                        <td width="94%" valign="bottom"><span
                                                                                class="STYLE1"
                                                                                style="white-space:nowrap">学生信息列表</span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
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
                                                                   onclick="checkAll(this,'listForm','stCheckbox');"/>
                                                        </div>
                                                    </td>
                                                    <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">序号</span></div>
                                                    </td>
                                                    <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">学号</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">学生姓名</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">专业</span></div>
                                                    </td>
                                                    <td width="150" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">入学日期</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">籍贯</span></div>
                                                    </td>
                                                </tr>
                                                <c:forEach items="${pageInfo.data}" var="item" varStatus="stIdx">
                                                    <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                        <td height="20"><input name="stCheckbox" type="checkbox"
                                                                               value="${item.id}"
                                                                               onclick="checkOne('listForm', 'stCheckbox')"/>
                                                        </td>
                                                        <td>${stIdx.index+1}</td>
                                                        <td>${item.sn}</td>
                                                        <td>${item.name}</td>
                                                        <td>${item.majorName}</td>
                                                        <td><fmt:formatDate value="${item.admissionDate}"
                                                                            pattern="yyyy-MM-dd"/></td>
                                                        <td>${item.originPlace}</td>
                                                    </tr>
                                                </c:forEach>
                                                <tr height="16px"></tr>
                                            </table>
                                        </div>
                                    </td>
                                </tr>
                                <%@ include file="../../common/pagetable.jsp" %>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td background="${pageContext.request.contextPath}/images/mail_rightbg.gif">&nbsp;</td>
        </tr>
        <tr>
            <td valign="bottom" background="${pageContext.request.contextPath}/images/mail_leftbg.gif"><img
                    src="${pageContext.request.contextPath}/images/buttom_left2.gif"
                    width="17" height="17"/></td>
            <td valign="bottom" background="${pageContext.request.contextPath}/images/buttom_bgs.gif"><img
                    src="${pageContext.request.contextPath}/images/buttom_bgs.gif"
                    width="100%" height="17"/></td>
            <td valign="bottom" background="${pageContext.request.contextPath}/images/mail_rightbg.gif"><img
                    src="${pageContext.request.contextPath}/images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>
