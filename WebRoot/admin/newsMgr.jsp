<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xwfb.bean.News"%>
<%@page import="com.xwfb.bean.Sort"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>新闻管理</title>
<link href="./css/reset.css" rel="stylesheet" type="text/css" />
<link href="./css/base.css" rel="stylesheet" type="text/css" />
<link href="./css/menu.css" rel="stylesheet" type="text/css" />
<link href="./css/applyEdit.css" rel="stylesheet" type="text/css" />

</head>
<body>
<%@ include file="inc/menu.inc" %> 
<%/*获得分类集*/ ArrayList<Sort> listSort =( ArrayList<Sort>) request.getAttribute("listSort"); %>
<div style="width:950px;margin:10px auto;">
<form method="post" action="NewsServlet?action=selectNewsBySortName" >
 <select name="newsClassId" >
<% 
int newsClassId = (Integer)request.getAttribute("newsClassId");

for(int i=0 ;i < listSort.size();i++){	
	Sort sort = listSort.get(i);
%>
			
			<% if ((newsClassId==-1) || (sort.getId()!=newsClassId)){%>
				<option name= "newsClassId" value="<%=sort.getId() %>" ><%=sort.getSortName() %></option>
			<% }else{%>
			<option name= "newsClassId" value="<%=sort.getId() %>" selected ><%=sort.getSortName() %></option>
			<%} %>
			
		
<%
 }
%>			</select>	

</select>

<input type="submit" value="查询" />
</form>
 </div>

<table  border="1">
<thead>
	<th>id</th>
	<th>新闻分类</th>
	<th>新闻标题</th>
	<th>作者</th>
	<th>创建时间</th>
	
	<th>新闻属性</th>
	<th>操作</th> 
</thead>
<tbody>

<%
 ArrayList<News> listNews =( ArrayList<News>) request.getAttribute("listNews");
for(int i=0 ;i < listNews.size();i++){	
	News news = listNews.get(i);
%>
	<tr>
		
		<input name="sortid" type="hidden" value="<%=news.getId() %>"/>
		<td><%=news.getId() %></td>
		<td>
			<%//=news.getNewsClassId() %>
			<%
//ArrayList<Sort> listSort =( ArrayList<Sort>) request.getAttribute("listSort");
for(int j=0 ;j < listSort.size();j++){	
	Sort sort = listSort.get(j);
	if(sort.getId() == news.getNewsClassId()){%>
	<p><%=sort.getSortName() %></p>
	<% }
}
%>
			

		</td>
		<td><%=news.getTitle() %></td>
			
		<td><%=news.getAuthor() %> </td>
		<td><%=news.getCreateTime() %> </td>
		<td><%if(news.getNewsType ()==0){%>
			普通新闻
			<%} %>
			
			<%if(news.getNewsType ()==1){%>
			<span style="color:#A86918; ">焦点新闻</span>
			<%} %>
			
			<%if(news.getNewsType ()==2){%>
			<span style="color:red;">公告新闻</span>
			<%} %>
		
		 </td>
		
		
		<td><a href="NewsServlet?action=updateNewsPage&newsid=<%= news.getId() %>">修改</a> | <a href="NewsServlet?action=deleteNews&newsid=<%= news.getId() %>">删除</a></td>
		
	</tr>
<%
 }
%>
	

</tbody>
</table>



</body>

</html>
