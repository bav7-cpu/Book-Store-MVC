// this controller class connects to the DAO and handles HTTP requests for updating a book in the application
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAOEnum;
import models.Book;

@WebServlet("/updatebook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAOEnum dao;
	
	public UpdateBook() {
		this.dao = BookDAOEnum.INSTANCE;
	} 
   
	 // this method handles GET requests to load the book data for editing
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book b = dao.selectBooks(id);
		request.setAttribute("b", b);
		RequestDispatcher rd = request.getRequestDispatcher("updatebook.jsp");
		rd.include(request, response);
	}

	 // this method handles POST requests to update the book details in the database
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            String newTitle = request.getParameter("title");
            String newAuthor = request.getParameter("author");
            String newDate = request.getParameter("date");
            String newGenres = request.getParameter("genres");
            String newCharacters = request.getParameter("characters");
            String newSynopsis = request.getParameter("synopsis"); 

            if (newTitle.isEmpty() || newAuthor.isEmpty() || newDate.isEmpty() || newGenres.isEmpty() ||newCharacters.isEmpty() ||newSynopsis.isEmpty()) {
            	response.getWriter().println("Error: Nothing can remain empty.");
                return;
            }

            boolean successful = dao.updateBook(new Book(id, newTitle, newAuthor, newDate, newGenres, newCharacters, newSynopsis));

            if (successful) {
                response.sendRedirect("books");
            } else {
                response.getWriter().println("Error: Book update failed. ID may not exist.");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("Error: Invalid ID format.");
        } catch (SQLException e) {
            response.getWriter().println("Database error: " + e.getMessage());
        }
    }
}
