/*
 This software is allowed to use under GPL or you need to obtain Commercial or Enterise License
 to use it in non-GPL project. Please contact sales@dhtmlx.com for details
 */
scheduler.attachEvent("onTimelineCreated", function (a) {
    if (a.render == "tree")a.y_unit_original = a.y_unit, a.y_unit = scheduler._getArrayToDisplay(a.y_unit_original), scheduler.attachEvent("onOptionsLoadStart", function () {
        a.y_unit = scheduler._getArrayToDisplay(a.y_unit_original)
    }), scheduler.form_blocks[a.name] = {render: function (b) {
        var d = "<div class='dhx_section_timeline' style='overflow: hidden; height: " + b.height + "px'></div>";
        return d
    }, set_value: function (b, d, g, e) {
        var c = scheduler._getArrayForSelect(scheduler.matrix[e.type].y_unit_original,
            e.type);
        b.innerHTML = "";
        var a = document.createElement("select");
        b.appendChild(a);
        var h = b.getElementsByTagName("select")[0];
        if (!h._dhx_onchange && e.onchange)h.onchange = e.onchange, h._dhx_onchange = !0;
        for (var j = 0; j < c.length; j++) {
            var i = document.createElement("option");
            i.value = c[j].key;
            if (i.value == g[scheduler.matrix[e.type].y_property])i.selected = !0;
            i.innerHTML = c[j].label;
            h.appendChild(i)
        }
    }, get_value: function (b) {
        return b.firstChild.value
    }, focus: function () {
    }}
});
scheduler.attachEvent("onBeforeViewRender", function (a, b, d) {
    var g = {};
    if (a == "tree") {
        var e, c, f, h, j, i;
        b.children ? (e = d.folder_dy || d.dy, d.folder_dy && !d.section_autoheight && (f = "height:" + d.folder_dy + "px;"), c = "dhx_row_folder", h = "dhx_matrix_scell folder", j = "<div class='dhx_scell_expand'>" + (b.open ? "-" : "+") + "</div>", i = d.folder_events_available ? "dhx_data_table folder_events" : "dhx_data_table folder") : (e = d.dy, c = "dhx_row_item", h = "dhx_matrix_scell item", j = "", i = "dhx_data_table");
        td_content = "<div class='dhx_scell_level" +
            b.level + "'>" + j + "<div class='dhx_scell_name'>" + (scheduler.templates[d.name + "_scale_label"](b.key, b.label, b) || b.label) + "</div></div>";
        g = {height: e, style_height: f, tr_className: c, td_className: h, td_content: td_content, table_className: i}
    }
    return g
});
var section_id_before;
scheduler.attachEvent("onBeforeEventChanged", function (a, b, d) {
    if (scheduler._isRender("tree")) {
        var g = scheduler.getSection(a[scheduler.matrix[scheduler._mode].y_property]);
        if (g && typeof g.children != "undefined" && !scheduler.matrix[scheduler._mode].folder_events_available)return d || (a[scheduler.matrix[scheduler._mode].y_property] = section_id_before), !1
    }
    return!0
});
scheduler.attachEvent("onBeforeDrag", function (a, b, d) {
    if (scheduler._isRender("tree")) {
        var g = scheduler._locate_cell_timeline(d);
        if (g) {
            var e = scheduler.matrix[scheduler._mode].y_unit[g.y].key;
            if (typeof scheduler.matrix[scheduler._mode].y_unit[g.y].children != "undefined" && !scheduler.matrix[scheduler._mode].folder_events_available)return!1
        }
        var c = scheduler.getEvent(a);
        section_id_before = e || c[scheduler.matrix[scheduler._mode].y_property]
    }
    return!0
});
scheduler._getArrayToDisplay = function (a) {
    var b = [], d = function (a, e) {
        for (var c = e || 0, f = 0; f < a.length; f++) {
            a[f].level = c;
            if (typeof a[f].children != "undefined" && typeof a[f].key == "undefined")a[f].key = scheduler.uid();
            b.push(a[f]);
            a[f].open && a[f].children && d(a[f].children, c + 1)
        }
    };
    d(a);
    return b
};
scheduler._getArrayForSelect = function (a, b) {
    var d = [], g = function (a) {
        for (var c = 0; c < a.length; c++)scheduler.matrix[b].folder_events_available ? d.push(a[c]) : typeof a[c].children == "undefined" && d.push(a[c]), a[c].children && g(a[c].children, b)
    };
    g(a);
    return d
};
scheduler._toggleFolderDisplay = function (a, b, d) {
    var g, e = function (a, b, c, d) {
        for (var k = 0; k < b.length; k++) {
            if ((b[k].key == a || d) && b[k].children)if (b[k].open = typeof c != "undefined" ? c : !b[k].open, g = !0, !d && g)break;
            b[k].children && e(a, b[k].children, c, d)
        }
    }, c = scheduler.getSection(a);
    if (scheduler.callEvent("onBeforeFolderToggle", [c, b, d]))e(a, scheduler.matrix[scheduler._mode].y_unit_original, b, d), scheduler.matrix[scheduler._mode].y_unit = scheduler._getArrayToDisplay(scheduler.matrix[scheduler._mode].y_unit_original),
        scheduler.callEvent("onOptionsLoad", []), scheduler.callEvent("onAfterFolderToggle", [c, b, d])
};
scheduler.attachEvent("onCellClick", function (a, b) {
    scheduler._isRender("tree") && (scheduler.matrix[scheduler._mode].folder_events_available || typeof scheduler.matrix[scheduler._mode].y_unit[b].children != "undefined" && scheduler._toggleFolderDisplay(scheduler.matrix[scheduler._mode].y_unit[b].key))
});
scheduler.attachEvent("onYScaleClick", function (a, b) {
    scheduler._isRender("tree") && typeof b.children != "undefined" && scheduler._toggleFolderDisplay(b.key)
});
scheduler.getSection = function (a) {
    if (scheduler._isRender("tree")) {
        var b, d = function (a, e) {
            for (var c = 0; c < e.length; c++)e[c].key == a && (b = e[c]), e[c].children && d(a, e[c].children)
        };
        d(a, scheduler.matrix[scheduler._mode].y_unit_original);
        return b || null
    }
};
scheduler.deleteSection = function (a) {
    if (scheduler._isRender("tree")) {
        var b = !1, d = function (a, e) {
            for (var c = 0; c < e.length; c++) {
                e[c].key == a && (e.splice(c, 1), b = !0);
                if (b)break;
                e[c].children && d(a, e[c].children)
            }
        };
        d(a, scheduler.matrix[scheduler._mode].y_unit_original);
        scheduler.matrix[scheduler._mode].y_unit = scheduler._getArrayToDisplay(scheduler.matrix[scheduler._mode].y_unit_original);
        scheduler.callEvent("onOptionsLoad", []);
        return b
    }
};
scheduler.deleteAllSections = function () {
    if (scheduler._isRender("tree"))scheduler.matrix[scheduler._mode].y_unit_original = [], scheduler.matrix[scheduler._mode].y_unit = scheduler._getArrayToDisplay(scheduler.matrix[scheduler._mode].y_unit_original), scheduler.callEvent("onOptionsLoad", [])
};
scheduler.addSection = function (a, b) {
    if (scheduler._isRender("tree")) {
        var d = !1, g = function (a, c, f) {
            if (b)for (var h = 0; h < f.length; h++) {
                f[h].key == c && typeof f[h].children != "undefined" && (f[h].children.push(a), d = !0);
                if (d)break;
                f[h].children && g(a, c, f[h].children)
            } else f.push(a), d = !0
        };
        g(a, b, scheduler.matrix[scheduler._mode].y_unit_original);
        scheduler.matrix[scheduler._mode].y_unit = scheduler._getArrayToDisplay(scheduler.matrix[scheduler._mode].y_unit_original);
        scheduler.callEvent("onOptionsLoad", []);
        return d
    }
};
scheduler.openAllSections = function () {
    scheduler._isRender("tree") && scheduler._toggleFolderDisplay(1, !0, !0)
};
scheduler.closeAllSections = function () {
    scheduler._isRender("tree") && scheduler._toggleFolderDisplay(1, !1, !0)
};
scheduler.openSection = function (a) {
    scheduler._isRender("tree") && scheduler._toggleFolderDisplay(a, !0)
};
scheduler.closeSection = function (a) {
    scheduler._isRender("tree") && scheduler._toggleFolderDisplay(a, !1)
};