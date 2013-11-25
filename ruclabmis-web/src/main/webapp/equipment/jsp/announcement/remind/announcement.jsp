<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script src="../../../../js/valid.js" type=text/javascript></script>

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

        a.announcement:link {
            text-decoration: none;
            color: #000000;
        }

        a.announcement:visited {
            text-decoration: none;
            color: #000000;
        }

        a.announcement:hover {
            text-decoration: none;
            color: #FF0000;
        }

        a.announcement:active {
            text-decoration: none;
            color: #000000;
        }
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
            var href = '/equipment/jsp/announcement/remind/announcement?page=' + page;
            document.listForm.page.value = page;
            document.listForm.action = href;
            document.listForm.submit();
        }


        function save() {

            document.form1.action = "addAnnouncement";
            document.form1.submit();
        }
        function displayClass(value) {

            if (value == "2") {
                document.getElementById('scopeDiv').style.display = '';
            } else {
                document.getElementById('scopeDiv').style.display = 'none';
            }

        }

    </script>

</head>
<body style="background-color: #EEF2FB">
<form name="listForm" method="post">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">

        <tr>
            <td valign="top" bgcolor="#EEF2FB">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

                    <tr valign="top">
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#a8c7ce">
                                <tr align="center" bgcolor="#E3E9EE" style=" height: 10px;background-color: #E3E9EE">
                                    <td bgcolor="#E3E9EE"></td>
                                </tr>
                                <tr bgcolor="#E3E9EE">

                                    <td align="center" bgcolor="#E3E9EE">
                                        <table border="0" cellpadding="2" cellspacing="1"
                                               style="width:99%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#E3E9EE">
                                            <tr>
                                                <td align="center">


                                                    <div style="border: 1px;background-color: #FFFFFF;">

                                                        <c:forEach items="${pageInfo.data}" var="item">
                                                            <div class="message"
                                                                 style="border: 1px;background-color: #FFFFFF">
                                                                <hr size="0"
                                                                    style="  border:none; border-bottom:1px dashed #ccc;">
                                                                <p align="left" style="margin: 10px;font-size: 12px">
                            <span>
                                <a class="announcement"
                                   href="/equipment/jsp/announcement/remind/announcementDetail?announcementDetailId=${item.id}">
                                        ${item.title}
                                </a>
                            </span>
                            <span style="float:right">
                                <fmt:formatDate value="${item.publishTime}"></fmt:formatDate>
                            </span>
                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                </td>
                                            </tr>
                                            <%@ include file="../../../../include/pagetable.jsp" %>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>

        </tr>

    </table>
</form>
</body>
