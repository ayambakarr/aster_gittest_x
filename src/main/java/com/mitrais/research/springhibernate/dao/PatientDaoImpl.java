package com.mitrais.research.springhibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mitrais.research.springhibernate.model.Patient;
import com.mitrais.research.springhibernate.model.PatientAlcohol;
import com.mitrais.research.springhibernate.model.Person;

@Repository
public class PatientDaoImpl extends AbstractDao implements PatientDao{

	@Override
	public void updatePatient(Patient patient) {
		getSessionFactory().getCurrentSession().update(patient);;
		
	}

	@Override
	public void deletePatient(Patient patient) {
		getSessionFactory().getCurrentSession().delete(patient);		
	}

	@Override
	public void savePatient(Patient patient) {
		getSessionFactory().getCurrentSession().save(patient);		
	}

	@Override
    @SuppressWarnings("unchecked") 
	public List<Patient> getPatientList(Patient pat) {
        Query query = getSessionFactory().getCurrentSession().createQuery("from Patient where firstName = ? and lastName = ?")  ;        
        query.setString(0,pat.getFirstName());
        query.setString(1,pat.getLastName());
        return query.list();	    
	}

	@Override
	public List<Patient> getPatientList() {
		Query query = getSessionFactory().getCurrentSession().createQuery("from Patient")  ;        
        return query.list();	    
	}

	@Override
	public List<PatientAlcohol> getPatientAlcoholList(Patient pat) {
//		Query query = getSessionFactory().getCurrentSession().createQuery("from Patient inner join PatientAlcohol where patientGUID = ?")  ;        
//        query.setString(0,pat.getPatientGUID());
//        return query.list();	    
//		
		return null;
	}
}
