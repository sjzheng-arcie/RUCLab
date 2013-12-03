<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="/js/page.js"></script>
<tr>
    <td height="30">
        <table width='100%' border='0' cellspacing='0' cellpadding='0'
               style='font-size:13px;'>
            <tr>
                <td><span align='left' class='STYLE22' style="white-space:nowrap">
                                            &nbsp;&nbsp;共有<strong>${pageInfo.totalResult}</strong> 条记录，当前第<strong>${pageInfo.currentPage}</strong> 页，共 <strong>${pageInfo.totalPage}</strong> 页</span>

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
                        <td width='37' class='STYLE22'>
                            <div align='center' style="white-space:nowrap">转到</div>
                        </td>
                        <td>
                            <div align='left'>
                                <select onchange="goPage(this.options[this.selectedIndex].value, ${pageInfo.totalPage})">
                                    <c:forEach var="i" begin="1" end="${pageInfo.totalPage}" step="1">
                                        <option class='STYLE22' value='${i}'
                                                <c:if test="${pageInfo.currentPage == i}">selected</c:if> > 第${i}页
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                    </tr>
                </table>
					</span>
                </td>
            </tr>
        </table>
    </td>
</tr>