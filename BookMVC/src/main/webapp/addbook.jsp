<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="models.Book"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
<link rel="stylesheet" href="./css.css">
</head>
<body>
<h1>Add Book:</h1>
<div class="css-form">
<form method="POST" action="./newbooks">
	
    Title: <input type="text" name="title" placeholder="Title" required>
    Author: <input type="text" name="author" placeholder="Author" required>
    Date: <input type="date" name="date" placeholder="Date" required>
    Genres: <input type="text" name="genres" placeholder="Genres" required>
    Characters: <input type="text" name="characters" placeholder="Characters" required>
    Synopsis: <input type="text" name="synopsis" placeholder="Synopsis" required>
    <br>
    <a href="books">Back To Books</a> <br>
	<input type="submit" value="Add"> <br>
</form>
</div>

</body>
</html>