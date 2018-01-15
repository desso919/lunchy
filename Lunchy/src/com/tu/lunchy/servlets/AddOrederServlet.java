package com.tu.lunchy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tu.lunchy.dao.impl.OrderDaoImpl;
import com.tu.lunchy.dao.objects.Order;
import com.tu.lunchy.util.OrderStatus;
import com.tu.lunchy.util.Orders;
import com.tu.lunchy.util.SessionUtil;

/**
 * Servlet implementation class AddOrederServlet
 */
@WebServlet("/AddOrederServlet")
public class AddOrederServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOrederServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Orders orders = SessionUtil.getUserOrders(request);

		if(orders != null) {
			for (Order order : orders.getOrders()) {
				order.setOrderStatus(OrderStatus.ACCEPTED.toString());
				boolean isAdded = OrderDaoImpl.addOrder(order);

				if (!isAdded) {
					order.setOrderStatus(OrderStatus.FAILED.toString());
				}
			}

			SessionUtil.updateUserOrders(request, orders);
			
			// redirect to my orders page anyway
			response.sendRedirect("web/MyOrdersPage.jsp");
		} else {
			// redirect to login page
			response.sendRedirect("index.html");
		}
	}

}
