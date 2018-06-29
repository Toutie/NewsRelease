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
		//��֯notice
		notice.setTitle(StringUtil.transfer(request.getParameter("title")));
		notice.setReceiver(request.getParameter("receiver"));
		notice.setContent(StringUtil.transfer(request.getParameter("content")));
		notice.setSender(((User)session.getAttribute("user")).getName());		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		notice.setTime(sdf.format(new Date()));
		
		System.out.println(notice.getContent());
		
		/*
		 * ������Ҫ����������Ч�Ժ�Ȩ����Ч��
		 * noticeVerify.releaseVerify()
		 */
		
		//ͨ����֤��������ݿ�
		NoticeDaoImpl noticeDao = new NoticeDaoImpl();
		if(noticeDao.releaseNotice(notice)){	//�����ɹ�
			out.print("release000");
			
			//����֪ͨ��ҳ��������Application�й���Ҳ�ѯ
			int pageSize = 10;	//Ĭ��10��1ҳ
			int noticePage = noticeDao.getNoticePage(pageSize);
			this.getServletContext().setAttribute("noticePage", Integer.toString(noticePage));
			System.out.println("noticePage:"+noticePage);
		}else{	//����ʧ��
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
