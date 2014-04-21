<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="/laboratory/../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/util.js"></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <script type="text/javascript" src="/js/autocomplete/jquery-1.9.1.js"></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        function editorClass(vcid) {
            window.location.href = "/experiment/virtual/editClass?vcId=" + vcid;
        }
        function deleteClasses(id) {
            var idsStr = "";
            if (id) {
                idsStr = id;
            } else {
                var ids = new Array();
                $.each($("input[name='idCheckbox']:checked"), function (idx, data) {
                    ids.push($(data).val());
                });
                idsStr = ids.join(",");
                console.log(idsStr);
            }
            if (idsStr && idsStr.length > 0 && window.confirm("您确定要删除指定的班级吗?")) {
                $.post("/experiment/virtual/removeClass", {
                    'ids': idsStr
                }, function (data) {
                    alert(data.message);
                    window.location.href = window.location.href;
                });
            }
        }
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">
<table border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td class="op_act" onclick="javascript:location.href='/experiment/virtual/listbycource?page=1&curriculumId='+${curriculumId}">虚拟班级管理</td>
        <td class="op_nor" onclick="javascript:location.href='/laboratory/jsp/experiment/experiment/listbycourse?page=1&view=experiment&curriculumId='+${curriculumId}">实验信息管理</td>
        <td class="op_nor" onclick="javascript:location.href='/laboratory/jsp/experiment/experiment/listbycourse?page=1&view=report&curriculumId='+${curriculumId}">实验报告管理</td>
        <td class="op_nor" onclick="javascript:location.href='/laboratory/jsp/experiment/experiment/listbycourse?page=1&view=achievement&curriculumId='+${curriculumId}">学期成绩评定</td>
    </tr>
</table>
<form name="listForm" method="post">
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="/laboratory/../images/mail_leftbg.gif"><img
                    src="/laboratory/../images/left-top-right.gif" width="17" height="29"/></td>
            <td valign="top" background="/laboratory/../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">实验教学管理 > 虚拟班级</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="/laboratory/../images/mail_rightbg.gif"><img
                    src="/laboratory/../images/nav-right-bg.gif" width="16" height="29"/></td>
        </tr>

        <tr>
            <td valign="middle" background="/laboratory/../images/mail_leftbg.gif">&nbsp;</td>
            <td valign="top" bgcolor="#F7F8F9">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
                    <tr>
                        <td valign="top" class="STYLE10">

                            <span style="white-space:nowrap">&nbsp;&nbsp;班级编号:<input type="text" name="sn"
                                                                                     id="sn" value=""
                                                                                     style="width:100px;"/></span>
                            <span style="white-space:nowrap">&nbsp;&nbsp;班级名称:<input type="text" name="name"
                                                                                     id="name" value=""
                                                                                     style="width:100px;"/></span>

                            <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);" class="txt_bt"
                                                                            style="cursor:hand"
                                                                            onclick="toFind('listForm')"><img
                                    src="/laboratory/../images/zoom.png" width="15" height="15" border="0"/>
                                查询</a></span>


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
                                                                                    src="/laboratory/../images/tb.gif"
                                                                                    width="14" height="14"/></div>
                                                                        </td>
                                                                        <td width="94%" valign="bottom"><span
                                                                                class="STYLE1"
                                                                                style="white-space:nowrap">虚拟班级列表</span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td>
                                                                <div align="right">
                                                                    <span class="STYLE1" style="white-space:nowrap">
                                                                        <a href="/experiment/virtual/showAdd?page=1" class="txt_bt"><img
                                                                                src="/laboratory/../images/add_min.gif"
                                                                                width="10" height="10" border="0"/>
                                                                            <span class="STYLE1">新增</span></a>&nbsp;
<%--                                                                        <a href="editclass.html"
                                                                           onclick="toUpdate();"><img
                                                                                src="/laboratory/../images/edit_min.gif"
                                                                                width="10" height="10"
                                                                                border="0"/> <span
                                                                                class="STYLE1">编辑</span></a>&nbsp;--%>

                                                                        <a href="#" onclick="deleteClasses();" class="txt_bt" ><img
                                                                                src="/laboratory/../images/del_min.gif"
                                                                                width="10" height="10"
                                                                                border="0"/> <span
                                                                                class="STYLE1">删除</span></a>&nbsp;&nbsp;
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
                                                                   onclick="checkAll(this,'listForm','idCheckbox');"/>
                                                        </div>
                                                    </td>
                                                    <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">序号</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">班级编号</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">班级名称</span></div>
                                                    </td>
                                                    <td width="150" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">课程名称</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">学年</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">任课老师</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">编辑班级</span></div>
                                                    </td>

                                                </tr>

                                                <c:forEach items="${pageInfo.data}" var="item" varStatus="st">
                                                    <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                        <td height="20"><input name="idCheckbox" type="checkbox"
                                                                               value="${item.id}"
                                                                               onclick="checkOne('listForm', 'idCheckbox')"/>
                                                        </td>
                                                        <td>${st.index+1}</td>
                                                        <td>${item.classSn}</td>
                                                        <td>${item.className}</td>
                                                        <td>${item.curriculumName}</td>
                                                        <td>${item.classYear}</td>
                                                        <td>${item.teacherName}</td>

                                                        <td>
                                                            <input type="button" onClick="editorClass(${item.id})"
                                                                   class="button"
                                                                   value="编辑"/>
                                                            <input type="button" onClick="deleteClasses('${item.id}')"
                                                                   class="button" value="删除"/>
                                                        </td>

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
            <td background="/laboratory/../images/mail_rightbg.gif">&nbsp;</td>
        </tr>
        <tr>
            <td valign="bottom" background="/laboratory/../images/mail_leftbg.gif"><img
                    src="/laboratory/../images/buttom_left2.gif"
                    width="17" height="17"/></td>
            <td valign="bottom" background="/laboratory/../images/buttom_bgs.gif"><img
                    src="/laboratory/../images/buttom_bgs.gif"
                    width="100%" height="17"/></td>
            <td valign="bottom" background="/laboratory/../images/mail_rightbg.gif"><img
                    src="/laboratory/../images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>
