package com.tu.lunchy.dao.impl;

import com.tu.lunchy.dao.objects.User;
import com.tu.lunchy.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl {

	public static User getUser(String username, String password) {
		Connection connection = DatabaseConnection.getConnection();
		User user = null;

		String selectQuery = "select * from users where username = ? and password = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int userid = resultSet.getInt("user_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				int account_type = resultSet.getInt("account_type_id");

				user = new User(userid, firstName, lastName, username, password, account_type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public static User getUserByUsername(String username) {
		Connection connection = DatabaseConnection.getConnection();
		User user = null;

		String selectQuery = "select * from users where username = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int userid = resultSet.getInt("user_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String password = resultSet.getString("password");
				int account_type = resultSet.getInt("account_type_id");

				user = new User(userid, firstName, lastName, username, password, account_type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	public static User getUserById(int userId) {
		Connection connection = DatabaseConnection.getConnection();
		User user = null;

		String selectQuery = "select * from users where user_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int userid = resultSet.getInt("user_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String username = resultSet.getString("username");
				int account_type = resultSet.getInt("account_type_id");

				user = new User(userid, firstName, lastName, username, "", account_type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	

	public static boolean addUser(User user) {
		Connection connection = DatabaseConnection.getConnection();
		String sqlQuery = "INSERT INTO users (username, password, first_name, last_name, account_type_id) VALUES (?, ?, ?, ?, ?)";
		int result = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstName());
			preparedStatement.setString(4, user.getLastName());
			preparedStatement.setInt(5, user.getAccountType());
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
