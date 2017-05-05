package com.pfa.searchHospitalWS;

import java.util.ArrayList;

import com.pfa.Helpers.Location;

public class Hospital {
	/*
	 * Attributes 
	 */
	private int hospitalId;
	private String hospitalName;
	private Location hospitalLocation;
	private ArrayList<String> specialities;
	
	/*
	 * Constructors 
	 */
	
	public Hospital(){
		
	}
	
	public Hospital(int hospitalId, String hospitalName, Location hospitalLocation, ArrayList<String> specialities){
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.hospitalLocation = hospitalLocation;
		this.specialities = specialities;
	}
	

	/*
	 * setter and getters
	 */

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Location getHospitalLocation() {
		return hospitalLocation;
	}

	public void setHospitalLocation(Location hospitalLocation) {
		this.hospitalLocation = hospitalLocation;
	}

	public ArrayList<String> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(ArrayList<String> specialities) {
		this.specialities = specialities;
	}
		
	
}
