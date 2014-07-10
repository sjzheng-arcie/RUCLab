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
                            <li><a href="jsp/appointment/laboratory/frame.jsp" onfocus="toFocus(this)"
                                   target="main">预约申请</a></li>
                            <li><a href="jsp/appointment/laboratory/list" onfocus="toFocus(this)"
                                   target="main">申请中的预约</a></li>
                            <li><a href="jsp/appointment/laboratory/list?formType=history" onfocus="toFocus(this)"
                                   target="main">预约结果</a></li>
                            </li>

                        </ul>
                    </div>
                    <h1 class="type"><a href="javascript:void(0)">多次预约管理</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="../images/menu_topline.gif" width="182" height="5"/></td>
                            </tr>
                        </table>
                        <ul class="MM">
                            <li><a href="jsp/appointment/laboratory/multiframe.jsp" onfocus="toFocus(this)"
                                   target="main">多次预约申请</a></li>
                            <li><a href="jsp/appointment/laboratory/multilist" onfocus="toFocus(this)"
                                   target="main">申请中的多人预约</a></li>
                            <li><a href="jsp/appointment/laboratory/multilist?formType=history" onfocus="toFocus(this)"
                                   target="main">多次预约结果</a></li>
                            </li>
                        </ul>
                    </div>


                </shiro:hasAnyRoles>
            </div>

        </td>
    </tr>
</table>
</body>
</html>