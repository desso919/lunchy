package com.tu.lunchy.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tu.lunchy.dao.objects.Order;
import com.tu.lunchy.util.Orders;
import com.tu.lunchy.util.SessionUtil;

/**
 * Servlet implementation class UpdateOrderedForTimeServlet
 */
@WebServlet("/UpdateOrderedForTimeServlet")
public class UpdateOrderedForTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderedForTimeServlet() {
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
    	Orders orders = SessionUtil.getUserOrders(request);
 
    	if(orders != null) {
    		int orderId = Integer.parseInt(request.getParameter("orderId"));
    		String orderForTime = request.getParameter("orderForTime");
    		if(orderForTime != null) {
    			LocalTime time = LocalTime.parse(orderForTime);
    			LocalDate date = LocalDate.now();
    			LocalDateTime datetime = LocalDateTime.of(date, time);
    			Timestamp orderForDateTime =  Timestamp.valueOf(datetime);
        		
        		for(Order order : orders.getOrders()) {
        			if(order.getOrderId() == orderId) {
        				order.setOrederedForTime(orderForDateTime);
        			}
        		}
        		SessionUtil.updateUserOrders(request, orders);
    		}
    		response.sendRedirect("web/MyOrdersPage.jsp");
    	} else {
    		response.sendRedirect("web/HomePage.jsp");
    	}
	}

}
