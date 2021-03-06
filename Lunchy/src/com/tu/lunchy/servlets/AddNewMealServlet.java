package com.tu.lunchy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class AddNewMeal
 */
@WebServlet("/AddNewMealServlet")
public class AddNewMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewMealServlet() {
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

		String mealName = request.getParameter("mealName");
		String menuName = request.getParameter("menuName");
		String mealDescription = request.getParameter("description");
		String mealIngredients = request.getParameter("ingredients");

		double price = Double.parseDouble(request.getParameter("price"));
		Meal meal = new Meal(mealName, mealDescription, mealIngredients, price);

		if (CheckUtil.isValidMeal(meal)) {
			boolean isMealAdded = MealDaoImpl.addMeal(meal, menuName);

			if (isMealAdded) {
				response.sendRedirect("web/AddNewMealPage.jsp");
			} else {
				response.getWriter().println("<h1> Failed to add new meal</h1>");
			}
		} else {
			response.getWriter().println("<h1> Failed to add new meal. Meal values are not correct</h1>");
		}
	}

//	private boolean addMealToMenuMealsTable(String mealName, String menuName) {
//		List<Menu> menus = MenuDaoImpl.getMenus();
//		int menuId = 0;
//
//		for (Menu menu : menus) {
//			if (menu.getMenuName().equalsIgnoreCase(menuName)) {
//				menuId = menu.getMenuId();
//			}
//		}
//
//		int mealId = MealDaoImpl.getMealIdByName(mealName);
//		return MealDaoImpl.addMenuMeal(menuId, mealId);
//	}
}
