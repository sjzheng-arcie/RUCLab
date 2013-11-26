<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>信息平台</title>

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
                <h1 class="type"><a href="javascript:void(0)">个人中心</a></h1>

                <div class="content">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td><img src="../images/menu_topline.gif" width="182" height="5"/></td>
                        </tr>
                    </table>
                    <ul class="MM">
                        <li><a href="jsp/curriculum/experiment/curriculum/mycurriculumschedule"
                               onfocus="toFocus(this)" target="main">我的课程表</a></li>
                        <li><a href="jsp/experiment/experimentpaper/myexperimentlist" onfocus="toFocus(this)"
                               target="main">我的实验课程</a></li>
                        <li><a href="remind?id=0" onfocus="toFocus(this)" target="main">
                            我的短消息</a>
                        </li>
                        <li><a href="remind?id=1" onfocus="toFocus(this)" target="main">我的通知</a>
                        </li>
                        <li><a href="new/pages_miyl/miyl01_ylsj/mydatelist" onfocus="toFocus(this)" target="main">
                            我的预约申请</a></li>

                    </ul>
                </div>

                <h1 class="type"><a href="javascript:void(0)">常用功能</a></h1>

                <div class="content">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td><img src="../images/menu_topline.gif" width="182" height="5"/></td>
                        </tr>
                    </table>
                    <ul class="MM">
                        <li><a href="jsp/res/book/downloadlist " onfocus="(this)" target="main">教学资源下载</a>
                        </li>
                        <li><a href="jsp/experiment/report/uploadreport" onfocus="toFocus(this)" target="main">实验报告提交</a>
                        </li>
                        <li><a href="jsp/experiment/achievement/myscore" onfocus="toFocus(this)" target="main">
                            分数查看</a></li>

                    </ul>
                </div>


            </div>

        </td>
    </tr>
</table>
</body>
</html>