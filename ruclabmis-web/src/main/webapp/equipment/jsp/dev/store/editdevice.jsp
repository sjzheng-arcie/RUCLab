<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link href="../../../css/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script src="../../../../js/valid.js" type=text/javascript></script>
<script src="../../../../js/DatePicker/WdatePicker.js" type=text/javascript></script>
<script>
    function save() {
        document.form1.action = "list.html";
        document.form1.submit();
    }

    function editDevice(){
        var deviceNo=document.getElementById('deviceNo').value;
        var factoryNo=document.getElementById('factoryNo').value;
        var accessoryNum=document.getElementById('accessoryNum').value;
        var device= new Array(deviceNo,factoryNo,accessoryNum)
        if(deviceNo!=""&&factoryNo!=""&&accessoryNum!=""){
            window.returnValue=device;
            window.close();
        }else{
            alert("请输入完整信息");
        }
        window.close();
    }
</script>
<body>
<form name="form1" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="17" valign="top" background="../../../images/mail_leftbg.gif">
        <img src="../../../images/left-top-right.gif" width="17" height="29"/>
    </td>
    <td valign="top" background="../../../images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
            <tr>
                <td height="31">
                    <div class="titlebt">设备信息管理 > 设备资产报增 </div>
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
                                                    <td width="94%" valign="bottom"><span class="STYLE1">固定资产报增单</span>
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
                                        <td align="center">设备编号1</td>
                                        <td>
                                            <input name="sn" id="sn" value="${equipment.sn}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   valid="required|isNumber"
                                                   errmsg="设备编号不能为空!|设备编号只能为数字"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                        <td align="center">分类号</td>
                                        <td>
                                            <input name="category_id" id="category_id" value="${equipment.categoryId}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   valid="required|isNumber"
                                                   errmsg="分类号不能为空!|分类号只能为数字"/>
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
                                        <td align="center">设备型号</td>
                                        <td>
                                            <input name="model_number" id="model_number" value="${equipment.modelNumber}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   valid="isNumber"
                                                   errmsg="设备型号只能为数字"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                        <td align="center">设备规格</td>
                                        <td>
                                            <input name="specifications" id="specifications" value="${equipment.specifications}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   valid="isNumber"
                                                   errmsg="设备规格只能为数字"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                        <td align="center">单价</td>
                                        <td>
                                            <input name="unit_price" id="unit_price" value="${equipment.unitPrice}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"
                                                   valid="isNumber"
                                                   errmsg="单价只能为数字"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                    </tr>
                                    <tr style="height: 30px;">
                                        <td align="center">厂家</td>
                                        <td>
                                            <input name="vender" id="vender" value="${equipment.vender}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                        <td align="center">出厂号</td>
                                        <td>
                                            <input name="factory_number" id="factory_number" value="${equipment.factoryNumber}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                        <td align="center">出厂日期</td>
                                        <td>
                                            <input name="manufacture_date" id="manufacture_date"
                                                   value="<fmt:formatDate value="${equipment.manufactureDate}" pattern="yyyy-MM-dd"/>"
                                                   onblur="" class="Mdate" style="width:154px" maxlength="10"
                                                   valid="isDate" errmsg="日期只能为：XXXX-XX-XX"
                                                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                                        </td>
                                    </tr>
                                    <tr style="height: 30px;">
                                        <td align="center">购置日期</td>
                                        <td>
                                            <input name="acquisition_date" id="acquisition_date"
                                                   value="<fmt:formatDate value="${equipment.acquisitionDate}" pattern="yyyy-MM-dd"/>"
                                                   onblur="" class="Mdate" style="width:154px" maxlength="10"
                                                   valid="isDate" errmsg="日期只能为：XXXX-XX-XX"
                                                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                                        </td>
                                        <td align="center">国别</td>
                                        <td>
                                            <input name="country" id="country" value="${equipment.country}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                    </tr>
                                    <tr style="height: 30px;">
                                        <td nowrap align="center">经费科目:</td>
                                        <td nowrap>
                                            <select name="funding_subject" id="funding_subject">
                                                <c:forEach items="${roles}" var="item">
                                                    <option value="${item.id}"
                                                            <c:if test="${item.id == user.roleId}"> selected</c:if>>${item.name}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td nowrap align="center">使用方向:</td>
                                        <td nowrap>
                                            <select name="use_direction" id="use_direction">
                                                <c:forEach items="${roles}" var="item">
                                                    <option value="${item.id}"
                                                            <c:if test="${item.id == user.roleId}"> selected</c:if>>${item.name}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td align="center">设备状态</td>
                                        <td>
                                            <input name="state" id="state" value="${equipment.stateId}" onblur="" class="text"
                                                   style="width:154px" maxlength="20"/>
                                            <span style="color:red;">*</span>
                                        </td>
                                    </tr>
                                </table>

                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td align="center">
                                            <input type="button" name="Submit" value="保存" class="button" onclick="addDevice();"/>
                                            <input type="reset" name="Submit3" value="重置" class="button"
                                                   onclick="reset();"/>
                                            <input type="button" name="Submit" value="提交" class="button" onclick="save();"/>


                                            <input type="button" name="Submit2" value="返回" class="button"
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
<input type="hidden" name="us_sreplyby" value=""/>
</form>
</body>