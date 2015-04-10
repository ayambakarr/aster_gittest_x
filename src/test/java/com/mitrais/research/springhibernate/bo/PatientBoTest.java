package com.mitrais.research.springhibernate.bo;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.mitrais.research.springhibernate.BaseTest;
import com.mitrais.research.springhibernate.dao.PatientDao;
import com.mitrais.research.springhibernate.model.Patient;

@ContextConfiguration({"classpath:spring-database.xml"})
public class PatientBoTest extends BaseTest {
			
	@Autowired
	private PatientBo patientBoImpl;
	
//	@Autowired
//	private PatientDao patientDao;
	
	@Test
	public void searchPatientByName(){		
		Patient pat = new Patient();
		pat.setFirstName("sean");
		pat.setLastName("satya");
		patientBoImpl.getPatientByName(pat);
//		patientDao.getPatientList(pat);
	}
	
//	@Test
//	public void savePatient(){
//		Patient pat = new Patient();
//		patientBo.savePatient(pat);
//	}
//	
//	@Test
//	public void updatePatient(){
//		Patient pat = new Patient();		
//		patientBo.updatePatient(pat);
//	}
//	
//	@Test
//	public void deletePatient(){
//		Patient pat = new Patient();		
//		patientBo.deletePatient(pat);
//	}

}
