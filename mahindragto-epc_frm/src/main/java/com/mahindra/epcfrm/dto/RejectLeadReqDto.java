package com.mahindra.epcfrm.dto;

public class RejectLeadReqDto {
	
	private int leadId;
	private String formStatus;
	public int getLeadId() {
		return leadId;
	}
	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}
	public String getFormStatus() {
		return formStatus;
	}
	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}
	
}
