package com.tu.lunchy.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tu.lunchy.dao.objects.User;

public class SessionUtil {

	private static final String LOGGED_USER_SESSION_KEY = "LoggedUser";
	private static final String USER_ORDERS_SESSION_KEY = "Orders";

	public static Object getAttribute(HttpServletRequest request, String key) {
		HttpSession httpSession = request.getSession(false);
		return httpSession.getAttribute(key);
	}

	public static void setLoggedInUser(HttpServletRequest request, User user) {
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute(LOGGED_USER_SESSION_KEY, user);
		httpSession.setMaxInactiveInterval(600*600);
	}

	public static void setUserOrders(HttpServletRequest request, Orders orders) {
		HttpSession httpSession = request.getSession(false);
		httpSession.setAttribute(USER_ORDERS_SESSION_KEY, orders);
	}

	public static User getLoggedInUser(HttpServletRequest request) {
		HttpSession httpSession = request.getSession(false);
		return (User) httpSession.getAttribute(LOGGED_USER_SESSION_KEY);
	}

	public static Orders getUserOrders(HttpServletRequest request) {
		HttpSession httpSession = request.getSession(false);
		return (Orders) httpSession.getAttribute(USER_ORDERS_SESSION_KEY);
	}

	public static void updateUserOrders(HttpServletRequest request, Orders orders) {
		HttpSession httpSession = request.getSession(false);
		httpSession.setAttribute(USER_ORDERS_SESSION_KEY, orders);
	}

}
