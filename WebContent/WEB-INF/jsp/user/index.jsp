<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>

<%@ page language="java" import="model.po.User" %>
<%@ page language="java" import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ include file="header.jsp" %>


<h3>用户列表</h3>
<% if (request.getAttribute("userList") != null){  %>
	<div class="userlist">
	    <table>
	        <tr>
	            <th>名字</th>
	            <th>生日</th>
	            <th>性别</th>
	            <th>操作</th>
	        </tr>
	        
	        <c:forEach items="${userList}" var="user">
	            <tr>
	              <td>${user.name}</td>
	              <td>${user.birthday}</td>
	              <td>
	                    <c:choose>
	                        <c:when test="${user.sex == 1}">男 </c:when>
	                        <c:otherwise>女</c:otherwise>
	                    </c:choose>
	               </td>
	               <td>
	                    <a href="#">编辑</a>&nbsp;&nbsp;
	                    <a href="#">删除</a>
	               </td>
	            </tr>
	        </c:forEach>
		</table>
	</div>
	<div class="pager">${pagerHtml}</div>
<% } %>


<%@ include file="footer.jsp" %>