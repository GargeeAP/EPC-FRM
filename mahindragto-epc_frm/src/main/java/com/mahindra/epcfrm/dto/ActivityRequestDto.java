/**
 * 
 */
package com.mahindra.epcfrm.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

/**
 * @author Raju.Addu
 *
 */
@Component
public class ActivityRequestDto {

	private String activityType;
	private String customerName;
	private String customerMobile;
	private String farmerName;
	private String farmerMobile;
	private String remarks;
	private LocalDate date;
	private LocalTime fromTime;
	private LocalTime toTime;
	
	/*
	 * private long pin; private String irrSystem; private String area; private
	 * String village;
	 */

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getFromTime() {
		return fromTime;
	}

	public void setFromTime(LocalTime fromTime) {
		this.fromTime = fromTime;
	}

	public LocalTime getToTime() {
		return toTime;
	}

	public void setToTime(LocalTime toTime) {
		this.toTime = toTime;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmerMobile() {
		return farmerMobile;
	}

	public void setFarmerMobile(String farmerMobile) {
		this.farmerMobile = farmerMobile;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
