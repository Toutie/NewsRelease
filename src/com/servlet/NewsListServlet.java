package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import StringUtil.StringUtil;

import com.bean.News;
import com.dao.NewsDaoImpl;

/**
 * Servlet implementation class NewsListServlet
 */
@WebServlet(asyncSupported = true, description = "NewsListServlet", urlPatterns = { "/NewsListServlet" })
public class NewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = this.getServletContext();
		HttpSession session = request.getSession();
		
		String newsPageStr = (String)servletContext.getAttribute("newsPage");
		String type = request.getParameter("type");
		String curPageStr = request.getParameter("curPage");	//得到当前页数的字符串
		String chineseType = StringUtil.typeToChineseStr(type);
		NewsDaoImpl newsDaoImpl = new NewsDaoImpl();

		int curPage = 1;	//当前页
		int pageSize = 10;	//页大小
		int newsPage = 0;	//该类型新闻的总页数
		int beginPage = 0;	//起始页
		int endPage = 0;	//结束页
		
		if(newsPageStr == null){
			newsPage = newsDaoImpl.getNewsPage(type, pageSize);
			newsPageStr = Integer.toString(newsPage);
			servletContext.setAttribute("newsPage", newsPageStr);
		}else{
			newsPage = Integer.parseInt(newsPageStr); 
		}
		
		if(curPageStr == null ||curPageStr.equals("")){
			curPage = 1;
		}else{
			curPage = Integer.parseInt(curPageStr);
		}
		
		if(curPage < 1){
			curPage = 1;
		}else if(curPage > newsPage){
			curPage = newsPage;
		}
		
		if(beginPage <= 5){
			beginPage = 1;
		}else {
			beginPage = curPage - 5;
		}
		endPage = beginPage + 10;
		
		if(endPage>newsPage){
			endPage = newsPage;
		}
		
		List<News> newsList = newsDaoImpl.queryNewsByType(type, curPage, pageSize);
		session.setAttribute("type", type);
		session.setAttribute("chineseType", chineseType);
		session.setAttribute("newsList", newsList);
		session.setAttribute("curPage", curPage);
		session.setAttribute("beginPage", beginPage);
		session.setAttribute("endPage", endPage);

		request.getRequestDispatcher("/front/newsList.jsp").forward(request, response);
		servletContext.removeAttribute("newsPage");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
