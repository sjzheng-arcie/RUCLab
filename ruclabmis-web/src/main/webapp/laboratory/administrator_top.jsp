<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>

    </style>
    <title> 管理页面</title>
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
    </script>
    <meta http-equiv=Content-Type content=text/html;charset=UTF-8>
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
        function rs() {
            parent.main.location.href = "bbs/frame";
        }
        function rs1() {
            parent.main.location.href = "administrator_welcome";
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
            <a href="jsp/announcement/remind/remind?id=1" target="">短消息(${unreadCount})</a>
            <a href="jsp/common/user/toUpdatePassword" target="">修改密码</a>
            [<a href="/laboratory/logout" target="_top">退出</a>]
            </span>

    </div>
    <ul class="top_right_menu">
        <li class="active"><a href="administrator_left" target="leftFrame" onclick=rs1();>首页</a></li>
        <li><a href="administrator_leftmenubasinfo" target="leftFrame">基础信息管理</a></li>
        <li><a href="administrator_leftmenulab" target="leftFrame">实验室管理</a></li>
        <li><a href="administrator_leftmenuresource" target="leftFrame">教学资源管理</a></li>
        <li><a href="administrator_leftmenuteach" target="leftFrame">实验教学管理</a></li>
        <li><a href="new/left" target="leftFrame">预约管理</a></li>
        <li><a href="administrator_leftmenutask" target="leftFrame">考核管理</a></li>
        <li><a href="bbs/left" target="leftFrame" onclick=rs();>论坛</a></li>
    </ul>
</div>
</div>

</body>
</html>

