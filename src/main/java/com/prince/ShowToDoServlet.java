package com.prince;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class ShowToDoServlet
 */
@WebServlet("/ShowToDoServlet")
public class ShowToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection con = DBConnection.getConnection();

        try {

            HttpSession session = request.getSession(false);
            Integer userId = (Integer) session.getAttribute("userId");

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM todos WHERE user_id=?"
            );

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            request.setAttribute("todos", rs);

            request.getRequestDispatcher("ShowToDoList.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
