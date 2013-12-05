<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
                <h1 class="type"><a href="javascript:void(0)">教学实验管理</a></h1>

                <div class="content">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td><img src="../images/menu_topline.gif" width="182" height="5"/></td>
                        </tr>
                    </table>
                    <ul class="MM">

                        <li><a href="jsp/experiment/virtual/list?page=1" onfocus="toFocus(this)" target="main">虚拟班级</a>
                        </li>
                        <li><a href="jsp/experiment/notice/list" onfocus="toFocus(this)" target="main">通知公告</a>
                        </li>
                        <li><a href="jsp/curriculum/experiment/curriculum/curriculum" onfocus="toFocus(this)"
                               target="main">课程信息管理</a></li>
                        <li><a href="jsp/experiment/experimentpaper/list" onfocus="toFocus(this)" target="main">
                            实验信息管理</a></li>


                    </ul>
                </div>
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