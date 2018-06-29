package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Notice;
import com.bean.User;
import com.dao.NoticeDaoImpl;

public class MyNoticeServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public MyNoticeServlet() {
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

		System.out.println("It's MyNoticeServlet!");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		NoticeDaoImpl noticeDao = new NoticeDaoImpl();
		
		String username = ((User)session.getAttribute("user")).getUsername();
		username = username.substring(0, 4);
		String curPageStr = request.getParameter("curPage");	//得到当前页数的字符串
		int curPage = 1;
		int pageSize = 10;	//默认为10，这里可以写在web.xml比较好
		int noticePage = 0;	//通知总页数
		int beginPage = 0;	//导航开始的页码
		int endPage = 0;	//导航结束的页码
		
		//在Application中得到页数
		String noticePageStr = (String)this.getServletContext().getAttribute("noticePage");
		if(noticePageStr == null){//application中没有这个值
			noticePage = noticeDao.getNoticePage(pageSize);
			this.getServletContext().setAttribute("noticePage", Integer.toString(noticePage));
			System.out.println("set noticePage in application:"+noticePage);
		}else{
			noticePage = Integer.parseInt(noticePageStr);
		}

		//验证当前页码的有效性，可以写成一个验证函数比较好
		if(curPageStr==null){//如果curPage为空
			curPage = 1;
		}else{
			curPage = Integer.parseInt(curPageStr);
		}
		
		if(curPage<1){	//如果curPage小于1
			curPage = 1;
		}else if(curPage > noticePage){//如果curPage大于总页数
			curPage = noticePage;
		}
		
		//计算页面中开始迭代的页码和结束迭代的页码
		if(curPage<=5){
			beginPage = 1;
		}else{
			beginPage = curPage - 5;
		}
		endPage = beginPage + 10;
		if(endPage>noticePage){
			endPage = noticePage;
		}
		
		List<Notice> notices = noticeDao.queryNotices(curPage, pageSize,username);
		
		//保存一些值
		session.setAttribute("notices", notices);	//得到的通知列表
		session.setAttribute("curPage", curPage);	//当前的页数
		session.setAttribute("beginPage", beginPage);//开始迭代页码
		session.setAttribute("endPage", endPage);//结束迭代页码
		
		//移交控制权给myNotice.jsp
		request.getRequestDispatcher("/console/myNotice.jsp").forward(request, response);
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
