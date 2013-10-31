<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<link href="../../../css/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="../../../../js/valid.js" type=text/javascript></script>
<script> 
function save(){

    document.form1.action="addAnnouncement";
    document.form1.submit();
}
function displayClass(value){

    if(value=="2"){
        document.getElementById('scopeDiv').style.display='';
    }else{
        document.getElementById('scopeDiv').style.display= 'none';
    }

}

</script>

</head>
<body style="background-color: #EEF2FB">
<form name="form1" method="post" target="_parent">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" >

  <tr>
    <td valign="top" bgcolor="#EEF2FB">
       	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

 			<tr valign="top">
    			<td>
    				<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#a8c7ce"  >
                        <tr  align="center"  bgcolor="#E3E9EE" style=" height: 10px;background-color: #E3E9EE"><td bgcolor="#E3E9EE"></td></tr>
                        <tr bgcolor="#E3E9EE" >

        					<td  align="center"  bgcolor="#E3E9EE" >
					  			<table border="0" cellpadding="2" cellspacing="1" style="width:99%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
					 				<tr>
                                        <td align="center">
                                            <div class="message" style="border: 1px;background: #FFFFFF ;height: 800px ;width: 95%">
                                                <p style="height:30px"><p>
                                                <h1 style="text-align: center;margin: 20px">${announcementDetailFlag.title}</h1>
                                                <hr style="margin: 30px">
                                                <p style="margin: 30px" align="left"><span>发送人 :  </span><span>${announcementDetailFlag.user.name}</span> <span style="float:right"><fmt:formatDate value="${announcementDetailFlag.publishTime}"></fmt:formatDate></span>
                                                    <span style="float:right;">发布时间 :  </span></p>
                                                <hr style="margin: 30px">
                                                <div style="margin: 30px;text-align: left">${announcementDetailFlag.content}</div>
                                                <hr style="margin:30px">

                                            </div>
                                        </td>
					    			</tr>



					   			</table>
							</td>

      					</tr>
                        <tr  align="center"  bgcolor="#E3E9EE" style=" height: 10px;background-color: #E3E9EE"><td align="center">
                            <input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
                        </td></tr>
    				</table>
    			</td>
  			</tr>
		</table>
    </td>

  </tr>

</table>
<input type="hidden" name="us_sreplyby" value=""/>
</form>
</body>
