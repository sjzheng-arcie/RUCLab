<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="../../../../css/skin.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script src="../../../../js/valid.js" type=text/javascript></script>
    <script>
        function save() {
            document.mainForm.action = "addAnnouncement";
            document.mainForm.submit();
        }

        function displayClass(value) {
            if (value == "2") {
                document.getElementById('scopeDiv').style.display = '';
            } else {
                document.getElementById('scopeDiv').style.display = 'none';
            }

        }

    </script>

</head>
<body style="background-color: #EEF2FB">
<form name="mainForm" method="post" target="_parent">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">

        <tr>
            <td valign="top" bgcolor="#EEF2FB">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

                    <tr valign="top">
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                                <tr bgcolor="#FFFFFF">
                                    <td align="center" bgcolor="#FFFFFF">
                                        <table border="0" cellpadding="2" cellspacing="1"
                                               style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"
                                               bgcolor="#E3E9EE">
                                            <tr>
                                                <td nowrap align="right">通知标题:</td>
                                                <td nowrap>
                                                    <input id="title" name="title" class="text" style="width:154px"
                                                           maxlength="20"/>
                                                    <span style="color:red;">*</span>&nbsp;&nbsp;

                                                </td>


                                            </tr>
                                            <tr>
                                                <td nowrap align="right">浏览人范围:</td>
                                                <td nowrap>


                                                    <input type="radio" id="radio1" name="scope" value="1"
                                                           onclick="displayClass(this.value);" checked>全网可见</input>
                                                    <input type="radio" id="radio2" name="scope" value="2"
                                                           onclick="displayClass(this.value);">班级可见</input>
                                                    <div id="scopeDiv" style="display:none">
                                                        <select>
                                                            <option>虚拟班级一</option>
                                                            <option>虚拟班级二</option>
                                                        </select>
                                                    </div>

                                                </td>

                                            </tr>
                                            <tr>
                                                <td nowrap align="right">通知内容:</td>
                                                <td colspan="3" nowrap>
                                                    <div id="innerId">
                                                <span><textarea id="content" style="WIDTH: 500px; height: 300px"
                                                                name="content" rows="20" cols="90"
                                                                tabIndex="2"></textarea></span>
                                                        <script type="text/javascript"
                                                                src="../../../../js/ueditor/ueditor.config.js"></script>

                                                        <script type="text/javascript"
                                                                src="../../../../js/ueditor/ueditor.all.js"></script>

                                                        <link type="text/css"
                                                              href="../../../../js/ueditor/themes/default/css/ueditor.css"/>

                                                        <script type="text/javascript" charset="utf-8">
                                                            var editor = new baidu.editor.ui.Editor();
                                                            editor.render('content');
                                                        </script>
                                                    </div>

                                                </td>
                                                <input id="limit" name="limit" style="display:none" value="1"/>
                                            </tr>
                                            <tr>
                                                <td colspan="2" align="center">
                                                    <input type="button" name="Submit" value="保存" class="button" onclick="save();"/>
                                                </td>
                                            </tr>


                                        </table>
                                    </td>
                                </tr>

                            </table>

                        </td>
                    </tr>
                </table>
            </td>

        </tr>

    </table>

</form>
</body>
