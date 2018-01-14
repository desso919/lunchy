package com.tu.lunchy.util;

public class AccessUtil {


	public static AccountType getUserAccess(int userType) {
		if (userType == 1) {
			return AccountType.ADMINISTRATOR;
		} else if (userType == 2) {
			return AccountType.RESTAURANT_WORKER;
		} else if (userType == 3) {
			return AccountType.CLIENT;
		}

		return AccountType.UNKNOWN;
	}
}
