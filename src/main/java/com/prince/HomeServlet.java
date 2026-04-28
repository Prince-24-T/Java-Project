package com.prince;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import com.prince.DBConnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
		  Connection con = DBConnection.getConnection();
		  
//		  if(con==null) {
//			System.out.print("DataBase not Connected");
//		  }else {
//		System.out.print("DataBase is connected");
//		
//			  
//		  }
		    // 👉 Forward request to index.html
//	        RequestDispatcher rd = request.getRequestDispatcher("index.html");
//	        rd.forward(request, response);
	
	}

	
	

}
