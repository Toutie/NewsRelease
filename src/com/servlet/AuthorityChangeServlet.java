package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDaoImpl;

@WebServlet("/servlet/AuthorityChangeServlet")
public class AuthorityChangeServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AuthorityChangeServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("It's authorityChangeServlet");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		UserDaoImpl userDao = new UserDaoImpl();
		
		String isNews = request.getParameter("isNews");
		String isNotice = request.getParameter("isNotice");
		String username = request.getParameter("username");
		
		System.out.println("username:"+username);
		System.out.println("isNews:"+isNews);
		System.out.println("isNotice:"+isNotice);
		
		//—È÷§
		if(isNews!=null&&!isNews.trim().isEmpty()&&!isNews.equals("undefined")){
			if(userDao.updateNewsAuthority(username, isNews)){
				out.print("true");
			}else{
				out.print("false");
			}
			
			return;
		}
		
		if(isNotice!=null&&!isNotice.trim().isEmpty()&&!isNotice.equals("undefined")){
			if(userDao.updateNoticeAuthority(username, isNotice)){
				out.print("true");
			}else{
				out.print("false");
			}
			
			return;
		}
		
		
		out.print("false");
		out.close();
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
