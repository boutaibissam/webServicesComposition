package com.pfa.searchHospitalWS;

import java.util.List;

import com.pfa.Helpers.Location;

public class Hospital {
	/*
	 * Attributes 
	 */
	private String hospitalId;
	private String hospitalName;
	private Location hospitalLocation;
	private List<String> specialities;
	
	/*
	 * Constructors 
	 */
	
	public Hospital(){
		
	}
	
	public Hospital(String hospitalId, String hospitalName, Location hospitalLocation, List<String> specialities){
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.hospitalLocation = hospitalLocation;
		this.specialities = specialities;
	}
	

	/*
	 * setter and getters
	 */

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
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

	public List<String> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(List<String> specialities) {
		this.specialities = specialities;
	}
		
	
}
