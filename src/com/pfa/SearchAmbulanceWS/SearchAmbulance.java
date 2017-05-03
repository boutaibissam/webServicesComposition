package com.pfa.SearchAmbulanceWS;

import java.util.ArrayList;

public class SearchAmbulance {
	
	public 	ArrayList<AmbulanceServiceProvider> SearchAmbulanceBy(Double[] patientLocation,double[] targetLocation){
		/*
		 * in this method we will look for the nearest Ambulance service provider 
		 * to the patient Or the client location 
		 * than we will return an ordered list of the service  providers 
		 * based on Distance Matrix provided with google maps Api. 
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

}
