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
	//ʵ����
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
		
		//��֤��֤��
		if(!LoginVerify.codeVerify(request.getParameter("verification"),(String)session.getAttribute("verification"))){
			//������ʾ����֤�����ajax
		}
		
		//��ȡ����
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		//��֤�û����������ʽ
		if(!LoginVerify.formVerify(user)){
			//������ʾ����ʽ���󣬽�����ajax
		}
		
		//��֤�˺������Ƿ����
		user = userDao.isValid(user.getUsername(), user.getPassword());
		if(user==null){
			//�˺Ż��������
		}else{
			//��½�ɹ�
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
