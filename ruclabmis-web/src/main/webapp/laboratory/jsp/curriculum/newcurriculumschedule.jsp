<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
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
        $("#curriculumClassId").chosen({
            no_results_text: "没有找到"
        });
        $("#termYearId").chosen({
            no_results_text: "没有找到"
        });
    });
    function roomDelete() {
        var src = window.event.srcElement;
        $(src).parent().next().remove();
        $(src).parent().remove();
        window.event.stopPropagation();
        $('#roomName').append(initRoomId());
    };
    function toReturn(){
        window.location.href = "curriculumclasslist?page=1";
    }
    function add(){
        var a = Number(document.getElementsByName("beginWeek"));
        var b =Number(document.getElementsByName("endWeek"));
        if(a >b){
            alert("结束周次不能早于开始周次！");
            return false;
        }
        var c = window.document.getElementById("roomId").value;
        if(c==null|| c==''){
            alert("请选择房间");
            return false;
        }
        document.mainForm.action="addcurriculumschedule";
        document.mainForm.submit();
    };
    function toSetLab(){
        var termYearIdTemp=window.document.getElementById("termYearId").value;
        var curriculumClassIdTemp=window.document.getElementById("curriculumClassId").value;
        var weekDayTemp=window.document.getElementById("weekDay").value;
        var beginWeekTemp=window.document.getElementById("beginWeek").value;
        var endWeekTemp=window.document.getElementById("endWeek").value;
        var sectionBeginTemp = window.document.getElementById("sectionBegin").value;
        var sectionEndTemp = window.document.getElementById("sectionEnd").value;

        window.open("toselectlab?termYearId="+termYearIdTemp+"&curriculumClassId="+curriculumClassIdTemp+"&weekDay="+weekDayTemp+
                "&beginWeek="+beginWeekTemp+"&endWeek="+endWeekTemp+"&sectionBegin="+sectionBeginTemp+"&sectionEnd="+sectionEndTemp, "人员信息",
                "height=450, width=800, toolbar=no, status=no");
    };
    function formatRoomDisplay(roomId,roomName) {

        return '<span>' + roomName+ '<input type="hidden" id="roomId" name="roomId" value=\"'+roomId+'\" /> <a class="button" href="#" roomId=\"' +roomId+ '\" onclick="roomDelete(event);">删除</a> </span><br/>';
    };
    function initRoomId() {

        return '<span><input type="hidden" id="roomId" name="roomId"  value=\"\"/> </span><br/>';
    };
    function setLab(roomId,roomName){
        window.document.getElementById('roomName').innerHTML = "";
       $('#roomName').append(formatRoomDisplay(roomId,roomName));

    };


    var endSection=[
        [1,2,3,4],[2,3,4],[3,4],[4],
        [5,6],[6],
        [7,8,9,10],[8,9,10],[9,10],[10],
        [11,12,13,14],[12,13,14],[13,14],[14]
    ]
;
    function setSectionEnd(){

        var begin=document.mainForm.sectionBegin;
        var end=document.mainForm.sectionEnd;
        end.innerHTML="";
        var selectEnd=endSection[begin.selectedIndex];
        for(var i=0;i<selectEnd.length;i++){
            end[i]=new Option(selectEnd[i],selectEnd[i]);
        }

    }
;
</script>

<body onload="doOnLoad();" style="background-color: #eef2fb">
<form name="mainForm" action="addcurriculumschedule" method="post">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0" >
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0"  cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_act" onclick="javascript:location.href='list'">创建课表信息</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr bgcolor="">
                    <td valign="top" height="500">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto;background-color: #e3efff">
                            <table width="100%" border="0" cellpadding="1" cellspacing="10" style="margin-top:20px;background-color:#e3efff ">
                                <tr>
                                    <td align="right">学期学年：</td>
                                    <td>
                                        <select id="termYearId" name="termYearId"
                                                style="width: 252px;height: 22px" valid="requierd" errmsg="请选择学年"
                                                data-placeholder="选择学年学期...">
                                            <c:forEach items="${termYearList}" var="termYear">
                                                <option value="${termYear.id}">${termYear.name}(${termYear.year}年)</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">班级：</td>
                                    <td>
                                        <select id="curriculumClassId" name="curriculumClassId"
                                                style="width: 252px;height: 22px"
                                                data-placeholder="选择班级...">
                                            <c:forEach items="${curriculumClassList}" var="curriculumClass">
                                                    <option value="${curriculumClass.id}">${curriculumClass.className}(${curriculumClass.teacherName})</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">星期：</td>
                                    <td>
                                        <select id="weekDay"name="weekDay">
                                            <option value="1">星期一</option>
                                            <option value="2">星期二</option>
                                            <option value="3">星期三</option>
                                            <option value="4">星期四</option>
                                            <option value="5">星期五</option>
                                            <option value="6">星期六</option>
                                            <option value="7">星期天</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">开始时间：</td>
                                    <td width="70%">第<select  id ="beginWeek"  name="beginWeek">
                                        <c:forEach var="temp" begin="1" end="26" step="1">
                                            <option value="${temp}">${temp}</option>
                                        </c:forEach>
                                    </select>周</td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">结束时间：</td>
                                    <td width="70%">第<select id="endWeek" name="endWeek">
                                        <c:forEach var="temp" begin="1" end="26" step="1">
                                            <option value="${temp}">${temp}</option>
                                        </c:forEach>
                                    </select>周</td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">节次：</td>
                                    <td>
                                        第<select name="sectionBegin"id="sectionBegin" onchange="setSectionEnd();">
                                            <c:forEach begin="1" end="14" step="1" var="item">
                                            <option value="${item}">${item}</option>
                                            </c:forEach>
                                        </select>
                                        节 - 第
                                        <select name="sectionEnd"id="sectionEnd" >
                                            <c:forEach begin="1" end="4" step="1" var="item">
                                                <option value="${item}">${item}</option>
                                            </c:forEach>
                                        </select>
                                        节
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right"><input type="button" onclick="toSetLab();" value="添加房间"/></td>
                                    <td>
                                        <div name="roomName" id="roomName">
                                            <input type="hidden" name="roomId" id="roomId" value=""/>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellpadding="1" cellspacing="1" style="margin-top:20px">
                                <tr>
                                    <td align="center">
                                        <input type="button" name="return" value="返回"
                                               onclick="toReturn();"/>
                                    </td>
                                    <td align="left">
                                        <input type="button" value="保存"onclick="add();"/>
                                    </td>
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
                            dhxLayout.cells("a").setText("创建课表信息");
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