<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>
    <link href="${pageContext.request.contextPath}/js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/chosen/chosen.jquery.min.js"></script>

    <script>
        function save() {
            if (!validator(document.mainForm)) {
                return;
            }

            document.mainForm.submit();
        }

        $(document).ready(function () {
            $("#target").chosen({
                no_results_text: "没有找到"
            });
        });

    </script>

</head>
<body style="background-color: #EEF2FB">
<table width="100%" border="0" cellpadding="0" cellspacing="0">

    <tr>
        <td valign="top" bgcolor="#EEF2FB">
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

                <tr valign="top">
                    <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                            <tr bgcolor="#E3E9EE">
                                <td align="center" bgcolor="#E3E9EE">
                                    <div id="">
                                        <div class="message">
                                            <form action="/messagecenter/laboratory/jsp/announcement/remind/addMessage"
                                                  method="post" target="_parent" name="mainForm">
                                                <table style=" border:1px; width:80%;margin:auto;">
                                                    <tr>
                                                        <td align="left">
                                                            <select id="target" name="target"
                                                                    style="width: 252px;height: 22px"
                                                                    data-placeholder="选择人名...">
                                                                <c:forEach items="${teacherList}" var="teacher">
                                                                    <option value="${teacher.id}">${teacher.name}(${teacher.sn})</option>
                                                                </c:forEach>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="left">
                                                            <div id="innerId">
                                                        <span>
                                                            <textarea id= "content" style="WIDTH: 500px; height: 300px" name="content" rows="20" cols="90"tabIndex="2">
                                                            </textarea>
                                                        </span>
                                                                <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.config.js"></script>
                                                                <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.all.js"></script>
                                                                <link type="text/css" href="${pageContext.request.contextPath}/js/ueditor/themes/default/css/ueditor.css"/>
                                                                <script type="text/javascript" charset="utf-8">
                                                                    var editor = new baidu.editor.ui.Editor();
                                                                    editor.render('content');
                                                                </script>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center"><input type="button"
                                                                                  class="autocomplete-suggestion"
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


</body>
