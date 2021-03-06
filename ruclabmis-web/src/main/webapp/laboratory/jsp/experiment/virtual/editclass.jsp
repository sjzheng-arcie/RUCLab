<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="/laboratory/../css/skin.css" rel="stylesheet" type="text/css"/>
    <link href="/js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/util.js"></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <script type="text/javascript " src="/js/valid.js"></script>
    <script type="text/javascript" src="/js/autocomplete/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="/js/chosen/chosen.jquery.min.js"></script>
    <script>
        var classId = "${vClass.id}";

        function deleteStudents(id) {
            var idStr = "";
            if (id) {
                idStr = id;
            } else {
                var idArr = new Array();
                $.each($("input[name='stCheckbox']:checked"), function (idx, data) {
                    idArr.push($(data).val());
                });
                idStr = idArr.join(",");
            }
            if (idStr.length > 0 && window.confirm("您确定要删除该学生吗?")) {
                $.post("/experiment/virtual/removeStudent", {
                    'vcId': $("#vcId").val(),
                    'stIds': idStr
                }, function (data) {
                    if(data.success){
                        window.location.reload(true);
                    }else{
                        alert(data.message);
                    }
                });
            }
        }
        function updateClass() {
            if (!validator(document.listForm)) {
                return;
            }
            var classId = $("#vcId").val(),
                    classSn = $("#classSn").val(),
                    className = $("#className").val(),
                    classYear = $("#classYear").val(),
                    vcId = $("#vcId").val();
            $.post("/experiment/virtual/updateClass", {
                'id': vcId,
                'classSn': classSn,
                'className': className,
                'classYear': classYear
            }, function (data) {
                    window.location.href = "/experiment/virtual/list?page=1";
            });
        }
        function addStudents(){
            var vcId = $("#vcId").val();
            window.open("/experiment/virtual/editClassAddStudent?vcId="+vcId, "学生信息",
                    "height=400, width=800, toolbar=no, status=no");
        }

        function refresh(){
            window.location.reload(true);
        }

        $(document).ready(function () {

        });
    </script>

</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="post">
<input type="hidden" id="vcId" name="vcId" value="${vClass.id}">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="17" valign="top" background="/laboratory/../images/mail_leftbg.gif">
            <img src="/laboratory/../images/left-top-right.gif" width="17" height="29"/>
        </td>
        <td valign="top" background="/laboratory/../images/content-bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg">
                <tr>
                    <td height="31">
                        <div class="titlebt">教学实验管理 > 修改虚拟班级信息</div>
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
                                                                class="STYLE1">班级基本信息</span></td>
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
                                                       value="${vClass.classSn}"
                                                       valid="required"
                                                       errmsg="班级编号不能为空!" />
                                                <span style="color:red;">*</span>&nbsp;&nbsp;

                                            </td>
                                            <td nowrap align="right">班级名称:</td>
                                            <td nowrap>
                                                <input id="className" name="className" class="text"
                                                       value="${vClass.className}"
                                                       valid="required"
                                                       errmsg="班级名称不能为空!" />
                                                <span style="color:red;">*</span>&nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_name"></span>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td nowrap align="right">所属课程:</td>
                                            <td nowrap>
                                                <input id="curriculumName" name="curriculumName" class="text"
                                                       value="${vClass.curriculumName}" disabled/>
                                                <span style="color:red;">*</span>&nbsp;&nbsp;
                                                <span style="color:red;"id="errMsg_curriculum"></span>
                                            </td>
                                            <td nowrap align="right">任课老师:</td>
                                            <td nowrap>
                                                <input id="teacherName" name="teacherName" class="text"
                                                       value="${vClass.teacherName}" disabled/>
                                                <span style="color:red;">*</span>&nbsp;&nbsp;
                                                <span style="color:red;" id="errMsg_teacher"></span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td nowrap align="right">学年:</td>
                                            <td nowrap>
                                                <input id="classYear" name="classYear" class="text"
                                                       value="${vClass.classYear}" />
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td align="center">
                                    <input type="button" name="Submit" value="保存" class="button"
                                           onclick="updateClass()"/>
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


<table width="98%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="17" valign="top" background="/laboratory/../images/mail_leftbg.gif"><img
                src="/laboratory/../images/left-top-right.gif" width="17" height="29"/></td>
        <td valign="top" background="/laboratory/../images/content-bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                <tr>
                    <td height="31">
                        <div class="titlebt">虚拟班级信息 > 学生名单</div>
                    </td>
                </tr>
            </table>
        </td>
        <td width="16" valign="top" background="/laboratory/../images/mail_rightbg.gif"><img
                src="/laboratory/../images/nav-right-bg.gif" width="16" height="29"/></td>
    </tr>

    <tr>
        <td valign="middle" background="/laboratory/../images/mail_leftbg.gif">&nbsp;</td>
        <td valign="top" bgcolor="#F7F8F9">
            <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
                <tr>
                    <td valign="top" class="STYLE10">

                        <span style="white-space:nowrap">&nbsp;&nbsp;学号:<input type="text" name="sn" id="sn"
                                                                               value="" style="width:100px;"/></span>

                        <span style="white-space:nowrap">&nbsp;&nbsp;名称:<input type="text" name="name" id="name"
                                                                               value="" style="width:100px;"/></span>

                        <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);" style="cursor:hand"  class="txt_bt"
                                                                        onclick="toFind('listForm')"><img
                                src="/laboratory/../images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>
                        <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);" class="txt_bt" style="cursor:hand"
                                                                        onclick="deleteStudents()"><img
                                src="/laboratory/../images/del_min.gif" width="15" height="15" border="0"/>
                            删除选课学生</a></span>
                        <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);" class="txt_bt" style="cursor:hand"
                                                                        onclick="addStudents()"><img
                                src="/laboratory/../images/add_min.gif" width="15" height="15" border="0"/>
                            添加学生</a></span>


                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td height="30">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td height="24" bgcolor="#353c44"></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div id="divwidth" style="overflow:auto;overflow-y:hidden;">
                                        <table width="100%" class="table" id="table1" border="0" cellpadding="0"
                                               cellspacing="1" bgcolor="#a8c7ce">
                                            <tr>
                                                <td width="20" height="20" bgcolor="d3eaef" class="STYLE10">
                                                    <div align="center">
                                                        <input type="checkbox" name="checkbox" id="checkbox"
                                                               onclick="checkAll(this,'listForm','stCheckbox');"/>
                                                    </div>
                                                </td>
                                                <td width="20" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">序号</span></div>
                                                </td>
                                                <td width="80" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">学号</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">学生姓名</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">专业</span></div>
                                                </td>
                                                <td width="150" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">入学日期</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">籍贯</span></div>
                                                </td>
                                                <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                    <div align="center"><span class="STYLE10">编辑</span></div>
                                                </td>

                                            </tr>

                                            <c:forEach items="${students}" var="item" varStatus="st">
                                                <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                    <td height="20"><input name="stCheckbox" type="checkbox"
                                                                           value="${item.id}"
                                                                           onclick="checkOne('listForm', 'stCheckbox')"/>
                                                    </td>
                                                    <td>${st.index+1}</td>
                                                    <td>${item.sn}</td>
                                                    <td>${item.name}</td>
                                                    <td>${item.major.name}</td>
                                                    <td><fmt:formatDate value="${item.admissionDate}"
                                                                        pattern="yyyy-MM-dd"/></td>
                                                    <td>${item.originPlace}</td>
                                                    <td><input type="button" class="button" value="删除"
                                                               onclick="deleteStudents('${item.id}')"></td>
                                                </tr>
                                            </c:forEach>
                                            <tr height="16px"></tr>
                                        </table>
                                    </div>
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
                width="100%" height="17"/></td>
        <td valign="bottom" background="/laboratory/../images/mail_rightbg.gif"><img
                src="/laboratory/../images/buttom_right2.gif" width="16" height="17"/></td>
    </tr>
</table>
</form>
</body>
</html>
