package com.pfa.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static Connection conn= null ;
	
	public static Connection connect(String databaseName){
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
				
		} catch (ClassNotFoundException e) {	
				e.printStackTrace();
		}
		
		try {
			// connect way #1
			String url1 = "jdbc:mysql://localhost:3306/"+databaseName+"?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url1, user, password);
		}
		catch (Exception e) {	
			e.printStackTrace();
		}
	            
	            
	    if(conn == null){
	            	System.out.println("error ");
	    }
	    else{
	    	System.out.print("it is okay !!");
	    }
		
		return conn;
	}
}
