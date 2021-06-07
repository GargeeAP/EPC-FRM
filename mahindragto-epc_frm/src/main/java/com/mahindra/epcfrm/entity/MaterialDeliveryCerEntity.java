package com.mahindra.epcfrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MaterialDeliveryCer")
public class MaterialDeliveryCerEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8584987744526209714L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int materialDelCerId;
	
	@Column(length = 100)
	private String materialDelCerFile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getMaterialDelCerId() {
		return materialDelCerId;
	}

	public void setMaterialDelCerId(int materialDelCerId) {
		this.materialDelCerId = materialDelCerId;
	}

	public String getMaterialDelCerFile() {
		return materialDelCerFile;
	}

	public void setMaterialDelCerFile(String materialDelCerFile) {
		this.materialDelCerFile = materialDelCerFile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
