<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xwfb.bean.News"%>
<%@page import="com.xwfb.bean.Sort"%>
<div id="leftMenu">
<% ArrayList<Sort> listSubSort =( ArrayList<Sort>) request.getAttribute("listSubSort");
//如果子分类不为空 则显示
if(listSubSort!=null){
 %>
			<div class="menuTitle"></div>
			<ul class="menuList">
								<%

for(int l=0 ;l < listSubSort.size();l++){	
	Sort subsort = listSubSort.get(l);
	
%>
				<li><a href=""><%=subsort.getSortName()%></a></li>
			<%} %>	
			</ul>
<%} %>
			<div class="searchTitle"></div>
			<form class="searchBox" method="post" action="NewsServlet?action=selectNewsListSearch">
				<select style="width:100px;" name="newsClassId">
					<option value="">请选择</option>
					<%//读取新闻搜索里的分类
ArrayList<Sort> listSort1 =( ArrayList<Sort>) request.getAttribute("listSort");
for(int k=0 ;k < listSort1.size();k++){	
	Sort sort = listSort1.get(k);
	if(sort.getSortLevel()!=0){continue;}
	//for (Sort sort : al) {
					
		//		}
	
%>
			<option value="<%=sort.getId() %>"><%=sort.getSortName() %></option> 
<%} %>
					
				</select>
				<br />
				<input style="width:100px;" name="newsTitle" type="text" / >
				<br />
				<input style="width:100px;height:30px;" type="submit" value="搜索" />

			</form>
		</div>