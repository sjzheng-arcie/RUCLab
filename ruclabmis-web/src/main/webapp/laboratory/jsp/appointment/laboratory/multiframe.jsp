<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
</head>

<frameset cols="350,*" frameborder="NO" border="1" framespacing="0" name="appointmentframe">
    <frame src="/laboratory/jsp/appointment/laboratory/multiappointmentbaseinfo" name="multibaseinfoFrame"
           noresize="noresize" marginwidth="0" frameborder="0" scrolling="no" target="multistatusFrame"/>
    <frame src="/laboratory/jsp/appointment/laboratory/multiroomstatus" name="multistatusFrame" noresize="noresize"
           marginwidth="0" marginheight="0" frameborder="0" scrolling="no"/>
</frameset>

</html>