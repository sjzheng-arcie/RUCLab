/*表单验证*/
var FormValid = function (frm) {
    this.frm = frm;
    this.errMsg = new Array();
    this.errName = new Array();
    this.required = function (inputObj) {
        if (typeof(inputObj) == "undefined" || inputObj.value.trim() == "") {
            return false;
        }
        return true;
    };
    this.equal = function (inputObj, formElements) {
        var fstObj = inputObj;
        var sndObj = formElements[inputObj.getAttribute('equalName')];
        if (fstObj != null && sndObj != null) {
            if (fstObj.value != sndObj.value) {
                return false;
            }
        }
        return true;
    };

    this.gt = function (inputObj, formElements) {
        var fstObj = inputObj;
        var sndObj = formElements[inputObj.getAttribute('equalName')];
        if (fstObj != null && sndObj != null && fstObj.value.trim() != '' && sndObj.value.trim() != '') {
            if (fstObj.value <= sndObj.value) {
                return false;
            }
        }
        return true;
    };

    this.compare = function (inputObj, formElements) {
        var fstObj = inputObj;
        var sndObj = formElements[inputObj.getAttribute('objectName')];
        if (fstObj != null && sndObj != null && fstObj.value.trim() != '' && sndObj.value.trim() != '') {
            if (!eval('fstObj.value' + inputObj.getAttribute('operate') + 'sndObj.value')) {
                return false;
            }
        }
        return true;
    };

    this.limit = function (inputObj) {
        var len = inputObj.value.length;
        if (len) {
            var minv = inputObj.getAttribute('min');
            var maxv = inputObj.getAttribute('max');
            minv = minv || 0;
            maxv = maxv || Number.MAX_VALUE;
            return minv <= len && len <= maxv;
        }
        return true;
    };

    this.range = function (inputObj) {
        var val = parseInt(inputObj.value);
        if (inputObj.value) {
            var minv = inputObj.getAttribute('min');
            var maxv = inputObj.getAttribute('max');
            minv = minv || 0;
            maxv = maxv || Number.MAX_VALUE;
            return minv <= val && val <= maxv;
        }
        return true;
    };

    this.requireChecked = function (inputObj) {
        var minv = inputObj.getAttribute('min');
        var maxv = inputObj.getAttribute('max');
        minv = minv || 1;
        maxv = maxv || Number.MAX_VALUE;
        var checked = 0;
        var groups = document.getElementsByName(inputObj.name);

        for (var i = 0; i < groups.length; i++) {
            if (groups[i].checked) checked++;

        }
        return minv <= checked && checked <= maxv;
    };

    this.filter = function (inputObj) {
        var value = inputObj.value;
        var allow = inputObj.getAttribute('allow');
        if (value.trim()) {
            return new RegExp("^.+\.(?=EXT)(EXT)$".replace(/EXT/g, allow.split(/\s*,\s*/).join("|")), "gi").test(value);
        }
        return true;
    };

    this.isNo = function (inputObj) {
        var value = inputObj.value;
        var noValue = inputObj.getAttribute('noValue');
        return value != noValue;
    };
    this.checkReg = function (inputObj, reg, msg) {
        inputObj.value = inputObj.value.trim();

        if (inputObj.value == '') {
            return;
        } else {
            if (!reg.test(inputObj.value)) {
                this.addErrorMsg(inputObj.name, msg);
            }
        }
    };


    this.passed = function () {
        if (this.errMsg.length > 0) {
            FormValid.showError(this.errMsg, this.errName);
            frt = document.getElementsByName(this.errName[0])[0];

            if (frt.type != 'radio' && frt.type != 'checkbox') {
                frt.focus();
            }
            return false;
        } else {
            return true;
        }
    };


    this.addErrorMsg = function (name, str) {
        this.errMsg.push(str);
        this.errName.push(name);
    };

    this.addAllName = function (name) {
        FormValid.allName.push(name);
    };

};
FormValid.allName = new Array();
FormValid.showError = function (errMsg) {
    var msg = "";
    for (i = 0; i < errMsg.length; i++) {
        msg += "- " + errMsg[i] + "\n";
    }
    alert(msg);
};
function validator(frm) {
    var formElements = frm.elements;
    var fv = new FormValid(frm);
    for (var i = 0; i < formElements.length; i++) {
        var validType = formElements[i].getAttribute('valid');
        var errorMsg = formElements[i].getAttribute('errmsg');
        if (validType == null || validType == "") continue;
        fv.addAllName(formElements[i].name);

        var vts = validType.split('|');
        var ems = errorMsg.split('|');
        for (var j = 0; j < vts.length; j++) {
            var curValidType = vts[j];
            var curErrorMsg = ems[j];
            switch (curValidType) {
                case 'isNum':
                case 'isSymbols':
                case 'isTableName':
                case 'isNumber':
                case 'isAccount':
                case 'isPassword':
                case 'isEnglishChinese':
                case 'isEmail':
                case 'isPhone':
                case 'isMobile':
                case 'isIdCard':
                case 'isMoney':
                case 'isZip':
                case 'isQQ':
                case 'isInt':
                case 'isEnglish':
                case 'isChinese':
                case 'isUrl':
                case 'isDate':
                case 'underHundred':
                case 'isTime':
                    fv.checkReg(formElements[i], RegExps[curValidType], curErrorMsg);
                    break;
                case 'regexp':
                    fv.checkReg(formElements[i], new RegExp(formElements[i].getAttribute('regexp'), "g"), curErrorMsg);
                    break;
                case 'custom':
                    if (!eval(formElements[i].getAttribute('custom') + '(formElements[i],formElements)')) {
                        fv.addErrorMsg(formElements[i].name, curErrorMsg);
                    }
                    break;
                default :
                    if (!eval('fv.' + curValidType + '(formElements[i],formElements)')) {
                        fv.addErrorMsg(formElements[i].name, curErrorMsg);
                    }
                    break;
            }
        }
    }
    return fv.passed();
}

//FormValid.showError = function(errMsg,errName) {
//        for (key in FormValid.allName) {
//                document.getElementById('errMsg_'+FormValid.allName[key]).innerHTML = '';
//        }
//        for (key in errMsg) {
//                document.getElementById('errMsg_'+errName[key]).innerHTML = errMsg[key];
//        }
//}

String.prototype.trim = function () {
    return this.replace(/^\s*|\s*$/g, "");
};
var RegExps = function () {
};
RegExps.isNumber = /^[-\+]?\d+(\.\d+)?$/;
RegExps.isEmail = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/;
//RegExps.isEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)/;
RegExps.isPhone = /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/;
RegExps.isMobile = /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/;
RegExps.isIdCard = /(^\d{15}$)|(^\d{17}[0-9Xx]$)/;
RegExps.isMoney = /^\d+(\.\d+)?$/;
RegExps.isZip = /^[1-9]\d{5}$/;
RegExps.isQQ = /^[1-9]\d{4,10}$/;
RegExps.isInt = /^[-\+]?\d+$/;
RegExps.isEnglish = /^[A-Za-z]+$/;
RegExps.isChinese = /^[\u0391-\uFFE5]+$/;
RegExps.isUrl = /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
RegExps.isDate = /^\d{4}-\d{1,2}-\d{1,2}$/;
RegExps.isTime = /^\d{4}-\d{1,2}-\d{1,2}\s\d{1,2}:\d{1,2}:\d{1,2}$/;
RegExps.isAccount = /^[a-z]\w{3,}$/i;
RegExps.isPassword = /^\w{6,16}$/i;
RegExps.isEnglishChinese = /^[A-Za-z\u0391-\uFFE5]+$/i;
RegExps.isTableName = /^[a-z]\w*$/i;
RegExps.isSymbols = /^[\w\u0391-\uFFE5]+$/i;
RegExps.isNum = /^\d+$/i;
RegExps.underHundred=/^(0|[0-9][0-9]?|100)$/;
