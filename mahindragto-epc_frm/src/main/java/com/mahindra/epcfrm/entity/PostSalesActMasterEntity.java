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
@Table(name = "PostSalesActMaster")
public class PostSalesActMasterEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1470999596426087486L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int leadId;

	// for next toggle apis
	@Column(length = 50)
	private String woCompStatus;
	private LocalDate woCompDate;

	@Column(length = 50)
	private String inspecStatus;
	private LocalDate inspecDate;

	@Column(length = 50)
	private String firstPayStatus;
	private LocalDate firstPayDate;

	@Column(length = 50)
	private String finalPayStatus;
	private LocalDate finalPayDate;

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

	public String getWoCompStatus() {
		return woCompStatus;
	}

	public void setWoCompStatus(String woCompStatus) {
		this.woCompStatus = woCompStatus;
	}

	public LocalDate getWoCompDate() {
		return woCompDate;
	}

	public void setWoCompDate(LocalDate woCompDate) {
		this.woCompDate = woCompDate;
	}

	public String getInspecStatus() {
		return inspecStatus;
	}

	public void setInspecStatus(String inspecStatus) {
		this.inspecStatus = inspecStatus;
	}

	public LocalDate getInspecDate() {
		return inspecDate;
	}

	public void setInspecDate(LocalDate inspecDate) {
		this.inspecDate = inspecDate;
	}

	public String getFirstPayStatus() {
		return firstPayStatus;
	}

	public void setFirstPayStatus(String firstPayStatus) {
		this.firstPayStatus = firstPayStatus;
	}

	public LocalDate getFirstPayDate() {
		return firstPayDate;
	}

	public void setFirstPayDate(LocalDate firstPayDate) {
		this.firstPayDate = firstPayDate;
	}

	public String getFinalPayStatus() {
		return finalPayStatus;
	}

	public void setFinalPayStatus(String finalPayStatus) {
		this.finalPayStatus = finalPayStatus;
	}

	public LocalDate getFinalPayDate() {
		return finalPayDate;
	}

	public void setFinalPayDate(LocalDate finalPayDate) {
		this.finalPayDate = finalPayDate;
	}
}
