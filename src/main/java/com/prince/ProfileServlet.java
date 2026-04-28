package com.prince;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		  HttpSession session = request.getSession(false);
		  

	        if (session == null) {
	            response.sendRedirect("login.html");
	            return;
	        }
		  String user = (String) session.getAttribute("user");
		  Integer userId =  (Integer) session.getAttribute("userId");
		  request.setAttribute("user", user);
		    request.setAttribute("userId", userId);
		    System.out.println("Profile Session ID: " + session.getId());

		    RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
		    rd.forward(request, response);
		  
		  
		 
		  
		
	
		  
//		RequestDispatcher rd = request.getRequestDispatcher("profile.html");
//		
//		rd.include(request, response);
		
	
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		doGet(request, response);
//	}

}
