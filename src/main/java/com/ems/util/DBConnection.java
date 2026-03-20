package com.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static final String URL = "jdbc:postgresql://localhost:5432/ems";
	public static final String USERNAME = "db_username";
	public static final String PASSWORD = "db_password";
	
	public static Connection createConnection() {
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver"); 
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
