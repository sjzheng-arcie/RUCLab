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
        var baseHref = '/laboratory/jsp/res/experimentquestion/list';
    </script>

</head>

<body onload="getwidth()" onresize="getwidth()">

<form name="listForm" method="post">
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
            <td valign="top" background="../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">资源管理 > 实验题目管理</div>
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

                            <span style="white-space:nowrap">&nbsp;&nbsp;题目编号.:<input type="text" name="questionNo"
                                                                                        id="questionNo" value=""
                                                                                        style="width:100px;"/></span>
		<span style="white-space:nowrap">&nbsp;&nbsp;题目类型:<select id="questionType" name="questionType">
            <option value="">请选择</option>
            <option value="0">单选</option>
            <option value="1">多选</option>
            <option value="2">填空</option>
            <option value="3">简答</option>
        </select></span>
                            <span style="white-space:nowrap">&nbsp;&nbsp;所属课程:<input type="text" name="theCourse"
                                                                                     id="theCourse" value=""
                                                                                     style="width:100px;"/></span>
                            <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);"
                                                                            style="cursor:hand"
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
                                                                                    width="14" height="14"/></div>
                                                                        </td>
                                                                        <td width="94%" valign="bottom"><span
                                                                                class="STYLE1"
                                                                                style="white-space:nowrap">题目资源列表</span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td>
                                                                <div align="right">
	            	<span class="STYLE1" style="white-space:nowrap">
						<a href="add.html"><img src="../../../../images/add_min.gif" width="10" height="10" border="0"/>
                            <span class="STYLE1">新增</span></a>&nbsp;
      					<a href="#" onclick="toUpdate();"><img src="../../../../images/edit_min.gif" width="10" height="10"
                                                               border="0"/> <span class="STYLE1">修改</span></a>&nbsp;
      					<a href="#" onclick="toDelete();"><img src="../../../../images/del_min.gif" width="10" height="10"
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
                                            <table width="100%" class="table" id="table1" border="0" cellpadding="0"
                                                   cellspacing="1" bgcolor="#a8c7ce">
                                                <tr>
                                                    <td width="40" height="20" bgcolor="d3eaef" class="STYLE10">
                                                        <div align="center">
                                                            <input type="checkbox" name="checkbox" id="checkbox"
                                                                   onclick="checkAll(this);"/>
                                                        </div>
                                                    </td>
                                                    <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">序号</span></div>
                                                    </td>
                                                    <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">编号</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">所属科目</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">题目类型</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">题目内容</span></div>
                                                    </td>
                                                    <td width="80" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">难易程度</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">正确率</span></div>
                                                    </td>

                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">查看详细</span></div>
                                                    </td>
                                                </tr>
                                                <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                    <td height="20"><input name="idcheckbox" type="checkbox"
                                                                           value="admin" onclick="checkOne(this)"/></td>
                                                    <td>1</td>
                                                    <td>XZ001</td>
                                                    <td>编程语言</td>
                                                    <td>选择题目</td>
                                                    <td>下面属于面向对象编程的语言有（）</td>
                                                    <td>中</td>
                                                    <td>40%</td>

                                                    <td><a href="detial.html">查看详细</a></td>
                                                </tr>
                                                <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                    <td height="20"><input name="idcheckbox" type="checkbox"
                                                                           value="admin" onclick="checkOne(this)"/></td>
                                                    <td>2</td>
                                                    <td>XZ002</td>
                                                    <td>编程语言</td>
                                                    <td>选择题目</td>
                                                    <td>下面属于面向对象编程的语言有（）</td>
                                                    <td>中</td>
                                                    <td>40%</td>

                                                    <td><a href="detial.html">查看详细</a></td>
                                                </tr>
                                                <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                    <td height="20"><input name="idcheckbox" type="checkbox"
                                                                           value="admin" onclick="checkOne(this)"/></td>
                                                    <td>3</td>
                                                    <td>XZ003</td>
                                                    <td>编程语言</td>
                                                    <td>选择题目</td>
                                                    <td>下面属于面向对象编程的语言有（）</td>
                                                    <td>中</td>
                                                    <td>40%</td>

                                                    <td><a href="detial.html">查看详细</a></td>
                                                </tr>

                                                <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                    <td height="20"><input name="idcheckbox" type="checkbox"
                                                                           value="admin" onclick="checkOne(this)"/></td>
                                                    <td>4</td>
                                                    <td>JD001</td>
                                                    <td>编程语言</td>
                                                    <td>简答题</td>
                                                    <td>关于面向对象</td>
                                                    <td>中</td>
                                                    <td>40%</td>

                                                    <td><a href="detial.html">查看详细</a></td>
                                                </tr>

                                                <c:forEach items="${pageInfo.data}" var="item">
                                                    <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                        <td height="20"><input name="idcheckbox" type="checkbox"
                                                                               value="${item.id}" onclick="checkOne('listForm', 'idcheckbox')"/>
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
                                <%@ include file="../../common/pagetable.jsp"%>
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
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>
