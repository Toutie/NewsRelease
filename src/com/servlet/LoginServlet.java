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
	//实例化
	User user = new User();
	UserDaoImpl userDao = new UserDaoImpl();
	
	
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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//验证验证码
		if(!LoginVerify.codeVerify(request.getParameter("verification"),(String)session.getAttribute("verification"))){
			//返回提示，验证码错误，ajax
		}
		
		//获取参数
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		//验证用户名和密码格式
		if(!LoginVerify.formVerify(user)){
			//返回提示，格式错误，建议用ajax
		}
		
		//验证账号密码是否错误
		user = userDao.isValid(user.getUsername(), user.getPassword());
		if(user==null){
			//账号或密码错误
		}else{
			//登陆成功
			session.setAttribute("user", user);
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
