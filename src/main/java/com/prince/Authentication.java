package com.prince;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet Filter implementation class ProfileFilder
 */
@WebFilter("/ProfileServlet")
public class Authentication extends HttpFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
	
	}
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	     
	     HttpServletRequest req = (HttpServletRequest) request;
	     HttpServletResponse res = (HttpServletResponse) response;
	     HttpSession session = req.getSession(false);
	     
	     if (session != null && session.getAttribute("user") != null) {
	         // ✅ user logged in → allow
	         chain.doFilter(request, response);
	     } else {
	         // ❌ not logged in → redirect
	    	
	    	  res.sendRedirect("login.html");
	     }
		
	}
	public void destroy() {
		
		
		
	}

	
	

	
	

}
