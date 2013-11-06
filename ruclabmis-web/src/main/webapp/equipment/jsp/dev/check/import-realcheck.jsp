<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设备资产实盘导入</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="/equipment/css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/util.js"></script>
    <script type="text/javascript" src="/js/page.js"></script>
</head>
<body>
<form name="importRealCheck" method="post" id="importRealCheck" enctype="multipart/form-data">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="/equipment/images/mail_leftbg.gif">
                <img src="/equipment/images/left-top-right.gif" width="17" height="29"/>
            </td>
            <td valign="top" background="/equipment/images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">设备信息管理 >设备资产实盘导入</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="/equipment/images/mail_rightbg.gif">
                <img src="/equipment/images/nav-right-bg.gif" width="16" height="29"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" background="/equipment/images/mail_leftbg.gif">&nbsp;</td>
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
                                                                <div align="center"><img src="/equipment/images/tb.gif"
                                                                                         width="14" height="14"/></div>
                                                            </td>
                                                            <td width="94%" valign="bottom"><span
                                                                    class="STYLE1">设备资产实盘文件导入</span></td>
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
                                                <td nowrap align="right">是否清空:</td>
                                                <td nowrap>
                                                    <input type="checkbox" name="clean" id="clean" checked/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">选择文件:</td>
                                                <td nowrap>
                                                    <input type="file" name="file" id="file"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_file"></span>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="center">
                                        <input type="submit" name="Submit" value="提交" class="button"/>
                                        <input type="reset" name="Submit3" value="重置" class="button"
                                               onclick="reset();"/>
                                        <input type="button" name="Submit2" value="返回" class="button"
                                               onclick="window.history.go(-1);"/>
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
                                                                                 width="100%" height="17"></td>
            <td valign="bottom" background="/equipment/images/mail_rightbg.gif"><img
                    src="/equipment/images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>