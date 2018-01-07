package com.tu.lunchy.database;

import java.sql.SQLException;
import java.util.List;

import com.tu.lunchy.dao.impl.OrderDaoImpl;
import com.tu.lunchy.dao.objects.Order;

public class Test {
	

	public static void main(String[] args) throws SQLException {
		OrderDaoImpl us = new OrderDaoImpl();
		
		//User user = us.getUser("dimana", "dimana");

		
		List<Order> user2 = us.getAllOrders();
		System.out.println(user2);
	}

}
