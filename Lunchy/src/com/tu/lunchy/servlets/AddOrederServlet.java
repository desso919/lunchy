package com.tu.lunchy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tu.lunchy.dao.impl.MealDaoImpl;
import com.tu.lunchy.dao.impl.OrderDaoImpl;
import com.tu.lunchy.dao.impl.UserDaoImpl;
import com.tu.lunchy.dao.objects.Meal;
import com.tu.lunchy.dao.objects.Order;
import com.tu.lunchy.dao.objects.User;
import com.tu.lunchy.util.CookieUtil;
import com.tu.lunchy.util.OrderStatus;
import com.tu.lunchy.util.Util;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = new Order();
		User user = null;
		
    	HttpSession session = request.getSession(false);
    	
    	if(session != null) {
    		 user = (User) session.getAttribute("user");
    	}

		order.setUserId(user.getUserId());
		order.setMealId(Integer.parseInt(request.getParameter("mealId")));
		order.setMenuId(Integer.parseInt(request.getParameter("menuId")));
		order.setOrderedForTheOffice(Util.convertIntToBoolean(Integer.parseInt(request.getParameter("isOrderedForTheOffice"))));
		order.setOrederedForTime(Util.convertStringToTimestamp(request.getParameter("isOrderedForTheOffice")));		
		order.setOrederTime(Util.getCurrentTimestamp());
		order.setOrderStatus(OrderStatus.ACCEPTED.toString());
		
		boolean isAdded = OrderDaoImpl.addOrder(order);

		if (isAdded) {
			PrintWriter out = response.getWriter();
			out.println("<h1>Added order succesfully</h1>");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<h1> Failed to add new order</h1>");
		}
	}

}
