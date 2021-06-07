package com.mahindra.epcfrm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FilesMaintainMaster")
public class FilesMaintainMasterEntity extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4069091263221621317L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int leadId;
	
	private String fileName;
	
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
