package com.mahindra.epcfrm.dto;

import java.util.List;
import com.mahindra.epcfrm.entity.MaterialInstallationPhotosEntity;
import com.mahindra.epcfrm.entity.MaterialInstaCerEntity;

public class MaterialInstallationMasterDto {

    private int leadId;
	private List<MaterialInstallationPhotosEntity> materialInstaPhotos;
	private String uploadVideo;
	private int uploadVideoId;
	private List<MaterialInstaCerEntity> materialInstaCer;
	private Long otp;
	private double gpsLat;
	private double gpsLong;
	private String timeStamp;
	private String materialInsaStatus;
	private String formStatus;
	
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
	public String getMaterialInsaStatus() {
		return materialInsaStatus;
	}
	public void setMaterialInsaStatus(String materialInsaStatus) {
		this.materialInsaStatus = materialInsaStatus;
	}
	public String getFormStatus() {
		return formStatus;
	}
	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}
	public int getUploadVideoId() {
		return uploadVideoId;
	}
	public void setUploadVideoId(int uploadVideoId) {
		this.uploadVideoId = uploadVideoId;
	}
	
	
	
	
}
