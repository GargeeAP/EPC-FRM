/**
 * 
 */
package com.mahindra.epcfrm.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Raju.Addu
 *
 */
@Entity
@Table(name = "ActivityHistory")
public class ActivityHistoryEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8040747228655677601L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 50)
	private String userId;
	@Column(length = 100)
	private String farmerName;
	@Column(length = 15)
	private String farmerMobile;
	@Column(length = 50)
	private String activityType;
	@Column(length = 100)
	private String customerName;
	@Column(length = 15)
	private String customerMobile;
	private String remarks;
	private LocalDate date;
	private LocalTime fromTime;
	private LocalTime toTime;

	/*
	 * @Column(length = 6) private long pin;
	 * 
	 * @Column(length = 100) private String village;
	 * 
	 * @Column(length = 25) private String irrSystem; private String area;
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
