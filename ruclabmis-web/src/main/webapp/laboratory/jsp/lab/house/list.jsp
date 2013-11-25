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
        var baseHref = '/laboratory/jsp/sys/user/list';
    </script>

</head>

<body onload="getWidth()()" onresize="getWidth()()">

<form name="form1" method="post">
<table width="98%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
            src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
    <td valign="top" background="../../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">基础管理 > 实验室管理</div>
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

<span style="white-space:nowrap">&nbsp;&nbsp;组织编号:<input type="text" name="searchB1" id="searchB1"
                                                         value="" style="width:100px;"/></span>
                <span style="white-space:nowrap">&nbsp;&nbsp;组织名称:<input type="text" name="searchB1" id="searchB1"
                                                                         value="" style="width:100px;"/></span>
                <span style="white-space:nowrap">&nbsp;&nbsp;级别:<input type="text" name="searchB1" id="searchB1"
                                                                       value="" style="width:100px;"/></span>
                <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);" style="cursor:hand"
                                                                onclick="findInfo()"><img
                        src="../../../../images/zoom.png"
                        width="15" height="15"
                        border="0"/> 查询</a></span>


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
                <table id="hello" width="100%" border="1" cellpadding="0" cellspacing="1"
                       bgcolor="#a8c7ce">
                    <tr>
                        <td width="200" height="20" bgcolor="d3eaef">
                        </td>

                        <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">房间编号</span></div>
                        </td>
                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">房间名称</span></div>
                        </td>
                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">房间位置</span></div>
                        </td>
                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">实验工作台</span></div>
                        </td>
                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">设备库存设备</span></div>
                        </td>
                        <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="center"><span class="STYLE10">详细信息</span></div>
                        </td>
                    </tr>

                    <tr bgcolor="#ffffff" align="center" data-tt-id="xxxy">
                        <td height="20" align="left">信息学院实验教学楼</td>


                        <td colspan="6"></td>
                    </tr>


                    <tr bgcolor="#ffffff" align="center" data-tt-id="rjgc" data-tt-parent-id="xxxy">
                        <td height="20" align="left">信息学院实验楼一</td>


                        <td colspan="6"></td>
                    </tr>

                    <tr bgcolor="#ffffff" align="center" class="STYLE19" data-tt-id="20"
                        data-tt-parent-id="rjgc">

                        <td height="20"><input type="checkbox">软件实验房间101</td>

                        <td>SJ003</td>
                        <td>软件实验房间</td>
                        <td>S1-101</td>
                        <td><a href="experimentriglist.html">实验台</a></td>

                        <td><a href="stocklist.html">库存设备</a></td>
                        <td><a href="detail.html">详细信息</a></td>

                    </tr>

                    <tr bgcolor="#ffffff" align="center" data-tt-id="kc1" data-tt-parent-id="xxxy">
                        <td height="20" align="left">信息学院实验楼二</td>


                        <td colspan="6"></td>

                    </tr>
                    <tr bgcolor="#ffffff" align="center" class="STYLE19" data-tt-id="1"
                        data-tt-parent-id="kc1">
                        <td height="20"><input type="checkbox">计算机实验房间101</td>

                        <td>SJ001</td>
                        <td>软件实验房间</td>
                        <td>S1-101</td>
                        <td><a href="experimentriglist.html">实验台</a></td>

                        <td><a href="stocklist.html">库存设备</a></td>
                        <td><a href="detail.html">详细信息</a></td>

                    </tr>
                    <tr bgcolor="#ffffff" align="center" class="STYLE19" data-tt-id="2"
                        data-tt-parent-id="kc1">
                        <td height="20"><input type="checkbox">计算机实验房间102</td>

                        <td>SY005</td>
                        <td>软件实验房间</td>
                        <td>S1-101</td>
                        <td><a href="experimentriglist.html">实验台</a></td>

                        <td><a href="stocklist.html">库存设备</a></td>
                        <td><a href="detail.html">详细信息</a></td>
                    </tr>
                    <tr bgcolor="#ffffff" align="center" data-tt-id="kc2" data-tt-parent-id="xxxy">
                        <td height="20" align="left">信息学院实验楼三</td>
                        <td colspan="6"></td>
                    </tr>

                    <tr bgcolor="#ffffff" align="center" class="STYLE19" data-tt-id="7"
                        data-tt-parent-id="kc2">
                        <td height="20"><input type="checkbox">网络实验房间102</td>

                        <td>SJ001</td>
                        <td>软件实验房间</td>
                        <td>S1-101</td>
                        <td><a href="experimentriglist.html">实验台</a></td>

                        <td><a href="stocklist.html">库存设备</a></td>
                        <td><a href="detail.html">详细信息</a></td>

                    </tr>
                    <tr bgcolor="#ffffff" align="center" class="STYLE19" data-tt-id="8"
                        data-tt-parent-id="kc2">
                        <td height="20"><input type="checkbox">网络实验房间201</td>

                        <td>SJ002</td>
                        <td>软件实验房间</td>
                        <td>S1-101</td>
                        <td><a href="experimentriglist.html">实验台</a></td>

                        <td><a href="stocklist.html">库存设备</a></td>
                        <td><a href="detail.html">详细信息</a></td>

                    </tr>
                    <tr bgcolor="#ffffff" align="center" class="STYLE19" data-tt-id="9"
                        data-tt-parent-id="kc2">
                        <td height="20"><input type="checkbox">网络实验房间301</td>

                        <td>SJ002</td>
                        <td>软件实验房间</td>
                        <td>S1-101</td>
                        <td><a href="experimentriglist.html">实验台</a></td>

                        <td><a href="stocklist.html">库存设备</a></td>
                        <td><a href="detail.html">详细信息</a></td>
                    </tr>


                    <tr height="16px"></tr>
                </table>

                <link rel="stylesheet" href="jquery.treetable.css"/>
                <script src="jquery.min.js"></script>

                <script src="jquery.treetable.js"></script>
                <script>
                    $("#hello").treetable({ expandable: true });


                </script>
            </div>
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
