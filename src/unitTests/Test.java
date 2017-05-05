package unitTests;



import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;

public class Test {
	private static final String API_KEY = "AIzaSyDvZxwxhsqsbykt9Sb8ja--KsaLO0YOpPk";
	private static final GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
	

	public static DistanceMatrix estimateRouteTime() {
		 DistanceMatrixApiRequest req=null;
		try {
	        req = DistanceMatrixApi.newRequest(context);
	        
	        DistanceMatrix trix = req.origins("rabat morocco")
	        		.destinations("casablanca morocco")
	                .mode(TravelMode.DRIVING)
	                .avoid(RouteRestriction.HIGHWAYS)
	                .language("fr-FR")
	                .await();
	        return trix;

	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    } 
	    return null;
	}
/*
	public static void main(String[] args) {
		/*GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
	    try {
	        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context); 
	        DistanceMatrix trix = req.origins("Vancouver BC","Seattle")
	                .destinations("San Francisco","Victoria BC")
	                .mode(TravelMode.DRIVING)
	                .avoid(RouteRestriction.HIGHWAYS)
	                .language("fr-FR")
	                .await();
	        //Do something with result here
	       
	        System.out.println(trix.toString());
	        
	    } catch(ApiException e){
	        System.out.println(e.getMessage());
	    } catch(Exception e){
	        System.out.println(e.getMessage());
	    } 
		

		///Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//JsonParser jp = new JsonParser();
		//JsonElement je = jp.parse(estimateRouteTime().toString());
		//String prettyJsonString = gson.toJson(je);
		//DistanceMatrix mat = estimateRouteTime();
		//System.out.println(mat.getClass());

	}*/
	public static void main(String[] args) {
		GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
	    try {
	        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context); 
	        DistanceMatrix trix = req.origins("Vancouver BC","Seattle")
	                .destinations("San Francisco","Victoria BC")
	                .mode(TravelMode.DRIVING)
	                .avoid(RouteRestriction.HIGHWAYS)
	                .language("fr-FR")
	                .await();
	        
	       
	        //System.out.println(trix.toString());
	        JSONObject jsonRespRouteDistance = new JSONObject(trix.rows);
	        System.out.println(jsonRespRouteDistance.toString());
                    /*.getJSONArray("rows")
                    .getJSONObject(0)
                    .getJSONArray ("elements")
                    .getJSONObject(0)
                    .getJSONObject("distance");

		String distance = jsonRespRouteDistance.get("text").toString();
		System.out.println(distance);
		/* 
		* For distance, below is only partial solution as the 
		* output to string destination_addr will contain square brackets [] and double codes ""
		* Eg. [ "1600 Pennsylvania Avenue, Hagerstown, MD 21742, USA" ]
		* 
		*/
		String destination_addr = new JSONObject(trix)
		        .get("destination_addresses")
		        .toString();
		 System.out.println(destination_addr);
	        
	    } catch(ApiException e){
	        System.out.println(e.getMessage());
	    } catch(Exception e){
	        System.out.println(e.getMessage());
	    }
	   
	}

}
