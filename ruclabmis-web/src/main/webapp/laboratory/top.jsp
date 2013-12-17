<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <style>

    </style>
    <title> 管理页面</title>

    <meta http-equiv=Content-Type content=text/html;charset=UTF-8>
    <script language=JavaScript1.2>
        function rs(flag) {
            var x = document.getElementsByTagName("li");
            for (var i = 0; i < x.length; i++) {
                x[i].className = "";

            }
            document.getElementById(flag).className = "active";

            if (flag=="homePage"){
                parent.main.location.href = "welcome";
            }else if (flag=="teacher_homePage"){
                parent.main.location.href = "teacher_welcome";
            }else if (flag=="student_homePage"){
                parent.main.location.href = "student_welcome";
            }
            else if(flag=="bbs"){
                parent.main.location.href = "bbs/frame";
            }
        }
    </script>
    <base target="main">
    <link href="../images/skin.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0">
<div class="top">
    <div class="top_left"><img src="../images/logo_lab.gif" width="305" height="103"></div>
    <div class="top_right_top">
           <span style="float:right;">您好！<a>${user.name}</a>[${user.role.name}]
            <a href="/messagecenter/laboratory/jsp/announcement/remind/message" target="">短消息(${unreadCount})</a>
            <a href="jsp/sys/user/password.jsp" target="">修改密码</a>
            [<a href="/login/laboratory/logout" target="_top">退出</a>]
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            </span>

    </div>
    <ul class="top_right_menu">
        <shiro:hasAnyRoles name="administrators,equipment_admin,student,teacher">
            <shiro:hasRole name="student">
                <li id="student_homePage" class="active"><a href="left" target="leftFrame" onclick="rs('student_homePage')">首页</a></li>
            </shiro:hasRole>
            <shiro:hasRole name="teacher">
                <li id="teacher_homePage" class="active"><a href="left" target="leftFrame" onclick="rs('teacher_homePage')">首页</a></li>
            </shiro:hasRole>
            <shiro:hasRole name="administrators">
                <li id="homePage" class="active"><a href="left" target="leftFrame" onclick="rs('homePage')">首页</a></li>
                <li id="administrator_leftmenubasinfo"><a href="administrator_leftmenubasinfo" target="leftFrame"onclick="rs('administrator_leftmenubasinfo')">基础信息管理</a></li>
                <li id="administrator_leftmenulab"><a href="administrator_leftmenulab" target="leftFrame"onclick="rs('administrator_leftmenulab')">实验室管理</a></li>
                <li id="administrator_leftmenuresource"><a href="administrator_leftmenu" target="leftFrame"onclick="rs('administrator_leftmenu')">教学资源管理</a></li>
                <li id="administrator_leftmenuteach"><a href="administrator_leftmenuteach" target="leftFrame"onclick="rs('administrator_leftmenuteach')">实验教学管理</a></li>
                <li id="administrator_leftmenuorder"><a href="administrator_leftmenuorder" target="leftFrame"onclick="rs('administrator_leftmenuorder')">预约管理</a></li>
                <li id="administrator_leftmenutask"><a href="administrator_leftmenutask" target="leftFrame"onclick="rs('administrator_leftmenutask')">考核管理</a></li>
            </shiro:hasRole>
            <li id="bbs"><a href="bbs/left" target="leftFrame" onclick="rs('bbs')">论坛</a></li>
        </shiro:hasAnyRoles>
    </ul>

        <shiro:hasRole name="administrators">
            <script>
                rs('homePage');
            </script>
        </shiro:hasRole>
        <shiro:hasRole name="student">
            <script>
                rs('student_homePage');
            </script>
        </shiro:hasRole>
        <shiro:hasRole name="teacher">
            <script>
                rs('teacher_homePage');
            </script>
        </shiro:hasRole>
</div>
</div>

</body>
</html>

