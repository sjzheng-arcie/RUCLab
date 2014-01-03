<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <title></title>
</head>
<link href="${pageContext.request.contextPath}/js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/chosen/chosen.jquery.min.js"></script>
<link href="/css/style.css" rel="stylesheet" type="text/css"/>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>

<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="/dhtmlx/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="/dhtmlx/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>








<script>


    $(document).ready(function () {
        $("#target").chosen({
            no_results_text: "没有找到"
        });
        $("#termYear").chosen({
            no_results_text: "没有找到"
        });
    });
</script>
<body onload="doOnLoad();">
<form action="addcurriculumschedule" method="post">
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0">
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" bgcolor="#E3EFFF" cellpadding="0">
                <tr>
                    <td height="27">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td class="op_act" onclick="javascript:location.href='list'">创建课表信息</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top" height="500">
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto;bgcolor:#E3EFFF;">

                            <table width="100%" border="0" cellpadding="1" bgcolor="#E3EFFF"cellspacing="1" style="margin-top:20px">

                                <tr>
                                    <td align="right">学期学年：</td>
                                    <td>
                                        <select id="termYear" name="termYearId"
                                                style="width: 252px;height: 22px"
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
                                        <select id="target" name="curriculumClassId"
                                                style="width: 252px;height: 22px"
                                                data-placeholder="选择班级...">
                                            <c:forEach items="${curriculumClassList}" var="curriculumClass">
                                                    <option value="${curriculumClass.id}">${curriculumClass.className}(${curriculumClass.classSn})</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">星期：</td>
                                    <td>
                                        <select name="weekDay">
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
                                    <td align="right" width="30%">节次：</td>
                                    <td>
                                        <select name="classSection">
                                            <option value="1">上午一二节</option>
                                            <option value="2" >上午三四节</option>
                                            <option value="3">下午五六节</option>
                                            <option value="4">下午七八节</option>
                                            <option value="5">晚上九十节</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">开始时间：</td>
                                    <td width="70%">第<select name="beginWeek">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                        <option value="13">13</option>
                                        <option value="14">14</option>
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                        <option value="21">21</option>
                                        <option value="22">22</option>
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="25">25</option>
                                        <option value="26">26</option>
                                    </select>周</td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">结束时间：</td>
                                    <td width="70%">第<select name="endWeek">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                        <option value="13">13</option>
                                        <option value="14">14</option>
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                        <option value="21">21</option>
                                        <option value="22">22</option>
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="25">25</option>
                                        <option value="26">26</option>
                                    </select>周</td>
                                </tr>
                            </table>

                            <table width="100%" border="0" cellspacing="0" bgcolor="#E3EFFF" cellpadding="0">
                                <tr bgcolor="#E3EFFF">
                                    <td width="20%">楼栋:<input type="text"></td>
                                    <td width="20%">房间:<input type="text"></td>
                                    <td width="20%"><input type="button" value="搜索"></td>
                                    <td width="20%"></td>
                                    <td width="20%"></td>
                                </tr>

                            </table>
                            <table width="100%" border="0" cellspacing="1" cellpadding="0">
                            <tr>
                                <td width="25%" height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
                                    style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><p><img src="/images/door_open.png" width="64"
                                                                                   height="64"/><br/>
                                                <span class="title">101</span></p></td>
                                            <td><p>空闲<br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                            </p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td width="25%" height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
                                    style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">102</span></td>
                                            <td><p>空闲<br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                            </p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">103</span></td>
                                            <td><p>已占用<br/>
                                                子网划分实验<br/>
                                                张磊<br/>
                                                2013-2-26 13:00:00 至 <br/>
                                                2013-2-28 17:00:00</p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td width="25%" height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
                                    style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">104</span></td>
                                            <td><p>空闲<br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                            </p></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
                                    style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">201</span></td>
                                            <td><p>空闲<br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                            </p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">202</span></td>
                                            <td><p>已占用<br/>
                                                继承与接口<br/>
                                                周慧<br/>
                                                2013-2-25 13:00:00 至<br/>
                                                2013-2-28 17:00:00</p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
                                    style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">203</span></td>
                                            <td><p>空闲<br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                            </p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
                                    style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">204</span></td>
                                            <td><p> 空闲<br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                            </p></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">301</span></td>
                                            <td><p>已占用<br/>
                                                网络监听与端口扫描<br/>
                                                方浩<br/>
                                                2013-2-24 13:00:00至<br/>
                                                2013-2-28 17:00:00</p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
                                    style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">302</span></td>
                                            <td><p>空闲<br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                            </p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">303</span></td>
                                            <td><p>已占用<br/>
                                                8255A并行口实验 输出方波<br/>
                                                郑名明<br/>
                                                2013-2-27 13:00:00至<br/>
                                                2013-2-28 17:00:00</p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">304</span></td>
                                            <td><p> 已占用<br/>
                                                基于Servlet的MVC模式<br/>
                                                周敏<br/>
                                                2013-2-26 13:00:00至<br/>
                                                2013-2-30 17:00:00</p></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">401</span></td>
                                            <td><p>已占用<br/>
                                                了解Linux内核及内核模块<br/>
                                                王伟<br/>
                                                2013-2-24 13:00:00至<br/>
                                                2013-2-28 17:00:00</p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td height="110" bgcolor="#e4ffaa" onclick="javascript:location.href='curriculumclasslist'"
                                    style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">402</span></td>
                                            <td><p>空闲<br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                            </p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td height="110" bgcolor="#E4FFAA" onclick="javascript:location.href='curriculumclasslist'"
                                    style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door_open.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">403</span></td>
                                            <td><p>空闲<br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                            </p></td>
                                        </tr>
                                    </table>
                                </td>
                                <td height="110" bgcolor="#aae4ff" onclick="javascript:alert('当前教室已被占用!')" style="cursor:hand;">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td width="40%" align="center"><img src="/images/door.png" width="64"
                                                                                height="64"/><br/>
                                                <span class="title">404</span></td>
                                            <td><p> 已占用<br/>
                                                汇编语言程序的调试与运行<br/>
                                                吴敬力<br/>
                                                2013-2-26 13:00:00至<br/>
                                                2013-2-30 17:00:00</p></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>

                            </table>



                            <table width="100%" border="0" cellpadding="1" cellspacing="1" style="margin-top:20px">
                                <tr>
                                    <td align="center"><input type="submit" value="保存"
                                                              onclick="javascript:location.href='curriculumclasslist'"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="parentId"
                             style="position: relative; top: 0px; left: 0px; width: 100%; height: 100%; aborder: #B5CDE4 1px solid;"></div>
                        <script>var dhxLayout, dhxToolbar, dhxTree, editor;
                        function doOnLoad() {
                            dhxLayout = new dhtmlXLayoutObject("parentId", "1c");
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