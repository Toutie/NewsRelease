package com.servlet;

import java.io.IOException;

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
 * Servlet implementation class newsDetailServlet
 */

public class NewsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newsid = request.getParameter("newsid");
		//从数据库查询对应id的新闻出来,存在session中
		NewsDaoImpl newsDaoImpl = new NewsDaoImpl();
		if(!newsDaoImpl.updateClick(newsid)){
			System.out.println("新闻"+newsid+"更新点击量失败！");
			return;
		}
		News news = newsDaoImpl.queryNews(newsid);
		String chineseType = StringUtil.typeToChineseStr(news.getType());
		HttpSession session = request.getSession();
		session.setAttribute("news", news);
		session.setAttribute("chineseType", chineseType);
		request.getRequestDispatcher("/front/newsDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
