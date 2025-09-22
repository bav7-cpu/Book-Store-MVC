<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="models.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Books</title>
    <link rel="stylesheet" href="./css.css">
</head>
<body>


<form action="./searchbooks" method="get">
    <input type="text" name="searchBooks" placeholder="Search books" required />
    <input type="submit" value="Search" />
</form>
<a href="books">Back To Books</a> <br>

<table class="css-table">
    <tr>
    	<th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Date</th>
        <th>Genres</th>
        <th>Characters</th>
        <th>Synopsis</th>
    </tr>
    <c:forEach items="${searchBooksResults}" var="c">
        <tr>
        	<td>${c.id}</td>
            <td>${c.title}</td>
            <td>${c.author}</td>
            <td>${c.date}</td>
            <td>${c.genres}</td>
            <td>${c.characters}</td>
            <td>${c.synopsis}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
