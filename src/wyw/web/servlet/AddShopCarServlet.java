package wyw.web.servlet;

import wyw.bean.Book;
import wyw.bean.ShoppingCart;
import wyw.service.BookService;
import wyw.service.impl.BookServiceImpl;
import wyw.util.exception.BookException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddShopCarServlet")
public class AddShopCarServlet extends HttpServlet {
    private BookService bs = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //根据前台传过来的书的id和书的本数,调用shopingcart中的addCar()方法,将书添加到购物车中
        long id = Long.parseLong(request.getParameter("id"));
        int num = Integer.parseInt(request.getParameter("num"));

        bs = new BookServiceImpl();
        String url="/viewBook.jsp";
        try {
            Book book = bs.findBookById(id);
            //获取监听器中购物车的对象
            ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");

            /*System.out.println(cart+"购物车对象！");*/

            //调用shopingcart中的addCar()方法,将书添加到购物车中
            cart.addCar(book, num);

            /*System.out.println(cart.getOrderlines());*/

        } catch (BookException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

