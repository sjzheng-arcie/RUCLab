<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
                <shiro:hasAnyRoles name="administrators,equipment_admin,student,teacher">
                    <h1 class="type"><a href="javascript:void(0)">个人中心</a></h1>

                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="../images/menu_topline.gif" width="182" height="5"/></td>
                            </tr>
                        </table>
                        <ul class="MM">

                            <li><a href="/messagecenter/laboratory/jsp/announcement/remind/message" onfocus="toFocus(this)"
                                   target="main">我的短消息</a>
                            </li>
                            <li><a href="/messagecenter/laboratory/jsp/announcement/remind/announcement" onfocus="toFocus(this)"
                                   target="main">我的通知</a>
                            </li>
                            <shiro:hasAnyRoles name="teacher,equipment_admin,student">
                                <li><a href="jsp/curriculum/experiment/curriculum/mycurriculumschedule"
                                       onfocus="toFocus(this)" target="main">我的课程表</a></li>
                                <li><a href="new/pages_miyl/miyl01_ylsj/mydatelist" onfocus="toFocus(this)"
                                       target="main">
                                    我的预约申请</a></li>
                            </shiro:hasAnyRoles>
                            <shiro:hasAnyRoles name="teacher,equipment_admin,administrators">
                                <li><a href="jsp/task/mytask/mytasklist" onfocus="toFocus(this)" target="main">我的任务</a>
                                </li>
                                <li><a href="jsp/task/work/myworklist" onfocus="toFocus(this)" target="main">我的工作</a>
                                </li>
                            </shiro:hasAnyRoles>
                            <shiro:hasAnyRoles name="student,teacher,equipment_admin,student">
                                <li><a href="jsp/curriculum/experiment/curriculum/mycurriculumschedule"
                                       onfocus="toFocus(this)" target="main">我的课程表</a></li>

                            </shiro:hasAnyRoles>
                            <li><a href="jsp/experiment/experiment/courselist?page=1" onfocus="toFocus(this)"
                                   target="main">我的实验课程</a></li>

                            <shiro:hasRole name="student">
                                <li><a href="jsp/experiment/achievement/myscore" onfocus="toFocus(this)" target="main">
                                    成绩查询</a></li>
                            </shiro:hasRole>
                        </ul>
                    </div>
                </shiro:hasAnyRoles>
                <shiro:hasAnyRoles name="equipment_admin,teacher">
                    <h1 class="type"><a href="javascript:void(0)">实验教学管理</a></h1>

                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="../images/menu_topline.gif" width="182" height="5"/></td>
                            </tr>
                        </table>
                        <ul class="MM">
                            <li><a href="/experiment/virtual/list?page=1" onfocus="toFocus(this)" target="main">虚拟班级管理</a>
                            </li>
                            <li><a href="jsp/experiment/experiment/courselist?page=1" onfocus="toFocus(this)" target="main">
                                实验信息管理</a></li>
                            <li><a href="jsp/curriculum/pages_miyl/miyl01_ylsj/page01_ylya_new.html" onfocus="toFocus(this)"
                                   target="main">
                                实验室预约</a></li>
                            <li><a href="jsp/experiment/experiment/courselist?page=1&view=report" onfocus="toFocus(this)"
                                   target="main">实验报告管理</a>
                            </li>
                            <li><a href="jsp/experiment/achievement/courselist" onfocus="toFocus(this)" target="main">
                                学期成绩评定</a></li>
                        </ul>
                    </div>
                </shiro:hasAnyRoles>
                <shiro:hasAnyRoles name="equipment_admin,student,teacher">
                    <h1 class="type"><a href="javascript:void(0)">教学资源管理</a></h1>

                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="../images/menu_topline.gif" width="182" height="5"/></td>
                            </tr>
                        </table>
                        <ul class="MM">
                            <li><a href="jsp/res/instruction/list" onfocus="toFocus(this)" target="main">实验指导书管理</a>
                            </li>
                            <li><a href="jsp/res/book/list" onfocus="toFocus(this)" target="main">教学资源下载</a>
                            </li>
                            <shiro:hasRole name="student">
                                <li><a href="jsp/experiment/report/uploadreport" onfocus="toFocus(this)" target="main">实验报告提交</a>
                                </li>
                                <li><a href="jsp/experiment/achievement/myscore" onfocus="toFocus(this)" target="main">
                                    实验成绩查询</a></li>
                            </shiro:hasRole>
                            <shiro:hasRole name="teacher">
                                <li><a href="jsp/res/experimentquestion/list" onfocus="toFocus(this)" target="main">实验题库管理</a>
                                </li>
                                <li><a href="jsp/res/question/list" onfocus="toFocus(this)" target="main">考试题库管理</a>
                                </li>
                                <li><a href="jsp/res/examination/list" onfocus="toFocus(this)" target="main">考试管理</a>
                                </li>
                            </shiro:hasRole>
                        </ul>
                    </div>
                </shiro:hasAnyRoles>
                <shiro:hasAnyRoles name="administrators">
                    <h1 class="type"><a href="javascript:void(0)">常用功能</a></h1>

                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="../images/menu_topline.gif" width="182" height="5"/></td>
                            </tr>
                        </table>
                        <ul class="MM">

                            <li><a href="/messagecenter/laboratory/jsp/announcement/remind/addannouncementTab?id=1" onfocus="toFocus(this)"
                                   target="main">发布公告</a>
                            </li>
                            <li><a href="../common/user/list" onfocus="toFocus(this)" target="main">教职工信息管理</a>
                            </li>
                            <li><a href="jsp/bas/student/list" onfocus="toFocus(this)" target="main">学生信息管理</a>
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