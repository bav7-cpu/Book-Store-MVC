// this controller class connects to the DAO and handles HTTP requests for deleting a book in the application
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

@WebServlet("/deletebook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
private BookDAOEnum dao;
	
	public DeleteBook() {
		this.dao = BookDAOEnum.INSTANCE;
	} 
	
	// this method handles GET requests to load a specific book for deletion confirmation
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book b = dao.selectBooks(id);
		request.setAttribute("b", b);
		RequestDispatcher rd = request.getRequestDispatcher("deletebook.jsp");
		rd.include(request, response);
	}


    // this method handles POST requests to perform the actual deleting of a book
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int id = Integer.parseInt(request.getParameter("id"));
            


            try {
                boolean deleted = dao.deleteBook(new Book (id));
                if (deleted) {
                	response.sendRedirect("books");
                } else {
                	response.getWriter().println("Book with ID " + id + " not found or could not be deleted.");
                }
            } catch (SQLException e) {
            	response.getWriter().println("Database error: " + e.getMessage());
            }

	}
}
