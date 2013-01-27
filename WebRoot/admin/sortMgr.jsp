<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xwfb.bean.Sort"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>分类管理 </title>
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
	<th>分类名称</th>
	<th>上级分类id</th>
	<th>操作</th> 
</thead>
<tbody>

<%
ArrayList<Sort> listSort =( ArrayList<Sort>) request.getAttribute("listSort");
for(int i=0 ;i < listSort.size();i++){	
	Sort sort = listSort.get(i);
%>
	<tr>
		<form method="post" action="SortServlet?action=updateSort">
		<input name="sortid" type="hidden" value="<%=sort.getId() %>"/>
		<td><%=sort.getId() %></td>
		<td><input name="sortName" type="text" value="<%=sort.getSortName() %>"/> </td>
			
		<td><input name="sortLevel" type="text" value="<%=sort.getSortLevel() %>"/> </td>
		
		<td><input name="submit" type="submit" value="修改"/> | <a href="SortServlet?action=deleteSort&sortid=<%= sort.getId() %>">删除</a></td>
		</form>
	</tr>
<%
 }
%>
	<tr>
		<form method="post" action="SortServlet?action=insertSort">
		
		<td>默认</td>
		<td><input name="sortName" type="text" value=""/> </td>
			
		<td><input name="sortLevel" type="text" value=""/> </td>
		<td><input name="submit" type="submit" value="添加"/> </td>
		</form>
	</tr>

</tbody>
</table>

</body>

</html>
