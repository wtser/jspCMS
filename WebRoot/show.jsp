<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xwfb.bean.News"%>
<%@page import="com.xwfb.bean.Sort"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>新闻展示</title>
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
	font-size:1.2em;
}
#main #rightList #path a{
	color: white;
	text-decoration: none;
}
#main #rightList #listBox{
	width: 660px;
	height: 350px;
	
	padding-top:30px;
}
#main #rightList #listBox #title{
	font-size: 2em;
	text-align: center;
}
#main #rightList #listBox #info{
	font-size: 1.4em;
	text-align: center;
	width: 400px;
	height: 30px;
	line-height: 30px;
	background-color: #F1F1F1;
	border: 1px #D3CDCD solid;
	margin: 0 auto;
	margin-top: 20px;
}
#main #rightList #listBox #content{
	font-size: 1.4em;
	padding-left: 50px;
	margin-top: 20px;
	height:300px;
	overflow: auto;
}

</style>
</head>
<body>
	<%@include file="inc/top.inc" %>
	<div id="main">
		<%@include file="inc/menu.inc" %>
		<% News news =(News) request.getAttribute("news"); %> 
		<div id="rightList">
			<div id="path">您现在的位置：<a href="NewsServlet?action=selectNewsIndex">网站首页</a> > <a href="NewsServlet?action=selectNewsList&newsClassId=<%=request.getAttribute("newsClassId") %>"><%=request.getAttribute("thisSortName") %></a> > <%=news.getTitle() %></div>
			<div id="listBox">
			
				<h1 id="title"><%=news.getTitle() %></h1>
				<div id="info">作者：<%=news.getAuthor() %>  发布时间：<%=news.getCreateTime() %></div>
				<div id="content">
					<%=news.getContent() %>
				</div>
			</div>
			
		</div>
	</div>

	<%@include file="inc/bottom.inc" %>
</body>
</html>
