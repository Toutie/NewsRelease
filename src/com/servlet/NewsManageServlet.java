package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.News;
import com.dao.NewsDaoImpl;

import StringUtil.StringUtil;

public class NewsManageServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public NewsManageServlet() {
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
		
		String type = request.getParameter("type");
		String curPageStr = request.getParameter("curPage");	//得到当前页数的字符串
		NewsDaoImpl newsDaoImpl = new NewsDaoImpl();

		int curPage = 1;	//当前页
		int pageSize = 10;	//页大小
		int allNewsPage = 0;	//所有新闻的总页数
		int beginPage = 0;	//起始页
		int endPage = 0;	//结束页
		
		
		allNewsPage = newsDaoImpl.getAllNewsPage(pageSize);
		String allNewsPageStr = Integer.toString(allNewsPage);
		session.setAttribute("allNewsPage", allNewsPageStr);
		
		if(curPageStr == null ||curPageStr.equals("")){
			curPage = 1;
		}else{
			curPage = Integer.parseInt(curPageStr);
		}
		
		if(curPage < 1){
			curPage = 1;
		}else if(curPage > allNewsPage){
			curPage = allNewsPage;
		}
		
		if(beginPage <= 5){
			beginPage = 1;
		}else {
			beginPage = curPage - 5;
		}
		endPage = beginPage + 10;
		
		if(endPage>allNewsPage){
			endPage = allNewsPage;
		}
		
		List<News> allNews = newsDaoImpl.queryAllNews(curPage, pageSize);
		session.setAttribute("allNews", allNews);
		session.setAttribute("curPage", curPage);
		session.setAttribute("beginPage", beginPage);
		session.setAttribute("endPage", endPage);

		request.getRequestDispatcher("/console/newsManage.jsp").forward(request, response);
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
