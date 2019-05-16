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

@WebServlet("/UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {

    CustomerService customerService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String zip = request.getParameter("zip");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        Customer cus = new Customer(name,password,zip,address,telephone,email);
        customerService = new CustomerServiceImpl();
        String url = "";

        try {
            customerService.updateCustomer(cus);
            request.getSession().removeAttribute("customer");
            request.getSession().setAttribute("customer",cus);
            url = "/userinfo.jsp";
        } catch (CustomerException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher(url).forward(request, response);


    }
}
