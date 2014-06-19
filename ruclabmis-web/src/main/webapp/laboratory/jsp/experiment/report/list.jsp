<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <script type="text/javascript" src="../../../../js/autocomplete/jquery-1.9.1.js"></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
         function saveSore(){
             var arr = new Array();
             $.map($("input[id*=score]"),function(data){
                 try{
                     var id = parseInt($(data).attr("id").substring(6)),
                         score = parseInt($(data).val());
                     if(!(isNaN(score)) && score>=0 && score<=100){
                         arr.push(id);
                         arr.push(score);
                     }else{
                         alert("学生实验分数应为数字，并在0-100之间!");
                     }
                 }catch (e){
                     alert("请为学生的分数填入正确的数字!");
                 }
             });
             if(arr.length>0 && arr.length%2 ==0){
                 $.post("setStudentExpScore",{
                     scores :  arr.join(",")
                 },function(data){
                     if(data.success){
                         window.location.href = window.location.href;
                         alert("保存学生实验分数成功!");
                     }else{
                         alert(data.message);
                     }
                 });
             }
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
         function download(eid,stuId){
             downloadFile("/laboratory/jsp/experiment/experiment/downloadStuExpReport",{eid:eid,stuId:stuId});
         }
         function splitReportName(realpath){
             if(realpath==null)
                return;
             var flag = realpath.lastIndexOf("\\");
             if(flag!=-1){
                realpath.substring(flag+1);
                return realpath;
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
                            <div class="titlebt">实验报告管理 > 实验报告评分</div>
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
                                                                                style="white-space:nowrap">实验报告列表</span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td>
                                                                <div align="right">
                                                                    <span class="STYLE1" style="white-space:nowrap">
                                                                        <a href="javascript:;" onclick="saveSore();" class='txt_bt'><img
                                                                                src="../../../../images/add_min.gif"
                                                                                width="10" height="10" border="0"/>
                                                                            <span class="STYLE1">保存</span></a>&nbsp;
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
                                                    <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">学号</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">姓名</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">实验报告名称</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">实验报告</span></div>
                                                    </td>
                                                    <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                        <div align="center"><span class="STYLE10">分数</span></span>
                                                        </div>
                                                    </td>
                                                </tr>

                                                <c:forEach items="${pageInfo.data}" var="item">
                                                    <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                        <td>${item.sn}</td>
                                                        <td>${item.name}</td>
                                                        <td>
                                                           <c:if test="${item.report_path!=null}">
                                                                   <c:set var="filename" value="${item.report_path}"/>
                                                                   <c:set value="${fn:split(filename, '\\\\')}" var="str1" />
                                                                   ${str1[fn:length(str1)-1]}
                                                           </c:if>


                                                        <td><input type="button" class="button" onclick="download(${item.experiment_id},${item.class_student_id})" value="查看"/></td>
                                                        <td><input type="text" id="score_${item.id}" value="${item.score}" style="width: 80px"></td>
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
