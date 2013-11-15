<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="/prototype/css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/util.js"></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        //var baseHref = '/prototype/jsp/experiment/virtual/list';
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="/prototype/images/mail_leftbg.gif"><img
                    src="/prototype/images/left-top-right.gif" width="17" height="29"/></td>
            <td valign="top" background="/prototype/images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">教学实验管理 > 虚拟班级</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="/prototype/images/mail_rightbg.gif"><img
                    src="/prototype/images/nav-right-bg.gif" width="16" height="29"/></td>
        </tr>

        <tr>
            <td valign="middle" background="/prototype/images/mail_leftbg.gif">&nbsp;</td>
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

                            <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);"
                                                                            style="cursor:hand"
                                                                            onclick="toFind('listForm')"><img
                                    src="/prototype/images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>


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
                                                                                    src="/prototype/images/tb.gif"
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
                                                                        <a href="/experiment/virtual/showAdd?page=1"><img
                                                                                src="/prototype/images/add_min.gif"
                                                                                width="10" height="10" border="0"/>
                                                                            <span class="STYLE1">新增</span></a>&nbsp;
                                                                        <a href="editclass.html"
                                                                           onclick="toUpdate();"><img
                                                                                src="/prototype/images/edit_min.gif"
                                                                                width="10" height="10"
                                                                                border="0"/> <span
                                                                                class="STYLE1">修改班级信息</span></a>&nbsp;

                                                                        <a href="#" onclick="toDelete();"><img
                                                                                src="/prototype/images/del_min.gif"
                                                                                width="10" height="10"
                                                                                border="0"/> <span
                                                                                class="STYLE1">删除</span></a>&nbsp;&nbsp;
                                                                        <a href="#" onclick="toHouseDy();"><img
                                                                                src="/prototype/images/del_min.gif"
                                                                                width="10" height="10"
                                                                                border="0"/> <span
                                                                                class="STYLE1">导入</span></a>&nbsp;&nbsp;
                                                                        <a href="#" onclick="toHouseLay();"><img
                                                                                src="/prototype/images/del_min.gif"
                                                                                width="10"
                                                                                height="10" border="0"/> <span
                                                                                class="STYLE1">导出</span></a>&nbsp;&nbsp;
                                                                        <a href="#" onclick="toRoom();"><img
                                                                                src="/prototype/images/del_min.gif"
                                                                                width="10" height="10"
                                                                                border="0"/> <span
                                                                                class="STYLE1">打印</span></a>&nbsp;&nbsp;
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
                                                        <div align="center"><span class="STYLE10">学生</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">编辑班级</span></div>
                                                    </td>

                                                </tr>

                                                <c:forEach items="${pageInfo.data}" var="item" varStatus="st">
                                                    <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                        <td height="20"><input name="idcheckbox" type="checkbox"
                                                                               value="${item.id}"
                                                                               onclick="checkOne('listForm', 'idcheckbox')"/>
                                                        </td>
                                                        <td>${st.index+1}</td>
                                                        <td>${item.classSn}</td>
                                                        <td>${item.className}</td>
                                                        <td>${item.curriculumName}</td>
                                                        <td>${item.classYear}</td>
                                                        <td>${item.teacherName}</td>
                                                        <td><a href="studentlist.html">查看</a> <a
                                                                href="studentlist.html">修改</a></td>
                                                        <td><a href="editclass.html"><input type="button"
                                                                                            onClick="editclass()"
                                                                                            class="button" value="编辑">
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
            <td background="/prototype/images/mail_rightbg.gif">&nbsp;</td>
        </tr>
        <tr>
            <td valign="bottom" background="/prototype/images/mail_leftbg.gif"><img
                    src="/prototype/images/buttom_left2.gif"
                    width="17" height="17"/></td>
            <td valign="bottom" background="/prototype/images/buttom_bgs.gif"><img
                    src="/prototype/images/buttom_bgs.gif"
                    width="100%" height="17"/></td>
            <td valign="bottom" background="/prototype/images/mail_rightbg.gif"><img
                    src="/prototype/images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>
