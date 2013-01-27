<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xwfb.bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>用户管理</title>
<link href="./css/reset.css" rel="stylesheet" type="text/css" />
<link href="./css/base.css" rel="stylesheet" type="text/css" />
<link href="./css/menu.css" rel="stylesheet" type="text/css" />
<link href="./css/applyEdit.css" rel="stylesheet" type="text/css" />

</head>
<body>

<%@ include file ="inc/menu.inc"  %>

<table  border="1">
<thead>
	<th>id</th>
	<th>用户名</th>
	<th>密码</th>
	<th>登陆次数</th>
	<th>权限</th>
	<th>操作</th> 
</thead>
<tbody>

<%
ArrayList<User> listUser =( ArrayList<User>) request.getAttribute("listUser");
for(int i=0 ;i < listUser.size();i++){	
	User user = listUser.get(i);
%>

	<tr>
		<form method="post" action="UserServlet?action=updateUser">
		<input name="userid" type="hidden" value="<%=user.getId() %>"/>
		<td><%=user.getId()  %></td>
		
		<td><input name="name" type="text" value="<%=user.getName() %>"/> </td>
			
		<td><input name="pass" type="text" value="<%=user.getPass() %>"/> </td>
		<td><input name="logTime" type="text" value="<%=user.getLogTime() %>"/> </td>
		<td><input name="privileges" type="text" value="<%=user.getPrivileges()%>"/> </td>
		<td><input name="submit" type="submit" value="修改"/> | <a href="UserServlet?action=deleteUser&userid=<%=user.getId()%>">删除</a></td>
		</form>
	</tr>
<%
 }
%>
	<tr>
		<form method="post" action="UserServlet?action=insertUser">
		
		<td>默认</td>
		<td><input name="name" type="text" value=""/> </td>
		<td><input name="pass" type="text" value=""/> </td>
			
		<td><input name="logTime" type="text" value="" disabled /> </td>
		<td><input name="privileges" type="text" value=""  /> </td>
		<td><input name="submit" type="submit" value="添加"/> </td>
		</form>
	</tr>

</tbody>
</table>

</body>

</html>
