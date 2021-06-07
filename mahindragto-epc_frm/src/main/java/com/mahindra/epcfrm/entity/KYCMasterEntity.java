package com.mahindra.epcfrm.entity;

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
@Table(name = "KycMaster")
public class KYCMasterEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5795551699030996866L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int leadId;
	
	@Column(length = 50)
	private String kycNo;

	@Column(length = 12)
	private String aadharNo;
	

	@Column(length = 100)
	private String farmerPhoto;
	private int farmerPhotoId;
	
	@Column(length = 100)
	private String waterTestDoc;
	private int waterTestDocId;

	@Column(length = 100)
	private String soilTestDoc;
	private int soilTestDocId;
	
	@Column(length = 100)
	private String bankDoc;
	private int bankDocId;
	
	@Column(length = 100)
	private String aadharCard;
	private int aadharCardId;
	
	@Column(length = 100)
	private String rationCard;
	private int rationCardId;
	
	@Column(length = 100)
	private String patta;
	private int pattaId;
	
	@Column(length = 100)
	private String chitta;
	private int chittaId;
	
	@Column(length = 100)
	private String surveyCaptureImage;
	private int surveyCaptureImageId;
	
	@Column(length = 100)
	private String gpsCaptureImage;
	private int gpsCaptureImageId;
	
	@Column(length = 100)
	private String otherDoc;
	private int otherDocId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKycNo() {
		return kycNo;
	}

	public void setKycNo(String kycNo) {
		this.kycNo = kycNo;
	}

	public String getFarmerPhoto() {
		return farmerPhoto;
	}

	public void setFarmerPhoto(String farmerPhoto) {
		this.farmerPhoto = farmerPhoto;
	}

	public String getWaterTestDoc() {
		return waterTestDoc;
	}

	public void setWaterTestDoc(String waterTestDoc) {
		this.waterTestDoc = waterTestDoc;
	}

	public String getSoilTestDoc() {
		return soilTestDoc;
	}

	public void setSoilTestDoc(String soilTestDoc) {
		this.soilTestDoc = soilTestDoc;
	}

	public String getBankDoc() {
		return bankDoc;
	}

	public void setBankDoc(String bankDoc) {
		this.bankDoc = bankDoc;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getRationCard() {
		return rationCard;
	}

	public void setRationCard(String rationCard) {
		this.rationCard = rationCard;
	}

	public String getPatta() {
		return patta;
	}

	public void setPatta(String patta) {
		this.patta = patta;
	}

	public String getChitta() {
		return chitta;
	}

	public void setChitta(String chitta) {
		this.chitta = chitta;
	}

	public String getSurveyCaptureImage() {
		return surveyCaptureImage;
	}

	public void setSurveyCaptureImage(String surveyCaptureImage) {
		this.surveyCaptureImage = surveyCaptureImage;
	}

	public String getGpsCaptureImage() {
		return gpsCaptureImage;
	}

	public void setGpsCaptureImage(String gpsCaptureImage) {
		this.gpsCaptureImage = gpsCaptureImage;
	}

	public String getOtherDoc() {
		return otherDoc;
	}

	public void setOtherDoc(String otherDoc) {
		this.otherDoc = otherDoc;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public int getFarmerPhotoId() {
		return farmerPhotoId;
	}

	public void setFarmerPhotoId(int farmerPhotoId) {
		this.farmerPhotoId = farmerPhotoId;
	}

	public int getWaterTestDocId() {
		return waterTestDocId;
	}

	public void setWaterTestDocId(int waterTestDocId) {
		this.waterTestDocId = waterTestDocId;
	}

	public int getSoilTestDocId() {
		return soilTestDocId;
	}

	public void setSoilTestDocId(int soilTestDocId) {
		this.soilTestDocId = soilTestDocId;
	}

	public int getBankDocId() {
		return bankDocId;
	}

	public void setBankDocId(int bankDocId) {
		this.bankDocId = bankDocId;
	}

	public int getAadharCardId() {
		return aadharCardId;
	}

	public void setAadharCardId(int aadharCardId) {
		this.aadharCardId = aadharCardId;
	}

	public int getRationCardId() {
		return rationCardId;
	}

	public void setRationCardId(int rationCardId) {
		this.rationCardId = rationCardId;
	}

	public int getPattaId() {
		return pattaId;
	}

	public void setPattaId(int pattaId) {
		this.pattaId = pattaId;
	}

	public int getChittaId() {
		return chittaId;
	}

	public void setChittaId(int chittaId) {
		this.chittaId = chittaId;
	}

	public int getSurveyCaptureImageId() {
		return surveyCaptureImageId;
	}

	public void setSurveyCaptureImageId(int surveyCaptureImageId) {
		this.surveyCaptureImageId = surveyCaptureImageId;
	}

	public int getGpsCaptureImageId() {
		return gpsCaptureImageId;
	}

	public void setGpsCaptureImageId(int gpsCaptureImageId) {
		this.gpsCaptureImageId = gpsCaptureImageId;
	}

	public int getOtherDocId() {
		return otherDocId;
	}

	public void setOtherDocId(int otherDocId) {
		this.otherDocId = otherDocId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
