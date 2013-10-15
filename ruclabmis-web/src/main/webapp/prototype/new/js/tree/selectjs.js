/* Create a new XMLHttpRequest object to talk to the Web server */
var xmlHttp = false;
/*@cc_on @*/
/*@if (@_jscript_version >= 5)
 try {
 xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
 } catch (e) {
 try {
 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
 } catch (e2) {
 xmlHttp = false;
 }
 }
 @end @*/
if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
    xmlHttp = new XMLHttpRequest();
}

/*
 ��������˵���path:���·�� ��actionName:�����Դ ��idName�������˵�id ��fieldName�������˵�name��findName:��ݲ�����ƣ� value�������˵�value ��
 */
function addSelect(path, actionName, idName, fieldName, findName, value) {
    document.getElementById(idName).innerHTML = "<select name='" + fieldName + "' style='width:132px'><option>��ݸ����С�</option></select>";
    xmlHttp.open("POST", path + "/" + actionName + ".do?method=findForSelect&id=" + findName + "&value=" + value, false);
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            document.getElementById(idName).innerHTML = "<select name='" + fieldName + "' style='width:132px'>" + xmlHttp.responseText + "</select>";
        } else if (xmlHttp.readyState == 4 && xmlHttp.status != 200) {
            document.getElementById(idName).innerHTML = "<select name='" + fieldName + "' style='width:132px'><option style='color:red'>��ݴ���</option></select>";
        }
    }
    xmlHttp.send();

}

/*
 ��ӱ�ţ�path:���·�� ��idName����ǩid ��fieldName��input��name��findName:��ݲ��ұ����� ��
 */
function addNo(path, idName, fieldName, findName) {
    document.getElementById(idName).innerHTML = "<input name='" + fieldName + "' readonly value='�������С�' style='color:red'>";
    xmlHttp.open("POST", path + "/sequence.do?method=getNO&id=" + findName, false);
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            document.getElementById(idName).innerHTML = "<input name='" + fieldName + "' readonly value='" + xmlHttp.responseText + "' >";
        } else if (xmlHttp.readyState == 4 && xmlHttp.status != 200) {
            document.getElementById(idName).innerHTML = "<input name='" + fieldName + "' readonly value='�����ɴ���' style='color:red'>";
        }
    }
    xmlHttp.send();

}
