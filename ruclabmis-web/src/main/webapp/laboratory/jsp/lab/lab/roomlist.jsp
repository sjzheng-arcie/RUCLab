<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        //获得divwidth的宽度
        function getWidth(){
            document.getElementById("divwidth").style.width= document.body.offsetWidth-35+"px";
            if(document.body.scrollWidth>document.body.offsetWidth){
                document.getElementById("divwidth").style.width=document.body.scrollWidth-35+"px";
            }
        }
        function update() {
            if(!validator(document.mainForm)){
                return;
            }

            document.mainForm.action = "updateApplication";
            document.mainForm.submit();
        }

        function toAddRoom(){
            window.open("/laboratory/jsp/lab/lab/addroom?laboratoryId=${laboratoryInfo.id}", "设备库",
                    "height=460, width=1000, toolbar=no, status=no ,location=no");
        }
        function freshWindow(){
            window.location.reload(true);
        }
        function back(){
            window.location.href="/laboratory/jsp/lab/lab/list"
        }
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
<table width="98%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="17" valign="top" background="../../../../images/mail_leftbg.gif">
            <img src="../../../../images/left-top-right.gif" width="17" height="29"/>
        </td>
        <td valign="top" background="../../../../images/content-bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                <tr>
                    <td height="31">
                        <div class="titlebt">实验室管理 > 向实验室中添加房间</div>
                    </td>
                </tr>
            </table>
        </td>
        <td width="16" valign="top" background="../../../../images/mail_rightbg.gif">
            <img src="../../../../images/nav-right-bg.gif" width="16" height="29"/>
        </td>
    </tr>
    <tr>
        <td valign="middle" background="../../../../images/mail_leftbg.gif">&nbsp;</td>
        <td valign="top" bgcolor="#F7F8F9">
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
                                                        <td width="94%" valign="bottom"><span
                                                                class="STYLE1">添加房间</span></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <div align="right"><span class="STYLE1">&nbsp;</span><span
                                                        class="STYLE1"> &nbsp;</span></div>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr valign="top">
                    <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                            <tr bgcolor="#FFFFFF">
                                <td bgcolor="#FFFFFF">
                                    <table border="0" cellpadding="2" cellspacing="1"
                                           style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                           bgcolor="#E3E9EE">
                                        <tr>

                                            <td nowrap align="right">实验室名称:</td>
                                            <td nowrap>
                                                <input name="deskName" id="deskName" onblur="" class="text"
                                                       style="width:154px" maxlength="20" valid="required|isAccount"
                                                       value="${laboratoryInfo.name}"  readonly/>
                                            </td>

                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td align="center">
                                    <input type="button" name="addEquipmentToDesk" value="添加房间" class="button" onclick="toAddRoom();"/>
                                    <input  class="button" type="button" name="return" value="返回" class="button"
                                            onclick="back();"/>
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
                                                            <table width="100%" border="0" cellspacing="0"
                                                                   cellpadding="0">
                                                                <tr>
                                                                    <td width="6%" height="19" valign="bottom">
                                                                        <div align="center"><img
                                                                                src="../../../../images/tb.gif"
                                                                                width="14" height="14"/></div>
                                                                    </td>
                                                                    <td width="94%" valign="bottom"><span
                                                                            class="STYLE1"
                                                                            style="white-space:nowrap">房间列表</span>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                        <td>
                                                            <div align="right">
                                                                <span class="STYLE1" style="white-space:nowrap">

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
                                                               onclick="checkAll(this,'listForm', 'idcheckbox');"/>
                                                    </div>
                                                </td>

                                                <td width="100" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">房间名称</span></div>
                                                </td>
                                                <td width="100" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">类型</span></div>
                                                </td>
                                                <td width="100" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">描述</span></div>
                                                </td>
                                                <td width="100" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">工作台</span></div>
                                                </td>
                                                <td width="100" bgcolor="d3eaef">
                                                    <div align="center"><span class="STYLE10">移除</span></div>
                                                </td>
                                            </tr>
                                            <c:forEach items="${pageInfo.data}" var="item">
                                                <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                    <td height="20"><input name="idcheckbox" type="checkbox"
                                                                           value="${item.room.id}"
                                                                           onclick="checkOne('listForm', 'idcheckbox')"/>
                                                    </td>
                                                    <td>${item.room.name}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${item.room.type==true}">
                                                                实验室
                                                            </c:when>
                                                            <c:otherwise>
                                                                会议室
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td>${item.room.description}</td>
                                                    <td><a class="button" href="/laboratory/jsp/lab/desk/desklist?roomId=${item.room.id}&page=0&laboratoryId=${laboratoryInfo.id}">
                                                        工作台
                                                    </a></td>
                                                    <td><a href="/laboratory/jsp/lab/lab/remove?roomId=${item.room.id}&laboratoryId=${laboratoryInfo.id}">
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
                            <%@ include file="../../common/pagetable.jsp"%>
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
