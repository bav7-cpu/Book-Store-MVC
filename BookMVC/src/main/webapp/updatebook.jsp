<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
<link rel="stylesheet" href="./css.css">
</head>
<body>

<table class="css-table">
<form method="POST" action="./updatebook">
<tr><th>ID</th><th>Update Title</th><th>Update Author</th><th>Update Date</th><th>Update Genres</th><th>Update Characters</th><th>Update Synopsis</th></tr>
    <input type="hidden" name="id" value="${b.id}">
    <tr>
	<td>ID: ${b.id} </td>
	<td><input type="text" name="title" placeholder="Title" value="${b.title}" required> </td>
	<td><input type="text" name="author" placeholder="Author" value="${b.author}" required> </td>
	<td><input type="text" name="date" placeholder="Date" value="${b.date}" required> </td>
	<td><input type="text" name="genres" placeholder="Genres" value="${b.genres}" required> </td>
	<td><input type="text" name="characters" placeholder="Characters" value="${b.characters}" required> </td>
	<td><input type="text" name="synopsis" placeholder="Synopsis" value=" ${fn:replace(b.synopsis, '"', '')}" required> </td>
    </tr>

<a href="books">Back To Books</a> <br>
<input type="submit" value="Update"> <br>

</table>
</body>
</html>