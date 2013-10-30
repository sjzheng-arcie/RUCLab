<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

<title>发送信息</title>


    <link rel="stylesheet" href="../../../../js/autocomplete/jquery-ui.css" />
    <link rel="stylesheet" href="../../../../js/autocomplete/autocomplete.styles.css" />

    <script src="../../../../js/autocomplete/jquery-1.9.1.js"></script>
    <script src="../../../../js/autocomplete/jquery-ui.js"></script>

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
                            label:item.sn,
                            value:item.sn
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
	<table style=" border:1px; width:80%;margin:auto;">
		<tr>
		<td align="right">接收对象</td>
            <td align="left">
                <input id="param" name="param" type="text" autocomplete="off" class="autocomplete-suggestion"  />
            </td>

        </tr>
		<tr>
		<td align="right">消息内容</td><td align="left">

          <textarea id= "content" style="WIDTH: 500px; height: 300px" name="content" rows="20" cols="90"
                                                                tabIndex="2"></textarea></span>
           </td>
		</tr>
		<tr>
		<td></td><td><input type="submit" class="autocomplete-suggestion" value="发送"></td>
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
