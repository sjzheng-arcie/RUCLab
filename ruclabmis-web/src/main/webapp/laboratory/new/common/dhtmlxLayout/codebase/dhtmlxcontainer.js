//v.3.5 build 120822

/*
 Copyright DHTMLX LTD. http://www.dhtmlx.com
 You allowed to use this component or parts of it under GPL terms
 To use it on other terms or get Professional edition of the component please contact us at sales@dhtmlx.com
 */
function dhtmlXContainer(i) {
    var g = this;
    this.obj = i;
    i = null;
    this.obj._padding = !0;
    this.dhxcont = null;
    this.st = document.createElement("DIV");
    this.st.style.position = "absolute";
    this.st.style.left = "-200px";
    this.st.style.top = "0px";
    this.st.style.width = "100px";
    this.st.style.height = "1px";
    this.st.style.visibility = "hidden";
    this.st.style.overflow = "hidden";
    document.body.insertBefore(this.st, document.body.childNodes[0]);
    this.obj._getSt = function () {
        return g.st
    };
    this.obj.dv = "def";
    this.obj.av = this.obj.dv;
    this.obj.cv = this.obj.av;
    this.obj.vs = {};
    this.obj.vs[this.obj.av] = {};
    this.obj.view = function (a) {
        if (!this.vs[a]) {
            this.vs[a] = {};
            this.vs[a].dhxcont = this.vs[this.dv].dhxcont;
            var b = document.createElement("DIV");
            b.style.position = "relative";
            b.style.left = "0px";
            b.style.width = "200px";
            b.style.height = "200px";
            b.style.overflow = "hidden";
            b.style.visibility = "";
            g.st.appendChild(b);
            this.vs[a].dhxcont.mainCont[a] = b;
            b = null
        }
        this.avt = this.av;
        this.av = a;
        return this
    };
    this.obj.setActive = function () {
        if (this.vs[this.av])this.cv = this.av, this.vs[this.avt].dhxcont ==
            this.vs[this.avt].dhxcont.mainCont[this.avt].parentNode && (g.st.appendChild(this.vs[this.avt].dhxcont.mainCont[this.avt]), this.vs[this.avt].menu && g.st.appendChild(document.getElementById(this.vs[this.avt].menuId)), this.vs[this.avt].toolbar && g.st.appendChild(document.getElementById(this.vs[this.avt].toolbarId)), this.vs[this.avt].sb && g.st.appendChild(document.getElementById(this.vs[this.avt].sbId))), this.vs[this.av].dhxcont != this.vs[this.av].dhxcont.mainCont[this.av].parentNode && (this.vs[this.av].dhxcont.insertBefore(this.vs[this.av].dhxcont.mainCont[this.av],
            this.vs[this.av].dhxcont.childNodes[this.vs[this.av].dhxcont.childNodes.length - 1]), this.vs[this.av].menu && this.vs[this.av].dhxcont.insertBefore(document.getElementById(this.vs[this.av].menuId), this.vs[this.av].dhxcont.childNodes[0]), this.vs[this.av].toolbar && this.vs[this.av].dhxcont.insertBefore(document.getElementById(this.vs[this.av].toolbarId), this.vs[this.av].dhxcont.childNodes[this.vs[this.av].menu ? 1 : 0]), this.vs[this.av].sb && this.vs[this.av].dhxcont.insertBefore(document.getElementById(this.vs[this.av].sbId),
            this.vs[this.av].dhxcont.childNodes[this.vs[this.av].dhxcont.childNodes.length - 1])), this._doOnResize && this._doOnResize(), this._isWindow && this.updateNestedObjects(), this.avt = null
    };
    this.obj._viewRestore = function () {
        var a = this.av;
        if (this.avt)this.av = this.avt, this.avt = null;
        return a
    };
    this.setContent = function (a) {
        this.obj.vs[this.obj.av].dhxcont = a;
        this.obj._init();
        a = null
    };
    this.obj._init = function () {
        this.vs[this.av].dhxcont.innerHTML = "<div ida='dhxMainCont' style='position: relative; left: 0px; top: 0px; overflow: hidden;'></div><div class='dhxcont_content_blocker' style='display: none;'></div>";
        this.vs[this.av].dhxcont.mainCont = {};
        this.vs[this.av].dhxcont.mainCont[this.av] = this.vs[this.av].dhxcont.childNodes[0]
    };
    this.obj._genStr = function (a) {
        for (var b = "", c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", d = 0; d < a; d++)b += c.charAt(Math.round(Math.random() * (c.length - 1)));
        return b
    };
    this.obj.setMinContentSize = function (a, b) {
        this.vs[this.av]._minDataSizeW = a;
        this.vs[this.av]._minDataSizeH = b
    };
    this.obj._setPadding = function (a, b) {
        typeof a == "object" ? (this._offsetTop = a[0], this._offsetLeft =
            a[1], this._offsetWidth = a[2], this._offsetHeight = a[3], a = null) : (this._offsetLeft = this._offsetTop = a, this._offsetWidth = -a * 2, this._offsetHeight = -a * 2);
        this.vs[this.av].dhxcont.className = "dhxcont_global_content_area " + (b || "")
    };
    this.obj.moveContentTo = function (a) {
        for (var b in this.vs) {
            a.view(b).setActive();
            var c = null;
            this.vs[b].grid && (c = "grid");
            this.vs[b].tree && (c = "tree");
            this.vs[b].tabbar && (c = "tabbar");
            this.vs[b].folders && (c = "folders");
            this.vs[b].layout && (c = "layout");
            c != null && (a.view(b).attachObject(this.vs[b][c +
                "Id"], !1, !0, !1), a.vs[b][c] = this.vs[b][c], a.vs[b][c + "Id"] = this.vs[b][c + "Id"], a.vs[b][c + "Obj"] = this.vs[b][c + "Obj"], this.vs[b][c] = null, this.vs[b][c + "Id"] = null, this.vs[b][c + "Obj"] = null);
            if (this.vs[b]._frame)a.vs[b]._frame = this.vs[b]._frame, this.vs[b]._frame = null;
            if (this.vs[b].menu != null) {
                if (a.cv == a.av)a.vs[a.av].dhxcont.insertBefore(document.getElementById(this.vs[b].menuId), a.vs[a.av].dhxcont.childNodes[0]); else {
                    var d = a._getSt();
                    d.appendChild(document.getElementById(this.vs[b].menuId));
                    d = null
                }
                a.vs[b].menu =
                    this.vs[b].menu;
                a.vs[b].menuId = this.vs[b].menuId;
                a.vs[b].menuHeight = this.vs[b].menuHeight;
                this.vs[b].menu = null;
                this.vs[b].menuId = null;
                this.vs[b].menuHeight = null;
                this.cv == this.av && this._doOnAttachMenu && this._doOnAttachMenu("unload");
                a.cv == a.av && a._doOnAttachMenu && a._doOnAttachMenu("move")
            }
            if (this.vs[b].toolbar != null)a.cv == a.av ? a.vs[a.av].dhxcont.insertBefore(document.getElementById(this.vs[b].toolbarId), a.vs[a.av].dhxcont.childNodes[a.vs[a.av].menu != null ? 1 : 0]) : (d = a._getSt(), d.appendChild(document.getElementById(this.vs[b].toolbarId)),
                d = null), a.vs[b].toolbar = this.vs[b].toolbar, a.vs[b].toolbarId = this.vs[b].toolbarId, a.vs[b].toolbarHeight = this.vs[b].toolbarHeight, this.vs[b].toolbar = null, this.vs[b].toolbarId = null, this.vs[b].toolbarHeight = null, this.cv == this.av && this._doOnAttachToolbar && this._doOnAttachToolbar("unload"), a.cv == a.av && a._doOnAttachToolbar && a._doOnAttachToolbar("move");
            if (this.vs[b].sb != null) {
                if (a.cv == a.av)a.vs[a.av].dhxcont.insertBefore(document.getElementById(this.vs[b].sbId), a.vs[a.av].dhxcont.childNodes[a.vs[a.av].dhxcont.childNodes.length -
                    1]); else return d = a._getSt(), d.appendChild(document.getElementById(this.vs[b].sbId)), d;
                a.vs[b].sb = this.vs[b].sb;
                a.vs[b].sbId = this.vs[b].sbId;
                a.vs[b].sbHeight = this.vs[b].sbHeight;
                this.vs[b].sb = null;
                this.vs[b].sbId = null;
                this.vs[b].sbHeight = null;
                this.cv == this.av && this._doOnAttachStatusBar && this._doOnAttachStatusBar("unload");
                a.cv == a.av && a._doOnAttachStatusBar && a._doOnAttachStatusBar("move")
            }
            for (var e = this.vs[b].dhxcont.mainCont[b], f = a.vs[b].dhxcont.mainCont[b]; e.childNodes.length > 0;)f.appendChild(e.childNodes[0])
        }
        a.view(this.av).setActive();
        a = null
    };
    this.obj.adjustContent = function (a, b, c, d, e) {
        var f = this.vs[this.av].dhxcont, h = f.mainCont[this.av];
        f.style.left = (this._offsetLeft || 0) + "px";
        f.style.top = (this._offsetTop || 0) + b + "px";
        var g = a.clientWidth + (this._offsetWidth || 0);
        if (d !== !0)f.style.width = Math.max(0, g) + "px";
        if (d !== !0 && f.offsetWidth > g)f.style.width = Math.max(0, g * 2 - f.offsetWidth) + "px";
        var k = a.clientHeight + (this._offsetHeight || 0);
        f.style.height = Math.max(0, k - b) + (c != null ? c : 0) + "px";
        if (f.offsetHeight > k - b)f.style.height = Math.max(0, (k - b) * 2 - f.offsetHeight) +
            "px";
        if (e && !isNaN(e))f.style.height = Math.max(0, parseInt(f.style.height) - e) + "px";
        if (this.vs[this.av]._minDataSizeH != null && parseInt(f.style.height) < this.vs[this.av]._minDataSizeH)f.style.height = this.vs[this.av]._minDataSizeH + "px";
        if (this.vs[this.av]._minDataSizeW != null && parseInt(f.style.width) < this.vs[this.av]._minDataSizeW)f.style.width = this.vs[this.av]._minDataSizeW + "px";
        if (d !== !0 && (h.style.width = f.clientWidth + "px", h.offsetWidth > f.clientWidth))h.style.width = Math.max(0, f.clientWidth * 2 - h.offsetWidth) +
            "px";
        var i = this.vs[this.av].menu != null ? !this.vs[this.av].menuHidden ? this.vs[this.av].menuHeight : 0 : 0, j = this.vs[this.av].toolbar != null ? !this.vs[this.av].toolbarHidden ? this.vs[this.av].toolbarHeight : 0 : 0, l = this.vs[this.av].sb != null ? !this.vs[this.av].sbHidden ? this.vs[this.av].sbHeight : 0 : 0;
        h.style.height = f.clientHeight + "px";
        if (h.offsetHeight > f.clientHeight)h.style.height = Math.max(0, f.clientHeight * 2 - h.offsetHeight) + "px";
        h.style.height = Math.max(0, parseInt(h.style.height) - i - j - l) + "px";
        a = f = h = null
    };
    this.obj.coverBlocker =
        function () {
            return this.vs[this.av].dhxcont.childNodes[this.vs[this.av].dhxcont.childNodes.length - 1]
        };
    this.obj.showCoverBlocker = function () {
        var a = this.coverBlocker();
        a.style.display = "";
        a = null
    };
    this.obj.hideCoverBlocker = function () {
        var a = this.coverBlocker();
        a.style.display = "none";
        a = null
    };
    this.obj.updateNestedObjects = function (a) {
        if (this.skin == "dhx_terrace") {
            var b = this.vs[this.av].menu != null || this.vs[this.av].toolbar != null;
            if (this.vs[this.av].grid) {
                var c = b || this._isWindow ? 14 : 0, d = this._isWindow ? 14 : 0, e = this._isWindow ?
                    14 : 0;
                if (a) {
                    if (!this._isWindow)this.vs[this.av].grid.entBox.style.border = "0px solid white", this.vs[this.av].grid.skin_h_correction = -2;
                    this.vs[this.av].grid.dontSetSizes = !0;
                    this.vs[this.av].gridObj.style.position = "absolute"
                }
                this.vs[this.av].gridObj.style.top = c + "px";
                this.vs[this.av].gridObj.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) - c - d + "px";
                this.vs[this.av].gridObj.style.left = e + "px";
                this.vs[this.av].gridObj.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) -
                    e * 2 + "px";
                this.vs[this.av].grid.setSizes()
            }
            if (this.vs[this.av].tree) {
                c = b || this._isWindow ? 14 : 0;
                d = this._isWindow ? 14 : 0;
                e = this._isWindow ? 14 : 0;
                if (a)this.vs[this.av].treeObj.style.position = "absolute";
                this.vs[this.av].treeObj.style.top = c + "px";
                this.vs[this.av].treeObj.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) - c - d + "px";
                this.vs[this.av].treeObj.style.left = e + "px";
                this.vs[this.av].treeObj.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) - e * 2 + "px"
            }
            if (this.vs[this.av].form) {
                c =
                    b || this._isWindow ? 14 : 0;
                d = this._isWindow ? 14 : 0;
                e = this._isWindow ? 14 : 0;
                if (a)this.vs[this.av].formObj.style.position = "absolute";
                this.vs[this.av].formObj.style.top = c + "px";
                this.vs[this.av].formObj.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) - c - d + "px";
                this.vs[this.av].formObj.style.left = e + "px";
                this.vs[this.av].formObj.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) - e * 2 + "px";
                this.vs[this.av].form.setSizes()
            }
            if (this.vs[this.av].layout)a && !this._isWindow && !this._isCell && this.vs[this.av].layout._hideBorders(), c = this._isCell && this._noHeader && !b ? 0 : 14, d = this._isCell && this._noHeader ? 0 : 14, e = this._isCell && this._noHeader ? 0 : 14, this.vs[this.av].layoutObj.style.top = c + "px", this.vs[this.av].layoutObj.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) - c - d + "px", this.vs[this.av].layoutObj.style.left = e + "px", this.vs[this.av].layoutObj.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) - e * 2 + "px", this.vs[this.av].layout.setSizes();
            if (this.vs[this.av].accordion) {
                if (a)this.vs[this.av].accordion._hideBorders = !0;
                c = this._isCell && this._noHeader && !b ? 0 : 14;
                d = this._isCell && this._noHeader ? 0 : 14;
                e = this._isCell && this._noHeader ? 0 : 14;
                this.vs[this.av].accordionObj.style.top = c + "px";
                this.vs[this.av].accordionObj.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) - c - d + "px";
                this.vs[this.av].accordionObj.style.left = e + "px";
                this.vs[this.av].accordionObj.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) -
                    e * 2 + "px";
                this.vs[this.av].accordion.setSizes()
            }
            if (this.vs[this.av].tabbar != null)c = !b && this._isCell && this._noHeader ? 0 : 14, d = this._isCell && this._noHeader ? c : 28, e = this._isCell && this._noHeader ? 0 : 14, this.vs[this.av].tabbarObj.style.top = c + "px", this.vs[this.av].tabbarObj.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) - d + "px", this.vs[this.av].tabbarObj.style.left = e + "px", this.vs[this.av].tabbarObj.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) - e * 2 +
                "px", this.vs[this.av].tabbar.adjustOuterSize();
            if (this.vs[this.av].editor)e = c = 14, this.vs[this.av].editorObj.style.top = c + "px", this.vs[this.av].editorObj.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) - c * 2 + "px", this.vs[this.av].editorObj.style.left = e + "px", this.vs[this.av].editorObj.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) - e * 2 + "px", _isIE || this.vs[this.av].editor._prepareContent(!0), this.vs[this.av].editor.setSizes();
            this.vs[this.av].dockedCell &&
            this.vs[this.av].dockedCell.updateNestedObjects()
        } else {
            this.vs[this.av].grid && this.vs[this.av].grid.setSizes();
            this.vs[this.av].sched && this.vs[this.av].sched.setSizes();
            this.vs[this.av].tabbar && this.vs[this.av].tabbar.adjustOuterSize();
            this.vs[this.av].folders && this.vs[this.av].folders.setSizes();
            this.vs[this.av].editor && (_isIE || this.vs[this.av].editor._prepareContent(!0), this.vs[this.av].editor.setSizes());
            if (this.vs[this.av].layout)(this._isAcc || this._isTabbarCell) && this.skin == "dhx_skyblue" ? (this.vs[this.av].layoutObj.style.width =
                parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) + 2 + "px", this.vs[this.av].layoutObj.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) + 2 + "px") : (this.vs[this.av].layoutObj.style.width = this.vs[this.av].dhxcont.mainCont[this.av].style.width, this.vs[this.av].layoutObj.style.height = this.vs[this.av].dhxcont.mainCont[this.av].style.height), this.vs[this.av].layout.setSizes();
            if (this.vs[this.av].accordion != null)this.skin == "dhx_web" ? (this.vs[this.av].accordionObj.style.width =
                parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) + "px", this.vs[this.av].accordionObj.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) + "px") : (this.vs[this.av].accordionObj.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) + 2 + "px", this.vs[this.av].accordionObj.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) + 2 + "px"), this.vs[this.av].accordion.setSizes();
            this.vs[this.av].dockedCell && this.vs[this.av].dockedCell.updateNestedObjects();
            this.vs[this.av].form && this.vs[this.av].form.setSizes()
        }
    };
    this.obj.attachStatusBar = function () {
        if (!this.vs[this.av].sb) {
            var a = document.createElement("DIV");
            a.className = this._isCell ? "dhxcont_sb_container_layoutcell" : "dhxcont_sb_container";
            a.id = "sbobj_" + this._genStr(12);
            a.innerHTML = "<div class='dhxcont_statusbar'></div>";
            this.cv == this.av ? this.vs[this.av].dhxcont.insertBefore(a, this.vs[this.av].dhxcont.childNodes[this.vs[this.av].dhxcont.childNodes.length - 1]) : g.st.appendChild(a);
            a.setText = function (a) {
                this.childNodes[0].innerHTML =
                    a
            };
            a.getText = function () {
                return this.childNodes[0].innerHTML
            };
            a.onselectstart = function (a) {
                a = a || event;
                return a.returnValue = !1
            };
            this.vs[this.av].sb = a;
            this.vs[this.av].sbHeight = this.skin == "dhx_web" ? 41 : this.skin == "dhx_skyblue" ? 23 : a.offsetHeight;
            this.vs[this.av].sbId = a.id;
            this._doOnAttachStatusBar && this._doOnAttachStatusBar("init");
            this.adjust();
            return this.vs[this._viewRestore()].sb
        }
    };
    this.obj.detachStatusBar = function () {
        if (this.vs[this.av].sb)this.vs[this.av].sb.setText = null, this.vs[this.av].sb.getText =
            null, this.vs[this.av].sb.onselectstart = null, this.vs[this.av].sb.parentNode.removeChild(this.vs[this.av].sb), this.vs[this.av].sb = null, this.vs[this.av].sbHeight = null, this.vs[this.av].sbId = null, this._viewRestore(), this._doOnAttachStatusBar && this._doOnAttachStatusBar("unload")
    };
    this.obj.getFrame = function () {
        return this.getView()._frame
    };
    this.obj.getView = function (a) {
        return this.vs[a || this.av]
    };
    this.obj.attachMenu = function (a) {
        if (!this.vs[this.av].menu) {
            var b = document.createElement("DIV");
            b.style.position =
                "relative";
            b.style.overflow = "hidden";
            b.id = "dhxmenu_" + this._genStr(12);
            this.cv == this.av ? this.vs[this.av].dhxcont.insertBefore(b, this.vs[this.av].dhxcont.childNodes[0]) : g.st.appendChild(b);
            typeof a != "object" ? this.vs[this.av].menu = new dhtmlXMenuObject(b.id, a || this.skin) : (a.parent = b.id, this.vs[this.av].menu = new dhtmlXMenuObject(a));
            this.vs[this.av].menuHeight = this.skin == "dhx_web" ? 29 : b.offsetHeight;
            this.vs[this.av].menuId = b.id;
            this._doOnAttachMenu && this._doOnAttachMenu("init");
            this.adjust();
            return this.vs[this._viewRestore()].menu
        }
    };
    this.obj.detachMenu = function () {
        if (this.vs[this.av].menu) {
            var a = document.getElementById(this.vs[this.av].menuId);
            this.vs[this.av].menu.unload();
            this.vs[this.av].menu = null;
            this.vs[this.av].menuId = null;
            this.vs[this.av].menuHeight = null;
            a && a.parentNode.removeChild(a);
            a = null;
            this._viewRestore();
            this._doOnAttachMenu && this._doOnAttachMenu("unload")
        }
    };
    this.obj.attachToolbar = function (a) {
        if (!this.vs[this.av].toolbar) {
            var b = document.createElement("DIV");
            b.style.position = "relative";
            b.style.overflow = "hidden";
            b.id =
                "dhxtoolbar_" + this._genStr(12);
            this.cv == this.av ? this.vs[this.av].dhxcont.insertBefore(b, this.vs[this.av].dhxcont.childNodes[this.vs[this.av].menu != null ? 1 : 0]) : g.st.appendChild(b);
            typeof a != "object" ? this.vs[this.av].toolbar = new dhtmlXToolbarObject(b.id, a || this.skin) : (a.parent = b.id, this.vs[this.av].toolbar = new dhtmlXToolbarObject(a));
            this.vs[this.av].toolbarHeight = b.offsetHeight;
            this.vs[this.av].toolbarId = b.id;
            this._doOnAttachToolbar && this._doOnAttachToolbar("init");
            this.adjust();
            var c = this;
            this.vs[this.av].toolbar.attachEvent("_onIconSizeChange",
                function () {
                    c.vs[c.av].toolbarHeight = this.cont.offsetHeight;
                    c.vs[c.av].toolbarId = this.cont.id;
                    c._doOnAttachToolbar && c._doOnAttachToolbar("iconSizeChange")
                });
            this.skin != "dhx_terrace" && this.vs[this.av].toolbar.callEvent("_onIconSizeChange", []);
            return this.vs[this._viewRestore()].toolbar
        }
    };
    this.obj.detachToolbar = function () {
        if (this.vs[this.av].toolbar) {
            var a = document.getElementById(this.vs[this.av].toolbarId);
            this.vs[this.av].toolbar.unload();
            this.vs[this.av].toolbar = null;
            this.vs[this.av].toolbarId = null;
            this.vs[this.av].toolbarHeight = null;
            a && a.parentNode.removeChild(a);
            a = null;
            this._viewRestore();
            this._doOnAttachToolbar && this._doOnAttachToolbar("unload")
        }
    };
    this.obj.attachGrid = function () {
        if (this._isWindow && this.skin == "dhx_skyblue")this.vs[this.av].dhxcont.mainCont[this.av].style.border = "#a4bed4 1px solid", this._redraw();
        var a = document.createElement("DIV");
        a.id = "dhxGridObj_" + this._genStr(12);
        a.style.width = "100%";
        a.style.height = "100%";
        a.cmp = "grid";
        document.body.appendChild(a);
        this.attachObject(a.id,
            !1, !0, !1);
        this.vs[this.av].grid = new dhtmlXGridObject(a.id);
        this.vs[this.av].grid.setSkin(this.skin);
        if (this.skin == "dhx_skyblue" || this.skin == "dhx_black" || this.skin == "dhx_blue")this.vs[this.av].grid.entBox.style.border = "0px solid white", this.vs[this.av].grid._sizeFix = 2;
        this.vs[this.av].gridId = a.id;
        this.vs[this.av].gridObj = a;
        this.skin == "dhx_terrace" && (this.adjust(), this.updateNestedObjects(!0));
        return this.vs[this._viewRestore()].grid
    };
    this.obj.attachScheduler = function (a, b, c, d) {
        var d = d || window.scheduler,
            e = 0;
        c && (h = document.getElementById(c)) && (e = 1);
        if (!e) {
            var f = c || '<div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div><div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div><div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>', h = document.createElement("DIV");
            h.id = "dhxSchedObj_" + this._genStr(12);
            h.innerHTML = '<div id="' + h.id + '" class="dhx_cal_container" style="width:100%; height:100%;"><div class="dhx_cal_navline"><div class="dhx_cal_prev_button">&nbsp;</div><div class="dhx_cal_next_button">&nbsp;</div><div class="dhx_cal_today_button"></div><div class="dhx_cal_date"></div>' +
                f + '</div><div class="dhx_cal_header"></div><div class="dhx_cal_data"></div></div>';
            document.body.appendChild(h.firstChild)
        }
        this.attachObject(h.id, !1, !0, !1);
        this.vs[this.av].sched = d;
        this.vs[this.av].schedId = h.id;
        d.setSizes = d.update_view;
        d.destructor = function () {
        };
        d.init(h.id, a, b);
        return this.vs[this._viewRestore()].sched
    };
    this.obj.attachTree = function (a) {
        if (this._isWindow && this.skin == "dhx_skyblue")this.vs[this.av].dhxcont.mainCont[this.av].style.border = "#a4bed4 1px solid", this._redraw();
        var b = document.createElement("DIV");
        b.id = "dhxTreeObj_" + this._genStr(12);
        b.style.width = "100%";
        b.style.height = "100%";
        b.cmp = "tree";
        document.body.appendChild(b);
        this.attachObject(b.id, !1, !0, !1);
        this.vs[this.av].tree = new dhtmlXTreeObject(b.id, "100%", "100%", a || 0);
        this.vs[this.av].tree.setSkin(this.skin);
        this.vs[this.av].tree.allTree.childNodes[0].style.marginTop = "2px";
        this.vs[this.av].tree.allTree.childNodes[0].style.marginBottom = "2px";
        this.vs[this.av].treeId = b.id;
        this.vs[this.av].treeObj = b;
        this.skin == "dhx_terrace" && (this.adjust(), this.updateNestedObjects(!0));
        return this.vs[this._viewRestore()].tree
    };
    this.obj.attachTabbar = function (a) {
        if (this._isWindow && this.skin == "dhx_skyblue")this.vs[this.av].dhxcont.style.border = "none", this.setDimension(this.w, this.h);
        var b = document.createElement("DIV");
        b.id = "dhxTabbarObj_" + this._genStr(12);
        b.style.width = "100%";
        b.style.height = "100%";
        b.style.overflow = "hidden";
        b.cmp = "tabbar";
        if (!this._isWindow)b._hideBorders = !0;
        document.body.appendChild(b);
        this.attachObject(b.id, !1, !0, !1);
        if (this._isCell)this.hideHeader(), this._padding =
            b._hideBorders = !1;
        this.vs[this.av].tabbar = new dhtmlXTabBar(b.id, a || "top", this.skin == "dhx_terrace" ? null : 20);
        if (!this._isWindow && this.skin != "dhx_terrace")this.vs[this.av].tabbar._s.expand = !0;
        this.vs[this.av].tabbar.setSkin(this.skin);
        this.vs[this.av].tabbar.adjustOuterSize();
        this.vs[this.av].tabbarId = b.id;
        this.vs[this.av].tabbarObj = b;
        this.skin == "dhx_terrace" && (this.adjust(), this.updateNestedObjects(!0));
        return this.vs[this._viewRestore()].tabbar
    };
    this.obj.attachFolders = function () {
        if (this._isWindow &&
            this.skin == "dhx_skyblue")this.vs[this.av].dhxcont.mainCont[this.av].style.border = "#a4bed4 1px solid", this._redraw();
        var a = document.createElement("DIV");
        a.id = "dhxFoldersObj_" + this._genStr(12);
        a.style.width = "100%";
        a.style.height = "100%";
        a.style.overflow = "hidden";
        a.cmp = "folders";
        document.body.appendChild(a);
        this.attachObject(a.id, !1, !0, !1);
        this.vs[this.av].folders = new dhtmlxFolders(a.id);
        this.vs[this.av].folders.setSizes();
        this.vs[this.av].foldersId = a.id;
        this.vs[this.av].foldersObj = a;
        return this.vs[this._viewRestore()].folders
    };
    this.obj.attachAccordion = function () {
        if (this._isWindow && this.skin == "dhx_skyblue")this.vs[this.av].dhxcont.mainCont[this.av].style.border = "#a4bed4 1px solid", this._redraw();
        var a = document.createElement("DIV");
        a.id = "dhxAccordionObj_" + this._genStr(12);
        this._padding = !0;
        if (this.skin == "dhx_web")a.style.left = "0px", a.style.top = "0px", a.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) + "px", a.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) + "px"; else if (this.skin !=
            "dhx_terrace")a.style.left = "-1px", a.style.top = "-1px", a.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) + 2 + "px", a.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) + 2 + "px";
        a.style.position = "relative";
        a.cmp = "accordion";
        document.body.appendChild(a);
        this.attachObject(a.id, !1, !0, !1);
        this.vs[this.av].accordion = new dhtmlXAccordion(a.id, this.skin);
        this.vs[this.av].accordion.setSizes();
        this.vs[this.av].accordionId = a.id;
        this.vs[this.av].accordionObj = a;
        this.skin == "dhx_terrace" && (this.adjust(), this.updateNestedObjects(!0));
        return this.vs[this._viewRestore()].accordion
    };
    this.obj.attachLayout = function (a, b) {
        if (this._isCell && this.skin == "dhx_skyblue")this.hideHeader(), this.vs[this.av].dhxcont.style.border = "0px solid white", this.adjustContent(this.childNodes[0], 0);
        this._isCell && this.skin == "dhx_web" && this.hideHeader();
        this._padding = !0;
        var c = document.createElement("DIV");
        c.id = "dhxLayoutObj_" + this._genStr(12);
        c.style.overflow = "hidden";
        c.style.position = "absolute";
        c.style.left = "0px";
        c.style.top = "0px";
        c.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) + "px";
        c.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) + "px";
        if ((this._isTabbarCell || this._isAcc) && this.skin == "dhx_skyblue")c.style.left = "-1px", c.style.top = "-1px", c.style.width = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.width) + 2 + "px", c.style.height = parseInt(this.vs[this.av].dhxcont.mainCont[this.av].style.height) + 2 + "px";
        c.dhxContExists = !0;
        c.cmp = "layout";
        document.body.appendChild(c);
        this.attachObject(c.id, !1, !0, !1);
        this.vs[this.av].layout = new dhtmlXLayoutObject(c, a, b || this.skin);
        this._isWindow && this.attachEvent("_onBeforeTryResize", this.vs[this.av].layout._defineWindowMinDimension);
        this.vs[this.av].layoutId = c.id;
        this.vs[this.av].layoutObj = c;
        if (this.skin == "dhx_terrace") {
            if (this._isCell)this.style.backgroundColor = "transparent", this.vs[this.av].dhxcont.style.backgroundColor = "transparent", this.hideHeader();
            this.adjust();
            this.updateNestedObjects(!0)
        }
        return this.vs[this._viewRestore()].layout
    };
    this.obj.attachEditor = function (a) {
        if (this._isWindow && this.skin == "dhx_skyblue")this.vs[this.av].dhxcont.mainCont[this.av].style.border = "#a4bed4 1px solid", this._redraw();
        var b = document.createElement("DIV");
        b.id = "dhxEditorObj_" + this._genStr(12);
        b.style.position = "relative";
        b.style.display = "none";
        b.style.overflow = "hidden";
        b.style.width = "100%";
        b.style.height = "100%";
        b.cmp = "editor";
        document.body.appendChild(b);
        if (this.skin == "dhx_terrace")b._attached = !0;
        this.attachObject(b.id, !1, !0, !1);
        this.vs[this.av].editor =
            new dhtmlXEditor(b.id, a || this.skin);
        this.vs[this.av].editorId = b.id;
        this.vs[this.av].editorObj = b;
        this.skin == "dhx_terrace" && (this.adjust(), this.updateNestedObjects(!0));
        return this.vs[this._viewRestore()].editor
    };
    this.obj.attachMap = function (a) {
        var b = document.createElement("DIV");
        b.id = "GMapsObj_" + this._genStr(12);
        b.style.position = "relative";
        b.style.display = "none";
        b.style.overflow = "hidden";
        b.style.width = "100%";
        b.style.height = "100%";
        b.cmp = "gmaps";
        document.body.appendChild(b);
        this.attachObject(b.id, !1,
            !0, !0);
        a || (a = {center: new google.maps.LatLng(40.719837, -73.992348), zoom: 11, mapTypeId: google.maps.MapTypeId.ROADMAP});
        this.vs[this.av].gmaps = new google.maps.Map(b, a);
        return this.vs[this.av].gmaps
    };
    this.obj.attachObject = function (a, b, c, d) {
        typeof a == "string" && (a = document.getElementById(a));
        if (b) {
            a.style.visibility = "hidden";
            a.style.display = "";
            var e = a.offsetWidth, f = a.offsetHeight
        }
        this._attachContent("obj", a);
        if (b && this._isWindow)a.style.visibility = "", this._adjustToContent(e, f);
        if (this.skin == "dhx_terrace" &&
            (this.vs[this.av].menu != null || this.vs[this.av].toolbar != null))this.adjust(typeof d == "undefined" || d == !0), this.updateNestedObjects(!0);
        c || this._viewRestore()
    };
    this.obj.detachObject = function (a, b) {
        for (var c = null, d = null, e = "tree,grid,layout,tabbar,accordion,folders".split(","), f = 0; f < e.length; f++)if (this.vs[this.av][e[f]]) {
            c = this.vs[this.av][e[f]];
            d = this.vs[this.av][e[f] + "Obj"];
            if (a) {
                c.unload && c.unload();
                for (c.destructor && c.destructor(); d.childNodes.length > 0;)d.removeChild(d.childNodes[0]);
                d.parentNode.removeChild(d);
                c = d = null
            } else document.body.appendChild(d), d.style.display = "none";
            this.vs[this.av][e[f]] = null;
            this.vs[this.av][e[f] + "Id"] = null;
            this.vs[this.av][e[f] + "Obj"] = null
        }
        if (c != null && d != null)return[c, d];
        if (a && this.vs[this.av]._frame)this._detachURLEvents(), this.vs[this.av]._frame = null;
        for (var h = this.vs[this.av].dhxcont.mainCont[this.av]; h.childNodes.length > 0;)if (a == !0)h.removeChild(h.childNodes[0]); else {
            var g = h.childNodes[0];
            b != null ? (typeof b != "object" && (b = document.getElementById(b)), b.appendChild(g)) : document.body.appendChild(g);
            g.style.display = "none"
        }
        h = b = null
    };
    this.obj.appendObject = function (a) {
        typeof a == "string" && (a = document.getElementById(a));
        this._attachContent("obj", a, !0)
    };
    this.obj.attachHTMLString = function (a) {
        this._attachContent("str", a);
        for (var b = a.match(/<script[^>]*>[^\f]*?<\/script>/g) || [], c = 0; c < b.length; c++) {
            var d = b[c].replace(/<([\/]{0,1})script[^>]*>/g, "");
            d && (window.execScript ? window.execScript(d) : window.eval(d))
        }
    };
    this.obj.attachURL = function (a, b) {
        this._attachContent(b == !0 ? "urlajax" : "url", a, !1);
        if (this.skin ==
            "dhx_terrace" && (this.vs[this.av].menu != null || this.vs[this.av].toolbar != null))this.adjust(!0), this.updateNestedObjects(!0);
        this._viewRestore()
    };
    this.obj.adjust = function (a) {
        if (this.skin == "dhx_skyblue") {
            if (this.vs[this.av].menu) {
                if (this._isWindow || this._isLayout)this.vs[this.av].menu._topLevelOffsetLeft = 0, document.getElementById(this.vs[this.av].menuId).style.height = "26px", this.vs[this.av].menuHeight = document.getElementById(this.vs[this.av].menuId).offsetHeight, this._doOnAttachMenu && this._doOnAttachMenu("show");
                if (this._isCell)document.getElementById(this.vs[this.av].menuId).className += " in_layoutcell", this.vs[this.av].menuHeight = 25;
                if (this._isAcc)document.getElementById(this.vs[this.av].menuId).className += " in_acccell", this.vs[this.av].menuHeight = 25;
                this._doOnAttachMenu && this._doOnAttachMenu("adjust")
            }
            this.vs[this.av].toolbar && (this._isWindow && (document.getElementById(this.vs[this.av].toolbarId).className += " in_window"), this._isLayout && (document.getElementById(this.vs[this.av].toolbarId).className += " in_layout"),
                this._isCell && (document.getElementById(this.vs[this.av].toolbarId).className += " in_layoutcell"), this._isAcc && (document.getElementById(this.vs[this.av].toolbarId).className += " in_acccell"), this._isTabbarCell && (document.getElementById(this.vs[this.av].toolbarId).className += " in_tabbarcell"))
        }
        this.skin == "dhx_web" && this.vs[this.av].toolbar && (this._isWindow && (document.getElementById(this.vs[this.av].toolbarId).className += " in_window"), this._isLayout && (document.getElementById(this.vs[this.av].toolbarId).className +=
            " in_layout"), this._isCell && (document.getElementById(this.vs[this.av].toolbarId).className += " in_layoutcell"), this._isAcc && (document.getElementById(this.vs[this.av].toolbarId).className += " in_acccell"), this._isTabbarCell && (document.getElementById(this.vs[this.av].toolbarId).className += " in_tabbarcell"));
        if (this.skin == "dhx_terrace") {
            var b = 0;
            if (this._isWindow || this._isCell || this._isAcc || this._isTabbarCell)b = 14;
            this._isCell && this._noHeader && (b = 0);
            var c = 0;
            if (this._isWindow || this._isCell || this._isAcc ||
                this._isTabbarCell)c = 14;
            this._isCell && this._noHeader && (c = 0);
            var d = a == !0 && !this.vs[this.av].toolbar || this._isLayout ? 14 : 0, e = a == !0 || this._isLayout ? 14 : 0, f = !1;
            if (this.vs[this.av].menu)document.getElementById(this.vs[this.av].menuId).style.marginLeft = b + "px", document.getElementById(this.vs[this.av].menuId).style.marginRight = b + "px", document.getElementById(this.vs[this.av].menuId).style.marginTop = c + "px", document.getElementById(this.vs[this.av].menuId).style.marginBottom = d + "px", this.vs[this.av].menuHeight =
                32 + c + d, this._doOnAttachMenu && this._doOnAttachMenu("show"), f = !0;
            if (this.vs[this.av].toolbar)c == 0 && this.vs[this.av].menu != null & this._isCell && (c = 14), document.getElementById(this.vs[this.av].toolbarId).style.marginLeft = b + "px", document.getElementById(this.vs[this.av].toolbarId).style.marginRight = b + "px", document.getElementById(this.vs[this.av].toolbarId).style.marginTop = c + "px", document.getElementById(this.vs[this.av].toolbarId).style.marginBottom = e + "px", this.vs[this.av].toolbarHeight = 32 + c + e, this._doOnAttachToolbar &&
                this._doOnAttachToolbar("show"), f = !0
        }
    };
    this.obj._attachContent = function (a, b, c) {
        if (c !== !0) {
            if (this.vs[this.av]._frame)this._detachURLEvents(), this.vs[this.av]._frame = null;
            for (; this.vs[this.av].dhxcont.mainCont[this.av].childNodes.length > 0;)this.vs[this.av].dhxcont.mainCont[this.av].removeChild(this.vs[this.av].dhxcont.mainCont[this.av].childNodes[0])
        }
        if (a == "url") {
            if (this._isWindow && b.cmp == null && this.skin == "dhx_skyblue")this.vs[this.av].dhxcont.mainCont[this.av].style.border = "#a4bed4 1px solid", this._redraw();
            var d = document.createElement("IFRAME");
            d.frameBorder = 0;
            d.border = 0;
            d.style.width = "100%";
            d.style.height = "100%";
            d.setAttribute("src", "javascript:false;");
            this.vs[this.av].dhxcont.mainCont[this.av].appendChild(d);
            d.src = b;
            this.vs[this.av]._frame = d;
            this._attachURLEvents()
        } else if (a == "urlajax") {
            if (this._isWindow && b.cmp == null && this.skin == "dhx_skyblue")this.vs[this.av].dhxcont.mainCont[this.av].style.border = "#a4bed4 1px solid", this.vs[this.av].dhxcont.mainCont[this.av].style.backgroundColor = "#FFFFFF", this._redraw();
            var e = this, f = String(this.av).valueOf(), h = function () {
                var a = e.av;
                e.av = f;
                e.attachHTMLString(this.xmlDoc.responseText, this);
                e.av = a;
                e._doOnFrameContentLoaded && e._doOnFrameContentLoaded();
                this.destructor()
            }, g = new dtmlXMLLoaderObject(h, window);
            g.dhxWindowObject = this;
            g.loadXML(b)
        } else if (a == "obj") {
            if (this._isWindow && b.cmp == null && this.skin == "dhx_skyblue")this.vs[this.av].dhxcont.mainCont[this.av].style.border = "#a4bed4 1px solid", this.vs[this.av].dhxcont.mainCont[this.av].style.backgroundColor = "#FFFFFF", this._redraw();
            this.vs[this.av].dhxcont._frame = null;
            this.vs[this.av].dhxcont.mainCont[this.av].appendChild(b);
            this.vs[this.av].dhxcont.mainCont[this.av].style.overflow = c === !0 ? "auto" : "hidden";
            b.style.display = ""
        } else if (a == "str") {
            if (this._isWindow && b.cmp == null && this.skin == "dhx_skyblue")this.vs[this.av].dhxcont.mainCont[this.av].style.border = "#a4bed4 1px solid", this.vs[this.av].dhxcont.mainCont[this.av].style.backgroundColor = "#FFFFFF", this._redraw();
            this.vs[this.av].dhxcont._frame = null;
            this.vs[this.av].dhxcont.mainCont[this.av].innerHTML =
                b
        }
    };
    this.obj._attachURLEvents = function () {
        var a = this, b = this.vs[this.av]._frame;
        _isIE ? b.onreadystatechange = function () {
            if (b.readyState == "complete") {
                try {
                    b.contentWindow.document.body.onmousedown = function () {
                        a._doOnFrameMouseDown && a._doOnFrameMouseDown()
                    }
                } catch (c) {
                }
                try {
                    a._doOnFrameContentLoaded && a._doOnFrameContentLoaded()
                } catch (d) {
                }
            }
        } : b.onload = function () {
            try {
                b.contentWindow.onmousedown = function () {
                    a._doOnFrameMouseDown && a._doOnFrameMouseDown()
                }
            } catch (c) {
            }
            try {
                a._doOnFrameContentLoaded && a._doOnFrameContentLoaded()
            } catch (d) {
            }
        }
    };
    this.obj._detachURLEvents = function () {
        if (_isIE)try {
            this.vs[this.av]._frame.onreadystatechange = null, this.vs[this.av]._frame.contentWindow.document.body.onmousedown = null, this.vs[this.av]._frame.onload = null
        } catch (a) {
        } else try {
            this.vs[this.av]._frame.contentWindow.onmousedown = null, this.vs[this.av]._frame.onload = null
        } catch (b) {
        }
    };
    this.obj.showMenu = function () {
        if (this.vs[this.av].menu && this.vs[this.av].menuId && document.getElementById(this.vs[this.av].menuId).style.display == "none")this.vs[this.av].menuHidden = !1, this._doOnAttachMenu && this._doOnAttachMenu("show"), document.getElementById(this.vs[this.av].menuId).style.display = "", this._viewRestore()
    };
    this.obj.hideMenu = function () {
        if (this.vs[this.av].menu && this.vs[this.av].menuId && document.getElementById(this.vs[this.av].menuId).style.display != "none")document.getElementById(this.vs[this.av].menuId).style.display = "none", this.vs[this.av].menuHidden = !0, this._doOnAttachMenu && this._doOnAttachMenu("hide"), this._viewRestore()
    };
    this.obj.showToolbar = function () {
        if (this.vs[this.av].toolbar &&
            this.vs[this.av].toolbarId && document.getElementById(this.vs[this.av].toolbarId).style.display == "none")this.vs[this.av].toolbarHidden = !1, this._doOnAttachToolbar && this._doOnAttachToolbar("show"), document.getElementById(this.vs[this.av].toolbarId).style.display = "", this._viewRestore()
    };
    this.obj.hideToolbar = function () {
        if (this.vs[this.av].toolbar && this.vs[this.av].toolbarId && document.getElementById(this.vs[this.av].toolbarId).style.display != "none")this.vs[this.av].toolbarHidden = !0, document.getElementById(this.vs[this.av].toolbarId).style.display =
            "none", this._doOnAttachToolbar && this._doOnAttachToolbar("hide"), this._viewRestore()
    };
    this.obj.showStatusBar = function () {
        if (this.vs[this.av].sb && this.vs[this.av].sbId && document.getElementById(this.vs[this.av].sbId).style.display == "none")this.vs[this.av].sbHidden = !1, this._doOnAttachStatusBar && this._doOnAttachStatusBar("show"), document.getElementById(this.vs[this.av].sbId).style.display = "", this._viewRestore()
    };
    this.obj.hideStatusBar = function () {
        if (this.vs[this.av].sb && this.vs[this.av].sbId && document.getElementById(this.vs[this.av].sbId).style.display !=
            "none")this.vs[this.av].sbHidden = !0, document.getElementById(this.vs[this.av].sbId).style.display = "none", this._doOnAttachStatusBar && this._doOnAttachStatusBar("hide"), this._viewRestore()
    };
    this.obj._dhxContDestruct = function () {
        var a = this.av, b;
        for (b in this.vs)this.av = b, this.detachMenu(), this.detachToolbar(), this.detachStatusBar(), this.detachObject(!0), this.vs[b].dhxcont.mainCont[b] = null;
        for (b in this.vs)this.vs[b].dhxcont.mainCont = null, this.vs[b].dhxcont.innerHTML = "", this.vs[b].dhxcont = null, this.vs[b] =
            null;
        this.setActive = this.getView = this.getFrame = this._getSt = this._dhxContDestruct = this._genStr = this._init = this._setPadding = this._viewRestore = this._detachURLEvents = this._attachURLEvents = this._attachContent = this.updateNestedObjects = this.hideCoverBlocker = this.showCoverBlocker = this.coverBlocker = this.adjustContent = this.moveContentTo = this.setMinContentSize = this.adjust = this.show = this.view = this.attachMap = this.attachURL = this.attachHTMLString = this.appendObject = this.detachObject = this.attachObject = this.attachEditor =
            this.attachLayout = this.attachAccordion = this.attachFolders = this.attachTabbar = this.attachTree = this.attachScheduler = this.attachGrid = this.hideStatusBar = this.hideToolbar = this.hideMenu = this.showStatusBar = this.showToolbar = this.showMenu = this.detachStatusBar = this.detachToolbar = this.detachMenu = this.attachStatusBar = this.attachToolbar = this.attachMenu = this.vs = null;
        g.st.innerHTML = "";
        g.st.parentNode.removeChild(g.st);
        g.st = null;
        g.setContent = null;
        g.dhxcont = null;
        g = g.obj = null;
        if (dhtmlx.detaches)for (b in dhtmlx.detaches)dhtmlx.detaches[b](this)
    };
    if (dhtmlx.attaches)for (var j in dhtmlx.attaches)this.obj[j] = dhtmlx.attaches[j];
    return this
};

//v.3.5 build 120822

/*
 Copyright DHTMLX LTD. http://www.dhtmlx.com
 You allowed to use this component or parts of it under GPL terms
 To use it on other terms or get Professional edition of the component please contact us at sales@dhtmlx.com
 */