package com.mitrais.research.springhibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mitrais.research.springhibernate.model.PatientAlcohol;

@Repository
public class PatientAlcoholDaoImpl extends AbstractDao implements PatientAlcoholDao{

	@Override
	public void updatePatientAlcohol(PatientAlcohol patientAlcohol) {
		getSessionFactory().getCurrentSession().update(patientAlcohol);;
		
	}

	@Override
	public void deletePatientAlcohol(PatientAlcohol patientAlcohol) {
		getSessionFactory().getCurrentSession().delete(patientAlcohol);		
	}

	@Override
	public void savePatientAlcohol(PatientAlcohol patientAlcohol) {
		getSessionFactory().getCurrentSession().save(patientAlcohol);		
	}

	@Override
    @SuppressWarnings("unchecked") 
	public List<PatientAlcohol> getPatientAlcoholList(PatientAlcohol pat) {
//        Query query = getSessionFactory().getCurrentSession().createQuery("from PatientAlcohol where firstName = ? and lastName = ?")  ;        
//        query.setString(0,pat.getFirstName());
//        query.setString(1,pat.getLastName());
//        return query.list();	    
		return null;
	}

	@Override
	public List<PatientAlcohol> getPatientAlcoholList() {
		Query query = getSessionFactory().getCurrentSession().createQuery("from PatientAlcohol")  ;        
        return query.list();	    
	}
}
