function checkAll(box) {  //全选或全不选
    document.listForm.checkbox.checked = box.checked;
    if (document.listForm.idcheckbox == null)
        return;
    var numRow = document.listForm.idcheckbox.length;
    if (numRow == null) {
        document.listForm.idcheckbox.checked = box.checked;
        return;
    }
    if (box.checked) {
        for (var i = 0; i < numRow; i++) {
            document.listForm.idcheckbox[i].checked = true;
        }
    } else {
        for (var i = 0; i < numRow; i++) {
            document.listForm.idcheckbox[i].checked = false;
        }
    }
}

function checkOne() {  //选一个时全选或全不选
    if (document.listForm.idcheckbox == null)
        return;
    var numRow = document.listForm.idcheckbox.length;
    if (numRow == null) {
        document.listForm.checkbox.checked = listForm.idcheckbox.checked;
        return;
    }
    var numBox = 0;
    for (var i = 0; i < numRow; i++) {
        if (document.listForm.idcheckbox[i].checked) {
            numBox++;
            break;
        }
    }
    if (numBox == numRow) {
        document.listForm.checkbox.checked = true;
    } else {
        document.listForm.checkbox.checked = false;
    }
}

function toUpdate() {
    var selectedItem;
    if (document.listForm.idcheckbox == null) {
        return;
    }
    var len = document.listForm.idcheckbox.length;
    var flag = 0;
    if (len != undefined) {
        for (var i = 0; i < len; i++) {
            if (eval(document.listForm.idcheckbox[i].checked)) {
                selectedItem = document.listForm.idcheckbox[i].value;
                flag++;
            }
        }
    } else {
        if (document.listForm.idcheckbox.checked) {
            selectedItem = document.listForm.idcheckbox.value;
            flag++;
        }
    }

    if (flag == 0) {
        alert("请选择一条记录！");
        return;
    } else if (flag != 1) {
        alert("请只选择一条记录，不要多选！");
        return;
    }

    document.listForm.action = "toUpdate?id=" + selectedItem;
    document.listForm.submit();
}

function toUpdatePassword() {
    var selectedItem;
    if (document.listForm.idcheckbox == null) {
        return;
    }
    var len = document.listForm.idcheckbox.length;
    var flag = 0;
    if (len != undefined) {
        for (var i = 0; i < len; i++) {
            if (eval(document.listForm.idcheckbox[i].checked)) {
                selectedItem = document.listForm.idcheckbox[selectedItem].value;
                flag++;
            }
        }
    } else {
        if (document.listForm.idcheckbox.checked) {
            selectedItem = document.listForm.idcheckbox.value;
            flag++;
        }
    }

    if (flag == 0) {
        alert("请选择一条记录！");
        return;
    } else if (flag != 1) {
        alert("请只选择一条记录，不要多选！");
        return;
    }

    document.listForm.action = "toUpdatePassword?id=" + selectedItem;
    document.listForm.submit();
}

function toDelete() {
    var selectedItem;
    if (document.listForm.idcheckbox == null) {
        return;
    }
    var len = document.listForm.idcheckbox.length;
    var flag = 0;
    if (len != undefined) {
        for (var i = 0; i < len; i++) {
            if (eval(document.listForm.idcheckbox[i].checked)) {
                selectedItem = document.listForm.idcheckbox[selectedItem].value;
                flag++;
            }
        }
    } else {
        if (document.listForm.idcheckbox.checked) {
            selectedItem = document.listForm.idcheckbox.value;
            flag++;
        }
    }

    if (flag == 0) {
        alert("请选择一条记录！");
        return;
    } else if (flag != 1) {
        alert("请只选择一条记录，不要多选！");
        return;
    }

    if (confirm("是否删除所选记录？")) {
        document.listForm.action = "delete?id=" + selectedItem;
        document.listForm.submit();
    }
}

function toFind() {
    document.listForm.action = baseHref;
    document.listForm.submit();
}

function goPage(pageIndex, maxPage) {
    if (pageIndex <= 0) {
        alert("已到达首页！");
        return;
    }
    if (pageIndex > maxPage) {
        alert("已到达尾页！");
        return;
    }

    document.listForm.action = baseHref + ' ?page=' + pageIndex;
    document.listForm.submit();
}

//获得divwidth的宽度
function getWidth() {
    document.getElementById("divwidth").style.width = document.body.offsetWidth - 35 + "px";
    if (document.body.scrollWidth > document.body.offsetWidth) {
        document.getElementById("divwidth").style.width = document.body.scrollWidth - 35 + "px";
    }
}