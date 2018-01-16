package com.tu.lunchy.util;

import com.tu.lunchy.dao.objects.Meal;

public class CheckUtil {

	public static boolean isValidMeal(Meal meal) {
		
		if(isValidString(meal.getMealName()) && isValidString(meal.getDescription()) && isValidString(meal.getIngredients())) {
			return true;
		}
		
		return false;
	}
	
	private static boolean isValidString(String value) {
		
		if(value != null) {
			if(!value.equals("")) {
				return true;
			}
		}
		return false;
	}
}
