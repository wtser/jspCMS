package com.xwfb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xwfb.bean.Sort;
import com.xwfb.bean.User;
import com.xwfb.dao.SortDao;
import com.xwfb.dao.UserDao;

public class UserServlet extends HttpServlet {

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
		//System.out.println(action);
		UserDao userdao = new UserDao();

		if("insertUser".equals(action)){
			User user = new User();
			
			String name= request.getParameter("name");
			String pass = request.getParameter("pass");
			int privileges = Integer.parseInt(request.getParameter("privileges"));
			
			user.setName(name);
			user.setPass(pass);
			user.setPrivileges(privileges);
			
			userdao.insertUser(user);
			
			
			request.getRequestDispatcher("UserServlet?action=selectAll").forward(request, response);
			
		}
		else if("deleteUser".equals(action)){
			int userid = Integer.parseInt(request.getParameter("userid"));			
			userdao.deleteUser(userid);
			request.getRequestDispatcher("UserServlet?action=selectAll").forward(request, response);
		
		}
		else if("updateUser".equals(action)){		
			User user = new User();
			int userid = Integer.parseInt(request.getParameter("userid"));
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			int logTime = Integer.parseInt(request.getParameter("logTime"));
			int privileges = Integer.parseInt(request.getParameter("privileges"));
			//System.out.println(permission);
			user.setId(userid);
			user.setName(name);
			user.setPass(pass);
			user.setLogTime(logTime);
			user.setPrivileges(privileges); 

			userdao.updateUser(user);
			
			request.getRequestDispatcher("UserServlet?action=selectAll").forward(request, response);		
		}
		else if("selectAll".equals(action)){
			
			ArrayList<User> listUser = new ArrayList<User>();
			listUser = userdao.getAllUser();
			request.setAttribute("listUser", listUser);
			
			request.getRequestDispatcher("admin/userMgr.jsp").forward(request, response);
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
