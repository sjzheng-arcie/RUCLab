<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        function deleteClasses(id) {
            if(window.confirm("确实要删除该房间吗？该房间将会从实验室中移除。")){
                if(window.confirm("删除该实房间将会删除该房间内的工作台！")){
                    window.location.href="/laboratory/jsp/lab/house/todelete?id="+id;
                }
            }
        }
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
                            <div class="titlebt">实验室管理 > 房间管理</div>
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
                                    <span style="white-space:nowrap">&nbsp;&nbsp;房间名称:
                                        <input type="text" name="roomName" id="roomName" value="" style="width:100px;"/>
                                    </span>
                                    <span style="white-space:nowrap">&nbsp;&nbsp;房间类型:
                                        <select name="roomType" id="roomType">
                                            <option value="3"></option>
                                            <option value="1">实验室</option>
                                            <option value="0">会议室</option>
                                        </select>
                                    </span>
                                    <span style="white-space:nowrap">&nbsp;&nbsp;
                                        <a href="javascript:void(0)" onclick="toFind('listForm');" class="txt_bt">
                                            <img src="../../../../images/zoom.png" width="15" height="15" border="0"/> 查询</a>
                                    </span>
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
                                                                    <div align="center"><img src="../../../../images/tb.gif"
                                                                                             width="14" height="14"/></div>
                                                                </td>
                                                                <td width="94%" valign="bottom"><span class="STYLE1"
                                                                                                      style="white-space:nowrap">房间管理</span>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </td>
                                                    <td>
                                                        <div align="right">
                                                        <span class="STYLE1" style="white-space:nowrap">
                                                            <a href="toadd" class="txt_bt">
                                                                <img src="../../../../images/add_min.gif" width="10" height="10" border="0"/>
                                                                <span class="STYLE1">新增</span>
                                                            </a>&nbsp;
                                                            <a href="javascript:;" onclick="toDelete('listForm','idcheckbox');" class="txt_bt">
                                                                <img src="../../../../images/del_min.gif" width="10" height="10" border="0"/>
                                                                <span class="STYLE1">删除</span>
                                                            </a>&nbsp;
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
                                    <table id="treeTable" class="table" width="100%" border="0" cellpadding="0" cellspacing="1"
                                           bgcolor="#a8c7ce">
                                        <tr>
                                            <td width="40" height="20" bgcolor="d3eaef" class="STYLE10">
                                                <div align="center">
                                                    <input type="checkbox" name="checkbox" id="checkbox"
                                                           onclick="checkAll(this,'listForm', 'idcheckbox');"/>
                                                </div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">房间名称</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">房间类型</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">房间描述</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">工作台</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">详细信息</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">删除</span></div>
                                            </td>
                                        </tr>
                                        <c:forEach items="${pageInfo.data}" var="item">
                                            <tr bgcolor="#ffffff" align="center" class="STYLE19" data-tt-id="20"
                                                data-tt-parent-id="rjgc">
                                                <td height="20"><input name="idcheckbox" type="checkbox"
                                                                       value="${item.id}"
                                                                       onclick="checkOne('listForm', 'idcheckbox')"/>
                                                </td>
                                                <td height="20">${item.name}</td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${item.type==true}">
                                                            实验室
                                                        </c:when>
                                                        <c:otherwise>
                                                            会议室
                                                        </c:otherwise>
                                                    </c:choose>

                                                </td>
                                                <td>${item.description}</td>
                                                <td><a class="button" href="/laboratory/jsp/lab/desk/desklist?roomId=${item.id}&houseListPage=${pageInfo.currentPage}">
                                                    工作台
                                                </a></td>
                                                <td><a href="/laboratory/jsp/lab/house/update?id=${item.id}">
                                                    <img src="../../../../images/edit_min.gif" width="10"
                                                         height="10" border="0"/>
                                                </a></td>
                                                <td><a href="javascript:;" onclick="deleteClasses('${item.id}');">
                                                    <img src="../../../../images/del_min.gif" width="10"
                                                         height="10" border="0"/>
                                                </a></td>
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
