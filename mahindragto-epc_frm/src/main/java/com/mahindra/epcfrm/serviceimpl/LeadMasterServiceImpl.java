package com.mahindra.epcfrm.serviceimpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mahindra.epcfrm.entity.FarmerMasterEntity;
import com.mahindra.epcfrm.entity.FilesMaintainMasterEntity;
import com.mahindra.epcfrm.entity.MaterialInstallationPhotosEntity;
import com.mahindra.epcfrm.entity.KYCMasterEntity;
import com.mahindra.epcfrm.entity.LeadMasterEntity;
import com.mahindra.epcfrm.entity.MaterialDeliveryCerEntity;
import com.mahindra.epcfrm.entity.MaterialDeliveryMaster;
import com.mahindra.epcfrm.entity.MaterialDeliveryPhotosEntity;
import com.mahindra.epcfrm.entity.MaterialInstaCerEntity;
import com.mahindra.epcfrm.entity.MaterialInstallationMasterEntity;
import com.mahindra.epcfrm.entity.PostSalesActMasterEntity;
import com.mahindra.epcfrm.entity.RegistrationDetailsMasterEntity;
import com.mahindra.epcfrm.entity.SiteSurveyMasterEntity;
import com.mahindra.epcfrm.entity.WorkOrderMasterEntity;
import com.mahindra.epcfrm.dto.FarmerMasterDto;
import com.mahindra.epcfrm.dto.KycMasterDto;
import com.mahindra.epcfrm.dto.LeadFilterDto;
import com.mahindra.epcfrm.dto.LeadSearchDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.dto.MaterialDeliveryMasterDto;
import com.mahindra.epcfrm.dto.MaterialInstallationMasterDto;
import com.mahindra.epcfrm.dto.PostSalesActDto;
import com.mahindra.epcfrm.dto.RegistrationDetailsMasterDto;
import com.mahindra.epcfrm.dto.RejectLeadReqDto;
import com.mahindra.epcfrm.dto.SiteSurveyMasterDto;
import com.mahindra.epcfrm.dto.WorkOrderMasterDto;
import com.mahindra.epcfrm.exception.DataNotFoundException;
import com.mahindra.epcfrm.exception.FileStorageException;
import com.mahindra.epcfrm.repository.CustomerMasterRepo;
import com.mahindra.epcfrm.repository.FarmerMasterRepo;
import com.mahindra.epcfrm.repository.FilesMaintainMasterRepo;
import com.mahindra.epcfrm.repository.KycMasterRepo;
import com.mahindra.epcfrm.repository.LeadMasterRepo;
import com.mahindra.epcfrm.repository.MaterialDeliveryMasterRepo;
import com.mahindra.epcfrm.repository.MaterialDeliveryPhotosRepo;
import com.mahindra.epcfrm.repository.MaterialInstallationMasterRepo;
import com.mahindra.epcfrm.repository.PostSalesActMasterRepo;
import com.mahindra.epcfrm.repository.RegistrationDetailsMasterRepo;
import com.mahindra.epcfrm.repository.SiteSurveyMasterRepo;
import com.mahindra.epcfrm.repository.WorkOrderMasterRepo;
import com.mahindra.epcfrm.service.LeadMasterService;

@Service
public class LeadMasterServiceImpl implements LeadMasterService {

	Logger log = LoggerFactory.getLogger(LeadMasterServiceImpl.class);

	@Autowired
	LeadMasterRepo leadMasterRepo;

	@Autowired
	CustomerMasterRepo customerMasterRepo;

	@Autowired
	FarmerMasterRepo farmerMasterRepo;

	@Autowired
	KycMasterRepo kycMasterRepo;

	@Autowired
	SiteSurveyMasterRepo siteSurveyMasterRepo;

	@Autowired
	WorkOrderMasterRepo woMasterRepo;

	@Autowired
	MaterialDeliveryMasterRepo materialDeliverMasterRepo;

	@Autowired
	RegistrationDetailsMasterRepo regDetailsMasterRepo;

	@Autowired
	MaterialInstallationMasterRepo materialInstMasterRepo;

	@Autowired
	PostSalesActMasterRepo postSalesActRepo;


	@Autowired
	FilesMaintainMasterRepo filesMainMasterRepo;
	
	@Autowired
	MaterialDeliveryPhotosRepo materialDeliveryPhotosRepo;

	private final Path root = Paths.get("uploads");

	/*
	 * Upload File Service
	 */
	public String newUploadFiles(MultipartFile file, LeadMasterEntity leadMaster, String fileName) {
		try {
			log.info("inside upload file service started");
			log.debug("inside upload file service");
			System.out.println("root ");
			if (root == null) {
				Files.createDirectory(root);
			}
			Path targetLocation = this.root
					.resolve(leadMaster.getId() + "_" + fileName + "_" + file.getOriginalFilename());
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ex) {
			log.error("Exception occured in File Uploading", ex);
			throw new FileStorageException("Could not store file " + file + ". Please try again!", ex);
		}
		log.info("inside upload file service ended");
		return file.getOriginalFilename();
	}

	@Override
	public MasterResponseDto leadSearch(LeadSearchDto searchDTO) throws Exception {
		log.info("inside leadSearch service");
		log.debug("inside leadSearch service");
		MasterResponseDto leadSearchRes = new MasterResponseDto();
		List<LeadMasterEntity> leadList = leadMasterRepo.findByUserMobile(searchDTO.getUserMobile());
		log.info("leadList Count:" + leadList.size());
		if (leadList.size() != 0) {
			leadSearchRes.setStatusCode(0);
			leadSearchRes.setMessage("success");
			leadSearchRes.setData(leadList);
			return leadSearchRes;
		} else {
			leadSearchRes.setStatusCode(1);
			leadSearchRes.setMessage("Lead data is not available for this user " + searchDTO.getUserMobile());
			leadSearchRes.setData(null);
			return leadSearchRes;
		}
	}

	@Override
	public MasterResponseDto farmerInfoReg(FarmerMasterDto farmerMDto, HttpSession session) {
		log.info("inside farmerInfoReg save service");
		log.debug("inside farmerInfoReg service");
		String user = (String) session.getAttribute("loginUser");
		MasterResponseDto masterRes = new MasterResponseDto();
		if (farmerMDto.getLeadId() != 0) {
			Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(farmerMDto.getLeadId());
			if (presentLead.isPresent()) {
				LeadMasterEntity lead = presentLead.get();
				Optional<FarmerMasterEntity> avlFarmer = farmerMasterRepo.findById(lead.getFarmerMaster().getId());
				if (avlFarmer.isPresent()) {
					FarmerMasterEntity farmer = avlFarmer.get();
					BeanUtils.copyProperties(farmerMDto, farmer);
					farmer.setId(avlFarmer.get().getId());
					farmer.setLeadId(lead.getId());
					lead.setCreatedBy(farmer.getCreatedBy());
					lead.setFarmerMaster(farmer);
					lead.setUserMobile(user);
					lead.setModifiedBy(user);
					lead.setFarmerInfoStatus(farmerMDto.getFarmerInfoStatus());
					lead.setFormStatus(farmerMDto.getFormStatus());
					lead.setId(farmerMDto.getLeadId());
					LeadMasterEntity saveLead = leadMasterRepo.save(lead);
					masterRes.setData(saveLead);
					masterRes.setMessage("success");
					masterRes.setStatusCode(0);
				} else {
					masterRes.setData(null);
					masterRes.setMessage("This farmer is not available");
					masterRes.setStatusCode(1);
				}
			} else {
				masterRes.setData(null);
				masterRes.setMessage(farmerMDto.getLeadId() + " This lead is not available");
				masterRes.setStatusCode(1);

			}
		} else {
			FarmerMasterEntity farmer = new FarmerMasterEntity();
			farmer.setCreatedBy(user);
			BeanUtils.copyProperties(farmerMDto, farmer);
			LeadMasterEntity lead = new LeadMasterEntity();
			lead.setFarmerMaster(farmer);
			lead.setUserMobile(user);
			lead.setFarmerInfoStatus(farmerMDto.getFarmerInfoStatus());
			lead.setFormStatus(farmerMDto.getFormStatus());
			LeadMasterEntity saveLead = leadMasterRepo.save(lead);
			masterRes.setData(saveLead);
			masterRes.setMessage("success");
			masterRes.setStatusCode(0);
		}
		return masterRes;
	}

	@Override
	public MasterResponseDto workOrderReg(WorkOrderMasterDto woDto) {
		log.info("inside  workOrderReg service");
		log.debug("inside  workOrderReg service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(woDto.getLeadId());
		if (presentLead.isPresent()) {
			Optional<WorkOrderMasterEntity> woAvl = woMasterRepo.findByLeadId(woDto.getLeadId());
			LeadMasterEntity lead = presentLead.get();
			WorkOrderMasterEntity woEntity;
			if (woAvl.isPresent()) {
				woEntity = woAvl.get();
				BeanUtils.copyProperties(woDto, woEntity);
				woEntity.setId(woAvl.get().getId());
			} else {
				woEntity = new WorkOrderMasterEntity();
				BeanUtils.copyProperties(woDto, woEntity);
			}
			lead.setFormStatus(woDto.getFormStatus());
			lead.setWorkOrderStatus(woDto.getWorkOrderStatus());
			lead.setId(presentLead.get().getId());
			lead.setWordOrderMaster(woEntity);
			LeadMasterEntity saveLead = leadMasterRepo.save(lead);
			masterRes.setData(saveLead);
			masterRes.setMessage("success");
			masterRes.setStatusCode(0);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(woDto.getLeadId() + " This lead data is not available ");
			masterRes.setData(null);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto siteSurveyReg(SiteSurveyMasterDto siteSurveyMDto) {
		log.info("inside siteSurveyReg save service");
		log.debug("inside siteSurveyReg service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(siteSurveyMDto.getLeadId());
		if (presentLead.isPresent()) {
			Optional<SiteSurveyMasterEntity> avlSiteSurvey = siteSurveyMasterRepo
					.findByLeadId(siteSurveyMDto.getLeadId());
			LeadMasterEntity leadMasterEntity = presentLead.get();
			SiteSurveyMasterEntity siteSurvey;
			if (avlSiteSurvey.isPresent()) {
				log.info("inside if block siteSurvey is already available");
				siteSurvey = avlSiteSurvey.get();
				BeanUtils.copyProperties(siteSurveyMDto, siteSurvey);
				siteSurvey.setId(avlSiteSurvey.get().getId());
			} else {
				log.info("inside else block siteSurvey is not available");
				siteSurvey = new SiteSurveyMasterEntity();
				BeanUtils.copyProperties(siteSurveyMDto, siteSurvey);
			}
			leadMasterEntity.setFormStatus(siteSurveyMDto.getFormStatus());
			leadMasterEntity.setSiteSurveyStatus(siteSurveyMDto.getSiteSurveyStatus());
			leadMasterEntity.setId(presentLead.get().getId());
			leadMasterEntity.setSiteSurveyMaster(siteSurvey);
			LeadMasterEntity newLead = leadMasterRepo.save(leadMasterEntity);
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(newLead);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(siteSurveyMDto.getLeadId() + " This lead data is not available ");
			masterRes.setData(null);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto kycReg(KycMasterDto kycMDto) {
		log.info("inside kycReg service");
		log.debug("inside kycReg service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(kycMDto.getLeadId());
		if (presentLead.isPresent()) {
			Optional<KYCMasterEntity> avlKyc = kycMasterRepo.findByLeadId(kycMDto.getLeadId());
			LeadMasterEntity leadMasterEntity = presentLead.get();
			KYCMasterEntity kyc;
			if (avlKyc.isPresent()) {
				log.info("inside if block kyc already available");
				kyc = avlKyc.get();
				BeanUtils.copyProperties(kycMDto, kyc);
				kyc.setLeadId(avlKyc.get().getLeadId());
			} else {
				log.info("inside else block kyc is not available");
				kyc = new KYCMasterEntity();
				BeanUtils.copyProperties(kycMDto, kyc);
			}
			leadMasterEntity.setId(presentLead.get().getId());
			leadMasterEntity.setFormStatus(kycMDto.getFormStatus());
			leadMasterEntity.setKycId(kyc);
			leadMasterEntity.setKycStatus(kycMDto.getKycStatus());
			LeadMasterEntity newLead = leadMasterRepo.save(leadMasterEntity);
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(newLead);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(kycMDto.getLeadId() + " This lead data is not available");
			masterRes.setData(null);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto materialDeliveryReg(MaterialDeliveryMasterDto mdMDto) {
		log.info("inside materialDeliveryReg service");
		log.debug("inside materialDeliveryReg service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(mdMDto.getLeadId());
		if (presentLead.isPresent()) {
			Optional<MaterialDeliveryMaster> avlMdMDto = materialDeliverMasterRepo.findByLeadId(mdMDto.getLeadId());
			LeadMasterEntity leadMasterEntity = presentLead.get();
			MaterialDeliveryMaster mDeMaster;

			MaterialDeliveryPhotosEntity mDePhotosEntity;
			MaterialDeliveryCerEntity mDelCerEntity;
			List<MaterialDeliveryPhotosEntity> listOfMPH = new ArrayList<>();
			List<MaterialDeliveryPhotosEntity> maPhotosFromDto = mdMDto.getMaterialPhotos();
			List<MaterialDeliveryCerEntity> listOfMDCer = new ArrayList<>();
			List<MaterialDeliveryCerEntity> maCerFromDto = mdMDto.getMaterialDeliveryCer();
			if (avlMdMDto.isPresent()) {
				log.info("inside if block material delivery is already available");

				mDeMaster = avlMdMDto.get();

				// BeanUtils.copyProperties(mdMDto, mDeMaster);
				mDeMaster.setLeadId(mdMDto.getLeadId());
				mDeMaster.setUploadVideo(mdMDto.getUploadVideo());
				mDeMaster.setUploadVideoId(mdMDto.getUploadVideoId());
				mDeMaster.setGpsLat(mdMDto.getGpsLat());
				mDeMaster.setGpsLong(mdMDto.getGpsLong());
				mDeMaster.setOtp(mdMDto.getOtp());
				mDeMaster.setPerInvoiceNumber(mdMDto.getPerInvoiceNumber());
				mDeMaster.setPerInvoicePhoto(mdMDto.getPerInvoicePhoto());
				mDeMaster.setPerInvoicePhotoId(mdMDto.getPerInvoicePhotoId());
				mDeMaster.setId(avlMdMDto.get().getId());
				
				// add list to the mDeMaster
				mDeMaster.setMaterialPhotos(maPhotosFromDto);
				mDeMaster.setMaterialDeliveryCer(maCerFromDto);

			} else {
				log.info("inside else block material delivery is not available");
				mDeMaster = new MaterialDeliveryMaster();
				BeanUtils.copyProperties(mdMDto, mDeMaster);

				for (MaterialDeliveryPhotosEntity mp : maPhotosFromDto) {
					mDePhotosEntity = new MaterialDeliveryPhotosEntity();
					mDePhotosEntity.setMaterialPhotosId(mp.getMaterialPhotosId());
					mDePhotosEntity.setMaterialPhotosName(mp.getMaterialPhotosName());
					listOfMPH.add(mDePhotosEntity);
				}
				for (MaterialDeliveryCerEntity mCer : maCerFromDto) {
					mDelCerEntity = new MaterialDeliveryCerEntity();
					mDelCerEntity.setMaterialDelCerFile(mCer.getMaterialDelCerFile());
					mDelCerEntity.setMaterialDelCerId(mCer.getMaterialDelCerId());
					listOfMDCer.add(mDelCerEntity);
				}
				// add list to the mDeMaster
				mDeMaster.setMaterialPhotos(listOfMPH);
				mDeMaster.setMaterialDeliveryCer(listOfMDCer);

			}

			
			leadMasterEntity.setId(presentLead.get().getId());
			leadMasterEntity.setFormStatus(mdMDto.getFormStatus());
			leadMasterEntity.setMaterialDeliveryMaster(mDeMaster);
			leadMasterEntity.setMaterialDeliStatus(mdMDto.getMaterialDeliStatus());
			LeadMasterEntity newLead = leadMasterRepo.save(leadMasterEntity);

			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(newLead);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(mdMDto.getLeadId() + " This lead data is not available");
			masterRes.setData(null);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto saveRegDetails(RegistrationDetailsMasterDto regDMDto) {
		log.info("inside saveRegDetails  service");
		log.debug("inside saveRegDetails service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(regDMDto.getLeadId());
		if (presentLead.isPresent()) {
			Optional<RegistrationDetailsMasterEntity> avlRegDetails = regDetailsMasterRepo
					.findByLeadId(regDMDto.getLeadId());
			LeadMasterEntity leadMasterEntity = presentLead.get();
			RegistrationDetailsMasterEntity regDetailsMaster;
			if (avlRegDetails.isPresent()) {
				log.info("inside if block registration details is already available");
				regDetailsMaster = avlRegDetails.get();
				BeanUtils.copyProperties(regDMDto, regDetailsMaster);

				regDetailsMaster.setId(avlRegDetails.get().getId());
			} else {
				log.info("inside else block registration details is not available");
				regDetailsMaster = new RegistrationDetailsMasterEntity();
				BeanUtils.copyProperties(regDMDto, regDetailsMaster);
				System.out.println(regDMDto.getFarmerRegNo() + " fareg " + regDetailsMaster.getFarmerRegNo());
			}
			leadMasterEntity.setId(presentLead.get().getId());
			leadMasterEntity.setFormStatus(regDMDto.getFormStatus());
			leadMasterEntity.setRegDetailsStatus(regDMDto.getRegDetailsStatus());
			leadMasterEntity.setRegDetailsMaster(regDetailsMaster);
			LeadMasterEntity newLead = leadMasterRepo.save(leadMasterEntity);
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(newLead);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(regDMDto.getLeadId() + " This lead data is not available");
			masterRes.setData(null);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto materialInstaReg(MaterialInstallationMasterDto mIMDto) {
		log.info("inside materialInstaReg service");
		log.debug("inside materialInstaReg service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(mIMDto.getLeadId());
		if (presentLead.isPresent()) {
			Optional<MaterialInstallationMasterEntity> avlMIMDto = materialInstMasterRepo
					.findByLeadId(mIMDto.getLeadId());
			LeadMasterEntity leadMasterEntity = presentLead.get();
			MaterialInstallationMasterEntity mInstaMaster;

			MaterialInstallationPhotosEntity instRePhEntity;
			MaterialInstaCerEntity mInstCerEntity;
			List<MaterialInstallationPhotosEntity> listOfInsPh = new ArrayList<>();
			List<MaterialInstallationPhotosEntity> listOfInsPhFromDto = mIMDto.getMaterialInstaPhotos();
			List<MaterialInstaCerEntity> listOfMInsCer = new ArrayList<>();
			List<MaterialInstaCerEntity> listOfMInsCerFromDto = mIMDto.getMaterialInstaCer();

			if (avlMIMDto.isPresent()) {
				log.info("inside if block material installation is already available");
				mInstaMaster = avlMIMDto.get();
				
				BeanUtils.copyProperties(mIMDto, mInstaMaster);
				mInstaMaster.setId(avlMIMDto.get().getId());
				// add list to the mDeMaster
				mInstaMaster.setMaterialInstaCer(listOfMInsCerFromDto);
				mInstaMaster.setMaterialInstaPhotos(listOfInsPhFromDto);
				
			} else {
				log.info("inside else block material installation is not available");
				mInstaMaster = new MaterialInstallationMasterEntity();
				BeanUtils.copyProperties(mIMDto, mInstaMaster);
				for (MaterialInstallationPhotosEntity imph : listOfInsPhFromDto) {
					instRePhEntity = new MaterialInstallationPhotosEntity();
					instRePhEntity.setInstPhotoId(imph.getInstPhotoId());
					instRePhEntity.setInstPhotoName(imph.getInstPhotoName());
					listOfInsPh.add(instRePhEntity);
				}
				for (MaterialInstaCerEntity mInCer : listOfMInsCerFromDto) {
					mInstCerEntity = new MaterialInstaCerEntity();
					mInstCerEntity.setMaterialInstaCerFile(mInCer.getMaterialInstaCerFile());
					mInstCerEntity.setMaterialInstaCerFileId(mInCer.getMaterialInstaCerFileId());
					listOfMInsCer.add(mInstCerEntity);
				}
				// add list to the mDeMaster
				mInstaMaster.setMaterialInstaCer(listOfMInsCer);
				mInstaMaster.setMaterialInstaPhotos(listOfInsPh);
			}

			

			leadMasterEntity.setId(presentLead.get().getId());
			leadMasterEntity.setFormStatus(mIMDto.getFormStatus());
			leadMasterEntity.setMaterialInsaStatus(mIMDto.getMaterialInsaStatus());
			leadMasterEntity.setMaterialInstallMaster(mInstaMaster);
			LeadMasterEntity newLead = leadMasterRepo.save(leadMasterEntity);
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(newLead);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(mIMDto.getLeadId() + " This lead data is not available");
			masterRes.setData(null);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto postSalesActReg(PostSalesActDto psActDto) {
		log.info("inside postSalesActReg service");
		log.debug("inside postSalesActReg service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> avlLead = leadMasterRepo.findById(psActDto.getLeadId());
		if (avlLead.isPresent()) {
			LeadMasterEntity lead = avlLead.get();
			Optional<PostSalesActMasterEntity> avlPSAct = postSalesActRepo.findByLeadId(psActDto.getLeadId());
			PostSalesActMasterEntity psEntity;
			if (avlPSAct.isPresent()) {
				psEntity = avlPSAct.get();
				psEntity.setLeadId(lead.getId());
				if (psActDto.getTag().equalsIgnoreCase("WorkCompletion")) {
					psEntity.setWoCompStatus(psActDto.getPostSalesStatus());
					psEntity.setWoCompDate(psActDto.getPostSalesDate());
				} else if (psActDto.getTag().equalsIgnoreCase("Inspection")) {
					psEntity.setInspecStatus(psActDto.getPostSalesStatus());
					psEntity.setInspecDate(psActDto.getPostSalesDate());
				} else if (psActDto.getTag().equalsIgnoreCase("FirstPayment")) {
					psEntity.setFirstPayStatus(psActDto.getPostSalesStatus());
					psEntity.setFirstPayDate(psActDto.getPostSalesDate());
				} else if (psActDto.getTag().equalsIgnoreCase("FinalPayment")) {
					psEntity.setFinalPayStatus(psActDto.getPostSalesStatus());
					psEntity.setFinalPayDate(psActDto.getPostSalesDate());
				}

			} else {
				psEntity = new PostSalesActMasterEntity();
				psEntity.setLeadId(psActDto.getLeadId());
				if (psActDto.getTag().equalsIgnoreCase("WorkCompletion")) {
					psEntity.setWoCompStatus(psActDto.getPostSalesStatus());
					psEntity.setWoCompDate(psActDto.getPostSalesDate());
				} else if (psActDto.getTag().equalsIgnoreCase("Inspection")) {
					psEntity.setInspecStatus(psActDto.getPostSalesStatus());
					psEntity.setInspecDate(psActDto.getPostSalesDate());
				} else if (psActDto.getTag().equalsIgnoreCase("FirstPayment")) {
					psEntity.setFirstPayStatus(psActDto.getPostSalesStatus());
					psEntity.setFirstPayDate(psActDto.getPostSalesDate());
				} else if (psActDto.getTag().equalsIgnoreCase("FinalPayment")) {
					psEntity.setFinalPayStatus(psActDto.getPostSalesStatus());
					psEntity.setFinalPayDate(psActDto.getPostSalesDate());
				}
			}

			lead.setPostSalesMaster(psEntity);
			lead.setFormStatus(psActDto.getFormStatus());
			lead.setId(avlLead.get().getId());
			LeadMasterEntity saveLead = leadMasterRepo.save(lead);
			masterRes.setData(saveLead);
			masterRes.setMessage("success");
			masterRes.setStatusCode(0);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(psActDto.getLeadId() + " This lead data is not available");
			masterRes.setData(null);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto rejectLead(RejectLeadReqDto rLeadDto) {
		log.info("inside rejectLead service");
		log.debug("inside rejectLead service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> avlLead = leadMasterRepo.findById(rLeadDto.getLeadId());
		if (avlLead.isPresent()) {
			leadMasterRepo.updateFormStatus(rLeadDto.getFormStatus(), rLeadDto.getLeadId());
			masterRes.setStatusCode(0);
			masterRes.setMessage(rLeadDto.getLeadId() + " This lead is Rejected");
			masterRes.setData(null);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(rLeadDto.getLeadId() + " This lead data is not available");
			masterRes.setData(null);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto filterLeads(LeadFilterDto leadFDto) {
		log.info("inside filterLeads service");
		log.debug("inside filterLeads service");
		MasterResponseDto masterRes = new MasterResponseDto();
		if (leadFDto.getSortByDate().equalsIgnoreCase("Oldest")) {
			log.info("inside filterLeads if block sort by oldest");
			List<LeadMasterEntity> ascLeads = leadMasterRepo.findByUserMobileAndAscOrder(leadFDto.getUserMobile());
			if (!ascLeads.isEmpty()) {
				return getSortedDataService(ascLeads, leadFDto);
			} else {
				masterRes.setStatusCode(1);
				masterRes.setMessage("Lead data is not available");
				masterRes.setData(null);
				return masterRes;
			}

		} else {
			log.info("inside filterLeads if block sort by newest");
			List<LeadMasterEntity> descLeads = leadMasterRepo.findByUserMobileAndDescOrder(leadFDto.getUserMobile());
			if (!descLeads.isEmpty()) {
				return getSortedDataService(descLeads, leadFDto);
			} else {
				masterRes.setStatusCode(1);
				masterRes.setMessage("Lead data is not available");
				masterRes.setData(null);
				return masterRes;
			}
		}
	}

	public MasterResponseDto getSortedDataService(List<LeadMasterEntity> avlLeads, LeadFilterDto leadFDto) {
		log.info("inside getSortedDataService ");
		MasterResponseDto masterRes = new MasterResponseDto();
		if (leadFDto.getFilterBy().equalsIgnoreCase("open")) {
			try {
				List<LeadMasterEntity> openLeads = avlLeads.stream()
						.filter(e -> e.getFormStatus().equalsIgnoreCase("open")).collect(Collectors.toList());
				if (openLeads.isEmpty()) {
					masterRes.setStatusCode(0);
					masterRes.setMessage("open leads is not available for this user:" + leadFDto.getUserMobile());
					masterRes.setData(openLeads);
				} else {
					masterRes.setStatusCode(0);
					masterRes.setMessage("success");
					masterRes.setData(openLeads);
				}
			} catch (NullPointerException e) {
				throw new DataNotFoundException("Open Data is not found");
			}

		} else if (leadFDto.getFilterBy().equalsIgnoreCase("close")) {
			try {
				List<LeadMasterEntity> closeLeads = avlLeads.stream()
						.filter(e -> e.getFormStatus().equalsIgnoreCase("close")).collect(Collectors.toList());
				if (closeLeads.isEmpty()) {
					masterRes.setStatusCode(0);
					masterRes.setMessage("Close leads is not available for this user:" + leadFDto.getUserMobile());
					masterRes.setData(closeLeads);
				} else {
					masterRes.setStatusCode(0);
					masterRes.setMessage("success");
					masterRes.setData(closeLeads);
				}
			} catch (NullPointerException e) {
				throw new DataNotFoundException("Close Data is not found");
			}
		} else if (leadFDto.getFilterBy().equalsIgnoreCase("reject")) {
			try {
				List<LeadMasterEntity> rejectLeads = avlLeads.stream()
						.filter(e -> e.getFormStatus().equalsIgnoreCase("reject")).collect(Collectors.toList());
				if (rejectLeads.isEmpty()) {
					masterRes.setStatusCode(0);
					masterRes.setMessage("Reject leads is not available for this user:" + leadFDto.getUserMobile());
					masterRes.setData(rejectLeads);
				} else {
					masterRes.setStatusCode(0);
					masterRes.setMessage("success");
					masterRes.setData(rejectLeads);
				}
			} catch (NullPointerException e) {
				throw new DataNotFoundException("reject Data is not found");
			}
		} else {
			List<LeadMasterEntity> allLeads = avlLeads;
			if (allLeads.isEmpty()) {
				masterRes.setStatusCode(0);
				masterRes.setMessage("leads is not available for this user:" + leadFDto.getUserMobile());
				masterRes.setData(allLeads);
			} else {
				masterRes.setStatusCode(0);
				masterRes.setMessage("success");
				masterRes.setData(allLeads);
			}

		}
		return masterRes;
	}

	@Override
	public MasterResponseDto fileUploadByApi(MultipartFile file, int leadId, String fileType) throws Exception {
		log.info("inside fileUploadByApi service");
		log.debug("inside fileUploadByApi service");
		MasterResponseDto resDto = new MasterResponseDto();
		if (file != null && file.getSize() != 0) {
			FilesMaintainMasterEntity fileMaintain = new FilesMaintainMasterEntity();
			String fileName = leadId + "_" + fileType + "_" + file.getOriginalFilename();
			fileMaintain.setLeadId(leadId);
			fileMaintain.setFileName(fileName);
			try {
				String uploadFiles = uploadFiles(file, leadId, fileType);
				FilesMaintainMasterEntity fileSaved = filesMainMasterRepo.save(fileMaintain);
				resDto.setMessage(uploadFiles + " File is uploaded");
				resDto.setStatusCode(0);
				resDto.setData(fileSaved);
			} catch (Exception e) {
				throw new Exception("Some thing went wrong");
			}

		} else {
			resDto.setMessage("Please attach file");
			resDto.setStatusCode(1);
		}
		return resDto;
	}

	/*
	 * Upload File Service
	 */
	public String uploadFiles(MultipartFile file, int leadId, String fileType) {
		try {
			log.info("inside upload file service started");
			log.debug("inside upload file service");
			System.out.println("root ");
			if (root == null) {
				Files.createDirectory(root);
			}
			Path targetLocation = this.root.resolve(leadId + "_" + fileType + "_" + file.getOriginalFilename());
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ex) {
			log.error("Exception occured in File Uploading", ex);
			throw new FileStorageException("Could not store file " + file + ". Please try again!", ex);
		}
		log.info("inside upload file service ended");
		return file.getOriginalFilename();
	}

}
