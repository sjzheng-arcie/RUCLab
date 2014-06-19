<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>

    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../../../js/util.js"></script>
    <script type="text/javascript" src="../../../../js/page.js"></script>
    <script type="text/javascript" src="../../../../js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="../../../../js/ajaxfileupload.js"></script>
    <script src="../../../../js/DatePicker/WdatePicker.js" type=text/javascript></script>
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>
    <title></title>

    <script>



        function toAddCharger(){
            window.open("/laboratory/jsp/task/task/userlist?page=1&userIdList="+$('body').data('userIdlistBody').join(","), "人员信息",
                    "height=450, width=1000, toolbar=no, status=no");
        }
        function setUser(selectedUser) {
            var userIdNameList=new Array();
            userIdNameList=selectedUser.toString().split(',');
            var idList=new Array();
            var nameList=new Array();
            var i=0;
            for(i=0;i<userIdNameList.length;i++){
                var tempUser=userIdNameList[i].toString();
                var tempUserId=tempUser.substring(0,tempUser.indexOf('+'));
                var tempUserName=tempUser.substring(tempUser.indexOf('+')+1,tempUser.length);
                idList[i]=tempUserId;
                nameList[i]=tempUserName;
                $('#userShowArea').append(formatUserDisplay(tempUserId,tempUserName));
                $("body").data('userIdlistBody').push(tempUserId);
            }
          // (idList);

        }

            function userDelete(e) {

                var src = window.event.srcElement;

                var userId = src.getAttribute("userId");
                var index = $.inArray(userId,$("body").data('userIdlistBody'));


                if(index>=0){
                    $("body").data('userIdlistBody').splice(index,1);
                }

                $(src).parent().next().remove();
                $(src).parent().remove();

                window.event.stopPropagation();

            }


        function formatUserDisplay(userId,userName) {

            return '<span>' + userName+ ' <a href="javascript:;" class="button" userId=\"' +userId+ '\" onclick="userDelete(event)">删除</a> </span><br/>';
        }
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
                fileElementId:'file',                   //文件选择框的id属性
                dataType:'json',                       //服务器返回的格式,可以是json或xml等
                success:function(data, status){        //服务器响应成功时的处理函数
                    $("#documentName").val(data.message);
                  //  $("#documentName").val(""+file.substr(file.lastIndexOf("\\")+1,file.length));
                },
                error:function(data, status, e){ //服务器响应失败时的处理函数
                    alert('文件上传失败:'+e);
                }
            });
        }

        function save(){

            if (!validator(document.mainForm)) {
                return;
            }
            document.mainForm.action="addones?teacherId="+${teacherInfo.id};
            document.mainForm.submit();
        }
        $(document).ready(function () {
            $('body').data('filelist', new Array());

            $('body').data('userIdlistBody',new Array());

            init();
        });
    </script>
</head>

<body onload="getWidth()" onresize="getWidth()">

<form name="mainForm" method="post">

    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="17" valign="top" background="../../../../images/mail_leftbg.gif">
                <img src="../../../../images/left-top-right.gif" width="17" height="29"/>
            </td>
            <td valign="top" background="../../../../images/content-bg.gif">
                <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg"
                       id="table2">
                    <tr>
                        <td height="31">
                            <div class="titlebt">考核管理 > 添加工作任务</div>
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
                                                                    class="STYLE1">添加任务</span></td>
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
                                               style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;" bgcolor="#E3E9EE">

                                            <input type="hidden" name="teacherId"value="${teacherInfo.id}"/>
                                            <tr>
                                                <td nowrap align="right">任务名称:</td>
                                                <td nowrap>
                                                    <input name="taskName" id="taskName" onblur="" class="text"
                                                           style="width:154px" maxlength="20" valid="required" errmsg="请填写任务名！"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_task_name"></span>
                                                </td>
                                                <td nowrap align="right">类型:</td>
                                                <td nowrap>
                                                    <select name="typeId" id="typeId">
                                                        <c:forEach items="${taskTypeList}" var="item">
                                                            <option value="${item.id}"> ${item.typeName}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_task_no"></span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td nowrap align="right" >任务成员</td>
                                                <td nowrap  align="left" colspan="3">
                                                    <input type="text" name="teacher" value="${teacherInfo.name}" disabled/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">完成时间:</td>
                                                <td nowrap>
                                                    <input name="limitDate" id="limitDate"
                                                           onblur="" class="Mdate" style="width:154px" maxlength="10"
                                                           valid="isDate|required" errmsg="日期只能为：XXXX-XX-XX|请填写日期"
                                                           onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>

                                                    <span style="color:red;">*</span>&nbsp;&nbsp;
                                                    <span style="color:red;" id="errMsg_limit_time"></span>
                                                </td>
                                                <td nowrap align="right"></td>
                                                <td nowrap>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td nowrap align="right">上传附件:</td>
                                                <td colspan="3">
                                                    <input type="text" id="documentName" name="documentName" readonly="true"/>
                                                    <input style="width:30%" type="file" name="file" id="file" class="" value="浏览"/>
                                                    <input type="button" value="上传" class="bottom" onclick="return uploadFile();"/>

                                                </td>
                                            </tr>
                                            <tr>
                                                <td nowrap align="right">任务内容:</td>
                                                <td colspan="3"><textarea name="taskContent" style="width:70%;height:100px"></textarea>
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
                                        <input type="reset" name="reset" value="重置" class="button"  onclick="reset();"/>
                                        <input type="button" name="return" value="返回" class="button" onclick="window.history.go(-1);"/>
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
            <td valign="bottom" background="../../../../images/mail_leftbg.gif"><img
                    src="../../../../images/buttom_left2.gif" width="17" height="17"/></td>
            <td valign="bottom" background="../../../../images/buttom_bgs.gif"><img
                    src="../../../../images/buttom_bgs.gif" width="100%" height="17"></td>
            <td valign="bottom" background="../../../../images/mail_rightbg.gif"><img
                    src="../../../../images/buttom_right2.gif" width="16" height="17"/></td>
        </tr>
    </table>


</form>
</body>
</html>
