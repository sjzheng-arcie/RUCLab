<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <title></title>
</head>
<link href="../../css/style.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="../../common/dhtmlxScheduler/codebase/dhtmlxscheduler.css" type="text/css" media="screen"
      title="no title" charset="utf-8">
<script src="../../common/dhtmlxScheduler/codebase/dhtmlxscheduler.js" type="text/javascript" charset="utf-8"></script>

<style type="text/css" media="screen">
    html, body {
        margin: 0px;
        padding: 0px;
        height: 100%;
        overflow: hidden;
    }
</style>
<script type="text/javascript" charset="utf-8">
    function init() {
        scheduler.config.multi_day = true;
        scheduler.config.xml_date = "%Y-%m-%d %H:%i";
        scheduler.init('scheduler_here', new Date(2013, 2, 5), "month");
        scheduler.load("common/events.xml");

    }
</script>

<body onload="init();">
<div id="scheduler_here" class="dhx_cal_container" style='width:100%; height:100%; border:1px solid #a4bed4'>
    <div class="dhx_cal_navline">
        <div class="dhx_cal_prev_button">&nbsp;</div>
        <div class="dhx_cal_next_button">&nbsp;</div>
        <div class="dhx_cal_today_button"></div>
        <div class="dhx_cal_date"></div>
        <div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div>
        <div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div>
        <div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>
    </div>
    <div class="dhx_cal_header"></div>
    <div class="dhx_cal_data"></div>
</div>
</body>
</html>