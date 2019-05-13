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
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

    BookService bs;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bs = new BookServiceImpl();
        try {
            List<Book> books = bs.findAllBooks();
            request.getSession().setAttribute("books",books);
            String url = "/indexSuccess.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        } catch (BookException e) {
            e.printStackTrace();
        }
    }
}
