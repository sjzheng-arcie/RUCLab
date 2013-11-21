/*
 This software is allowed to use under GPL or you need to obtain Commercial or Enterise License
 to use it in non-GPL project. Please contact sales@dhtmlx.com for details
 */
scheduler.config.limit_start = null;
scheduler.config.limit_end = null;
scheduler.config.limit_view = !1;
scheduler.config.check_limits = !0;
scheduler.config.mark_now = !0;
scheduler.config.display_marked_timespans = !0;
(function () {
    var w = null, s = "dhx_time_block", F = function (b, a, c) {
        a instanceof Date && c instanceof Date ? (b.start_date = a, b.end_date = c) : (b.days = a, b.zones = c);
        return b
    }, E = function (b, a, c) {
        var d = typeof b == "object" ? b : {days: b};
        d.type = s;
        d.css = "";
        if (a) {
            if (c)d.sections = c;
            d = F(d, b, a)
        }
        return d
    };
    scheduler.blockTime = function (b, a, c) {
        var d = E(b, a, c);
        return scheduler.addMarkedTimespan(d)
    };
    scheduler.unblockTime = function (b, a, c) {
        var a = a || "fullday", d = E(b, a, c);
        return scheduler.deleteMarkedTimespan(d)
    };
    scheduler.attachEvent("onBeforeViewChange",
        function (b, a, c, d) {
            d = d || a;
            c = c || b;
            return scheduler.config.limit_view && (d.valueOf() > scheduler.config.limit_end.valueOf() || this.date.add(d, 1, c) <= scheduler.config.limit_start.valueOf()) ? (setTimeout(function () {
                scheduler.setCurrentView(scheduler._date, c)
            }, 1), !1) : !0
        });
    var A = function (b, a, c) {
        var d = c[a] && c[a][s] ? c[a][s] : c[b] && c[b][s] ? c[b][s] : [];
        return d
    }, t = function (b) {
        if (!b)return!0;
        if (!scheduler.config.check_limits)return!0;
        for (var a = scheduler, c = a._mode, d = scheduler._marked_timespans, e = a.config, g = [], g = b.rec_type ?
            scheduler.getRecDates(b) : [b], h = !0, i = 0; i < g.length; i++) {
            var f = g[i];
            f._timed = scheduler.is_one_day_event(f);
            if (h = e.limit_start && e.limit_end ? f.start_date.valueOf() >= e.limit_start.valueOf() && f.end_date.valueOf() <= e.limit_end.valueOf() : !0)for (var j = new Date(f.start_date.valueOf()), o = scheduler.date.add(j, 1, "day"); j < f.end_date; j = scheduler.date.date_part(o), o = a.date.add(j, 1, "day")) {
                var n = +scheduler.date.date_part(new Date(j)), p = j.getDay(), k = [];
                if (a._props && a._props[c]) {
                    var l = a._props[c], q = d[c];
                    if (q && q[f[l.map_to]])for (var r =
                        q[f[l.map_to]], z = A(p, n, r), m = 0; m < z.length; m++)k = scheduler._add_timespan_zones(k, z[m].zones)
                }
                if (a.matrix && a.matrix[c]) {
                    var s = a.matrix[c], t = d[c];
                    if (t && t[f[s.y_property]])for (var w = t[f[s.y_property]], B = A(p, n, w), m = 0; m < B.length; m++)k = scheduler._add_timespan_zones(k, B[m].zones)
                }
                for (var D = d.global, C = A(p, n, D), m = 0; m < C.length; m++)k = scheduler._add_timespan_zones(k, C[m].zones);
                if (k)for (m = 0; m < k.length; m += 2) {
                    var x = scheduler._get_zone_minutes(j), v = f.end_date > o || f.end_date.getDate() != j.getDate() ? 1440 : scheduler._get_zone_minutes(f.end_date),
                        y = k[m], u = k[m + 1];
                    if (y < v && u > x) {
                        if (x <= u && x >= y) {
                            if (u == 1440 || v < u) {
                                h = !1;
                                break
                            }
                            if (f._timed && a._drag_id && a._drag_mode == "new-size")f.start_date.setHours(0), f.start_date.setMinutes(u); else {
                                h = !1;
                                break
                            }
                        }
                        if (v >= y && v < u || x < y && v > u)if (f._timed && a._drag_id && a._drag_mode == "new-size")f.end_date.setHours(0), f.end_date.setMinutes(y); else {
                            h = !1;
                            break
                        }
                    }
                }
            }
            if (!h)a._drag_id = null, a._drag_mode = null, h = a.checkEvent("onLimitViolation") ? a.callEvent("onLimitViolation", [f.id, f]) : h
        }
        return h
    };
    scheduler.attachEvent("onMouseDown", function (b) {
        return!(b =
            s)
    });
    scheduler.attachEvent("onBeforeDrag", function (b) {
        return!b ? !0 : t(scheduler.getEvent(b))
    });
    scheduler.attachEvent("onClick", function (b) {
        return t(scheduler.getEvent(b))
    });
    scheduler.attachEvent("onBeforeLightbox", function (b) {
        var a = scheduler.getEvent(b);
        w = [a.start_date, a.end_date];
        return t(a)
    });
    scheduler.attachEvent("onEventSave", function (b, a) {
        if (a.rec_type) {
            var c = scheduler._lame_clone(a);
            scheduler._roll_back_dates(c)
        }
        return t(a)
    });
    scheduler.attachEvent("onEventAdded", function (b) {
        if (!b)return!0;
        var a =
            scheduler.getEvent(b);
        if (!t(a) && scheduler.config.limit_start && scheduler.config.limit_end) {
            if (a.start_date < scheduler.config.limit_start)a.start_date = new Date(scheduler.config.limit_start);
            if (a.start_date.valueOf() >= scheduler.config.limit_end.valueOf())a.start_date = this.date.add(scheduler.config.limit_end, -1, "day");
            if (a.end_date < scheduler.config.limit_start)a.end_date = new Date(scheduler.config.limit_start);
            if (a.end_date.valueOf() >= scheduler.config.limit_end.valueOf())a.end_date = this.date.add(scheduler.config.limit_end,
                -1, "day");
            if (a.start_date.valueOf() >= a.end_date.valueOf())a.end_date = this.date.add(a.start_date, this.config.event_duration || this.config.time_step, "minute");
            a._timed = this.is_one_day_event(a)
        }
        return!0
    });
    scheduler.attachEvent("onEventChanged", function (b) {
        if (!b)return!0;
        var a = scheduler.getEvent(b);
        if (!t(a)) {
            if (!w)return!1;
            a.start_date = w[0];
            a.end_date = w[1];
            a._timed = this.is_one_day_event(a)
        }
        return!0
    });
    scheduler.attachEvent("onBeforeEventChanged", function (b) {
        return t(b)
    });
    scheduler.attachEvent("onBeforeEventCreated",
        function (b) {
            var a = scheduler.getActionData(b).date, c = {_timed: !0, start_date: a, end_date: scheduler.date.add(a, scheduler.config.time_step, "minute")};
            return t(c)
        });
    scheduler.attachEvent("onViewChange", function () {
        scheduler.markNow()
    });
    scheduler.attachEvent("onSchedulerResize", function () {
        window.setTimeout(function () {
            scheduler.markNow()
        }, 1);
        return!0
    });
    scheduler.attachEvent("onTemplatesReady", function () {
        scheduler._mark_now_timer = window.setInterval(function () {
            scheduler.markNow()
        }, 6E4)
    });
    scheduler.markNow = function (b) {
        var a =
            "dhx_now_time";
        this._els[a] || (this._els[a] = []);
        var c = scheduler.config.now_date || new Date, d = this.config;
        scheduler._remove_mark_now();
        if (!b && d.mark_now && c < this._max_date && c > this._min_date && c.getHours() >= d.first_hour && c.getHours() < d.last_hour) {
            var e = this.locate_holder_day(c);
            this._els[a] = scheduler._append_mark_now(e, c)
        }
    };
    scheduler._append_mark_now = function (b, a) {
        var c = "dhx_now_time", d = scheduler._get_zone_minutes(a), e = {zones: [d, d + 1], css: c, type: c};
        if (this._table_view) {
            if (this._mode == "month")return e.days = +scheduler.date.date_part(a), scheduler._render_marked_timespan(e, null, null)
        } else if (this._props && this._props[this._mode]) {
            for (var g = this._els.dhx_cal_data[0].childNodes, h = [], i = 0; i < g.length - 1; i++) {
                var f = b + i;
                e.days = f;
                var j = scheduler._render_marked_timespan(e, null, f)[0];
                h.push(j)
            }
            return h
        } else return e.days = b, scheduler._render_marked_timespan(e, null, b)
    };
    scheduler._remove_mark_now = function () {
        for (var b = "dhx_now_time", a = this._els[b], c = 0; c < a.length; c++) {
            var d = a[c], e = d.parentNode;
            e && e.removeChild(d)
        }
        this._els[b] =
            []
    };
    scheduler._marked_timespans = {global: {}};
    scheduler._get_zone_minutes = function (b) {
        return b.getHours() * 60 + b.getMinutes()
    };
    scheduler._prepare_timespan_options = function (b) {
        var a = [], c = [];
        if (b.days == "fullweek")b.days = [0, 1, 2, 3, 4, 5, 6];
        if (b.days instanceof Array) {
            for (var d = b.days.slice(), e = 0; e < d.length; e++) {
                var g = scheduler._lame_clone(b);
                g.days = d[e];
                a.push.apply(a, scheduler._prepare_timespan_options(g))
            }
            return a
        }
        if (!b || !(b.start_date && b.end_date && b.end_date > b.start_date || b.days !== void 0 && b.zones))return a;
        var h = 0, i = 1440;
        if (b.zones == "fullday")b.zones = [h, i];
        if (b.zones && b.invert_zones)b.zones = scheduler.invertZones(b.zones);
        b.id = scheduler.uid();
        b.css = b.css || "";
        b.type = b.type || "default";
        var f = b.sections;
        if (f)for (var j in f) {
            if (f.hasOwnProperty(j)) {
                var o = f[j];
                o instanceof Array || (o = [o]);
                for (e = 0; e < o.length; e++) {
                    var n = scheduler._lame_copy({}, b);
                    n.sections = {};
                    n.sections[j] = o[e];
                    c.push(n)
                }
            }
        } else c.push(b);
        for (var p = 0; p < c.length; p++) {
            var k = c[p], l = k.start_date, q = k.end_date;
            if (l && q)for (var r = scheduler.date.date_part(new Date(l)),
                                z = scheduler.date.add(r, 1, "day"); r < q;) {
                n = scheduler._lame_copy({}, k);
                delete n.start_date;
                delete n.end_date;
                n.days = r.valueOf();
                var m = l > r ? scheduler._get_zone_minutes(l) : h, s = q > z || q.getDate() != r.getDate() ? i : scheduler._get_zone_minutes(q);
                n.zones = [m, s];
                a.push(n);
                r = z;
                z = scheduler.date.add(z, 1, "day")
            } else {
                if (k.days instanceof Date)k.days = scheduler.date.date_part(k.days).valueOf();
                k.zones = b.zones.slice();
                a.push(k)
            }
        }
        return a
    };
    scheduler._get_dates_by_index = function (b, a, c) {
        for (var d = [], a = a || scheduler._min_date,
                 c = c || scheduler._max_date, e = a.getDay(), g = b - e >= 0 ? b - e : 7 - a.getDay() + b, h = scheduler.date.add(a, g, "day"); h < c; h = scheduler.date.add(h, 1, "week"))d.push(h);
        return d
    };
    scheduler._get_css_classes_by_config = function (b) {
        var a = [];
        b.type == s && (a.push(s), b.css && a.push(s + "_reset"));
        a.push("dhx_marked_timespan", b.css);
        return a.join(" ")
    };
    scheduler._get_block_by_config = function (b) {
        var a = document.createElement("DIV");
        if (b.html)typeof b.html == "string" ? a.innerHTML = b.html : a.appendChild(b.html);
        return a
    };
    scheduler._render_marked_timespan =
        function (b, a, c) {
            var d = [], e = scheduler.config, g = this._min_date, h = this._max_date, i = !1;
            if (!e.display_marked_timespans)return d;
            if (!c && c !== 0) {
                if (b.days < 7)c = b.days; else {
                    var f = new Date(b.days), i = +f;
                    if (!(+h >= +f && +g <= +f))return d;
                    c = f.getDay()
                }
                var j = g.getDay();
                j > c ? c = 7 - (j - c) : c -= j
            }
            var o = b.zones, n = scheduler._get_css_classes_by_config(b);
            if (scheduler._table_view && scheduler._mode == "month") {
                var p = [], k = [];
                if (a)p.push(a), k.push(c); else for (var k = i ? [i] : scheduler._get_dates_by_index(c), l = 0; l < k.length; l++)p.push(this._scales[k[l]]);
                for (l = 0; l < p.length; l++)for (var a = p[l], c = k[l], q = 0; q < o.length; q += 2) {
                    var r = o[l], s = o[l + 1];
                    if (s <= r)return[];
                    var m = scheduler._get_block_by_config(b);
                    m.className = n;
                    var t = a.offsetHeight - 1, w = a.offsetWidth - 1, A = Math.floor((this._correct_shift(c, 1) - g.valueOf()) / (864E5 * this._cols.length)), B = this.locate_holder_day(c, !1) % this._cols.length, D = this._colsS[B], C = this._colsS.heights[A] + (this._colsS.height ? this.xy.month_scale_height + 2 : 2) - 1;
                    m.style.top = C + "px";
                    m.style.lineHeight = m.style.height = t + "px";
                    m.style.left = D + Math.round(r /
                        1440 * w) + "px";
                    m.style.width = Math.round((s - r) / 1440 * w) + "px";
                    a.appendChild(m);
                    d.push(m)
                }
            } else {
                var x = c;
                if (this._props && this._props[this._mode] && b.sections && b.sections[this._mode]) {
                    var v = this._props[this._mode], x = v.order[b.sections[this._mode]];
                    v.size && x > v.position + v.size && (x = 0)
                }
                a = a ? a : scheduler.locate_holder(x);
                for (l = 0; l < o.length; l += 2) {
                    r = Math.max(o[l], e.first_hour * 60);
                    s = Math.min(o[l + 1], e.last_hour * 60);
                    if (s <= r)if (l + 2 < o.length)continue; else return[];
                    m = scheduler._get_block_by_config(b);
                    m.className = n;
                    var y =
                        this.config.hour_size_px * 24 + 1, u = 36E5;
                    m.style.top = Math.round((r * 6E4 - this.config.first_hour * u) * this.config.hour_size_px / u) % y + "px";
                    m.style.lineHeight = m.style.height = Math.max(Math.round((s - r) * 6E4 * this.config.hour_size_px / u) % y, 1) + "px";
                    a.appendChild(m);
                    d.push(m)
                }
            }
            return d
        };
    scheduler.markTimespan = function (b) {
        var a = scheduler._prepare_timespan_options(b);
        if (a.length) {
            for (var c = [], d = 0; d < a.length; d++) {
                var e = a[d], g = scheduler._render_marked_timespan(e, null, null);
                g.length && c.push.apply(c, g)
            }
            return c
        }
    };
    scheduler.unmarkTimespan =
        function (b) {
            if (b)for (var a = 0; a < b.length; a++) {
                var c = b[a];
                c.parentNode && c.parentNode.removeChild(c)
            }
        };
    scheduler._marked_timespans_ids = {};
    scheduler.addMarkedTimespan = function (b) {
        var a = scheduler._prepare_timespan_options(b), c = "global";
        if (a.length) {
            var d = a[0].id, e = scheduler._marked_timespans, g = scheduler._marked_timespans_ids;
            g[d] || (g[d] = []);
            for (var h = 0; h < a.length; h++) {
                var i = a[h], f = i.days, j = i.zones, o = i.css, n = i.sections, p = i.type;
                i.id = d;
                if (n)for (var k in n) {
                    if (n.hasOwnProperty(k)) {
                        e[k] || (e[k] = {});
                        var l = n[k],
                            q = e[k];
                        q[l] || (q[l] = {});
                        q[l][f] || (q[l][f] = {});
                        q[l][f][p] || (q[l][f][p] = []);
                        var r = q[l][f][p];
                        i._array = r;
                        r.push(i);
                        g[d].push(i)
                    }
                } else e[c][f] || (e[c][f] = {}), e[c][f][p] || (e[c][f][p] = []), r = e[c][f][p], i._array = r, r.push(i), g[d].push(i)
            }
            return d
        }
    };
    scheduler._add_timespan_zones = function (b, a) {
        var c = b.slice(), a = a.slice();
        if (!c.length)return a;
        for (var d = 0; d < c.length; d += 2)for (var e = c[d], g = c[d + 1], h = d + 2 == c.length, i = 0; i < a.length; i += 2) {
            var f = a[i], j = a[i + 1];
            if (j > g && f <= g || f < e && j >= e)c[d] = Math.min(e, f), c[d + 1] = Math.max(g,
                j), d -= 2; else {
                if (!h)continue;
                var o = e > f ? 0 : 2;
                c.splice(d + o, 0, f, j)
            }
            a.splice(i--, 2);
            break
        }
        return c
    };
    scheduler._subtract_timespan_zones = function (b, a) {
        for (var c = b.slice(), d = 0; d < c.length; d += 2)for (var e = c[d], g = c[d + 1], h = 0; h < a.length; h += 2) {
            var i = a[h], f = a[h + 1];
            if (f > e && i < g) {
                var j = !1;
                e >= i && g <= f && c.splice(d, 2);
                e < i && (c.splice(d, 2, e, i), j = !0);
                g > f && c.splice(j ? d + 2 : d, j ? 0 : 2, f, g);
                d -= 2;
                break
            }
        }
        return c
    };
    scheduler.invertZones = function (b) {
        return scheduler._subtract_timespan_zones([0, 1440], b.slice())
    };
    scheduler._delete_marked_timespan_by_id =
        function (b) {
            var a = scheduler._marked_timespans_ids[b];
            if (a)for (var c = 0; c < a.length; c++)for (var d = a[c], e = d._array, g = 0; g < e.length; g++)if (e[g] == d) {
                e.splice(g, 1);
                break
            }
        };
    scheduler._delete_marked_timespan_by_config = function (b) {
        var a = scheduler._marked_timespans, c = b.sections, d = b.days, e = b.type || "default", g = [];
        if (c)for (var h in c) {
            if (c.hasOwnProperty(h) && a[h]) {
                var i = c[h];
                a[h][i] && a[h][i][d] && a[h][i][d][e] && (g = a[h][i][d][e])
            }
        } else a.global[d] && a.global[d][e] && (g = a.global[d][e]);
        for (var f = 0; f < g.length; f++) {
            var j =
                g[f], o = scheduler._subtract_timespan_zones(j.zones, b.zones);
            if (o.length)j.zones = o; else {
                g.splice(f, 1);
                f--;
                for (var n = scheduler._marked_timespans_ids[j.id], p = 0; p < n.length; p++)if (n[p] == j) {
                    n.splice(p, 1);
                    break
                }
            }
        }
    };
    scheduler.deleteMarkedTimespan = function (b) {
        if (!arguments.length)scheduler._marked_timespans = {global: {}}, scheduler._marked_timespans_ids = {};
        if (typeof b != "object")scheduler._delete_marked_timespan_by_id(b); else for (var a = scheduler._prepare_timespan_options(b), c = 0; c < a.length; c++) {
            var d = a[c];
            scheduler._delete_marked_timespan_by_config(a[c])
        }
    };
    scheduler._get_types_to_render = function (b, a) {
        var c = b ? b : {}, d;
        for (d in a || {})a.hasOwnProperty(d) && (c[d] = a[d]);
        return c
    };
    scheduler._get_configs_to_render = function (b) {
        var a = [], c;
        for (c in b)b.hasOwnProperty(c) && a.push.apply(a, b[c]);
        return a
    };
    scheduler.attachEvent("onScaleAdd", function (b, a) {
        if (!(scheduler._table_view && scheduler._mode != "month")) {
            var c = a.getDay(), d = a.valueOf(), e = this._mode, g = scheduler._marked_timespans, h = [];
            if (this._props && this._props[e]) {
                var i = this._props[e], f = i.options, j = scheduler._get_unit_index(i,
                    a), o = f[j], a = scheduler.date.date_part(new Date(this._date)), c = a.getDay(), d = a.valueOf();
                if (g[e] && g[e][o.key]) {
                    var n = g[e][o.key], p = scheduler._get_types_to_render(n[c], n[d]);
                    h.push.apply(h, scheduler._get_configs_to_render(p))
                }
            }
            var k = g.global, l = k[d] || k[c];
            h.push.apply(h, scheduler._get_configs_to_render(l));
            for (var q = 0; q < h.length; q++)scheduler._render_marked_timespan(h[q], b, a)
        }
    })
})();
