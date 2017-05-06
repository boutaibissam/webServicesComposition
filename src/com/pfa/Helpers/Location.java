package com.pfa.Helpers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
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
	 * position using DistanceMatrix 
	 * provided bye Google Maps Api.
	 * 
	 */	
	public DistanceMatrix calculateDistanceMatrix(ArrayList<Location> listOflocations ){
		DistanceMatrix matrix_ = null;
		DistanceMatrixApiRequest req=null;
		ArrayList<String> dest =new ArrayList<String>();
		String[] destinations =null;
		/* 
		 * origins[one origin ]
		 * 
		 * destinations(multiple destination )
		 * 
		 */
		LatLng origin=new LatLng(this.getLatitude() ,this.getLonguitude());
		//
		for (Location x: listOflocations){
			 LatLng destination=new LatLng(x.getLatitude(),x.getLonguitude()); 
			 dest.add(destination.toString());
			 destinations = new String[dest.size()];
			 dest.toArray(destinations);
		}
	   
	    
		try {
			req = DistanceMatrixApi.newRequest(context);
			matrix_ = req.origins(origin)
		        		.destinations(destinations)
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
	
	
	
	
	public static Location getGeoPointFromAddress(String locationAddress) throws IOException {
		Double lat = null, lon = null;
        String locationAddres = locationAddress.replaceAll(" ", "%20");
        String str = "http://maps.googleapis.com/maps/api/geocode/json?address="
                + locationAddres;
        HttpURLConnection connection = null;
        URL url = new URL(str);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
                
        connection.setUseCaches(false);
        connection.setDoOutput(true);

        //Send request
        DataOutputStream wr = new DataOutputStream (
            connection.getOutputStream());
        wr.close();
        
        /*
         * Get Response  
         */
        InputStream in = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));
        StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
        String line;
        while ((line = rd.readLine()) != null) {
          response.append(line);
          response.append('\r');
        }
        rd.close();
        
        /*
         * HttpResponse to JsonObject to get latitude and longitude
         */

        JSONObject json;
        try {
            json = new JSONObject( response.toString());
            JSONObject geoMetryObject = new JSONObject();
            JSONObject locations = new JSONObject();
            JSONArray jarr = json.getJSONArray("results");
            int i;
            for (i = 0; i < jarr.length(); i++) {
                json = jarr.getJSONObject(i);
                geoMetryObject = json.getJSONObject("geometry");
                locations = geoMetryObject.getJSONObject("location");
                lat = locations.getDouble("lat");
                lon = locations.getDouble("lng");
               
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return new Location(lat,lon);
	} 
	
}
