//v.3.5 build 120822

/*
 Copyright DHTMLX LTD. http://www.dhtmlx.com
 You allowed to use this component or parts of it under GPL terms
 To use it on other terms or get Professional edition of the component please contact us at sales@dhtmlx.com
 */
function xmlPointer(a) {
    this.d = a
}
xmlPointer.prototype = {text: function () {
    if (!_isFF)return this.d.xml;
    var a = new XMLSerializer;
    return a.serializeToString(this.d)
}, get: function (a) {
    return this.d.getAttribute(a)
}, exists: function () {
    return!!this.d
}, content: function () {
    return this.d.firstChild ? this.d.firstChild.data : ""
}, each: function (a, b, c, d) {
    var f = this.d.childNodes, e = new xmlPointer;
    if (f.length)for (d = d || 0; d < f.length; d++)if (f[d].tagName == a && (e.d = f[d], b.apply(c, [e, d]) == -1))break
}, get_all: function () {
    for (var a = {}, b = this.d.attributes, c = 0; c < b.length; c++)a[b[c].name] =
        b[c].value;
    return a
}, sub: function (a) {
    var b = this.d.childNodes, c = new xmlPointer;
    if (b.length)for (var d = 0; d < b.length; d++)if (b[d].tagName == a)return c.d = b[d], c
}, up: function () {
    return new xmlPointer(this.d.parentNode)
}, set: function (a, b) {
    this.d.setAttribute(a, b)
}, clone: function () {
    return new xmlPointer(this.d)
}, sub_exists: function (a) {
    var b = this.d.childNodes;
    if (b.length)for (var c = 0; c < b.length; c++)if (b[c].tagName == a)return!0;
    return!1
}, through: function (a, b, c, d, f) {
    var e = this.d.childNodes;
    if (e.length)for (var g =
        0; g < e.length; g++) {
        if (e[g].tagName == a && e[g].getAttribute(b) != null && e[g].getAttribute(b) != "" && (!c || e[g].getAttribute(b) == c)) {
            var h = new xmlPointer(e[g]);
            d.apply(f, [h, g])
        }
        var j = this.d;
        this.d = e[g];
        this.through(a, b, c, d, f);
        this.d = j
    }
}};
function dhtmlXTreeObject(a, b, c, d) {
    if (_isIE)try {
        document.execCommand("BackgroundImageCache", !1, !0)
    } catch (f) {
    }
    this.parentObject = typeof a != "object" ? document.getElementById(a) : a;
    this.parentObject.style.overflow = "hidden";
    this._itim_dg = !0;
    this.dlmtr = ",";
    this.dropLower = !1;
    this.enableIEImageFix();
    this.xmlstate = 0;
    this.mytype = "tree";
    this.smcheck = !0;
    this.width = b;
    this.height = c;
    this.rootId = d;
    this.childCalc = null;
    this.def_line_img_y = this.def_line_img_x = this.def_img_y = this.def_img_x = "18px";
    this._dragged = [];
    this._selected =
        [];
    this.style_pointer = "pointer";
    this._aimgs = !0;
    this.htmlcA = " [";
    this.htmlcB = "]";
    this.lWin = window;
    this.mlitems = this.cMenu = 0;
    this.iconURL = "";
    this.dadmode = 0;
    this.slowParse = !1;
    this.autoScroll = !0;
    this.hfMode = 0;
    this.nodeCut = [];
    this.XMLloadingWarning = this.XMLsource = 0;
    this._idpull = {};
    this._pullSize = 0;
    this.treeLinesOn = !0;
    this.tscheck = !1;
    this.timgen = !0;
    this.dpcpy = !1;
    this._ld_id = null;
    this._oie_onXLE = [];
    this.imPath = window.dhx_globalImgPath || "";
    this.checkArray = "iconUncheckAll.gif,iconCheckAll.gif,iconCheckGray.gif,iconUncheckDis.gif,iconCheckDis.gif,iconCheckDis.gif".split(",");
    this.radioArray = "radio_off.gif,radio_on.gif,radio_on.gif,radio_off.gif,radio_on.gif,radio_on.gif".split(",");
    this.lineArray = "line2.gif,line3.gif,line4.gif,blank.gif,blank.gif,line1.gif".split(",");
    this.minusArray = ["minus2.gif", "minus3.gif", "minus4.gif", "minus.gif", "minus5.gif"];
    this.plusArray = ["plus2.gif", "plus3.gif", "plus4.gif", "plus.gif", "plus5.gif"];
    this.imageArray = ["leaf.gif", "folderOpen.gif", "folderClosed.gif"];
    this.cutImg = [0, 0, 0];
    this.cutImage = "but_cut.gif";
    dhtmlxEventable(this);
    this.dragger =
        new dhtmlDragAndDropObject;
    this.htmlNode = new dhtmlXTreeItemObject(this.rootId, "", 0, this);
    this.htmlNode.htmlNode.childNodes[0].childNodes[0].style.display = "none";
    this.htmlNode.htmlNode.childNodes[0].childNodes[0].childNodes[0].className = "hiddenRow";
    this.allTree = this._createSelf();
    this.allTree.appendChild(this.htmlNode.htmlNode);
    if (_isFF)this.allTree.childNodes[0].width = "100%", this.allTree.childNodes[0].style.overflow = "hidden";
    var e = this;
    this.allTree.onselectstart = new Function("return false;");
    if (_isMacOS)this.allTree.oncontextmenu =
        function (a) {
            return e._doContClick(a || window.event, !0)
        };
    this.allTree.onmousedown = function (a) {
        return e._doContClick(a || window.event)
    };
    this.XMLLoader = new dtmlXMLLoaderObject(this._parseXMLTree, this, !0, this.no_cashe);
    _isIE && this.preventIECashing(!0);
    window.addEventListener && window.addEventListener("unload", function () {
        try {
            e.destructor()
        } catch (a) {
        }
    }, !1);
    window.attachEvent && window.attachEvent("onunload", function () {
        try {
            e.destructor()
        } catch (a) {
        }
    });
    this.setImagesPath = this.setImagePath;
    this.setIconsPath = this.setIconPath;
    dhtmlx.image_path && this.setImagePath(dhtmlx.image_path);
    dhtmlx.skin && this.setSkin(dhtmlx.skin);
    return this
}
dhtmlXTreeObject.prototype.setDataMode = function (a) {
    this._datamode = a
};
dhtmlXTreeObject.prototype._doContClick = function (a, b) {
    if (!b && a.button != 2)return this._acMenu && (this._acMenu.hideContextMenu ? this._acMenu.hideContextMenu() : this.cMenu._contextEnd()), !0;
    for (var c = _isIE ? a.srcElement : a.target; c && c.tagName != "BODY";) {
        if (c.parentObject)break;
        c = c.parentNode
    }
    if (!c || !c.parentObject)return!0;
    var d = c.parentObject;
    if (!this.callEvent("onRightClick", [d.id, a]))(a.srcElement || a.target).oncontextmenu = function (a) {
        (a || event).cancelBubble = !0;
        return!1
    };
    if (this._acMenu = d.cMenu || this.cMenu) {
        if (!this.callEvent("onBeforeContextMenu",
            [d.id]))return!0;
        (a.srcElement || a.target).oncontextmenu = function (a) {
            (a || event).cancelBubble = !0;
            return!1
        };
        if (this._acMenu.showContextMenu) {
            var f = window.document.documentElement, e = window.document.body, g = [f.scrollLeft || e.scrollLeft, f.scrollTop || e.scrollTop];
            if (_isIE)var h = a.clientX + g[0], j = a.clientY + g[1]; else h = a.pageX, j = a.pageY;
            this._acMenu.showContextMenu(h - 1, j - 1);
            this.contextID = d.id;
            a.cancelBubble = !0;
            this._acMenu._skip_hide = !0
        } else c.contextMenuId = d.id, c.contextMenu = this._acMenu, c.a = this._acMenu._contextStart,
            c.a(c, a), c.a = null;
        return!1
    }
    return!0
};
dhtmlXTreeObject.prototype.enableIEImageFix = function (a) {
    a ? (this._getImg = function () {
        var a = document.createElement("DIV");
        a.innerHTML = "&nbsp;";
        a.className = "dhx_bg_img_fix";
        return a
    }, this._setSrc = function (a, c) {
        a.style.backgroundImage = "url(" + c + ")"
    }, this._getSrc = function (a) {
        var c = a.style.backgroundImage;
        return c.substr(4, c.length - 5).replace(/(^")|("$)/g, "")
    }) : (this._getImg = function (a) {
        return document.createElement(a == this.rootId ? "div" : "img")
    }, this._setSrc = function (a, c) {
        a.src = c
    }, this._getSrc = function (a) {
        return a.src
    })
};
dhtmlXTreeObject.prototype.destructor = function () {
    for (var a in this._idpull) {
        var b = this._idpull[a];
        if (b)b.parentObject = null, b.treeNod = null, b.childNodes = null, b.span = null, b.tr.nodem = null, b.tr = null, b.htmlNode.objBelong = null, b.htmlNode = null, this._idpull[a] = null
    }
    this.parentObject.innerHTML = "";
    this.XMLLoader && this.XMLLoader.destructor();
    this.allTree.onselectstart = null;
    this.allTree.oncontextmenu = null;
    this.allTree.onmousedown = null;
    for (a in this)this[a] = null
};
function cObject() {
    return this
}
cObject.prototype = {};
cObject.prototype.clone = function () {
    function a() {
    }

    a.prototype = this;
    return new a
};
function dhtmlXTreeItemObject(a, b, c, d, f, e) {
    this.scolor = this.acolor = this.htmlNode = "";
    this.span = this.dragMove = this.dragSpan = this.tempDOMU = this.tempDOMM = this.childsCount = this.tr = 0;
    this.closeble = 1;
    this.childNodes = [];
    this.userData = new cObject;
    this.checkstate = 0;
    this.treeNod = d;
    this.label = b;
    this.parentObject = c;
    this.actionHandler = f;
    this.images = [d.imageArray[0], d.imageArray[1], d.imageArray[2]];
    this.id = d._globalIdStorageAdd(a, this);
    this.htmlNode = this.treeNod.checkBoxOff ? this.treeNod._createItem(1, this, e) : this.treeNod._createItem(0,
        this, e);
    this.htmlNode.objBelong = this;
    return this
}
dhtmlXTreeObject.prototype._globalIdStorageAdd = function (a, b) {
    if (this._globalIdStorageFind(a, 1, 1))return a = a + "_" + (new Date).valueOf(), this._globalIdStorageAdd(a, b);
    this._idpull[a] = b;
    this._pullSize++;
    return a
};
dhtmlXTreeObject.prototype._globalIdStorageSub = function (a) {
    this._idpull[a] && (this._unselectItem(this._idpull[a]), this._idpull[a] = null, this._pullSize--);
    this._locker && this._locker[a] && (this._locker[a] = !1)
};
dhtmlXTreeObject.prototype._globalIdStorageFind = function (a) {
    var b = this._idpull[a];
    return b ? b : null
};
dhtmlXTreeObject.prototype._escape = function (a) {
    switch (this.utfesc) {
        case "none":
            return a;
        case "utf8":
            return encodeURIComponent(a);
        default:
            return escape(a)
    }
};
dhtmlXTreeObject.prototype._drawNewTr = function (a) {
    var b = document.createElement("tr"), c = document.createElement("td"), d = document.createElement("td");
    c.appendChild(document.createTextNode(" "));
    d.colSpan = 3;
    d.appendChild(a);
    b.appendChild(c);
    b.appendChild(d);
    return b
};
dhtmlXTreeObject.prototype.loadXMLString = function (a, b) {
    var c = this;
    this.parsCount || this.callEvent("onXLS", [c, null]);
    this.xmlstate = 1;
    if (b)this.XMLLoader.waitCall = b;
    this.XMLLoader.loadXMLString(a)
};
dhtmlXTreeObject.prototype.loadXML = function (a, b) {
    if (this._datamode && this._datamode != "xml")return this["load" + this._datamode.toUpperCase()](a, b);
    var c = this;
    this.parsCount || this.callEvent("onXLS", [c, this._ld_id]);
    this._ld_id = null;
    this.xmlstate = 1;
    this.XMLLoader = new dtmlXMLLoaderObject(this._parseXMLTree, this, !0, this.no_cashe);
    if (b)this.XMLLoader.waitCall = b;
    this.XMLLoader.loadXML(a)
};
dhtmlXTreeObject.prototype._attachChildNode = function (a, b, c, d, f, e, g, h, j, i, m) {
    if (i && i.parentObject)a = i.parentObject;
    if (a.XMLload == 0 && this.XMLsource && !this.XMLloadingWarning)a.XMLload = 1, this._loadDynXML(a.id);
    var l = a.childsCount, k = a.childNodes;
    if (m && m.tr.previousSibling)m.tr.previousSibling.previousSibling ? i = m.tr.previousSibling.nodem : h = h.replace("TOP", "") + ",TOP";
    if (i) {
        var o, r;
        for (o = 0; o < l; o++)if (k[o] == i) {
            for (r = l; r != o; r--)k[1 + r] = k[r];
            break
        }
        o++;
        l = o
    }
    if (h)for (var s = h.split(","), p = 0; p < s.length; p++)switch (s[p]) {
        case "TOP":
            if (a.childsCount >
                0)i = {}, i.tr = a.childNodes[0].tr.previousSibling;
            a._has_top = !0;
            for (o = l; o > 0; o--)k[o] = k[o - 1];
            l = 0
    }
    var n;
    if (!(n = this._idpull[b]) || n.span != -1)n = k[l] = new dhtmlXTreeItemObject(b, c, a, this, d, 1), b = k[l].id, a.childsCount++;
    if (!n.htmlNode)n.label = c, n.htmlNode = this._createItem(this.checkBoxOff ? 1 : 0, n), n.htmlNode.objBelong = n;
    f && (n.images[0] = f);
    e && (n.images[1] = e);
    g && (n.images[2] = g);
    var q = this._drawNewTr(n.htmlNode);
    if (this.XMLloadingWarning || this._hAdI)n.htmlNode.parentNode.parentNode.style.display = "none";
    i && i.tr &&
        i.tr.nextSibling ? a.htmlNode.childNodes[0].insertBefore(q, i.tr.nextSibling) : this.parsingOn == a.id ? this.parsedArray[this.parsedArray.length] = q : a.htmlNode.childNodes[0].appendChild(q);
    i && !i.span && (i = null);
    if (this.XMLsource)n.XMLload = j && j != 0 ? 0 : 1;
    n.tr = q;
    q.nodem = n;
    if (a.itemId == 0)q.childNodes[0].className = "hiddenRow";
    (a._r_logic || this._frbtr) && this._setSrc(n.htmlNode.childNodes[0].childNodes[0].childNodes[1].childNodes[0], this.imPath + this.radioArray[0]);
    if (h) {
        s = h.split(",");
        for (p = 0; p < s.length; p++)switch (s[p]) {
            case "SELECT":
                this.selectItem(b,
                    !1);
                break;
            case "CALL":
                this.selectItem(b, !0);
                break;
            case "CHILD":
                n.XMLload = 0;
                break;
            case "CHECKED":
                this.XMLloadingWarning ? this.setCheckList += this.dlmtr + b : this.setCheck(b, 1);
                break;
            case "HCHECKED":
                this._setCheck(n, "unsure");
                break;
            case "OPEN":
                n.openMe = 1
        }
    }
    if (!this.XMLloadingWarning && (this._getOpenState(a) < 0 && !this._hAdI && this.openItem(a.id), i && (this._correctPlus(i), this._correctLine(i)), this._correctPlus(a), this._correctLine(a), this._correctPlus(n), a.childsCount >= 2 && (this._correctPlus(k[a.childsCount - 2]),
        this._correctLine(k[a.childsCount - 2])), a.childsCount != 2 && this._correctPlus(k[0]), this.tscheck && this._correctCheckStates(a), this._onradh))if (this.xmlstate == 1) {
        var t = this.onXLE;
        this.onXLE = function (a) {
            this._onradh(b);
            t && t(a)
        }
    } else this._onradh(b);
    return n
};
dhtmlXTreeObject.prototype.insertNewItem = function (a, b, c, d, f, e, g, h, j) {
    var i = this._globalIdStorageFind(a);
    if (!i)return-1;
    var m = this._attachChildNode(i, b, c, d, f, e, g, h, j);
    if (!this._idpull[this.rootId].XMLload)this._idpull[this.rootId].XMLload = 1;
    return m
};
dhtmlXTreeObject.prototype.insertNewChild = function (a, b, c, d, f, e, g, h, j) {
    return this.insertNewItem(a, b, c, d, f, e, g, h, j)
};
dhtmlXTreeObject.prototype._parseXMLTree = function (a, b, c, d, f) {
    var e = new xmlPointer(f.getXMLTopNode("tree"));
    a._parse(e);
    a._p = e
};
dhtmlXTreeObject.prototype._parseItem = function (a, b, c, d) {
    var f;
    if (this._srnd && (!this._idpull[f = a.get("id")] || !this._idpull[f].span))this._addItemSRND(b.id, f, a); else {
        var e = a.get_all();
        if (typeof this.waitUpdateXML == "object" && !this.waitUpdateXML[e.id])this._parse(a, e.id, 1); else {
            var g = [];
            e.select && g.push("SELECT");
            e.top && g.push("TOP");
            if (e.call)this.nodeAskingCall = e.id;
            e.checked == -1 ? g.push("HCHECKED") : e.checked && g.push("CHECKED");
            e.open && g.push("OPEN");
            if (this.waitUpdateXML)if (this._globalIdStorageFind(e.id))var h =
                this.updateItem(e.id, e.text, e.im0, e.im1, e.im2, e.checked, e.child); else this.npl == 0 ? g.push("TOP") : c = b.childNodes[this.npl], h = this._attachChildNode(b, e.id, e.text, 0, e.im0, e.im1, e.im2, g.join(","), e.child, 0, c), e.id = h.id, c = null; else h = this._attachChildNode(b, e.id, e.text, 0, e.im0, e.im1, e.im2, g.join(","), e.child, d || 0, c);
            if (e.tooltip)h.span.parentNode.parentNode.title = e.tooltip;
            e.style && (h.span.style.cssText ? h.span.style.cssText += ";" + e.style : h.span.setAttribute("style", h.span.getAttribute("style") + "; " + e.style));
            if (e.radio)h._r_logic = !0;
            if (e.nocheckbox) {
                var j = h.span.parentNode.previousSibling.previousSibling;
                j.childNodes[0].style.display = "none";
                if (window._KHTMLrv)j.style.display = "none";
                h.nocheckbox = !0
            }
            e.disabled && (e.checked != null && this._setCheck(h, e.checked), this.disableCheckbox(h, 1));
            h._acc = e.child || 0;
            this.parserExtension && this.parserExtension._parseExtension.call(this, a, e, b ? b.id : 0);
            this.setItemColor(h, e.aCol, e.sCol);
            e.locked == "1" && this.lockItem(h.id, !0, !0);
            (e.imwidth || e.imheight) && this.setIconSize(e.imwidth,
                e.imheight, h);
            (e.closeable == "0" || e.closeable == "1") && this.setItemCloseable(h, e.closeable);
            var i = "";
            e.topoffset && this.setItemTopOffset(h, e.topoffset);
            if (!this.slowParse || typeof this.waitUpdateXML == "object")a.sub_exists("item") && (i = this._parse(a, e.id, 1));
            if (i != "")this.nodeAskingCall = i;
            a.each("userdata", function (b) {
                this.setUserData(a.get("id"), b.get("name"), b.content())
            }, this)
        }
    }
};
dhtmlXTreeObject.prototype._parse = function (a, b, c, d) {
    if (this._srnd && !this.parentObject.offsetHeight) {
        var f = this;
        return window.setTimeout(function () {
            f._parse(a, b, c, d)
        }, 100)
    }
    if (a.exists()) {
        this.skipLock = !0;
        if (!b) {
            var b = a.get("id"), e = a.get("dhx_security");
            if (e)dhtmlx.security_key = e;
            if (a.get("radio"))this.htmlNode._r_logic = !0;
            this.parsingOn = b;
            this.parsedArray = [];
            this.nodeAskingCall = this.setCheckList = ""
        }
        var g = this._globalIdStorageFind(b);
        if (!g)return dhtmlxError.throwError("DataStructure", "XML refers to not existing parent");
        this.parsCount = this.parsCount ? this.parsCount + 1 : 1;
        this.XMLloadingWarning = 1;
        var h = g.childsCount && !d && !this._edsbps && !g._has_top ? 0 : 0;
        this.npl = 0;
        a.each("item", function (a) {
            g.XMLload = 1;
            this._parseItem(a, g, 0, h);
            this.npl++
        }, this, d);
        if (!c) {
            a.each("userdata", function (b) {
                this.setUserData(a.get("id"), b.get("name"), b.content())
            }, this);
            g.XMLload = 1;
            if (this.waitUpdateXML) {
                this.waitUpdateXML = !1;
                for (var j = g.childsCount - 1; j >= 0; j--)g.childNodes[j]._dmark && this.deleteItem(g.childNodes[j].id)
            }
            for (var i = this._globalIdStorageFind(this.parsingOn),
                     j = 0; j < this.parsedArray.length; j++)g.htmlNode.childNodes[0].appendChild(this.parsedArray[j]);
            this.parsedArray = [];
            this.lastLoadedXMLId = b;
            this.XMLloadingWarning = 0;
            for (var m = this.setCheckList.split(this.dlmtr), l = 0; l < m.length; l++)m[l] && this.setCheck(m[l], 1);
            this.XMLsource && this.tscheck && this.smcheck && g.id != this.rootId && (g.checkstate === 0 ? this._setSubChecked(0, g) : g.checkstate === 1 && this._setSubChecked(1, g));
            this._redrawFrom(this, null, d);
            a.get("order") && a.get("order") != "none" && this._reorderBranch(g, a.get("order"),
                !0);
            this.nodeAskingCall != "" && this.callEvent("onClick", [this.nodeAskingCall, this.getSelectedItemId()]);
            this._branchUpdate && this._branchUpdateNext(a)
        }
        if (this.parsCount == 1) {
            this.parsingOn = null;
            if (!this._edsbps || !this._edsbpsA.length) {
                var k = this;
                window.setTimeout(function () {
                    k.callEvent("onXLE", [k, b])
                }, 1);
                this.xmlstate = 0
            }
            this.skipLock = !1
        }
        this.parsCount--;
        if (!c && this.onXLE)this.onXLE(this, b);
        return this.nodeAskingCall
    }
};
dhtmlXTreeObject.prototype._branchUpdateNext = function (a) {
    a.each("item", function (a) {
        var c = a.get("id");
        if (!this._idpull[c] || this._idpull[c].XMLload)this._branchUpdate++, this.smartRefreshItem(a.get("id"), a)
    }, this);
    this._branchUpdate--
};
dhtmlXTreeObject.prototype.checkUserData = function (a, b) {
    if (a.nodeType == 1 && a.tagName == "userdata") {
        var c = a.getAttribute("name");
        c && a.childNodes[0] && this.setUserData(b, c, a.childNodes[0].data)
    }
};
dhtmlXTreeObject.prototype._redrawFrom = function (a, b, c, d) {
    if (b)f = b; else {
        var f = a._globalIdStorageFind(a.lastLoadedXMLId);
        a.lastLoadedXMLId = -1;
        if (!f)return 0
    }
    for (var e = 0, g = c ? c - 1 : 0; g < f.childsCount; g++) {
        if (!this._branchUpdate || this._getOpenState(f) == 1)if (!b || d == 1)f.childNodes[g].htmlNode.parentNode.parentNode.style.display = "";
        if (f.childNodes[g].openMe == 1)this._openItem(f.childNodes[g]), f.childNodes[g].openMe = 0;
        a._redrawFrom(a, f.childNodes[g])
    }
    if (!f.unParsed && (f.XMLload || !this.XMLsource))f._acc = e;
    a._correctLine(f);
    a._correctPlus(f)
};
dhtmlXTreeObject.prototype._createSelf = function () {
    var a = document.createElement("div");
    a.className = "containerTableStyle";
    a.style.width = this.width;
    a.style.height = this.height;
    this.parentObject.appendChild(a);
    return a
};
dhtmlXTreeObject.prototype._xcloseAll = function (a) {
    if (!a.unParsed) {
        if (this.rootId != a.id) {
            if (!a.htmlNode)return;
            for (var b = a.htmlNode.childNodes[0].childNodes, c = b.length, d = 1; d < c; d++)b[d].style.display = "none";
            this._correctPlus(a)
        }
        for (d = 0; d < a.childsCount; d++)a.childNodes[d].childsCount && this._xcloseAll(a.childNodes[d])
    }
};
dhtmlXTreeObject.prototype._xopenAll = function (a) {
    this._HideShow(a, 2);
    for (var b = 0; b < a.childsCount; b++)this._xopenAll(a.childNodes[b])
};
dhtmlXTreeObject.prototype._correctPlus = function (a) {
    if (a.htmlNode) {
        var b = a.htmlNode.childNodes[0].childNodes[0].childNodes[0].lastChild, c = a.htmlNode.childNodes[0].childNodes[0].childNodes[2].childNodes[0], d = this.lineArray;
        if (this.XMLsource && !a.XMLload) {
            if (d = this.plusArray, this._setSrc(c, this.iconURL + a.images[2]), this._txtimg)return b.innerHTML = "[+]"
        } else if (a.childsCount || a.unParsed)if (a.htmlNode.childNodes[0].childNodes[1] && a.htmlNode.childNodes[0].childNodes[1].style.display != "none") {
            if (!a.wsign)d =
                this.minusArray;
            this._setSrc(c, this.iconURL + a.images[1]);
            if (this._txtimg)return b.innerHTML = "[-]"
        } else {
            if (!a.wsign)d = this.plusArray;
            this._setSrc(c, this.iconURL + a.images[2]);
            if (this._txtimg)return b.innerHTML = "[+]"
        } else this._setSrc(c, this.iconURL + a.images[0]);
        var f = 2;
        a.treeNod.treeLinesOn ? (a.parentObject && (f = this._getCountStatus(a.id, a.parentObject)), this._setSrc(b, this.imPath + d[f])) : this._setSrc(b, this.imPath + d[3])
    }
};
dhtmlXTreeObject.prototype._correctLine = function (a) {
    if (a.htmlNode) {
        var b = a.parentObject;
        if (b)if (this._getLineStatus(a.id, b) == 0 || !this.treeLinesOn)for (var c = 1; c <= a.childsCount; c++) {
            if (!a.htmlNode.childNodes[0].childNodes[c])break;
            a.htmlNode.childNodes[0].childNodes[c].childNodes[0].style.backgroundImage = "";
            a.htmlNode.childNodes[0].childNodes[c].childNodes[0].style.backgroundRepeat = ""
        } else for (c = 1; c <= a.childsCount; c++) {
            if (!a.htmlNode.childNodes[0].childNodes[c])break;
            a.htmlNode.childNodes[0].childNodes[c].childNodes[0].style.backgroundImage =
                "url(" + this.imPath + this.lineArray[5] + ")";
            a.htmlNode.childNodes[0].childNodes[c].childNodes[0].style.backgroundRepeat = "repeat-y"
        }
    }
};
dhtmlXTreeObject.prototype._getCountStatus = function (a, b) {
    return b.childsCount <= 1 ? b.id == this.rootId ? 4 : 0 : b.childNodes[0].id == a ? b.id == this.rootId ? 2 : 1 : b.childNodes[b.childsCount - 1].id == a ? 0 : 1
};
dhtmlXTreeObject.prototype._getLineStatus = function (a, b) {
    return b.childNodes[b.childsCount - 1].id == a ? 0 : 1
};
dhtmlXTreeObject.prototype._HideShow = function (a, b) {
    if (this.XMLsource && !a.XMLload) {
        if (b != 1)a.XMLload = 1, this._loadDynXML(a.id)
    } else {
        var c = a.htmlNode.childNodes[0].childNodes, d = c.length;
        if (d > 1) {
            (c[1].style.display != "none" || b == 1) && b != 2 ? (this.allTree.childNodes[0].border = "1", this.allTree.childNodes[0].border = "0", nodestyle = "none") : nodestyle = "";
            for (var f = 1; f < d; f++)c[f].style.display = nodestyle
        }
        this._correctPlus(a)
    }
};
dhtmlXTreeObject.prototype._getOpenState = function (a) {
    if (!a.htmlNode)return 0;
    var b = a.htmlNode.childNodes[0].childNodes;
    return b.length <= 1 ? 0 : b[1].style.display != "none" ? 1 : -1
};
dhtmlXTreeObject.prototype.onRowClick2 = function () {
    var a = this.parentObject.treeNod;
    if (!a.callEvent("onDblClick", [this.parentObject.id, a]))return!1;
    this.parentObject.closeble && this.parentObject.closeble != "0" ? a._HideShow(this.parentObject) : a._HideShow(this.parentObject, 2);
    if (a.checkEvent("onOpenEnd"))a.xmlstate ? (a._oie_onXLE.push(a.onXLE), a.onXLE = a._epnFHe) : a.callEvent("onOpenEnd", [this.parentObject.id, a._getOpenState(this.parentObject)]);
    return!1
};
dhtmlXTreeObject.prototype.onRowClick = function () {
    var a = this.parentObject.treeNod;
    if (!a.callEvent("onOpenStart", [this.parentObject.id, a._getOpenState(this.parentObject)]))return 0;
    this.parentObject.closeble && this.parentObject.closeble != "0" ? a._HideShow(this.parentObject) : a._HideShow(this.parentObject, 2);
    if (a.checkEvent("onOpenEnd"))a.xmlstate ? (a._oie_onXLE.push(a.onXLE), a.onXLE = a._epnFHe) : a.callEvent("onOpenEnd", [this.parentObject.id, a._getOpenState(this.parentObject)])
};
dhtmlXTreeObject.prototype._epnFHe = function (a, b, c) {
    b != this.rootId && this.callEvent("onOpenEnd", [b, a.getOpenState(b)]);
    a.onXLE = a._oie_onXLE.pop();
    if (!c && !a._oie_onXLE.length && a.onXLE)a.onXLE(a, b)
};
dhtmlXTreeObject.prototype.onRowClickDown = function (a) {
    var a = a || window.event, b = this.parentObject.treeNod;
    b._selectItem(this.parentObject, a)
};
dhtmlXTreeObject.prototype.getSelectedItemId = function () {
    for (var a = [], b = 0; b < this._selected.length; b++)a[b] = this._selected[b].id;
    return a.join(this.dlmtr)
};
dhtmlXTreeObject.prototype._selectItem = function (a) {
    if (this.checkEvent("onSelect"))this._onSSCFold = this.getSelectedItemId();
    this._unselectItems();
    this._markItem(a);
    if (this.checkEvent("onSelect")) {
        var b = this.getSelectedItemId();
        b != this._onSSCFold && this.callEvent("onSelect", [b])
    }
};
dhtmlXTreeObject.prototype._markItem = function (a) {
    if (a.scolor)a.span.style.color = a.scolor;
    a.span.className = "selectedTreeRow";
    a.i_sel = !0;
    this._selected[this._selected.length] = a
};
dhtmlXTreeObject.prototype.getIndexById = function (a) {
    var b = this._globalIdStorageFind(a);
    return!b ? null : this._getIndex(b)
};
dhtmlXTreeObject.prototype._getIndex = function (a) {
    for (var b = a.parentObject, c = 0; c < b.childsCount; c++)if (b.childNodes[c] == a)return c
};
dhtmlXTreeObject.prototype._unselectItem = function (a) {
    if (a && a.i_sel) {
        a.span.className = "standartTreeRow";
        if (a.acolor)a.span.style.color = a.acolor;
        a.i_sel = !1;
        for (var b = 0; b < this._selected.length; b++)if (!this._selected[b].i_sel) {
            this._selected.splice(b, 1);
            break
        }
    }
};
dhtmlXTreeObject.prototype._unselectItems = function () {
    for (var a = 0; a < this._selected.length; a++) {
        var b = this._selected[a];
        b.span.className = "standartTreeRow";
        if (b.acolor)b.span.style.color = b.acolor;
        b.i_sel = !1
    }
    this._selected = []
};
dhtmlXTreeObject.prototype.onRowSelect = function (a, b, c) {
    var a = a || window.event, d = this.parentObject;
    if (b)d = b.parentObject;
    var f = d.treeNod, e = f.getSelectedItemId();
    (!a || !a.skipUnSel) && f._selectItem(d, a);
    c || (d.actionHandler ? d.actionHandler(d.id, e) : f.callEvent("onClick", [d.id, e]))
};
dhtmlXTreeObject.prototype._correctCheckStates = function (a) {
    if (this.tscheck && a && a.id != this.rootId) {
        var b = a.childNodes, c = 0, d = 0;
        if (a.childsCount != 0) {
            for (var f = 0; f < a.childsCount; f++)if (!b[f].dscheck)if (b[f].checkstate == 0)c = 1; else if (b[f].checkstate == 1)d = 1; else {
                d = c = 1;
                break
            }
            c && d ? this._setCheck(a, "unsure") : c ? this._setCheck(a, !1) : this._setCheck(a, !0);
            this._correctCheckStates(a.parentObject)
        }
    }
};
dhtmlXTreeObject.prototype.onCheckBoxClick = function () {
    if (this.treeNod.callEvent("onBeforeCheck", [this.parentObject.id, this.parentObject.checkstate])) {
        if (this.parentObject.dscheck)return!0;
        this.treeNod.tscheck ? this.parentObject.checkstate == 1 ? this.treeNod._setSubChecked(!1, this.parentObject) : this.treeNod._setSubChecked(!0, this.parentObject) : this.parentObject.checkstate == 1 ? this.treeNod._setCheck(this.parentObject, !1) : this.treeNod._setCheck(this.parentObject, !0);
        this.treeNod._correctCheckStates(this.parentObject.parentObject);
        return this.treeNod.callEvent("onCheck", [this.parentObject.id, this.parentObject.checkstate])
    }
};
dhtmlXTreeObject.prototype._createItem = function (a, b, c) {
    var d = document.createElement("table");
    d.cellSpacing = 0;
    d.cellPadding = 0;
    d.border = 0;
    if (this.hfMode)d.style.tableLayout = "fixed";
    d.style.margin = 0;
    d.style.padding = 0;
    var f = document.createElement("tbody"), e = document.createElement("tr"), g = document.createElement("td");
    g.className = "standartTreeImage";
    if (this._txtimg) {
        var h = document.createElement("div");
        g.appendChild(h);
        h.className = "dhx_tree_textSign"
    } else {
        h = this._getImg(b.id);
        h.border = "0";
        if (h.tagName ==
            "IMG")h.align = "absmiddle";
        g.appendChild(h);
        h.style.padding = 0;
        h.style.margin = 0;
        h.style.width = this.def_line_img_x;
        h.style.height = this.def_line_img_y
    }
    var j = document.createElement("td"), i = this._getImg(this.cBROf ? this.rootId : b.id);
    i.checked = 0;
    this._setSrc(i, this.imPath + this.checkArray[0]);
    i.style.width = "16px";
    i.style.height = "16px";
    if (!a)(!_isIE ? j : i).style.display = "none";
    j.appendChild(i);
    if (!this.cBROf && i.tagName == "IMG")i.align = "absmiddle";
    i.onclick = this.onCheckBoxClick;
    i.treeNod = this;
    i.parentObject = b;
    j.width = window._KHTMLrv ? "16px" : "20px";
    var m = document.createElement("td");
    m.className = "standartTreeImage";
    var l = this._getImg(this.timgen ? b.id : this.rootId);
    l.onmousedown = this._preventNsDrag;
    l.ondragstart = this._preventNsDrag;
    l.border = "0";
    if (this._aimgs) {
        l.parentObject = b;
        if (l.tagName == "IMG")l.align = "absmiddle";
        l.onclick = this.onRowSelect
    }
    c || this._setSrc(l, this.iconURL + this.imageArray[0]);
    m.appendChild(l);
    l.style.padding = 0;
    l.style.margin = 0;
    if (this.timgen)m.style.width = l.style.width = this.def_img_x, l.style.height =
        this.def_img_y; else if (l.style.width = "0px", l.style.height = "0px", _isOpera || window._KHTMLrv)m.style.display = "none";
    var k = document.createElement("td");
    k.className = "standartTreeRow";
    b.span = document.createElement("span");
    b.span.className = "standartTreeRow";
    this.mlitems ? (b.span.style.width = this.mlitems, b.span.style.display = "block") : k.noWrap = !0;
    if (_isIE && _isIE > 7)k.style.width = "999999px"; else if (!window._KHTMLrv)k.style.width = "100%";
    b.span.innerHTML = b.label;
    k.appendChild(b.span);
    k.parentObject = b;
    g.parentObject =
        b;
    k.onclick = this.onRowSelect;
    g.onclick = this.onRowClick;
    k.ondblclick = this.onRowClick2;
    if (this.ettip)e.title = b.label;
    if (this.dragAndDropOff) {
        if (this._aimgs)this.dragger.addDraggableItem(m, this), m.parentObject = b;
        this.dragger.addDraggableItem(k, this)
    }
    b.span.style.paddingLeft = "5px";
    b.span.style.paddingRight = "5px";
    k.style.verticalAlign = "";
    k.style.fontSize = "10pt";
    k.style.cursor = this.style_pointer;
    e.appendChild(g);
    e.appendChild(j);
    e.appendChild(m);
    e.appendChild(k);
    f.appendChild(e);
    d.appendChild(f);
    if (this.ehlt ||
        this.checkEvent("onMouseIn") || this.checkEvent("onMouseOut"))e.onmousemove = this._itemMouseIn, e[_isIE ? "onmouseleave" : "onmouseout"] = this._itemMouseOut;
    return d
};
dhtmlXTreeObject.prototype.setImagePath = function (a) {
    this.iconURL = this.imPath = a
};
dhtmlXTreeObject.prototype.setIconPath = function (a) {
    this.iconURL = a
};
dhtmlXTreeObject.prototype.setOnRightClickHandler = function (a) {
    this.attachEvent("onRightClick", a)
};
dhtmlXTreeObject.prototype.setOnClickHandler = function (a) {
    this.attachEvent("onClick", a)
};
dhtmlXTreeObject.prototype.setOnSelectStateChange = function (a) {
    this.attachEvent("onSelect", a)
};
dhtmlXTreeObject.prototype.setXMLAutoLoading = function (a) {
    this.XMLsource = a
};
dhtmlXTreeObject.prototype.setOnCheckHandler = function (a) {
    this.attachEvent("onCheck", a)
};
dhtmlXTreeObject.prototype.setOnOpenHandler = function (a) {
    this.attachEvent("onOpenStart", a)
};
dhtmlXTreeObject.prototype.setOnOpenStartHandler = function (a) {
    this.attachEvent("onOpenStart", a)
};
dhtmlXTreeObject.prototype.setOnOpenEndHandler = function (a) {
    this.attachEvent("onOpenEnd", a)
};
dhtmlXTreeObject.prototype.setOnDblClickHandler = function (a) {
    this.attachEvent("onDblClick", a)
};
dhtmlXTreeObject.prototype.openAllItems = function (a) {
    var b = this._globalIdStorageFind(a);
    if (!b)return 0;
    this._xopenAll(b)
};
dhtmlXTreeObject.prototype.getOpenState = function (a) {
    var b = this._globalIdStorageFind(a);
    return!b ? "" : this._getOpenState(b)
};
dhtmlXTreeObject.prototype.closeAllItems = function (a) {
    if (a === window.undefined)a = this.rootId;
    var b = this._globalIdStorageFind(a);
    if (!b)return 0;
    this._xcloseAll(b);
    this.allTree.childNodes[0].border = "1";
    this.allTree.childNodes[0].border = "0"
};
dhtmlXTreeObject.prototype.setUserData = function (a, b, c) {
    var d = this._globalIdStorageFind(a, 0, !0);
    if (d) {
        if (b == "hint")d.htmlNode.childNodes[0].childNodes[0].title = c;
        if (typeof d.userData["t_" + b] == "undefined")d._userdatalist ? d._userdatalist += "," + b : d._userdatalist = b;
        d.userData["t_" + b] = c
    }
};
dhtmlXTreeObject.prototype.getUserData = function (a, b) {
    var c = this._globalIdStorageFind(a, 0, !0);
    return!c ? void 0 : c.userData["t_" + b]
};
dhtmlXTreeObject.prototype.getItemColor = function (a) {
    var b = this._globalIdStorageFind(a);
    if (!b)return 0;
    var c = {};
    if (b.acolor)c.acolor = b.acolor;
    if (b.scolor)c.scolor = b.scolor;
    return c
};
dhtmlXTreeObject.prototype.setItemColor = function (a, b, c) {
    var d = a && a.span ? a : this._globalIdStorageFind(a);
    if (d) {
        if (d.i_sel) {
            if (c)d.span.style.color = c
        } else if (b)d.span.style.color = b;
        if (c)d.scolor = c;
        if (b)d.acolor = b
    } else return 0
};
dhtmlXTreeObject.prototype.getItemText = function (a) {
    var b = this._globalIdStorageFind(a);
    return!b ? 0 : b.htmlNode.childNodes[0].childNodes[0].childNodes[3].childNodes[0].innerHTML
};
dhtmlXTreeObject.prototype.getParentId = function (a) {
    var b = this._globalIdStorageFind(a);
    return!b || !b.parentObject ? "" : b.parentObject.id
};
dhtmlXTreeObject.prototype.changeItemId = function (a, b) {
    if (a != b) {
        var c = this._globalIdStorageFind(a);
        if (!c)return 0;
        c.id = b;
        c.span.contextMenuId = b;
        this._idpull[b] = this._idpull[a];
        delete this._idpull[a]
    }
};
dhtmlXTreeObject.prototype.doCut = function () {
    this.nodeCut && this.clearCut();
    this.nodeCut = [].concat(this._selected);
    for (var a = 0; a < this.nodeCut.length; a++) {
        var b = this.nodeCut[a];
        b._cimgs = [];
        b._cimgs[0] = b.images[0];
        b._cimgs[1] = b.images[1];
        b._cimgs[2] = b.images[2];
        b.images[0] = b.images[1] = b.images[2] = this.cutImage;
        this._correctPlus(b)
    }
};
dhtmlXTreeObject.prototype.doPaste = function (a) {
    var b = this._globalIdStorageFind(a);
    if (!b)return 0;
    for (var c = 0; c < this.nodeCut.length; c++)this._checkPNodes(b, this.nodeCut[c]) || this._moveNode(this.nodeCut[c], b);
    this.clearCut()
};
dhtmlXTreeObject.prototype.clearCut = function () {
    for (var a = 0; a < this.nodeCut.length; a++) {
        var b = this.nodeCut[a];
        b.images[0] = b._cimgs[0];
        b.images[1] = b._cimgs[1];
        b.images[2] = b._cimgs[2];
        this._correctPlus(b)
    }
    this.nodeCut = []
};
dhtmlXTreeObject.prototype._moveNode = function (a, b) {
    return this._moveNodeTo(a, b)
};
dhtmlXTreeObject.prototype._fixNodesCollection = function (a, b) {
    var c = 0, d = 0, f = a.childNodes, e = a.childsCount - 1;
    if (b != f[e]) {
        for (var g = 0; g < e; g++)f[g] == f[e] && (f[g] = f[g + 1], f[g + 1] = f[e]);
        for (g = 0; g < e + 1; g++)if (c) {
            var h = f[g];
            f[g] = c;
            c = h
        } else f[g] == b && (c = f[g], f[g] = f[e])
    }
};
dhtmlXTreeObject.prototype._recreateBranch = function (a, b, c) {
    var d, f = "";
    if (c) {
        for (d = 0; d < b.childsCount; d++)if (b.childNodes[d] == c)break;
        d != 0 ? c = b.childNodes[d - 1] : (f = "TOP", c = "")
    }
    var e = this._onradh;
    this._onradh = null;
    var g = this._attachChildNode(b, a.id, a.label, 0, a.images[0], a.images[1], a.images[2], f, 0, c);
    g._userdatalist = a._userdatalist;
    g.userData = a.userData.clone();
    if (a._attrs) {
        g._attrs = {};
        for (var h in a._attrs)g._attrs[h] = a._attrs[h]
    }
    g.XMLload = a.XMLload;
    if (e)this._onradh = e, this._onradh(g.id);
    for (d = 0; d < a.childsCount; d++)this._recreateBranch(a.childNodes[d],
        g, 0, 1);
    return g
};
dhtmlXTreeObject.prototype._moveNodeTo = function (a, b, c) {
    if (a.treeNod._nonTrivialNode)return a.treeNod._nonTrivialNode(this, b, c, a);
    if (this._checkPNodes(b, a))return!1;
    var d = b.mytype ? a.treeNod.lWin != b.lWin : a.treeNod.lWin != b.treeNod.lWin;
    if (!this.callEvent("onDrag", [a.id, b.id, c ? c.id : null, a.treeNod, b.treeNod]))return!1;
    if (b.XMLload == 0 && this.XMLsource)b.XMLload = 1, this._loadDynXML(b.id);
    this.openItem(b.id);
    var f = a.treeNod, e = a.parentObject.childsCount, g = a.parentObject;
    if (d || f.dpcpy) {
        var h = a.id, a = this._recreateBranch(a,
            b, c);
        f.dpcpy || f.deleteItem(h)
    } else {
        var j = b.childsCount, i = b.childNodes;
        if (j == 0)b._open = !0;
        f._unselectItem(a);
        i[j] = a;
        a.treeNod = b.treeNod;
        b.childsCount++;
        var m = this._drawNewTr(i[j].htmlNode);
        c ? (b.htmlNode.childNodes[0].insertBefore(m, c.tr), this._fixNodesCollection(b, c), i = b.childNodes) : (b.htmlNode.childNodes[0].appendChild(m), this.dadmode == 1 && this._fixNodesCollection(b, c))
    }
    if (!f.dpcpy && !d) {
        var l = a.tr;
        document.all && navigator.appVersion.search(/MSIE\ 5\.0/gi) != -1 ? window.setTimeout(function () {
                l.parentNode.removeChild(l)
            },
            250) : a.parentObject.htmlNode.childNodes[0].removeChild(a.tr);
        if (!c || b != a.parentObject)for (var k = 0; k < g.childsCount; k++) {
            if (g.childNodes[k].id == a.id) {
                g.childNodes[k] = 0;
                break
            }
        } else g.childNodes[g.childsCount - 1] = 0;
        f._compressChildList(g.childsCount, g.childNodes);
        g.childsCount--
    }
    if (!d && !f.dpcpy) {
        a.tr = m;
        m.nodem = a;
        a.parentObject = b;
        if (f != b.treeNod) {
            if (a.treeNod._registerBranch(a, f))return;
            this._clearStyles(a);
            this._redrawFrom(this, a.parentObject);
            this._onradh && this._onradh(a.id)
        }
        this._correctPlus(b);
        this._correctLine(b);
        this._correctLine(a);
        this._correctPlus(a);
        c ? this._correctPlus(c) : b.childsCount >= 2 && (this._correctPlus(i[b.childsCount - 2]), this._correctLine(i[b.childsCount - 2]));
        this._correctPlus(i[b.childsCount - 1]);
        this.tscheck && this._correctCheckStates(b);
        f.tscheck && f._correctCheckStates(g)
    }
    e > 1 && (f._correctPlus(g.childNodes[e - 2]), f._correctLine(g.childNodes[e - 2]));
    f._correctPlus(g);
    f._correctLine(g);
    this.callEvent("onDrop", [a.id, b.id, c ? c.id : null, f, b.treeNod]);
    return a.id
};
dhtmlXTreeObject.prototype._clearStyles = function (a) {
    if (a.htmlNode) {
        var b = a.htmlNode.childNodes[0].childNodes[0].childNodes[1], c = b.nextSibling.nextSibling;
        a.span.innerHTML = a.label;
        a.i_sel = !1;
        a._aimgs && this.dragger.removeDraggableItem(b.nextSibling);
        this.checkBoxOff ? (b.childNodes[0].style.display = "", b.childNodes[0].onclick = this.onCheckBoxClick, this._setSrc(b.childNodes[0], this.imPath + this.checkArray[a.checkstate])) : b.childNodes[0].style.display = "none";
        b.childNodes[0].treeNod = this;
        this.dragger.removeDraggableItem(c);
        this.dragAndDropOff && this.dragger.addDraggableItem(c, this);
        this._aimgs && this.dragger.addDraggableItem(b.nextSibling, this);
        c.childNodes[0].className = "standartTreeRow";
        c.onclick = this.onRowSelect;
        c.ondblclick = this.onRowClick2;
        b.previousSibling.onclick = this.onRowClick;
        this._correctLine(a);
        this._correctPlus(a);
        for (var d = 0; d < a.childsCount; d++)this._clearStyles(a.childNodes[d])
    }
};
dhtmlXTreeObject.prototype._registerBranch = function (a, b) {
    b && b._globalIdStorageSub(a.id);
    a.id = this._globalIdStorageAdd(a.id, a);
    a.treeNod = this;
    for (var c = 0; c < a.childsCount; c++)this._registerBranch(a.childNodes[c], b);
    return 0
};
dhtmlXTreeObject.prototype.enableThreeStateCheckboxes = function (a) {
    this.tscheck = convertStringToBoolean(a)
};
dhtmlXTreeObject.prototype.setOnMouseInHandler = function (a) {
    this.ehlt = !0;
    this.attachEvent("onMouseIn", a)
};
dhtmlXTreeObject.prototype.setOnMouseOutHandler = function (a) {
    this.ehlt = !0;
    this.attachEvent("onMouseOut", a)
};
dhtmlXTreeObject.prototype.enableTreeImages = function (a) {
    this.timgen = convertStringToBoolean(a)
};
dhtmlXTreeObject.prototype.enableFixedMode = function (a) {
    this.hfMode = convertStringToBoolean(a)
};
dhtmlXTreeObject.prototype.enableCheckBoxes = function (a, b) {
    this.checkBoxOff = convertStringToBoolean(a);
    this.cBROf = !(this.checkBoxOff || convertStringToBoolean(b))
};
dhtmlXTreeObject.prototype.setStdImages = function (a, b, c) {
    this.imageArray[0] = a;
    this.imageArray[1] = b;
    this.imageArray[2] = c
};
dhtmlXTreeObject.prototype.enableTreeLines = function (a) {
    this.treeLinesOn = convertStringToBoolean(a)
};
dhtmlXTreeObject.prototype.setImageArrays = function (a, b, c, d, f, e) {
    switch (a) {
        case "plus":
            this.plusArray[0] = b;
            this.plusArray[1] = c;
            this.plusArray[2] = d;
            this.plusArray[3] = f;
            this.plusArray[4] = e;
            break;
        case "minus":
            this.minusArray[0] = b, this.minusArray[1] = c, this.minusArray[2] = d, this.minusArray[3] = f, this.minusArray[4] = e
    }
};
dhtmlXTreeObject.prototype.openItem = function (a) {
    var b = this._globalIdStorageFind(a);
    return b ? this._openItem(b) : 0
};
dhtmlXTreeObject.prototype._openItem = function (a) {
    var b = this._getOpenState(a);
    if (b < 0 || this.XMLsource && !a.XMLload) {
        if (!this.callEvent("onOpenStart", [a.id, b]))return 0;
        this._HideShow(a, 2);
        if (this.checkEvent("onOpenEnd"))this.onXLE == this._epnFHe && this._epnFHe(this, a.id, !0), !this.xmlstate || !this.XMLsource ? this.callEvent("onOpenEnd", [a.id, this._getOpenState(a)]) : (this._oie_onXLE.push(this.onXLE), this.onXLE = this._epnFHe)
    } else this._srnd && this._HideShow(a, 2);
    a.parentObject && !this._skip_open_parent && this._openItem(a.parentObject)
};
dhtmlXTreeObject.prototype.closeItem = function (a) {
    if (this.rootId == a)return 0;
    var b = this._globalIdStorageFind(a);
    if (!b)return 0;
    b.closeble && this._HideShow(b, 1)
};
dhtmlXTreeObject.prototype.getLevel = function (a) {
    var b = this._globalIdStorageFind(a);
    return!b ? 0 : this._getNodeLevel(b, 0)
};
dhtmlXTreeObject.prototype.setItemCloseable = function (a, b) {
    var b = convertStringToBoolean(b), c = a && a.span ? a : this._globalIdStorageFind(a);
    if (!c)return 0;
    c.closeble = b
};
dhtmlXTreeObject.prototype._getNodeLevel = function (a, b) {
    return a.parentObject ? this._getNodeLevel(a.parentObject, b + 1) : b
};
dhtmlXTreeObject.prototype.hasChildren = function (a) {
    var b = this._globalIdStorageFind(a);
    return b ? this.XMLsource && !b.XMLload ? !0 : b.childsCount : 0
};
dhtmlXTreeObject.prototype._getLeafCount = function (a) {
    for (var b = 0, c = 0; c < a.childsCount; c++)a.childNodes[c].childsCount == 0 && b++;
    return b
};
dhtmlXTreeObject.prototype.setItemText = function (a, b, c) {
    var d = this._globalIdStorageFind(a);
    if (!d)return 0;
    d.label = b;
    d.span.innerHTML = b;
    d.span.parentNode.parentNode.title = c || ""
};
dhtmlXTreeObject.prototype.getItemTooltip = function (a) {
    var b = this._globalIdStorageFind(a);
    return!b ? "" : b.span.parentNode.parentNode._dhx_title || b.span.parentNode.parentNode.title || ""
};
dhtmlXTreeObject.prototype.refreshItem = function (a) {
    if (!a)a = this.rootId;
    var b = this._globalIdStorageFind(a);
    this.deleteChildItems(a);
    this._loadDynXML(a)
};
dhtmlXTreeObject.prototype.setItemImage2 = function (a, b, c, d) {
    var f = this._globalIdStorageFind(a);
    if (!f)return 0;
    f.images[1] = c;
    f.images[2] = d;
    f.images[0] = b;
    this._correctPlus(f)
};
dhtmlXTreeObject.prototype.setItemImage = function (a, b, c) {
    var d = this._globalIdStorageFind(a);
    if (!d)return 0;
    c ? (d.images[1] = b, d.images[2] = c) : d.images[0] = b;
    this._correctPlus(d)
};
dhtmlXTreeObject.prototype.getSubItems = function (a) {
    var b = this._globalIdStorageFind(a, 0, 1);
    if (!b)return 0;
    var c = "";
    for (i = 0; i < b.childsCount; i++)c ? c += this.dlmtr + b.childNodes[i].id : c = b.childNodes[i].id;
    return c
};
dhtmlXTreeObject.prototype._getAllScraggyItems = function (a) {
    for (var b = "", c = 0; c < a.childsCount; c++)if (a.childNodes[c].unParsed || a.childNodes[c].childsCount > 0) {
        var d = a.childNodes[c].unParsed ? this._getAllScraggyItemsXML(a.childNodes[c].unParsed, 1) : this._getAllScraggyItems(a.childNodes[c]);
        d && (b ? b += this.dlmtr + d : b = d)
    } else b ? b += this.dlmtr + a.childNodes[c].id : b = a.childNodes[c].id;
    return b
};
dhtmlXTreeObject.prototype._getAllFatItems = function (a) {
    for (var b = "", c = 0; c < a.childsCount; c++)if (a.childNodes[c].unParsed || a.childNodes[c].childsCount > 0) {
        b ? b += this.dlmtr + a.childNodes[c].id : b = a.childNodes[c].id;
        var d = a.childNodes[c].unParsed ? this._getAllFatItemsXML(a.childNodes[c].unParsed, 1) : this._getAllFatItems(a.childNodes[c]);
        d && (b += this.dlmtr + d)
    }
    return b
};
dhtmlXTreeObject.prototype._getAllSubItems = function (a, b, c) {
    var d = c ? c : this._globalIdStorageFind(a);
    if (!d)return 0;
    for (var b = "", f = 0; f < d.childsCount; f++) {
        b ? b += this.dlmtr + d.childNodes[f].id : b = d.childNodes[f].id;
        var e = this._getAllSubItems(0, b, d.childNodes[f]);
        e && (b += this.dlmtr + e)
    }
    return b
};
dhtmlXTreeObject.prototype.selectItem = function (a, b, c) {
    var b = convertStringToBoolean(b), d = this._globalIdStorageFind(a);
    if (!d || !d.parentObject)return 0;
    this.XMLloadingWarning ? d.parentObject.openMe = 1 : this._openItem(d.parentObject);
    var f = null;
    if (c && (f = {ctrlKey: !0}, d.i_sel))f.skipUnSel = !0;
    if (b)this.onRowSelect(f, d.htmlNode.childNodes[0].childNodes[0].childNodes[3], !1); else this.onRowSelect(f, d.htmlNode.childNodes[0].childNodes[0].childNodes[3], !0)
};
dhtmlXTreeObject.prototype.getSelectedItemText = function () {
    for (var a = [], b = 0; b < this._selected.length; b++)a[b] = this._selected[b].span.innerHTML;
    return a.join(this.dlmtr)
};
dhtmlXTreeObject.prototype._compressChildList = function (a, b) {
    a--;
    for (var c = 0; c < a; c++)b[c] == 0 && (b[c] = b[c + 1], b[c + 1] = 0)
};
dhtmlXTreeObject.prototype._deleteNode = function (a, b, c) {
    if (!b || !b.parentObject)return 0;
    var d = 0, f = 0;
    if (b.tr.nextSibling)d = b.tr.nextSibling.nodem;
    if (b.tr.previousSibling)f = b.tr.previousSibling.nodem;
    for (var e = b.parentObject, g = e.childsCount, h = e.childNodes, j = 0; j < g; j++)if (h[j].id == a) {
        c || e.htmlNode.childNodes[0].removeChild(h[j].tr);
        h[j] = 0;
        break
    }
    this._compressChildList(g, h);
    c || e.childsCount--;
    d && (this._correctPlus(d), this._correctLine(d));
    f && (this._correctPlus(f), this._correctLine(f));
    this.tscheck && this._correctCheckStates(e);
    c || this._globalIdStorageRecSub(b)
};
dhtmlXTreeObject.prototype.setCheck = function (a, b) {
    var c = this._globalIdStorageFind(a, 0, 1);
    c && (b === "unsure" ? this._setCheck(c, b) : (b = convertStringToBoolean(b), this.tscheck && this.smcheck ? this._setSubChecked(b, c) : this._setCheck(c, b)), this.smcheck && this._correctCheckStates(c.parentObject))
};
dhtmlXTreeObject.prototype._setCheck = function (a, b) {
    if (a) {
        if ((a.parentObject._r_logic || this._frbtr) && b)if (this._frbtrs)this._frbtrL && this.setCheck(this._frbtrL.id, 0), this._frbtrL = a; else for (var c = 0; c < a.parentObject.childsCount; c++)this._setCheck(a.parentObject.childNodes[c], 0);
        var d = a.htmlNode.childNodes[0].childNodes[0].childNodes[1].childNodes[0];
        a.checkstate = b == "unsure" ? 2 : b ? 1 : 0;
        if (a.dscheck)a.checkstate = a.dscheck;
        this._setSrc(d, this.imPath + (a.parentObject._r_logic || this._frbtr ? this.radioArray : this.checkArray)[a.checkstate])
    }
};
dhtmlXTreeObject.prototype.setSubChecked = function (a, b) {
    var c = this._globalIdStorageFind(a);
    this._setSubChecked(b, c);
    this._correctCheckStates(c.parentObject)
};
dhtmlXTreeObject.prototype._setSubChecked = function (a, b) {
    a = convertStringToBoolean(a);
    if (b) {
        if ((b.parentObject._r_logic || this._frbtr) && a)for (var c = 0; c < b.parentObject.childsCount; c++)this._setSubChecked(0, b.parentObject.childNodes[c]);
        if (b._r_logic || this._frbtr)this._setSubChecked(a, b.childNodes[0]); else for (c = 0; c < b.childsCount; c++)this._setSubChecked(a, b.childNodes[c]);
        var d = b.htmlNode.childNodes[0].childNodes[0].childNodes[1].childNodes[0];
        b.checkstate = a ? 1 : 0;
        if (b.dscheck)b.checkstate = b.dscheck;
        this._setSrc(d,
            this.imPath + (b.parentObject._r_logic || this._frbtr ? this.radioArray : this.checkArray)[b.checkstate])
    }
};
dhtmlXTreeObject.prototype.isItemChecked = function (a) {
    var b = this._globalIdStorageFind(a);
    return!b ? void 0 : b.checkstate
};
dhtmlXTreeObject.prototype.deleteChildItems = function (a) {
    var b = this._globalIdStorageFind(a);
    if (b)for (var c = b.childsCount, d = 0; d < c; d++)this._deleteNode(b.childNodes[0].id, b.childNodes[0])
};
dhtmlXTreeObject.prototype.deleteItem = function (a, b) {
    if (!this._onrdlh || this._onrdlh(a))var c = this._deleteItem(a, b);
    this.allTree.childNodes[0].border = "1";
    this.allTree.childNodes[0].border = "0"
};
dhtmlXTreeObject.prototype._deleteItem = function (a, b, c) {
    var b = convertStringToBoolean(b), d = this._globalIdStorageFind(a);
    if (d) {
        var f = this.getParentId(a), e = d.parentObject;
        this._deleteNode(a, d, c);
        if (this._editCell && this._editCell.id == a)this._editCell = null;
        this._correctPlus(e);
        this._correctLine(e);
        b && f != this.rootId && this.selectItem(f, 1);
        return e
    }
};
dhtmlXTreeObject.prototype._globalIdStorageRecSub = function (a) {
    for (var b = 0; b < a.childsCount; b++)this._globalIdStorageRecSub(a.childNodes[b]), this._globalIdStorageSub(a.childNodes[b].id);
    this._globalIdStorageSub(a.id);
    var c = a;
    c.span = null;
    c.tr.nodem = null;
    c.tr = null;
    c.htmlNode = null
};
dhtmlXTreeObject.prototype.insertNewNext = function (a, b, c, d, f, e, g, h, j) {
    var i = this._globalIdStorageFind(a);
    if (!i || !i.parentObject)return 0;
    var m = this._attachChildNode(0, b, c, d, f, e, g, h, j, i);
    return m
};
dhtmlXTreeObject.prototype.getItemIdByIndex = function (a, b) {
    var c = this._globalIdStorageFind(a);
    return!c || b >= c.childsCount ? null : c.childNodes[b].id
};
dhtmlXTreeObject.prototype.getChildItemIdByIndex = function (a, b) {
    var c = this._globalIdStorageFind(a);
    return!c || b >= c.childsCount ? null : c.childNodes[b].id
};
dhtmlXTreeObject.prototype.setDragHandler = function (a) {
    this.attachEvent("onDrag", a)
};
dhtmlXTreeObject.prototype._clearMove = function () {
    if (this._lastMark)this._lastMark.className = this._lastMark.className.replace(/dragAndDropRow/g, ""), this._lastMark = null;
    this.allTree.className = this.allTree.className.replace(" selectionBox", "")
};
dhtmlXTreeObject.prototype.enableDragAndDrop = function (a, b) {
    a == "temporary_disabled" ? (this.dADTempOff = !1, a = !0) : this.dADTempOff = !0;
    (this.dragAndDropOff = convertStringToBoolean(a)) && this.dragger.addDragLanding(this.allTree, this);
    if (arguments.length > 1)this._ddronr = !convertStringToBoolean(b)
};
dhtmlXTreeObject.prototype._setMove = function (a) {
    if (a.parentObject.span) {
        var b = getAbsoluteTop(a), c = getAbsoluteTop(this.allTree) - this.allTree.scrollTop;
        this.dadmodec = this.dadmode;
        this.dadmodefix = 0;
        var d = a.parentObject.span;
        d.className += " dragAndDropRow";
        this._lastMark = d;
        this._autoScroll(null, b, c)
    }
};
dhtmlXTreeObject.prototype._autoScroll = function (a, b, c) {
    if (this.autoScroll) {
        a && (b = getAbsoluteTop(a), c = getAbsoluteTop(this.allTree) - this.allTree.scrollTop);
        if (b - c - parseInt(this.allTree.scrollTop) > parseInt(this.allTree.offsetHeight) - 50)this.allTree.scrollTop = parseInt(this.allTree.scrollTop) + 20;
        if (b - c < parseInt(this.allTree.scrollTop) + 30)this.allTree.scrollTop = parseInt(this.allTree.scrollTop) - 20
    }
};
dhtmlXTreeObject.prototype._createDragNode = function (a, b) {
    if (!this.dADTempOff)return null;
    var c = a.parentObject;
    if (!this.callEvent("onBeforeDrag", [c.id, b]))return null;
    c.i_sel || this._selectItem(c, b);
    var d = document.createElement("div"), f = [];
    if (this._itim_dg)for (var e = 0; e < this._selected.length; e++)f[e] = "<table cellspacing='0' cellpadding='0'><tr><td><img width='18px' height='18px' src='" + this._getSrc(this._selected[e].span.parentNode.previousSibling.childNodes[0]) + "'></td><td>" + this._selected[e].span.innerHTML +
        "</td></tr></table>"; else f = this.getSelectedItemText().split(this.dlmtr);
    d.innerHTML = f.join("");
    d.style.position = "absolute";
    d.className = "dragSpanDiv";
    this._dragged = [].concat(this._selected);
    return d
};
dhtmlXTreeObject.prototype._focusNode = function (a) {
    var b = getAbsoluteTop(a.htmlNode) - getAbsoluteTop(this.allTree);
    if (b > this.allTree.offsetHeight - 30 || b < 0)this.allTree.scrollTop = b + this.allTree.scrollTop
};
dhtmlXTreeObject.prototype._preventNsDrag = function (a) {
    a && a.preventDefault && a.preventDefault();
    return!1
};
dhtmlXTreeObject.prototype._drag = function (a, b, c) {
    this._autoOpenTimer && clearTimeout(this._autoOpenTimer);
    if (!c.parentObject)c = this.htmlNode.htmlNode.childNodes[0].childNodes[0].childNodes[1].childNodes[0], this.dadmodec = 0;
    this._clearMove();
    var d = a.parentObject.treeNod;
    d && d._clearMove && d._clearMove("");
    if (!this.dragMove || this.dragMove())for (var f = !d || !d._clearMove || !d._dragged ? Array(a.parentObject) : d._dragged, e = c.parentObject, g = 0; g < f.length; g++) {
        var h = this._moveNode(f[g], e);
        this.dadmodec && h !== !1 && (e =
            this._globalIdStorageFind(h, !0, !0));
        h && !this._sADnD && this.selectItem(h, 0, 1)
    }
    if (d)d._dragged = []
};
dhtmlXTreeObject.prototype._dragIn = function (a, b, c, d) {
    if (!this.dADTempOff)return 0;
    var f = b.parentObject, e = a.parentObject;
    if (e || !this._ddronr) {
        if (!this.callEvent("onDragIn", [f.id, e ? e.id : null, f.treeNod, this]))return e && this._autoScroll(a), 0;
        if (e) {
            if (f.childNodes == null)return this._setMove(a, c, d), a;
            for (var g = f.treeNod, h = 0; h < g._dragged.length; h++)if (this._checkPNodes(e, g._dragged[h]))return this._autoScroll(a), 0;
            this._setMove(a, c, d);
            if (this._getOpenState(e) <= 0)this._autoOpenId = e.id, this._autoOpenTimer =
                window.setTimeout(new callerFunction(this._autoOpenItem, this), 1E3)
        } else this.allTree.className += " selectionBox";
        return a
    }
};
dhtmlXTreeObject.prototype._autoOpenItem = function (a, b) {
    b.openItem(b._autoOpenId)
};
dhtmlXTreeObject.prototype._dragOut = function () {
    this._clearMove();
    this._autoOpenTimer && clearTimeout(this._autoOpenTimer)
};
dhtmlXTreeObject.prototype.moveItem = function (a, b, c, d) {
    var f = this._globalIdStorageFind(a);
    if (!f)return 0;
    switch (b) {
        case "right":
            alert("Not supported yet");
            break;
        case "item_child":
            var e = (d || this)._globalIdStorageFind(c);
            if (!e)return 0;
            (d || this)._moveNodeTo(f, e, 0);
            break;
        case "item_sibling":
            e = (d || this)._globalIdStorageFind(c);
            if (!e)return 0;
            (d || this)._moveNodeTo(f, e.parentObject, e);
            break;
        case "item_sibling_next":
            e = (d || this)._globalIdStorageFind(c);
            if (!e)return 0;
            e.tr && e.tr.nextSibling && e.tr.nextSibling.nodem ?
                (d || this)._moveNodeTo(f, e.parentObject, e.tr.nextSibling.nodem) : (d || this)._moveNodeTo(f, e.parentObject);
            break;
        case "left":
            f.parentObject.parentObject && this._moveNodeTo(f, f.parentObject.parentObject, f.parentObject);
            break;
        case "up":
            var g = this._getPrevNode(f);
            if (g == -1 || !g.parentObject)return;
            this._moveNodeTo(f, g.parentObject, g);
            break;
        case "up_strict":
            g = this._getIndex(f);
            g != 0 && this._moveNodeTo(f, f.parentObject, f.parentObject.childNodes[g - 1]);
            break;
        case "down_strict":
            var g = this._getIndex(f), h = f.parentObject.childsCount -
                2;
            g == h ? this._moveNodeTo(f, f.parentObject) : g < h && this._moveNodeTo(f, f.parentObject, f.parentObject.childNodes[g + 2]);
            break;
        case "down":
            g = this._getNextNode(this._lastChild(f));
            if (g == -1 || !g.parentObject)return;
            g.parentObject == f.parentObject && (g = this._getNextNode(g));
            if (g == -1)this._moveNodeTo(f, f.parentObject); else {
                if (g == -1 || !g.parentObject)return;
                this._moveNodeTo(f, g.parentObject, g)
            }
    }
    if (_isIE && _isIE < 8)this.allTree.childNodes[0].border = "1", this.allTree.childNodes[0].border = "0"
};
dhtmlXTreeObject.prototype._loadDynXML = function (a, b) {
    var b = b || this.XMLsource, c = (new Date).valueOf();
    this._ld_id = a;
    this.loadXML(b + getUrlSymbol(b) + "uid=" + c + "&id=" + this._escape(a))
};
dhtmlXTreeObject.prototype._checkPNodes = function (a, b) {
    return this._dcheckf ? !1 : b == a ? 1 : a.parentObject ? this._checkPNodes(a.parentObject, b) : 0
};
dhtmlXTreeObject.prototype.disableDropCheck = function (a) {
    this._dcheckf = convertStringToBoolean(a)
};
dhtmlXTreeObject.prototype.preventIECaching = function (a) {
    this.no_cashe = convertStringToBoolean(a);
    this.XMLLoader.rSeed = this.no_cashe
};
dhtmlXTreeObject.prototype.preventIECashing = dhtmlXTreeObject.prototype.preventIECaching;
dhtmlXTreeObject.prototype.disableCheckbox = function (a, b) {
    var c = typeof a != "object" ? this._globalIdStorageFind(a, 0, 1) : a;
    if (c && (c.dscheck = convertStringToBoolean(b) ? (c.checkstate || 0) % 3 + 3 : c.checkstate > 2 ? c.checkstate - 3 : c.checkstate, this._setCheck(c), c.dscheck < 3))c.dscheck = !1
};
dhtmlXTreeObject.prototype.setEscapingMode = function (a) {
    this.utfesc = a
};
dhtmlXTreeObject.prototype.enableHighlighting = function (a) {
    this.ehlt = !0;
    this.ehlta = convertStringToBoolean(a)
};
dhtmlXTreeObject.prototype._itemMouseOut = function () {
    var a = this.childNodes[3].parentObject, b = a.treeNod;
    b.callEvent("onMouseOut", [a.id]);
    if (a.id == b._l_onMSI)b._l_onMSI = null;
    if (b.ehlta)a.span.className = a.span.className.replace("_lor", "")
};
dhtmlXTreeObject.prototype._itemMouseIn = function () {
    var a = this.childNodes[3].parentObject, b = a.treeNod;
    b._l_onMSI != a.id && b.callEvent("onMouseIn", [a.id]);
    b._l_onMSI = a.id;
    if (b.ehlta)a.span.className = a.span.className.replace("_lor", ""), a.span.className = a.span.className.replace(/((standart|selected)TreeRow)/, "$1_lor")
};
dhtmlXTreeObject.prototype.enableActiveImages = function (a) {
    this._aimgs = convertStringToBoolean(a)
};
dhtmlXTreeObject.prototype.focusItem = function (a) {
    var b = this._globalIdStorageFind(a);
    if (!b)return 0;
    this._focusNode(b)
};
dhtmlXTreeObject.prototype.getAllSubItems = function (a) {
    return this._getAllSubItems(a)
};
dhtmlXTreeObject.prototype.getAllChildless = function () {
    return this._getAllScraggyItems(this.htmlNode)
};
dhtmlXTreeObject.prototype.getAllLeafs = dhtmlXTreeObject.prototype.getAllChildless;
dhtmlXTreeObject.prototype._getAllScraggyItems = function (a) {
    for (var b = "", c = 0; c < a.childsCount; c++)if (a.childNodes[c].unParsed || a.childNodes[c].childsCount > 0) {
        var d = a.childNodes[c].unParsed ? this._getAllScraggyItemsXML(a.childNodes[c].unParsed, 1) : this._getAllScraggyItems(a.childNodes[c]);
        d && (b ? b += this.dlmtr + d : b = d)
    } else b ? b += this.dlmtr + a.childNodes[c].id : b = a.childNodes[c].id;
    return b
};
dhtmlXTreeObject.prototype._getAllFatItems = function (a) {
    for (var b = "", c = 0; c < a.childsCount; c++)if (a.childNodes[c].unParsed || a.childNodes[c].childsCount > 0) {
        b ? b += this.dlmtr + a.childNodes[c].id : b = a.childNodes[c].id;
        var d = a.childNodes[c].unParsed ? this._getAllFatItemsXML(a.childNodes[c].unParsed, 1) : this._getAllFatItems(a.childNodes[c]);
        d && (b += this.dlmtr + d)
    }
    return b
};
dhtmlXTreeObject.prototype.getAllItemsWithKids = function () {
    return this._getAllFatItems(this.htmlNode)
};
dhtmlXTreeObject.prototype.getAllFatItems = dhtmlXTreeObject.prototype.getAllItemsWithKids;
dhtmlXTreeObject.prototype.getAllChecked = function () {
    return this._getAllChecked("", "", 1)
};
dhtmlXTreeObject.prototype.getAllUnchecked = function (a) {
    a && (a = this._globalIdStorageFind(a));
    return this._getAllChecked(a, "", 0)
};
dhtmlXTreeObject.prototype.getAllPartiallyChecked = function () {
    return this._getAllChecked("", "", 2)
};
dhtmlXTreeObject.prototype.getAllCheckedBranches = function () {
    var a = [this._getAllChecked("", "", 1)], b = this._getAllChecked("", "", 2);
    b && a.push(b);
    return a.join(this.dlmtr)
};
dhtmlXTreeObject.prototype._getAllChecked = function (a, b, c) {
    if (!a)a = this.htmlNode;
    if (a.checkstate == c && !a.nocheckbox)b ? b += this.dlmtr + a.id : b = a.id;
    for (var d = a.childsCount, f = 0; f < d; f++)b = this._getAllChecked(a.childNodes[f], b, c);
    return b ? b : ""
};
dhtmlXTreeObject.prototype.setItemStyle = function (a, b, c) {
    var c = c || !1, d = this._globalIdStorageFind(a);
    if (!d)return 0;
    d.span.style.cssText ? d.span.style.cssText = c ? b : d.span.style.cssText + ";" + b : d.span.setAttribute("style", d.span.getAttribute("style") + "; " + b)
};
dhtmlXTreeObject.prototype.enableImageDrag = function (a) {
    this._itim_dg = convertStringToBoolean(a)
};
dhtmlXTreeObject.prototype.setOnDragIn = function (a) {
    this.attachEvent("onDragIn", a)
};
dhtmlXTreeObject.prototype.enableDragAndDropScrolling = function (a) {
    this.autoScroll = convertStringToBoolean(a)
};
dhtmlXTreeObject.prototype.setSkin = function (a) {
    var b = this.parentObject.className.replace(/dhxtree_[^ ]*/gi, "");
    this.parentObject.className = b + " dhxtree_" + a;
    a == "dhx_terrace" && this.enableTreeLines(!1)
};
(function () {
    dhtmlx.extend_api("dhtmlXTreeObject", {_init: function (a) {
        return[a.parent, a.width || "100%", a.height || "100%", a.root_id || 0]
    }, auto_save_selection: "enableAutoSavingSelected", auto_tooltip: "enableAutoTooltips", checkbox: "enableCheckBoxes", checkbox_3_state: "enableThreeStateCheckboxes", checkbox_smart: "enableSmartCheckboxes", context_menu: "enableContextMenu", distributed_parsing: "enableDistributedParsing", drag: "enableDragAndDrop", drag_copy: "enableMercyDrag", drag_image: "enableImageDrag", drag_scroll: "enableDragAndDropScrolling",
        editor: "enableItemEditor", hover: "enableHighlighting", images: "enableTreeImages", image_fix: "enableIEImageFix", image_path: "setImagePath", lines: "enableTreeLines", loading_item: "enableLoadingItem", multiline: "enableMultiLineItems", multiselect: "enableMultiselection", navigation: "enableKeyboardNavigation", radio: "enableRadioButtons", radio_single: "enableSingleRadioMode", rtl: "enableRTL", search: "enableKeySearch", smart_parsing: "enableSmartXMLParsing", smart_rendering: "enableSmartRendering", text_icons: "enableTextSigns",
        xml: "loadXML", skin: "setSkin"}, {})
})();
dhtmlXTreeObject.prototype._dp_init = function (a) {
    a.attachEvent("insertCallback", function (a, c, d) {
        var f = this._loader.doXPath(".//item", a), e = f[0].getAttribute("text");
        this.obj.insertNewItem(d, c, e, 0, 0, 0, 0, "CHILD")
    });
    a.attachEvent("updateCallback", function (a, c, d) {
        var f = this._loader.doXPath(".//item", a), e = f[0].getAttribute("text");
        this.obj.setItemText(c, e);
        this.obj.getParentId(c) != d && this.obj.moveItem(c, "item_child", d);
        this.setUpdated(c, !0, "updated")
    });
    a.attachEvent("deleteCallback", function (a, c) {
        this.obj.setUserData(c,
            this.action_param, "true_deleted");
        this.obj.deleteItem(c, !1)
    });
    a._methods = ["setItemStyle", "", "changeItemId", "deleteItem"];
    this.attachEvent("onEdit", function (b, c) {
        b == 3 && a.setUpdated(c, !0);
        return!0
    });
    this.attachEvent("onDrop", function (b, c, d, f, e) {
        f == e && a.setUpdated(b, !0)
    });
    this._onrdlh = function (b) {
        var c = a.getState(b);
        if (c == "inserted")return a.set_invalid(b, !1), a.setUpdated(b, !1), !0;
        if (c == "true_deleted")return a.setUpdated(b, !1), !0;
        a.setUpdated(b, !0, "deleted");
        return!1
    };
    this._onradh = function (b) {
        a.setUpdated(b,
            !0, "inserted")
    };
    a._getRowData = function (a) {
        for (var c = {}, d = this.obj._globalIdStorageFind(a), f = d.parentObject, e = 0, e = 0; e < f.childsCount; e++)if (f.childNodes[e] == d)break;
        c.tr_id = d.id;
        c.tr_pid = f.id;
        c.tr_order = e;
        c.tr_text = d.span.innerHTML;
        f = (d._userdatalist || "").split(",");
        for (e = 0; e < f.length; e++)c[f[e]] = d.userData["t_" + f[e]];
        return c
    }
};

//v.3.5 build 120822

/*
 Copyright DHTMLX LTD. http://www.dhtmlx.com
 You allowed to use this component or parts of it under GPL terms
 To use it on other terms or get Professional edition of the component please contact us at sales@dhtmlx.com
 */