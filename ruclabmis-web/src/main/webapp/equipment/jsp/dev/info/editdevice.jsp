<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>
<script src="../../../../js/DatePicker/WdatePicker.js" type=text/javascript></script>
<script>
    function update() {
        if(!validator(document.mainForm)){
            return;
        }
        document.mainForm.action = "update";
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
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">设备信息管理 > 设备资产 </div>
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
                                                        <div align="center"><img src="../../../images/tb.gif" width="14"
                                                                                 height="14"/></div>
                                                    </td>
                                                    <td width="94%" valign="bottom"><span class="STYLE1">固定资产</span>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <div align="right"><span class="STYLE1">&nbsp;</span><span class="STYLE1"></span>
                                            </div>
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
                                    <tr style="height: 30px;">
                                        <input name="id" id="id" type="hidden" value="${equipment.id}">
                                        <input name="application_id" id="application_id" type="hidden" value="${applicationId}">

                                        <td align="center">设备编号</td>
                                        <td>
                                            <input name="sn" id="sn" value="${equipment.sn}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   valid="required|isNumber"
                                                   errmsg="设备编号不能为空!|设备编号只能为数字"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                        <td align="center">分类</td>
                                        <td>
                                            <select name="categoryId" id="categoryId">
                                                <c:forEach items="${typecodes}" var="typecode">
                                                    <option value="${typecode.id}"
                                                            <c:if test="${typecode.id == equipment.categoryId}"> selected</c:if>>${typecode.name}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                            <span style="color:red;">*</span>
                                        </td>
                                        <td align="center">设备名称</td>
                                        <td>
                                            <input name="name" id="name" value="${equipment.name}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   valid="required"
                                                   errmsg="设备名称不能为空!"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                    </tr>
                                    <tr style="height: 30px;">
                                        <td align="center">领用人</td>
                                        <input name="holder" id="holder" type="hidden" value="${equipment.holder}">
                                        <td>
                                            <input name="holderName" id="holderName" value="${equipment.holderName}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"/>
                                        </td>
                                        <td align="center">使用人</td>
                                        <td>
                                            <input name="user" id="user" value="${equipment.user}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"/>
                                        </td>
                                        <td align="center">设备状态</td>
                                        <td>
                                            <select name="stateId" id="stateId">
                                                <c:forEach items="${states}" var="states">
                                                    <option value="${states.id}"
                                                            <c:if test="${states.id == equipment.stateId}"> selected</c:if>>${states.value}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr style="height: 30px;">
                                        <td align="center">设备型号</td>
                                        <td>
                                            <input name="modelNumber" id="modelNumber" value="${equipment.modelNumber}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   valid="isNumber"
                                                   errmsg="设备型号只能为数字"/>
                                        </td>
                                        <td align="center">设备规格</td>
                                        <td>
                                            <input name="specifications" id="specifications" value="${equipment.specifications}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   valid="isNumber"
                                                   errmsg="设备规格只能为数字"/>
                                        </td>
                                        <td align="center">单价</td>
                                        <td>
                                            <input name="unitPrice" id="unitPrice" value="${equipment.unitPrice}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   valid="required|isNumber"
                                                   errmsg="单价不能为空|单价只能为数字"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                    </tr>
                                    <tr style="height: 30px;">
                                        <td align="center">厂家</td>
                                        <td>
                                            <input name="vender" id="vender" value="${equipment.vender}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"/>
                                        </td>
                                        <td align="center">出厂号</td>
                                        <td>
                                            <input name="factoryNumber" id="factoryNumber" value="${equipment.factoryNumber}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"/>
                                        </td>
                                        <td align="center">国别</td>
                                        <td>
                                            <input name="country" id="country" value="${equipment.country}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"/>
                                        </td>
                                    </tr>
                                    <tr style="height: 30px;">
                                        <td align="center">购置日期</td>
                                        <td>
                                            <input name="acquisitionDate" id="acquisitionDate"
                                                   value="<fmt:formatDate value="${equipment.acquisitionDate}" pattern="yyyy-MM-dd"/>"
                                                   onblur="" class="Mdate" style="width:154px" maxlength="10"
                                                   valid="isDate" errmsg="日期只能为：XXXX-XX-XX"
                                                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                                        </td>
                                        <td align="center">出厂日期</td>
                                        <td>
                                            <input name="manufactureDate" id="manufactureDate"
                                                   value="<fmt:formatDate value="${equipment.manufactureDate}" pattern="yyyy-MM-dd"/>"
                                                   onblur="" class="Mdate" style="width:154px" maxlength="10"
                                                   valid="isDate" errmsg="日期只能为：XXXX-XX-XX"
                                                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                                        </td>
                                        <td align="center">报废日期</td>
                                        <td>
                                            <input name="scrapDate" id="scrapDate"
                                                   value="<fmt:formatDate value="${equipment.scrapDate}" pattern="yyyy-MM-dd"/>"
                                                   onblur="" class="Mdate" style="width:154px" maxlength="10"
                                                   valid="required|isDate" errmsg="报废日期不能为空|日期只能为：XXXX-XX-XX"
                                                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                    </tr>
                                    <tr style="height: 30px;">
                                        <td nowrap align="center">经费科目:</td>
                                        <td nowrap>
                                            <select name="fundingSubjectId" id="fundingSubjectId">
                                                <c:forEach items="${fundingSubjects}" var="fundingSubject">
                                                    <option value="${fundingSubject.id}"
                                                            <c:if test="${fundingSubject.id == equipment.fundingSubjectId}"> selected</c:if>>${fundingSubject.value}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                            <span style="color:red;">*</span>
                                        </td>
                                        <td nowrap align="center">使用方向:</td>
                                        <td nowrap>
                                            <select name="useDirectionId" id="useDirectionId">
                                                <c:forEach items="${useDirections}" var="direction">
                                                    <option value="${direction.id}"
                                                            <c:if test="${direction.id == equipment.useDirectionId}"> selected</c:if>>${direction.value}
                                                    </option>
                                                </c:forEach>
                                                <span style="color:red;">*</span>
                                            </select>
                                        </td>
                                    </tr>
                                </table>

                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td align="center">
                                            <input type="button" name="save" value="保存" class="button" onclick="update();"/>
                                            <input type="reset" name="reset" value="重置" class="button"/>
                                            <input type="button" name="return" value="返回" class="button"
                                                   onclick="window.history.go(-1);"/>
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
                                                                         width="100%" height="17"></td>
    <td valign="bottom" background="../../../images/mail_rightbg.gif"><img
            src="../../../images/buttom_right2.gif" width="16" height="17"/></td>
</tr>
</table>
</form>
</body>