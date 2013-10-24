<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>

<title>消息列表</title>


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


</head>

<body >


<div style="border: 1px;">

                <c:forEach items="${announcementLists}" var="item">
                    <p></p>

                    <div class="message" style="border: 1px;">
                        <hr class="hr1">

                        <p align="left"><span>发布者 :  </span><span>${item.user.name}</span> <span style="float:right">${item.publishTime}</span>
                            <span style="float:right">发布时间 :  </span></p>
                        <hr class="hr1">
                        <h6 align="left">${item.content}</h6>
                        <hr class="hr1">
                        <p align="left">查看详细</p>
                        <hr class="hr1">
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


<br/>

<br/>


<br/>

<br/>


<br/>

<br/>

<br/>

<br/>

<br/>

<br/>

<br/>

<br/>

</body>

</html>
