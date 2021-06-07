package com.mahindra.epcfrm.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WorkOrderMaster")
public class WorkOrderMasterEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8690916692650623105L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int leadId;
	@Column(length = 50)
	private String wOStatus;

	@Column(length = 50)
	private String wONumber;

	@Column(length = 50)
	private String apprStatusValue;

	private LocalDate wODate;
	private String drawingNo;
	private String reqForApp;

	

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

	public String getwOStatus() {
		return wOStatus;
	}

	public void setwOStatus(String wOStatus) {
		this.wOStatus = wOStatus;
	}

	public String getwONumber() {
		return wONumber;
	}

	public void setwONumber(String wONumber) {
		this.wONumber = wONumber;
	}

	public String getApprStatusValue() {
		return apprStatusValue;
	}

	public void setApprStatusValue(String apprStatusValue) {
		this.apprStatusValue = apprStatusValue;
	}

	public LocalDate getwODate() {
		return wODate;
	}

	public void setwODate(LocalDate wODate) {
		this.wODate = wODate;
	}

	public String getDrawingNo() {
		return drawingNo;
	}

	public void setDrawingNo(String drawingNo) {
		this.drawingNo = drawingNo;
	}

	public String getReqForApp() {
		return reqForApp;
	}

	public void setReqForApp(String reqForApp) {
		this.reqForApp = reqForApp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
