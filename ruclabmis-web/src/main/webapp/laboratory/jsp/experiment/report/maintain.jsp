<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <script type="text/javascript" src="../../../../js/autocomplete/jquery-1.9.1.js"></script>
    <script src="../../../../js/DatePicker/WdatePicker.js" type=text/javascript></script>


    <script>
        function save(){
            $.post("/laboratory/jsp/experiment/experiment/updateExpRep",{
                id :$("#id").val(),
                name:$("#name").val(),
                status:$("#status").val(),
                needReport:$("#needReport").val(),
                reportDeadline:$("#reportDeadline").val(),
                content:$("#content").val()
            },function(data){
                if(data.success){
                    window.location.href = "/laboratory/jsp/experiment/experiment/myexperimentlist?page=1&cid=${cur.id}&view=report&curriculumClassId="+"${curriculumClassId}";
                }else{
                    alert(data.message);
                }
            });
        }
        function update() {
            if (!validator(document.listForm)) {
                return;
            }

            document.listForm.action = "maintain";
            document.listForm.submit();
        }


    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
    <input type="hidden" id="id" name="id" value="${exp.id}"/>
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/left-top-right.gif" width="17" height="29"/></td>
            <td valign="top" background="../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">实验报告管理 > 维护实验报告上传信息</div>
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
                                                <td nowrap align="right">所属课程:</td>
                                                <td nowrap><input type="text" value="${cur.name}" disabled/></td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">实验名称:</td>
                                                <td nowrap><input type="text" name="name" id="name" value="${exp.name}"/></td>
                                                <td nowrap align="right">是否发布:</td>
                                                <td nowrap><select name="status" id="status">
                                                    <option value="false" <c:if test="${!exp.status}">selected="selected" </c:if>>待发布</option>
                                                    <option value="true" <c:if test="${exp.status}">selected="selected" </c:if>>已发布</option>
                                                </select></td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">是否提交报告:</td>
                                                <td nowrap>
                                                    <select name="needReport" id="needReport">
                                                        <option value="false" <c:if test="${!exp.needReport}">selected="selected" </c:if>>否</option>
                                                        <option value="true" <c:if test="${exp.needReport}">selected="selected" </c:if>>是</option>
                                                    </select>
                                                </td>
                                                <td nowrap align="right">报告提交期限:</td>
                                                <td nowrap><input name="reportDeadline" id="reportDeadline"
                                                                  onblur="" class="Mdate" style="width:154px" maxlength="10"
                                                                  valid="isDate" errmsg="日期只能为：XXXX-XX-XX"
                                                                  onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
                                                                  value="<fmt:formatDate value='${exp.reportDeadline}'
                                                                  pattern='yyyy-MM-dd'></fmt:formatDate>" /></td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">实验内容:</td>
                                                <td>
                                                    <textarea name="content" id="content" rows="3">${exp.content}</textarea>
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
                                        <input type="reset" name="reset" value="重置" class="button"
                                               onclick="reset();"/>
                                        <input type="button" name="return" value="返回" class="button"
                                               onclick="window.history.go(-1);"/>
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
            <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/buttom_left2.gif"
                    width="17" height="17"/></td>
            <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img
                    src="../../../../images/buttom_bgs.gif"
                    width="100%" height="17"/></td>
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/buttom_right2.gif"
                    width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>
