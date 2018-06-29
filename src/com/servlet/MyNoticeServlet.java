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
		String curPageStr = request.getParameter("curPage");	//�õ���ǰҳ�����ַ���
		int curPage = 1;
		int pageSize = 10;	//Ĭ��Ϊ10���������д��web.xml�ȽϺ�
		int noticePage = 0;	//֪ͨ��ҳ��
		int beginPage = 0;	//������ʼ��ҳ��
		int endPage = 0;	//����������ҳ��
		
		//��Application�еõ�ҳ��
		String noticePageStr = (String)this.getServletContext().getAttribute("noticePage");
		if(noticePageStr == null){//application��û�����ֵ
			noticePage = noticeDao.getNoticePage(pageSize);
			this.getServletContext().setAttribute("noticePage", Integer.toString(noticePage));
			System.out.println("set noticePage in application:"+noticePage);
		}else{
			noticePage = Integer.parseInt(noticePageStr);
		}

		//��֤��ǰҳ�����Ч�ԣ�����д��һ����֤�����ȽϺ�
		if(curPageStr==null){//���curPageΪ��
			curPage = 1;
		}else{
			curPage = Integer.parseInt(curPageStr);
		}
		
		if(curPage<1){	//���curPageС��1
			curPage = 1;
		}else if(curPage > noticePage){//���curPage������ҳ��
			curPage = noticePage;
		}
		
		//����ҳ���п�ʼ������ҳ��ͽ���������ҳ��
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
		
		//����һЩֵ
		session.setAttribute("notices", notices);	//�õ���֪ͨ�б�
		session.setAttribute("curPage", curPage);	//��ǰ��ҳ��
		session.setAttribute("beginPage", beginPage);//��ʼ����ҳ��
		session.setAttribute("endPage", endPage);//��������ҳ��
		
		//�ƽ�����Ȩ��myNotice.jsp
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
