package com.tu.lunchy.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tu.lunchy.dao.impl.MealDaoImpl;
import com.tu.lunchy.dao.objects.Meal;

/**
 * Servlet implementation class AddNewMeal
 */
@WebServlet("/AddNewMeal")
public class AddNewMeal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewMeal() {
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

		Meal meal = new Meal();
		meal.setMealName(request.getParameter("meal_name"));
		meal.setDescription(request.getParameter("description"));
		meal.setIngredients(request.getParameter("ingredients"));
		meal.setPrice(Double.parseDouble(request.getParameter("price")));

		boolean isAdded = MealDaoImpl.addMeal(meal);

		if (isAdded) {
			PrintWriter out = response.getWriter();
			out.println("<h1>Added succesfully</h1>");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<h1> Failed to add new meal</h1>");
		}
	}

}
