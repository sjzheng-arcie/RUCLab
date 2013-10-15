/*
 This software is allowed to use under GPL or you need to obtain Commercial or Enterise License
 to use it in non-GPL project. Please contact sales@dhtmlx.com for details
 */
(function () {
    scheduler.config.all_timed = "short";
    scheduler.config.update_render = !0;
    var i = function (a) {
        return!((a.end_date - a.start_date) / 36E5 >= 24)
    }, j = scheduler._pre_render_events_line;
    scheduler._pre_render_events_line = function (a, f) {
        if (!this.config.all_timed)return j.call(this, a, f);
        for (var c = 0; c < a.length; c++) {
            var d = a[c];
            if (!d._timed)if (this.config.all_timed == "short" && !i(d))a.splice(c--, 1); else {
                var b = this._lame_copy({}, d);
                b.start_date = new Date(b.start_date);
                var h = scheduler.date.add(d.start_date, 1, "day"),
                    h = scheduler.date.date_part(h);
                if (d.end_date < h)b.end_date = new Date(d.end_date); else if (b.end_date = h, this.config.last_hour != 24)b.end_date = scheduler.date.date_part(new Date(b.start_date)), b.end_date.setHours(this.config.last_hour);
                var g = !1;
                b.start_date < this._max_date && b.end_date > this._min_date && b.start_date < b.end_date && (a[c] = b, g = !0);
                b.start_date > b.end_date && a.splice(c--, 1);
                var e = this._lame_copy({}, d);
                e.end_date = new Date(e.end_date);
                e.start_date = e.start_date < this._min_date ? new Date(this._min_date) : this.date.add(d.start_date,
                    1, "day");
                e.start_date.setHours(this.config.first_hour);
                e.start_date.setMinutes(0);
                e.start_date < this._max_date && e.start_date < e.end_date && (g ? a.splice(c + 1, 0, e) : a[c--] = e)
            }
        }
        var k = this._drag_mode == "move" ? !1 : f;
        return j.call(this, a, k)
    };
    var g = scheduler.get_visible_events;
    scheduler.get_visible_events = function (a) {
        return!this.config.all_timed ? g.call(this, a) : g.call(this, !1)
    };
    scheduler.attachEvent("onBeforeViewChange", function (a, f, c) {
        scheduler._allow_dnd = c == "day" || c == "week";
        return!0
    });
    scheduler.render_view_data =
        function (a, f) {
            if (!a) {
                if (this._not_render) {
                    this._render_wait = !0;
                    return
                }
                this._render_wait = !1;
                this.clear_view();
                a = this.get_visible_events(!(this._table_view || this.config.multi_day))
            }
            if (this.config.multi_day && !this._table_view) {
                for (var c = [], d = [], b = 0; b < a.length; b++)a[b]._timed || this.config.all_timed === !0 || this.config.all_timed == "short" && i(a[b]) ? c.push(a[b]) : d.push(a[b]);
                this._rendered_location = this._els.dhx_cal_data[0];
                this._table_view = !1;
                this.render_data(c, f);
                this._rendered_location = this._els.dhx_multi_day[0];
                this._table_view = !0;
                this.render_data(d, f);
                this._table_view = !1
            } else this._rendered_location = this._els.dhx_cal_data[0], this.render_data(a, f)
        }
})();
