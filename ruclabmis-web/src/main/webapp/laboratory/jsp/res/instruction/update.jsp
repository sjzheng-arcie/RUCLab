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
                url:'${pageContext.request.contextPath}/fileUploadControllerReturnPath/fileUpload',
                secureuri:false,                       //是否启用安全提交,默认为false
                fileElementId:'file',           //文件选择框的id属性
                dataType:'json',                       //服务器返回的格式,可以是json或xml等
                success:function(data, status){        //服务器响应成功时的处理函数
                    $("#documentName").val(data.message);
                },
                error:function(data, status, e){ //服务器响应失败时的处理函数
                    alert('文件上传失败:'+e);
                }
            });
        }

        function save() {
            var documentName = document.getElementById("documentName").value;
            if (!documentName) {
                alert("未添加附件，请上传或从实验题库生成!");
                return;
            }

            if (!validator(document.mainForm)) {
                return;
            }

            document.mainForm.action = "update";
            document.mainForm.submit();
        }

        function deleteFile() {
            var id = document.getElementById("id").value;
            window.location.href = "deleteFile?id=" + id;
        }

        function downloadFile() {
            var id = document.getElementById("id").value;
            window.location.href = "downloadFile?id=" + id;
        }

        function toAddSubject(){
            var fileName = document.getElementById("name").value;
            if (!fileName) {
                alert("请输入指导书名称!");
                return;
            }

            window.open("/laboratory/jsp/res/instruction/toAddSubject?name="+fileName, "实验题库",
                    "height=400, width=1000, toolbar=no, status=no");
        }

        function freshDocName(fileName){
            $("#documentName").val(fileName);
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
                            <div class="titlebt">指导书管理 > 编辑指导书</div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="16" valign="top" background="../../../../images/mail_rightbg.gif">
                <img src="../../../../images/nav-right-bg.gif" width="16" height="29"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" background="../../../../images/mail_leftbg.gif">&nbsp;</td>
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
                                                                    class="STYLE1">编辑指导书</span></td>
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
                                            <input name="id" id="id" type="hidden" value="${instruction.id}">
                                            <tr>
                                                <td nowrap align="right">指导书名称:</td>
                                                <td nowrap>
                                                    <input name="name" id="name" onblur="" class="text"
                                                           style="width:154px" maxlength="20" valid="required"
                                                           errmsg="名称不能为空!"  value="${instruction.name}" />
                                                    <span style="color:red;">*</span>
                                                </td>
                                                <td nowrap align="right">所属课程:</td>
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
                                                <td nowrap align="right">实验目的:</td>
                                                <td colspan="3">
                                                    <textarea name="purpose" style="width:90%;height:30px"
                                                              valid="required"
                                                              errmsg="实验目的不能为空!">${instruction.purpose}</textarea>
                                                    <span style="color:red;"> *</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">实验说明:</td>
                                                <td colspan="3">
                                                    <textarea name="explanation" style="width:90%;height:60px"  valid="required"
                                                              errmsg="实验说明不能为空!">${instruction.explanation}</textarea>
                                                    <span style="color:red;"> *</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">附件:</td>
                                                <td>
                                                    <input name="documentPath" id="documentPath" type="hidden"
                                                           value="${instruction.documentPath}"/>
                                                    <input id="documentName" name="documentName" style="color:#aaaaaa" readonly
                                                           value="${instruction.documentName}"/>
                                                    <input type="button" value="下载" class="buttom" onclick="downloadFile();"/>
                                                    <input type="button" value="删除" class="buttom" onclick="deleteFile();"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td/>
                                                <td colspan="2"> 从文件添加附件:
                                                    <input style="width:30%" type="file" name="file" id="file" class="bottom" value="浏览"/>
                                                    <input type="button" value="上传" class="bottom" onclick="return uploadFile();"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td/>
                                                <td>从实验题库生成附件:
                                                    <input type="button" value="选择．．．" class="buttom" onclick="toAddSubject();"/>
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
            <td background="../../../../images/mail_rightbg.gif">&nbsp;</td>
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
