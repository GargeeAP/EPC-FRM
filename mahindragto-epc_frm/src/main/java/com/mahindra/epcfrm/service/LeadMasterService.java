package com.mahindra.epcfrm.service;

import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;
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

public interface LeadMasterService {

	public MasterResponseDto leadSearch(LeadSearchDto searchDTO) throws Exception;
	
	public MasterResponseDto filterLeads(LeadFilterDto leadFilterDto);

	public MasterResponseDto farmerInfoReg(FarmerMasterDto farmerMDto, HttpSession session);

	public MasterResponseDto siteSurveyReg(SiteSurveyMasterDto siteSurveyMDto);

	public MasterResponseDto workOrderReg(WorkOrderMasterDto woDto);

	public MasterResponseDto kycReg(KycMasterDto kycMDto);

	public MasterResponseDto materialDeliveryReg(MaterialDeliveryMasterDto mdMDto);

	public MasterResponseDto saveRegDetails(RegistrationDetailsMasterDto regDMDto);

	public MasterResponseDto materialInstaReg(MaterialInstallationMasterDto mIMDto);

	public MasterResponseDto postSalesActReg(PostSalesActDto psActDto);


	public MasterResponseDto rejectLead(RejectLeadReqDto rLeadDto);
	
	public MasterResponseDto fileUploadByApi(MultipartFile file,int leadId,String fileType)throws Exception;

}
