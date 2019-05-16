package wyw.web.servlet;

import wyw.bean.Customer;
import wyw.bean.ShipAddress;
import wyw.service.ShipAddressService;
import wyw.service.impl.ShipAddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SaveAddressServlet")
public class SaveAddressServlet extends HttpServlet {

    ShipAddressService shipAddressService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shipuname = request.getParameter("shipuname");
        String adres = request.getParameter("adres");
        String phone = request.getParameter("phone");

        Customer customer = (Customer) request.getSession().getAttribute("customer");

        ShipAddress shipAddress = new ShipAddress(shipuname,adres,phone,customer);

        shipAddressService = new ShipAddressServiceImpl();
        String url = "";

        try{
            shipAddressService.saveShipAddress(shipAddress,customer);
            url = "/confirm.jsp";
        }catch(Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher(url).forward(request, response);



    }
}
