<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>
<script type="text/javascript" src="/js/autocomplete/jquery-1.9.1.js"></script>
<script type="text/javascript" src="/js/chosen/chosen.jquery.min.js"></script>

<script>
    function save() {

        if (!validator(document.mainForm)) {
            return;
        }

        $.post("/laboratory/jsp/appointment/laboratory/multiadd", {
            startTime :"<fmt:formatDate value="${startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>",
            endTime :"<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>",
            description :$("#description").val(),
            roomId :$("#roomId").val(),
            phoneNum :$("#phoneNum").val(),
            beginWeek :${beginWeek},
            endWeek :${endWeek},
            weekDay :${weekDay},
            termYearId :${termYearId},
            type:"${appointmentType}"
        }, function (data) {
            alert(data.message);
            if (data.success) {
                parent.location.href = "/laboratory/jsp/appointment/laboratory/multilist";
            }
        });
    }
//
//    function save() {
//        document.mainForm.action = "/laboratory/jsp/appointment/laboratory/add";
//        document.mainForm.submit();
//
//        parent.location.href = "/laboratory/jsp/appointment/laboratory/list";
//    }
</script>
<body>
<form name="mainForm" method="post">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif">
                <img src="../../../../images/left-top-right.gif" width="17" height="29"/>
            </td>
            <td valign="top" background="../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="positionbt">预约申请</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="../../../../images/mail_rightbg.gif">
                <img src="../../../../images/nav-right-bg.gif" width="16" height="29"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" background="../../../../images/mail_leftbg.gif"></td>
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
                                                                    class="STYLE1">申请信息详情</span></td>
                                                        </tr>
                                                    </table>
                                                </td>
                                                <td>
                                                    <div align="right"><span class="STYLE1"></span><span
                                                            class="STYLE1"> </span></div>
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
                                                <td nowrap align="right">预约房间:</td>
                                                <td nowrap>
                                                    <input name="roomId" id="roomId" type="hidden" value="${room.getId()}"/>
                                                    <input name="roomName" id="roomName" value="${room.getName()}" onblur=""
                                                           class="text" readonly style="width:154px;color:#aaaaaa"/>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td nowrap align="right">申请人:</td>
                                                <td nowrap>
                                                    <input name="user" id="user" value="<shiro:principal/>" onblur=""
                                                           class="text" readonly style="width:154px;color:#aaaaaa"/>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right"> 学期:</td>
                                                <td nowrap>
                                                    <input name="term" id="term" value="${termYear.name}" onblur=""
                                                           class="text" readonly style="width:154px;color:#aaaaaa"/>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">周次:</td>
                                                <td nowrap>
                                                    <input name="week" id="week" value="${beginWeek}-${endWeek}" onblur=""
                                                           class="text" readonly style="width:154px;color:#aaaaaa"/>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td nowrap align="right">星期:</td>
                                                <td nowrap>
                                                    <input name="weekDay" id="weekDay"
                                                           <c:if test="${weekDay==1}">value="星期一"</c:if>
                                                           <c:if test="${weekDay==2}">value="星期二"</c:if>
                                                           <c:if test="${weekDay==3}">value="星期三"</c:if>
                                                           <c:if test="${weekDay==4}">value="星期四"</c:if>
                                                           <c:if test="${weekDay==5}">value="星期五"</c:if>
                                                           <c:if test="${weekDay==6}">value="星期六"</c:if>
                                                           <c:if test="${weekDay==7}">value="星期天"</c:if>

                                                           onblur=""
                                                           class="text" readonly style="width:154px;color:#aaaaaa"/>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">预约时间段:</td>
                                                <td nowrap>
                                                    <input name="scheduleSection" id="scheduleSection" onblur=""
                                                           class="text" readonly style="width:354px;color:#aaaaaa"
                                                           value="<fmt:formatDate value="${startTime}" pattern="HH:mm:ss"/> - <fmt:formatDate value="${endTime}" pattern="HH:mm:ss"/>"
                                                            />
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td nowrap align="right">联系电话:</td>
                                                <td nowrap>
                                                    <input name="phoneNum" id="phoneNum" value="" valid="required" errmsg="请输入联系电话!"
                                                           class="text"  style="width:154px;color:#aaaaaa"/>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="right"  align="right">申请内容描述：</td>
                                                <td  colspan="4">
                                                    <textarea name="description" id="description"
                                                             cols="60" rows="10" valid="required" errmsg="请填写申请信息"
                                                              style="width: 90%;height: 350"></textarea> <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="center">
                                        <input type="button" name="Submit" value="提交申请" class="button" onclick="save();"/>
                                        <input type="button" name="return" value="返回" class="button"
                                               onclick="window.history.go(-1);" />
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td background="../../../../images/mail_rightbg.gif"></td>
        </tr>
        <tr>
            <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/buttom_left2.gif"
                    width="17" height="17"/></td>
            <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img
                    src="../../../../images/buttom_bgs.gif"
                    width="100%" height="17"></td>
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>

</form>
</body>
