package com.pfa.DaoFactory;

import java.util.ArrayList;

import com.pfa.searchHospitalWS.Hospital;

public interface HospitalDao {
	
	public ArrayList<Hospital> HospitalsBySpecialty(String speciality, Object patientLocation);

}
