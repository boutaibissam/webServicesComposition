package com.pfa.searchHospitalWS;

import com.pfa.DaoFactory.HospitalDaoImp;
import com.pfa.Helpers.Location;

import java.io.IOException;
import java.util.ArrayList;



public class SearchHospitalService {
		
	
	/*
	 *  this the final service provided to the client 
	 */
	public ArrayList<Hospital> HospitalsOrdredByLocation(String speciality, Object patientLocation){
		
		ArrayList<Hospital>  hospitals= new HospitalDaoImp()
				.HospitalsBySpecialty(speciality, patientLocation);
		
		ArrayList<Location> listOflocations = new ArrayList<Location>();
		
		for(Hospital x : hospitals){
			listOflocations.add(x.getHospitalLocation());
		}
		if(patientLocation  instanceof  String){
			try {
				Location.getGeoPointFromAddress((String) patientLocation).calculateDistanceMatrix(listOflocations);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		else if (patientLocation  instanceof  Location){
			((Location)patientLocation).calculateDistanceMatrix(listOflocations);
		}
		
		/*
		 * Ordering no yet implemented 
		 */
		
		return hospitals;
		
	}
	
	
}
