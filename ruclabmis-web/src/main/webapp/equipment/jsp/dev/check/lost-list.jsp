<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>仪器设备类资产盘亏</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/util.js"></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <script>
    </script>
</head>
<body onload="getWidth()" onresize="getWidth()">

<form name="listForm" method="get">
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="/../../../../images/mail_leftbg.gif"><img
                    src="/../../../../images/left-top-right.gif" width="17" height="29"/></td>
            <td valign="top" background="/../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">设备管理系统 > 仪器设备类资产盘亏</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="/../../../../images/mail_rightbg.gif"><img
                    src="/../../../../images/nav-right-bg.gif" width="16" height="29"/></td>
        </tr>

        <tr>
            <td valign="middle" background="/../../../../images/mail_leftbg.gif">&nbsp;</td>
            <td valign="top" bgcolor="#F7F8F9">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9">
                    <tr>
                        <td valign="top" class="STYLE10">

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
                                                                                    src="/../../../../images/tb.gif"
                                                                                    width="14"
                                                                                    height="14"/></div>
                                                                        </td>
                                                                        <td width="94%" valign="bottom"><span
                                                                                class="STYLE1"
                                                                                style="white-space:nowrap">仪器设备类资产实盘报表</span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td>
                                                                <div align="right">
	            	<span class="STYLE1" style="white-space:nowrap">

                  <a href="#" onclick="toHouseDy();"><img src="/../../../../images/del_min.gif" width="10" height="10"
                                                          border="0"/> <span class="STYLE1">导出</span></a>&nbsp;&nbsp;
                  <a href="#" onclick="toHouseLay();"><img src="/../../../../images/del_min.gif" width="10" height="10"
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
                                <tr>
                                    <td>
                                        <div id="divwidth" style="overflow:auto;overflow-y:hidden;">
                                            <table width="100%" class="table" id="table1" border="0" cellpadding="0"
                                                   cellspacing="1" bgcolor="#a8c7ce">
                                                <tr>
                                                    <td width="40" height="20" bgcolor="d3eaef" class="STYLE10">
                                                        <div align="center">
                                                            <input type="checkbox" name="checkbox" id="checkbox"
                                                                   onclick="checkAll(this,'listForm','checkbox');"/>
                                                        </div>
                                                    </td>
                                                    <td width="40" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">序号</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">仪器编号</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">分类号</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">仪器名称</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">型号</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">规格</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">单价</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">厂家</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">出厂号</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">购置日期</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">经费科目</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">领用人</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">存放地点</span></div>
                                                    </td>
                                                    <td width="100" bgcolor="d3eaef">
                                                        <div align="center"><span class="STYLE10">备注</span></div>
                                                    </td>
                                                </tr>
                                                <c:forEach items="${pageInfo.data}" var="equip" varStatus="st">
                                                    <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                                        <td height="20"><input name="checkbox" type="checkbox"
                                                                               value="admin" onclick="checkOne(this)"/>
                                                        </td>
                                                        <td>${st.index+1}</td>
                                                        <td>${equip.sn}</td>
                                                        <td>${equip.categoryId}</td>
                                                        <td>${equip.name}</td>
                                                        <td>${equip.modelNumber}</td>
                                                        <td>${equip.specifications}</td>
                                                        <td>${equip.unitPrice}</td>
                                                        <td>${equip.vender}</td>
                                                        <td>${equip.factoryNumber}</td>
                                                        <td><fmt:formatDate value="${equip.acquisitionDate}" pattern="yyyy-MM-dd"/></td>
                                                        <td>${equip.fundingSubject}</td>
                                                        <td>${equip.user}</td>
                                                        <td>${equip.location}</td>
                                                        <td>${equip.remarks}</td>
                                                    </tr>
                                                </c:forEach>

                                                <tr height="16px"></tr>
                                            </table>
                                        </div>
                                    </td>
                                </tr>
                                <%@ include file="../../common/pagetable.jsp" %>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td background="/../../../../images/mail_rightbg.gif">&nbsp;</td>
        </tr>
        <tr>
            <td valign="bottom" background="/../../../../images/mail_leftbg.gif"><img
                    src="/../../../../images/buttom_left2.gif"
                    width="17" height="17"/></td>
            <td valign="bottom" background="/../../../../images/buttom_bgs.gif"><img
                    src="/../../../../images/buttom_bgs.gif"
                    width="100%" height="17"/></td>
            <td valign="bottom" background="/../../../../images/mail_rightbg.gif"><img
                    src="/../../../../images/buttom_right2.gif"
                    width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>