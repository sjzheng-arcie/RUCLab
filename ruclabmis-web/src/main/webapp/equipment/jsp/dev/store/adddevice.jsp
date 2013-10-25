<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>
<script>
    function save() {
        document.form1.action = "list.html";
        document.form1.submit();
    }

    function addDevice(){
        var deviceNo=document.getElementById('deviceNo').value;
        var factoryNo=document.getElementById('factoryNo').value;
        var accessoryNum=document.getElementById('accessoryNum').value;
        var device= new Array(deviceNo,factoryNo,accessoryNum)
        if(deviceNo!=""&&factoryNo!=""&&accessoryNum!=""){
            window.returnValue=device;
            window.close();
        }else{
            alert("请输入完整信息");
        }
        window.close();
    }
</script>
<body>
<form name="form1" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="../../../images/mail_leftbg.gif">
        <img src="../../../images/left-top-right.gif" width="17" height="29"/>
    </td>
    <td valign="top" background="../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">设备信息管理 > 设备资产报增</div>
                </td>
            </tr>
        </table>
    </td>
    <td width="16" valign="top" background="../../../images/mail_rightbg.gif">
        <img src="../../../images/nav-right-bg.gif" width="16" height="29"/>
    </td>
</tr>
<tr>
    <td valign="middle" background="../../../images/mail_leftbg.gif">&nbsp;</td>
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
                                                        <div align="center"><img src="../../../images/tb.gif" width="14"
                                                                                 height="14"/></div>
                                                    </td>
                                                    <td width="94%" valign="bottom"><span class="STYLE1">固定资产报增单</span>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <div align="right"><span class="STYLE1">&nbsp;</span><span class="STYLE1"> &nbsp;</span>
                                            </div>
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
                                    <tr style="height: 30px;">
                                        <td nowrap align="right">报增单位:</td>
                                        <td nowrap>
                                            11111111
                                        </td>
                                        <td nowrap align="right">时间:</td>
                                        <td nowrap>
                                            11111111
                                        </td>
                                        <td nowrap align="right">报增单编号:</td>
                                        <td nowrap>
                                           11111111111111111111
                                        </td>
                                    </tr>
                                    <tr style="height: 30px;">
                                        <td nowrap align="right">品名:</td>
                                        <td nowrap>
                                           11111111
                                        </td>
                                        <td nowrap align="right">单价:</td>
                                        <td nowrap>
                                            11111111
                                        </td>
                                        <td nowrap align="right">经费科目:</td>
                                        <td nowrap>

                                                985项目

                                        </td>
                                    </tr>
                                    <tr style="height: 30px;">

                                        <td nowrap align="right">型号:</td>
                                        <td nowrap>
                                            11111111
                                        </td>


                                        <td nowrap align="right">出厂日期:</td>
                                        <td nowrap>
                                            11111111
                                        </td>
                                        <td nowrap align="right">使用方向:</td>
                                        <td nowrap>
                                            11111111
                                        </td>

                                    </tr>
                                    <tr style="height: 30px;">
                                        <td nowrap align="right">规格:</td>
                                        <td nowrap>
                                            11111111
                                        </td>
                                        <td nowrap align="right">购置日期:</td>
                                        <td nowrap>
                                            11111111
                                        </td>
                                        <td nowrap align="right">厂家:</td>
                                        <td nowrap>
                                            11111111
                                        </td>

                                    </tr>
                                    <tr style="height: 30px;">

                                        <td nowrap align="right">国别:</td>
                                        <td nowrap>
                                            11111111
                                        </td>

                                        <td nowrap align="right">批量数:</td>
                                        <td nowrap>
                                            11111111
                                        </td>
                                        <td nowrap align="right">金额合计:</td>
                                        <td nowrap>
                                            11111111
                                        </td>

                                    </tr>
                                    <tr style="height: 30px;">

                                        <td nowrap align="right">设备管理部门:</td>
                                        <td nowrap>
                                            11111111
                                        </td>

                                        <td nowrap align="right">单位负责人:</td>
                                        <td nowrap>
                                            11111111
                                        </td>
                                        <td nowrap align="right">经办人:</td>
                                        <td nowrap>
                                            11111111
                                        </td>

                                    </tr>
                                    <tr style="height: 30px;">

                                        <td nowrap align="right">保管人:</td>
                                        <td nowrap>
                                            11111111
                                        </td>


                                    </tr>
                                    <tr height="16px"></tr>
                                    <tr>
                                        <td nowrap align="right">设备编号:</td>
                                        <td nowrap>
                                            <input id="deviceNo" class="text" style="width:154px" maxlength="20"/>
                                            <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id=""></span>
                                        </td>
                                        <td nowrap align="right">出厂号:</td>
                                        <td nowrap>
                                            <input id="factoryNo" class="text" style="width:154px" maxlength="20"/>
                                            <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id=""></span>
                                        </td>
                                        <td nowrap align="right">附件数量:</td>
                                        <td nowrap>
                                            <input id="accessoryNum"  class="text" style="width:154px" maxlength="20"/>
                                            <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id=""></span>
                                        </td>
                                    </tr>
                                </table>
                                </div>

                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td align="center">
                                            <input type="button" name="Submit" value="保存" class="button" onclick="addDevice();"/>
                                            <input type="reset" name="Submit3" value="重置" class="button"
                                                   onclick="reset();"/>
                                            <input type="button" name="Submit" value="提交" class="button" onclick="save();"/>
                                            <input type="button" name="Submit2" value="返回" class="button"
                                                   onclick="window.history.go(-1);"/>
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
    <td background="../../../images/mail_rightbg.gif">&nbsp;</td>
</tr>
<tr>
    <td valign="bottom" background="../../../images/mail_leftbg.gif"><img src="../../../images/buttom_left2.gif"
                                                                          width="17" height="17"/></td>
    <td valign="bottom" background="../../../images/buttom_bgs.gif"><img src="../../../images/buttom_bgs.gif"
                                                                         width="100%" height="17"></td>
    <td valign="bottom" background="../../../images/mail_rightbg.gif"><img
            src="../../../images/buttom_right2.gif" width="16" height="17"/></td>
</tr>
</table>
<input type="hidden" name="us_sreplyby" value=""/>
</form>
</body>