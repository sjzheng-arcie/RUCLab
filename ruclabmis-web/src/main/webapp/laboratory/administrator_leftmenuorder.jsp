<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>管理页面</title>
    <script src="../js/prototype.lite.js" type="text/javascript"></script>
    <script src="../js/moo.fx.js" type="text/javascript"></script>
    <script src="../js/moo.fx.pack.js" type="text/javascript"></script>
    <link href="../css/left.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        //选择中标签变色
        var selectedid = null;
        function toFocus(id) {
            if (selectedid) {
                toBlur(selectedid);
            }
            selectedid = id;
            id.style.color = '#006600';
        }
        function toBlur(id) {
            id.style.color = '#000000';
        }
    </script>
</head>
<body>
<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#eef2fb">
    <tr>
        <td width="182" valign="top">
            <div id="container">
                <shiro:hasAnyRoles name="administrators,equipment_admin">
                    <h1 class="type"><a href="javascript:void(0)">预约管理</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="../images/menu_topline.gif" width="182" height="5"/></td>
                            </tr>
                        </table>
                        <ul class="MM">
                            <li><a href="jsp/curriculum/appointment/laboratory/appointmentbaseinfo" onfocus="toFocus(this)"
                                   target="main">实验室室预约申请</a></li>
                            <li><a href="jsp/curriculum/appointment/laboratory/mydatelist" onfocus="toFocus(this)"
                                   target="main">实验室预约管理</a></li>
                            <li><a href="jsp/curriculum/appointment/meetingroom/appointmentbaseinfo" onfocus="toFocus(this)"
                                   target="main">会议室预约申请</a></li>
                            <li><a href="jsp/curriculum/appointment/meetingroom/meetingroomappointmentbaseinfo" onfocus="toFocus(this)" target="main">会议室预约管理</a>
                            </li>
                        </ul>
                    </div>
                </shiro:hasAnyRoles>
            </div>
            <script type="text/javascript">
                var contents = document.getElementsByClassName('content');
                var toggles = document.getElementsByClassName('type');
                var myAccordion = new fx.Accordion(
                        toggles, contents, {opacity: true, duration: 400}
                );
                myAccordion.showThisHideOpen(contents[0]);
                var windowHeight = document.documentElement.clientHeight;
                window.parent.document.getElementById("frame").rows = "2000,*";
            </script>
        </td>
    </tr>
</table>
</body>
</html>