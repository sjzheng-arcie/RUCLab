<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>系统异常</title>
</head>
<%
    Throwable ex = null;
    if (exception != null)
        ex = exception;
    if (request.getAttribute("javax.servlet.error.exception") != null)
        ex = (Throwable) request.getAttribute("javax.servlet.error.exception");

    //记录日志
    Logger logger = LoggerFactory.getLogger("duplicate.jsp");
    logger.error(ex.getMessage(), ex);
%>

<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>系统异常</title>
</head>

<body>
<ul>
    <li>
        <h2> 账户名、名称或编号重复,请检查或者账户名，编号是否重复！</h2>
        <h1>

            <p><a href="javascript:;" onclick="window.history.go(-1);">返回</a></p>

        </h1>
    </li>
</ul>

</body>
</html>
