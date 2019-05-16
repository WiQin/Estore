package wyw.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wyw.bean.Customer;
import wyw.bean.OrderForm;
import wyw.bean.ShipAddress;
import wyw.bean.ShoppingCart;
import wyw.service.OrderService;
import wyw.service.ShipAddressService;
import wyw.service.impl.OrderServiceImpl;
import wyw.service.impl.ShipAddressServiceImpl;
import wyw.util.exception.OrderServiceException;


/*
 * 提交订单  保存订单
 */
@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderservice;
	private ShipAddressService shipService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		orderservice = new OrderServiceImpl();

		// 从session中取出顾客
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		
		try {
			shipService = new ShipAddressServiceImpl();
			
			ShipAddress shipaddress = shipService.findShipAddressById(customer.getId());
			
			if (shipaddress!= null) {
				// 从购物车中取出所需订单信息
				ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
				OrderForm order = new OrderForm();
				order.setCost(cart.getCost());
				order.setCustomer(customer);
				order.setShipAddress(shipaddress);
				order.setOrderDate(new Date());
				order.setLines(cart.getOrderlines());
				
				// 将订单保存到数据库中
				orderservice.saveOrderForm(order);
				
				System.out.println("执行保存！！！");
				
				cart.removeAll();
				request.getRequestDispatcher("/confirmSuccess.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "请选择或者新增收货地址");
				request.getRequestDispatcher("/confirm.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
