package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.News;
import com.bean.User;
import com.dao.NewsDaoImpl;

public class NewsReleaseServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public NewsReleaseServlet() {
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

		System.out.println("It's NewsReleaseServlet");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		News news = new News();
		//组织news
		news.setTitle(request.getParameter("title"));
		news.setType(request.getParameter("type"));
		news.setContent(request.getParameter("content"));
		news.setUsername(((User)session.getAttribute("user")).getUsername());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		news.setTime(sdf.format(new Date()));
		
		System.out.println(news.getContent());
		
		/*
		 * 这里需要检验数据有效性
		 * NewsVerify.releaseVerify()
		 */
		
		//通过验证则插入数据库
		NewsDaoImpl newsDao = new NewsDaoImpl();
		if(newsDao.releaseNews(news)){	//发布成功
			out.print("release000");
		}else{	//发布时报
			out.print("release001");
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
