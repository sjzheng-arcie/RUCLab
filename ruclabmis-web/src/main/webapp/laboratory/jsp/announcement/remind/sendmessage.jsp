<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

    <link href="${pageContext.request.contextPath}/css/skin.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <script src="${pageContext.request.contextPath}/js/valid.js" type=text/javascript></script>
    <link href="${pageContext.request.contextPath}/js/chosen/chosen.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/chosen/chosen.jquery.min.js"></script>



    <title>消息通知</title>
    <style type="text/css">
        .hr1 {
            color: #efeeea;
            height: 1px;
            border: 0px;
            border-top: 1px solid #efeeea;
            margin: 0px;
            margin-top: 8px;
            margin-bottom: 8px;
            padding: 0px;
            overflow: hidden;
        }

        a.announcement:link {
            text-decoration: none;
            color: #000000;
        }
        a.announcement:visited {
            text-decoration: none;
            color: #000000;
        }
        a.announcement:hover {
            text-decoration: none;
            color: #FF0000;
        }
        a.announcement:active {
            text-decoration: none;
            color: #000000;
        }
    </style>
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
<body  style="background-color:#EEF2FB;">
    <table border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td class="op_nor" onclick="javascript:location.href='announcement'">通知</td>
            <td class="op_nor" onclick="javascript:location.href='message?page=1'">短消息</td>
            <td class="op_nor" onclick="javascript:location.href='toaddannouncement'">发布公告</td>
            <td class="op_act" onclick="javascript:location.href='sendmessage'">发送短消息</td>
        </tr>
    </table>
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
                                            <div class="">
                                                <form action="/laboratory/jsp/announcement/remind/laboratory/addMessage"
                                                      method="post" name="mainForm">
                                                    <table style=" border:1px; width:80%;margin:auto;">
                                                        <tr>
                                                            <td align="left">
                                                               <c:choose>
                                                                   <c:when test="${userInfo.sn!=null}">
                                                                       <input type="text" value="${userInfo.name}" disabled="no"/>
                                                                       <input type="hidden"  name="target"  value="${userInfo.id}"/>
                                                                   </c:when>
                                                                   <c:otherwise>
                                                                       <select id="target" name="target"
                                                                               style="width: 252px;height: 22px"
                                                                               data-placeholder="选择人名...">
                                                                           <c:forEach items="${teacherList}" var="teacher">
                                                                               <c:forEach items="${teacherList}" var="teacher">
                                                                                   <option value="${teacher.id}">${teacher.name}(${teacher.sn})</option>
                                                                               </c:forEach>
                                                                           </c:forEach>
                                                                       </select>
                                                                   </c:otherwise>

                                                               </c:choose>

                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="left">

                                                            <textarea id= "content" style="WIDTH: 500px; height: 300px" name="content" rows="20" cols="90"tabIndex="2"></textarea>

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

</html>
