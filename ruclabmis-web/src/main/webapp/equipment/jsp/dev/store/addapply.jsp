<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>

<script>
    function save() {
        document.form1.action = "applylist.html";
        document.form1.submit();
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
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
               id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">设备基本信息管理 > 实验设备入库</div>
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
                                                        <div align="center"><img src="../../../images/tb.gif"
                                                                                 width="14" height="14"/></div>
                                                    </td>
                                                    <td width="94%" valign="bottom"><span class="STYLE1">实验设备入库申请</span>
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
                                        <td align="center">单据号</td>
                                        <td>&nbsp;<input type="text"> <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_us_sname"></span></td>
                                        <td align="center">数量</td>
                                        <td>&nbsp;<input type="text"> <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_us_sname"></span></td>
                                        <td align="center">经费来源</td>
                                        <td>&nbsp;<input type="text"> <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_us_sname"></span></td>
                                    </tr>
                                    <tr>
                                        <td align="center">经办人</td>
                                        <td>&nbsp;<input type="text" style="color:#aaa"  readonly="readonly" value="<shiro:principal/>"> <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_us_sname"></span></td>
                                    </tr>
                                    <tr>
                                        <td align="center">负责人</td>
                                        <td>&nbsp;<input type="text"> <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_us_sname"></span></td>

                                        <td align="center">保管人</td>
                                        <td>&nbsp;<input type="text"> <span style="color:red;">*</span>&nbsp;&nbsp;
                                            <span style="color:red;" id="errMsg_us_sname"></span></td>
                                    </tr>


                                </table>
                            </td>
                        </tr>
                    </table>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td align="center">
                                <input type="button" name="save" value="保存" class="button" onclick="save();"/>
                                <input type="reset" name="reset" value="重置" class="button"
                                       onclick="reset();"/>
                                <input type="button" name="Submit2" value="返回" class="button"
                                       onclick="window.history.go(-1);"/>
                            </td>
                        </tr>
                    </table>


                </td>
            </tr>

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
                                                    <td width="94%" valign="bottom"><span class="STYLE1">设备列表</span>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <div align="right">
                                                <span class="STYLE1" style="white-space:nowrap">
                                                        <a onclick="addDevice()"><img src="../../../images/add_min.gif" width="10" height="10"
                                                                                      border="0"/> <span class="STYLE1">添加设备</span></a>&nbsp;
                                                      <a href="add.html"><img src="../../../images/add_min.gif" width="10" height="10" border="0"/>
                                                          <span class="STYLE1">修改设备</span></a>&nbsp;
                                                     <a href="add.html"><img src="../../../images/add_min.gif" width="10" height="10" border="0"/>
                                                         <span class="STYLE1">移除设备</span></a>&nbsp;
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
            <tr valign="top">
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
                                <td width="100" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">出厂号</span></div>
                                </td>
                                <td width="100" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">备注</span></div>
                                </td>
                            </tr>
                            <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                <td height="20"><input name="idcheckbox" type="checkbox" value="admin" onclick="checkOne(this)"/></td>
                                <td>1</td>

                                <td title="">SQ0001</td>



                                <td title="">79017700</td>

                                <td title="">04410101</td>


                                <td title="">备注</td>

                            </tr>

                            <tr height="16px"></tr>
                        </table>
                    </div>

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
