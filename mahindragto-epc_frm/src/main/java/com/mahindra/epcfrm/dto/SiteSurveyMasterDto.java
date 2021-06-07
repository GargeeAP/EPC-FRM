package com.mahindra.epcfrm.dto;

import java.time.LocalDate;

/**
 * @author Birla.Manoj
 *
 */

public class SiteSurveyMasterDto {

	private int leadId;
	private String address1;
	private String address2;
	private String village;
	private String taluka;
	private String dist;
	private String city;
	private String state;
	private String stateName;
	private int pinCode;
	// Land Address
	private String landSurveyNo;
	private String landVillage;
	private String landDistrict;
	private String landTaluka;
	private int landPincode;

	// Land Details
	private double landAreaHec;
	private double areaHec;
	private String crop;
	private String cropId;
	private String waterSource;
	private String irrSystem;
	private String eleMeter;
	private double subsidyPer;
	private double amount;
	private String iniQuotAttachment;
	private int iniQuotAttachmentId;
	private String misProduct;
	private LocalDate visitDate;
	private String siteSurveyStatus;
	private double gpsLat;
	private double gpsLong;
	
	private String formStatus;
	
	
	

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public double getSubsidyPer() {
		return subsidyPer;
	}

	public void setSubsidyPer(double subsidyPer) {
		this.subsidyPer = subsidyPer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getIniQuotAttachment() {
		return iniQuotAttachment;
	}

	public void setIniQuotAttachment(String iniQuotAttachment) {
		this.iniQuotAttachment = iniQuotAttachment;
	}

	public String getMisProduct() {
		return misProduct;
	}

	public void setMisProduct(String misProduct) {
		this.misProduct = misProduct;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}


	public String getLandSurveyNo() {
		return landSurveyNo;
	}

	public void setLandSurveyNo(String landSurveyNo) {
		this.landSurveyNo = landSurveyNo;
	}

	public String getLandVillage() {
		return landVillage;
	}

	public void setLandVillage(String landVillage) {
		this.landVillage = landVillage;
	}

	public String getLandDistrict() {
		return landDistrict;
	}

	public void setLandDistrict(String landDistrict) {
		this.landDistrict = landDistrict;
	}

	public String getLandTaluka() {
		return landTaluka;
	}

	public void setLandTaluka(String landTaluka) {
		this.landTaluka = landTaluka;
	}

	public int getLandPincode() {
		return landPincode;
	}

	public void setLandPincode(int landPincode) {
		this.landPincode = landPincode;
	}

	public double getLandAreaHec() {
		return landAreaHec;
	}

	public void setLandAreaHec(double landAreaHec) {
		this.landAreaHec = landAreaHec;
	}

	public double getAreaHec() {
		return areaHec;
	}

	public void setAreaHec(double areaHec) {
		this.areaHec = areaHec;
	}

	public String getWaterSource() {
		return waterSource;
	}

	public void setWaterSource(String waterSource) {
		this.waterSource = waterSource;
	}

	public String getIrrSystem() {
		return irrSystem;
	}

	public void setIrrSystem(String irrSystem) {
		this.irrSystem = irrSystem;
	}

	public String getEleMeter() {
		return eleMeter;
	}

	public void setEleMeter(String eleMeter) {
		this.eleMeter = eleMeter;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getSiteSurveyStatus() {
		return siteSurveyStatus;
	}

	public void setSiteSurveyStatus(String siteSurveyStatus) {
		this.siteSurveyStatus = siteSurveyStatus;
	}

	public String getCropId() {
		return cropId;
	}

	public void setCropId(String cropId) {
		this.cropId = cropId;
	}

	public double getGpsLat() {
		return gpsLat;
	}

	public void setGpsLat(double gpsLat) {
		this.gpsLat = gpsLat;
	}

	public double getGpsLong() {
		return gpsLong;
	}

	public void setGpsLong(double gpsLong) {
		this.gpsLong = gpsLong;
	}

	public int getIniQuotAttachmentId() {
		return iniQuotAttachmentId;
	}

	public void setIniQuotAttachmentId(int iniQuotAttachmentId) {
		this.iniQuotAttachmentId = iniQuotAttachmentId;
	}

	public String getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}
	
	
	

}
