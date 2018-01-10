package com.tu.lunchy.dao.impl;

import com.tu.lunchy.dao.objects.User;
import com.tu.lunchy.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl {

	public User getUser(String username, String password) {
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
				int account_type = resultSet.getInt("account_type_id");

				user = new User(userid, username, password, account_type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public boolean addUser(User user) {
		Connection connection = DatabaseConnection.getConnection();
		String sqlQuery = "INSERT INTO users (username, password, account_type_id) VALUES (?, ?, ?)";
		int result = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			;
			preparedStatement.setInt(3, user.getAccountType());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result > 0) {
			return true;
		}

		return false;
	}
}
