package wyw.web.servlet;

import wyw.bean.Customer;
import wyw.service.CustomerService;
import wyw.service.impl.CustomerServiceImpl;
import wyw.util.exception.CustomerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    CustomerService service;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        service = new CustomerServiceImpl();

        String url = "";
        try {
            Customer customer = service.findCustomerByName(name, password);
            request.getSession().setAttribute("customer",customer);
            url = "/BookServlet";
        } catch (CustomerException e) {
            url = "/login.jsp";
            e.printStackTrace();
        }
        request.getRequestDispatcher(url).forward(request, response);


    }
}
