package com.tu.lunchy.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tu.lunchy.dao.impl.MenuDaoImpl;
import com.tu.lunchy.dao.objects.Menu;

/**
 * Servlet implementation class ShowMenuServlet
 */
@WebServlet("/ShowMenuServlet")
public class ShowMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMenuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Menu menu = MenuDaoImpl.getMenu(1);

		if (menu != null) {
			out.println("<h1> Menu </h1>");
			out.println("<h3> " + menu.toString() + " </h3>");
		} else {
			out.println("<h1> Menu </h1>");
			out.println("<h3> Menu not found </h3>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
