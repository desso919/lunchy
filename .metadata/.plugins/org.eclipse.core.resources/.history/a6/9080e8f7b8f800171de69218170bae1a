package com.tu.lunchy.util;

public enum UserType {

	ADMINISTRATOR, RESTAURANT_WORKER, CLIENT, UNKNOWN;

	public static UserType getUserType(int userType) {
		if (userType == 1) {
			return UserType.ADMINISTRATOR;
		} else if (userType == 2) {
			return UserType.RESTAURANT_WORKER;
		} else if (userType == 3) {
			return UserType.CLIENT;
		}

		return UserType.UNKNOWN;
	}

}
