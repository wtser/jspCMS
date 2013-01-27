<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xwfb.bean.News"%>
<%@page import="com.xwfb.bean.Sort"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>新闻发布系统</title>
<link href="css/reset.css" rel="stylesheet" type="text/css" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#main{
	width: 950px;
	height: 250px;
	margin: 0 auto;
	position: relative;
	background-color: #eaeaea;
	

}
#main #cpi{
	width: 650px;
	height: auto;
	position: absolute;
	left: 0;
	background-color: #fff;

}
#main #cpi .cptitle{
	width: 644px;
	height: 35px;
	background: url(./img/cpnews.gif) 0px 0px no-repeat;
	position: relative;
	
}
#main #cpi .cpnews{
	width: 596px;
	height: 175px;
	margin-left: auto;
	margin-right: auto;
	margin-bottom: 20px;
	margin-top: 20px;
}
#main #cpi .cpnews .cppic{
	float: left;
	width: 173px;
	height: 175px;
	background: url(./img/cp.gif) 0px 0px no-repeat;
}
#main #cpi .cpnews .cpcontent{
	width: 400px;
	height: 175px;
	float: right;
	font-size: 1.2em;
	color:#666;
	line-height: 20px;
}
#main #newsli{
	width: 296px;
	height: 250px;
	position: absolute;
	right: 0;
	background-color: #fff;
}
#main #newsli .newTitle{
	width: 263px;
	height: 30px;
	background: url(./img/news.gif) no-repeat;
	margin-top: 20px;
	margin-bottom: 0px;
	margin-right: auto;
	margin-left: auto;
	position: relative;
}
#main #newsli .listBox{
	width: 259px;
	height: 140px;
	margin: 0px auto;
	position: relative;
}
#main #newsli .listBox li{
	height: 35px;
	border-bottom: 1px dotted #ccc;
	line-height: 35px;
}
#main #newsli .listBox li a{
	color: #666;
	text-decoration: none;
	font-size:1.2em;
}
#main #newsli .listBox li .datetime{
	position: absolute;
	right: 0;
	color: #999;
	font-size:1.2em;
}
#main #newsli .listBox li a:visited{
	color: #666;
	text-decoration: none;
}
#main #newsli .listBox li a:hover{
	color: red;
	text-decoration: underline;
}
</style>
</head>
<body>
	<%@include file="inc/top.inc" %>
	<div id="main">
		<div id="cpi">
			<div class="cptitle">
				<a href="page/html/company.php" style="position:absolute;right:10px;top:20px;"><img src="./img/more.gif" style=""></a>
			</div>
			
			<div class="cpnews">
				<div class="cppic"></div>
				<div class="cpcontent">
					<span>杭州某某手机配件公司成立于2005年,本公司以手机配件设计制造为基础，公司目前主要从事手机外壳、手机按键、手机耳机、手机充电器、手机TF塞子、IO塞子、USB塞子等TPU材质等双色塞子等手机配件类外壳及装饰件的生产与销售。公司厂房面积为5000平方米，目前拥有在职员工280余人，其中各类专业技术、管理人员80余人。公司现有现代化的厂房及员工配套生活区，公司坚持高起点、高技术、高品质的方针，从国内外引进先进的模具制造、注塑成型等生产设备，并努力不断提高自身的技术水平，确保准时高效地为客户提供稳定优质的产品及服务。公司于2008年通过了质量体系认证，公司现有现代化的厂房及员工配套生活区，公司坚持高起点、高</span>
				</div>
			</div>
		</div>
		<div id="newsli">
			<div class="newTitle"><a href="page/html/company.php" style="position:absolute;right:10px;top:0px;"><img src="./img/more.gif" style=""></a></div>
			<ul class="listBox">
			<%
 ArrayList<News> listNews =( ArrayList<News>) request.getAttribute("listNews");
for(int i=0 ;i < listNews.size();i++){	
	News news = listNews.get(i);
	if(i==5){break;}
%>
				<li><a href="NewsServlet?action=selectNewsShow&newsClassId=19&newsid=<%=news.getId() %>"><%=news.getTitle() %></a> <span class="datetime"><%=news.getCreateTime() %></span></li>
<%} %>				
			</ul>
		</div>
	</div>

	<%@include file="inc/bottom.inc" %>
</body>
</html>
