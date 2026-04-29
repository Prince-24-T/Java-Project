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

@WebServlet("/AddToDoServlet")
public class AddToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		 Connection con = DBConnection.getConnection();
		 
		 try {
			 
			 String title = request.getParameter("title");
			 String description = request.getParameter("description");
			 HttpSession session = request.getSession(false);
			 Integer user_id = (Integer) session.getAttribute("userId");
			 
			  PreparedStatement ps = con.prepareStatement(
				        "Insert into todos(title, description , user_id)  values (?,?,?)"
				    );
			  
			  ps.setString(1, title);
			  ps.setString(2, description);
			  ps.setInt(3, user_id);
			  
			  int row = ps.executeUpdate();
			  if(row>0) {
				  RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				    rd.forward(request, response);

			  }else {
				  pw.print("Some Problem occured during TO_Do list Adding");

				    RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				    rd.include(request, response);
			  }
			 
		 }catch(Exception e){
			 System.out.print(e);
			 
		 }
	}

}
