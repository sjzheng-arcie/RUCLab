<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>

<title>消息通知</title>

<style type="text/css">


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



        width: 100%;


        background-color: #ffffff;

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

        height: 20px;

        text-align: center;

        cursor: pointer;

        background: #dddddd;

    }

    .menu0 li.hover {

        background: #53B6E6;

    }

    #main0 ul {

        display: none;

    }

    #main0 ul.block {

        display: block;

    }




</style>

<script>


            function setTab( n) {

                var tli = document.getElementById("menu0").getElementsByTagName("li");

                var mli = document.getElementById("main0").getElementsByTagName("ul");

                for (i = 0; i < tli.length; i++) {

                    tli[i].className = i == n ? "hover" : "";

                    mli[i].style.display = i == n ? "block" : "none";

                }

            }

        var newId="${tabId}";
        if(newId==null||newId==""){
          newId=0;
        }



</script>


</head>

<body onload="setTab(newId)">



<div id="tabs0">
    <ul class="menu0" id="menu0">

        <li  onclick="setTab(0)" >公告</li>

        <li onclick="setTab(1)" >短消息</li>
        <li onclick="setTab(2)">发布公告</li>
        <li onclick="setTab(3)">发送消息</li>


    </ul>

    <div class="main" id="main0">

        <ul class="block">
            <li>


                <p></p>

                <div id=rr0 style="border: 1px solid #B7B7B7">
                <iframe id="contentFrm"
                        name="contentFrm" src="announcement" width="95%" frameborder="0" onload="this.height=this.contentWindow.document.documentElement.scrollHeight" style="padding:0px; margin:0px;" scrolling="no"></iframe>
                </div>

            </li>
        </ul>

        <ul class="bloack">
            <li>
                <p></p>

                <div id="rr1" style="border: 1px solid #B7B7B7">
                    <iframe id="contentFrm0"
                            name="contentFrm0" src="message" width="95%"  frameborder="0" onload="this.height=this.contentWindow.document.documentElement.scrollHeight" style="padding:0px; margin:0px;" scrolling="no"></iframe>
                </div>
            </li>
        </ul>


        <ul class="bloack">
            <li>
                <p></p>

                <div id=rr2>
                <iframe id="contentFrm1"
                        name="contentFrm1" src="toaddannouncement"  width="95%"  frameborder="0" onload="this.height=this.contentWindow.document.documentElement.scrollHeight" style="padding:0px; margin:0px;" scrolling="no"></iframe>
                </div>
            </li>
        </ul>
        <ul class="bloack">
            <li>
                <p></p>

                <div id=rr3>
                <iframe id="contentFrm2"
                        name="contentFrm2" src="sendmessage" width="95%"  frameborder="0" onload="this.height=this.contentWindow.document.documentElement.scrollHeight" style="padding:0px; margin:0px;" scrolling="no"></iframe>
                </div>
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
