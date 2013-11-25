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
        var baseHref = '/laboratory/jsp/res/report/courselist';
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
<table width="98%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
            src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
    <td valign="top" background="../../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
               id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">教学资源管理 > 课程管理</div>
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

                            <span style="white-space:nowrap">&nbsp;&nbsp;实验编号:<input type="text" name="experimentNo"
                                                                                     id="experimentNo" value=""
                                                                                     style="width:100px;"/></span>
                            <span style="white-space:nowrap">&nbsp;&nbsp;实验名称:<input type="text" name="experimentName"
                                                                                     id="experimentName" value=""
                                                                                     style="width:100px;"/></span>
		<span style="white-space:nowrap">&nbsp;&nbsp;是否提交实验报告:<select id="ifReport" name="ifReport">
            <option value="0">是</option>
            <option value="1">否</option>
        </select></span>
                            <span style="white-space:nowrap">&nbsp;&nbsp;实验报告提交期限:<input type="text" name="timeLimit"
                                                                                         id="timeLimit" value=""
                                                                                         style="width:100px;"/></span>
                            <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);"
                                                                            style="cursor:hand"
                                                                            onclick="findInfo()"><img
                                    src="../../../../images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>


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
                                                                        style="white-space:nowrap">实验信息列表</span>
                                                                </td>
                                                            </tr>
                                                        </table>
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
                                            <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">实验编号</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">实验名称</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">实验时间</span></div>
                                            </td>


                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">是否提交实验报告</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">实验报告提交期限</span></div>
                                            </td>


                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">上传实验报告</span></div>
                                            </td>
                                        </tr>
                                        <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                            <td height="20"><input name="idcheckbox" type="checkbox"
                                                                   value="admin" onclick="checkOne(this)"/></td>
                                            <td>1</td>
                                            <td>KC001</td>
                                            <td>编程语言基础实验课</td>
                                            <td>09年第一学期第2周第5节</td>


                                            <td>是</td>
                                            <td>2012-02-12</td>


                                            <td><a href="detial.html"><input type="button" value="上传"
                                                                             class="button" onclick="upload()"></a>
                                            </td>
                                        </tr>
                                        <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                            <td height="20"><input name="idcheckbox" type="checkbox"
                                                                   value="admin" onclick="checkOne(this)"/></td>
                                            <td>2</td>
                                            <td>KC002</td>
                                            <td>面向对象编程</td>
                                            <td>09年第二学期第8周第3节</td>

                                            <td>是</td>
                                            <td>2012-01-13</td>


                                            <td><a href="detial.html"><input type="button" value="上传"
                                                                             class="button" onclick="upload()"></a>
                                            </td>
                                        </tr>
                                        <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                            <td height="20"><input name="idcheckbox" type="checkbox"
                                                                   value="admin" onclick="checkOne(this)"/></td>
                                            <td>3</td>
                                            <td>KC003</td>
                                            <td>电子电路实验课</td>
                                            <td>09年第二学期第12周第6节</td>

                                            <td>是</td>
                                            <td>2012-11-13</td>


                                            <td><a href="detial.html"><input type="button" value="上传"
                                                                             class="button" onclick="upload()"></a>
                                            </td>
                                        </tr>

                                        <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                            <td height="20"><input name="idcheckbox" type="checkbox"
                                                                   value="admin" onclick="checkOne(this)"/></td>
                                            <td>4</td>
                                            <td>JD001</td>
                                            <td>显示核心交火实验</td>
                                            <td>08年第二学期第5周第6节</td>

                                            <td>否</td>
                                            <td>----</td>


                                            <td>----</a></td>
                                        </tr>

                                        <c:forEach items="${pageInfo.data}" var="item">
                                            <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                <td height="20"><input name="idcheckbox" type="checkbox"
                                                                       value="${item.id}"
                                                                       onclick="checkOne('listForm', 'idcheckbox')"/>
                                                </td>
                                                <td>${item.id}</td>
                                                <td>${item.sn}</td>
                                                <td>${item.name}</td>

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
    <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
            src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
</tr>
</table>
</form>
</body>
</html>
