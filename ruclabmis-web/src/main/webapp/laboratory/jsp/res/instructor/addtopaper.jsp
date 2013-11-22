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
        var baseHref = '/laboratory/jsp/experiment/paper/addtopaper';


        function toApply()
        {
            var id = "141";
            var selectedItems = getAllSelected('listForm', 'idcheckbox');
            if(selectedItems.length <= 0 )
            {
                alert("请选择要添加的的题目！");
                return;
            }

            if( id != "") //有父窗体则刷新父窗体，关闭自己
            {
                document.forms["listForm"].action = "addQuestion?questionId="+id+"&items=" + selectedItems;
                document.forms["listForm"].submit();

                window.opener.location.href=window.opener.location.href;
                window.close();
            }
            else //无父窗体则跳转至表单页面
            {
                document.forms["listForm"].action = "toApply?items=" + selectedItems;
                document.forms["listForm"].submit();
            }

        }




    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">

<table width="98%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
                src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
        <td valign="top" background="../../../../images/content-bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                <tr>
                    <td height="31">
                        <div class="titlebt">试卷修改 > 添加题目到试卷</div>
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

                         <span style="white-space:nowrap">&nbsp;&nbsp;题目名称:<input type="text" name="questionName"
                                                                                  id="questionName" value=""
                                                                                  style="width:100px;"/></span>


                        <span style="white-space:nowrap">&nbsp;&nbsp;题目内容:<input type="text" name="questionContent"
                                                                                 id="questionContent" value=""
                                                                                 style="width:100px;"/></span>


                      <span style="white-space:nowrap">&nbsp;&nbsp;
                             <a href="javascript:void(0)" onclick="toFind('listForm');">
                                 <img src="../../../../images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>


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
                                                                            style="white-space:nowrap">题目列表</span>
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
                                                    <div align="center"><span class="STYLE10">题目名称</span></div>
                                                </td>

                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">题目内容</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">答案</span></div>
                                                </td>

                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">查看详细</span></div>
                                                </td>
                                            </tr>
                                            <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                <td height="20"><input name="idcheckbox" type="checkbox"
                                                                       value="${item.id}" onclick="checkOne('listForm', 'idcheckbox')"/>
                                                <td>题目名称</td>
                                                <td>下面属于面向对象编程的语言有（）A、 C语言 B、 C++ C、 HTML D、 Java</td>
                                                <td>D</td>
                                                <td><a href="../experimentquestion/detail?question_id=${item.id}">查看详细</a></td>
                                            </tr>


                                            <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                <td height="20"><input name="idcheckbox" type="checkbox"
                                                                       value="${item.id}" onclick="checkOne('listForm', 'idcheckbox')"/>
                                                <td>题目名称</td>
                                                <td>关于面向对象:(1)什么是面向对象的编程语言(2)请举出几种常见的面向对象的语言。(3)什么是类？什么是对象？</td>
                                                <td>(1)面向对象的语言就是……(2)Java、C#……(3)类就是……</td>
                                                <td><a href="../experimentquestion/detail?question_id=${item.id}">查看详细</a></td>
                                            </tr>

                                            <c:forEach items="${pageInfo.data}" var="item">
                                                <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                    <td height="20"><input name="idcheckbox" type="checkbox"
                                                                           value="${item.id}" onclick="checkOne('listForm', 'idcheckbox')"/>
                                                    </td>
                                                    <td>${item.name}</td>

                                                    <td>${item.questionContent}</td>
                                                    <td>${item.answerContent}</td>
                                                    <td><a href="../experimentquestion/detail?question_id=${item.id}">查看详细</a></td>
                                                </tr>
                                            </c:forEach>
                                            <tr height="16px"></tr>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            <%@ include file="../../common/pagetable.jsp"%>
                        </table>
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td align="center">
                                    <input type="button" name="Submit2" value="返回" class="button"
                                           onclick="window.history.go(-1);"/>
                                    <input type="button" name="Submit" value="添加选中题目到本试卷" class="button"
                                           onclick="toApply();return false;"/>

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
