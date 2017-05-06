package com.pfa.DaoFactory;

import com.pfa.Helpers.Location;
import com.pfa.searchHospitalWS.*;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;


import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class HospitalDaoImp implements HospitalDao {
	
	public   ArrayList<Hospital> HospitalsBySpecialty(String speciality, Object patientLocation) {
		
		ArrayList<Hospital> hospitalsList =  new ArrayList<Hospital>();
	    try{
	    	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	    	MongoDatabase database = mongoClient.getDatabase("hospitalsdb");
	    	MongoCollection<Document> collection = database.getCollection("hospitals");
	    	BasicDBObject whereQuery =new BasicDBObject();
	    	whereQuery.put("specialities",speciality);
	    	if(patientLocation  instanceof String ){
	    		whereQuery.put("city",(String) patientLocation);
	    	}
	    	MongoCursor<Document> cursor = collection.find(whereQuery).iterator();
	    	  
	    	try {
	    		while (cursor.hasNext()) {
	    	         
	    	          Document obj = cursor.next();
	    	          Document location= (Document) obj.get("Location");
	    	          
	    	          hospitalsList.add(new Hospital(
	    	        		  obj.get("hospitalName").toString(),
	    	        		  obj.get("hospitalName").toString(),
	    	        		  new Location(location.getDouble("latitude"), location.getDouble("longitude")),
	    	        		  (List<String> )obj.get ("specialities")
	    	          ));
	    	    }
	    	} 
	    	
	    	finally {
	    	      cursor.close();
	    	}
	    	mongoClient.close();
				
	      }
	    
	    catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	     }
	      
	    return hospitalsList;
	   
	}
	
	public static void main(String[] args){
		HospitalDaoImp t = new HospitalDaoImp();
		ArrayList<Hospital> hospitalsList = t.HospitalsBySpecialty("dermatologist","cassablanca");
		System.out.println(hospitalsList.size());
		System.out.println("______________________________________________________");
        for (Hospital x :hospitalsList){
      	  System.out.println(x.getHospitalName());
      	  System.out.println(x.getSpecialities());
      	  System.out.println("Latitude  :" +x.getHospitalLocation().getLatitude());
      	  System.out.println("Longitude :" +x.getHospitalLocation().getLonguitude());
      	  System.out.println("______________________________________________________");
        }
	}

}
