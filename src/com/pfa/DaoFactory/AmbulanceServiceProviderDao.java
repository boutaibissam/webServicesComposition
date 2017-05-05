package com.pfa.DaoFactory;

import java.util.ArrayList;

import com.pfa.SearchAmbulanceWS.AmbulanceServiceProvider;

public interface AmbulanceServiceProviderDao {
	
	public ArrayList<AmbulanceServiceProvider> HospitalsBySpecialty();

}
