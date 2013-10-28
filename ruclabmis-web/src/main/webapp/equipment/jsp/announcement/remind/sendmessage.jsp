<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

<title>发送信息</title>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <link rel="stylesheet" type="text/css" href="../../../../js/autocomplete/autocomplete.styles.css" />
    <script type="text/javascript" src="../../../../js/autocomplete/jquery.autocomplete.min.js"></script>

    <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>


    <style type="text/css">





</style>

<script>
    $().ready(function() {

    $( "#param" ).autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: "/equipment/jsp/announcement/remind/getUserSno",
                dataType: "json",
                data:{
                    param: request.term
                },
                success: function( userList ) {
                    response( $.map( userList, function( item ) {
                        return {
                            param:item.sn

                        }
                    }));
                }
            });
        },
        minLength: 1

    });});

</script>

</head>

<body>

<br />

<br />









<div id="">


	  <div  class="message">
     <form action="/equipment/jsp/announcement/remind/addMessage" method="post" target="_parent" >
	<table style=" border:1px red solid; width:80%;margin:auto;">
		<tr>
		<td align="right">接收对象</td><td align="left"><input name="receiver"type="text"></td>

        </tr>
        <tr><td></td><td> <input id="param" name="param" type="text" autocomplete="off" class="param"  /></td></tr>
		<tr>
		<td align="right">消息内容</td><td align="left">

          <textarea id= "content" style="WIDTH: 500px; height: 300px" name="content" rows="20" cols="90"
                                                                tabIndex="2"></textarea></span>
           </td>
		</tr>
		<tr>
		<td></td><td><input type="submit" value="发送"></td>
		</tr>
	</table>
     </form>


 </div>

</div>

<br />

<br />


<br />

<br />



<br />

<br />

<br />

<br />

<br />

<br />

<br />

<br />

</body>

</html>
