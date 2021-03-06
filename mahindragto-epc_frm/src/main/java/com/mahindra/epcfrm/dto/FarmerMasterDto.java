package com.mahindra.epcfrm.dto;

import java.time.LocalDate;

public class FarmerMasterDto {

	private int leadId;
	private String sal;
	private String firstName;
	private String lastName;
	private Long faMobile;
	private String emailId;
	private String fatherName;
	private String asmName;
	private String dealerName;
	private String dealerCode;
	private String sapFarmerCode;// sapFarmerCode
	private String statusOnlinePortal;
	private String farmerInfoStatus;
	private String formStatus;
    private String enquiryType;
    private String leadSource;
    private LocalDate estiMonthPur;
    
	
	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
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

	public Long getFaMobile() {
		return faMobile;
	}

	public void setFaMobile(Long faMobile) {
		this.faMobile = faMobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAsmName() {
		return asmName;
	}

	public void setAsmName(String asmName) {
		this.asmName = asmName;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getSapFarmerCode() {
		return sapFarmerCode;
	}

	public void setSapFarmerCode(String sapFarmerCode) {
		this.sapFarmerCode = sapFarmerCode;
	}

	public String getStatusOnlinePortal() {
		return statusOnlinePortal;
	}

	public void setStatusOnlinePortal(String statusOnlinePortal) {
		this.statusOnlinePortal = statusOnlinePortal;
	}

	public String getFarmerInfoStatus() {
		return farmerInfoStatus;
	}

	public void setFarmerInfoStatus(String farmerInfoStatus) {
		this.farmerInfoStatus = farmerInfoStatus;
	}

	public String getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}

	public String getEnquiryType() {
		return enquiryType;
	}

	public void setEnquiryType(String enquiryType) {
		this.enquiryType = enquiryType;
	}

	public String getLeadSource() {
		return leadSource;
	}

	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}

	public LocalDate getEstiMonthPur() {
		return estiMonthPur;
	}

	public void setEstiMonthPur(LocalDate estiMonthPur) {
		this.estiMonthPur = estiMonthPur;
	}
	
	
}
