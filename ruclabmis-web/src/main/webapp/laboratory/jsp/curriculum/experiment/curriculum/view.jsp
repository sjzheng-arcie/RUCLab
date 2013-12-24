﻿<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:v>
<head>
    <link href="../css/flowPath.css" type="text/css" rel="stylesheet"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title></title>
</head>

<STYLE>
    v\:* {
        behavior: url(#default#VML);
    }
</STYLE>

<body onload="loadView()">
</body>
<script>

    function loadView() {

        var opener = window.opener;
        var doc = document;
        var body = doc.body;
        body.innerHTML = opener.document.getElementById("contextBody").innerHTML;

        var global = opener.com.xjwgraph.Global;
        var tempBaseTool = global.baseTool;

        if (tempBaseTool.isWebKit ||
                tempBaseTool.isOpera) {

            var svgNS = 'http://www.w3.org/2000/svg';

            var lineMap = global.lineMap;
            var svgBody = doc.createElementNS(svgNS, 'svg');

            svgBody.setAttribute("id", "svgContext");
            svgBody.setAttribute("style", "position:absolute;z-index:0;");
            svgBody.setAttribute("height", "100%");
            svgBody.setAttribute("width", "100%");

            var marker = doc.createElementNS(svgNS, 'marker');
            marker.setAttribute("id", "arrow");
            marker.setAttribute("viewBox", "0 0 18 20");
            marker.setAttribute("refX", "0");
            marker.setAttribute("refY", "10");
            marker.setAttribute("markerUnits", "strokeWidth");
            marker.setAttribute("markerWidth", "3");
            marker.setAttribute("markerHeight", "10");
            marker.setAttribute("orient", "auto");

            var linePath = doc.createElementNS(svgNS, 'documentPath');
            linePath.setAttribute("d", "M 0 0 L 20 10 L 0 20 z");
            linePath.setAttribute("fill", "purple");
            linePath.setAttribute("stroke", "blue");

            marker.appendChild(linePath);

            svgBody.appendChild(marker);

            body.appendChild(svgBody);

            var lineKeys = lineMap.getKeys();
            var lineKeysLength = lineKeys.length;

            for (var i = lineKeysLength; i--;) {

                var openerLine = opener.$id(lineKeys[i]);
                var documentPath = openerLine.getAttribute("d") || openerLine.getAttribute("documentPath");

                var line = doc.createElementNS(svgNS, "documentPath");

                line.setAttribute("id", i);
                line.setAttribute("d", documentPath);
                line.setAttribute("documentPath", documentPath);
                line.setAttribute("style", "cursor:pointer; fill:none; stroke:blue; stroke-width:2");
                line.setAttribute("marker-end", 'url(#arrow)');

                svgBody.appendChild(line);

            }

        }

    }

</script>
</html>