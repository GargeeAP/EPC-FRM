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
@Table(name = "RegistrationDetailsMaster")
public class RegistrationDetailsMasterEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2739173175129468676L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int leadId;
	
	
	private String farmerRegNo;
	private LocalDate regDate;
	private Long boqNumber;
	private String spacing;
	private String irrSpacing;
	@Column(length = 100)
	private String quotAttachment;
	private int quotAttachmentId;
	@Column(length = 50)
	private String quotAmount;
	
	//farmer Contribution
	private String loanStatus;
	private String bankName;
	private String bankCode;
	private Long ddNo;
	private double ddAmount;
	@Column(length = 100)
	private String ddAttachment;
	private int ddAttachmentId;
	private LocalDate ddDate;
	private LocalDate preInspectionDate;
	@Column(length = 100)
	private String faAcceptAttachment;
	private int faAcceptAttachmentId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLeadId() {
		return leadId;
	}
	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}
	public String getFarmerRegNo() {
		return farmerRegNo;
	}
	public void setFarmerRegNo(String farmerRegNo) {
		this.farmerRegNo = farmerRegNo;
	}
	public String getQuotAttachment() {
		return quotAttachment;
	}
	public void setQuotAttachment(String quotAttachment) {
		this.quotAttachment = quotAttachment;
	}
	public String getQuotAmount() {
		return quotAmount;
	}
	public void setQuotAmount(String quotAmount) {
		this.quotAmount = quotAmount;
	}
	public Long getDdNo() {
		return ddNo;
	}
	public void setDdNo(Long ddNo) {
		this.ddNo = ddNo;
	}
	public double getDdAmount() {
		return ddAmount;
	}
	public void setDdAmount(double ddAmount) {
		this.ddAmount = ddAmount;
	}
	public String getDdAttachment() {
		return ddAttachment;
	}
	public void setDdAttachment(String ddAttachment) {
		this.ddAttachment = ddAttachment;
	}
	public LocalDate getDdDate() {
		return ddDate;
	}
	public void setDdDate(LocalDate ddDate) {
		this.ddDate = ddDate;
	}
	public LocalDate getPreInspectionDate() {
		return preInspectionDate;
	}
	public void setPreInspectionDate(LocalDate preInspectionDate) {
		this.preInspectionDate = preInspectionDate;
	}
	public String getFaAcceptAttachment() {
		return faAcceptAttachment;
	}
	public void setFaAcceptAttachment(String faAcceptAttachment) {
		this.faAcceptAttachment = faAcceptAttachment;
	}
	
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public Long getBoqNumber() {
		return boqNumber;
	}
	public void setBoqNumber(Long boqNumber) {
		this.boqNumber = boqNumber;
	}
	public String getSpacing() {
		return spacing;
	}
	public void setSpacing(String spacing) {
		this.spacing = spacing;
	}
	public String getIrrSpacing() {
		return irrSpacing;
	}
	public void setIrrSpacing(String irrSpacing) {
		this.irrSpacing = irrSpacing;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getQuotAttachmentId() {
		return quotAttachmentId;
	}
	public void setQuotAttachmentId(int quotAttachmentId) {
		this.quotAttachmentId = quotAttachmentId;
	}
	public int getDdAttachmentId() {
		return ddAttachmentId;
	}
	public void setDdAttachmentId(int ddAttachmentId) {
		this.ddAttachmentId = ddAttachmentId;
	}
	public int getFaAcceptAttachmentId() {
		return faAcceptAttachmentId;
	}
	public void setFaAcceptAttachmentId(int faAcceptAttachmentId) {
		this.faAcceptAttachmentId = faAcceptAttachmentId;
	}
	
	
}
