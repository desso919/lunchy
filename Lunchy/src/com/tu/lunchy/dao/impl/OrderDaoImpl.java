package com.tu.lunchy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tu.lunchy.dao.objects.Order;
import com.tu.lunchy.database.DatabaseConnection;

public class OrderDaoImpl {

	private static final String ORDER_STATUS_ACCEPTED = "ACCEPTED";

	public List<Order> getAllOrders() throws SQLException {
		Connection connection = DatabaseConnection.getConnection();
		List<Order> allOrders = new ArrayList<Order>();

		String selectQuery = "select * from orders";

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
					convertIntToBoolean(isOrderedForTheOffice), orderTime, orderedForTime));
		}

		return allOrders;
	}

	public boolean addOrder(Order order) throws SQLException {
		Connection connection = DatabaseConnection.getConnection();

		String selectQuery = "INSERT INTO orders (user_id, menu_id, meal_id, order_status, is_oredred_for_office, order_time, order_for_time) VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setInt(1, order.getUserId());
		preparedStatement.setInt(2, order.getMenuId());
		preparedStatement.setInt(3, order.getMealId());
		preparedStatement.setString(4, ORDER_STATUS_ACCEPTED);
		preparedStatement.setInt(5, convertBooleanToInt(order.isOrderedForTheOffice()));
		preparedStatement.setTimestamp(6, order.getOrederTime());
		preparedStatement.setTimestamp(7, order.getOrederedForTime());

		int result = preparedStatement.executeUpdate();

		if (result > 0) {
			return true;
		}

		return false;
	}

	private int convertBooleanToInt(boolean booleanValue) {
		return booleanValue ? 1 : 0;
	}

	private Boolean convertIntToBoolean(int intValue) {
		if (intValue == 1) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}
}
