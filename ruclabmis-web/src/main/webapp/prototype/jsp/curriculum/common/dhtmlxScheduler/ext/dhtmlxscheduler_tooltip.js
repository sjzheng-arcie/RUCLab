/*
 This software is allowed to use under GPL or you need to obtain Commercial or Enterise License
 to use it in non-GPL project. Please contact sales@dhtmlx.com for details
 */
window.dhtmlXTooltip = window.dhtmlxTooltip = {};
dhtmlXTooltip.config = {className: "dhtmlXTooltip tooltip", timeout_to_display: 50, timeout_to_hide: 50, delta_x: 15, delta_y: -20};
dhtmlXTooltip.tooltip = document.createElement("div");
dhtmlXTooltip.tooltip.className = dhtmlXTooltip.config.className;
dhtmlXTooltip.show = function (b, d) {
    var c = dhtmlXTooltip, h = this.tooltip, a = h.style;
    c.tooltip.className = c.config.className;
    var i = this.position(b), j = b.target || b.srcElement;
    if (!this.isTooltip(j)) {
        var e = 0, f = 0, g = scheduler._obj;
        if (g.offsetParent) {
            do e += g.offsetLeft, f += g.offsetTop; while (g = g.offsetParent)
        }
        var k = i.x + (c.config.delta_x || 0) - e, l = i.y - (c.config.delta_y || 0) - f;
        a.visibility = "hidden";
        a.removeAttribute ? (a.removeAttribute("right"), a.removeAttribute("bottom")) : (a.removeProperty("right"), a.removeProperty("bottom"));
        a.left = "0";
        a.top = "0";
        this.tooltip.innerHTML = d;
        scheduler._obj.appendChild(this.tooltip);
        var n = this.tooltip.offsetWidth, o = this.tooltip.offsetHeight, m = scheduler._obj.parentNode.scrollLeft || 0, p = Math.min(scheduler._obj.offsetWidth, scheduler._obj.parentNode.offsetWidth);
        p - k - (scheduler.xy.margin_left || 0) - n < 0 ? (a.removeAttribute ? a.removeAttribute("left") : a.removeProperty("left"), a.right = scheduler._obj.offsetWidth - m - k + 2 * (c.config.delta_x || 0) + "px") : a.left = k < 0 ? i.x + Math.abs(c.config.delta_x || 0) + "px" : k + m + "px";
        scheduler._obj.offsetHeight - l - (scheduler.xy.margin_top || 0) - o < 0 ? (a.removeAttribute ? a.removeAttribute("top") : a.removeProperty("top"), a.bottom = scheduler._obj.offsetHeight - l - 2 * (c.config.delta_y || 0) + "px") : a.top = l < 0 ? i.y + Math.abs(c.config.delta_y || 0) + "px" : l + "px";
        a.visibility = "visible";
        scheduler.callEvent("onTooltipDisplayed", [this.tooltip, this.tooltip.event_id])
    }
};
dhtmlXTooltip.hide = function () {
    if (this.tooltip.parentNode) {
        var b = this.tooltip.event_id;
        this.tooltip.event_id = null;
        this.tooltip.parentNode.removeChild(this.tooltip);
        scheduler.callEvent("onAfterTooltip", [b])
    }
};
dhtmlXTooltip.delay = function (b, d, c, h) {
    this.tooltip._timeout_id && window.clearTimeout(this.tooltip._timeout_id);
    this.tooltip._timeout_id = setTimeout(function () {
        var a = b.apply(d, c);
        b = d = c = null;
        return a
    }, h || this.config.timeout_to_display)
};
dhtmlXTooltip.isTooltip = function (b) {
    for (var d = !1; b && !d;)d = b.className == this.tooltip.className, b = b.parentNode;
    return d
};
dhtmlXTooltip.position = function (b) {
    b = b || window.event;
    if (b.pageX || b.pageY)return{x: b.pageX, y: b.pageY};
    var d = window._isIE && document.compatMode != "BackCompat" ? document.documentElement : document.body;
    return{x: b.clientX + d.scrollLeft - d.clientLeft, y: b.clientY + d.scrollTop - d.clientTop}
};
scheduler.attachEvent("onMouseMove", function (b, d) {
    var c = window.event || d, h = c.target || c.srcElement, a = dhtmlXTooltip, i = a.isTooltip(h), j = a.isTooltipTarget && a.isTooltipTarget(h);
    if (b || i || j) {
        var e;
        if (b || a.tooltip.event_id) {
            var f = scheduler.getEvent(b) || scheduler.getEvent(a.tooltip.event_id);
            if (!f)return;
            a.tooltip.event_id = f.id;
            e = scheduler.templates.tooltip_text(f.start_date, f.end_date, f);
            if (!e)return a.hide()
        }
        j && (e = "");
        var g = void 0;
        _isIE && (g = document.createEventObject(c));
        scheduler.callEvent("onBeforeTooltip",
            [b]) && e && a.delay(a.show, a, [g || c, e])
    } else a.delay(a.hide, a, [], a.config.timeout_to_hide)
});
scheduler.attachEvent("onBeforeDrag", function () {
    dhtmlXTooltip.hide();
    return!0
});
scheduler.attachEvent("onEventDeleted", function () {
    dhtmlXTooltip.hide();
    return!0
});
scheduler.templates.tooltip_date_format = scheduler.date.date_to_str("%Y-%m-%d %H:%i");
scheduler.templates.tooltip_text = function (b, d, c) {
    return"<b>Event:</b> " + c.text + "<br/><b>Start date:</b> " + scheduler.templates.tooltip_date_format(b) + "<br/><b>End date:</b> " + scheduler.templates.tooltip_date_format(d)
};
