package com.xwfb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xwfb.bean.News;
import com.xwfb.bean.Sort;
import com.xwfb.dao.NewsDao;
import com.xwfb.dao.SortDao;

public class NewsServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
		NewsDao newsdao = new NewsDao();
		if ("selectAll".equals(action)){
			//所有新闻的集合
			ArrayList<News> listNews = new ArrayList<News>();
			listNews = newsdao.getNewsAll();
			request.setAttribute("listNews", listNews);
			
			//所以分类的集合 
			SortDao sortdao= new SortDao();
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);
			
			//没有新闻分类id传过去，直接设置为-1；
			request.setAttribute("newsClassId", -1);
			//System.out.println(listSort);
			
			request.getRequestDispatcher("admin/newsMgr.jsp").forward(request, response);
		}
		else if ("selectNewsBySortName".equals(action)){
			
			int newsClassId = Integer.parseInt(request.getParameter("newsClassId"));
			//System.out.println(newsClassId);
			//所有新闻的集合
			ArrayList<News> listNews = new ArrayList<News>();
			listNews = newsdao.getNewsBySortName(newsClassId);
			request.setAttribute("listNews", listNews);
			
			//所以分类的集合 
			SortDao sortdao= new SortDao();
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);
			
			//传递新闻分类id，改进前台用户体验
			request.setAttribute("newsClassId", newsClassId);
			//System.out.println(newsClassId);
			
			request.getRequestDispatcher("admin/newsMgr.jsp").forward(request, response);
		}
		//首页新闻显示页面
		else if ("selectNewsIndex".equals(action)){
			
			int newsClassId = 19;
			//System.out.println(newsClassId);
			//所有新闻的集合
			ArrayList<News> listNews = new ArrayList<News>();
			listNews = newsdao.getNewsBySortName(newsClassId);
			request.setAttribute("listNews", listNews);
			
			//所以分类的集合 
			SortDao sortdao= new SortDao();
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);
			
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		//新闻列表页面
		else if ("selectNewsList".equals(action)){
			
			int newsClassId = Integer.parseInt(request.getParameter("newsClassId"));
			//System.out.println(newsClassId);
			//所有新闻的集合
			ArrayList<News> listNews = new ArrayList<News>();
			listNews = newsdao.getNewsBySortName(newsClassId);
			//listNews = newsdao.getNewsBySortName(7);
			request.setAttribute("listNews", listNews);
			
			//所以分类的集合 
			SortDao sortdao= new SortDao();
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);
			
			//所以子分类的集合 
			//SortDao sortdao= new SortDao();
			//int newsClassId
			ArrayList<Sort> listSubSort = new ArrayList<Sort>();
			listSubSort = sortdao.getSubSortById(newsClassId);
			
			
			request.setAttribute("listSubSort", listSubSort);
			
			String thisSortName = sortdao.getSortById(newsClassId).get(0).getSortName();
			request.setAttribute("thisSortName", thisSortName);
			//System.out.println(newsClassId);
			
			//System.out.println(listNews);
			
			
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
		//新闻列表页面
		else if ("selectNewsListSearch".equals(action)){
			
			int newsClassId = Integer.parseInt(request.getParameter("newsClassId"));
			
			String title = request.getParameter("title");
			System.out.println(newsClassId);
			System.out.println(title);
			//所有新闻的集合
			ArrayList<News> listNews = new ArrayList<News>();
			listNews = newsdao.getNewsBySearch(newsClassId, title);
			//listNews = newsdao.getNewsBySortName(7);
			request.setAttribute("listNews", listNews);
			
			//所以分类的集合 
			SortDao sortdao= new SortDao();
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);
			
			//所以子分类的集合 
			//SortDao sortdao= new SortDao();
			//int newsClassId
			ArrayList<Sort> listSubSort = new ArrayList<Sort>();
			listSubSort = sortdao.getSubSortById(newsClassId);
			
			
			request.setAttribute("listSubSort", listSubSort);
			
			String thisSortName = sortdao.getSortById(newsClassId).get(0).getSortName();
			request.setAttribute("thisSortName", thisSortName);
			System.out.println(newsClassId);
			
			System.out.println(listNews);
			
			
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
		else if ("selectNewsShow".equals(action)){
			
			int newsClassId = Integer.parseInt(request.getParameter("newsClassId"));
			request.setAttribute("newsClassId", newsClassId);
			int newsid = Integer.parseInt(request.getParameter("newsid"));
			//System.out.println(newsClassId);
			//获取指定id的新闻
			///ArrayList<News> listNews = new ArrayList<News>();
			News news=null;
			news = newsdao.getNewsById(newsid);
			//listNews = newsdao.getNewsBySortName(7);
			request.setAttribute("news", news);
			
			//所以分类的集合 
			SortDao sortdao= new SortDao();
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);
			
			//所以子分类的集合 
			//SortDao sortdao= new SortDao();
			//int newsClassId
			ArrayList<Sort> listSubSort = new ArrayList<Sort>();
			listSubSort = sortdao.getSubSortById(newsClassId);
			
			
			request.setAttribute("listSubSort", listSubSort);
			
			String thisSortName = sortdao.getSortById(newsClassId).get(0).getSortName();
			request.setAttribute("thisSortName", thisSortName);
			System.out.println(newsClassId);
			System.out.println(newsid);
			System.out.println(news);
			
			
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}
		else if("insertNews".equals(action)){
			News news = new News();
			
			int newsClassId = Integer.parseInt(request.getParameter("newsClassId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			//String author = request.getParameter("author");
			
			int newsType = Integer.parseInt(request.getParameter("newsType"));
			Date now = new Date();
			DateFormat df= DateFormat.getDateInstance();
			String nowtimes = df.format(now);
			news.setNewsClassId(newsClassId);
			news.setTitle(title);
			news.setContent(content);
			news.setNewsType(newsType);
			news.setCreateTime(nowtimes);
			newsdao.insertNews(news);
			
			request.getRequestDispatcher("SortServlet?action=newsAdd").forward(request, response);
			
		}
		else if("deleteNews".equals(action)){
			int newsid = Integer.parseInt(request.getParameter("newsid"));
			
			
			newsdao.deleteNews(newsid);
			
			request.getRequestDispatcher("NewsServlet?action=selectAll").forward(request, response);
		
		}
		else if("updateNews".equals(action)){
			int newsid = Integer.parseInt(request.getParameter("newsid"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int newsType = Integer.parseInt(request.getParameter("newsType"));
			int newsClassId = Integer.parseInt(request.getParameter("newsClassId"));
			
			News news = new News();
			news.setId(newsid);
			news.setTitle(title);
			news.setContent(content);
			news.setNewsType(newsType);
			news.setNewsClassId(newsClassId);
			
			newsdao.updateNews(news);
			
			
			request.getRequestDispatcher("NewsServlet?action=selectAll").forward(request, response);
		
		}
		//修改数据的静态页面
		else if("updateNewsPage".equals(action)){
			
			//所以分类的集合 
			SortDao sortdao= new SortDao();
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);
			
			int newsid = Integer.parseInt(request.getParameter("newsid"));
			News news=null ;//= new News();
			news=newsdao.getNewsById(newsid);
			request.setAttribute("news", news);
			request.getRequestDispatcher("admin/newsMod.jsp").forward(request, response);
		
		}
	}
	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
