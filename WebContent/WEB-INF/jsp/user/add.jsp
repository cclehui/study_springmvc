<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>

<%@ page language="java" import="model.po.User" %>
<%@ page language="java" import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ include file="header.jsp" %>


<h3>添加用户</h3>

<div class="content">
    <form action="${basePath}/user/addUserPost.do" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="name" value="" /></td>
            </tr>
            <tr>
                <td>生日</td>
                <td><input type="text" name="birthday" value="" /></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <select name="sex"> 
                        <option value="1">男</option>
                        <option value="0">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="提交" /></td>
            </tr>
        </table>
    </form>
</div>

<%@ include file="footer.jsp" %>