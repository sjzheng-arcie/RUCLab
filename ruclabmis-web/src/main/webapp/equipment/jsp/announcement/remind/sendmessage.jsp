
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="../../../css/skin.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <script src="../../../../js/valid.js" type=text/javascript></script>

    <link rel="stylesheet" href="../../../../js/autocomplete/jquery-ui.css" />
    <link rel="stylesheet" href="../../../../js/autocomplete/autocomplete.styles.css" />

    <script src="../../../../js/autocomplete/jquery-1.9.1.js"></script>
    <script src="../../../../js/autocomplete/jquery-ui.js"></script>

    <script>
        $().ready(function() {
            $( "#target" ).autocomplete({
                source: function( request, response ) {
                    $.ajax({
                        url: "/equipment/jsp/sys/user/autoFillUserName",
                        dataType: "json",
                        data:{
                            param: request.term
                        },
                        success: function( userList ) {
                            response( $.map( userList, function( item ) {
                                return {
                                    label:item.user.name + "(" +item.user.sn + ")",
                                    value:item.user.name + "(" +item.user.sn + ")"
                                }
                            }));
                        }
                    });
                },
                minLength: 1

            });});

    </script>
    <script>
        function save(){
            if(!validator(document.mainForm)){
                return;
            }

            document.mainForm.submit();
        }

        function displayClass(value){

            if(value=="2"){
                document.getElementById('scopeDiv').style.display='';
            }else{
                document.getElementById('scopeDiv').style.display= 'none';;
            }

        }

    </script>

</head>
<body style="background-color: #EEF2FB">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" >

    <tr>
        <td valign="top" bgcolor="#EEF2FB">
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

                <tr valign="top">
                    <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
                            <tr bgcolor="#E3E9EE" >
                                <td  align="center"   bgcolor="#E3E9EE" >
                                    <div id="">
                                        <div  class="message">
                                            <form action="/equipment/jsp/announcement/remind/addMessage"
                                                  method="post" target="_parent" name="mainForm">
                                                <table style=" border:1px; width:80%;margin:auto;">
                                                    <tr>
                                                        <td align="right">接收对象</td>
                                                        <td align="left">
                                                            <input id="target" name="target"  value="${replySn}"
                                                                   autocomplete="off"  valid="required"
                                                                   class="autocomplete-suggestion"
                                                                   errmsg="接收对象不能为空!"  />
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="right">消息内容</td><td align="left">
                                                        <textarea id= "content" style="WIDTH: 500px; height: 300px" name="content" rows="20" cols="90"
                                                                  tabIndex="2"></textarea></span>
                                                    </td>
                                                    </tr>
                                                    <tr>
                                                        <td></td><td align="center"><input type="button" class="autocomplete-suggestion"
                                                                                           onclick="save();" value="发送"></td>
                                                    </tr>
                                                </table>
                                            </form>


                                        </div>

                                    </div>
                                </td>
                            </tr>

                        </table>

                    </td>
                </tr>
            </table>
        </td>

    </tr>

</table>
<input type="hidden" name="us_sreplyby" value=""/>

</body>
