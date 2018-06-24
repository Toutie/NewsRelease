package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.UserDaoImpl;
import com.verify.LoginVerify;

public class LoginServlet extends HttpServlet {
	
	
	
	/**
		 * Constructor of the object.
		 */
	public LoginServlet() {
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

		System.out.println("It's LoginServlet!");
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verification = request.getParameter("verification");
		System.out.println(username+"/"+password+"/"+verification);
		
		String correctCode = (String)session.getAttribute("verification");
		
		//验证验证码
		if(!LoginVerify.codeVerify(verification,correctCode)){
			//返回提示，验证码错误，ajax
			out.print("login002");	//验证码错误
		}else{
			
			//验证用户名和密码格式
			if(!LoginVerify.formVerify(username,password)){
				//返回提示，格式错误，建议用ajax
				out.print("login003");
			}
			
			//实例化
			User user = new User();
			UserDaoImpl userDao = new UserDaoImpl();
			
			//验证账号密码是否错误
			user = userDao.isValid(username, password);
			if(user==null){
				//账号或密码错误
				out.print("login001");
			}else{
				//登陆成功
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(1800);
				out.print("login000");
			}
		}
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
