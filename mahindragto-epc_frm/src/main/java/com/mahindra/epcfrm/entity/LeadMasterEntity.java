/**
 * 
 */
package com.mahindra.epcfrm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Raju.Addu
 *
 */
@Entity
@Table(name = "LeadMaster")
public class LeadMasterEntity extends BaseEntity {

	private static final long serialVersionUID = 1331398974558006304L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	private FarmerMasterEntity farmerMaster;

	@OneToOne(cascade = CascadeType.ALL)
	private SiteSurveyMasterEntity siteSurveyMaster;

	@OneToOne(cascade = CascadeType.ALL)
	private MaterialDeliveryMaster materialDeliveryMaster;

	@OneToOne(cascade = CascadeType.ALL)
	private RegistrationDetailsMasterEntity regDetailsMaster;

	@OneToOne(cascade = CascadeType.ALL)
	private MaterialInstallationMasterEntity materialInstallMaster;

	// kyc new entity
	@OneToOne(cascade = CascadeType.ALL)
	private KYCMasterEntity kycId;

	@OneToOne(cascade = CascadeType.ALL)
	private WorkOrderMasterEntity wordOrderMaster;

	@OneToOne(cascade = CascadeType.ALL)
	private PostSalesActMasterEntity postSalesMaster;

	@Column(length = 15)
	private String userMobile;

	// status
	@Column(length = 50)
	private String farmerInfoStatus;
	@Column(length = 50)
	private String siteSurveyStatus;
	@Column(length = 50)
	private String kycStatus;
	@Column(length = 50)
	private String regDetailsStatus;
	@Column(length = 50)
	private String workOrderStatus;
	@Column(length = 50)
	private String materialDeliStatus;
	@Column(length = 50)
	private String materialInsaStatus;
	@Column(length = 50)
	private String invDetailsStatus;
	@Column(length = 50)
	private String formStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FarmerMasterEntity getFarmerMaster() {
		return farmerMaster;
	}

	public void setFarmerMaster(FarmerMasterEntity farmerMaster) {
		this.farmerMaster = farmerMaster;
	}

	public SiteSurveyMasterEntity getSiteSurveyMaster() {
		return siteSurveyMaster;
	}

	public void setSiteSurveyMaster(SiteSurveyMasterEntity siteSurveyMaster) {
		this.siteSurveyMaster = siteSurveyMaster;
	}

	public MaterialDeliveryMaster getMaterialDeliveryMaster() {
		return materialDeliveryMaster;
	}

	public void setMaterialDeliveryMaster(MaterialDeliveryMaster materialDeliveryMaster) {
		this.materialDeliveryMaster = materialDeliveryMaster;
	}

	public RegistrationDetailsMasterEntity getRegDetailsMaster() {
		return regDetailsMaster;
	}

	public void setRegDetailsMaster(RegistrationDetailsMasterEntity regDetailsMaster) {
		this.regDetailsMaster = regDetailsMaster;
	}

	public MaterialInstallationMasterEntity getMaterialInstallMaster() {
		return materialInstallMaster;
	}

	public void setMaterialInstallMaster(MaterialInstallationMasterEntity materialInstallMaster) {
		this.materialInstallMaster = materialInstallMaster;
	}

	public KYCMasterEntity getKycId() {
		return kycId;
	}

	public void setKycId(KYCMasterEntity kycId) {
		this.kycId = kycId;
	}

	public String getWorkOrderStatus() {
		return workOrderStatus;
	}

	public void setWorkOrderStatus(String workOrderStatus) {
		this.workOrderStatus = workOrderStatus;
	}

	public String getKycStatus() {
		return kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public WorkOrderMasterEntity getWordOrderMaster() {
		return wordOrderMaster;
	}

	public void setWordOrderMaster(WorkOrderMasterEntity wordOrderMaster) {
		this.wordOrderMaster = wordOrderMaster;
	}

	public String getFarmerInfoStatus() {
		return farmerInfoStatus;
	}

	public void setFarmerInfoStatus(String farmerInfoStatus) {
		this.farmerInfoStatus = farmerInfoStatus;
	}

	public String getSiteSurveyStatus() {
		return siteSurveyStatus;
	}

	public void setSiteSurveyStatus(String siteSurveyStatus) {
		this.siteSurveyStatus = siteSurveyStatus;
	}

	public String getRegDetailsStatus() {
		return regDetailsStatus;
	}

	public void setRegDetailsStatus(String regDetailsStatus) {
		this.regDetailsStatus = regDetailsStatus;
	}

	public String getMaterialDeliStatus() {
		return materialDeliStatus;
	}

	public void setMaterialDeliStatus(String materialDeliStatus) {
		this.materialDeliStatus = materialDeliStatus;
	}

	public String getMaterialInsaStatus() {
		return materialInsaStatus;
	}

	public void setMaterialInsaStatus(String materialInsaStatus) {
		this.materialInsaStatus = materialInsaStatus;
	}

	public String getInvDetailsStatus() {
		return invDetailsStatus;
	}

	public void setInvDetailsStatus(String invDetailsStatus) {
		this.invDetailsStatus = invDetailsStatus;
	}

	public String getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}

	public PostSalesActMasterEntity getPostSalesMaster() {
		return postSalesMaster;
	}

	public void setPostSalesMaster(PostSalesActMasterEntity postSalesMaster) {
		this.postSalesMaster = postSalesMaster;
	}

}
