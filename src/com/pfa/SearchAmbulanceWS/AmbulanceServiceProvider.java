package com.pfa.SearchAmbulanceWS;

import java.io.Serializable;

public class AmbulanceServiceProvider implements Serializable {
	

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Attributes
	 */
	
	private int ambulanceServicePRoviderID;
	private String  ambulanceServiceProviderName;
	private String  city;
	private Double latitude; 
	private Double longitude; 
	private String phoneNumber;
	
	/*
	 * constructor with no arguments 
	 */
	
	public AmbulanceServiceProvider(){}

	/*
	 *  Constructor with all attributes as argument
	 */
	
	public  AmbulanceServiceProvider(int ambulanceServicePRoviderID, String ambulanceServiceProviderName,String city,
						              double latitude, Double longitude, String phoneNumber){
			this.ambulanceServicePRoviderID = ambulanceServicePRoviderID;
			this.ambulanceServiceProviderName = ambulanceServiceProviderName;
			this.city = city;
			this.latitude = latitude;
			this.longitude = longitude;
			this.longitude = longitude;
			this.phoneNumber = phoneNumber;
		 }
		
	/*
	 *  getters and setters
	 */
	public int getAmbulanceServicePRoviderID() {
		return ambulanceServicePRoviderID;
	}
	public void setAmbulanceServicePRoviderID(int ambulanceServicePRoviderID) {
		this.ambulanceServicePRoviderID = ambulanceServicePRoviderID;
	}
	public String getAmbulanceServiceProviderName() {
		return ambulanceServiceProviderName;
	}
	public void setAmbulanceServiceProviderName(String ambulanceServiceProviderName) {
		this.ambulanceServiceProviderName = ambulanceServiceProviderName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
