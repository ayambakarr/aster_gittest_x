package com.mitrais.research.springhibernate.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mitrais.research.springhibernate.model.Patient;
import com.mitrais.research.springhibernate.model.PatientAlcohol;

@Transactional
public interface PatientDao {		
	    void updatePatient (Patient patient);
	    void deletePatient (Patient patient) ;
	    void savePatient(Patient patient);
	    @Transactional
	    List<Patient> getPatientList(Patient pat);
	    @Transactional
	    List<Patient> getPatientList();
	    @Transactional
	    List<PatientAlcohol> getPatientAlcoholList(Patient pat);
}
