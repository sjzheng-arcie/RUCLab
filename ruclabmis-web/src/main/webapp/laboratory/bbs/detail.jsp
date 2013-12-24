<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<HTML>
<HEAD>
    <TITLE>实验交流论坛--看贴</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=UTF-8">
    <Link rel="stylesheet" type="text/css" href="style/style.css"/>
    <script type="text/javascript" src="../../js/pagination/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/pagination/jquery.pagination.js"></script>
    <script type="text/javascript" src="../../js/autocomplete/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="../../js/pagination/pagination.css" />
    <script>
        function reply(){
            document.mainForm.action="addReply";
            document.mainForm.submit();
        }
    </script>
    <script>

/*            $.ajax({
                type: "post",
                url: '/laboratory/bbs/clickCount',
                data:'topicUid=${bbsTopic.id}',
                success: function (msg) {

                }
            })*/


/*        $.post("/clickCount", {
            'topicUid': ${bbsTopic.id}
        }, function (msg) {
            alert(msg);
         });*/
    </script>
     <script type="text/javascript">

        // This file demonstrates the different options of the pagination plugin
        // It also demonstrates how to use a JavaScript data structure to
        // generate the paginated content and how to display more than one
        // item per page with items_per_page.

        /**
         * Callback function that displays the content.
         *
         * Gets called every time the user clicks on a pagination link.
         *
         * @param {int}page_index New Page index
         * @param {jQuery} jq the container with the pagination links as a jQuery object
         */
        function pageselectCallback(page_index, jq){
            // Get number of elements per pagionation page from form
            var items_per_page = $('#items_per_page').val();
            var max_elem = Math.min((page_index+1) * items_per_page, members.length);
            var newcontent = '';

            // Iterate through a selection of the content and build an HTML string
            for(var i=page_index*items_per_page;i<max_elem;i++)
            {
                newcontent += '<dt>' + members[i][0] + '</dt>';
                newcontent += '<dd class="state">' + members[i][2] + '</dd>';
                newcontent += '<dd class="party">' + members[i][3] + '</dd>';
            }

            // Replace old content with new content
            $('#Searchresult').html(newcontent);

            // Prevent click eventpropagation
            return false;
        }

        // The form contains fields for many pagiantion optiosn so you can
        // quickly see the resuluts of the different options.
        // This function creates an option object for the pagination function.
        // This will be be unnecessary in your application where you just set
        // the options once.
        function getOptionsFromForm(){
            var opt = {callback: pageselectCallback};
            // Collect options from the text fields - the fields are named like their option counterparts
            $("input:text").each(function(){
                opt[this.name] = this.className.match(/numeric/) ? parseInt(this.value) : this.value;
            });
            // Avoid html injections in this demo
            var htmlspecialchars ={ "&":"&amp;", "<":"&lt;", ">":"&gt;", '"':"&quot;"}
            $.each(htmlspecialchars, function(k,v){
                opt.prev_text = opt.prev_text.replace(k,v);
                opt.next_text = opt.next_text.replace(k,v);
            })
            return opt;
        }

        // When document has loaded, initialize pagination and form
        $(document).ready(function(){
            // Create pagination element with options from form
            var optInit = getOptionsFromForm();
            $("#Pagination").pagination(members.length, optInit);

            // Event Handler for for button
            $("#setoptions").click(function(){
                var opt = getOptionsFromForm();
                // Re-create pagination content with new parameters
                $("#Pagination").pagination(members.length, opt);
            });

        });

    </script>

</HEAD>

<BODY>
<form name="mainForm" method="post">
<DIV>
    <div id="banner" style="background-image:url('images/default/banner_mole_bg.jpg');border:0;position:relative;">
        <div style=" left:0px; top:0px; z-index:99px;"><img src="images/default/banner_mole_left.jpg" style="margin-left:0px;"/>
        </div>
    </div>
</DIV>
    <DIV>
    <DIV class="h" >
        <p style="font-size: 16px;margin-top: 0px;margin-bottom: 0px">&gt;&gt;<B><a href="frame">论坛首页</a></B>&gt;&gt;<B>
            <a href="list?courseId=${bbsTopic.sessionid}">${sessionTitle}</a></B>
            <%--<span style="float:right">
                <A href="topost??courseId=${bbsTopic.id}"><IMG src="images/post.gif" border="0" id=td_post></A>
           <shiro:hasAnyRoles name="administrator,teacher,equipment_admin,lab_admin">
                <A href="upTop?topicId=${bbsTopic.id}"><IMG src="images/uptop.gif" border="0" id=td_uptop></A>
                <A href="deletetopic?topicId=${bbsTopic.id}&&sessionId=${bbsTopic.sessionid}"><IMG src="images/del.gif" border="0" id=td_del></A>
           </shiro:hasAnyRoles>
            </span>--%>
        </p>
    </DIV>
    <DIV>
        <TABLE cellSpacing="0" cellPadding="0" width="100%">
            <%@ include file="../jsp/common/toppagetable.jsp" %>
            <TR>
                <TH class="h">主题：${bbsTopic.title}
                 </TH>

            </TR>

        </TABLE>
    </DIV>
    <DIV class="t">
        <TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed" cellSpacing="0" cellPadding="0" width="100%">
            <TR class="tr1">
                <TH style="WIDTH: 20%">
                    <B>${poster}</B><BR/>
                    <img src="images/head/1.gif"/>
                </TH>
                <TH>
                    <H3>${bbsTopic.title}</H3>
                    <H4>${bbsTopic.contents}</H4>
                    <DIV></DIV>
                    <DIV class="tipad gray">
                        发表：[<fmt:formatDate value="${bbsTopic.creattime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>] &nbsp;
                        最后回复:[<fmt:formatDate value="${bbsTopic.lastrepliedtime}"
                                              pattern="yyyy-MM-dd HH:mm:ss"/>]


                            <c:if test="${userSn==currentSn}">
                                <A href="deletetopic?topicId=${bbsTopic.id}&&sessionId=${bbsTopic.sessionid}">[删除]</A>
                                <A href="toupdatetopic?topicId=${bbsTopic.id}&&sessionId=${bbsTopic.sessionid}">[修改]</A>
                            </c:if>



                    </DIV>
                </TH>
            </TR>
        </TABLE>
    </DIV>
     <c:forEach items="${pageInfo.data}" var="item">
            <DIV class="t">
            <TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed" cellSpacing="0" cellPadding="0" width="100%">
                <TR class="tr1">
                    <TH style="WIDTH: 20%">
                        <B>${item.replyUserName}</B><BR/>
                        <img src="images/head/1.gif"/><BR/>
                     </TH>
                    <TH>
                        <H3>${item.title}</H3>
                        <H4>${item.content}</H4>
                        <DIV></DIV>
                        <DIV class="tipad gray">
                            发表：[<fmt:formatDate value="${item.replytime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"/>] &nbsp;
                            <c:if test="${item.replyUsersn==currentSn}">
                                <A href="deletereply?replyId=${item.id}&&topicId=${bbsTopic.id}&&sessionId=${bbsTopic.sessionid}">[删除]</A>
                                <A href="toupdatereply?replyId=${item.id}&&topicId=${bbsTopic.id}&&sessionId=${bbsTopic.sessionid}">[修改]</A>
                            </c:if>

                        </DIV>

                    </TH>
                </TR>


        </TABLE>
           </DIV>

    </c:forEach>
    <DIV>
        <TABLE cellSpacing="0" cellPadding="0" width="100%">
            <%@ include file="../jsp/common/toppagetable.jsp" %>
        </TABLE>
    </DIV>
</DIV>
<DIV>
        <INPUT type="hidden" name="sessionId" value="${bbsTopic.sessionid}"/>
        <INPUT type="hidden" name="topicId" value="${bbsTopic.id}"/>

        <DIV class="t">
            <TABLE cellSpacing="0" cellPadding="0" align="center">
                <TR>
                <TD class="h" colSpan="3"><B>回复</B></TD>
            </TR>
                <TR class="tr3">
                    <TH width="20%"><B>标题</B></TH>
                    <TH><INPUT class="input" style="PADDING-LEFT: 2px; FONT: 14px Tahoma" tabIndex="1" size="60"
                               name="title"></TH>
                </TR>
                <TR class="tr3">
                    <TH vAlign=top>
                        <DIV><B>内容</B></DIV>
                    </TH>
                    <TH colSpan=2>
                        <div id="innerId">
                                                <span><textarea id="content" style="WIDTH: 90%; height: 300px"
                                                                name="content" rows="20" cols="90"
                                                                tabIndex="2"></textarea></span>
                            <script type="text/javascript"
                                    src="../../js/ueditor/ueditor.config.js"></script>

                            <script type="text/javascript"
                                    src="../../js/ueditor/ueditor.all.js"></script>

                            <link type="text/css"
                                  href="../../js/ueditor/themes/default/css/ueditor.css"/>

                            <script type="text/javascript" charset="utf-8">
                                var editor = new baidu.editor.ui.Editor();
                                editor.render('content');
                            </script>
                        </div>
                    </TH>
                </TR>
                <TR class="tr3">
                    <TH vAlign=top>

                    </TH>
                    <TH colSpan=2>
                        <DIV style="MARGIN: 15px 0px; TEXT-ALIGN: left">
                            <INPUT class="btn" name="replySubmit"tabIndex="3" type="button" onclick="reply();" value="回 复">
                            <INPUT class="btn" tabIndex="4" type="reset" onclick="clickcount()" value="重 置">
                        </DIV>
                    </TH>
                </TR>

            </TABLE>
        </DIV>

</DIV>
</form>
</BODY>
</HTML>
