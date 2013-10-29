function checkAll(box,formName,checkBoxName) {  //全选或全不选
    document.forms[formName].checkbox.checked = box.checked;
    var temp = document.forms[formName].elements[checkBoxName];
    if(temp==null)
        return;
    var numRow = temp.length;
    if (numRow == null) {
        temp.checked = box.checked;
        return;
    }
    if (box.checked) {

        for (var i = 0; i < numRow; i++) {
            temp[i].checked = true;
        }
    } else {
        for (var i = 0; i < numRow; i++) {
            temp[i].checked = false;
        }
    }
}

function checkOne(formName,checkBoxName) {  //选一个时全选或全不选
    var form_temp = document.forms[formName];
    if(form_temp==null)
        return;
    var temp = document.forms[formName].elements[checkBoxName];
     if (temp == null)
        return;
    var numRow = temp.length;
    if (numRow == null) {
        document.forms[formName].checkbox.checked = temp.checked;
        return;
    }
    var numBox = 0;
    for (var i = 0; i < numRow; i++) {
        if (temp[i].checked) {
            numBox++;
            break;
        }
    }
    if (numBox == numRow) {
        document.forms[formName].checkbox.checked = true;
    } else {
        document.forms[formName].checkbox.checked = false;
    }
}
/*function toUpdate() {
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
}*/
function toUpdate(formName,checkBoxName) {
    var form_temp = document.forms[formName];
    if(form_temp==null)
        return;
    var selectedItem;
    var temp = document.forms[formName].elements[checkBoxName];
    if (temp == null) {
        return;
    }
    var len = temp.length;
    var flag = 0;
    if (len != undefined) {
        for (var i = 0; i < len; i++) {
            if (eval(temp[i].checked)) {
                selectedItem = temp[i].value;
                flag++;
            }
        }
    } else {
        if (temp.checked) {
            selectedItem = temp.value;
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

    document.forms[formName].action = "toUpdate?id=" + selectedItem;
    document.forms[formName].submit();
}

/*function toUpdatePassword() {
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
}*/
function toUpdatePassword(formName,checkBoxName) {
    var form_temp = document.forms[formName];
    if(form_temp==null)
        return;
    var selectedItem;
    var temp = document.forms[formName].elements[checkBoxName];
    if (temp == null) {
        return;
    }
    var len = temp.length;
    var flag = 0;
    if (len != undefined) {
        for (var i = 0; i < len; i++) {
            if (eval(temp[i].checked)) {
                selectedItem = temp[i].value;
                flag++;
            }
        }
    } else {
        if (temp.checked) {
            selectedItem = temp.value;
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

    document.forms[formName].action = "toUpdatePassword?id=" + selectedItem;
    document.forms[formName].submit();
}
/*function toDelete() {
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
}*/
function toDelete(formName,checkBoxName) {
    var form_temp = document.forms[formName];
    if(form_temp==null)
        return;
    var selectedItem;
    var temp = document.forms[formName].elements[checkBoxName];
    if (temp == null) {
        return;
    }
    var len = temp.length;
    var flag = 0;
    if (len != undefined) {
        for (var i = 0; i < len; i++) {
            if (eval(temp[i].checked)) {
                selectedItem = temp[i].value;
                flag++;
            }
        }
    } else {
        if (temp.checked) {
            selectedItem = temp.value;
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
        document.forms[formName].action = "delete?id=" + selectedItem;
        document.forms[formName].submit();
    }
}
//function toFind() {
//    document.listForm.action = baseHref;
//    document.listForm.submit();
//}
 function toFind(formName){
     document.forms[formName].action = baseHref;
     document.forms[formName].submit();
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