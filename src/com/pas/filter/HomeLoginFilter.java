package com.pas.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeLoginFilter  implements Filter{
	private String unpagelock;
	  
	  public void destroy() {}
	  
	  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
	    throws IOException, ServletException
	  {
	    HttpServletRequest request = (HttpServletRequest)req;
	    HttpServletResponse response = (HttpServletResponse)resp;
	    HttpSession session = request.getSession(true);
	    String servletpath = request.getServletPath();
	    
	    System.out.println("Filter:       " + servletpath);
	    
	    if(servletpath.contains("/admin")){  //不过滤后台
	    	 chain.doFilter(req, resp);
		     return;
	    }
	    if(servletpath.contains("/static/admin")){  //不过滤后台资源文件
	    	 chain.doFilter(req, resp);
		     return;
	    }
	    if(servletpath.contains("/static/home")){  //不过滤前台资源文件
	    	 chain.doFilter(req, resp);
		     return;
	    }
	    
	    List<String> list = Arrays.asList(this.unpagelock.split(","));
	    if (list.contains(servletpath))
	    {
	      chain.doFilter(req, resp);
	      return;
	    }
	    if (session.getAttribute("uid") != null)
	    {
	      int uid = ((Integer)session.getAttribute("uid")).intValue();
	      if (uid == 0) {
	        //response.sendRedirect("http://localhost:8080/pa/Admin/login.html");
	    	  response.sendRedirect("/PAS/login");
	      } else {
	        chain.doFilter(req, resp);
	      }
	    }
	    else
	    {
	    	response.sendRedirect("/PAS/login");
	    }
	  }
	  
	  public void init(FilterConfig filterConfig)
	    throws ServletException
	  {
	    this.unpagelock = filterConfig.getInitParameter("unpagelock");
	  }
}
