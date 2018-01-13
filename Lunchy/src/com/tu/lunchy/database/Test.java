package com.tu.lunchy.database;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Test {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
	public static void main(String[] args) throws SQLException {

		 //method 1
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        
        System.out.println(Timestamp.valueOf(sdf.format(new Timestamp(System.currentTimeMillis()))).toString());

	}

}
