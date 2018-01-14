package com.tu.lunchy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Currency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tu.lunchy.dao.impl.UserDaoImpl;
import com.tu.lunchy.dao.objects.User;
import com.tu.lunchy.util.Orders;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = UserDaoImpl.getUser(username, password);
		HttpSession session = request.getSession();
		session.setAttribute("LoggedUser", user);
		session.setAttribute("Orders", new Orders());
		session.setMaxInactiveInterval(60*60);
		
		if(user != null) {
			//AccountType userAccountType = AccessUtil.getUserAccess(user.getAccountType());
			response.sendRedirect("web/HomePage.jsp");
			
		} else {
			PrintWriter out = response.getWriter();
			out.println("<h1> Login failed</h1>");
		}
		
	}

}
