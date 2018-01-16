package com.tu.lunchy.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tu.lunchy.dao.impl.MealDaoImpl;
import com.tu.lunchy.dao.impl.MenuDaoImpl;
import com.tu.lunchy.dao.objects.Meal;
import com.tu.lunchy.dao.objects.Menu;
import com.tu.lunchy.util.CheckUtil;

/**
 * Servlet implementation class AddMenuServlet
 */
@WebServlet("/AddMenuServlet")
public class AddMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMenuServlet() {
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
		String mealName = request.getParameter("menuName");

		if(mealName != null) {
			boolean isAdded = MenuDaoImpl.addMenu(new Menu(mealName));

			if (!isAdded) {
				PrintWriter out = response.getWriter();
				out.println("<h1> Failed to add new menu</h1>");
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<h1> Failed to add new menu. Menu name is not correct</h1>");
		}
	}

}
