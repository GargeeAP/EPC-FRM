package com.mahindra.epcfrm.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Birla.Manoj
 *
 */
@Entity
@Table(name = "SiteSurveyMaster")
public class SiteSurveyMasterEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8899791286917795718L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int leadId;

	// Farmer Address
	@Column(length = 500)
	private String address1;

	@Column(length = 500)
	private String address2;

	@Column(length = 100)
	private String village;

	@Column(length = 100)
	private String taluka;

	@Column(length = 100)
	private String dist;

	@Column(length = 100)
	private String city;

	@Column(length = 50)
	private String state;

	@Column(length = 50)
	private String stateName;

	@Column(length = 6)
	private int pinCode;

	// Land Address
	@Column(length = 100)
	private String landSurveyNo;
	@Column(length = 100)
	private String landVillage;
	@Column(length = 100)
	private String landDistrict;
	@Column(length = 100)
	private String landTaluka;
	@Column(length = 6)
	private int landPincode;

	// Land Details
	private double landAreaHec;
	private double areaHec;
	@Column(length = 50)
	private String crop;
	@Column(length = 5)
	private String cropId;
	private String waterSource;
	private String irrSystem;
	private String eleMeter;
	private double subsidyPer;
	private double amount;
	@Column(length = 100)
	private String iniQuotAttachment;
	
	private int iniQuotAttachmentId;
	@Column(length = 50)
	private String misProduct;
	// private LocalDate estiMonthPur;
	// @Column(length = 50)
	// private String enquiryType;
	private LocalDate visitDate;

	// private String gps;

	private double gpsLat;
	private double gpsLong;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
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
	
	
}
