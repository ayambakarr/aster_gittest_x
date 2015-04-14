package com.mitrais.research.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.research.springhibernate.bo.PatientBo;
import com.mitrais.research.springhibernate.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientBo patBo;
	
	@Override
	public List<Patient> getPatientByName(Patient pat) {
		return patBo.getPatientByName(pat);
	}

	@Override
	public String savePatient(Patient pat) {
		return patBo.savePatient(pat);
	}

	@Override
	public void updatePatient(Patient pat) {
		patBo.updatePatient(pat);		
	}

	@Override
	public void deletePatient(Patient pat) {
		patBo.deletePatient(pat);		
	}

	@Override
	public List<Patient> getPatientByName(String name) {
		return patBo.getPatientByName(name);
	}

}
