package com.pfa.SearchAmbulanceWS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pfa.DatabaseConnection.DbConnection;

public class SearchAmbulance {
	
	public 	ArrayList<AmbulanceServiceProvider> SearchAmbulanceBy(Double[] patientLocation,double[] targetLocation){
		/*
		 * in this method we will look for the nearest Ambulance service provider 
		 * to the patient Or the client location 
		 * than we will return an ordered list of the service  providers 
		 * based on Distance Matrix provided by google maps Api. 
		 * 
		 * Up to this point, We have not used the targetLiocation variable 
		 * so to optimize the service we will calculate the distance need 
		 * to reach the patient location and also the distance needed to 
		 * arrive to the hospital 
		 * 
		 * then We will return an ordered list of AmbulanceService prooviders
		 * 
		 * and that's All :)
		 */
	     
			    
	    ArrayList<AmbulanceServiceProvider>  liste = new ArrayList<AmbulanceServiceProvider>();
		Statement stmt = null;
		try {
			stmt = DbConnection.connect("mydb").createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String query =  "select * from Ambulance_service_proverders ;";
		
		ResultSet rs=null;	
		try{
			rs=stmt.executeQuery(query);	 
			while(rs.next()){  
			liste.add(new AmbulanceServiceProvider(rs.getInt("AmbulanceServiceID"),
					rs.getString("AmbulanceServicename"), rs.getString("city"),rs.getDouble("latitude"),
					rs.getDouble("longitude"), rs.getString("phoneNumber")));  
		}

		}
		catch(Exception e){
			// handling the exception	
		}
		
		return liste;
	    
	}
	
	public static void main(String[] args){
		SearchAmbulance  s =new SearchAmbulance ();
		s.SearchAmbulanceBy([1], [1]);
	}

}
