<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        var baseHref = '/prototype/jsp/res/paper/editpaper';
    </script>

</head>

<body onload="getwidth()" onresize="getwidth()">

<form name="listForm" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="17" valign="top" background="../../../images/mail_leftbg.gif">
            <img src="../../../images/left-top-right.gif" width="17" height="29"/>
        </td>
        <td valign="top" background="../../../images/content-bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                <tr>
                    <td height="31">
                        <div class="titlebt">试卷资源管理 > 编辑试卷</div>
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
                                                        <td width="94%" valign="bottom"><span
                                                                class="STYLE1">添加试卷资源</span></td>
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
                                            <td nowrap align="right">试卷编号:</td>
                                            <td nowrap>
                                                <input name="paperNo" id="paperNo" onblur="" class="text"
                                                       style="width:154px" maxlength="20" valid="required|isAccount"
                                                       value="SJ001" readonly/>
                                                <span style="color:red;">*</span>&nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_us_sno"></span>
                                            </td>
                                            <td nowrap align="right">试卷名称:</td>
                                            <td nowrap>
                                                <input name="paperName" id="paperName" onblur="" class="text"
                                                       style="width:154px" maxlength="20" valid="required|isAccount"
                                                       value="软件工程清考试题" readonly/>
                                                <span style="color:red;">*</span>&nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_us_sno"></span>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td nowrap align="right">所属课程:</td>
                                            <td nowrap>
                                                <input name="theCourse" id="theCourse" onblur="" class="text"
                                                       style="width:154px" maxlength="20" valid="required|isAccount"
                                                       value="软件工程" readonly/>
                                                <span style="color:red;">*</span>&nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_us_sno"></span>

                                            </td>
                                            <td nowrap align="right">考试时间:</td>
                                            <td nowrap>
                                                <input name="examTime" id="examTime" onblur="" class="text"
                                                       style="width:154px" maxlength="20" valid="required|isAccount"
                                                       value="2012-02-12" readonly/>
                                                <span style="color:red;">*</span>&nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_us_sname"></span>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td nowrap align="right">命题人:</td>
                                            <td nowrap>
                                                <input name="proposition" id="proposition" class="text" style="width:154px"
                                                       valid="required|isPassword" value="赵天华" readonly/>
                                                <span style="color:red;"> *</span> &nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_us_spwd"></span>
                                            </td>
                                            <td nowrap align="right">是否用过:</td>
                                            <td nowrap>
                                                <input name="isUsed" id="isUsed" class="text" style="width:154px"
                                                       valid="required|isPassword" value="是" readonly/>
                                                <span style="color:red;"> *</span> &nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_us_spwd"></span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td nowrap align="right">用途:</td>
                                            <td nowrap>
                                                <input name="theUse" id="theUse" class="text" style="width:154px"
                                                       valid="required|isPassword" value="清考" readonly/>
                                                <span style="color:red;"> *</span> &nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_us_spwd"></span>
                                            </td>
                                            <td nowrap align="right">考试时间长度(min):</td>
                                            <td nowrap>
                                                <input name="theTime" id="theTime" class="text" style="width:154px"
                                                       valid="required|isPassword" value="90" readonly/>
                                                <span style="color:red;"> *</span> &nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_us_spwd"></span>
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
        <td valign="bottom" background="../../../images/mail_rightbg.gif"><img src="../../../images/buttom_right2.gif"
                                                                               width="16" height="17"/></td>
    </tr>
</table>


<table width="98%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="17" valign="top" background="../../../images/mail_leftbg.gif"><img
                src="../../../images/left-top-right.gif" width="17" height="29"/></td>
        <td valign="top" background="../../../images/content-bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="">
                <tr>
                    <td height="31">
                        <div class="titlebt">资源管理 > 试题资源管理</div>
                    </td>
                </tr>
            </table>
        </td>
        <td width="16" valign="top" background="../../../images/mail_rightbg.gif"><img
                src="../../../images/nav-right-bg.gif" width="16" height="29"/></td>
    </tr>

    <tr>
        <td valign="middle" background="../../../images/mail_leftbg.gif">&nbsp;</td>
        <td valign="top" bgcolor="#F7F8F9">
            <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
                <tr>
                    <td valign="top" class="STYLE10">

                        <span style="white-space:nowrap">&nbsp;&nbsp;题目编号名称:<input type="text" name="questionNo"
                                                                                    id="questionNo" value=""
                                                                                    style="width:100px;"/></span>
		<span style="white-space:nowrap">&nbsp;&nbsp;题目类型:<select id="questionType" name="questionType">
            <option value="">请选择</option>
            <option value="0">单选</option>
            <option value="1">多选</option>
            <option value="2">填空</option>
            <option value="3">简答</option>
        </select></span>
                        <span style="white-space:nowrap">&nbsp;&nbsp;所属课程:<input type="text" name="thQuestionCourse"
                                                                                 id="thQuestionCourse" value=""
                                                                                 style="width:100px;"/></span>
                        <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);" style="cursor:hand"
                                                                        onclick="findInfo()"><img
                                src="../../../images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>


                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td height="30">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td height="24" bgcolor="#353c44"></td>
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
                                                <td width="150" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">问题项一</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">问题项二</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">问题项三</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">问题项四</span></div>
                                                </td>

                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">答案</span></div>
                                                </td>

                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">查看详细</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">删除</span></div>
                                                </td>
                                            </tr>
                                            <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                <td height="20"><input name="idcheckbox" type="checkbox" value="admin"
                                                                       onclick="checkOne(this)"/></td>
                                                <td>1</td>
                                                <td>XZ001</td>
                                                <td>编程语言</td>
                                                <td>选择题目</td>
                                                <td>下面属于面向对象编程的语言有（）</td>
                                                <td>A、 C语言</td>
                                                <td>B、 C++</td>
                                                <td>C、 HTML</td>
                                                <td>D、 Java</td>
                                                <td>D</td>
                                                <td><a>查看详细</a></td>
                                                <td><a>删除</a></td>
                                            </tr>
                                            <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                <td height="20"><input name="idcheckbox" type="checkbox" value="admin"
                                                                       onclick="checkOne(this)"/></td>
                                                <td>2</td>
                                                <td>XZ002</td>
                                                <td>编程语言</td>
                                                <td>选择题目</td>
                                                <td>下面属于面向对象编程的语言有（）</td>
                                                <td>A、 C语言</td>
                                                <td>B、 C++</td>
                                                <td>C、 HTML</td>
                                                <td>D、 Java</td>
                                                <td>D</td>
                                                <td><a>查看详细</a></td>
                                                <td><a>删除</a></td>
                                            </tr>
                                            <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                <td height="20"><input name="idcheckbox" type="checkbox" value="admin"
                                                                       onclick="checkOne(this)"/></td>
                                                <td>3</td>
                                                <td>XZ003</td>
                                                <td>编程语言</td>
                                                <td>选择题目</td>
                                                <td>下面属于面向对象编程的语言有（）</td>
                                                <td>A、 C语言</td>
                                                <td>B、 C++</td>
                                                <td>C、 HTML</td>
                                                <td>D、 Java</td>
                                                <td>D</td>
                                                <td><a>查看详细</a></td>
                                                <td><a>删除</a></td>
                                            </tr>

                                            <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                <td height="20"><input name="idcheckbox" type="checkbox" value="admin"
                                                                       onclick="checkOne(this)"/></td>
                                                <td>4</td>
                                                <td>JD001</td>
                                                <td>编程语言</td>
                                                <td>简答题</td>
                                                <td>关于面向对象</td>
                                                <td>(1)什么是面向对象的编程语言。</td>
                                                <td>(2)请举出几种常见的面向对象的语言。</td>
                                                <td>(3)什么是类？什么是对象？</td>
                                                <td>&nbsp</td>
                                                <td>(1)面向对象的语言就是……(2)Java、C#……(3)类就是……</td>
                                                <td><a>查看详细</a></td>
                                                <td><a>删除</a></td>
                                            </tr>

                                            <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                <td height="20"><input name="idcheckbox" type="checkbox" value="admin"
                                                                       onclick="checkOne(this)"/></td>
                                                <td>5</td>
                                                <td>JD002</td>
                                                <td>编程语言</td>
                                                <td>简答题</td>
                                                <td>关于面向对象</td>
                                                <td>(1)什么是面向对象的编程语言。</td>
                                                <td>(2)请举出几种常见的面向对象的语言。</td>
                                                <td>(3)什么是类？什么是对象？</td>
                                                <td>&nbsp</td>
                                                <td>(1)面向对象的语言就是……(2)Java、C#……(3)类就是……</td>
                                                <td><a>查看详细</a></td>
                                                <td><a>删除</a></td>
                                            </tr>
                                            <tr height="16px"></tr>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td height="30">
                                    <table width='100%' border='0' cellspacing='0' cellpadding='0'
                                           style='font-size:13px;'>
                                        <tr>
                                            <td><span align='left' class='STYLE22' style="white-space:nowrap">&nbsp;&nbsp;共有<strong>2</strong> 条记录，当前第<strong>1</strong> 页，共 <strong>1</strong> 页</span>
				<span class='STYLE22' style="white-space:nowrap">
				<table border='0' align='right' cellpadding='0' cellspacing='0' style='font-size:13px;'>
                    <tr>
                        <td width='49'>
                            <div align='center'><img src='../../../images/main_54.gif' width='40' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img src='../../../images/main_56.gif' width='45' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img src='../../../images/main_58.gif' width='45' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img src='../../../images/main_60.gif' width='40' height='15'
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

                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td align="center">
                                    <input type="button" name="Submit" value="保存" class="button" onclick="save();"/>
                                    <input type="reset" name="Submit3" value="重置" class="button" onclick="reset();"/>
                                    <input type="button" name="Submit2" value="返回" class="button"
                                           onclick="window.history.go(-1);"/>
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
                                                                             width="100%" height="17"/></td>
        <td valign="bottom" background="../../../images/mail_rightbg.gif"><img src="../../../images/buttom_right2.gif"
                                                                               width="16" height="17"/></td>
    </tr>
</table>
</form>
</body>
</html>
