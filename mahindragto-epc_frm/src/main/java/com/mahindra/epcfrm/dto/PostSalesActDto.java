package com.mahindra.epcfrm.dto;

import java.time.LocalDate;

public class PostSalesActDto {

	private int leadId;
	private String tag;
	private String postSalesStatus;
	private LocalDate postSalesDate;
	private String formStatus;

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getPostSalesStatus() {
		return postSalesStatus;
	}

	public void setPostSalesStatus(String postSalesStatus) {
		this.postSalesStatus = postSalesStatus;
	}

	public LocalDate getPostSalesDate() {
		return postSalesDate;
	}

	public void setPostSalesDate(LocalDate postSalesDate) {
		this.postSalesDate = postSalesDate;
	}

	public String getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}

}
