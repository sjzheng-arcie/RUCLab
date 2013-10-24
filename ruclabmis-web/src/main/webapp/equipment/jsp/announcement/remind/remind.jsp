<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>

<title>消息通知</title>

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

        height: 2000px;

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


            function setTab(m, n) {

                var tli = document.getElementById("menu" + m).getElementsByTagName("li");

                var mli = document.getElementById("main" + m).getElementsByTagName("ul");

                for (i = 0; i < tli.length; i++) {

                    tli[i].className = i == n ? "hover" : "";

                    mli[i].style.display = i == n ? "block" : "none";

                }

            }


    String.prototype.getQueryString = function (name) {
        var reg = new RegExp("(^|&|\\?)" + name + "=([^&]*)(&|$)"), r;
        if (r = this.match(reg)) return unescape(r[2]);
        return null;
    };
        var newId="${tabId}";
        if(newId==null||newId==""){
          newId=0;
        }
    function changeTab(name) {


        setTab(0, name);

    }


</script>


</head>

<body onload="changeTab(newId)">

<br/>

<br/>



<div id="tabs0">
    <ul class="menu0" id="menu0">

        <li onclick="setTab(0,0)" class="hover">公告</li>

        <li onclick="setTab(0,1)" class="hover">短消息</li>
        <li onclick="setTab(0,2)">发布公告</li>
        <li onclick="setTab(0,3)">发送消息</li>


    </ul>

    <div class="main" id="main0">

        <ul class="block">
            <li>


                <p></p>

                <div id=rr0></div>
                <iframe id="contentFrm" onLoad="document.getElementById('rr0').innerHTML=this.body.innerHTML;this.style.display='none';"
                        name="contentFrm" src="announcement" width="900px" height="2000px"  frameborder="0" style="padding:0px; margin:0px;" scrolling="no"></iframe>


            </li>
        </ul>

        <ul>
            <li>
                <p></p>

                <div id=rr1></div>
                <iframe id="contentFrm0" onLoad="document.getElementById('rr1').innerHTML=this.body.innerHTML;this.style.display='none';"
                        name="contentFrm0" src="message" width="900px" height="2000px"  frameborder="0" style="padding:0px; margin:0px;" scrolling="no"></iframe>
            </li>
        </ul>


        <ul>
            <li>
                <p></p>

                <div id=rr2></div>
                <iframe id="contentFrm1" onLoad="document.getElementById('rr2').innerHTML=this.body.innerHTML;this.style.display='none';"
                        name="contentFrm1" src="toaddannouncement" width="900px" height="2000px"  frameborder="0" style="padding:0px; margin:0px;" scrolling="no"></iframe>
            </li>
        </ul>
        <ul>
            <li>
                <p></p>

                <div id=rr3></div>
                <iframe id="contentFrm2" onLoad="document.getElementById('rr3').innerHTML=this.body.innerHTML;this.style.display='none';"
                        name="contentFrm2" src="sendmessage" width="900px" height="2000px"  frameborder="0" style="padding:0px; margin:0px;" scrolling="no"></iframe>
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
