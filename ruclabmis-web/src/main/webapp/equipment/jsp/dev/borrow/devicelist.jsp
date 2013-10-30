<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
    <link href="/equipment/css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/equipment/js/util.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script>

        function checkAll(box) {  //全选或全不选
            form1.checkbox.checked = box.checked;
            if (form1.idcheckbox == null)
                return;
            var numRow = form1.idcheckbox.length;
            if (numRow == null) {
                form1.idcheckbox.checked = box.checked;
                return;
            }
            if (box.checked) {
                for (var i = 0; i < numRow; i++) {
                    form1.idcheckbox[i].checked = true;
                }
            } else {
                for (var i = 0; i < numRow; i++) {
                    form1.idcheckbox[i].checked = false;
                }
            }
        }

        function checkOne() {  //选一个时全选或全不选

            if (form1.idcheckbox == null)
                return;
            var numRow = form1.idcheckbox.length;
            if (numRow == null) {
                form1.checkbox.checked = form1.idcheckbox.checked;
                return;
            }
            var numBox = 0;
            for (var i = 0; i < numRow; i++) {
                if (form1.idcheckbox[i].checked) {
                    numBox++;
                }
            }
            if (numBox == numRow) {
                form1.checkbox.checked = true;
            } else {
                form1.checkbox.checked = false;
            }
        }

        function toUpdate() {
            if (document.form1.idcheckbox == null) {
                return;
            }
            var len = document.form1.idcheckbox.length;
            var flag = 0;
            if (len != undefined) {
                for (var i = 0; i < len; i++) {
                    if (eval(document.form1.idcheckbox[i].checked)) {
                        flag++;
                    }
                }
            } else {
                if (document.form1.idcheckbox.checked) {
                    flag++;
                }
            }

            if (flag == 0) {
                alert("请选择一条记录！");
                return;
            } else if (flag != 1) {
                alert("请只选择一条记录，不要多选！");
                return;
            }
            if (confirm("是否修改？")) {
                document.form1.action = "updateSysint.html";
                document.form1.submit();
            }

        }
        function toDelete() {
            if (document.form1.idcheckbox == null) {
                return;
            }
            var len = document.form1.idcheckbox.length;
            var flag = 0;
            if (len != undefined) {
                for (var i = 0; i < len; i++) {
                    if (eval(document.form1.idcheckbox[i].checked)) {
                        flag++;
                    }
                }
            } else {
                if (document.form1.idcheckbox.checked) {
                    flag++;
                }
            }

            if (flag == 0) {
                alert("请至少选择一条记录！");
                return;
            }
            if (confirm("是否删除所选记录？")) {
                document.form1.action = "";
                document.form1.submit();
            }

        }
        //获得divwidth的宽度
        function getwidth() {
            document.getElementById("divwidth").style.width = document.body.offsetWidth - 35 + "px";
            if (document.body.scrollWidth > document.body.offsetWidth) {
                document.getElementById("divwidth").style.width = document.body.scrollWidth - 35 + "px";
            }
        }
    </script>
</head>
<body onload="getwidth()" onresize="getwidth()">

<form name="form1" method="post">
<table width="98%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="/equipment/images/mail_leftbg.gif"><img
            src="/equipment/images/left-top-right.gif" width="17" height="29"/></td>
    <td valign="top" background="/equipment/images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
               id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">设备借用管理 > 可借用设备</div>
                </td>
            </tr>
        </table>
    </td>
    <td width="16" valign="top" background="/equipment/images/mail_rightbg.gif"><img
            src="/equipment/images/nav-right-bg.gif" width="16" height="29"/></td>
</tr>

<tr>
    <td valign="middle" background="/equipment/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
        <tr>
            <td valign="top" class="STYLE10">
                <span style="white-space:nowrap">&nbsp;&nbsp;设备编号:<input type="text" name="sbSN"
                                                                                     id="sbSN" value=""
                                                                                     style="width:100px;"/></span>
                <span style="white-space:nowrap">&nbsp;&nbsp;设备名称:<input type="text" name="sbName"
                                                                                     id="sbName" value=""
                                                                                     style="width:100px;"/></span>
                <span style="white-space:nowrap">&nbsp;&nbsp;使用方向:
                    <select id="searchD1" name="searchD1">
                        <option value=""></option>
                        <option value="0">验证</option>
                        <option value="1">探究</option>
                    </select>
                </span>
                <span style="white-space:nowrap">&nbsp;&nbsp;<a href="javascript:void(0);"
                                                                            style="cursor:hand"
                                                                            onclick="findInfo()"><img
                                    src="/equipment/images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>


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
                                                        src="/equipment/images/tb.gif"
                                                        width="14" height="14"/></div>
                                            </td>
                                            <td width="94%" valign="bottom"><span
                                                    class="STYLE1"
                                                    style="white-space:nowrap">可借用设备信息列表</span>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <div align="right">
	            	<span class="STYLE1" style="white-space:nowrap">
						<a href="addapply.html"><img src="/equipment/images/add_min.gif" width="10" height="10"
                                                     border="0"/> <span class="STYLE1">申请借用</span></a>&nbsp;


                        <a href="#" onclick="toRoom();"><img src="/equipment/images/del_min.gif" width="10" height="10"
                                                             border="0"/> <span class="STYLE1">打印</span></a>&nbsp;&nbsp;
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
    <c:choose>
        <c:when test="${page.totalResult>0 and fn:length(page.data)>0}">
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
                        <td width="40" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">序号</span></div>
                        </td>
                        <td width="100" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">设备编号</span></div>
                        </td>
                        <td width="200" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">设备名称</span></div>
                        </td>

                        <td width="100" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">设备型号</span></div>
                        </td>
                        <td width="100" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">设备规格</span></div>
                        </td>
                        <td width="100" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">国别</span></div>
                        </td>
                        <td width="100" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">供应商</span></div>
                        </td>
                        <td width="100" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">生产日期</span></div>
                        </td>
                        <td width="100" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">购置日期</span></div>
                        </td>
                        <td width="100" bgcolor="d3eaef">
                            <div align="center"><span class="STYLE10">详细信息</span></div>
                        </td>
                    </tr>
                    <c:forEach items="${page.data}" var="equip" varStatus="st">
                        <tr bgcolor="#ffffff" align="center" class="STYLE19">
                            <td height="20"><input name="idcheckbox" type="checkbox"
                                                   value="admin" onclick="checkOne(this)"/></td>
                            <td>${st.index+1}</td>
                            <td>${equip.sn}</td>
                            <td>${equip.name}</td>
                            <td>${equip.modelNumber}</td>
                            <td>${equip.specifications}</td>
                            <td>${equip.country}</td>
                            <td>${equip.vender}</td>
                            <td><fmt:formatDate value="${equip.manufactureDate}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                            <td><fmt:formatDate value="${equip.acquisitionDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                            <td title=""><a href="devinfo.html">详细信息</a></td>
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
                    <td><span align='left' class='STYLE22' style="white-space:nowrap">&nbsp;&nbsp;共有<strong>${page.totalResult}</strong>
                        条记录，当前第<strong>${page.currentPage}</strong> 页，共 <strong>${page.totalPage}</strong> 页</span>
				<span class='STYLE22' style="white-space:nowrap">
				<table border='0' align='right' cellpadding='0' cellspacing='0' style='font-size:13px;'>
                    <tr>
                        <td width='49'>
                            <div align='center'><img src='/equipment/images/main_54.gif' width='40' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img src='/equipment/images/main_56.gif' width='45' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img src='/equipment/images/main_58.gif' width='45' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img src='/equipment/images/main_60.gif' width='40' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='37' class='STYLE22'>
                            <div align='center' style="white-space:nowrap">转到</div>
                        </td>
                        <td>
                            <div align='left'><select
                                    onchange=" document.forms[0].action='/NWSVN/sysint!find?page='+this.options[this.selectedIndex].value;document.forms[0].submit();">
                                <option class='STYLE22' value="1" selected>第1页</option>
                            </select></div>
                        </td>
                    </tr>
                </table>
					</span>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
        </c:when>
        <c:otherwise>
            <tr>
                <td>
                    <div>当前没有可借用的设备！</div>
                </td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>
</td>
</tr>
</table>
</td>
<td background="/equipment/images/mail_rightbg.gif">&nbsp;</td>
</tr>
<tr>
    <td valign="bottom" background="/equipment/images/mail_leftbg.gif"><img src="/equipment/images/buttom_left2.gif"
                                                                          width="17" height="17"/></td>
    <td valign="bottom" background="/equipment/images/buttom_bgs.gif"><img src="/equipment/images/buttom_bgs.gif"
                                                                         width="100%" height="17"/></td>
    <td valign="bottom" background="/equipment/images/mail_rightbg.gif"><img
            src="/equipment/images/buttom_right2.gif" width="16" height="17"/></td>
</tr>
</table>
</form>
</body>
</html>