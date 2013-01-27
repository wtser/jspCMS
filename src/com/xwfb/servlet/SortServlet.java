package com.xwfb.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xwfb.bean.Sort;
import com.xwfb.dao.NewsDao;
import com.xwfb.dao.SortDao;

public class SortServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		System.out.println(action);
		SortDao sortdao = new SortDao();

		if("insertSort".equals(action)){
			Sort sort = new Sort();
			
			String sortName = request.getParameter("sortName");
			int sortLevel = Integer.parseInt(request.getParameter("sortLevel"));
			sort.setSortLevel(sortLevel);
			sort.setSortName(sortName);

			sortdao.insertSort(sort);
			
			request.getRequestDispatcher("SortServlet?action=selectAll").forward(request, response);
			
		}
		else if("deleteSort".equals(action)){
			int sortid = Integer.parseInt(request.getParameter("sortid"));			
			sortdao.deleteSort(sortid);
			request.getRequestDispatcher("SortServlet?action=selectAll").forward(request, response);
		
		}
		else if("updateSort".equals(action)){		
			Sort sort = new Sort();
			int sortid = Integer.parseInt(request.getParameter("sortid"));
			int sortLevel = Integer.parseInt(request.getParameter("sortLevel"));
			String sortName = request.getParameter("sortName");
			 		
			sort.setId(sortid);
			sort.setSortLevel(sortLevel);
			sort.setSortName(sortName);

			sortdao.updateSort(sort);
			
			request.getRequestDispatcher("SortServlet?action=selectAll").forward(request, response);		
		}
		else if("selectAll".equals(action)){
			//Sort sort = null;
			
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);
			//request.RequestDispatcher("/admin/sortMgr.jsp").forward(request, response);
			request.getRequestDispatcher("admin/sortMgr.jsp").forward(request, response);
		}
		else if("newsAdd".equals(action)){
			//Sort sort = null;
			
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);
			//request.RequestDispatcher("/admin/sortMgr.jsp").forward(request, response);
			request.getRequestDispatcher("admin/newsAdd.jsp").forward(request, response);
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
