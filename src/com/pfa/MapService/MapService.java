package com.pfa.MapService;

import java.io.Serializable;
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.pfa.Helpers.*;

public class MapService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String getMap(ArrayList<Location> listOfLocations ){
		ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptEngine engine = manager.getEngineByName("javascript");
	    try {
	      engine.put("location",listOfLocations);
	      engine.eval(
	    		  "function myMap() {"
	    	      +"var mapProp= {"
	    	      +"	center:new google.maps.LatLng(51.508742,-0.120850),"
	    	      +"	zoom:5,"
	    	      +"};"
	              +"////// adding markers "
	              +"var marker = new google.maps.Marker({"
	              +"	position: myLatLng,"
	              +"    map: map,"
	              +"    title: 'Hello World!'"
	              +"  });");
	      String name = (String) engine.get("output");
	      System.out.println(name);
	    } catch (ScriptException e) {
	      System.err.println(e);
	    }
		return null;
		
	}
	
	

}
