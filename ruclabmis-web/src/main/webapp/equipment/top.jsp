<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>

    </style>
    <title>设备管理系统</title>
    <meta http-equiv=Content-Type content=text/html;charset=UTF-8>
    <base target="main">
    <link href="../images/skin.css" rel="stylesheet" type="text/css">


    <script language=JavaScript1.2>
        function rs1() {

            var roleName = "${user.role.name}";
            if (roleName == "teacher") {
                parent.main.location.href = "teacher_welcome";
            } else if (roleName == "leader") {
                parent.main.location.href = "leader_welcome";
            } else if (roleName == "administrators") {
                parent.main.location.href = "welcome";
            } else if (roleName == "equipment_admin") {
                parent.main.location.href = "admin_welcome";
            }


        }

    </script>

</head>
<body leftmargin="0" topmargin="0">
<div class="top">
    <div class="top_left"><img src="../images/logo.gif" width="305" height="103"></div>
    <div class="top_right">
        <div class="top_right_top">
           <span style="float:right;">您好！<a>${user.name}</a>[${user.role.name}]
            <a href="/messagecenter/equipment/jsp/announcement/remind/message" target="">短消息(${unreadCount})</a>
            <a href="/common/user/toUpdatePassword" target="">修改密码</a>
            [<a href="/login/equipment/logout" target="_top">退出</a>]
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            </span>

        </div>
        <ul class="top_right_menu">
            <li class="active"><a href="left.jsp" target="leftFrame" onclick=rs1();>首页</a></li>

        </ul>
    </div>
</div>

</body>
</html>
