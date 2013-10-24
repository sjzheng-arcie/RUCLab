<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>

<title>简洁Tab</title>

<style type="text/css">

    <!--

    body, div, ul, li {

        margin: 0 auto;

        padding: 0;

    }

    body {

        font: 12px "宋体";

        text-align: center;
        background-color: #ffffff;

    }

    a:link {

        color: #00F;

        text-decoration: none;

    }

    a:visited {

        color: #00F;

        text-decoration: none;

    }

    a:hover {

        color: #c00;

        text-decoration: underline;

    }

    ul {

        list-style: none;

    }

    .main {

        clear: both;

        width: 99%;

        padding: 8px;

        text-align: center;

    }

        /*第一种形式*/

    #tabs0 {

        height: 1000px;

        width: 100%;

        border: 1px solid #cbcbcb;

        background-color: #ddeeff;

    }

    .menu0 {

        width: 99%;
        background: #dddddd;

    }

    .menu0 li {

        display: block;

        float: left;

        padding: 4px 0;

        width: 100px;

        text-align: center;

        cursor: pointer;

        background: #dddddd;

    }

    .menu0 li.hover {

        background: #f2f6fb;

    }

    #main0 ul {

        display: none;

    }

    #main0 ul.block {

        display: block;

    }

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

    -->

</style>

<script>



        /*第一种形式 第二种形式 更换显示样式*/

            function setTab(m, n) {

                var tli = document.getElementById("menu" + m).getElementsByTagName("li");

                var mli = document.getElementById("main" + m).getElementsByTagName("ul");

                for (i = 0; i < tli.length; i++) {

                    tli[i].className = i == n ? "hover" : "";

                    mli[i].style.display = i == n ? "block" : "none";

                }

            }
    function setTab02() {

        var tli = document.getElementById("menu" + 0).getElementsByTagName("li");

        var mli = document.getElementById("main" + 0).getElementsByTagName("ul");

        for (i = 0; i < tli.length; i++) {

            tli[i].className = i == 2 ? "hover" : "";

            mli[i].style.display = i == 2 ? "block" : "none";

        }

    }

    String.prototype.getQueryString = function (name) {
        var reg = new RegExp("(^|&|\\?)" + name + "=([^&]*)(&|$)"), r;
        if (r = this.match(reg)) return unescape(r[2]);
        return null;
    };
    var sId = location.search.getQueryString("id");
        var newId="${tabId}";
    function changeTab(name) {


        setTab(0, name);

    }
        function toFind() {
            var href = '/equipment/jsp/announcement/remind/remind';

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
            var href = '/equipment/jsp/announcement/remind/remind?page=' + page;
            document.listForm.action = href;
            document.listForm.submit();
        }

</script>


</head>

<body onload="changeTab(newId)">

<br/>

<br/>



<div id="tabs0">
    <ul class="menu0" id="menu0">

        <li onclick="setTab(0,0)" class="hover">短消息</li>

        <li onclick="setTab(0,1)" class="hover">公告</li>
        <li onclick="setTab(0,2)">发布公告</li>


    </ul>

    <div class="main" id="main0">

        <ul class="block">
            <li>


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



                <p></p>

                <div class="message">
                    <hr class="hr1">

                    <p align="left"><span>发布者 :  </span><span>小白</span> <span style="float:right">2012-12-10</span>
                        <span style="float:right">发布时间 :  </span></p>
                    <hr class="hr1">
                    <h6 align="left">原定于本周五的座谈会取消</h6>
                    <hr class="hr1">
                    <p align="left">查看详细</p>
                    <hr class="hr1">
                </div>


                <p></p>

                <div class="message">
                    <hr class="hr1">

                    <p align="left"><span>发布者 :  </span><span>小白</span> <span style="float:right">2012-12-10</span>
                        <span style="float:right">发布时间 :  </span></p>
                    <hr class="hr1">
                    <h6 align="left">原定于本周五的座谈会取消</h6>
                    <hr class="hr1">
                    <p align="left">查看详细</p>
                    <hr class="hr1">
                </div>


    <form name="listForm">
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

            </li>
        </ul>

        <ul>
            <li>
                <p></p>

                <div id=rr></div>
                <iframe id="contentFrm" onLoad="document.getElementById('rr').innerHTML=this.body.innerHTML;this.style.display='none';"
                        name="contentFrm" src="message" width="900px" height="1000px"  frameborder="0" style="padding:0px; margin:0px;" scrolling="no"></iframe>
            </li>
        </ul>


        <ul>
            <li>
                <p></p>

                <div id=rr2></div>
                <iframe id="contentFrm1" onLoad="document.getElementById('rr2').innerHTML=this.body.innerHTML;this.style.display='none';"
                        name="contentFrm1" src="addannouncement" width="900px" height="1000px"  frameborder="0" style="padding:0px; margin:0px;" scrolling="no"></iframe>
            </li>
        </ul>

    </div>

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
