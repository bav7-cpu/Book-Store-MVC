// this controller class connects to the DAO and handles HTTP requests for adding a new book in the application
package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAOEnum;
import models.Book;


@WebServlet("/newbooks")
public class NewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAOEnum dao;
	
	public NewBook() {
		this.dao = BookDAOEnum.INSTANCE;
	}

	// this method handles GET requests to show the form for adding a new book
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("addbook.jsp");

		rd.include(request, response);
	}

	// this method handles POST requests to add a new book to the database
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String Title = request.getParameter("title");
        String Author = request.getParameter("author");
        String Date = request.getParameter("date");
        String Genres = request.getParameter("genres");
        String Characters = request.getParameter("characters");
        String Synopsis = request.getParameter("synopsis"); 
		 if (!Title.isEmpty() && !Author.isEmpty() && !Date.isEmpty() && !Genres.isEmpty() && !Characters.isEmpty() && !Synopsis.isEmpty()) {
		       
		        try {
		            boolean successful = dao.insertBook(new Book(Title, Author, Date, Genres, Characters, Synopsis));
		            if (successful) {
		            	response.sendRedirect("books");
		            } else {
		                response.getWriter().println("Book could not be added, please try again.");
		            }
		        } catch (SQLException e) {
		            response.getWriter().println("Error with the database:     " + e.getMessage() + " please try again.");
		        }
		    } else {
		        response.getWriter().println("No characteristics of the book can be empty, please try again.");
		    }
		
	
		
		
	}

}
