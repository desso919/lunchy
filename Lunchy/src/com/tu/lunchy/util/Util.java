package com.tu.lunchy.util;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

public class Util {

	public static Currency APPLICATION_CURRENCY;
	
	static {
		setDefaultApplicationCurrency(Currency.getInstance("BGN"));
	}

	public static Boolean convertIntToBoolean(int intValue) {
		if (intValue == 1) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	public static List<String> getSupportedCurrencies() {
		return Arrays.asList(Currency.getInstance("BGN").toString(), Currency.getInstance("EUR").toString(), Currency.getInstance("USD").toString());
	}
	
	public static boolean setDefaultApplicationCurrency(Currency currency){
		List<String> allSupportedCurrencies = getSupportedCurrencies();
		
		for (String currencyText : allSupportedCurrencies) {
			if(currencyText.equals(currency.toString())) {
				APPLICATION_CURRENCY = currency;
				return true;
			}
		}
		return false;
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
