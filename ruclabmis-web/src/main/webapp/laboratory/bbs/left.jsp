<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title> 实验交流论坛 </title>
    <meta name="keywords" content="Discuz!,Board,Comsenz,forums,bulletin board,"/>
    <meta name="description" content="实验交流论坛 "/>
    <meta name="generator" content="Discuz! 6.0.0 with Templates 5.0.0"/>
    <meta name="MSSmartTagsPreventParsing" content="TRUE"/>
    <meta http-equiv="MSThemeCompatible" content="Yes"/>
    <link rel="archives" title="实验交流论坛" href="archiver/"/>
    <link rel="stylesheet" type="text/css" id="css" href="forumdata/cache/style_1.css"/>
    <style type="text/css">
        body {
            margin: 0px;
            padding: 2px;
            background: frame_bg . gif;
            background-image: url(images/default/frame_bg.gif);
            background-attachment: fixed;
            background-position: right;
            background-repeat: repeat-y;
        }

        .out {
            padding: 0.2em;
            width: 96%;
            height: 100%;
            overflow: auto;
            text-align: left;
            overflow-x: hidden;
        }

        .tree {
            font: 12px Helvetica, Arial, sans-serif;
            color: #666;
            white-space: nowrap;
            padding-left: 0.4em;
        }

        .tree img {
            border: 0px;
            vertical-align: middle;
        }

        .tree a.node, .tree a.checked {
            white-space: nowrap;
            padding: 1px 2px 1px 2px;
        }

        .tree a.node:hover, .tree a.checked:hover {
            text-decoration: underline;
        }

        .tree a.checked {
            background: frame_bg . gif;
            color: #666;
        }

        .tree .clip {
            overflow: hidden;
        }

        h1 {
            padding-left: 10px;
            font-weight: bold;
            height: 2.4em;
            line-height: 2.4em;
        }

        h2 {
            padding-left: 10px;
            border-bottom: 1px solid #DDD;
            font-weight: normal;
            margin-bottom: 2em;
        }

        h3 {
            border: 1px solid #e9e9e9;
            padding: 3px 5px;
            background: #FFFBEA no-repeat 3px 50%;
            margin-top: 2em;
            padding-top: 0.4em;
            font-weight: normal;
        }

        strong {
            font-weight: bold;
        }
    </style>
    <script type="text/javascript">var IMGDIR = 'images/default';
    var attackevasive = '0';</script>
    <script src="include/javascript/common.js" type="text/javascript"></script>
    <script src="include/javascript/tree.js" type="text/javascript"></script>
    <script src="include/javascript/ajax.js" type="text/javascript"></script>
    <script src="include/javascript/iframe.js" type="text/javascript"></script>

</head>
<body>


<table border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td><img src="images/default/login_top.gif" width="163" height="40"/></td>
    </tr>
    <tr>
        <td><img src="images/default/login_bottom.gif" width="163" height="9"/></td>
    </tr>
</table>

<%--<h3 style="margin:0; padding:5px 0; color:#FF6600; background-color:#eee; text-align:center;">在线用户: 2000人</h3>--%>

<script type="text/javascript">
    ajaxget('misc.php?action=getonlines&inajax=1', 'onlinenum');
    window.setInterval("ajaxget('misc.php?action=getonlines&inajax=1', 'onlinenum', '')", 180000);
</script>

<div class="out">
    <table width="163" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td><img src="images/default/left_tree_top.gif" width="163" height="17"/></td>
        </tr>
        <tr>
            <td>
                <div id="left_list_tree">
                    <script type="text/javascript">
                        var tree = new dzTree('tree');
                        //tree.addNode(0, -1, '论坛首页', 'index.php', 'main', true);

                        tree.addNode(0, -1, '信息学院内部交流论坛', 'frame', 'main', true);
                        <c:forEach items="${courseList}" var="item">
                            tree.addNode(${item.id}, 0, '${item.curriculumName}', 'list?courseId=${item.id}&&page=1', 'main', false);

                        </c:forEach>

                        tree.show();

                        document.getElementById('left_list_tree').style.height = (top.document.body.clientHeight - 281) + 'px';
                    </script>
                </div>
            </td>
        </tr>
        <tr>
            <td><img src="images/default/left_tree_bottom.gif" width="163" height="17"/></td>
        </tr>
    </table>
</div>
<div style="font-size:12px; color:#bbb; display:none;">信息学院交流论坛</div>

</body>
</html>
