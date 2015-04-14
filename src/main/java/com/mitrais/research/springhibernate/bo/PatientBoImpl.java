package com.mitrais.research.springhibernate.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.research.springhibernate.dao.PatientDao;
import com.mitrais.research.springhibernate.model.Patient;

@Service
public class PatientBoImpl implements PatientBo {

	@Autowired
	private PatientDao patientDao;

	/* (non-Javadoc)
	 * @see com.mitrais.research.springhibernate.bo.PatientBo#getPatientByName(com.mitrais.research.springhibernate.model.Patient)
	 */
	@Override
	public List<Patient> getPatientByName(Patient pat) {
//		List<Patient> patList = patientDao.getPatientList(pat);
//		if(patList.isEmpty()){
//			return patList;
//		}else{
//			String practiceGUID = UUID.randomUUID().toString();
//			String accountGUID = UUID.randomUUID().toString();
//			int titleID = 0;
//			String firstName = "mamamama";
//			String lastName = "papapapa";
//			String createdBy = UUID.randomUUID().toString();
//			String updatedBy = UUID.randomUUID().toString();
//			int recordStatusID = 1;
//			Patient patDummy = new Patient(practiceGUID,accountGUID,titleID,firstName,lastName,createdBy,updatedBy,recordStatusID);
//			patList.add(patDummy);
//			return patList;
//		}
		return patientDao.getPatientList(pat);
		
	}

	/* (non-Javadoc)
	 * @see com.mitrais.research.springhibernate.bo.PatientBo#savePatient(com.mitrais.research.springhibernate.model.Patient)
	 */
	@Override
	public String savePatient(Patient pat) {
		return patientDao.savePatient(pat);
	}

	/* (non-Javadoc)
	 * @see com.mitrais.research.springhibernate.bo.PatientBo#updatePatient(com.mitrais.research.springhibernate.model.Patient)
	 */
	@Override
	public void updatePatient(Patient pat) {
		patientDao.updatePatient(pat);
	}

	/* (non-Javadoc)
	 * @see com.mitrais.research.springhibernate.bo.PatientBo#deletePatient(com.mitrais.research.springhibernate.model.Patient)
	 */
	@Override
	public void deletePatient(Patient pat) {
		patientDao.deletePatient(pat);
	}

	@Override
	public List<Patient> getPatientByName(String name) {
		return patientDao.getPatientByName(name);
	}

}
