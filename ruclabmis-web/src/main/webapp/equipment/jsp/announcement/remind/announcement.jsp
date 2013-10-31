
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="../../../css/skin.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="../../../../js/valid.js" type=text/javascript></script>

    <style type="text/css">


    <style type="text/css">
        .message {

            width: 100%;

            border: 1px solid #cbcbcb;

            background-color: #ffffff;

        }
        .hr1 {
            color: #efeeea;
            height: 1px;
            border: 0px;
            border-top: 1px solid #efeeea;
            margin: 0px;
            margin-top: 8px;
            margin-bottom: 8px;
            padding: 0px;
            overflow: hidden;
        }

        a.announcement:link{text-decoration:none; color:#000000;}
        a.announcement:visited{text-decoration:none;color:#000000; }
        a.announcement:hover{text-decoration:none;color:#FF0000; }
        a.announcement:active{text-decoration:none;color:#000000;}
    </style>
    <script>




        function toFind() {
            var href = '/equipment/jsp/announcement/remind/announcement';

            document.listForm.action = href;
            document.listForm.submit();
        }

        function goPage(page) {
            if (page <= 0) {
                alert("已到达首页！");
                return;
            }
            if (page > ${page.totalPage}) {
                alert("已到达尾页！");
                return;
            }
            var href = '/equipment/jsp/announcement/remind/announcement?page=' +page;
            document.listForm.page.value = page;
            document.listForm.action = href;
            document.listForm.submit();
        }

    </script>


    <script>




        function toFind() {
            var href = '/equipment/jsp/announcement/remind/sendmessage';

            document.listForm.action = href;
            document.listForm.submit();
        }

        function goPage(page) {
            if (page <= 0) {
                alert("已到达首页！");
                return;
            }
            if (page > ${page.totalPage}) {
                alert("已到达尾页！");
                return;
            }
            var href = '/equipment/jsp/announcement/remind/message?page=' +page;
            document.listForm.page.value = page;
            document.listForm.action = href;
            document.listForm.submit();
        }

    </script>
    <script>
        function save(){

            document.form1.action="addAnnouncement";
            document.form1.submit();
        }
        function displayClass(value){

            if(value=="2"){
                document.getElementById('scopeDiv').style.display='';
            }else{
                document.getElementById('scopeDiv').style.display= 'none';
            }

        }

    </script>

</head>
<body style="background-color: #EEF2FB">

<table width="100%"  border="0" cellpadding="0" cellspacing="0" >

    <tr>
        <td valign="top" bgcolor="#EEF2FB">
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

                <tr valign="top">
                    <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#a8c7ce"  >
                            <tr  align="center"  bgcolor="#E3E9EE" style=" height: 10px;background-color: #E3E9EE"><td bgcolor="#E3E9EE"></td></tr>
                            <tr bgcolor="#E3E9EE" >

                                <td  align="center"  bgcolor="#E3E9EE" >
                                    <table border="0" cellpadding="2" cellspacing="1" style="width:99%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
                                        <tr>
                                            <td align="center">


                                                <div style="border: 1px;background-color: #FFFFFF;">

                                                    <c:forEach items="${announcementLists}" var="item">
                                                        <div class="message" style="border: 1px;background-color: #FFFFFF" >
                                                            <hr size="0"  style="  border:none; border-bottom:1px dashed #ccc;">
                                                            <p align="left" style="margin: 10px;font-size: 12px">
                            <span>
                                <a class="announcement" href="/equipment/jsp/announcement/remind/announcementDetail?announcementDetailId=${item.id}" >
                                        ${item.title}
                                </a>
                            </span>
                            <span style="float:right">
                                <fmt:formatDate value="${item.publishTime}"></fmt:formatDate>
                            </span>
                                                        </div>
                                                    </c:forEach>





                                                    <form name="listForm">
                                                        <input type="hidden" id="page" name = "page"/>
                                                        <table border='0' align='right' cellpadding='0' cellspacing='0' style='font-size:13px;'>
                                                            <tr>
                                                                <td width='49'>
                                                                    <div align='center'><img onclick="goPage(1)" style="cursor:hand"
                                                                                             src='../../../images/main_54.gif' width='40' height='15'
                                                                                             border='0'/></div>
                                                                </td>
                                                                <td width='49'>
                                                                    <div align='center'><img onclick="goPage(${page.currentPage-1})" style="cursor:hand"
                                                                                             src='../../../images/main_56.gif' width='45' height='15'
                                                                                             border='0'/></div>
                                                                </td>
                                                                <td width='49'>
                                                                    <div align='center'><img onclick="goPage(${page.currentPage+1})" style="cursor:hand"
                                                                                             src='../../../images/main_58.gif' width='45' height='15'
                                                                                             border='0'/></div>
                                                                </td>
                                                                <td width='49'>
                                                                    <div align='center'><img onclick="goPage(${page.totalPage})" style="cursor:hand"
                                                                                             src='../../../images/main_60.gif' width='40' height='15'
                                                                                             border='0'/></div>
                                                                </td>
                                                                <td width='37' class='STYLE22'>
                                                                    <div align='center' style="white-space:nowrap">转到</div>
                                                                </td>
                                                                <td>
                                                                    <div align='left'>
                                                                        <select onchange="goPage(this.options[this.selectedIndex].value)">
                                                                            <c:forEach var="i" begin="1" end="${page.totalPage}" step="1">
                                                                                <option class='STYLE22' value='${i}'
                                                                                        <c:if test="${page.currentPage == i}">selected</c:if> > 第${i}页
                                                                                </option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </form>



                                                </div>


                                            </td>
                                        </tr>



                                    </table>
                                </td>

                            </tr>
                            <tr  align="center"  bgcolor="#E3E9EE" style=" height: 10px;background-color: #E3E9EE"><td align="center">
                                <input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
                            </td></tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>

    </tr>

</table>
<input type="hidden" name="us_sreplyby" value=""/>

</body>
