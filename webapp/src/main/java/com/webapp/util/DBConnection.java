package com.webapp.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/testjava";
	private static final String USERNAME="root";
	private static final String PASSWORD="admin";
	private static Connection connection=null;
	
	public static Connection openConnection() {
		
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return connection;
		
	}
	
	
	public static void closeConnection() {
		try {
			if(connection!=null) {
				connection.close();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
