package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bean.User;

/**
 * Servlet Filter implementation class NewsReleaseFilter
 */
@WebFilter("/NewsReleaseFilter")
public class NewsReleaseFilter implements Filter {

    /**
     * Default constructor. 
     */
    public NewsReleaseFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("NewsReleaseFilter Begin!");
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user!=null&&user.getIsNews().equals("1")){
			chain.doFilter(request, response);
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(
					"<script>alert('抱歉，你没有该权限！');</script>"
					+"<script>location.href='/NewsRelease/console/main.jsp'</script>"
					);
		}
		
		// pass the request along the filter chain
		
		System.out.println("NewsReleaseFilter End!");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
