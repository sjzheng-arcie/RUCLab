<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <script type="text/javascript" src="../../../../js/autocomplete/jquery-1.9.1.js"></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        var baseHref = '/laboratory/jsp/experiment/experimentpaper/paperinfo';
        function save() {
            document.listForm.action = "update";
            document.listForm.submit();
        }
        function downloadFile(url, data, method) {
            if (url && data) {
                data = typeof data == 'string' ? data : $.param(data);
                var inputs = '';
                $.each(data.split('&'), function () {
                    var p = this.split('=');
                    inputs += '<input type="hidden" name="' + p[0] + '" value="' + p[1] + '" />';
                });
                $('<form action="' + url + '" method="' + (method || 'post') +'" id="'+'downloadForm'+ '">' + inputs + '</form>').
                        appendTo('body').submit().remove();
            }
        }
        function download(eid){
            downloadFile("/laboratory/jsp/experiment/experiment/downloadTemplate",{eid:eid});
        }
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post" enctype="multipart/form-data">
    <input type="hidden" id="id" name="id" value="${exp.id}" />
    <input type="hidden" id="templatePath" name="templatePath" value="${exp.templatePath}" />
    <input type="hidden" id="curriculumId" name="curriculumId" value="${exp.curriculumId}" />
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
            <td valign="top" background="../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">实验管理 > 查看实验</div>
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
                                                                    class="STYLE1">实验信息</span></td>
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
                                                <td nowrap align="right">实验名称:</td>
                                                <td nowrap><input type="text" id="name" name="name" value="${exp.name}"/>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td nowrap align="right">实验内容:</td>
                                                <td colspan="3"><textarea name="content" id="content"
                                                                          style="width:70%;height:100px" >${exp.content}</textarea>
                                                </td>
                                            </tr>
                                            <c:if test="${ac=='show'}">
                                                <c:if test="${exp.templatePath!=null && exp.templatePath!='' }">
                                                    <tr>
                                                        <td nowrap align="right">实验报告模板:</td>
                                                        <td nowrap><input type="button" value="下载" onclick="download('${exp.id}')"/></td>
                                                    </tr>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${ac=='edit'}">
                                                <tr>
                                                    <td nowrap align="right">实验报告模板:</td>
                                                    <td nowrap>
                                                        <input type="file" id="file" name="file" class="button" value="浏览"/>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <c:if test="${ac=='show'}">
                                        <td align="center">
                                            <input type="button" name="return" value="返回" class="button"
                                                   onclick="window.history.go(-1);"/>
                                        </td>
                                    </c:if>
                                    <c:if test="${ac=='edit'}">
                                        <td align="center">
                                            <input type="button" name="Submit" value="保存" class="button" onclick="save();"/>
                                            <input type="button" name="return" value="返回" class="button"
                                                   onclick="window.history.go(-1);"/>
                                        </td>
                                    </c:if>
                                </tr>
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
            <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img
                    src="../../../../images/buttom_bgs.gif"
                    width="100%" height="17"/></td>
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>
