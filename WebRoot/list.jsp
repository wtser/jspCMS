<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xwfb.bean.News"%>
<%@page import="com.xwfb.bean.Sort"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>新闻列表</title>
<link href="css/reset.css" rel="stylesheet" type="text/css" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#main{
	width: 950px;
	height: 470px;
	margin: 0 auto;
	position: relative;
	background-color: #eaeaea;
	padding-top: 2px;
	font-size:1.2em;
}
#main #leftMenu{
	position: absolute;
	width: 190px;
	height: 466px;
	border-right: 2px solid #ccc;
	background-color: white;
	border: 1px #cecece solid;

}
#main #leftMenu .menuTitle{
	
height: 45px;
background: url(img/sort.gif)  no-repeat;
}
#main #leftMenu .searchTitle{
	
height: 45px;
background: url(img/search.gif)  no-repeat;
}
#main #leftMenu .searchBox{
	margin: 0 auto;
	text-align: center;
	font-size: 1.2em;
}
#main #leftMenu .menuList{
	width: 190px;
	margin: 0 auto;
}
#main #leftMenu .menuList li{
	height: 30px;
	line-height: 30px;
	text-align: center;
	border-bottom: 1px dotted #ccc;
	margin:0 10px;
}
#main #leftMenu .menuList li a{
color: #666;
text-decoration: none;
}
#main #leftMenu .menuList li a:visited{
color: #666;
text-decoration: none;
}
#main #leftMenu .menuList li a:hover{
color: red;
text-decoration: underline;
}
#main #rightList{
	position: absolute;
	width: 755px;
	height: 466px;
	right: 0;
	background-color: white;
}
#main #rightList #path{
	height: 40px;
	background-color: #025c88;
	line-height: 40px;
	padding-left: 20px;
	color: white;
}
#main #rightList #path a{
	color: white;
	text-decoration: none;
}
#main #rightList #listBox{
	width: 660px;
	height: 350px;
	padding-left:50px;
	padding-top:30px;
}
#main #rightList #listBox li{
	height: 30px;
	line-height: 30px;
	list-style-type: circle;
	position: relative;
}
#main #rightList #listBox li a{
	color:#333;
	text-decoration: none;
}
#main #rightList #listBox li .datetime{
	position: absolute;
	color:#666;
	right: 0;
	
}
#main #rightList #pagecode{
	color: #555;
	position: relative;
	padding-left: 40px;

}
</style>
</head>
<body>

	<%@include file="inc/top.inc" %>
	<div id="main">
		<%@include file="inc/menu.inc" %>
		
		<div id="rightList">
			<div id="path">您现在的位置：<a href="NewsServlet?action=selectNewsIndex">网站首页</a> > <%=request.getAttribute("thisSortName")%></div>
			<ul id="listBox">
					<%
 ArrayList<News> listNews =( ArrayList<News>) request.getAttribute("listNews");
for(int m=0 ;m < listNews.size();m++){	
	News news = listNews.get(m);
	
%>
				<li><a href="NewsServlet?action=selectNewsShow&newsClassId=<%=request.getParameter("newsClassId") %>&newsid=<%=news.getId() %>"><%=news.getTitle() %></a> <span class="datetime"><%=news.getCreateTime() %></span></li>
	<%} %>			
				
				
				
			</ul>
			<div id="pagecode">
				共19条 每页12条 页次：1/2 <span style="position: absolute;right:40px;"><a href="">首页</a> | <a href="">上一页</a> | <a href="">下一页</a></span>
			</div>
		</div>
	</div>

	<%@include file="inc/bottom.inc" %>
</body>
</html>
