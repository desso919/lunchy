package com.tu.lunchy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String DATABASE_NAME = "lunchy_db"; 
	private static final String USER = "sa"; 
	private static final String PASSWORD = "abcd1234"; 
	
	static {
		loadDriver();
	}
	
	public static void loadDriver() {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Error loading mysql driver.");
        }
    }

	public static Connection getConnection() {
		Connection conn = null;
		
		try {
		    conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE_NAME + "?user=" + USER + "&password=" + PASSWORD);
		    
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return conn;
	}
}
