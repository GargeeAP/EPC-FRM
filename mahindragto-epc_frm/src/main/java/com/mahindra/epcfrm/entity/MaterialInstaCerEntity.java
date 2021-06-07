package com.mahindra.epcfrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MaterialInstaCer")
public class MaterialInstaCerEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -765885099170490701L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 100)
	private String materialInstaCerFile;
	
	private int materialInstaCerFileId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterialInstaCerFile() {
		return materialInstaCerFile;
	}

	public void setMaterialInstaCerFile(String materialInstaCerFile) {
		this.materialInstaCerFile = materialInstaCerFile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getMaterialInstaCerFileId() {
		return materialInstaCerFileId;
	}

	public void setMaterialInstaCerFileId(int materialInstaCerFileId) {
		this.materialInstaCerFileId = materialInstaCerFileId;
	}

	
}
