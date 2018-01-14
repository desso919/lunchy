package com.tu.lunchy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tu.lunchy.dao.objects.Meal;
import com.tu.lunchy.dao.objects.Menu;
import com.tu.lunchy.database.DatabaseConnection;

public class MenuDaoImpl {

	public static Menu getMenu(int menuId) {
		Connection connection = DatabaseConnection.getConnection();
		Menu menu = new Menu();

		String selectQuery = "select * from menus where menu_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, menuId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				menu.setMenuName(resultSet.getString("menu_name"));
				menu.setMealsForThisMenu(getMealsForMenu(connection, menuId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menu;
	}
	
	public static String getMenuName(int menuId) {
		Connection connection = DatabaseConnection.getConnection();
		String menuName = null;

		String selectQuery = "select menu_name from menus where menu_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, menuId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				menuName = resultSet.getString("menu_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuName;
	}
	
	public static List<Menu> getMenus() {
		Connection connection = DatabaseConnection.getConnection();
		List<Menu> menus = new ArrayList<Menu>();

		String selectQuery = "select * from menus";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int menuId = resultSet.getInt("menu_id");
				String menuName = resultSet.getString("menu_name");
				List<Meal> mealsForMenu = getMealsForMenu(connection, menuId);
				
				menus.add(new Menu(menuId, menuName, mealsForMenu));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menus;
	}


	private static List<Meal> getMealsForMenu(Connection connection, int menuId) throws SQLException {
		List<Integer> mealIds = new ArrayList<Integer>();

		String selectQuery = "select * from menu_meals where menu_id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setInt(1, menuId);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			mealIds.add(resultSet.getInt("meal_id"));
		}

		return getMealsById(mealIds);
	}

	private static List<Meal> getMealsById(List<Integer> mealIds) throws SQLException {
		MealDaoImpl mealDaoImpl = new MealDaoImpl();
		List<Meal> meals = new ArrayList<Meal>();

		for (Integer mealId : mealIds) {
			Meal meal = mealDaoImpl.getMeal(mealId);
			meals.add(meal);
		}

		return meals;
	}

}
