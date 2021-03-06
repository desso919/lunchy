package com.tu.lunchy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tu.lunchy.dao.impl.MenuDaoImpl;
import com.tu.lunchy.dao.objects.Order;
import com.tu.lunchy.util.OrderStatus;
import com.tu.lunchy.util.Orders;
import com.tu.lunchy.util.SessionUtil;

/**
 * Servlet implementation class AddOrderToSessionServlet
 */
@WebServlet("/AddOrderToSessionServlet")
public class AddOrderToSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderToSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = new Order();
	
    	Orders orders = SessionUtil.getUserOrders(request);
 
    	if(orders != null) {  	
    		int menuId = Integer.parseInt(request.getParameter("mealId"));
    		order.setMealId(menuId);
    		order.setMenuName(MenuDaoImpl.getMenuName(menuId));  		
    		order.setUserId(Integer.parseInt(request.getParameter("userId")));
    		order.setMenuId(Integer.parseInt(request.getParameter("menuId")));
    		order.setOrderStatus(OrderStatus.PENDING.toString());

    		boolean isAdded = orders.addOrder(order);
    		
    		if (isAdded) {
    			SessionUtil.updateUserOrders(request, orders);
    			response.sendRedirect("web/MenuPage.jsp");
    		} else {
    			response.getWriter().println("<h1> Failed to add new order</h1>");
    		}
    		
    	} else {
    		response.sendRedirect("web/HomePage.jsp");
    	}

	}

}
