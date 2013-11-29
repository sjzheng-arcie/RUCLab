<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <script src="jquery.min.js"></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        var baseHref = '/laboratory/jsp/task/task/leaderlist';
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
<table width="98%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
            src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
    <td valign="top" background="../../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">审核管理 > 任务管理</div>
                </td>
            </tr>
        </table>
    </td>
    <td width="16" valign="top" background="../../../../images/mail_rightbg.gif"><img
            src="../../../../images/nav-right-bg.gif" width="16" height="29"/></td>
</tr>

    <tr>
    <td valign="middle" background="../../../../images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
    <tr>
        <td valign="top" class="STYLE10">


            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td height="30">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td height="24" bgcolor="#353c44">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td width="6%" height="19" valign="bottom">
                                                            <div align="center"><img src="../../../../images/tb.gif" width="14"
                                                                                     height="14"/></div>
                                                        </td>
                                                        <td width="94%" valign="bottom"><span class="STYLE1" style="white-space:nowrap">任务管理</span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <div align="right">
                                    <span class="STYLE1" style="white-space:nowrap">
                                        <a href="add.html"><img src="../../../../images/add_min.gif" width="10" height="10" border="0"/>
                                            <span class="STYLE1">新增</span></a>&nbsp;
                                        <a href="#" onclick="toUpdate();"><img src="../../../../images/edit_min.gif" width="10"
                                                                               height="10"
                                                                               border="0"/> <span class="STYLE1">修改</span></a>&nbsp;
                                        <a href="#" onclick="toDelete();"><img src="../../../../images/del_min.gif" width="10"
                                                                               height="10"
                                                                               border="0"/> <span class="STYLE1">删除</span></a>&nbsp;&nbsp;
                                <a href="#" onclick="toRoom();"><img src="../../../../images/del_min.gif" width="10" height="10"
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
                            <table id="treeTable" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                            <tr>
                                <td width="200" height="20" bgcolor="d3eaef">
                                </td>

                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                    <div align="center"><span class="STYLE10">任务名称</span></div>
                                </td>
                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                    <div align="center"><span class="STYLE10">完成时间</span></div>
                                </td>
                                <td width="80" height="20" bgcolor="d3eaef" class="STYLE6">
                                    <div align="center"><span class="STYLE10">任务内容</span></div>
                                </td>
                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                    <div align="center"><span class="STYLE10">附件</span></div>
                                </td>
                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                    <div align="center"><span class="STYLE10">备注</span></div>
                                </td>
                                <td width="60" height="20" bgcolor="d3eaef" class="STYLE6">
                                    <div align="center"><span class="STYLE10">完成度</span></div>
                                </td>
                                <td width="120" height="20" bgcolor="d3eaef" class="STYLE6">
                                    <div align="center"><span class="STYLE10">操作</span></div>
                                </td>
                            </tr>

                            <tr bgcolor="#ffffff" align="center" data-tt-id="rjgc">
                                <td height="20" align="left">软件工程</td>


                                <td colspan="7"></td>
                            </tr>


                            <tr bgcolor="#ffffff" align="center" data-tt-id="lby" data-tt-parent-id="rjgc">
                                <td height="20" align="left">陆伯言<input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
                                </td>


                                <td colspan="7"></td>
                            </tr>

                            <tr bgcolor="#ffffff" align="center"  data-tt-id="20" data-tt-parent-id="lby">
                                <td height="20">任务一</td>
                                <td>实验设备部署</td>
                                <td>2012-01-12</td>

                                <td>将新购入的设备部署在实验室</td>

                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>
                            </tr>

                            <tr bgcolor="#ffffff" align="center" data-tt-id="jby" data-tt-parent-id="rjgc">
                                <td height="20" align="left">姜伯约<input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
                                </td>
                                <td colspan="7"></td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center"  data-tt-id="1" data-tt-parent-id="jby">
                                <td height="20">任务一</td>
                                <td>实验设备部署</td>
                                <td>2012-01-12</td>
                                <td>将新购入的设备部署在实验室</td>
                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center"  data-tt-id="2" data-tt-parent-id="jby">
                                <td height="20">任务二</td>
                                <td>实验设备部署</td>
                                <td>2012-01-12</td>
                                <td>将新购入的设备部署在实验室</td>
                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center" data-tt-id="gfx" data-tt-parent-id="rjgc">
                                <td height="20" align="left">郭奉孝<input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
                                </td>
                                <td colspan="7"></td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center"  data-tt-id="7" data-tt-parent-id="gfx">
                                <td height="20">任务一</td>
                                <td>实验设备部署</td>
                                <td>2012-01-12</td>
                                <td>将新购入的设备部署在实验室</td>
                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center"  data-tt-id="8" data-tt-parent-id="gfx">
                                <td height="20">任务二</td>
                                <td>实验设备部署</td>
                                <td>2012-01-12</td>
                                <td>将新购入的设备部署在实验室</td>
                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center" class="STYLE19" data-tt-id="9" data-tt-parent-id="gfx">
                                <td height="20">任务三</td>
                                <td>实验设备部署</td>
                                <td>2012-01-12</td>
                                <td>将新购入的设备部署在实验室</td>
                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center" data-tt-id="wlgc">
                                <td height="20" align="left">网络工程</td>
                                <td colspan="7"></td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center" data-tt-id="cmd" data-tt-parent-id="wlgc">
                                <td height="20" align="left">曹孟德<input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
                                </td>
                                <td colspan="7"></td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center" data-tt-id="250" data-tt-parent-id="cmd">
                                <td height="20">任务一</td>
                                <td>实验设备部署</td>
                                <td>2012-01-12</td>

                                <td>将新购入的设备部署在实验室</td>

                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>

                            </tr>

                            <tr bgcolor="#ffffff" align="center" data-tt-id="zwy" data-tt-parent-id="wlgc">
                                <td height="20" align="left">张文远<input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
                                </td>
                                <td colspan="7"></td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center"  data-tt-id="91" data-tt-parent-id="zwy">
                                <td height="20">任务一</td>
                                <td>实验设备部署</td>
                                <td>2012-01-12</td>
                                <td>将新购入的设备部署在实验室</td>

                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>

                            </tr>
                            <tr bgcolor="#ffffff" align="center" data-tt-id="92" data-tt-parent-id="zwy">
                                <td height="20">任务二</td>

                                <td>实验设备部署</td>
                                <td>2012-01-12</td>

                                <td>将新购入的设备部署在实验室</td>

                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center" data-tt-id="xwr" data-tt-parent-id="wlgc">
                                <td height="20" align="left">荀文若<input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
                                </td>

                                <td colspan="7"></td>

                            </tr>

                            <tr bgcolor="#ffffff" align="center" data-tt-id="47" data-tt-parent-id="xwr">
                                <td height="20">任务一</td>
                                <td>实验设备部署</td>
                                <td>2012-01-12</td>

                                <td>将新购入的设备部署在实验室</td>

                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center"  data-tt-id="99" data-tt-parent-id="xwr">
                                <td height="20">任务二</td>

                                <td>实验设备部署</td>
                                <td>2012-01-12</td>
                                <td>将新购入的设备部署在实验室</td>

                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center" data-tt-id="100" data-tt-parent-id="xwr">
                                <td height="20">任务三</td>
                                <td>实验设备部署</td>
                                <td>2012-01-12</td>

                                <td>将新购入的设备部署在实验室</td>

                                <td>设备部署帮助手册</td>
                                <td>设备易损，注意安全</td>
                                <td>30%</td>
                                <td><input type="button" value="评分" class="button" onclick="score();"/>
                                    <input type="button" value="编辑" class="button" onclick="update();"/>
                                    <input type="button" value="删除" class="button" onclick="delete('');"/>
                                </td>
                            </tr>
                            <c:forEach items="${organizations}" var="item">
                                <c:if test="${item.id!=item.parentId}">
                                    <tr bgcolor="#ffffff" align="center" data-tt-id="id${item.id}"
                                        data-tt-parent-id="id${item.parentId}">
                                        <td height="20" align="left" >${item.name}</td>
                                        <td >${item.sn}</td>
                                        <td >${item.name}</td>
                                        <td >${item.limitedTime}</td>
                                        <td >${item.content}</td>
                                        <td >${item.director}</td>
                                        <td >${item.note}</td>
                                        <td><a href="toUpdate?id=${item.id}">
                                            <img src="../../../../images/edit_min.gif" width="10"
                                                 height="10" border="0"/>
                                        </a></td>
                                        <td><a href="toDelete?id=${item.id}">
                                            <img src="../../../../images/del_min.gif" width="10"
                                                 height="10" border="0"/>
                                        </a></td>
                                    </tr>
                                </c:if>
                                <c:if test="${item.id==item.parentId}">
                                    <tr bgcolor="#ffffff" align="center" data-tt-id="id${item.id}" colspan="7">
                                        <td height="20" align="left" >
                                            <input name="idcheckbox" type="checkbox"
                                                value="${item.id}"onclick="checkOne('listForm', 'idcheckbox')"/>${item.name}</td>
                                        <td ></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                            <tr height="16px"></tr>
                            </table>

                        <link rel="stylesheet" href="jquery.treetable.css"/>
                        <script src="jquery.min.js"></script>

                        <script src="jquery.treetable.js"></script>
                        <script>
                            $("#treeTable").treetable({ expandable: true, initialState : "expanded"});


                        </script>
                        </div>
                    </td>
                </tr>
            <tr>
            <td height="30">

            </td>
        </tr>
        </table>
        </td>
    </tr>
</table>
</td>
<td background="../../../../images/mail_rightbg.gif">&nbsp;</td>
</tr>
<tr>
    <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img src="../../../../images/buttom_left2.gif"
                                                                             width="17" height="17"/></td>
    <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img src="../../../../images/buttom_bgs.gif"
                                                                            width="100%" height="17"/></td>
    <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img src="../../../../images/buttom_right2.gif"
                                                                              width="16" height="17"/></td>
</tr>
</table>
</form>
</body>
</html>
