package com.mitrais.research.springhibernate.webservice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.research.springhibernate.model.Patient;
import com.mitrais.research.springhibernate.model.PatientAlcohol;
import com.mitrais.research.springhibernate.service.PatientService;

@Service("patientWs")
@Path("/patients")
public class PatientWs {
	private static Logger logger = Logger.getLogger(PatientWs.class.getName());
	
	@Autowired 
	private PatientService patientService;
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String testPing(){		
		String nanana = "nanana";
//		Date now = Calendar.getInstance().getTime();
//		List<PatientAlcohol> patientAlcoholList = new ArrayList<PatientAlcohol>();
//		PatientAlcohol dummy = new PatientAlcohol(new Date(now.getTime()),666,UUID.randomUUID().toString(),new Date(now.getTime()),UUID.randomUUID().toString(),new Date(now.getTime()),666);
//		patientAlcoholList.add(dummy);
		Patient pat = new Patient();
		pat.setFirstName("rerere");
		pat.setLastName("dasda");
		List<Patient> patList = patientService.getPatientByName(pat);		
		pat = patList.get(0);			
//		pat.setPatientAlcoholList(patientAlcoholList);
		patientService.updatePatient(pat);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			if(pat != null){
				jsonString = mapper.writeValueAsString(pat);
			}else{
				jsonString = mapper.writeValueAsString(nanana);
			}
		} catch (JsonGenerationException e) {
			return "error1";
		} catch (JsonMappingException e) {
			//return "error2";
			e.printStackTrace();
		} catch (IOException e) {
			return "error3";			
		}
		return jsonString;
	}
//	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String addPatient(Patient newPatient){
//		return null;
//	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String findPatients(){
		return null;
	}

	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addPatient(Patient newPatient){
		return null;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(Patient newPatient){
		return null;
	}

	
	
	@GET
	@Path("/{patientGUID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPatient(@PathParam("patientGUID") String patientGUID){	
		return null;
	}
	
}
