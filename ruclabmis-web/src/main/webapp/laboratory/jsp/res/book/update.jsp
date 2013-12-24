<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <script type="text/javascript" src="../../../../js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="../../../../js/ajaxfileupload.js"></script>
    <script src="../../../../js/valid.js" type=text/javascript></script>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script>
        function uploadFile(){
            var file = document.getElementById("file").value;
            if (!file) {
                alert("请选择要上传的附件!");
                return;
            }

            $.ajaxFileUpload({
                //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
                url:'${pageContext.request.contextPath}/fileUploadController/fileUpload',
                secureuri:false,                       //是否启用安全提交,默认为false
                fileElementId:'file',           //文件选择框的id属性
                dataType:'text',                       //服务器返回的格式,可以是json或xml等
                success:function(data, status){        //服务器响应成功时的处理函数
                    $("#documentName").val($("#file").val());
                },
                error:function(data, status, e){ //服务器响应失败时的处理函数
                    alert('文件上传失败:'+e);
                }
            });
        }

        function save() {
            var documentName = document.getElementById("documentName").value;
            if (!documentName) {
                alert("未添加附件，请先上传!");
                return;
            }

            if (!validator(document.mainForm)) {
                return;
            }

            document.mainForm.action = "update";
            document.mainForm.submit();
        }
    </script>
</head>

<body>

<form name="mainForm" method="post" enctype="multipart/form-data">
    <table width="98%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif">
                <img src="../../../../images/left-top-right.gif" width="17" height="29"/>
            </td>
            <td valign="top" background="../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">教学资源管理 > 修改教学资源</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="../../../../images/mail_rightbg.gif">
                <img src="../../../../images/nav-right-bg.gif" width="16" height="29"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" background="../../../../images/mail_leftbg.gif"></td>
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
                                                                <div align="center"><img src="../../../../images/tb.gif"
                                                                                         width="14" height="14"/></div>
                                                            </td>
                                                            <td width="94%" valign="bottom"><span
                                                                    class="STYLE1">修改教学资源</span></td>
                                                        </tr>
                                                    </table>
                                                </td>
                                                <td>
                                                    <div align="right"><span class="STYLE1"></span><span
                                                            class="STYLE1"> </span></div>
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
                                            <input name="id" id="id" type="hidden" value="${relatedResource.id}">
                                            <tr>
                                                <td align="right">教学资源名称:</td>
                                                <td nowrap>
                                                    <input name="name" id="name" onblur="" class="text" value="${relatedResource.name}"
                                                           style="width:254px" maxlength="20" valid="required"
                                                           errmsg="名称不能为空!" />
                                                    <span style="color:red;">*</span>
                                                </td>
                                                <td align="right">所属课程:</td>
                                                <td nowrap>
                                                    <select name="curriculumId">
                                                        <c:forEach items="${curriculumList}" var="item">
                                                            <option value="${item.id}"
                                                                    <c:if test="${item.id == instruction.curriculumId}">selected </c:if> >${item.name}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                    <span style="color:red;">*</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="right">资源描述:</td>
                                                <td colspan="6">
                                                    <textarea id="content" name="content" style="width:90%;height:30px"
                                                              valid="required"
                                                              errmsg="资源描述不能为空!">${relatedResource.content}</textarea>
                                                    <span style="color:red;"> *</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="right">附件:</td>
                                                <td>
                                                    <input id="documentName" name="documentName" readonly="true" value="${relatedResource.documentName}"/>
                                                    <input style="width:30%" type="file" name="file" id="file" class="bottom" value="浏览"/>
                                                    <input type="button" value="上传" class="bottom" onclick="return uploadFile();"/>
                                                </td>
                                                <td align="right">下载权限:</td>
                                                <td nowrap>
                                                    <select name="downloadLimit">
                                                        <option value="false"   <c:if test="!${relatedResource.downloadLimit}">selected </c:if> >公开</option>
                                                        <option value="true"  <c:if test="${relatedResource.downloadLimit}">selected </c:if> >班级内部</option>
                                                    </select>
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
                                        <input type="button" name="Submit" value="保存" class="button" onclick="save();"/>
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
            <td background="../../../../images/mail_rightbg.gif"></td>
        </tr>

        <tr>
            <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img src="../../../../images/buttom_left2.gif"
                                                                                     width="17" height="17"/></td>
            <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img src="../../../../images/buttom_bgs.gif"
                                                                                    width="100%" height="17"/></td>
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img src="../../../../images/buttom_right2.gif"
                                                                                      width="16" height="17"/></td>
        </tr>
    </table>
</form>
</body>
</html>
