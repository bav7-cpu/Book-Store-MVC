<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deleted Book</title>

<link rel="stylesheet" href="./css.css">
</head>
<body>

<table class="css-table">
<form method="POST" action="./deletebook">
<tr><th>ID</th><th>Title</th><th>Author</th><th>Date</th><th>Genres</th><th>Characters</th><th>Synopsis</th></tr>
    <input type="hidden" name="id" value="${b.id}">
    <h1>Are you sure you want to delete the book with the following properties: </h1><br>
    <tr>
    <td>${b.id}</td>
    <td>${b.title}</td>
    <td>${b.author}</td>
    <td>${b.date}</td>
    <td>${b.genres}</td>
    <td>${b.characters}</td>
    <td>${b.synopsis}</td>
    <input type="submit" value="Delete">
    </tr>
</form>
<a href="books">Back To Books</a>
</br>
</table>
</body>
</html>