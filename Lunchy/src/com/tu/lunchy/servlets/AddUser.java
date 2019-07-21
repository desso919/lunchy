package com.tu.lunchy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tu.lunchy.dao.impl.MealDaoImpl;
import com.tu.lunchy.dao.impl.UserDaoImpl;
import com.tu.lunchy.dao.objects.Meal;
import com.tu.lunchy.dao.objects.User;
import com.tu.lunchy.util.CheckUtil;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser() {
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

		String username = request.getParameter("userName");
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String initialPassword = request.getParameter("password");
		String accountType = request.getParameter("accountType");

		int accontTypeInteger = Integer.parseInt(accountType);
		User user = new User(username, initialPassword, firstname, lastname, accontTypeInteger);

		boolean isUserAdded = UserDaoImpl.addUser(user);

		if (isUserAdded) {
			response.sendRedirect("web/AddUserPage.jsp");
		} else {
			response.getWriter().println("<h1> Failed to add new user</h1>");
		}

	}

}
