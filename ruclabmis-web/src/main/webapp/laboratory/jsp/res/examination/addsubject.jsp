<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/autocomplete/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/util.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/page.js"></script>
    <script>
        function makeDocumentFromSubject() {
            var idArr = new Array();
            $.each($("input[name='idcheckbox']:checked"), function (idx, data) {
                idArr.push($(data).val());
            });
            $.post("/laboratory/jsp/res/examination/addSubject", {
                'name': $('#name').val(),
                'structIds': idArr.join(",")
            }, function (data) {
                if (data.success) {
                    window.opener.freshDocName(data.message);
                    window.close();
                } else {
                    alert(data.message);
                }
            });
        }

        function addSubjectDocument()
        {
            makeDocumentFromSubject();
        }
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
    <input name="name" id="name" type="hidden" value="${name}">
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
            <td valign="top" background="../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">考试修改 > 添加考试题到考试</div>
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

                         <span style="white-space:nowrap">考试题名称:<input type="text" name="questionName"
                                                                       id="questionName" value=""
                                                                       style="width:100px;"/></span>
                            <span style="white-space:nowrap">
                             <a href="javascript:void(0)" onclick="toFind('listForm');">
                                 <img src="../../../../images/zoom.png" width="15" height="15" border="0"/> 查询
                             </a>
                            </span>

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
                                                                                style="white-space:nowrap">考试题列表</span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td>

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

                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">考试题名称</span></div>
                                                    </td>
                                                </tr>

                                                <c:forEach items="${subjects}" var="item">
                                                    <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                        <td height="20"><input name="idcheckbox" type="checkbox"
                                                                               value="${item.id}" onclick="checkOne('listForm', 'idcheckbox')"/>
                                                        </td>
                                                        <td>${item.name}</td>
                                                    </tr>
                                                </c:forEach>
                                                <tr height="16px"></tr>
                                            </table>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="center">
                                        <input type="button" name="return" value="返回" class="button"
                                               onclick="window.history.go(-1);"/>
                                        <input type="button" name="button" value="生成考试" class="button"
                                               onclick="addSubjectDocument();"/>
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
