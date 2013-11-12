<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <title></title>
    <script>
    </script>
</head>

<body onload="getwidth()" onresize="getwidth()">

<form name="form1" method="post">
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../images/mail_leftbg.gif"><img
                    src="../../../images/left-top-right.gif" width="17" height="29"/></td>
            <td valign="top" background="../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">设备信息查询 > 设备信息查询</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="../../../images/mail_rightbg.gif"><img
                    src="../../../images/nav-right-bg.gif" width="16" height="29"/></td>
        </tr>

        <tr>
            <td valign="middle" background="../../../images/mail_leftbg.gif"></td>
            <td valign="top" bgcolor="#F7F8F9">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
                    <tr>
                        <td valign="top" class="STYLE10">
                            <div style="border: 1px solid;width:99%;">
                                <table width="100%" border="0" cellpadding="0">
                                    <tr>
                                        <td align='right'>使用部门</td>
                                        <td align='left'>
                                            <select id="searchDepartment" name="searchDepartment">
                                                <option value="">——请选择——</option>
                                                <option value="0">网络工程系</option>
                                                <option value="1">软件工程系</option>
                                            </select>
                                        </td>
                                        <td align='right'>使用人</td>
                                        <td align='left'>
                                            <input type="text" name="searchUser" id="searchUser" style="width:100px;"/></span>
                                        </td>
                                        <td align='right'>设备状态</td>
                                        <td align='left'>
                                            <select id="searchState" name="searchState">
                                                <option value="">——请选择——</option>
                                                <option value="0">正常</option>
                                                <option value="1">维修</option>
                                                <option value="1">报废</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align='right'>使用方向</td>
                                        <td align='left'><select id="searchDirection" name="searchDirection">
                                            <option value="">——请选择——</option>
                                            <option value="0">教学</option>
                                            <option value="1">科研</option>
                                            <option value="1">行政</option>
                                            <option value="1">后勤</option>
                                            <option value="1">生产</option>
                                            <option value="1">开发</option>
                                            <option value="1">社会服务</option>
                                            <option value="1">其他</option>
                                        </select></td>

                                        <td align='right'>经费科目</td>
                                        <td align='left'><select id="searchFunding" name="searchFunding">
                                            <option value="">——请选择——</option>
                                            <option value="0">教学</option>
                                            <option value="1">科研</option>
                                            <option value="1">基建</option>
                                            <option value="1">自筹</option>
                                            <option value="1">世行贷款</option>
                                            <option value="1">捐赠</option>
                                            <option value="1">其他</option>
                                        </select></td>
                                    </tr>
                                    <tr>
                                        <td colspan="8" align="center"><input type="submit" value="查询"></span>
                                        </td>
                                    </tr>
                                </table>
                            </div>

                            <@
                        </td>
                    </tr>
                </table>
            </td>
            <td background="../../../images/mail_rightbg.gif"></td>
        </tr>
        <tr>
            <td valign="bottom" background="../../../images/mail_leftbg.gif"><img src="../../../images/buttom_left2.gif"
                                                                                  width="17" height="17"/></td>
            <td valign="bottom" background="../../../images/buttom_bgs.gif"><img src="../../../images/buttom_bgs.gif"
                                                                                 width="100%" height="17"/></td>
            <td valign="bottom" background="../../../images/mail_rightbg.gif"><img src="../../../images/buttom_right2.gif"
                                                                                   width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>
