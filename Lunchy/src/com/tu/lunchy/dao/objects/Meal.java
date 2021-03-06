package com.tu.lunchy.dao.objects;

public class Meal {

	private int mealId;
	private String mealName;
	private String description;
	private String ingredients;
	private double price;

	public Meal() {
	}

	public Meal(String mealName, String description, String ingredients, double price) {
		this.mealName = mealName;
		this.description = description;
		this.ingredients = ingredients;
		this.price = price;
	}

	public Meal(int mealId, String mealName, String description, String ingredients, double price) {
		this.mealId = mealId;
		this.mealName = mealName;
		this.description = description;
		this.ingredients = ingredients;
		this.price = price;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Meal [mealId=" + mealId + ", mealName=" + mealName + ", description=" + description + ", ingredients="
				+ ingredients + ", price=" + price + "]";
	}

}
