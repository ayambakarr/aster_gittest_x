package com.mitrais.research.springhibernate.service;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mitrais.research.springhibernate.BaseTest;
import com.mitrais.research.springhibernate.bo.PatientBo;
import com.mitrais.research.springhibernate.model.Patient;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceMockTest extends BaseTest{
	
	@Mock
	private PatientBo patientBo; 
	
	@InjectMocks
	private PatientService patientService = new PatientServiceImpl();
	
//	private Patient createPatient(){		      
//		String practiceGUID = UUID.randomUUID().toString();
//		String accountGUID = UUID.randomUUID().toString();
//		int titleID = 0;
//		String firstName = "adsafs";
//		String lastName = "asdadfwqe";
//		String createdBy = UUID.randomUUID().toString();
//		String updatedBy = UUID.randomUUID().toString();
//		int recordStatusID = 1;
//		Patient pat = new Patient(practiceGUID,accountGUID,titleID,firstName,lastName,createdBy,updatedBy,recordStatusID);
//		return pat;
//	}
	
	@Test
	public void searchPatientByName(){		
		Patient pat = new Patient();
//		pat.setFirstName("sean");
//		pat.setLastName("satya");
		List<Patient> patList = patientService.getPatientByName(pat);		
//		assertTrue(patList.get(0).getFirstName().equals("mamamama") && patList.get(0).getLastName().equals("papapapa"));
		verify(patientBo).getPatientByName(pat);
	}
	
	@Test
	public void savePatient(){
		Patient pat = new Patient();
		patientService.savePatient(pat);
		verify(patientBo).savePatient(pat);
	}
	
	@Test
	public void updatePatient(){
		Patient pat = new Patient();		
		patientService.updatePatient(pat);
		verify(patientBo).updatePatient(pat);
	}
	
	@Test
	public void deletePatient(){
		Patient pat = new Patient();		
		patientService.deletePatient(pat);
		verify(patientBo).deletePatient(pat);
	}
}
