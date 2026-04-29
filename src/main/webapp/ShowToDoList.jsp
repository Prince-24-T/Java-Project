<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>
<body>

<h1>Your To-Do List</h1>

<%
ResultSet rs = (ResultSet) request.getAttribute("todos");
while(rs.next()) {
%>

    <hr>

    <h3>Title: <%= rs.getString("title") %></h3>

    <p>Description: <%= rs.getString("description") %></p>

    <a href="deleteTodo?id=<%= rs.getInt("id") %>">
        Delete
    </a>

    <br><br>

    <a href="updateTodo.jsp?id=<%= rs.getInt("id") %>&title=<%= rs.getString("title") %>&description=<%= rs.getString("description") %>">
        Edit
    </a>

<%
}
%>

</body>
</html>