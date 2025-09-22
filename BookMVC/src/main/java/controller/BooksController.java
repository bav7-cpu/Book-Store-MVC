// this controller class connects to the DAO and handles HTTP requests to display paginated lists of books in the application
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAOEnum;
import models.Book;

@WebServlet("/books")
public class BooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private BookDAOEnum dao;
	
	public BooksController() {
		this.dao = BookDAOEnum.INSTANCE;
	}
	// this method handles GET requests and loads paginated books to the JSP view
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int page = 1;
			int pageSize = 10;

			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (Exception ignored) {
				
			}
			
			
			ArrayList<Book> booksPage = dao.getBooksByPage(page, pageSize);
			int totalBooks = dao.getBookCount();
		
			int totalPages = (totalBooks + pageSize - 1) / pageSize;


			// Calculate page links for JSP using conditional operators
			// this concept:		(condition) ? valueIfTrue : valueIfFalse;
			Integer previousPage = (page > 1) ? page - 1 : null;
			Integer nextPage = (page < totalPages) ? page + 1 : null;

		
			request.setAttribute("books", booksPage);
			request.setAttribute("currentPage", page);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("previousPage", previousPage);
			request.setAttribute("nextPage", nextPage);

			RequestDispatcher rd = request.getRequestDispatcher("books.jsp");
			rd.forward(request, response);
		}
	}

