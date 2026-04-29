<!DOCTYPE html>
<html>
<body>

<h1>Update Todo</h1>

<form action="UpdateTodoServlet" method="post">

    <input type="hidden" name="id"
           value="<%= request.getParameter("id") %>">

    Title:
    <input type="text" name="title"
           value="<%= request.getParameter("title") %>">

    <br><br>

    Description:
    <input type="text" name="description"
           value="<%= request.getParameter("description") %>">

    <br><br>

    <input type="submit" value="Update">

</form>

</body>
</html>