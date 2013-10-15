/*
 This software is allowed to use under GPL or you need to obtain Commercial or Enterise License
 to use it in non-GPL project. Please contact sales@dhtmlx.com for details
 */
scheduler.form_blocks.combo = {render: function (b) {
    if (!b.cached_options)b.cached_options = {};
    var d = "";
    d += "<div class='" + b.type + "' style='height:" + (b.height || 20) + "px;' ></div>";
    return d
}, set_value: function (b, d, c, a) {
    b._combo && b._combo.destructor();
    window.dhx_globalImgPath = a.image_path || "/";
    b._combo = new dhtmlXCombo(b, a.name, b.offsetWidth - 8);
    a.options_height && b._combo.setOptionHeight(a.options_height);
    var e = b._combo;
    e.enableFilteringMode(a.filtering, a.script_path || null, !!a.cache);
    if (a.script_path) {
        var f =
            c[a.map_to];
        f ? a.cached_options[f] ? (e.addOption(f, a.cached_options[f]), e.disable(1), e.selectOption(0), e.disable(0)) : dhtmlxAjax.get(a.script_path + "?id=" + f + "&uid=" + scheduler.uid(), function (b) {
            var c = b.doXPath("//option")[0], d = c.childNodes[0].nodeValue;
            a.cached_options[f] = d;
            e.addOption(f, d);
            e.disable(1);
            e.selectOption(0);
            e.disable(0)
        }) : e.setComboValue("")
    } else {
        for (var g = [], h = 0; h < a.options.length; h++) {
            var i = [];
            i.push(a.options[h].key);
            i.push(a.options[h].label);
            g.push(i)
        }
        e.addOption(g);
        if (c[a.map_to]) {
            var j =
                e.getIndexByValue(c[a.map_to]);
            e.selectOption(j)
        }
    }
}, get_value: function (b, d, c) {
    var a = b._combo.getSelectedValue();
    c.script_path && (c.cached_options[a] = b._combo.getSelectedText());
    return a
}, focus: function () {
}};
scheduler.form_blocks.radio = {render: function (b) {
    var d = "";
    d += "<div class='dhx_cal_ltext dhx_cal_radio' style='height:" + b.height + "px;' >";
    for (var c = 0; c < b.options.length; c++) {
        var a = scheduler.uid();
        d += "<input id='" + a + "' type='radio' name='" + b.name + "' value='" + b.options[c].key + "'><label for='" + a + "'> " + b.options[c].label + "</label>";
        b.vertical && (d += "<br/>")
    }
    d += "</div>";
    return d
}, set_value: function (b, d, c, a) {
    for (var e = b.getElementsByTagName("input"), f = 0; f < e.length; f++) {
        e[f].checked = !1;
        var g = c[a.map_to] || d;
        if (e[f].value == g)e[f].checked = !0
    }
}, get_value: function (b) {
    for (var d = b.getElementsByTagName("input"), c = 0; c < d.length; c++)if (d[c].checked)return d[c].value
}, focus: function () {
}};
scheduler.form_blocks.checkbox = {render: function () {
    return scheduler.config.wide_form ? '<div class="dhx_cal_wide_checkbox"></div>' : ""
}, set_value: function (b, d, c, a) {
    var b = document.getElementById(a.id), e = scheduler.uid(), f = typeof a.checked_value != "undefined" ? c[a.map_to] == a.checked_value : !!d;
    b.className += " dhx_cal_checkbox";
    var g = "<input id='" + e + "' type='checkbox' value='true' name='" + a.name + "'" + (f ? "checked='true'" : "") + "'>", h = "<label for='" + e + "'>" + (scheduler.locale.labels["section_" + a.name] || a.name) + "</label>";
    scheduler.config.wide_form ? (b.innerHTML = h, b.nextSibling.innerHTML = g) : b.innerHTML = g + h;
    if (a.handler) {
        var i = b.getElementsByTagName("input")[0];
        i.onclick = a.handler
    }
}, get_value: function (b, d, c) {
    var b = document.getElementById(c.id), a = b.getElementsByTagName("input")[0];
    a || (a = b.nextSibling.getElementsByTagName("input")[0]);
    return a.checked ? c.checked_value || !0 : c.unchecked_value || !1
}, focus: function () {
}};
