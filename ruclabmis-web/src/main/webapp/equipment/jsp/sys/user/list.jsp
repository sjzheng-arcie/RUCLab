<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../js/util.js"></script>
    <title></title>
    <script>
        function checkAll(box) {  //全选或全不选
            document.listForm.checkbox.checked = box.checked;
            if (document.listForm.idcheckbox == null)
                return;
            var numRow = document.listForm.idcheckbox.length;
            if (numRow == null) {
                document.listForm.idcheckbox.checked = box.checked;
                return;
            }
            if (box.checked) {
                for (var i = 0; i < numRow; i++) {
                    document.listForm.idcheckbox[i].checked = true;
                }
            } else {
                for (var i = 0; i < numRow; i++) {
                    document.listForm.idcheckbox[i].checked = false;
                }
            }
        }

        function checkOne() {  //选一个时全选或全不选
            if (document.listForm.idcheckbox == null)
                return;
            var numRow = document.listForm.idcheckbox.length;
            if (numRow == null) {
                document.listForm.checkbox.checked = listForm.idcheckbox.checked;
                return;
            }
            var numBox = 0;
            for (var i = 0; i < numRow; i++) {
                if (document.listForm.idcheckbox[i].checked) {
                    numBox++;
                    break;
                }
            }
            if (numBox == numRow) {
                document.listForm.checkbox.checked = true;
            } else {
                document.listForm.checkbox.checked = false;
            }
        }

        function toUpdate() {
            if (document.listForm.idcheckbox == null) {
                return;
            }
            var len = document.listForm.idcheckbox.length;
            var flag = 0;
            var selectedID;
            if (len != undefined) {
                for (var i = 0; i < len; i++) {
                    if (eval(document.listForm.idcheckbox[i].checked)) {
                        selectedID =  document.listForm.idcheckbox[i].value;
                        flag++;
                    }
                }
            } else {
                if (document.listForm.idcheckbox.checked) {
                    flag++;
                }
            }

            if (flag == 0) {
                alert("请选择一条记录！");
                return;
            } else if (flag != 1) {
                alert("请只选择一条记录！");
                return;
            }
            document.listForm.action = "detail?id="+selectedID;
            document.listForm.submit();


        }
        function toDelete() {
            if (document.listForm.idcheckbox == null) {
                return;
            }
            var len = document.listForm.idcheckbox.length;
            var flag = 0;
            if (len != undefined) {
                for (var i = 0; i < len; i++) {
                    if (eval(document.listForm.idcheckbox[i].checked)) {
                        selectedID =  document.listForm.idcheckbox[i].value;
                        flag++;
                    }
                }
            } else {
                if (document.listForm.idcheckbox.checked) {
                    flag++;
                }
            }

            if (flag == 0) {
                alert("请至少选择一条记录！");
                return;
            }
            if (confirm("是否删除所选记录？")) {
                document.listForm.action = "delete?id="+selectedID;
                document.listForm.submit();
            }

        }

        function onInit() {
            getWidth();
        }

        //获得divwidth的宽度
        function getWidth() {
            document.getElementById("divwidth").style.width = document.body.offsetWidth - 35 + "px";
            if (document.body.scrollWidth > document.body.offsetWidth) {
                document.getElementById("divwidth").style.width = document.body.scrollWidth - 35 + "px";
            }
        }

        function toFind() {
            var href = '/equipment/jsp/sys/user/list?';
            href += 'snLike=' + document.getElementById('searchSN').value +'&';
            href += 'nameLike=' + document.getElementById('searchName').value;

            document.listForm.action = href;
            document.listForm.submit();
        }

        function goPage(page) {
            if (page <= 0) {
                alert("已到达首页！");
                return;
            }
            if (page > ${page.totalPage}) {
                alert("已到达尾页！");
                return;
            }
            var href = '/equipment/jsp/sys/user/list?page=' + page + '&';;
            href += 'snLike=' + document.getElementById('searchSN').value +'&';
            href += 'nameLike=' + document.getElementById('searchName').value;
            document.listForm.action =  href;
            document.listForm.submit();
        }
    </script>

</head>

<body onload="onInit()" onresize="getWidth()">

<form name="listForm" method="post">
<table width="98%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="../../../images/mail_leftbg.gif"><img
            src="../../../images/left-top-right.gif" width="17" height="29"/></td>
    <td valign="top" background="../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
               id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">系统管理 > 用户管理</div>
                </td>
            </tr>
        </table>
    </td>
    <td width="16" valign="top" background="../../../images/mail_rightbg.gif"><img
            src="../../../images/nav-right-bg.gif" width="16" height="29"/></td>
</tr>

<tr>
    <td valign="middle" background="../../../images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
            <tr>
                <td valign="top" class="STYLE10">
                    <span style="white-space:nowrap">
                        &nbsp;&nbsp;账号&nbsp;:&nbsp;<input type="text" name="searchSN"
                                                          id="searchSN" value="${param.searchSN}"
                                                          style="width:100px;"/>
                    </span>
                    <span style="white-space:nowrap">
                        &nbsp;&nbsp;用户名&nbsp;:&nbsp;<input type="text" name="searchName"
                                                           id="searchName" value="${param.searchName}"
                                                           style="width:100px;"/>
                    </span>
                     <span style="white-space:nowrap">&nbsp;&nbsp;
                         <a  href="javascript:void(0)" onclick="toFind();">
                             <img src="../../../images/zoom.png" width="15" height="15" border="0"/> 查询</a>
                     </span>

                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td height="30">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td height="24" bgcolor="#353c44">
                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                <tr>
                                                    <td>
                                                        <table width="100%" border="0" cellspacing="0"
                                                               cellpadding="0">
                                                            <tr>
                                                                <td width="6%" height="19" valign="bottom">
                                                                    <div align="center"><img
                                                                            src="../../../images/tb.gif"
                                                                            width="14" height="14"/></div>
                                                                </td>
                                                                <td width="94%" valign="bottom"><span
                                                                        class="STYLE1"
                                                                        style="white-space:nowrap">用户列表</span>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </td>
                                                    <td>
                                                        <div align="right">
	            	<span class="STYLE1" style="white-space:nowrap">
						<a href="add.jsp">
                            <img src="../../../images/add_min.gif" width="10" height="10" border="0"/>
                            <span class="STYLE1">新增</span>
                        </a>&nbsp;
                        <a href="#" onclick="toUpdate(); return false">
                            <img src="../../../images/edit_min.gif" width="10" height="10"
                                 border="0"/> <span class="STYLE1">修改</span>
                        </a>&nbsp;
      					<a href="#" onclick="toDelete(); return false">
                            <img src="../../../images/del_min.gif" width="10" height="10"
                                 border="0"/> <span class="STYLE1">删除</span>
                        </a>&nbsp;&nbsp;
	                </span>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
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
                                            <td width="40" height="20" bgcolor="d3eaef" class="STYLE10">
                                                <div align="center">
                                                    <input type="checkbox" name="checkbox" id="checkbox"
                                                           onclick="checkAll(this);"/>
                                                </div>
                                            </td>
                                            <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">编号号</span></div>
                                            </td>
                                            <td width="40" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">用户账号</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">用户名</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">性别</span></div>
                                            </td>
                                            <td width="80" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">联系电话</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">邮箱</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">专业</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">用户角色</span></div>
                                            </td>
                                            <td width="100" height="20" bgcolor="d3eaef" class="STYLE6">
                                                <div align="center"><span class="STYLE10">备注</span></div>
                                            </td>
                                        </tr>
                                        <c:forEach items="${users}" var="item">
                                            <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                <td height="20"><input name="idcheckbox" type="checkbox"
                                                                       value="${item.id}" onclick="checkOne(this)"/></td>
                                                <td>${item.id}</td>
                                                <td>${item.sn}</td>
                                                <td>${item.name}</td>
                                                <td>${item.sex}</td>
                                                <td>${item.phoneNum}</td>
                                                <td>${item.email}</td>
                                                <td>${item.majorId}</td>
                                                <td>角色</td>
                                                <td>${item.comment}</td>
                                            </tr>
                                        </c:forEach>
                                        <tr height="16px"></tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="30">
                                <table width='100%' border='0' cellspacing='0' cellpadding='0'
                                       style='font-size:13px;'>
                                    <tr>
                                        <td><span align='left' class='STYLE22' style="white-space:nowrap">
                                            &nbsp;&nbsp;共有<strong>${page.totalResult}</strong> 条记录，当前第<strong>${page.currentPage}</strong> 页，共 <strong>${page.totalPage}</strong> 页</span>

				<span class='STYLE22' style="white-space:nowrap">
				<table border='0' align='right' cellpadding='0' cellspacing='0' style='font-size:13px;'>
                    <tr>
                        <td width='49'>
                            <div align='center'><img onclick="goPage(1)" style="cursor:hand"
                                                     src='../../../images/main_54.gif' width='40' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img onclick="goPage(${page.currentPage-1})" style="cursor:hand"
                                                     src='../../../images/main_56.gif' width='45' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img onclick="goPage(${page.currentPage+1})" style="cursor:hand"
                                                     src='../../../images/main_58.gif' width='45' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img onclick="goPage(${page.totalPage})" style="cursor:hand"
                                                     src='../../../images/main_60.gif' width='40' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='37' class='STYLE22'>
                            <div align='center' style="white-space:nowrap">转到</div>
                        </td>
                        <td>
                            <div align='left'>
                                <select onchange="goPage(this.options[this.selectedIndex].value)">
                                    <c:forEach var="i" begin="1" end="${page.totalPage}" step="1">
                                        <option class='STYLE22' value='${i}'
                                                <c:if test="${page.currentPage == i}">selected</c:if> > 第${i}页
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                    </tr>
                </table>
					</span>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </td>
    <td background="../../../images/mail_rightbg.gif">&nbsp;</td>
</tr>
<tr>
    <td valign="bottom" background="../../../images/mail_leftbg.gif"><img src="../../../images/buttom_left2.gif"
                                                                          width="17" height="17"/></td>
    <td valign="bottom" background="../../../images/buttom_bgs.gif"><img src="../../../images/buttom_bgs.gif"
                                                                         width="100%" height="17"/></td>
    <td valign="bottom" background="../../../images/mail_rightbg.gif"><img
            src="../../../images/buttom_right2.gif" width="16" height="17"/></td>
</tr>
</table>
</form>
</body>
</html>
