/*
 This software is allowed to use under GPL or you need to obtain Commercial or Enterise License
 to use it in non-GPL project. Please contact sales@dhtmlx.com for details
 */
scheduler.load = function (a, c, b) {
    if (typeof c == "string")var f = this._process = c, c = b;
    this._load_url = a;
    this._after_call = c;
    a.$proxy ? a.load(this, typeof f == "string" ? f : null) : this._load(a, this._date)
};
scheduler._dp_init_backup = scheduler._dp_init;
scheduler._dp_init = function (a) {
    a._sendData = function (c, b) {
        if (c) {
            if (!this.callEvent("onBeforeDataSending", b ? [b, this.getState(b), c] : [null, null, c]))return!1;
            b && (this._in_progress[b] = (new Date).valueOf());
            if (this.serverProcessor.$proxy) {
                var a = this._tMode != "POST" ? "get" : "post", d = [], e;
                for (e in c)d.push({id: e, data: c[e], operation: this.getState(e)});
                this.serverProcessor._send(d, a, this)
            } else {
                var h = new dtmlXMLLoaderObject(this.afterUpdate, this, !0), g = this.serverProcessor + (this._user ? getUrlSymbol(this.serverProcessor) +
                    ["dhx_user=" + this._user, "dhx_version=" + this.obj.getUserData(0, "version")].join("&") : "");
                this._tMode != "POST" ? h.loadXML(g + (g.indexOf("?") != -1 ? "&" : "?") + this.serialize(c, b)) : h.loadXML(g, !0, this.serialize(c, b));
                this._waitMode++
            }
        }
    };
    a._updatesToParams = function (c) {
        for (var b = {}, a = 0; a < c.length; a++)b[c[a].id] = c[a].data;
        return this.serialize(b)
    };
    a._processResult = function (a, b, f) {
        if (f.status != 200)for (var d in this._in_progress) {
            var e = this.getState(d);
            this.afterUpdateCallback(d, d, e, null)
        } else b = new dtmlXMLLoaderObject(function () {
            },
            this, !0), b.loadXMLString(a), b.xmlDoc = f, this.afterUpdate(this, null, null, null, b)
    };
    this._dp_init_backup(a)
};
if (window.dataProcessor)dataProcessor.prototype.init = function (a) {
    this.init_original(a);
    a._dataprocessor = this;
    this.setTransactionMode("POST", !0);
    this.serverProcessor.$proxy || (this.serverProcessor += (this.serverProcessor.indexOf("?") != -1 ? "&" : "?") + "editing=true")
};
