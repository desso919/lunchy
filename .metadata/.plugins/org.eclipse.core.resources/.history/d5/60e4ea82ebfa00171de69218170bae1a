package com.tu.lunchy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.tu.lunchy.dao.objects.Order;
import com.tu.lunchy.dao.objects.User;
import com.tu.lunchy.database.DatabaseConnection;
import com.tu.lunchy.util.Util;

public class OrderDaoImpl {

	private static final String ORDER_STATUS_ACCEPTED = "ACCEPTED";

	public static List<Order> getAllOrders() {
		Connection connection = DatabaseConnection.getConnection();
		List<Order> allOrders = new ArrayList<Order>();

		String selectQuery = "select * from orders";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int orderId = resultSet.getInt("order_id");
				int userId = resultSet.getInt("user_id");
				int menuId = resultSet.getInt("menu_id");
				int mealId = resultSet.getInt("meal_id");
				String orderStatus = resultSet.getString("order_status");
				int isOrderedForTheOffice = resultSet.getInt("is_oredred_for_office");
				Timestamp orderTime = resultSet.getTimestamp("order_time");
				Timestamp orderedForTime = resultSet.getTimestamp("order_for_time");

				allOrders.add(new Order(orderId, userId, menuId, mealId, orderStatus,
						Util.convertIntToBoolean(isOrderedForTheOffice), orderTime, orderedForTime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allOrders;
	}
	

	public static List<Order> getAllOrdersForUser(User user) {
		Connection connection = DatabaseConnection.getConnection();
		List<Order> allOrders = new ArrayList<Order>();

		String selectQuery = "select * from orders where user_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, user.getUserId());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int orderId = resultSet.getInt("order_id");
				int userId = resultSet.getInt("user_id");
				int menuId = resultSet.getInt("menu_id");
				int mealId = resultSet.getInt("meal_id");
				String orderStatus = resultSet.getString("order_status");
				int isOrderedForTheOffice = resultSet.getInt("is_oredred_for_office");
				Timestamp orderTime = resultSet.getTimestamp("order_time");
				Timestamp orderedForTime = resultSet.getTimestamp("order_for_time");

				allOrders.add(new Order(orderId, userId, menuId, mealId, orderStatus,
						Util.convertIntToBoolean(isOrderedForTheOffice), orderTime, orderedForTime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allOrders;
	}

	public static boolean addOrder(Order order) {
		Connection connection = DatabaseConnection.getConnection();

		String selectQuery = "INSERT INTO orders (user_id, menu_id, meal_id, order_status, is_oredred_for_office, order_time, order_for_time) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int result = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, order.getUserId());
			preparedStatement.setInt(2, order.getMenuId());
			preparedStatement.setInt(3, order.getMealId());
			preparedStatement.setString(4, ORDER_STATUS_ACCEPTED);
			preparedStatement.setInt(5, Util.convertBooleanToInt(order.isOrderedForTheOffice()));
			preparedStatement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
			preparedStatement.setTimestamp(7, order.getOrederedForTime());

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
