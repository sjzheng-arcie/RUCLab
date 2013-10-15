<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String url = request.getRequestURL().toString();
    url = url.substring(0, url.indexOf('/', url.indexOf("//") + 2));
    String context = request.getContextPath();
    url += context;
    application.setAttribute("ctx", url);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<a href="/classif/list">classif</a>

<shiro:guest>
    <p>当前用户为 游客 请 <a href="/views/tologin">登录</a> or <a href="signup">注册</a></p>
</shiro:guest>


<shiro:user>
    <p> 已登录为 <shiro:principal/></p>

    <h1></h1><a href="/views/logout">退出</a>
</shiro:user>


<shiro:authenticated>
    <p>已认证通过的用户： <shiro:principal/> 不包含已记住的用户，这是与user标签的区别所在。</p>
</shiro:authenticated>


<shiro:notAuthenticated>
    <p>未认证通过用户： <shiro:principal/> 与authenticated标签相对应。与guest标签的区别是，该标签包含已记住用户。</p>


</shiro:notAuthenticated>

Please <a href="/views/tologin">Login</a> or <a href="signup">Signup</a> today!


</body>
</html>