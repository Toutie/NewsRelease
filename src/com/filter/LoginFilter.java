package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bean.User;

import StringUtil.StringUtil;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("LoginFilter Begin!");
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			chain.doFilter(request, response);
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(
					"<script>alert('ÇëµÇÂ¼ºóÔÙ²Ù×÷!');</script>"+
					"<script>location.href='/NewsRelease/login.html';</script>"
					);
		}
		
		System.out.println("LoginFilter End!");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
