package com.tu.lunchy.dao.objects;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private int menuId;
	private String menuName;
	private List<Meal> mealsForThisMenu = new ArrayList<Meal>();

	public Menu() {
	}

	public Menu(String menuName, List<Meal> mealsForThisMenu) {
		this.menuName = menuName;
		this.mealsForThisMenu = mealsForThisMenu;
	}

	public Menu(int menuId, String menuName, List<Meal> mealsForThisMenu) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.mealsForThisMenu = mealsForThisMenu;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public List<Meal> getMealsForThisMenu() {
		return mealsForThisMenu;
	}

	public void setMealsForThisMenu(List<Meal> mealsForThisMenu) {
		this.mealsForThisMenu = mealsForThisMenu;
	}

	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", mealsForThisMenu=" + mealsForThisMenu + "]";
	}

}
