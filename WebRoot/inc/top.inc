<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.xwfb.bean.Sort"%>
<div id="top">
		<div id="header">
			<div id="logo" ></div>
			<div id="tips">
				<a href="">设为首页</a> |
				<a href="">加入收藏</a> |
				<a href="">联系我们</a>
			</div>
		</div>
		<div id="menu">
		<a href="NewsServlet?action=selectNewsIndex">网站首页</a> 
						<%
 ArrayList<Sort> listSort =( ArrayList<Sort>) request.getAttribute("listSort");
for(int j=0 ;j < listSort.size();j++){	
	Sort sort = listSort.get(j);
	if(sort.getSortLevel()!=0){continue;}
%>
			<a href="NewsServlet?action=selectNewsList&newsClassId=<%=sort.getId() %>"><%=sort.getSortName() %></a> 
<%} %>
			
		</div>
		<div id="flashShow">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="100%" height="100%">
			 <param name="movie" value="img/flashShow.swf">
			 <param name="quality" value="high">
			 <param name="wmode" value="transparent">
			 <embed src="img/flashShow.swf" wmode="transparent" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="950" height="201">
			</object>
		</div>
</div>