<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="../../../../js/page.js"></script>
<tr>
    <td height="30">
        <table width='100%' border='0' cellspacing='0' cellpadding='0'
               style='font-size:13px;'>
            <tr>
                <td>

				<span class='STYLE22' style="white-space:nowrap">
				<table border='0' align='right' cellpadding='0' cellspacing='0' style='font-size:13px;'>
                    <tr>
                        <td width='49'>
                            <div align='center'><img onclick="goPage(1, ${pageInfo.totalPage})" style="cursor:hand"
                                                     src='/equipment/../images/main_54.gif' width='40' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img onclick="goPage(${pageInfo.currentPage-1}, ${pageInfo.totalPage})"
                                                     style="cursor:hand"
                                                     src='/equipment/../images/main_56.gif' width='45' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img onclick="goPage(${pageInfo.currentPage+1}, ${pageInfo.totalPage})"
                                                     style="cursor:hand"
                                                     src='/equipment/../images/main_58.gif' width='45' height='15'
                                                     border='0'/></div>
                        </td>
                        <td width='49'>
                            <div align='center'><img onclick="goPage(${pageInfo.totalPage}, ${pageInfo.totalPage})"
                                                     style="cursor:hand"
                                                     src='/equipment/../images/main_60.gif' width='40' height='15'
                                                     border='0'/></div>
                        </td>

                    </tr>
                </table>
					</span>
                </td>
            </tr>
        </table>
    </td>
</tr>