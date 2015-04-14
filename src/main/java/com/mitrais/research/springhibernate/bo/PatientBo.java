package com.mitrais.research.springhibernate.bo;

import java.util.List;

import com.mitrais.research.springhibernate.model.Patient;

public interface PatientBo {

	List<Patient> getPatientByName(Patient pat);
	List<Patient> getPatientByName(String name);
	String savePatient(Patient pat);
	void updatePatient(Patient pat);
	void deletePatient(Patient pat);

}