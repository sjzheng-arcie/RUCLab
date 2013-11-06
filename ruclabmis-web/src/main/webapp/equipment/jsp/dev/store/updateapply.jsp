<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>

<script>
    function update() {
        if(!validator(document.mainForm)){
            return;
        }

        document.mainForm.action = "updateApplication";
        document.mainForm.submit();
    }

    function toAddEquipment(){
        document.mainForm.action = "toAddEquipment?application_id=" + ${store.applicationId};
        document.mainForm.submit();
    }
</script>
<body>
<form name="mainForm" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="../../../images/mail_leftbg.gif">
        <img src="../../../images/left-top-right.gif" width="17" height="29"/>
    </td>
    <td valign="top" background="../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
               id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">设备基本信息管理 > 实验设备入库</div>
                </td>
            </tr>
        </table>
    </td>
    <td width="16" valign="top" background="../../../images/mail_rightbg.gif">
        <img src="../../../images/nav-right-bg.gif" width="16" height="29"/>
    </td>
</tr>
<tr>
    <td valign="middle" background="../../../images/mail_leftbg.gif">&nbsp;</td>
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
                                                        <div align="center"><img src="../../../images/tb.gif"
                                                                                 width="14" height="14"/></div>
                                                    </td>
                                                    <td width="94%" valign="bottom"><span class="STYLE1">实验设备入库申请</span>
                                                    </td>
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
                                        <input type="hidden" name="id" id="id" value="${store.applicationId}">
                                        <input type="hidden" name="applicantId" id="applicantId" value="${store.applicantId}">
                                        <input type="hidden" name="operatorId" id="operatorId" value="${store.operatorId}">
                                        <input type="hidden" name="approverId" id="approverId" value="${store.approverId}">
                                        <input type="hidden" name="stateId" id="stateId" value="${store.stateId}">
                                        <input type="hidden" name="formType" id="formType" value="${store.formType}">

                                        <td align="center">单据号</td>
                                        <td>
                                            <input name="sn" id="sn" value="${store.applicationSn}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   valid="required|isNumber"
                                                   errmsg="单据号不能为空!|单据号只能为数字"/>
                                            <span style="color:red;">*</span>
                                        </td>

                                        <td align="center">申请人</td>
                                        <td>
                                            <input name="applicant" id="applicant"
                                                   style="color:#aaaaaa" disabled value="<shiro:principal/>"
                                                   valid="required"
                                                   errmsg="申请人不能为空!"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td align="center">
                                <shiro:hasAnyRoles name="administrators,teacher,equipment_admin">
                                    <input type="button" name="addEquipment" value="添加设备" class="button" onclick="toAddEquipment();"/>
                                    <input type="button" name="save" value="保存" class="button" onclick="update();"/>
                                    <input type="reset" name="reset" value="重置" class="button"/>
                                </shiro:hasAnyRoles>
                                <input type="button" name="return" value="返回" class="button"
                                       onclick="window.location.href='./list';"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

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
                                                        <div align="center"><img src="../../../images/tb.gif" width="14"
                                                                                 height="14"/></div>
                                                    </td>
                                                    <td width="94%" valign="bottom"><span class="STYLE1">设备列表</span>
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
            </tr>
            <tr valign="top">
                <td>
                    <div id="divwidth" style="overflow:auto;overflow-y:hidden;">
                        <table width="100%" class="table" id="table1" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                            <tr>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">仪器编号</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">名称</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">分类号</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">型号</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">规格</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">单价</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">厂家</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">出厂号</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">出厂日期</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">购置日期</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">报废日期</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">经费科目</span></div>
                                </td>
                                <td width="80" bgcolor="d3eaef">
                                    <div align="center"><span class="STYLE10">使用方向</span></div>
                                </td>
                                <shiro:hasAnyRoles name="administrators,teacher,equipment_admin">
                                    <td width="80" bgcolor="d3eaef">
                                        <div align="center"><span class="STYLE10">详细信息</span></div>
                                    </td>
                                    <td width="80" bgcolor="d3eaef">
                                        <div align="center"><span class="STYLE10">删除设备</span></div>
                                    </td>
                                </shiro:hasAnyRoles>
                            </tr>
                            <c:forEach items="${store.equipments}" var="item">
                                <tr bgcolor="#ffffff" align="center" class="STYLE19">
                                    <td>${item.sn}</td>
                                    <td>${item.name}</td>
                                    <td>${item.categoryId}</td>
                                    <td>${item.modelNumber}</td>
                                    <td>${item.specifications}</td>
                                    <td>${item.unitPrice}</td>
                                    <td>${item.vender}</td>
                                    <td>${item.factoryNumber}</td>
                                    <td><fmt:formatDate value="${item.manufactureDate}" pattern="yyyy-MM-dd"/></td>
                                    <td><fmt:formatDate value="${item.acquisitionDate}" pattern="yyyy-MM-dd"/></td>
                                    <td><fmt:formatDate value="${item.scrapDate}" pattern="yyyy-MM-dd"/></td>
                                    <td>${item.fundingSubject}</td>
                                    <td>${item.useDirection}</td>
                                    <shiro:hasAnyRoles name="administrators,teacher,equipment_admin">
                                        <td><a href="/equipment/jsp/dev/store/toEditEquipment?application_id=${store.applicationId}&equipment_id=${item.id}">
                                            <img src="../../../images/edit_min.gif" width="10" height="10" border="0"/></a>
                                        </td>
                                        <td><a href="/equipment/jsp/dev/store/deleteEquipment?application_id=${store.applicationId}&equipment_id=${item.id}">
                                            <img src="../../../images/del_min.gif" width="10" height="10" border="0"/></a>
                                        </td>
                                    </shiro:hasAnyRoles>
                                </tr>
                            </c:forEach>
                            <tr height="16px"></tr>
                        </table>
                    </div>

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
                                                                         width="100%" height="17"></td>
    <td valign="bottom" background="../../../images/mail_rightbg.gif"><img
            src="../../../images/buttom_right2.gif" width="16" height="17"/></td>
</tr>
</table>
</form>
</body>
