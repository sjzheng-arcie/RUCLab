<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <script type="text/javascript" src="../../../../js/autocomplete/jquery-1.9.1.js"></script>
    <script src="../../../../js/DatePicker/WdatePicker.js" type=text/javascript></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script type="text/javascript">
        function toMaintain(){
            var cid = ${cid};
            var sel = $("input[name='idcheckbox']:checked :first").val();
            if(sel){
               window.location.href = "/laboratory/jsp/experiment/experiment/editExpRep?cid="+cid+"&eid="+sel;
            }else{
                alert("请选择要维护的实验!");
            }
        }
        function toPublic(){
            var ids = new Array();
            $.map($("input[name='idcheckbox']:checked"),function(data){
                ids.push($(data).val());
            });
            console.log(ids.join(","));
            if(ids.length>0){
                $.post("/laboratory/jsp/experiment/experiment/publishExpRep",{
                    ids:ids.join(",")
                },function(data){
                    if(data.success){
                        windown.location.href = window.location.href;
                    }else{
                        alert(data.message);
                    }
                });
            }else{
                alert("请选择要发布的实验!");
            }
        }
        function viewReport(eid,need){
            if(need){
                window.location.href="studentExpDetail?page=1&eid="+eid;
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
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">实验报告管理 > 课程实验</div>
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
                                                                                style="white-space:nowrap">实验信息列表</span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td>
                                                                <div align="right">
                                                                <span class="STYLE1" style="white-space:nowrap">
                                                                    <a href="#" onclick="toMaintain();"><img
                                                                            src="../../../../images/edit_min.gif"
                                                                            width="10" height="10" border="0"/>
                                                                        <span class="STYLE1">维护</span></a>&nbsp;
                                                                    <a href="" onclick="toPublic();"><img
                                                                            src="../../../../images/edit_min.gif"
                                                                            width="10" height="10" border="0"/>
                                                                        <span class="STYLE1">发布</span></a>&nbsp;

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
                                                                   onclick="checkAll(this,'listForm', 'idcheckbox');"/>
                                                        </div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">实验名称</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">发布状态</span></div>
                                                    </td>

                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">是否提交实验报告</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">实验报告提交期限</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">实验报告</span></div>
                                                    </td>

                                                </tr>
                                                <c:forEach items="${pageInfo.data}" var="item">
                                                    <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                        <td height="20"><input name="idcheckbox" type="checkbox"
                                                                               value="${item.id}"
                                                                               onclick="checkOne('listForm', 'idcheckbox')"/>
                                                        </td>
                                                        <td>${item.name}</td>
                                                        <td>
                                                            <c:choose>
                                                            <c:when test="${item.status}"> 已发布 </c:when>
                                                            <c:otherwise>未发布</c:otherwise>
                                                            </c:choose>
                                                        <td><c:choose>
                                                            <c:when test="${item.needReport}">是</c:when>
                                                            <c:otherwise>否</c:otherwise>
                                                        </c:choose></td>
                                                        <td><fmt:formatDate value="${item.reportDeadline}"
                                                                            pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                                        <td><a href="#" onclick="viewReport(${item.id},${item.needReport});">
                                                            <c:choose>
                                                                <c:when test="${item.needReport}">查看</c:when>
                                                                <c:otherwise>--</c:otherwise>
                                                            </c:choose>
                                                        </a></td>
                                                    </tr>
                                                </c:forEach>
                                                <tr height="16px"></tr>
                                            </table>
                                        </div>
                                    </td>
                                </tr>
                                <%@ include file="../../common/pagetable.jsp" %>
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
