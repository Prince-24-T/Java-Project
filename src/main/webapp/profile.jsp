<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<body>

<h1>Profile Page</h1>

<h3>Welcome: <%= request.getAttribute("user") %></h3>

<h3>User ID: <%= request.getAttribute("userId") %></h3>

<a href="ShowToDoServlet">See TO-DO LIST</a>

<a href="addToList.html" >Add TO-Do List</a>

 

</body>
</html>