<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title></title>
</head>
<link href="/css/style.css" rel="stylesheet" type="text/css"/>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxToolbar/codebase/skins/dhtmlxtoolbar_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxToolbar/codebase/dhtmlxtoolbar.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxTree/codebase/dhtmlxtree.css">
<script src="/dhtmlx/dhtmlxTree/codebase/dhtmlxtree.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxGrid/codebase/dhtmlxgrid.css">
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>
<script src="/dhtmlx/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxEditor/codebase/skins/dhtmlxeditor_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxEditor/codebase/dhtmlxeditor.js"></script>
<script type="text/javascript" src="../../../js/page.js"></script>
<link href="${pageContext.request.contextPath}/js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/chosen/chosen.jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $("#termYearId").chosen({
            no_results_text: "没有找到"
        });
        $("#curriculumClassId").chosen({
            no_results_text: "没有找到"
        });
    });
    function search(){
        document.mainForm.action="allcurriculumschedule";
        document.mainForm.submit();
    }
</script>

<body onload="doOnLoad();"style="background-color: #eef2fb">
<form name="mainForm" method="post" action="allcurriculumschedule">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0">
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_act" onclick="javascript:location.href='mycurriculumschedule'">课表信息
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="580">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto; ">
                            <table style="background-color: #E3EFFF;"cellpadding="0"cellspacing="0" width="100%" >
                                <tr>
                                    <td  bgcolor="#E3EFFF" >学年：
                                        <select id="termYearId" name="termYearId"
                                                style="width: 200px;height: 22px"
                                                data-placeholder="选择学年学期...">
                                            <c:forEach items="${termYearList}" var="termYear">
                                                <option <c:if test="${termYearInfo.id==termYear.id}"> selected </c:if> value="${termYear.id}">${termYear.name}(${termYear.year}年)</option>
                                            </c:forEach>
                                        </select></td>
                                    <td  bgcolor="#E3EFFF" >班级：
                                        <select id="curriculumClassId" name="curriculumClassId"
                                                style="width: 200px;height: 22px"
                                                data-placeholder="选择班级...">
                                            <c:forEach items="${curriculumClassList}" var="curriculumClass">
                                                <option  <c:if test="${classInfo.id==curriculumClass.id}">selected</c:if> value="${curriculumClass.id}">${curriculumClass.className}(${curriculumClass.teacherName})</option>
                                            </c:forEach>
                                        </select></td>
                                    <td  bgcolor="#E3EFFF" >
                                        <input type="button"  value=" 查询"  onclick="search();" /></td>
                                </tr>
                            </table>
                            <table width="100%" border="1" cellpadding="1" cellspacing="0">
                                <tr height="25">
                                    <td colspan="9" align="center" bgcolor="#e3efff"><strong>${curriculumScheduleTitle}</strong></td>
                                </tr>
                                <tr height="25" align="center">

                                    <td width="6.75%" bgcolor="#E3EFFF"></td>
                                    <td width="6.75%" bgcolor="#E3EFFF">节次</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">周一</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">周二</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">周三</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">周四</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">周五</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">周六</td>
                                    <td width="12.5%" bgcolor="#E3EFFF">周天</td>

                                </tr>
                                <tr height="100" align="center">
                                    <td bgcolor="#F7F7F7" >上午</td>
                                    <td bgcolor="#F7F7F7">一、二节(8:00-9:30)<br>三、四节(10:00-11:30)</td>
                                    <c:forEach items="${strCurriculumScheduleListStr}" var="str" begin="0" end="6" >
                                        <td bgcolor="#F7F7F7">
                                            <c:forEach items="${str}" var="item">
                                                ${item}<br/>
                                            </c:forEach>

                                        </td>
                                    </c:forEach>
                                </tr>
                                <tr height="100" align="center">
                                    <td bgcolor="#F7F7F7" >中午</td>
                                    <td bgcolor="#F7F7F7">五、六节(12:00-13:30)</td>
                                    <td bgcolor="#F7F7F7"></td>
                                    <c:forEach items="${strCurriculumScheduleListStr}" var="str" begin="7" end="13" >
                                        <td bgcolor="#F7F7F7">
                                            <c:forEach items="${str}" var="item">
                                                ${item}<br/>
                                            </c:forEach>

                                        </td>
                                    </c:forEach>
                                </tr>
                                <tr height="100" align="center">
                                    <td bgcolor="#F7F7F7" >下午</td>
                                    <td bgcolor="#F7F7F7">七、八节(14:00-15:30)九、十节(16:00-17:30)</td>
                                    <c:forEach items="${strCurriculumScheduleListStr}" var="str" begin="14" end="20" >
                                        <td bgcolor="#F7F7F7">
                                            <c:forEach items="${str}" var="item">
                                                ${item}<br/>
                                            </c:forEach>

                                        </td>
                                    </c:forEach>
                                </tr>

                                <tr height="100" align="center">
                                    <td bgcolor="#F7F7F7">晚上</td>
                                    <td bgcolor="#F7F7F7">十一至十四节(18:00-21:00)</td>
                                    <c:forEach items="${strCurriculumScheduleListStr}" var="str" begin="21" end="27" >
                                        <td bgcolor="#F7F7F7">
                                            <c:forEach items="${str}" var="item">
                                                ${item}<br/>
                                            </c:forEach>

                                        </td>
                                    </c:forEach>
                                </tr>
                            </table>

                        </div>


                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "1c");
                            dhxToolbar = dhxLayout.attachToolbar();
                            dhxToolbar.setIconsPath("${pageContext.request.contextPath}/dhtmlx/dhtmlxToolbar/samples/common/imgs/");
                            dhxToolbar.loadXML("common/toolbar_back.xml?" + new Date().getTime());
                            dhxToolbar.setAlign("right");
                            dhxToolbar.attachEvent("onClick", function (id) {
                                switch (id) {
                                    case 'back' :
                                        window.location.href = 'curriculumclasslist?page=1';
                                        break;
                                    default:
                                        alert("Button " + id + " was clicked!")
                                }
                            });
                            dhxLayout.cells("a").setText("课表信息");
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