<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>设备盘点列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="equipment/css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="equipment/js/util.js"></script>
</head>
<body onload="getwidth()" onresize="getwidth()">

<form name="form1" method="post">
<table width="98%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="equipment/images/mail_leftbg.gif"><img
            src="/equipment/images/left-top-right.gif" width="17" height="29"/></td>
    <td valign="top" background="/equipment/images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">设备管理系统 > 仪器设备类资产盘盈</div>
                </td>
            </tr>
        </table>
    </td>
    <td width="16" valign="top" background="/equipment/images/mail_rightbg.gif"><img
            src="/equipment/images/nav-right-bg.gif" width="16" height="29"/></td>
</tr>

<tr>
<td valign="middle" background="/equipment/images/mail_leftbg.gif">&nbsp;</td>
<td valign="top" bgcolor="#F7F8F9">
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
<tr>
<td valign="top" class="STYLE10">

<span style="white-space:nowrap">&nbsp;&nbsp;设备名称:<input type="text" name="searchB1" id="searchB1" value=""
                                                         style="width:100px;"/></span>

<span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);" style="cursor:hand" onclick="findInfo()"><img
        src="/equipment/images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>


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
                                            <div align="center"><img src="/equipment/images/tb.gif" width="14"
                                                                     height="14"/></div>
                                        </td>
                                        <td width="94%" valign="bottom"><span class="STYLE1" style="white-space:nowrap">仪器设备类资产盘盈报表</span>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <div align="right">
	            	<span class="STYLE1" style="white-space:nowrap">
	            			
                  <a href="../profit/add.html"><img src="/equipment/images/del_min.gif" width="10" height="10"
                                                    border="0"/> <span class="STYLE1">报增</span></a>&nbsp;&nbsp;
                  <a href="#" onclick="toHouseLay();"><img src="/equipment/images/del_min.gif" width="10" height="10"
                                                           border="0"/> <span class="STYLE1">导出</span></a>&nbsp;&nbsp;
                  <a href="#" onclick="toRoom();"><img src="/equipment/images/del_min.gif" width="10" height="10"
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
<table width="100%" class="table" id="table1" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
<tr>
    <td width="40" height="20" bgcolor="d3eaef" class="STYLE10">
        <div align="center">
            <input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
        </div>
    </td>
    <td width="40" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">序号</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">仪器编号</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">分类号</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">仪器名称</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">型号</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">规格</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">单价</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">厂家</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">出厂号</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">购置日期</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">经费科目</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">领用人</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">存放地点</span></div>
    </td>
    <td width="100" bgcolor="d3eaef">
        <div align="center"><span class="STYLE10">备注</span></div>
    </td>
</tr>
<tr bgcolor="#ffffff" align="center" class="STYLE19">
    <td height="20"><input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
    </td>
    <td>1</td>
    <td title="">79017700</td>

    <td title="">04410101</td>

    <td title="">台式钻床</td>
    <td title="">Z4006-B</td>
    <td title="">*</td>
    <td title="">600</td>

    <td title="">北京黄土岗公社机床厂</td>

    <td title="">772</td>

    <td title="">1979.03</td>

    <td title="">教学</td>

    <td title="">吴建红</td>

    <td title="">理工配配楼300</td>

    <td title="">备注</td>

</tr>
<tr bgcolor="#ffffff" align="center" class="STYLE19">
    <td height="20"><input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
    </td>
    <td>1</td>
    <td title="">79017800</td>

    <td title="">04410101</td>

    <td title="">台式钻床</td>
    <td title="">Z4006-B</td>
    <td title="">*</td>
    <td title="">600</td>

    <td title="">北京黄土岗公社机床厂</td>

    <td title="">772</td>

    <td title="">1979.03</td>

    <td title="">教学</td>

    <td title="">吴建红</td>

    <td title="">理工配配楼300</td>

    <td title="">备注</td>

</tr>
<tr bgcolor="#ffffff" align="center" class="STYLE19">
    <td height="20"><input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
    </td>
    <td>1</td>
    <td title="">89010400</td>

    <td title="">04070704</td>

    <td title="">空气调节器</td>
    <td title="">TWB-40</td>
    <td title="">*</td>
    <td title="">61130</td>

    <td title="">哈尔滨空伊奥二厂</td>

    <td title="">500</td>

    <td title="">1987.03</td>

    <td title="">基建</td>

    <td title="">吴建红</td>

    <td title="">理工配配楼300</td>

    <td title="">备注</td>

</tr>
<tr bgcolor="#ffffff" align="center" class="STYLE19">
    <td height="20"><input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
    </td>
    <td>1</td>
    <td title="">89010500</td>

    <td title="">04070704</td>

    <td title="">空气调节器</td>
    <td title="">TWB-40</td>
    <td title="">*</td>
    <td title="">61130</td>

    <td title="">哈尔滨空伊奥二厂</td>

    <td title="">501</td>

    <td title="">1987.03</td>

    <td title="">基建</td>

    <td title="">吴建红</td>

    <td title="">理工配配楼300</td>

    <td title="">备注</td>

</tr>
<tr bgcolor="#ffffff" align="center" class="STYLE19">
    <td height="20"><input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
    </td>
    <td>1</td>
    <td title="">88082600</td>

    <td title="">05010602</td>

    <td title="">计算机测试卡</td>
    <td title="">IBM-PC/XT</td>
    <td title="">*</td>
    <td title="">3100</td>

    <td title="">北京计算机技术公司</td>

    <td title=""></td>

    <td title="">1988.10</td>

    <td title="">教学</td>

    <td title="">肖源</td>

    <td title="">理工配配楼102</td>

    <td title="">备注</td>

</tr>
<tr bgcolor="#ffffff" align="center" class="STYLE19">
    <td height="20"><input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/>
    </td>
    <td>1</td>
    <td title="">91001800</td>

    <td title="">14030102</td>

    <td title="">吸尘器</td>
    <td title="">VC-250P</td>
    <td title="">*</td>
    <td title="">670</td>

    <td title="">无</td>

    <td title=""></td>

    <td title="">1991.01</td>

    <td title="">教学</td>

    <td title="">肖源</td>

    <td title="">理工配楼B100</td>

    <td title="">备注</td>

</tr>
<tr height="16px"></tr>
</table>
</div>
</td>
</tr>
<tr>
    <td height="30">
        <table width='100%' border='0' cellspacing='0' cellpadding='0' style='font-size:13px;'>
            <tr>
                <td><span align='left' class='STYLE22' style="white-space:nowrap">&nbsp;&nbsp;共有<strong>2</strong> 条记录，当前第<strong>1</strong> 页，共 <strong>1</strong> 页</span>
				<span class='STYLE22' style="white-space:nowrap">
				<table border='0' align='right' cellpadding='0' cellspacing='0' style='font-size:13px;'>
                    <tr>
                        <td width='49'>
                            <div align='center'><img src='/equipment/images/main_54.gif' width='40' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img src='/equipment/images/main_56.gif' width='45' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img src='/equipment/images/main_58.gif' width='45' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img src='/equipment/images/main_60.gif' width='40' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='37' class='STYLE22'>
                            <div align='center' style="white-space:nowrap">转到</div>
                        </td>
                        <td>
                            <div align='left'><select
                                    onchange=" document.forms[0].action='/NWSVN/sysint!find?page='+this.options[this.selectedIndex].value;document.forms[0].submit();">
                                <option class='STYLE22' value="1" selected>第1页</option>
                            </select></div>
                        </td>
                    </tr>
                </table>
					</span>
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
<td background="/equipment/images/mail_rightbg.gif">&nbsp;</td>
</tr>
<tr>
    <td valign="bottom" background="/equipment/images/mail_leftbg.gif"><img src="/equipment/images/buttom_left2.gif"
                                                                          width="17" height="17"/></td>
    <td valign="bottom" background="/equipment/images/buttom_bgs.gif"><img src="/equipment/images/buttom_bgs.gif"
                                                                         width="100%" height="17"/></td>
    <td valign="bottom" background="/equipment/images/mail_rightbg.gif"><img src="/equipment/images/buttom_right2.gif"
                                                                           width="16" height="17"/></td>
</tr>
</table>
</form>
</body>
</html>