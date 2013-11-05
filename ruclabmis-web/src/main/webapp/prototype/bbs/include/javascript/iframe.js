/*

 $RCSfile: iframe.js,v $
 $Revision: 1.9 $
 $Date: 2007/05/22 16:54:11 $
 */

function refreshmain(e) {
    e = e ? e : window.event;
    actualCode = e.keyCode ? e.keyCode : e.charCode;
    if (actualCode == 116 && parent.main) {
        parent.main.location.reload();
        if (document.all) {
            e.keyCode = 0;
            e.returnValue = false;
        } else {
            e.cancelBubble = true;
            //e.calcelable = true;
            e.preventDefault();
        }
    }
}

_attachEvent(document.documentElement, "keydown", refreshmain);