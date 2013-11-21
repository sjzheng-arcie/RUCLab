/*
 This software is allowed to use under GPL or you need to obtain Commercial or Enterise License
 to use it in non-GPL project. Please contact sales@dhtmlx.com for details
 */
scheduler.expand = function () {
    var a = scheduler._obj;
    do a._position = a.style.position || "", a.style.position = "static"; while ((a = a.parentNode) && a.style);
    a = scheduler._obj;
    a.style.position = "absolute";
    a._width = a.style.width;
    a._height = a.style.height;
    a.style.width = a.style.height = "100%";
    a.style.top = a.style.left = "0px";
    var b = document.body;
    b.scrollTop = 0;
    if (b = b.parentNode)b.scrollTop = 0;
    document.body._overflow = document.body.style.overflow || "";
    document.body.style.overflow = "hidden";
    scheduler._maximize()
};
scheduler.collapse = function () {
    var a = scheduler._obj;
    do a.style.position = a._position; while ((a = a.parentNode) && a.style);
    a = scheduler._obj;
    a.style.width = a._width;
    a.style.height = a._height;
    document.body.style.overflow = document.body._overflow;
    scheduler._maximize()
};
scheduler.attachEvent("onTemplatesReady", function () {
    var a = document.createElement("DIV");
    a.className = "dhx_expand_icon";
    scheduler.toggleIcon = a;
    scheduler._obj.appendChild(a);
    a.onclick = function () {
        scheduler.expanded ? scheduler.collapse() : scheduler.expand()
    }
});
scheduler._maximize = function () {
    this.expanded = !this.expanded;
    this.toggleIcon.style.backgroundPosition = "0 " + (this.expanded ? "0" : "18") + "px";
    for (var a = ["left", "top"], b = 0; b < a.length; b++) {
        var d = scheduler.xy["margin_" + a[b]], c = scheduler["_prev_margin_" + a[b]];
        scheduler.xy["margin_" + a[b]] ? (scheduler["_prev_margin_" + a[b]] = scheduler.xy["margin_" + a[b]], scheduler.xy["margin_" + a[b]] = 0) : c && (scheduler.xy["margin_" + a[b]] = scheduler["_prev_margin_" + a[b]], delete scheduler["_prev_margin_" + a[b]])
    }
    scheduler.callEvent("onSchedulerResize",
        []) && (scheduler.update_view(), scheduler.callEvent("onAfterSchedulerResize"))
};
