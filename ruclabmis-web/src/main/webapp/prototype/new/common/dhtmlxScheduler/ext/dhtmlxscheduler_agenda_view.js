/*
 This software is allowed to use under GPL or you need to obtain Commercial or Enterise License
 to use it in non-GPL project. Please contact sales@dhtmlx.com for details
 */
scheduler.date.add_agenda = function (a) {
    return scheduler.date.add(a, 1, "year")
};
scheduler.templates.agenda_time = function (a, d, c) {
    return c._timed ? this.day_date(c.start_date, c.end_date, c) + " " + this.event_date(a) : scheduler.templates.day_date(a) + " &ndash; " + scheduler.templates.day_date(d)
};
scheduler.templates.agenda_text = function (a, d, c) {
    return c.text
};
scheduler.templates.agenda_date = function () {
    return""
};
scheduler.date.agenda_start = function () {
    return scheduler.date.date_part(new Date)
};
scheduler.attachEvent("onTemplatesReady", function () {
    function a(c) {
        if (c) {
            var a = scheduler.locale.labels;
            scheduler._els.dhx_cal_header[0].innerHTML = "<div class='dhx_agenda_line'><div>" + a.date + "</div><span style='padding-left:25px'>" + a.description + "</span></div>";
            scheduler._table_view = !0;
            scheduler.set_sizes()
        }
    }

    function d() {
        var c = scheduler._date, a = scheduler.get_visible_events();
        a.sort(function (b, a) {
            return b.start_date > a.start_date ? 1 : -1
        });
        for (var d = "<div class='dhx_agenda_area'>", e = 0; e < a.length; e++) {
            var b =
                a[e], g = b.color ? "background:" + b.color + ";" : "", h = b.textColor ? "color:" + b.textColor + ";" : "", i = scheduler.templates.event_class(b.start_date, b.end_date, b);
            d += "<div class='dhx_agenda_line" + (i ? " " + i : "") + "' event_id='" + b.id + "' style='" + h + "" + g + "" + (b._text_style || "") + "'><div class='dhx_agenda_event_time'>" + scheduler.templates.agenda_time(b.start_date, b.end_date, b) + "</div>";
            d += "<div class='dhx_event_icon icon_details'>&nbsp</div>";
            d += "<span>" + scheduler.templates.agenda_text(b.start_date, b.end_date, b) + "</span></div>"
        }
        d +=
            "<div class='dhx_v_border'></div></div>";
        scheduler._els.dhx_cal_data[0].innerHTML = d;
        scheduler._els.dhx_cal_data[0].childNodes[0].scrollTop = scheduler._agendaScrollTop || 0;
        var f = scheduler._els.dhx_cal_data[0].childNodes[0], k = f.childNodes[f.childNodes.length - 1];
        k.style.height = f.offsetHeight < scheduler._els.dhx_cal_data[0].offsetHeight ? "100%" : f.offsetHeight + "px";
        var j = scheduler._els.dhx_cal_data[0].firstChild.childNodes;
        scheduler._els.dhx_cal_date[0].innerHTML = scheduler.templates.agenda_date(scheduler._min_date,
            scheduler._max_date, scheduler._mode);
        scheduler._rendered = [];
        for (e = 0; e < j.length - 1; e++)scheduler._rendered[e] = j[e]
    }

    var c = scheduler.dblclick_dhx_cal_data;
    scheduler.dblclick_dhx_cal_data = function () {
        if (this._mode == "agenda")!this.config.readonly && this.config.dblclick_create && this.addEventNow(); else if (c)return c.apply(this, arguments)
    };
    scheduler.attachEvent("onSchedulerResize", function () {
        return this._mode == "agenda" ? (this.agenda_view(!0), !1) : !0
    });
    var g = scheduler.render_data;
    scheduler.render_data = function (a) {
        if (this._mode ==
            "agenda")d(); else return g.apply(this, arguments)
    };
    var h = scheduler.render_view_data;
    scheduler.render_view_data = function () {
        if (this._mode == "agenda")scheduler._agendaScrollTop = scheduler._els.dhx_cal_data[0].childNodes[0].scrollTop, scheduler._els.dhx_cal_data[0].childNodes[0].scrollTop = 0;
        return h.apply(this, arguments)
    };
    scheduler.agenda_view = function (c) {
        scheduler._min_date = scheduler.config.agenda_start || scheduler.date.agenda_start(scheduler._date);
        scheduler._max_date = scheduler.config.agenda_end || scheduler.date.add_agenda(scheduler._min_date,
            1);
        scheduler._table_view = !0;
        a(c);
        c && d()
    }
});
