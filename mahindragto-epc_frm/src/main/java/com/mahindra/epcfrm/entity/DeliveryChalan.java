package com.mahindra.epcfrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DeliveryChalan")
public class DeliveryChalan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 100)
	private String delChalanFileName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDelChalanFileName() {
		return delChalanFileName;
	}

	public void setDelChalanFileName(String delChalanFileName) {
		this.delChalanFileName = delChalanFileName;
	}

}
