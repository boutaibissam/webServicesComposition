package com.pfa.searchHospitalWS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pfa.DatabaseConnection.DbConnection;

public class SearchHospitalService {
	private static ArrayList<Hospital> hospitalsListBySpeciality;
	private static ArrayList<Hospital> hospitalsListOrdredByLocation;
	
	/*
	 * this function is only used to optimize the google maps api 
	 */
	
	public ArrayList<Hospital> SearchBySpecialty(String speciality){
		
		ResultSet  rs = null;
		
		String query = "select * from  hospitals where hospital_id = "+
					   "select hospital_id from association_table where hospital_id = "+
					   "select speciality_id form specialities where speciality_name = ?";
		String query1 = "select speaciaty_name from  specialities where speciality_id = "+
					    "select speciality_id from association_table where hospital_id = "+
					    " "; 
		try {
			PreparedStatement pst= DbConnection.connect("databaseName").prepareStatement(query);
			pst.setString(1, speciality);
			rs =pst.executeQuery();
			while(rs.next()){
				hospitalsListBySpeciality.add(new Hospital(
						rs.getInt("hospital_id"),
						rs.getString("hospitalName"),
						new Location(rs.getDouble("latitude"), rs.getDoubale("longuitude")),
						new ArrayList<String> liste
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	// this the final service provided to the client 
	public ArrayList<Hospital> HospitalsOrdredByLocation(ArrayList<Hospital> HospitalsBySpeciality){
		return null;
	}
	
	

}
