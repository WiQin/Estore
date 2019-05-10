package wyw.web.servlet;

import wyw.bean.Customer;
import wyw.service.CustomerService;
import wyw.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    CustomerService service;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String zip = request.getParameter("zip");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        Customer customer = new Customer(name, password, zip, address, telephone, email);
        service = new CustomerServiceImpl();
        String url = "";
        try {
            service.saveCustomer(customer);
            url = "/login.jsp";
        } catch (/*Customer*/Exception e) {
            url = "/register.jsp";
            e.printStackTrace();
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
