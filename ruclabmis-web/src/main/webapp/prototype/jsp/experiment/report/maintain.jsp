<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <script src="../../../../js/DatePicker/WdatePicker.js" type=text/javascript></script>

    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        var baseHref = '/prototype/jsp/experiment/experimentpaper/maintain';


        function update() {
            if(!validator(document.listForm)){
                return;
            }

            document.listForm.action = "maintain";
            document.listForm.submit();
        }


    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">

<table width="98%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="17" valign="top" background="../../../images/mail_leftbg.gif"><img
                src="../../../images/left-top-right.gif" width="17" height="29"/></td>
        <td valign="top" background="../../../images/content-bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                <tr>
                    <td height="31">
                        <div class="titlebt">实验报告管理 > 维护实验报告上传信息</div>
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
                                                                class="STYLE1">维护实验报告上传信息</span></td>
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
                                            <td nowrap align="right">实验编号:</td><td nowrap>${experiment.experimentNo}</td>
                                            <td nowrap align="right">实验名称:</td><td nowrap>${experiment.experimentName}</td>

                                        </tr>
                                        <tr>
                                            <td nowrap align="right">所属课程:</td><td nowrap>${experiment.courseList}</td>
                                            <td nowrap align="right">指导老师:</td><td nowrap>${experiment.instructor}</td>
                                        </tr>
                                        <tr>
                                            <td nowrap align="right">实验指导书:</td><td nowrap>${experiment.instructor}</td>
                                            <td nowrap align="right">实验报告书:</td><td nowrap>${experiment.experimentReport}</td>
                                        </tr>
                                        <tr>
                                            <td nowrap align="right">是否提交实验报告:</td>
                                            <td nowrap>
                                                <select name="ifReported">
                                                    <c:if test="${experiment.ifReported==null}">
                                                        <option selected></option>
                                                    </c:if>
                                                    <c:if test="${experiment.ifReported==1}">
                                                        <option value="0" selected>是</option>
                                                    </c:if>
                                                    <c:if test="${experiment.ifReported==0}">
                                                        <option value="0" selected>否</option>
                                                    </c:if>
                                                </select>
                                            </td>
                                            <td nowrap align="right">最后提交期限:</td>
                                            <td nowrap>
                                                <input name="limitTime" id="manufactureDate"
                                                       onblur="" class="Mdate" style="width:154px" maxlength="10"
                                                       valid="isDate" errmsg="日期只能为：XXXX-XX-XX"
                                                       onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${experiment.limitTime}"/>
                                                <span style="color:red;"> *</span> &nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_us_spwd"></span>
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
