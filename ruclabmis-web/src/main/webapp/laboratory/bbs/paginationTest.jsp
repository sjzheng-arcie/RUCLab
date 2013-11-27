<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="../../js/pagination/pagination.css" />
        <script type="text/javascript" src="../../js/pagination/jquery.min.js"></script>
        <script type="text/javascript" src="../../js/pagination/jquery.pagination.js"></script>

        <!-- Load data to paginate -->
        <script type="text/javascript" src="../../js/pagination/members.js"></script>

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
        <style type="text/css">
            <!--
            * {padding: 0; margin: 0;}
            body { background-color: #fff; padding: 0;  height: 100%; font-family: Arial, Helvetica, sans-serif; }

            h1 {margin-bottom:10px;font-size:1.5em;}

            h3 {margin-top:10px; font-size:1em;}

            #Searchresult { margin-top:15px; margin-bottom:15px; border:solid 1px #eef;  padding:5px; background:#eef; width:100%; }

            #Searchresult dt { font-weight:bold;}

            #Searchresult dd {margin-left:25px;}

            #footer {margin-top:20px;  font-size:60%;  color:#15B;}

            label { float:left; width:250px; display:block;}

            form p { clear:both;}
            -->
        </style>

        <title>Pagination</title>
    </head>
    <body>
        <div id="hello">
            <h1>jQuery Pagination Plugin Demo</h1>
            <div id="Pagination" class="pagination">
            </div>
            <br style="clear:both;" />
            <h3>List of former members of the United States House of Representatives (A)</h3>
            <h3>Config form for pagination parameters</h3>
            <!-- This form is just to demonstrate the whole range of options and display styles. -->
            <form name="paginationoptions">
                <p><label for="items_per_page">Number of items per page</label><input type="text" value="5" name="items_per_page" id="items_per_page" class="numeric"/></p>
                <p><label for="num_display_entries">Number of pagination links shown</label><input type="text" value="10" name="num_display_entries" id="num_display_entries" class="numeric"/></p>
                <p><label for="num">Number of start and end points</label><input type="text" value="2" name="num_edge_entries" id="num_edge_entries" class="numeric"/></p>
                <p><label for="prev_text">"Previous" label</label><input type="text" value="Prev" name="prev_text" id="prev_text"/></p>
                <p><label for="next_text">"Next" label</label><input type="text" value="Next" name="next_text" id="next_text"/></p>
                <input type="button" id="setoptions" value="Set options" />
            </form>

        </div>
    </body>
</html>