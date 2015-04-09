package com.mitrais.research.springhibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "LetterTemplate")
public class LetterTemplate implements Serializable {
	@Id
	@GenericGenerator(name = "guidGenerator", strategy = "guid")
	@GeneratedValue(generator = "guidGenerator")	
	@Column (name = "LetterTemplateGUID", columnDefinition = "uniqueidentifier", nullable = false)
	String letterTemplateGUID;	
	@Column (name = "LetterTemplateName", nullable = false)
	String letterTemplateName;
	@Column (name = "LetterTypeID", nullable = false)
	int letterTypeID;	
	@Column (name = "ShareID", nullable = false)
	int shareID;
	@Column (name = "RatingID", nullable = false)
	int ratingID;	
	@Column (name = "TemplateContent")
	String templateContent;
	@Column (name = "Description", nullable = false)
	String description;	
	@Column (name = "CreatedBy", columnDefinition = "uniqueidentifier", nullable = false)
	String createdBy;
	@Column (name = "CreatedDate", nullable = false)
	Date createdDate;	
	@Column (name = "UpdatedBy", columnDefinition = "uniqueidentifier", nullable = false)
	String updatedBy;
	@Column (name = "UpdatedDate", nullable = false)
	Date updatedDate;
	@Column (name = "RecordStatusID", nullable = false)
	int recordStatusID; 
	@Column (name = "RowVersion", nullable = false)
	Date rowVersion;
	
	public LetterTemplate(){		
	}

	public LetterTemplate(String letterTemplateGUID, String letterTemplateName,
			int letterTypeID, int shareID, int ratingID,
			String templateContent, String description, String createdBy,
			Date createdDate, String updatedBy, Date updatedDate,
			int recordStatusID, Date rowVersion) {
		super();
		this.letterTemplateGUID = letterTemplateGUID;
		this.letterTemplateName = letterTemplateName;
		this.letterTypeID = letterTypeID;
		this.shareID = shareID;
		this.ratingID = ratingID;
		this.templateContent = templateContent;
		this.description = description;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.recordStatusID = recordStatusID;
		this.rowVersion = rowVersion;
	}

	public String getLetterTemplateGUID() {
		return letterTemplateGUID;
	}

	public void setLetterTemplateGUID(String letterTemplateGUID) {
		this.letterTemplateGUID = letterTemplateGUID;
	}

	public String getLetterTemplateName() {
		return letterTemplateName;
	}

	public void setLetterTemplateName(String letterTemplateName) {
		this.letterTemplateName = letterTemplateName;
	}

	public int getLetterTypeID() {
		return letterTypeID;
	}

	public void setLetterTypeID(int letterTypeID) {
		this.letterTypeID = letterTypeID;
	}

	public int getShareID() {
		return shareID;
	}

	public void setShareID(int shareID) {
		this.shareID = shareID;
	}

	public int getRatingID() {
		return ratingID;
	}

	public void setRatingID(int ratingID) {
		this.ratingID = ratingID;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Date getRowVersion() {
		return rowVersion;
	}

	public void setRowVersion(Date rowVersion) {
		this.rowVersion = rowVersion;
	}
	
	
}
