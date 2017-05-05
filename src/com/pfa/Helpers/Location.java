package com.pfa.Helpers;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;

public class Location implements Serializable {
	private static final String API_KEY = "AIzaSyDvZxwxhsqsbykt9Sb8ja--KsaLO0YOpPk";
	private static final GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/*
	 * Class Attributes 
	 */
	private Double latitude;
	private Double longuitude;
	
	/*
	 * Constructor with no argurment 
	 */
	public Location(){
		
	}
	
	/*
	 * Constructor with arguments 
	 */
	
	public Location(Double latitude, Double longuitude){
		this.latitude = latitude;
		this.longuitude = longuitude;
	
	}
	/*
	 * Setters and Getters
	 */
	
	public Double getLatitude() {
		return latitude;
	}



	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}



	public Double getLonguitude() {
		return longuitude;
	}



	public void setLonguitude(Double longuitude) {
		this.longuitude = longuitude;
	}

	/*
	 * This method calculate the distance between to 
	 * position using Distance Matrix api
	 * provided bye Google Maps Api.
	 * 
	 */

	public double calculateDistance(Location location){
		return 1.0;
	}
	
	public DistanceMatrix calculateDistanceMatrix(ArrayList<Location> listOflocations ){
		DistanceMatrix matrix_ = null;
		DistanceMatrixApiRequest req=null;
		/* 
		 * origins[one origin ]
		 * 
		 * destinations(multiple destination )
		 * 
		 */
		try {
			req = DistanceMatrixApi.newRequest(context);
			matrix_ = req.origins("rabat morocco")
		        		.destinations("casablanca morocco")
		                .mode(TravelMode.DRIVING)
		                .avoid(RouteRestriction.HIGHWAYS)
		                .language("fr-FR")
		                .await();
		} 
		catch (Exception e) {
		        System.out.println(e.getMessage());
		}
		    	
		return matrix_;
	}

}
