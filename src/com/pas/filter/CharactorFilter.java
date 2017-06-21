package com.pas.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharactorFilter
  implements Filter
{
  private String encoding = null;
  
  public void destroy()
  {
    this.encoding = null;
  }
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
  {
    if (this.encoding != null)
    {
      request.setCharacterEncoding(this.encoding);
      response.setContentType("text/html;charset=" + this.encoding);
      System.out.println("过滤器");
    }
    chain.doFilter(request, response);
  }
  
  public void init(FilterConfig filterConfig)
    throws ServletException
  {
    this.encoding = filterConfig.getInitParameter("encoding");
  }
}
