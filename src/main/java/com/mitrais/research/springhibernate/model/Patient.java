package com.mitrais.research.springhibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;


@Entity
@Table(name = "Patient")
public class Patient implements Serializable {
	@Id
	@GenericGenerator(name = "guidGenerator", strategy = "guid")
	@GeneratedValue(generator = "guidGenerator")
	@Column(name = "PatientGUID", columnDefinition = "uniqueidentifier", nullable = false, unique = true)    
	private String patientGUID;	
	@Column(name = "PracticeGUID", columnDefinition="uniqueidentifier" , nullable = false)	
    private String practiceGUID;
	@Column(name = "AccountGUID", columnDefinition="uniqueidentifier" , nullable = false)
    private String accountGUID;
	@Column(name = "UsualDoctorGUID")
    private int usualDoctorGUID;
	@Column(name = "PatientPhoto")
    private byte[] patientPhoto;
	@Column(name = "TitleID", nullable = false)
    private int titleID; 
	@Column(name = "FirstName", length = 30 , nullable = false)
    private String firstName;
	@Column(name = "LastName", length = 30 , nullable = false)
    private String lastName;
	@Column(name = "MiddleName", length = 30)
    private String middleName;
	@Column(name = "KnownAs", length = 30)
    private String knownAs;
	@Column(name = "GenderCode")
    private int genderCode; 
	@Column(name = "DOB")
    private Date dOB; 
	@Column(name = "DOD")
    private Date dOD; 
	@Column(name = "Email", length = 100)
    private String email; 
	@Column(name = "HomePhone", length = 20)
    private String homePhone; 
	@Column(name = "MobilePhone", length = 20)
    private String mobilePhone; 
	@Column(name = "OfficePhone", length = 20)
    private String officePhone; 
	@Column(name = "ContactMethodID")
    private int contactMethodID;
	@Column(name = "HeadOfFamilyGUID", columnDefinition="uniqueidentifier")
    private String headOfFamilyGUID; 
	@Column(name = "PatientStatusCode")
    private int patientStatusCode; 
	@Column(name = "NOKName", length = 50)
    private String nOKName; 
	@Column(name = "NOKRelationshipID")
    private int nOKRelationshipID; 
	@Column(name = "NOKHomePhone", length = 20)
    private String nOKHomePhone; 
	@Column(name = "NOKMobilePhone", length = 20)
    private String nOKMobilePhone; 
	@Column(name = "NOKWorkPhone", length = 20)
    private String nOKWorkPhone; 
	@Column(name = "NOKContactMethodID")
    private int nOKContactMethodID; 
	@Column(name = "NokEmail", length = 100)
    private String nokEmail; 
	@Column(name = "EmergencyName", length = 50)
    private String emergencyName; 
	@Column(name = "EmergencyRelationshipID")
    private int emergencyRelationshipID; 
	@Column(name = "EmergencyHomePhone", length = 20)
    private String emergencyHomePhone; 
	@Column(name = "EmergencyMobilePhone", length = 20)
    private String emergencyMobilePhone;
	@Column(name = "EmergencyWorkPhone", length = 20)
    private String emergencyWorkPhone; 
	@Column(name = "EmergencyContactMethodID")
    private int emergencyContactMethodID; 
	@Column(name = "EmergencyEmail", length = 100)
    private String emergencyEmail; 
	@Column(name = "CreatedBy", columnDefinition="uniqueidentifier" , nullable = false)
    private String createdBy; 
	@Column(name = "CreatedDate", nullable = false)
    private Date createdDate; 
	@Column(name = "UpdatedBy", columnDefinition="uniqueidentifier" , nullable = false)
    private String updatedBy; 
	@Column(name = "UpdatedDate", nullable = false)
    private Date updatedDate; 
	@Column(name = "RecordStatusID", nullable = false)
    private int recordStatusID;
	
	
	@OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JoinColumn(name="PatientGUID", nullable=false)
	private List<PatientAlcohol> patientAlcoholList;

	public List<PatientAlcohol> getPatientAlcoholList() {
		return patientAlcoholList;
	}
	public void setPatientAlcoholList(List<PatientAlcohol> patientAlcoholList) {
		this.patientAlcoholList = patientAlcoholList;
	}
	
	public Patient(){
	}
	public Patient(String practiceGUID, String accountGUID, int titleID,
			String firstName, String lastName, String createdBy, String updatedBy,
			int recordStatusID) {
		this.practiceGUID = practiceGUID;
		this.accountGUID = accountGUID;
		this.titleID = titleID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.recordStatusID = recordStatusID;
	}	
	
	public String getPatientGUID() {
		return patientGUID;
	}

	public void setPatientGUID(String patientGUID) {
		this.patientGUID = patientGUID;
	}

	public String getPracticeGUID() {
		return practiceGUID;
	}
	public void setPracticeGUID(String practiceGUID) {
		this.practiceGUID = practiceGUID;
	}
	public String getAccountGUID() {
		return accountGUID;
	}
	public void setAccountGUID(String accountGUID) {
		this.accountGUID = accountGUID;
	}
	public int getUsualDoctorGUID() {
		return usualDoctorGUID;
	}
	public void setUsualDoctorGUID(int usualDoctorGUID) {
		this.usualDoctorGUID = usualDoctorGUID;
	}
	public byte[] getPatientPhoto() {
		return patientPhoto;
	}
	public void setPatientPhoto(byte[] patientPhoto) {
		this.patientPhoto = patientPhoto;
	}
	public int getTitleID() {
		return titleID;
	}
	public void setTitleID(int titleID) {
		this.titleID = titleID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getKnownAs() {
		return knownAs;
	}
	public void setKnownAs(String knownAs) {
		this.knownAs = knownAs;
	}
	public int getGenderCode() {
		return genderCode;
	}
	public void setGenderCode(int genderCode) {
		this.genderCode = genderCode;
	}
	public Date getdOB() {
		return dOB;
	}
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
	public Date getdOD() {
		return dOD;
	}
	public void setdOD(Date dOD) {
		this.dOD = dOD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public int getContactMethodID() {
		return contactMethodID;
	}
	public void setContactMethodID(int contactMethodID) {
		this.contactMethodID = contactMethodID;
	}
	public String getHeadOfFamilyGUID() {
		return headOfFamilyGUID;
	}
	public void setHeadOfFamilyGUID(String headOfFamilyGUID) {
		this.headOfFamilyGUID = headOfFamilyGUID;
	}
	public int getPatientStatusCode() {
		return patientStatusCode;
	}
	public void setPatientStatusCode(int patientStatusCode) {
		this.patientStatusCode = patientStatusCode;
	}
	public String getnOKName() {
		return nOKName;
	}
	public void setnOKName(String nOKName) {
		this.nOKName = nOKName;
	}
	public int getnOKRelationshipID() {
		return nOKRelationshipID;
	}
	public void setnOKRelationshipID(int nOKRelationshipID) {
		this.nOKRelationshipID = nOKRelationshipID;
	}
	public String getnOKHomePhone() {
		return nOKHomePhone;
	}
	public void setnOKHomePhone(String nOKHomePhone) {
		this.nOKHomePhone = nOKHomePhone;
	}
	public String getnOKMobilePhone() {
		return nOKMobilePhone;
	}
	public void setnOKMobilePhone(String nOKMobilePhone) {
		this.nOKMobilePhone = nOKMobilePhone;
	}
	public String getnOKWorkPhone() {
		return nOKWorkPhone;
	}
	public void setnOKWorkPhone(String nOKWorkPhone) {
		this.nOKWorkPhone = nOKWorkPhone;
	}
	public int getnOKContactMethodID() {
		return nOKContactMethodID;
	}
	public void setnOKContactMethodID(int nOKContactMethodID) {
		this.nOKContactMethodID = nOKContactMethodID;
	}
	public String getNokEmail() {
		return nokEmail;
	}
	public void setNokEmail(String nokEmail) {
		this.nokEmail = nokEmail;
	}
	public String getEmergencyName() {
		return emergencyName;
	}
	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}
	public int getEmergencyRelationshipID() {
		return emergencyRelationshipID;
	}
	public void setEmergencyRelationshipID(int emergencyRelationshipID) {
		this.emergencyRelationshipID = emergencyRelationshipID;
	}
	public String getEmergencyHomePhone() {
		return emergencyHomePhone;
	}
	public void setEmergencyHomePhone(String emergencyHomePhone) {
		this.emergencyHomePhone = emergencyHomePhone;
	}
	public String getEmergencyMobilePhone() {
		return emergencyMobilePhone;
	}
	public void setEmergencyMobilePhone(String emergencyMobilePhone) {
		this.emergencyMobilePhone = emergencyMobilePhone;
	}
	public String getEmergencyWorkPhone() {
		return emergencyWorkPhone;
	}
	public void setEmergencyWorkPhone(String emergencyWorkPhone) {
		this.emergencyWorkPhone = emergencyWorkPhone;
	}
	public int getEmergencyContactMethodID() {
		return emergencyContactMethodID;
	}
	public void setEmergencyContactMethodID(int emergencyContactMethodID) {
		this.emergencyContactMethodID = emergencyContactMethodID;
	}
	public String getEmergencyEmail() {
		return emergencyEmail;
	}
	public void setEmergencyEmail(String emergencyEmail) {
		this.emergencyEmail = emergencyEmail;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public int getRecordStatusID() {
		return recordStatusID;
	}
	public void setRecordStatusID(int recordStatusID) {
		this.recordStatusID = recordStatusID;
	}
	
}
