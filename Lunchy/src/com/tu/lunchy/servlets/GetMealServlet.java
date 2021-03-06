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
 * Servlet implementation class GetMealServlet
 */
@WebServlet("/GetMealServlet")
public class GetMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//int mealId = request.getParameter("mealId");
		PrintWriter out = response.getWriter();
		Meal meal = MealDaoImpl.getMeal(1);

		if (meal != null) {
			out.println("<h1> Meal </h1>");
			out.println("<h3> " + meal.toString() + " </h3>");
		} else {
			out.println("<h1> Meal </h1>");
			out.println("<h3> Meal not found </h3>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
