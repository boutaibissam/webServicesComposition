package com.pfa.SearchAmbulanceWS;

import java.util.ArrayList;

import com.pfa.Helpers.Location;

public class SearchAmbulance {
	
	public 	ArrayList<AmbulanceServiceProvider> SearchAmbulanceBy(Location patientLocation, Location targetLocation){
		
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
	     
			    
	    
		
		return null;
	    
	}
	
	public static void main(String[] args){
		SearchAmbulance  s =new SearchAmbulance ();
		s.SearchAmbulanceBy(null, null);
	}

}
