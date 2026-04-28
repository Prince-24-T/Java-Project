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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		 Connection con = DBConnection.getConnection();
	
		try {
						
			   PreparedStatement ps = con.prepareStatement(
				        "SELECT id, userName, password FROM users WHERE email = ?"
				    );
			  ps.setString(1, email);
			  ResultSet rs = ps.executeQuery();

			    if (rs.next()) {
			        String dbUser = rs.getString("userName");
			        int  userId = rs.getInt("id");
			        System.out.print(dbUser);
			        String dbPass = rs.getString("password");
			        if(dbPass.equals(pass)) {
			        	  HttpSession session = request.getSession();
			        	  session.setAttribute("user", dbUser);
			        	  session.setAttribute("userId", userId);
			        	  System.out.println("Profile Session ID: " + session.getId());
			        	  response.sendRedirect("index.html");
			        	 
			        }else {
			        	 pw.println("Password is incorrect");
			            request.getRequestDispatcher("login.html").include(request, response); 
			        }
		
			    } else {
			    	 pw.println("Email is incorrect");
			            request.getRequestDispatcher("login.html").include(request, response); 
			        System.out.println("email is incorrect");
			    }
			
		}catch(Exception e){
			System.out.println(e);
			
		}
		
		 pw.close();  
		
		
		
	}

}
