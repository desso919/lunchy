package com.tu.lunchy.database;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Currency;

import com.tu.lunchy.util.Util;

public class Test {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
	public static void main(String[] args) throws SQLException {

		String orderForTime = "05:01";
		if(orderForTime != null) {
			LocalTime time = LocalTime.parse(orderForTime);
			LocalDate today = LocalDate.now();
			LocalDateTime datetime = LocalDateTime.of(today, time);
			Timestamp orderForDateTime =  Timestamp.valueOf(datetime);
			System.out.println("HERE: " + orderForDateTime.toString());
			
		}
    		
	}

}
