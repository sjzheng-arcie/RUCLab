<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="resources/js/jquery.js"></script>
</head>
<body>
<form method="post" action="upload.do" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" />
</form>
</body>
</html>