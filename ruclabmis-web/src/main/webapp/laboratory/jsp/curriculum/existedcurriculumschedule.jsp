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
                                        <table width="100%" border="1" cellpadding="" cellspacing="0" style="bgcolor:#E3EFFF;font-size:25px;">
                                            <tr height="40">
                                                <td colspan="9" align="center" bgcolor="#e3efff"><strong>由于存在冲突，以下课表记录未能添加成功</strong></td>
                                            </tr>
                                            <tr align="center" height="40">
                                                <td width="12.5%" bgcolor="#E3EFFF">学年</td>
                                                <td width="12.5%" bgcolor="#E3EFFF">专业</td>
                                                <td width="12.5%" bgcolor="#E3EFFF">班级</td>
                                                <td width="12.5%" bgcolor="#E3EFFF">周次</td>
                                                <td width="12.5%" bgcolor="#E3EFFF">星期</td>
                                                <td width="12.5%" bgcolor="#E3EFFF">节次</td>
                                                <td width="12.5%" bgcolor="#E3EFFF">课程</td>
                                                <td width="12.5%" bgcolor="#E3EFFF">教师</td>

                                            </tr>
                                            <c:forEach items="${exsitedCurriculumScheduleList}" var="item">
                                                <tr>
                                                    <td align="center" bgcolor="#F7F7F7">${item.termYear.name}(${item.termYear.year})</td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.curriculum.major.name}</td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.curriculumClass.className}</td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.weeknum}</td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.weekdays}</td>
                                                    <td align="center" bgcolor="#F7F7F7">
                                                    <c:choose>
                                                        <c:when test="${item.amPm==1}">
                                                            上午 一、二节
                                                        </c:when>
                                                        <c:when test="${item.amPm==2}">
                                                            上午 三、四节
                                                        </c:when>
                                                        <c:when test="${item.amPm==3}">
                                                            下午 五、六节
                                                        </c:when>
                                                        <c:when test="${item.amPm==4}">
                                                            下午 七、八节
                                                        </c:when>
                                                        <c:when test="${item.amPm==5}">
                                                            晚上 九、十节
                                                        </c:when>
                                                    </c:choose>
                                                    </td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.curriculum.name}</td>
                                                    <td align="center" bgcolor="#F7F7F7">${item.curriculumClass.teacherName}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "1c");
                            dhxLayout.cells("a").setText("添加失败");
                            dhxLayout.cells("a").attachObject("zuoxi");
                        }</script>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
    <table width="100%" border="0" cellpadding="1" cellspacing="1" style="margin-top:20px">
        <tr>
            <td align="center"><input type="button" name="return" value="返回" class="button"
                                      onclick="window.history.go(-1);"/></td>
        </tr>
    </table>
</form>
</body>
</html>