package com.mitrais.research.springhibernate.dao;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mitrais.research.springhibernate.BaseTest;
import com.mitrais.research.springhibernate.model.Patient;
import com.mitrais.research.springhibernate.model.PatientAlcohol;

@ContextConfiguration({"classpath:spring-database.xml"})
public class PatientDaoImplTest extends BaseTest{
	
	@Autowired
	private PatientDao patDao;
	
	@Autowired
	private PatientAlcoholDao patAlcoholDao;	
	
	@Autowired
	private PersonDao persond;	

	private Patient createPatient(){		      
		String practiceGUID = UUID.randomUUID().toString();
		String accountGUID = UUID.randomUUID().toString();
		int titleID = 0;
		String firstName = "adsafs";
		String lastName = "asdadfwqe";
		String createdBy = UUID.randomUUID().toString();
		String updatedBy = UUID.randomUUID().toString();
		int recordStatusID = 1;
		Patient pat = new Patient(practiceGUID,accountGUID,titleID,firstName,lastName,createdBy,updatedBy,recordStatusID);
		return pat;
	}
	
	@Test	
    @SuppressWarnings("unchecked")
	public void testPatient(){
		Date now = Calendar.getInstance().getTime();
		//save
		List<PatientAlcohol> patientAlcoholList = new ArrayList<PatientAlcohol>();
		PatientAlcohol dummy = new PatientAlcohol(new Date(now.getTime()),123,UUID.randomUUID().toString(),new Date(now.getTime()),UUID.randomUUID().toString(),new Date(now.getTime()),456);		
		patientAlcoholList.add(dummy);		  
		Patient pat = createPatient();
		pat.setPatientGUID(UUID.randomUUID().toString());
		pat.setCreatedDate(new Date(now.getTime()));
		pat.setUpdatedDate(new Date(now.getTime()));
		pat.setEmail("nannana");
		pat.setPatientAlcoholList(patientAlcoholList);
		String id = patDao.savePatient(pat);
		//update
		pat.setPatientGUID(id);
		pat.setFirstName("dulgundul");
		pat.setLastName("dalgundal");
		patDao.updatePatient(pat);
		//search
		List<Patient> patList = patDao.getPatientList(pat);
		assertTrue(patList.size() == 1);
		assertTrue(patList.get(0).getPatientGUID().equals(id));
		//delete
		patDao.deletePatient(pat);
		patList = patDao.getPatientList(pat);
		assertTrue(patList.size() == 0);
	}
	
	@Test
	public void searchPatientByName(){		
		Patient pat = new Patient();
		pat.setFirstName("sean");
		pat.setLastName("satya");
		//patientBo.getPatientByName(pat);
		patDao.getPatientList(pat);
	}
}
