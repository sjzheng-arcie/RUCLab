<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="<%=basePath%>/css/skin.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript " src="<%=basePath%>/js/valid.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/autocomplete/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/chosen/chosen.jquery.min.js"></script>
    <script LANGUAGE="javascript">
       // <![CDATA[
        var classId = "${vclass.curriculumId}";
        function createCurriculumOption(target, item) {
            if (classId && classId == item.id.toString()) {
                $("<option>").html(item.name).attr('value', item.id).attr('selected', 'selected')
                        .attr('teacher', item.teacherName).attr('teacherId', item.teacherId).appendTo("#" + target);
            } else {
                $("<option>").html(item.name).attr('value', item.id).attr('teacher', item.teacherName)
                        .attr('teacherId', item.teacherId).appendTo("#" + target);
            }
        }
        function initCurriculumSelect() {
            $.getJSON("/laboratory/jsp/bas/curriculum/list", {name: ""}, function (data) {
                $.each(data, function (idx, item) {
                    createCurriculumOption("curriculumId", item);
                });

                $("#curriculumId").chosen({
                    no_results_text: "没有找到!",
                    disable_search_threshold: 10
                });
            });

            $("#curriculumId").on("change", function (evn, params) {
                var t = $("#curriculumId option:selected").attr('teacher');
                $("#teacherName").val(t);
            });
        }

        function addNewClass() {

/*            if (!validator(document.listForm)) {
                return;
            }*/
            var classId = $("#curriculumId").val(),
                    classSn = $("#classSn").val(),
                    className = $("#className").val(),
                    classYear = $("#classYear").val(),
                    teacherId = $("#curriculum option:selected").attr('teacherId');
            if(classId==-1){
                alert("请选择课程!");
                return;

            }
            var sids = new Array();
            $.each($("input[name='stCheckbox']:checked"), function (idx, data) {
                sids.push($(data).val());
            });

            $.ajax({
                url: "/experiment/virtual/addClass",
                type: "POST",
                data: {'classSn': classSn,
                    'className': className,
                    'classYear': classYear,
                    'curriculumId': classId,
                    'sidStr': sids.join(",")
                },
                dataType: "json",
                success: function (data) {
                    alert(data.message);
                    if (data.success) {
                        window.location.href = "/experiment/virtual/list?page=1";
                    }
                }
            });

        }
        function addStudents(){
            var vcId = $("#vcId").val();
            window.open("/experiment/virtual/editClassAddStudent?vcId="+vcId+"&pageNum=1", "学生信息",
                    "height=400, width=800, toolbar=no, status=no");
        }

        $(document).ready(function () {
            initCurriculumSelect();
        });
        //]]>
    </script>

</head>

<body>

<form name="listForm" method="post">
<input type="hidden" id="vcId" name="vcId" value="${vClass.id}">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="17" valign="top" background="/laboratory/../images/mail_leftbg.gif">
            <img src="/laboratory/../images/left-top-right.gif" width="17" height="29"/>
        </td>
        <td valign="top" background="/laboratory/../images/content-bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                   id="newClassTable">
                <tr>
                    <td height="31">
                        <div class="titlebt">教学实验管理 > 新增班级</div>
                    </td>
                </tr>
            </table>
        </td>
        <td width="16" valign="top" background="/laboratory/../images/mail_rightbg.gif">
            <img src="/laboratory/../images/nav-right-bg.gif" width="16" height="29"/>
        </td>
    </tr>
    <tr>
        <td valign="middle" background="/laboratory/../images/mail_leftbg.gif">&nbsp;</td>
        <td valign="top" bgcolor="#F7F8F9">
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td height="30">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td height="24" bgcolor="#353c44">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td width="6%" height="19" valign="bottom">
                                                            <div align="center"><img src="/laboratory/../images/tb.gif"
                                                                                     width="14" height="14"/></div>
                                                        </td>
                                                        <td width="94%" valign="bottom"><span
                                                                class="STYLE1">班级信息</span></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <div align="right"><span class="STYLE1">&nbsp;</span><span
                                                        class="STYLE1"> &nbsp;</span></div>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr valign="top">
                    <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                            <tr bgcolor="#FFFFFF">
                                <td bgcolor="#FFFFFF">
                                    <table border="0" cellpadding="2" cellspacing="1"
                                           style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                           bgcolor="#E3E9EE">
                                        <tr>
                                            <td nowrap align="right">班级编号:</td>
                                            <td nowrap>
                                                <input id="classSn" name="classSn" class="text"
                                                       value="${vclass.classSn}"
                                                       valid="required"
                                                       errmsg="班级编号不能为空!"
                                                        />
                                                <span style="color:red;">*</span>&nbsp;&nbsp;

                                            </td>
                                            <td nowrap align="right">班级名称:</td>
                                            <td nowrap>
                                                <input id="className" name="className" class="text"
                                                       value="${vclass.className}"
                                                       valid="required"
                                                       errmsg="班级名称不能为空!" />
                                                <span style="color:red;">*</span>&nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_name"></span>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td nowrap align="right">所属课程:</td>
                                            <td nowrap>
                                                <select id="curriculumId" name="curriculumId"
                                                        style="width: 152px;height: 22px"
                                                        data-placeholder="请选择课程..."
                                                        valid="required"
                                                        errmsg="所属课程不能为空!" >
                                                    <option value="-1"></option>
                                                </select>
                                                <span style="color:red;">*</span>&nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_curriculum"></span>

                                            </td>
                                            <td nowrap align="right">任课老师:</td>
                                            <td nowrap>
                                                <input id="teacherName" name="teacherName" class="text"
                                                       value="${vclass.teacherName}" disabled/>
                                                <span style="color:red;">*</span>&nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_teacher"></span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td nowrap align="right">学年:</td>
                                            <td nowrap>
                                                <input id="classYear" name="classYear" class="text"
                                                       value="${vclass.classYear}"
                                                       valid="isNum"
                                                       errmsg="学年只能为数字!"  />

                                            </td>
                                        </tr>


                                    </table>
                                </td>
                            </tr>
                        </table>
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td align="center">
                                    <input type="button" name="Submit" value="保存班级" class="button"
                                           onclick="addNewClass();"/>
                                    <input type="button" name="return" value="返回" class="button"
                                           onclick="window.history.go(-1);">
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
        <td background="/laboratory/../images/mail_rightbg.gif">&nbsp;</td>
    </tr>
    <tr>
        <td valign="bottom" background="/laboratory/../images/mail_leftbg.gif"><img
                src="/laboratory/../images/buttom_left2.gif"
                width="17" height="17"/></td>
        <td valign="bottom" background="/laboratory/../images/buttom_bgs.gif"><img
                src="/laboratory/../images/buttom_bgs.gif"
                width="100%" height="17"></td>
        <td valign="bottom" background="/laboratory/../images/mail_rightbg.gif"><img
                src="/laboratory/../images/buttom_right2.gif"
                width="16" height="17"/></td>
    </tr>
</table>

</form>
</body>
</html>
