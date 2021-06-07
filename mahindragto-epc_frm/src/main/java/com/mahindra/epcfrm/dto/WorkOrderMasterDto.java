package com.mahindra.epcfrm.dto;

import java.time.LocalDate;


public class WorkOrderMasterDto {
	
	private int leadId;
	private String wOStatus;
	private String wONumber;
	private String apprStatusValue;
	private LocalDate wODate;
	private String drawingNo;
	private String reqForApp;
	private String workOrderStatus;
	private String formStatus;
	
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
	public String getWorkOrderStatus() {
		return workOrderStatus;
	}
	public void setWorkOrderStatus(String workOrderStatus) {
		this.workOrderStatus = workOrderStatus;
	}
	public String getFormStatus() {
		return formStatus;
	}
	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}
	
	
	
}
