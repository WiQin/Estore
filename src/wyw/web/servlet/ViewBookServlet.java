package wyw.web.servlet;

import wyw.bean.Book;
import wyw.service.BookService;
import wyw.service.impl.BookServiceImpl;
import wyw.util.exception.BookException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ViewBookServlet")
public class ViewBookServlet extends HttpServlet {

    BookService bookService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        bookService = new BookServiceImpl();

        try {
            Book book = bookService.findBookById(id);
            request.getSession().setAttribute("book", book);
            String url = "/viewBook.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        } catch (BookException e) {
            e.printStackTrace();
        }
    }
}
