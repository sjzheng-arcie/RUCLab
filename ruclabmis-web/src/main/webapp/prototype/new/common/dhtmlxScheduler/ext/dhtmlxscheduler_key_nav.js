/*
 This software is allowed to use under GPL or you need to obtain Commercial or Enterise License
 to use it in non-GPL project. Please contact sales@dhtmlx.com for details
 */
(function () {
    var h = !1, i, e = null;
    scheduler.attachEvent("onBeforeLightbox", function () {
        return h = !0
    });
    scheduler.attachEvent("onAfterLightbox", function () {
        h = !1;
        return!0
    });
    scheduler.attachEvent("onMouseMove", function (b, a) {
        i = scheduler.getActionData(a).date
    });
    dhtmlxEvent(document, _isOpera ? "keypress" : "keydown", function (b) {
        b = b || event;
        if (!h) {
            var a = window.scheduler;
            if (b.keyCode == 37 || b.keyCode == 39) {
                b.cancelBubble = !0;
                var k = a.date.add(a._date, b.keyCode == 37 ? -1 : 1, a._mode);
                a.setCurrentView(k);
                return!0
            }
            var f = a._select_id;
            if (b.ctrlKey && b.keyCode == 67) {
                if (f)a._buffer_id = f, e = !0, a.callEvent("onEventCopied", [a.getEvent(f)]);
                return!0
            }
            if (b.ctrlKey && b.keyCode == 88 && f) {
                e = !1;
                a._buffer_id = f;
                var c = a.getEvent(f);
                a.updateEvent(c.id);
                a.callEvent("onEventCut", [c])
            }
            if (b.ctrlKey && b.keyCode == 86) {
                if (c = a.getEvent(a._buffer_id)) {
                    var j = c.end_date - c.start_date;
                    if (e) {
                        var g = a._lame_clone(c);
                        g.id = a.uid();
                        g.start_date = new Date(i);
                        g.end_date = new Date(g.start_date.valueOf() + j);
                        a.addEvent(g);
                        a.callEvent("onEventPasted", [e, g, c])
                    } else {
                        var d = a._lame_copy({},
                            c);
                        d.start_date = new Date(i);
                        d.end_date = new Date(d.start_date.valueOf() + j);
                        var l = a.callEvent("onBeforeEventChanged", [d, b, !1, a._drag_event]);
                        if (l)c.start_date = new Date(d.start_date), c.end_date = new Date(d.end_date), a.render_view_data(), a.callEvent("onEventPasted", [e, c, d]), e = !0
                    }
                }
                return!0
            }
        }
    })
})();
