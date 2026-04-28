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

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	
		
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		 Connection con = DBConnection.getConnection();
		 
			
			
			try {
				
				  PreparedStatement ps = con.prepareStatement(
					        "SELECT userName FROM users WHERE email = ?"
					    );
				  ps.setString(1, email);
				  ResultSet rs = ps.executeQuery();

				    if (rs.next()) {
				        String dbUser = rs.getString("userName");
				        pw.print("User is already exist with this email");
				        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
				        rd.include(request , response);
			
				    } else {
				    	PreparedStatement newUser = con.prepareStatement(
						        "INSERT into  users(userName , email , password) values(?,?,?)"
						    );
				    	
				    	newUser.setString(1 , userName);
				    	newUser.setString(2 , email);
				    	newUser.setString(3 , pass);
				    	 newUser.executeUpdate(); // ⭐ important
				    	HttpSession session = request.getSession();
				    	session.setAttribute("name", userName);
				    	 RequestDispatcher rd=request.getRequestDispatcher("index.html"); 
				    	 rd.forward(request , response);
				    	
				    }
		
				
			}catch(Exception e){
				System.out.println(e);
				
			}

	}

}
