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
@Table(name = "MaterialDeliveryMaster")
public class MaterialDeliveryMaster extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4249874379794673049L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int leadId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "materialDeliveryPhId")
	private List<MaterialDeliveryPhotosEntity> materialPhotos;

	private String uploadVideo;
	private int uploadVideoId;
	
	private String perInvoicePhoto;
	private int perInvoicePhotoId;
	
	private String perInvoiceNumber;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MaterialDeliveryCerId")
	private List<MaterialDeliveryCerEntity> materialDeliveryCer;

	private Long otp;
	// private String gps;

	private double gpsLat;
	private double gpsLong;

	private String timeStamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<MaterialDeliveryPhotosEntity> getMaterialPhotos() {
		return materialPhotos;
	}

	public void setMaterialPhotos(List<MaterialDeliveryPhotosEntity> materialPhotos) {
		this.materialPhotos = materialPhotos;
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

	public List<MaterialDeliveryCerEntity> getMaterialDeliveryCer() {
		return materialDeliveryCer;
	}

	public void setMaterialDeliveryCer(List<MaterialDeliveryCerEntity> materialDeliveryCer) {
		this.materialDeliveryCer = materialDeliveryCer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
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
