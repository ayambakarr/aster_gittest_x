package com.mitrais.research.springhibernate.bo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.mitrais.research.springhibernate.BaseTest;
import com.mitrais.research.springhibernate.dao.PatientDao;
import com.mitrais.research.springhibernate.model.Patient;

@RunWith(MockitoJUnitRunner.class)
public class PatientBoMockTest extends BaseTest{
	
	@Mock
	private PatientDao patientDao; 
	
	@InjectMocks
	private PatientBo patientBo = new PatientBoImpl();
	
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
		List<Patient> patList = patientBo.getPatientByName(pat);		
//		assertTrue(patList.get(0).getFirstName().equals("mamamama") && patList.get(0).getLastName().equals("papapapa"));
		verify(patientDao).getPatientList(pat);
	}
	
	@Test
	public void savePatient(){
		Patient pat = new Patient();
		patientBo.savePatient(pat);
		verify(patientDao).savePatient(pat);
	}
	
	@Test
	public void updatePatient(){
		Patient pat = new Patient();		
		patientBo.updatePatient(pat);
		verify(patientDao).updatePatient(pat);
	}
	
	@Test
	public void deletePatient(){
		Patient pat = new Patient();		
		patientBo.deletePatient(pat);
		verify(patientDao).deletePatient(pat);
	}
}
