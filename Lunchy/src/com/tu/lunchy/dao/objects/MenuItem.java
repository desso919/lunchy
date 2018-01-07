package com.tu.lunchy.dao.objects;

public class MenuItem {
	
	private int menuId;
	private int mealId;
	private String menuName;
	
	public MenuItem() {
	}
	
	public MenuItem(int mealId, String menuName) {
		this.mealId = mealId;
		this.menuName = menuName;
	}
	
	public MenuItem(int menuId, int mealId, String menuName) {
		this.menuId = menuId;
		this.mealId = mealId;
		this.menuName = menuName;
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
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Override
	public String toString() {
		return "MenuItem [menuId=" + menuId + ", mealId=" + mealId + ", menuName=" + menuName + "]";
	}

	
}
