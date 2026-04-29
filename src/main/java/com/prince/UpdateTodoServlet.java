package com.prince;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/UpdateTodoServlet")
public class UpdateTodoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Connection con = DBConnection.getConnection();

        try {

            int id = Integer.parseInt(request.getParameter("id"));

            String title = request.getParameter("title");

            String description = request.getParameter("description");

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE todos SET title=?, description=? WHERE id=?"
            );

            ps.setString(1, title);
            ps.setString(2, description);
            ps.setInt(3, id);

            ps.executeUpdate();

            response.sendRedirect("ShowToDoServlet");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}