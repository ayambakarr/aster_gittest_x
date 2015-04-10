package com.mitrais.research.springhibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PatientAlcohol")
public class PatientAlcohol {
	@Id
	@GenericGenerator(name = "guidGenerator", strategy = "guid")
	@GeneratedValue(generator = "guidGenerator")	
	@Column(name = "PatientAlcoholGUID", columnDefinition = "uniqueidentifier", nullable = false)
	String patientAlcoholGUID;	
	@Column(name = "AssessmentDate", nullable = false)
	Date assessmentDate;
	@Column(name = "AlcoholStatusID", nullable = false)
	Integer alcoholStatusID;
	@Column(name = "DrinksPerDay")
	Integer drinksPerDay;
	@Column(name = "AlcoholBingeStatusID")
	Integer alcoholBingeStatusID;
	@Column(name = "HistoryAlcoholStatusID")
	Integer historyAlcoholStatusID;
	@Column(name = "HistoryStartedYear")
	Integer historyStartedYear;
	@Column(name = "HistoryStoppedYear")
	Integer historyStoppedYear;
	@Column(name = "AlcoholQuitStatusID")
	Integer alcoholQuitStatusID;
	@Column(name = "AlcoholNotes", length = 500)
	String alcoholNotes;
	@Column(name = "CreatedBy", columnDefinition = "uniqueidentifier", nullable = false)
	String createdBy;
	@Column(name = "CreatedDate", nullable = false)
	Date createdDate;
	@Column(name = "UpdatedBy", columnDefinition = "uniqueidentifier", nullable = false)
	String updatedBy;
	@Column(name = "UpdatedDate", nullable = false)
	Date updatedDate;
	@Column(name = "RecordStatusID", nullable = false)
	Integer recordStatusID;
	
	public PatientAlcohol(){
	}

	public PatientAlcohol(Date assessmentDate, Integer alcoholStatusID, String createdBy,
			Date createdDate, String updatedBy, Date updatedDate,
			Integer recordStatusID) {
		super();
		this.assessmentDate = assessmentDate;
		this.alcoholStatusID = alcoholStatusID;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.recordStatusID = recordStatusID;
	}

	public String getPatientAlcoholGUID() {
		return patientAlcoholGUID;
	}

	public void setPatientAlcoholGUID(String patientAlcoholGUID) {
		this.patientAlcoholGUID = patientAlcoholGUID;
	}
	
	public Date getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public Integer getAlcoholStatusID() {
		return alcoholStatusID;
	}

	public void setAlcoholStatusID(Integer alcoholStatusID) {
		this.alcoholStatusID = alcoholStatusID;
	}

	public Integer getDrinksPerDay() {
		return drinksPerDay;
	}

	public void setDrinksPerDay(Integer drinksPerDay) {
		this.drinksPerDay = drinksPerDay;
	}

	public Integer getAlcoholBingeStatusID() {
		return alcoholBingeStatusID;
	}

	public void setAlcoholBingeStatusID(Integer alcoholBingeStatusID) {
		this.alcoholBingeStatusID = alcoholBingeStatusID;
	}

	public Integer getHistoryAlcoholStatusID() {
		return historyAlcoholStatusID;
	}

	public void setHistoryAlcoholStatusID(Integer historyAlcoholStatusID) {
		this.historyAlcoholStatusID = historyAlcoholStatusID;
	}

	public Integer getHistoryStartedYear() {
		return historyStartedYear;
	}

	public void setHistoryStartedYear(Integer historyStartedYear) {
		this.historyStartedYear = historyStartedYear;
	}

	public Integer getHistoryStoppedYear() {
		return historyStoppedYear;
	}

	public void setHistoryStoppedYear(Integer historyStoppedYear) {
		this.historyStoppedYear = historyStoppedYear;
	}

	public Integer getAlcoholQuitStatusID() {
		return alcoholQuitStatusID;
	}

	public void setAlcoholQuitStatusID(Integer alcoholQuitStatusID) {
		this.alcoholQuitStatusID = alcoholQuitStatusID;
	}

	public String getAlcoholNotes() {
		return alcoholNotes;
	}

	public void setAlcoholNotes(String alcoholNotes) {
		this.alcoholNotes = alcoholNotes;
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

	public Integer getRecordStatusID() {
		return recordStatusID;
	}

	public void setRecordStatusID(Integer recordStatusID) {
		this.recordStatusID = recordStatusID;
	}
}
