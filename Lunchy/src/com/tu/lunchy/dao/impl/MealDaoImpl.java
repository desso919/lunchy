package com.tu.lunchy.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tu.lunchy.dao.objects.Meal;
import com.tu.lunchy.database.DatabaseConnection;

public class MealDaoImpl {

	public static Meal getMeal(int mealId) {
		Connection connection = DatabaseConnection.getConnection();
		Meal meal = null;

		String selectQuery = "select * from meals where meal_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, mealId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String mealName = resultSet.getString("meal_name");
				String description = resultSet.getString("description");
				String ingredients = resultSet.getString("ingredients");
				String price = resultSet.getString("price");

				meal = new Meal(mealId, mealName, description, ingredients, Double.valueOf(price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return meal;
	}
	
	public static int getMealIdByName(String name) {
		Connection connection = DatabaseConnection.getConnection();
        int mealId = 0;
        
		String selectQuery = "select * from meals where meal_name = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				mealId = resultSet.getInt("meal_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mealId;
	}

	public static boolean addMeal(Meal meal) {
		Connection connection = DatabaseConnection.getConnection();

		String sqlQuery = "INSERT INTO meals (meal_name, description, ingredients, price) VALUES (?, ?, ?, ?)";
		int result = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, meal.getMealName());
			preparedStatement.setString(2, meal.getDescription());
			preparedStatement.setString(3, meal.getIngredients());
			preparedStatement.setBigDecimal(4, BigDecimal.valueOf(meal.getPrice()));
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (result > 0) {
			return true;
		}

		return false;
	}
	
	public static boolean addMenuMeal(int menuId, int mealId) {
		Connection connection = DatabaseConnection.getConnection();

		String sqlQuery = "INSERT INTO menu_meals (menu_id, meal_id) VALUES (?, ?)";
		int result = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, menuId);
			preparedStatement.setInt(2, mealId);

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (result > 0) {
			return true;
		}

		return false;
	}

}
