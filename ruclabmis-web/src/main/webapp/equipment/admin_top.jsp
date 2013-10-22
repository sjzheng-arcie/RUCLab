<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>

    </style>
    <title>实验室设备管理系统</title>
    <script language=JavaScript>
        function logout() {
            if (confirm("您确定要退出控制面板吗？"))
                top.location = "out.asp";
            return false;
        }
    </script>
    <script language=JavaScript1.2>
        function showsubmenu(sid) {
            var whichEl = eval("submenu" + sid);
            var menuTitle = eval("menuTitle" + sid);
            if (whichEl.style.display == "none") {
                eval("submenu" + sid + ".style.display=\"\";");
            } else {
                eval("submenu" + sid + ".style.display=\"none\";");
            }
        }
        function rs1() {
            parent.main.location.href = "teacher_welcome.html";
        }
    </script>
    <meta http-equiv=Content-Type content=text/html;charset=UTF-8>
    <meta http-equiv="refresh" content="60">
    <script language=JavaScript1.2>
        function showsubmenu(sid) {
            var whichEl = eval("submenu" + sid);
            var menuTitle = eval("menuTitle" + sid);
            if (whichEl.style.display == "none") {
                eval("submenu" + sid + ".style.display=\"\";");
            } else {
                eval("submenu" + sid + ".style.display=\"none\";");
            }
        }
    </script>
    <base target="main">
    <link href="images/skin.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0">
<div class="top">
    <div class="top_left"><img src="images/logo.gif" width="305" height="103"></div>
    <div class="top_right">
        <div class="top_right_top"><span style="float:right">您好！<a>张超</a>[设备管理员] <a href="remind.html?id=0"
                                                                                    target="main">短消息(5)</a> |<a
                href="remind.html?id=1" target="main">提醒(5)</a> |[<a href="">退出</a>]|<a>登陆 </a> | <a
                href="jsp/sys/user/password.jsp" target="main">修改密码</a> | <a>帮助？</a> </span></div>
        <ul class="top_right_menu">
            <li class="active"><a href="admin_left.html" target="leftFrame" onclick=rs1();>首页</a></li>

        </ul>
    </div>
</div>

</body>
</html>
