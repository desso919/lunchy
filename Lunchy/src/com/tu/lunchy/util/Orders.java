package com.tu.lunchy.util;

import java.util.ArrayList;
import java.util.List;

import com.tu.lunchy.dao.impl.MealDaoImpl;
import com.tu.lunchy.dao.objects.Order;

public class Orders {

	private List<Order> orders = new ArrayList<Order>();
	private int orderId = 1;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public double getOrdersPrice() {
		return getAllOrdersPrice();
	}

	public boolean addOrder(Order order) {

		if (order != null) {
			order.setOrderId(orderId++);
			return orders.add(order);
		}
		return false;
	}

	public boolean removeOrder(int orderId) {
		for (Order order : orders) {
			if (order.getOrderId() == orderId) {
				return orders.remove(order);
			}
		}
		return false;
	}

	public int getOrdersCount() {
		return orders.size();
	}

	private double getAllOrdersPrice() {
		double allOrderPrice = 0;

		for (Order order : orders) {
			double orderPrice = MealDaoImpl.getMeal(order.getMealId()).getPrice();
			allOrderPrice = allOrderPrice + orderPrice;
		}
		return allOrderPrice;
	}
	
	public void removeAll () {
		orders.clear();
	}
}
