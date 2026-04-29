package com.prince;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class DeleteTodoServlet
 */
@WebServlet("/deleteTodo")
public class DeleteTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = DBConnection.getConnection();

        try {

            int id = Integer.parseInt(request.getParameter("id"));

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM todos WHERE id=?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();

            response.sendRedirect("ShowToDoServlet");

        } catch (Exception e) {
            System.out.println(e);
        }
	}



}
