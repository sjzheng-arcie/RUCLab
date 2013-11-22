<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title> 实验交流论坛 </title>
    <meta name="keywords" content="!,Board,Comsenz,forums,bulletin board,">
    <meta name="description" content="实验交流论坛 ">
    <meta name="generator" content="Discuz! 6.0.0"/>
    <meta name="author" content="Discuz! Team & Comsenz UI Team"/>
    <meta name="copyright" content="2001-2013 Comsenz Inc."/>
    <meta name="MSSmartTagsPreventParsing" content="TRUE">
    <meta http-equiv="MSThemeCompatible" content="Yes">

    <style type="text/css">
        body {
            margin: 0px;
        }

        #frameswitch {
            background: url(images/default/frame_switch.gif) no-repeat 0;
            cursor: pointer;
        }

        img {
            border: 0;
        }

        .topbar {
            width: 100%;
            height: 33px;
            background: url(images/default/topbar.gif) repeat-x;
            padding: auto 10px;
        }

        .topbar .logo {
            float: left;
            width: 105px;
            height: 33px;
            padding: 0px;
            margin: 0px;
            margin-right: 20px;
        }

        .topbar img {
            border: 0;
        }

        .topbar .pro {
            float: left;
            margin-top: 8px;
            width: 400px;
            height: 20px;
            background: url(images/default/toptab_text.gif) no-repeat 0 -80px;
        }

        .topbar .pro_each {
            float: left;
            width: 50px;
            height: 20px;
            display: inline;
            margin-right: 30px;
        }

        .topbar .pro_each a {
            display: block;
            width: 50px;
            height: 20px;
        }

        .topbar .mole {
            background: url(images/default/toptab_text.gif) no-repeat 0 0;
        }

        .topbar .moleon {
            background: url(images/default/toptab_text.gif) no-repeat -50px 0;
        }

        .topbar .seer {
            background: url(images/default/toptab_text.gif) no-repeat 0 -20px;
        }

        .topbar .seeron {
            background: url(images/default/toptab_text.gif) no-repeat -50px -20px;
        }

        .topbar .haqi {
            background: url(images/default/toptab_text.gif) no-repeat 0 -40px;
        }

        .topbar .haqion {
            background: url(images/default/toptab_text.gif) no-repeat -50px -40px;
        }

        .topbar .dwg {
            background: url(images/default/toptab_text.gif) no-repeat 0 -60px;
        }

        .topbar .hua {
            background: url(images/default/toptab_text.gif) no-repeat -140px 0;
        }

        .topbar .dwgon {
            background: url(images/default/toptab_text.gif) no-repeat -50px -60px;
        }

        .topbar .link {
            float: right;
            width: 230px;
            height: 18px;
            margin-top: 7px;
        }

        .topbar .index {
            float: left;
            background: url(images/default/toptab_text.gif) no-repeat 0 -115px;
            width: 50px;
            height: 18px;
        }

        .topbar .index a {
            display: block;
            width: 50px;
            height: 18px;
        }

        .topbar .pay {
            float: left;
            display: inline;
            margin: 0 10px;
            background: url(images/default/toptab_text.gif) no-repeat -50px -115px;
            width: 70px;
            height: 18px;
        }

        .topbar .pay a {
            display: block;
            width: 70px;
            height: 18px;
        }

        .topbar .reg {
            float: left;
            background: url(images/default/toptab_text.gif) no-repeat -120px -115px;
            width: 80px;
            height: 18px;
        }

        .topbar .reg a {
            display: block;
            width: 80px;
            height: 18px;
        }

    </style>
    <script src="include/javascript/common.js" type="text/javascript"></script>
    <script src="include/javascript/iframe.js" type="text/javascript"></script>
    <script type="text/javascript">function framebutton() {
        var obj = document.getElementById('navigation');
        var frameswitch = document.getElementById('frameswitch');
        var switchbar = document.getElementById('switchbar');
        if (obj.style.display == 'none') {
            obj.style.display = '';
            switchbar.style.left = '177px';
            frameswitch.style.backgroundPosition = '0';
        } else {
            obj.style.display = 'none';
            switchbar.style.left = '0px';
            frameswitch.style.backgroundPosition = '-11';
        }
    }

    if (top != self) {
        top.location = self.location;
    }
    </script>
</head>

<body scroll="no" onResize="resize();">


<table border="0" cellPadding="0" cellSpacing="0" height="100%" width="100%">
    <tr>
        <td align="middle" id="navigation" valign="center" name="frametitle" width="180">
            <iframe name="leftmenu" frameborder="0" src="left.html" scrolling="no"
                    style="height: 100%; visibility: inherit; width: 180px; z-index: 1"
                    onkeydown="refreshrightframe(event)"></iframe>
        </td>
        <td style="width: 100%">
            <table id="switchbar" border="0" cellPadding="0" cellSpacing="0" width="11" height="500"
                   style="position: absolute; left: 177px; background-repeat: repeat-y; background-position: -177px">
                <tr>
                    <td onClick="framebutton()"><img id="frameswitch" src="images/default/none.gif" alt="" border="0"
                                                     width="11" height="49"/></td>
                </tr>
            </table>
            <iframe id="bbs_iframe" frameborder="0" scrolling="yes" name="main_bbs" src="frame.html"
                    style="height: 100%; overflow: auto;" onkeydown="refreshrightframe(event)"></iframe>
        </td>
    </tr>
</table>
<script type="text/javascript">
    function resize() {
        var page_width = document.body.clientWidth;
        var bbs_iframe = document.getElementById('bbs_iframe');
        bbs_iframe.width = page_width - 180;
    }

    resize();
</script>
</body>
</html>
