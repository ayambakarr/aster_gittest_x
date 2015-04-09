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
//	public void savePerson(){
//		Person p = new Person();
//		p.setFullName("nanana");
//		persond.savePerson(p);
//	}
//	public void test(){		
//	}
	public void savePatient(){
		Date now = Calendar.getInstance().getTime();
		List<PatientAlcohol> patientAlcoholList = new ArrayList<PatientAlcohol>();
		PatientAlcohol dummy = new PatientAlcohol(new Date(now.getTime()),123,UUID.randomUUID().toString(),new Date(now.getTime()),UUID.randomUUID().toString(),new Date(now.getTime()),456);		
		patientAlcoholList.add(dummy);		  
		Patient pat = createPatient();
		pat.setPatientGUID(UUID.randomUUID().toString());
		pat.setCreatedDate(new Date(now.getTime()));
		pat.setUpdatedDate(new Date(now.getTime()));
		pat.setEmail("nannana");
		pat.setPatientAlcoholList(patientAlcoholList);
		patDao.savePatient(pat);
//		pat.setFirstName("sean");
//		pat.setLastName("satya");
//		List<Patient> listPat = patDao.getPatientList(pat);
//		assertTrue (listPat.size() == 1);
//		pat = listPat.get(0);		 
//		pat.getPatientAlcoholList().add(dummy);
//		patDao.updatePatient(pat);
		
//		List<Patient> listPat = patDao.getPatientList(pat);
//		assertTrue (listPat.size() >= 0);
//		patDao.deletePatient(pat);
//		listPat = patDao.getPatientList(pat);
//		assertTrue (listPat.size() >= 0);
//		patDao.savePatient(pat);
//		pat.setFirstName("kukukuku");
//		pat.setLastName("xxx");
//		listPat = patDao.getPatientList(pat);
//		pat = listPat.get(0);
//		pat.setFirstName("yayaya");
//		pat.setLastName("yuyuyuyu");
//		patDao.updatePatient(pat);		
	}
}
