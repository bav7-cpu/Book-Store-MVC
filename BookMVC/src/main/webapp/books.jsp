<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="models.Book"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
<link rel="stylesheet" href="./css.css">
</head>
<body>
<a href="./newbooks"><button>Add Book</button></a>

<a href="./searchbooks"><button>Search Book</button></a>

<div>
<table class="css-table">
    <tr><th>ID</th><th>Title</th><th>Author</th><th>Date</th><th>Genres</th><th>Characters</th><th>Synopsis</th><th>Update</th><th>Delete</th></tr>
    <c:forEach items="${books}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.title}</td>
            <td>${c.author}</td>
            <td>${c.date}</td>
            <td>${c.genres}</td>
            <td>${c.characters}</td>
            <td>${c.synopsis}</td>
            <td> <a href="./updatebook?id=${c.getId()}"> Update </a> </td>
            <td> <a href="./deletebook?id=${c.getId()}"> Delete </a> </td>
        </tr>
    </c:forEach>
</table>
</div>
<div style="margin-top: 20px;">
<%-- will show what page you are currently on and the option of going to the previous and next page
	this let the user traverse throughout the pages
	   --%>
	<a href="books?page=${previousPage}"><< Previous</a>
	<p>Page ${currentPage} of ${totalPages}</p>

	<a href="books?page=${nextPage}">Next >></a>
	<form action="books" method="get" style="margin-top:10px;">
		<label for="page">Go to page:</label>
		<input type="number" min="1" name="page" id="page" value="${currentPage}" required />
		<input type="submit" value="Enter" />
	</form>
</div>

</body>
</html>
