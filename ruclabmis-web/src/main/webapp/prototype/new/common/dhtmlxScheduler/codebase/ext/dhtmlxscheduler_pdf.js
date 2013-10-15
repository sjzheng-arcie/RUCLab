/*
 This software is allowed to use under GPL or you need to obtain Commercial or Enterise License
 to use it in non-GPL project. Please contact sales@dhtmlx.com for details
 */
(function () {
    function f(b) {
        return b.replace(newline_regexp, "\n").replace(html_regexp, "")
    }

    function m(b) {
        var b = parseFloat(b), e = B(b), b = b - e.width + e.cols * dx;
        return isNaN(b) ? "auto" : 100 * b / dx
    }

    function B(b) {
        for (var e = 0, c = scheduler._els.dhx_cal_header[0].childNodes[0].childNodes, a = 0; a < c.length; a++) {
            var d = c[a].style ? c[a] : c[a].parentNode, g = parseFloat(d.style.width);
            if (b > g)b -= g + 1, e += g + 1; else break
        }
        return{width: e, cols: a}
    }

    function v(b) {
        b = parseFloat(b);
        return isNaN(b) ? "auto" : 100 * b / dy
    }

    function r(b) {
        var e = "";
        if (scheduler.matrix &&
            scheduler.matrix[scheduler._mode]) {
            if (scheduler.matrix[scheduler._mode].second_scale)var c = b[1].childNodes;
            b = b[0].childNodes
        }
        for (var a = 0; a < b.length; a++)e += "\n<column><![CDATA[" + f(b[a].innerHTML) + "]]\></column>";
        dx = b[0].offsetWidth;
        if (c)for (var d = 0, g = b[0].offsetWidth, i = 1, a = 0; a < c.length; a++)e += "\n<column second_scale='" + i + "'><![CDATA[" + f(c[a].innerHTML) + "]]\></column>", d += c[a].offsetWidth, d >= g && (g += b[i] ? b[i].offsetWidth : 0, i++), dx = c[0].offsetWidth;
        return e
    }

    function C(b, e) {
        for (var c = parseInt(b.style.left,
            10), a = 0; a < scheduler._cols.length; a++)if (c -= scheduler._cols[a], c < 0)return a;
        return e
    }

    function D(b, e) {
        for (var c = parseInt(b.style.top, 10), a = 0; a < scheduler._colsS.heights.length; a++)if (scheduler._colsS.heights[a] > c)return a;
        return e
    }

    function s(b) {
        for (var e = "", c = b.firstChild.rows, a = 0; a < c.length; a++) {
            for (var d = [], g = 0; g < c[a].cells.length; g++)d.push(c[a].cells[g].firstChild.innerHTML);
            e += "\n<row height='" + b.firstChild.rows[a].cells[0].offsetHeight + "'><![CDATA[" + f(d.join("|")) + "]]\></row>";
            dy = b.firstChild.rows[0].cells[0].offsetHeight
        }
        return e
    }

    function t(b, e, c, a) {
        var d = "<" + b + " profile='" + e + "'";
        c && (d += " header='" + c + "'");
        a && (d += " footer='" + a + "'");
        d += ">";
        return d
    }

    function E(b) {
        return b ? "<" + b + ">" : ""
    }

    function n(b) {
        return b ? "</" + b + ">" : ""
    }

    function x() {
        var b = "", e = scheduler._mode;
        scheduler.matrix && scheduler.matrix[scheduler._mode] && (e = "timeline");
        b += "<scale mode='" + e + "' today='" + scheduler._els.dhx_cal_date[0].innerHTML + "'>";
        if (scheduler._mode == "week_agenda")for (var c = scheduler._els.dhx_cal_data[0].getElementsByTagName("DIV"), a = 0; a < c.length; a++)c[a].className ==
            "dhx_wa_scale_bar" && (b += "<column>" + f(c[a].innerHTML) + "</column>"); else if (scheduler._mode == "agenda" || scheduler._mode == "map")c = scheduler._els.dhx_cal_header[0].childNodes[0].childNodes, b += "<column>" + f(c[0].innerHTML) + "</column><column>" + f(c[1].innerHTML) + "</column>"; else if (scheduler._mode == "year") {
            c = scheduler._els.dhx_cal_data[0].childNodes;
            for (a = 0; a < c.length; a++)b += "<month label='" + f(c[a].childNodes[0].innerHTML) + "'>", b += r(c[a].childNodes[1].childNodes), b += s(c[a].childNodes[2]), b += "</month>"
        } else {
            b +=
                "<x>";
            c = scheduler._els.dhx_cal_header[0].childNodes;
            b += r(c);
            b += "</x>";
            var d = scheduler._els.dhx_cal_data[0];
            if (scheduler.matrix && scheduler.matrix[scheduler._mode]) {
                b += "<y>";
                for (a = 0; a < d.firstChild.rows.length; a++) {
                    var g = d.firstChild.rows[a];
                    b += "<row><![CDATA[" + f(g.cells[0].innerHTML) + "]]\></row>"
                }
                b += "</y>";
                dy = d.firstChild.rows[0].cells[0].offsetHeight
            } else if (d.firstChild.tagName == "TABLE")b += s(d); else {
                for (d = d.childNodes[d.childNodes.length - 1]; d.className.indexOf("dhx_scale_holder") == -1;)d = d.previousSibling;
                d = d.childNodes;
                b += "<y>";
                for (a = 0; a < d.length; a++)b += "\n<row><![CDATA[" + f(d[a].innerHTML) + "]]\></row>";
                b += "</y>";
                dy = d[0].offsetHeight
            }
        }
        b += "</scale>";
        return b
    }

    function h(b, e) {
        return(window.getComputedStyle ? window.getComputedStyle(b, null)[e] : b.currentStyle ? b.currentStyle[e] : null) || ""
    }

    function y(b) {
        var e = "", c = scheduler._rendered;
        if (scheduler._mode == "agenda" || scheduler._mode == "map")for (var a = 0; a < c.length; a++)e += "<event><head>" + f(c[a].childNodes[0].innerHTML) + "</head><body>" + f(c[a].childNodes[2].innerHTML) +
            "</body></event>"; else if (scheduler._mode == "week_agenda")for (a = 0; a < c.length; a++)e += "<event day='" + c[a].parentNode.getAttribute("day") + "'><body>" + f(c[a].innerHTML) + "</body></event>"; else if (scheduler._mode == "year") {
            c = scheduler.get_visible_events();
            for (a = 0; a < c.length; a++) {
                var d = c[a].start_date;
                if (d.valueOf() < scheduler._min_date.valueOf())d = scheduler._min_date;
                for (; d < c[a].end_date;) {
                    var g = d.getMonth() + 12 * (d.getFullYear() - scheduler._min_date.getFullYear()) - scheduler.week_starts._month, i = scheduler.week_starts[g] +
                        d.getDate() - 1, j = b ? h(scheduler._get_year_cell(d), "color") : "", k = b ? h(scheduler._get_year_cell(d), "backgroundColor") : "";
                    e += "<event day='" + i % 7 + "' week='" + Math.floor(i / 7) + "' month='" + g + "' backgroundColor='" + k + "' color='" + j + "'></event>";
                    d = scheduler.date.add(d, 1, "day");
                    if (d.valueOf() >= scheduler._max_date.valueOf())break
                }
            }
        } else {
            var z = scheduler.matrix && scheduler.matrix[scheduler._mode];
            if (z && z.render == "cell") {
                c = scheduler._els.dhx_cal_data[0].getElementsByTagName("TD");
                for (a = 0; a < c.length; a++)j = b ? h(c[a], "color") :
                    "", k = b ? h(c[a], "backgroundColor") : "", e += "\n<event><body backgroundColor='" + k + "' color='" + j + "'><![CDATA[" + f(c[a].innerHTML) + "]]\></body></event>"
            } else for (a = 0; a < c.length; a++) {
                var l = m(c[a].style.left), q = m(c[a].style.width);
                if (!isNaN(q * 1)) {
                    var o = v(c[a].style.top), p = v(c[a].style.height), n = c[a].className.split(" ")[0].replace("dhx_cal_", "");
                    if (n !== "dhx_tooltip_line") {
                        var w = scheduler.getEvent(c[a].getAttribute("event_id")), i = w._sday, u = w._sweek, r = w._length || 0;
                        if (scheduler._mode != "month") {
                            if (scheduler.matrix &&
                                scheduler.matrix[scheduler._mode]) {
                                var i = 0, s = c[a].parentNode.parentNode.parentNode, u = s.rowIndex;
                                q += m(10)
                            } else {
                                scheduler.xy.menu_width && (q += m(q * 20 / 100), l -= m(15 - l * 20 / 100));
                                if (c[a].parentNode == scheduler._els.dhx_cal_data[0])continue;
                                l += m(c[a].parentNode.style.left);
                                l -= m(51)
                            }
                            if (scheduler.matrix && scheduler.matrix[scheduler._mode]) {
                                var t = dy;
                                dy = c[a].parentNode.offsetHeight;
                                o = v(c[a].style.top);
                                o -= o * 0.2;
                                dy = t
                            }
                        } else p = parseInt(c[a].offsetHeight, 10), o = parseInt(c[a].style.top, 10) - 22, i = C(c[a], i), u = D(c[a], u);
                        e +=
                            "\n<event week='" + u + "' day='" + i + "' type='" + n + "' x='" + l + "' y='" + o + "' width='" + q + "' height='" + p + "' len='" + r + "'>";
                        n == "event" ? (e += "<header><![CDATA[" + f(c[a].childNodes[1].innerHTML) + "]]\></header>", j = b ? h(c[a].childNodes[2], "color") : "", k = b ? h(c[a].childNodes[2], "backgroundColor") : "", e += "<body backgroundColor='" + k + "' color='" + j + "'><![CDATA[" + f(c[a].childNodes[2].innerHTML) + "]]\></body>") : (j = b ? h(c[a], "color") : "", k = b ? h(c[a], "backgroundColor") : "", e += "<body backgroundColor='" + k + "' color='" + j + "'><![CDATA[" + f(c[a].innerHTML) +
                            "]]\></body>");
                        e += "</event>"
                    }
                }
            }
        }
        return e
    }

    function A(b, e, c, a, d, g, f) {
        var j = !1;
        d == "fullcolor" && (j = !0, d = "color");
        d = d || "color";
        html_regexp = RegExp("<[^>]*>", "g");
        newline_regexp = RegExp("<br[^>]*>", "g");
        var k = scheduler.uid(), h = document.createElement("div");
        h.style.display = "none";
        document.body.appendChild(h);
        h.innerHTML = '<form id="' + k + '" method="post" target="_blank" action="' + a + '" accept-charset="utf-8" enctype="application/x-www-form-urlencoded"><input type="hidden" name="mycoolxmlbody"/> </form>';
        var l =
            "";
        if (b) {
            for (var m = scheduler._date, o = scheduler._mode, l = t("pages", d, g, f), p = new Date(b); +p < +e; p = scheduler.date.add(p, 1, c))scheduler.setCurrentView(p, c), l += E("page") + x().replace("\u2013", "-") + y(j) + n("page");
            l += n("pages");
            scheduler.setCurrentView(m, o)
        } else l = t("data", d, g, f) + x().replace("\u2013", "-") + y(j) + n("data");
        document.getElementById(k).firstChild.value = encodeURIComponent(l);
        document.getElementById(k).submit();
        h.parentNode.removeChild(h)
    }

    scheduler.toPDF = function (b, e, c, a) {
        return A.apply(this, [null,
            null, null, b, e, c, a])
    };
    scheduler.toPDFRange = function (b, e, c, a, d, f, h) {
        typeof b == "string" && (b = scheduler.templates.api_date(b), e = scheduler.templates.api_date(e));
        return A.apply(this, arguments)
    }
})();
