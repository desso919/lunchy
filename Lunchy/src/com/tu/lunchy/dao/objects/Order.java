package com.tu.lunchy.dao.objects;

import java.sql.Timestamp;

public class Order {

	private int orderId;
	private int userId;
	private int menuId;
	private int mealId;
	private String orderStatus;
	private String MenuName;
	private boolean isOrderedForTheOffice;
	private Timestamp orederTime;
	private Timestamp orederedForTime;

	public Order() {
	}

	public Order(int userId, int menuId, int mealId, String orderStatus, boolean isOrderedForTheOffice,
			Timestamp orederTime, Timestamp orederedForTime) {
		this.userId = userId;
		this.menuId = menuId;
		this.mealId = mealId;
		this.orderStatus = orderStatus;
		this.isOrderedForTheOffice = isOrderedForTheOffice;
		this.orederTime = orederTime;
		this.orederedForTime = orederedForTime;
	}

	public Order(int orderId, int userId, int menuId, int mealId, String orderStatus, boolean isOrderedForTheOffice,
			Timestamp orederTime, Timestamp orederedForTime) {
		this.orderId = orderId;
		this.userId = userId;
		this.menuId = menuId;
		this.mealId = mealId;
		this.orderStatus = orderStatus;
		this.isOrderedForTheOffice = isOrderedForTheOffice;
		this.orederTime = orederTime;
		this.orederedForTime = orederedForTime;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public boolean isOrderedForTheOffice() {
		return isOrderedForTheOffice;
	}

	public void setOrderedForTheOffice(boolean isOrderedForTheOffice) {
		this.isOrderedForTheOffice = isOrderedForTheOffice;
	}

	public Timestamp getOrederTime() {
		return orederTime;
	}

	public String getMenuName() {
		return MenuName;
	}

	public void setMenuName(String menuName) {
		MenuName = menuName;
	}

	public void setOrederTime(Timestamp orederTime) {
		this.orederTime = orederTime;
	}

	public Timestamp getOrederedForTime() {
		return orederedForTime;
	}

	public void setOrederedForTime(Timestamp orederedForTime) {
		this.orederedForTime = orederedForTime;
	}
	
	

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", menuId=" + menuId + ", mealId=" + mealId
				+ ", orderStatus=" + orderStatus + ", isOrderedForTheOffice=" + isOrderedForTheOffice + ", orederTime="
				+ orederTime + ", orederedForTime=" + orederedForTime + "]";
	}

}
