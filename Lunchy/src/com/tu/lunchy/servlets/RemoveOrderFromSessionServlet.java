package com.tu.lunchy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tu.lunchy.util.Orders;
import com.tu.lunchy.util.SessionUtil;

/**
 * Servlet implementation class RemoveOrderFromSessionServlet
 */
@WebServlet("/RemoveOrderFromSessionServlet")
public class RemoveOrderFromSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveOrderFromSessionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Orders orders = SessionUtil.getUserOrders(request);

		if (orders != null) {
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			orders.removeOrder(orderId);
			
			SessionUtil.updateUserOrders(request, orders);
		}

		// redirect to my orders page anyway
		response.sendRedirect("web/MyOrdersPage.jsp");
	}

}
