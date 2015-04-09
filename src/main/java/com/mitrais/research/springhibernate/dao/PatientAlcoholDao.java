package com.mitrais.research.springhibernate.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mitrais.research.springhibernate.model.PatientAlcohol;

@Transactional
public interface PatientAlcoholDao {		
	    void updatePatientAlcohol (PatientAlcohol patientAlcohol);
	    void deletePatientAlcohol (PatientAlcohol patientAlcohol) ;
	    void savePatientAlcohol(PatientAlcohol patientAlcohol);
	    @Transactional
	    List<PatientAlcohol> getPatientAlcoholList(PatientAlcohol pat);
	    @Transactional
	    List<PatientAlcohol> getPatientAlcoholList();
}
