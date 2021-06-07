package com.mahindra.epcfrm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Birla.Manoj
 *
 */
@Entity
@Table(name = "MaterialInstallationMaster")
public class MaterialInstallationMasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int leadId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "InstReportPhotosId")
	private List<MaterialInstallationPhotosEntity> materialInstaPhotos;

	private String uploadVideo;
	private int uploadVideoId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MaterialInstaCerId")
	private List<MaterialInstaCerEntity> materialInstaCer;

	private Long otp;
	private double gpsLat;
	private double gpsLong;
	private String timeStamp;
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
	
	public List<MaterialInstallationPhotosEntity> getMaterialInstaPhotos() {
		return materialInstaPhotos;
	}
	public void setMaterialInstaPhotos(List<MaterialInstallationPhotosEntity> materialInstaPhotos) {
		this.materialInstaPhotos = materialInstaPhotos;
	}
	public int getUploadVideoId() {
		return uploadVideoId;
	}
	public void setUploadVideoId(int uploadVideoId) {
		this.uploadVideoId = uploadVideoId;
	}
	public String getUploadVideo() {
		return uploadVideo;
	}
	public void setUploadVideo(String uploadVideo) {
		this.uploadVideo = uploadVideo;
	}
	
	public List<MaterialInstaCerEntity> getMaterialInstaCer() {
		return materialInstaCer;
	}
	public void setMaterialInstaCer(List<MaterialInstaCerEntity> materialInstaCer) {
		this.materialInstaCer = materialInstaCer;
	}
	public Long getOtp() {
		return otp;
	}
	public void setOtp(Long otp) {
		this.otp = otp;
	}
	public double getGpsLat() {
		return gpsLat;
	}
	public void setGpsLat(double gpsLat) {
		this.gpsLat = gpsLat;
	}
	public double getGpsLong() {
		return gpsLong;
	}
	public void setGpsLong(double gpsLong) {
		this.gpsLong = gpsLong;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}
