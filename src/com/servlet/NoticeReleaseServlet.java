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


import com.bean.Notice;
import com.bean.User;
import com.dao.NoticeDaoImpl;

import StringUtil.StringUtil;

public class NoticeReleaseServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public NoticeReleaseServlet() {
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

System.out.println("It's noticeReleaseServlet");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		Notice notice = new Notice();
		//组织notice
		notice.setTitle(StringUtil.transfer(request.getParameter("title")));
		notice.setReceiver(request.getParameter("receiver"));
		notice.setContent(StringUtil.transfer(request.getParameter("content")));
		notice.setSender(((User)session.getAttribute("user")).getName());		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		notice.setTime(sdf.format(new Date()));
		
		System.out.println(notice.getContent());
		
		/*
		 * 这里需要检验数据有效性和权限有效性
		 * noticeVerify.releaseVerify()
		 */
		
		//通过验证则插入数据库
		NoticeDaoImpl noticeDao = new NoticeDaoImpl();
		if(noticeDao.releaseNotice(notice)){	//发布成功
			out.print("release000");
			
			//更新通知的页数，放入Application中供大家查询
			int pageSize = 10;	//默认10条1页
			int noticePage = noticeDao.getNoticePage(pageSize);
			this.getServletContext().setAttribute("noticePage", Integer.toString(noticePage));
			System.out.println("noticePage:"+noticePage);
		}else{	//发布失败
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
