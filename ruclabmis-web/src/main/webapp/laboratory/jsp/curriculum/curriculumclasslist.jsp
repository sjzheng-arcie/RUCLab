<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">

    <title></title>

</head>
<script type="text/javascript" src="../../../js/page.js"></script>
<link href="${pageContext.request.contextPath}/js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/chosen/chosen.jquery.min.js"></script>
<link href="/css/style.css" rel="stylesheet" type="text/css"/>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>

<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>

<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxToolbar/codebase/skins/dhtmlxtoolbar_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxToolbar/codebase/dhtmlxtoolbar.js"></script>
<script>
    $(document).ready(function () {
        $("#curriculumClassId").chosen({
            no_results_text: "没有找到"
        });
        $("#termYear").chosen({
            no_results_text: "没有找到"
        });

        $("#teacherId").chosen({
            no_results_text: "没有找到"
        });
        $("#roomId").chosen({
            no_results_text: "没有找到"
        });
    });


    function search(){
        document.mainForm.action="curriculumclasslist?page=1";
        document.mainForm.submit();
    }

</script>


<body onload="doOnLoad();" style="background-color: #eef2fb">
<form method="post" name="mainForm" action="curriculumclasslist">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0">
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_act" onclick="javascript:location.href='curriculumclasslist'">课程信息表一览</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="425">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto;">
                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td>
                                        <table width="100%" border="0" style="background-color:#E3EFFF;"   cellpadding="0" cellspacing="0">
                                            <tr height="25">
                                                <td  bgcolor="#E3EFFF" >学年：
                                                    <select id="termYear" name="termYearId"
                                                            style="width: 140px;height: 22px"
                                                            data-placeholder="选择学年学期...">
                                                        <option></option>
                                                        <c:forEach items="${termYearList}" var="termYear">

                                                            <option value="${termYear.id}">${termYear.name}(${termYear.year}年)</option>
                                                        </c:forEach>
                                                    </select></td>
                                                <td  bgcolor="#E3EFFF" >周次：
                                                    <select name="weekNum">
                                                        <option></option>
                                                        <c:forEach var="temp" begin="1" end="26" step="1">
                                                            <option value="${temp}">${temp}</option>
                                                        </c:forEach>
                                                    </select></td>
                                                <td  bgcolor="#E3EFFF" >老师：
                                                    <select id="teacherId" name="teacherId"
                                                            style="width: 140px;height: 22px"
                                                            data-placeholder="老师...">
                                                        <option></option>
                                                        <c:forEach items="${teacherList}" var="teacher">
                                                            <option value="${teacher.id}">${teacher.name}(${teacher.sn})</option>
                                                        </c:forEach>
                                                    </select></td>
                                                <td  bgcolor="#E3EFFF" >房间：
                                                    <select id="roomId" name="roomId"
                                                            style="width: 180px;height: 22px"
                                                            data-placeholder="房间...">
                                                        <option></option>
                                                        <c:forEach items="${roomList}" var="room">
                                                            <option value="${room.id}">${room.name}(${room.description})
                                                                <%--<c:choose>--%>
                                                                <%--<c:when test="${room.type==true}">--%>
                                                                    <%--(实验室)--%>
                                                                <%--</c:when>--%>
                                                                <%--<c:otherwise>--%>
                                                                    <%--(会议室)--%>
                                                                <%--</c:otherwise>--%>
                                                            <%--</c:choose>--%>
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                <td  bgcolor="#E3EFFF" >班级：
                                                    <select id="curriculumClassId" name="curriculumClassId"
                                                            style="width: 200px;height: 22px"
                                                            data-placeholder="选择班级...">
                                                        <option></option>
                                                        <c:forEach items="${curriculumClassList}" var="curriculumClass">
                                                            <option value="${curriculumClass.id}">${curriculumClass.className}(${curriculumClass.classSn})</option>
                                                        </c:forEach>
                                                    </select></td>
                                                <td width="20px" bgcolor="#E3EFFF" >
                                                    <input type="button"  value=" 查询"  onclick="search();" /></td>
                                            </tr>
                                        </table>
                                        <table width="100%" border="1" cellpadding="" cellspacing="0" style="bgcolor:#E3EFFF;font-size:25px;">
                                            <tr height="40">
                                                <td colspan="9" align="center" bgcolor="#e3efff"><strong>课表内容信息一览</strong></td>
                                            </tr>
                                            <tr align="center" height="40">
                                                <td width="12.5%" bgcolor="#E3EFFF">学年</td>

                                                <td width="12.5%" bgcolor="#E3EFFF">专业</td>

                                                <td width="12.5%" bgcolor="#E3EFFF">班级</td>
                                                <td width="12.5%" bgcolor="#E3EFFF">周次</td>
                                                <td width="12.5%" bgcolor="#E3EFFF">节次</td>
                                                <td width="12.5%" bgcolor="#E3EFFF">课程</td>
                                                <td width="12.5%" bgcolor="#E3EFFF">教师</td>

                                                <%--<td width="12.5%" bgcolor="#E3EFFF">安排实验室</td>--%>
                                                <td width="6.75%" bgcolor="#E3EFFF">修改</td>
                                                <td width="6.75%" bgcolor="#E3EFFF">删除</td>
                                            </tr>
                                            <c:forEach items="${pageInfo.data}" var="item">
                                                <tr>
                                                    <td align="center" bgcolor="#F7F7F7">${item.termYear.name}(${item.termYear.year})</td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.curriculum.major.name}</td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.curriculumClass.className}</td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.weeknum}</td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.sectionBegin} - ${item.sectionEnd}</td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.curriculum.name}</td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.curriculumClass.teacherName}</td>
                                                    <%--<td align="center" bgcolor="#F7F7F7" style="cursor:hand" ><a href="tosetlab?curriculumScheduleId=${item.id}">点击安排实验室  </a>--%>
                                                       <%--</td>--%>
                                                    <td align="center" bgcolor="#F7F7F7" style="cursor:hand" ><a href="toupdatecurriculumschedule?curriculumScheduleId=${item.id}">修改  </a>
                                                    </td>
                                                    <td align="center" bgcolor="#F7F7F7" style="cursor:hand" ><a href="deleteById?curriculumScheduleId=${item.id}">删除  </a>
                                                    </td>
                                                                                       </tr>
                                            </c:forEach>
                                        </table>
                                    </td>
                                </tr>
                                <%@ include file="../common/pagetableformessage.jsp" %>
                            </table>

                        </div>
                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "1c");
                            dhxToolbar = dhxLayout.attachToolbar();
                            dhxToolbar.setIconsPath("${pageContext.request.contextPath}/dhtmlx/dhtmlxToolbar/samples/common/imgs/");
                            dhxToolbar.loadXML("common/toolbar_fayl.xml?" + new Date().getTime());
                            dhxToolbar.attachEvent("onClick", function (id) {
                                switch (id) {
                                    case 'new' :
                                        window.location.href = 'newcurriculumschedule';
                                        break;
                                    case 'searchbyclassid' :
                                        window.location.href = 'toSearchByClassId';
                                        break;
                                    case 'searchbyteacher' :
                                        window.location.href = 'toSearchByTeacherId';
                                        break;
                                    case 'searchbyroom' :
                                        window.location.href = 'toSearchByRoomId';
                                        break;
                                    default:
                                        alert("Button " + id + " was clicked!")
                                }
                            });
                            dhxLayout.cells("a").setText("课表一览");
                            dhxLayout.cells("a").attachObject("zuoxi");
                        }</script>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</form>
</body>
</html>