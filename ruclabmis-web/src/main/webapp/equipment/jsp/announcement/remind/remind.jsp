<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
        background-color: #EEF2FB;

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


        background-color: #EEF2FB;

    }

    .menu0 {

        width: 99%;
        background: #dddddd;

    }

    .menu0 li {

        display: block;

        float: left;

        padding: 4px 4px;

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


    var replyFlag="${replySn}";

    var newId="${tabId}";
    if(newId==null||newId==""){
        newId=0;
    }

            function setTab( n) {

                var tli = document.getElementById("menu0").getElementsByTagName("li");

                var mli = document.getElementById("main0").getElementsByTagName("ul");

                for (i = 0; i < tli.length; i++) {

                    tli[i].className = i == n ? "hover" : "";

                    mli[i].style.display = i == n ? "block" : "none";

                }


            }
            function initTab( n) {

                setTab(n);
                switch (n){
                    case 0:
                            if(document.getElementById('contentFrm0').src=="")
                                document.getElementById('contentFrm0').src="announcement";
                        break;
                    case 1:
                        if(document.getElementById('contentFrm1').src=="")
                        document.getElementById('contentFrm1').src="message";
                        break;
                    case 2:
                        if(document.getElementById('contentFrm2').src=="")
                        document.getElementById('contentFrm2').src="toaddannouncement";
                        break;
                    case 3:
                        if(document.getElementById('contentFrm3').src=="")
                        document.getElementById('contentFrm3').src="sendmessage?replyFlag=${replySn}";
                        break;


                }

            }



</script>


</head>

<body onload="initTab(newId)" style="background-color:#EEF2FB;">



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

                <div id=rr0 style="border: 1px  #B7B7B7">
                <iframe id="contentFrm0"
                        name="contentFrm0" src="announcement" width="98%" frameborder="0" onload="this.height=this.contentWindow.document.documentElement.scrollHeight" style="padding:0px; margin:0px;" scrolling="no"></iframe>
                </div>

            </li>
        </ul>
        <ul class="block">
            <li>
                <p></p>

                <div id="rr1" style="border: 1px #B7B7B7">
                    <iframe id="contentFrm1"
                            name="contentFrm1" src="message?fatherPage=message&page=1" width="99%"  frameborder="0" onload="this.height=this.contentWindow.document.documentElement.scrollHeight" style="padding:0px; margin:0px;" scrolling="no"></iframe>
                </div>
            </li>
        </ul>



        <ul class="block">
            <li>
                <p></p>

                <div id="rr2" style="border: 1px  #B7B7B7" >
                <iframe id="contentFrm2"
                        name="contentFrm2" src="toaddannouncement"  width="99%"  frameborder="0" onload="this.height=this.contentWindow.document.documentElement.scrollHeight" style="padding:0px; margin:0px;" scrolling="no"></iframe>
                </div>
            </li>
        </ul>
        <ul class="block">
            <li>
                <p></p>

                <div id="rr3" style="border: 1px #B7B7B7">
                <iframe id="contentFrm3"

                        name="contentFrm3" src="sendmessage?replyFlag=${replySn}" width="99%"  frameborder="0" onload="this.height=this.contentWindow.document.documentElement.scrollHeight" style="padding:0px; margin:0px;" scrolling="no"></iframe>
                </div>
            </li>
        </ul>

    </div>

</div>
<br/>


<!--onLoad="document.getElementById('rr3').innerHTML=this.body.innerHTML;this.style.display='none';"-->


</body>

</html>
