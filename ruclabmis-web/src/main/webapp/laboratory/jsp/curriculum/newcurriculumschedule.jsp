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
    });
</script>
<body onload="doOnLoad();">
<form>
<table width="100%" height="100%" border="0" cellspacing="10" cellpadding="0">
    <tr>
        <td valign="top" height="100%">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
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
                        <div id="zuoxi" style="width: 100%; height: 100%; overflow: auto;">

                            <table width="100%" border="0" cellpadding="1" cellspacing="1" style="margin-top:20px">
                                <tr>
                                    <td align="right">学年：</td>
                                    <td><input type="text" name="schoolYear"/></td>
                                </tr>
                                <tr>
                                    <td align="right">学期：</td>
                                    <td><select>
                                        <option>第一学期</option>
                                        <option>第二学期</option>
                                    </select></td>
                                </tr>
                                <tr>
                                    <td align="right">班级：</td>
                                    <td>
                                        <select id="target" name="target"
                                                style="width: 252px;height: 22px"
                                                data-placeholder="选择班级...">
                                            <c:forEach items="${curriculumClassList}" var="curriculumClass">
                                                    <option value="${curriculumClass.id}">${curriculumClass.className}(${curriculumClass.classSn})</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">课程：</td>
                                    <td><select>
                                        <option>软件工程导论</option>
                                        <option>网络工程基础</option>
                                    </select></td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">开始时间：</td>
                                    <td width="70%">第<select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                        <option>10</option>
                                        <option>11</option>
                                        <option>12</option>
                                        <option>13</option>
                                        <option>14</option>
                                        <option>15</option>
                                        <option>16</option>
                                        <option>17</option>
                                        <option>18</option>
                                        <option>19</option>
                                        <option>20</option>
                                    </select>周</td>
                                </tr>
                                <tr>
                                    <td align="right" width="30%">结束时间：</td>
                                    <td width="70%">第<select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                        <option>10</option>
                                        <option>11</option>
                                        <option>12</option>
                                        <option>13</option>
                                        <option>14</option>
                                        <option>15</option>
                                        <option>16</option>
                                        <option>17</option>
                                        <option>18</option>
                                        <option>19</option>
                                        <option>20</option>
                                    </select>周</td>
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