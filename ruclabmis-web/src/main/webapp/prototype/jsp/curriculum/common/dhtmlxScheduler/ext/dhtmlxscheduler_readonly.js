/*
 This software is allowed to use under GPL or you need to obtain Commercial or Enterise License
 to use it in non-GPL project. Please contact sales@dhtmlx.com for details
 */
scheduler.attachEvent("onTemplatesReady", function () {
    function c(e, b, a, h) {
        for (var i = b.getElementsByTagName(e), g = a.getElementsByTagName(e), f = g.length - 1; f >= 0; f--)if (a = g[f], h) {
            var d = document.createElement("SPAN");
            d.className = "dhx_text_disabled";
            d.innerHTML = h(i[f]);
            a.parentNode.insertBefore(d, a);
            a.parentNode.removeChild(a)
        } else a.disabled = !0
    }

    var r = scheduler.config.lightbox.sections, k = null, n = scheduler.config.buttons_left.slice(), o = scheduler.config.buttons_right.slice();
    scheduler.attachEvent("onBeforeLightbox",
        function (e) {
            if (this.config.readonly_form || this.getEvent(e).readonly) {
                this.config.readonly_active = !0;
                for (var b = 0; b < this.config.lightbox.sections.length; b++)this.config.lightbox.sections[b].focus = !1
            } else this.config.readonly_active = !1, scheduler.config.buttons_left = n.slice(), scheduler.config.buttons_right = o.slice();
            var a = this.config.lightbox.sections;
            if (this.config.readonly_active) {
                for (var h = !1, b = 0; b < a.length; b++)if (a[b].type == "recurring") {
                    k = a[b];
                    this.config.readonly_active && a.splice(b, 1);
                    break
                }
                !h && !this.config.readonly_active && k && a.splice(a.length - 2, 0, k);
                for (var i = ["dhx_delete_btn", "dhx_save_btn"], g = [scheduler.config.buttons_left, scheduler.config.buttons_right], b = 0; b < i.length; b++)for (var f = i[b], d = 0; d < g.length; d++) {
                    for (var c = g[d], l = -1, j = 0; j < c.length; j++)if (c[j] == f) {
                        l = j;
                        break
                    }
                    l != -1 && c.splice(l, 1)
                }
            }
            this.resetLightbox();
            return!0
        });
    var p = scheduler._fill_lightbox;
    scheduler._fill_lightbox = function () {
        var e = p.apply(this, arguments);
        if (this.config.readonly_active) {
            var b = this.getLightbox(), a = this._lightbox_r =
                b.cloneNode(!0);
            a.id = scheduler.uid();
            c("textarea", b, a, function (a) {
                return a.value
            });
            c("input", b, a, !1);
            c("select", b, a, function (a) {
                return a.options[Math.max(a.selectedIndex || 0, 0)].text
            });
            b.parentNode.insertBefore(a, b);
            m.call(this, a);
            scheduler._lightbox && scheduler._lightbox.parentNode.removeChild(scheduler._lightbox);
            this._lightbox = a;
            this.setLightboxSize();
            a.onclick = function (a) {
                var b = a ? a.target : event.srcElement;
                if (!b.className)b = b.previousSibling;
                if (b && b.className)switch (b.className) {
                    case "dhx_cancel_btn":
                        scheduler.callEvent("onEventCancel",
                            [scheduler._lightbox_id]), scheduler._edit_stop_event(scheduler.getEvent(scheduler._lightbox_id), !1), scheduler.hide_lightbox()
                }
            }
        }
        return e
    };
    var m = scheduler.showCover;
    scheduler.showCover = function () {
        this.config.readonly_active || m.apply(this, arguments)
    };
    var q = scheduler.hide_lightbox;
    scheduler.hide_lightbox = function () {
        if (this._lightbox_r)this._lightbox_r.parentNode.removeChild(this._lightbox_r), this._lightbox_r = this._lightbox = null;
        return q.apply(this, arguments)
    }
});
