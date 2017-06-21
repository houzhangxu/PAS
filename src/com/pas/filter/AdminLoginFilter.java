package com.pas.filter;

import java.io.IOException;
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

public class AdminLoginFilter
  implements Filter
{
  private String unpagelock;
  
  public void destroy() {}
  
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
    throws IOException, ServletException
  {
    HttpServletRequest request = (HttpServletRequest)req;
    HttpServletResponse response = (HttpServletResponse)resp;
    HttpSession session = request.getSession(true);
    String servletpath = request.getServletPath();
    
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
        response.sendRedirect("http://localhost:8080/pa/Admin/login.html");
      } else {
        chain.doFilter(req, resp);
      }
    }
    else
    {
      response.sendRedirect("http://localhost:8080/pa/Admin/login.html");
    }
  }
  
  public void init(FilterConfig filterConfig)
    throws ServletException
  {
    this.unpagelock = filterConfig.getInitParameter("unpagelock");
  }
}
