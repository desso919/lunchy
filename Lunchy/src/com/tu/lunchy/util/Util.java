package com.tu.lunchy.util;

import java.sql.Timestamp;

public class Util {

	public static Boolean convertIntToBoolean(int intValue) {
		if (intValue == 1) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}
	
	public static int convertBooleanToInt(boolean booleanValue) {
		return booleanValue ? 1 : 0;
	}
	
	public static Timestamp convertStringToTimestamp(String timestamp) {
		return Timestamp.valueOf(timestamp);
	}
	
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
}
