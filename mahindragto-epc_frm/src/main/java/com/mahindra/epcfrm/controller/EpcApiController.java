/**
 * 
 */
package com.mahindra.epcfrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mahindra.epcfrm.dto.ApiResponseDto;
import com.mahindra.epcfrm.dto.CityRequestDto;
import com.mahindra.epcfrm.dto.CreateUpdateRespDto;
import com.mahindra.epcfrm.dto.DistrictRequestDto;
import com.mahindra.epcfrm.dto.FormerOtpRequestDto;
import com.mahindra.epcfrm.dto.FarmerMasterDto;
import com.mahindra.epcfrm.dto.KycMasterDto;
import com.mahindra.epcfrm.dto.LeadFilterDto;
import com.mahindra.epcfrm.dto.LeadMasterDataRespDto;
import com.mahindra.epcfrm.dto.LeadSearchDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.dto.MaterialDeliveryMasterDto;
import com.mahindra.epcfrm.dto.MaterialInstallationMasterDto;
import com.mahindra.epcfrm.dto.PostSalesActDto;
import com.mahindra.epcfrm.dto.RegistrationDetailsMasterDto;
import com.mahindra.epcfrm.dto.RejectLeadReqDto;
import com.mahindra.epcfrm.dto.SiteSurveyMasterDto;
import com.mahindra.epcfrm.dto.WorkOrderMasterDto;
import com.mahindra.epcfrm.service.CityMasterService;
import com.mahindra.epcfrm.service.CropMasterService;
import com.mahindra.epcfrm.service.DistrictMasterService;
import com.mahindra.epcfrm.service.EpcService;
import com.mahindra.epcfrm.service.LeadMasterService;
import com.mahindra.epcfrm.service.LoginService;
import com.mahindra.epcfrm.service.StateMasterService;

/**
 * @author Raju.Addu
 *
 */
@RestController
@RequestMapping("/epc/")
public class EpcApiController {

	Logger log = LoggerFactory.getLogger(EpcApiController.class);

	@Autowired
	LeadMasterService leadMasterService;
	@Autowired
	StateMasterService stateMasterService;
	@Autowired
	CropMasterService cropMasterService;

	@Autowired
	DistrictMasterService districtMasterService;

	@Autowired
	CityMasterService cityMasterService;

	@Autowired
	EpcService epcService;
	@Autowired
	private LoginService loginService;

	@GetMapping("getLead")
	public String getLead() {
		return "lead generated";
	}

	@GetMapping("/")
	public String getWelcome() {
		return "Welcome to EPC!";
	}

	@PostMapping("/getFormerOtp")
	public ResponseEntity<CreateUpdateRespDto> getFormerOtp(@RequestBody FormerOtpRequestDto formerReqDto,
			HttpSession session) {
		ApiResponseDto apiRespDto = null;
		CreateUpdateRespDto resp = new CreateUpdateRespDto();
		int leadId = formerReqDto.getLeadId();
		String mobile = formerReqDto.getFormarMobileNo();
		String otpType = formerReqDto.getOtpType();
		apiRespDto = loginService.getOtp(mobile, "Former", leadId, otpType, session);
		if (apiRespDto != null) {
			resp.setStatusCode(1);
			resp.setMessage(apiRespDto.getMessage());
			if ("success".equalsIgnoreCase(apiRespDto.getStatus())) {
				resp.setStatusCode(0);
				resp.setMessage("OTP is sent to Mobile No. ending with " + apiRespDto.getMobile());
			}
		}
		return ResponseEntity.ok(resp);
	}

	@PostMapping("/validateFormerOtp")
	public ResponseEntity<CreateUpdateRespDto> validateFormerOtp(@RequestBody FormerOtpRequestDto formerReqDto,
			HttpSession session) {
		int leadId = formerReqDto.getLeadId();
		String mobile = formerReqDto.getFormarMobileNo();
		String otpType = formerReqDto.getOtpType();
		String otp = formerReqDto.getOtp();
		return ResponseEntity.ok(loginService.validateFormerOtp(mobile, leadId, otp, otpType, session));
	}

	@PostMapping(value = "leadSearch")
	public MasterResponseDto leadSearch(@RequestBody LeadSearchDto leadSearchDTO) throws Exception {
		log.info("request processing of leadSearch");
		return leadMasterService.leadSearch(leadSearchDTO);
	}
	/*
	 * @PostMapping(value = "getLeadsList") public MasterResponseDto
	 * getLeadsListByUser(@RequestBody LeadFilterDto leadFDto) throws Exception {
	 * log.info("request processing of getLeadsListByUser"); return
	 * leadMasterService.filterLeads(leadFDto); }
	 */

	@PostMapping(value = "getLeadsList")
	public MasterResponseDto getLeadsListByUser(@RequestBody LeadSearchDto leadSearchDTO) throws Exception {
		log.info("request processing of leadSearch");
		return leadMasterService.leadSearch(leadSearchDTO);
	}

	@GetMapping(value = "getAllStates")
	public MasterResponseDto getAllStates() throws Exception {
		log.info("request processing of getAllStates");
		return stateMasterService.getAllStates();
	}

	@GetMapping(value = "getAllCrops")
	public MasterResponseDto getAllCrops() throws Exception {
		log.info("request processing of getAllCrops");
		return cropMasterService.getAllCrops();
	}

	@GetMapping(value = "getDistricts")
	public MasterResponseDto getDistricts(@RequestBody DistrictRequestDto reqDto) throws Exception {
		log.info("request processing of getDistricts");
		return districtMasterService.getDistrictsByStateWise(reqDto.getStateCode());
	}

	@GetMapping(value = "getCitiesByStateCode")
	public MasterResponseDto getCitiesByStateCode(@RequestBody CityRequestDto reqDto) throws Exception {
		log.info("request processing of getAllCities");
		return cityMasterService.getCitiesByStateCode(reqDto);
	}

	@GetMapping(value = "getAllCities")
	public MasterResponseDto getAllCities() throws Exception {
		log.info("request processing of getAllCities");
		return cityMasterService.getAllCities();
	}

	@GetMapping("getAllDealers")
	public MasterResponseDto getAllDealers() {
		return epcService.getAllDealers();
	}

	@GetMapping("getSubsidy")
	public MasterResponseDto getSubsidy(@RequestParam int stateCode) {
		return epcService.getSubsidy(stateCode);
	}

	@GetMapping("getAllSubsidy")
	public MasterResponseDto getAllSubsidy() {
		return epcService.getAllSubsidy();
	}

	@GetMapping("getLeadMasterData")
	public LeadMasterDataRespDto getLeadMasterData() {
		return epcService.getLeadMasterData();
	}

	// next apis multiple partition apis for lead creation
	@PostMapping(value = "farmerInfoReg")
	public MasterResponseDto farmerInfoSave(@RequestBody FarmerMasterDto farmerMasterDto, HttpSession session) {
		log.info("request processing of farmerInfoSave");
		return leadMasterService.farmerInfoReg(farmerMasterDto, session);
	}

	@PostMapping(value = "siteSurveyReg")
	public MasterResponseDto siteSurveyReg(@RequestBody SiteSurveyMasterDto siteSurveyDto) {
		log.info("request processing of siteSurveyReg");
		return leadMasterService.siteSurveyReg(siteSurveyDto);
	}

	@PostMapping(value = "workOrderReg")
	public MasterResponseDto workOrderReg(@RequestBody WorkOrderMasterDto woDto) {
		log.info("request processing of workOrderReg");
		return leadMasterService.workOrderReg(woDto);
	}

	@PostMapping(value = "kycReg")
	public MasterResponseDto kycReg(@RequestBody KycMasterDto kycMasterDto) {
		log.info("request processing of kycReg");
		return leadMasterService.kycReg(kycMasterDto);
	}

	@PostMapping(value = "materialDeliReg")
	public MasterResponseDto materialDeliReg(@RequestBody MaterialDeliveryMasterDto mDMDto) {
		log.info("request processing of materialDeliReg");
		return leadMasterService.materialDeliveryReg(mDMDto);
	}

	@PostMapping(value = "saveRegDetails")
	public MasterResponseDto saveRegDetails(@RequestBody RegistrationDetailsMasterDto regDMDto) {
		log.info("request processing of materialDeliReg");
		return leadMasterService.saveRegDetails(regDMDto);
	}

	@PostMapping(value = "materialInstaReg")
	public MasterResponseDto materialInstaReg(@RequestBody MaterialInstallationMasterDto mIMDto) {
		log.info("request processing of materialInstallation Reg");
		
		return leadMasterService.materialInstaReg(mIMDto);
	}

	@PostMapping(value = "PostSalesAct")
	public MasterResponseDto PostSalesActReg(@RequestBody PostSalesActDto psActDto) {
		log.info("request processing of workCompReg");
		return leadMasterService.postSalesActReg(psActDto);
	}

	@PostMapping(value = "rejectLead")
	public MasterResponseDto rejectLead(@RequestBody RejectLeadReqDto rejectLeadDto) {
		log.info("request processing of rejectLead");
		return leadMasterService.rejectLead(rejectLeadDto);
	}
	
	@PostMapping(value = "uploadFiles")
	public MasterResponseDto uploadFiles(@RequestPart(value = "file", required = false)  MultipartFile file,
			@RequestParam(value = "leadId",required = false) int leadId,
			@RequestParam(value="fileType",required = false) String fileType
			) throws Exception{
		log.info("request processing of rejectLead");
		 //int leadId=12;
		 //String fileType="File";
		System.out.println("id :"+leadId+" fileType :"+fileType);
		return leadMasterService.fileUploadByApi(file,leadId,fileType);
	}

}
