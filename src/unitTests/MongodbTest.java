package unitTests;



import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

import org.bson.Document;

public class MongodbTest {

   public static void main( String args[] ) {
	
      try{
    	  MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    	  MongoDatabase database = mongoClient.getDatabase("hospitalsdb");
    	  MongoCollection<Document> collection = database.getCollection("hospitals");
    	 // MongoCollection<Document> collection2 = database.getCollection("ambulanceServices");
    	  Document doc = new Document("hospitalName", "Hopital Militaire rabat  ")
    			  .append("city", "rabat") 
                  .append("specialities", Arrays.asList("phesisien","dermatologist", "cardiologist"))
                  .append("Location", new Document("latitude", 33.969803).append("longitude",-6.869520))
    	          .append("contacts", new Document("phone", "056222222").append("phone2 ", "054233102"));
    	// 33.984483, -6.852284 chu av r
    	// 33.986475, -6.854193 h enfant r 
    	//33.969803, -6.869520 h militaire r
    	 /* Document doc2 = new Document("ServiceproviderName", "SAM")
                  .append("numberOfAmbulancesAvialable", 4)
                  .append("state", "avialable")
                  .append("city", "casblanca")
    			  .append("country", "Morocco")
                  .append("Location", new Document("latitude", 203).append("longitude", 102))
    	          .append("contacts", new Document("phone_1", "056222222").append("phone_2 ", "054233102"));
    	  		
    	  */
    	  collection.insertOne(doc);
    	  /*//collection2.insertOne(doc2);
    	  MongoCursor<Document> cursor = collection2.find().iterator();
    	  try {
    		  
    	      while (cursor.hasNext()) {
    	          System.out.println(cursor.next().toJson());
    	      }
    	  } finally {
    	      cursor.close();
    	  }*/
    	  mongoClient.close();
			
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
   }
}
