package com.pfa.DaoFactory;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.pfa.SearchAmbulanceWS.AmbulanceServiceProvider;


public class AmbulanceServiceProviderDaoImp implements AmbulanceServiceProviderDao {
	
	public ArrayList<AmbulanceServiceProvider> HospitalsBySpecialty() {
		ArrayList<AmbulanceServiceProvider> AmbulanceServiceProviderList = 
				new ArrayList<AmbulanceServiceProvider>();
	      try{
	    	  MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	    	  MongoDatabase database = mongoClient.getDatabase("hospitalsdb");
	    	  MongoCollection<Document> collection = database.getCollection("hospitals");
	    	  MongoCursor<Document> cursor = collection.find().iterator();
	    	  
	    	  try {
	    	      while (cursor.hasNext()) {
	    	          System.out.println(cursor.next().toJson());
	    	      }
	    	  } finally {
	    	      cursor.close();
	    	  }
	    	  mongoClient.close();
				
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }
	      return AmbulanceServiceProviderList;
	   }
}
