package com.mitrais.research.springhibernate.service;

import java.util.List;

import com.mitrais.research.springhibernate.model.Patient;

public interface PatientService {

		List<Patient> getPatientByName(Patient pat);
		List<Patient> getPatientByName(String name);
		String savePatient(Patient pat);
		void updatePatient(Patient pat);
		void deletePatient(Patient pat);

}
