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
        var baseHref = '/laboratory/jsp/task/task/leaderscore';
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="../../../../images/mail_leftbg.gif">
        <img src="../../../../images/left-top-right.gif" width="17" height="29"/>
    </td>
    <td valign="top" background="../../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">考核管理 > 任务评分</div>
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
                                                    <td width="94%" valign="bottom"><span class="STYLE1">任务信息</span>
                                                    </td>
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
                                <table cellpadding="10" cellspacing="0"
                                       style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                       border="1px" bgcolor="#E3E9EE">
                                    <tr height="">
                                        <td nowrap align="right">任务编号:</td>
                                        <td nowrap>
                                            任务2012
                                        </td>
                                        <td nowrap align="right">任务名称:</td>
                                        <td nowrap>
                                            老坏设备更新
                                        </td>

                                    </tr>
                                    <tr>
                                        <td nowrap align="right">负责人:</td>
                                        <td nowrap>
                                            张春华
                                        </td>
                                        <td nowrap align="right">到期时间:</td>
                                        <td nowrap>
                                            2012-12-12
                                        </td>

                                    </tr>

                                    <tr>
                                        <td nowrap align="right">任务内容:</td>

                                        <td colspan="3">
                                            部署新设备
                                        </td>
                                    </tr>
                                    <tr>
                                        <td nowrap align="right">备注:</td>

                                        <td colspan="3">
                                            由于实验室没有空位，不能一次部署完毕
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
    <td background="../../../../images/mail_rightbg.gif">&nbsp;</td>
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
                                                    <td width="94%" valign="bottom"><span class="STYLE1">评分</span>
                                                    </td>
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
                                        <td nowrap align="right">完成度评分:</td>
                                        <td nowrap>
                                            <input name="completeness" id="completeness" onblur="" class="text"
                                                   style="width:154px" maxlength="20" value="6" readonly/>
                                            <span style="color:red;">*</span>&nbsp;&nbsp;

                                        </td>
                                        <td nowrap align="right">即时度评分:</td>
                                        <td nowrap>
                                            <input name="instantDegree" id="instantDegree" onblur="" class="text"
                                                   style="width:154px" maxlength="20" value="7" readonly/>
                                            <span style="color:red;">*</span>&nbsp;&nbsp;

                                        </td>

                                    </tr>
                                    <tr>
                                        <td nowrap align="right">完成质量评分:</td>
                                        <td nowrap>
                                            <input name="quality" id="quality" onblur="" class="text"
                                                   style="width:154px" maxlength="20" value="8" readonly/>
                                            <span style="color:red;">*</span>&nbsp;&nbsp;


                                        </td>
                                        <td nowrap align="right">花费资源评分:</td>
                                        <td nowrap>
                                            <input name="rsourceSpent" id="rsourceSpent" onblur="" class="text"
                                                   style="width:154px" maxlength="20" value="9" readonly/>
                                            <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_us_sname"></span>
                                        </td>

                                    </tr>
                                    <tr>

                                        <td nowrap align="right">任务整体评分:</td>
                                        <td nowrap>
                                            <input name="integrity" id="integrity" onblur="" class="text"
                                                   style="width:154px" maxlength="20" value="8" readonly/>
                                            <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_us_sname"></span>
                                        </td>
                                        <td nowrap align="right">评分人姓名:</td>
                                        <td nowrap>
                                            <input name="judes" id="judes" onblur="" class="text"
                                                   style="width:154px" maxlength="20" valid="required|isAccount"
                                                   value="徐长卿" readonly/>
                                            <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_us_sname"></span>
                                        </td>

                                    </tr>
                                </table>

                            </td>
                        </tr>
                    </table>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td align="center">
                                <input type="button" name="Submit" value="保存" class="button" onclick="save();"/>
                                <input type="reset" name="reset" value="重置" class="button" onclick="reset();"/>
                                <input type="button" name="return" value="返回" class="button"
                                       onclick="window.history.go(-1);"/>
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
                                                                            width="100%" height="17"></td>
    <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img src="../../../../images/buttom_right2.gif"
                                                                              width="16" height="17"/></td>
</tr>
</table>

<table width="98%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
                src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
        <td valign="top" background="../../../../images/content-bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                <tr>
                    <td height="31">
                        <div class="titlebt">考核管理 > 教师间任务评分情况</div>
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

                        <span style="white-space:nowrap">&nbsp;&nbsp;评分人:<input type="text" name="searchB1"
                                                                                id="searchB1" value=""
                                                                                style="width:100px;"/></span>
                        <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);" style="cursor:hand"
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
                                                                                width="14"
                                                                                height="14"/></div>
                                                                    </td>
                                                                    <td width="94%" valign="bottom"><span class="STYLE1"
                                                                                                          style="white-space:nowrap">组织结构</span>
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
                                        <table width="100%" border="0" cellpadding="0" cellspacing="1"
                                               bgcolor="#a8c7ce">
                                            <tr>
                                                <td width="200" height="20" bgcolor="d3eaef">

                                                </td>
                                                <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">序号</span></div>
                                                </td>
                                                <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">评分人</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">完成度</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">即时度</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">完成质量</span></div>
                                                </td>
                                                <td width="150" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">花费资源</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">整体评分</span></div>
                                                </td>


                                            </tr>
                                            <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                <td height="20"><input name="idcheckbox" type="checkbox" value="admin"
                                                                       onclick="checkOne(this)"/></td>
                                                <td>1</td>
                                                <td>张翼德</td>

                                                <td>6</td>
                                                <td>7</td>
                                                <td>8</td>
                                                <td>9</td>
                                                <td>8</td>

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
        <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img
                src="../../../../images/buttom_left2.gif"
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
