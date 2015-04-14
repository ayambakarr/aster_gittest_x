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
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
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
	@Produces(MediaType.APPLICATION_JSON)
	public Patient testPing() {
		String nanana = "nanana";
		// Date now = Calendar.getInstance().getTime();
		// List<PatientAlcohol> patientAlcoholList = new
		// ArrayList<PatientAlcohol>();
		// PatientAlcohol dummy = new PatientAlcohol(new
		// Date(now.getTime()),666,UUID.randomUUID().toString(),new
		// Date(now.getTime()),UUID.randomUUID().toString(),new
		// Date(now.getTime()),666);
		// patientAlcoholList.add(dummy);
		Patient pat = new Patient();
		pat.setFirstName("rerere");
		pat.setLastName("dasda");
		List<Patient> patList = patientService.getPatientByName(pat);
		pat = patList.get(0);
		// pat.setPatientAlcoholList(patientAlcoholList);
		patientService.updatePatient(pat);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			if (pat != null) {
				jsonString = mapper.writeValueAsString(pat);
			} else {
				jsonString = mapper.writeValueAsString(nanana);
			}
		} catch (JsonGenerationException e) {
			//return "error1";
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// return "error2";
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			//return "error3";
		}
		return pat;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String findPatients() {
		return null;
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addPatient(String newPatient) {
		ObjectMapper mapper = new ObjectMapper();
		Patient pat = new Patient();
		try {
			pat = mapper.readValue(newPatient, Patient.class);
		} catch (JsonGenerationException e) {
			return "error1";
		} catch (JsonMappingException e) {
			// return "error2";
			e.printStackTrace();
		} catch (IOException e) {
			return "error3";
		}
		return patientService.savePatient(pat);
	}

	@POST
	@Path("/add2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addPatient(@PathParam("titleID") Integer titleID,
			@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName,
			@PathParam("createdDate") Date createdDate,
			@PathParam("updatedDate") Date updatedDate,
			@PathParam("recordStatusID") Integer recordStatusID) {
		Patient pat = new Patient();
		pat.setTitleID(titleID);
		pat.setFirstName(firstName);
		pat.setLastName(lastName);
		pat.setCreatedDate(createdDate);
		pat.setUpdatedDate(updatedDate);
		pat.setRecordStatusID(recordStatusID);
		pat.setAccountGUID(UUID.randomUUID().toString());
		pat.setPracticeGUID(UUID.randomUUID().toString());
		pat.setCreatedBy(UUID.randomUUID().toString());
		pat.setUpdatedBy(UUID.randomUUID().toString());

		return "added new patient, guid :" + patientService.savePatient(pat);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(Patient newPatient) {
		return null;
	}

	@GET
	@Path("/{patientGUID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatient(@PathParam("patientGUID") String patientGUID) {
		return Response.status(200)
				.entity("getUserById is called, id : " + patientGUID).build();
	}

	@GET
	@Path("/ping/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getPatientByName(@PathParam("name") String name) {
		List<Patient> patList = patientService.getPatientByName(name);
		String patData = "";
		if(patList != null && patList.size() > 0){
			for (Patient p : patList) {
				patData += p.getFirstName() + " " + p.getLastName() + " / "
						+ p.getGenderCode() + " / " + p.getdOB() + " / "
						+ p.getHomePhone() + "\n";
			}
			return patData;
		}else{
			return "result not found";			
		}		
	}
}