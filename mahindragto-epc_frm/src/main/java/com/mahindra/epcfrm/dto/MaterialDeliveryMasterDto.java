package com.mahindra.epcfrm.dto;

import java.util.List;
import com.mahindra.epcfrm.entity.MaterialDeliveryCerEntity;
import com.mahindra.epcfrm.entity.MaterialDeliveryPhotosEntity;

public class MaterialDeliveryMasterDto {

	private int leadId;
	private List<MaterialDeliveryPhotosEntity> materialPhotos;
	private String uploadVideo;
	private int uploadVideoId;
	private List<MaterialDeliveryCerEntity> materialDeliveryCer;
	private String perInvoicePhoto;
	private int perInvoicePhotoId;
	private String perInvoiceNumber;
	private Long otp;
	private double gpsLat;
	private double gpsLong;
	private String timeStamp;
	private String materialDeliStatus;

	private String formStatus;

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public String getUploadVideo() {
		return uploadVideo;
	}

	public void setUploadVideo(String uploadVideo) {
		this.uploadVideo = uploadVideo;
	}

	public String getPerInvoicePhoto() {
		return perInvoicePhoto;
	}

	public void setPerInvoicePhoto(String perInvoicePhoto) {
		this.perInvoicePhoto = perInvoicePhoto;
	}

	public String getPerInvoiceNumber() {
		return perInvoiceNumber;
	}

	public void setPerInvoiceNumber(String perInvoiceNumber) {
		this.perInvoiceNumber = perInvoiceNumber;
	}

	public List<MaterialDeliveryPhotosEntity> getMaterialPhotos() {
		return materialPhotos;
	}

	public void setMaterialPhotos(List<MaterialDeliveryPhotosEntity> materialPhotos) {
		this.materialPhotos = materialPhotos;
	}

	public List<MaterialDeliveryCerEntity> getMaterialDeliveryCer() {
		return materialDeliveryCer;
	}

	public void setMaterialDeliveryCer(List<MaterialDeliveryCerEntity> materialDeliveryCer) {
		this.materialDeliveryCer = materialDeliveryCer;
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

	public String getMaterialDeliStatus() {
		return materialDeliStatus;
	}

	public void setMaterialDeliStatus(String materialDeliStatus) {
		this.materialDeliStatus = materialDeliStatus;
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

	public int getPerInvoicePhotoId() {
		return perInvoicePhotoId;
	}

	public void setPerInvoicePhotoId(int perInvoicePhotoId) {
		this.perInvoicePhotoId = perInvoicePhotoId;
	}

}
