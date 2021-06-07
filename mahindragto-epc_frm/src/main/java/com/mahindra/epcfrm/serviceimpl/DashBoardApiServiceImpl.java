package com.mahindra.epcfrm.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mahindra.epcfrm.dto.ActivityRequestDto;
import com.mahindra.epcfrm.dto.CreateUpdateRespDto;
import com.mahindra.epcfrm.dto.DashBoardCountRequestDto;
import com.mahindra.epcfrm.dto.DashBoardCountResponseDto;
import com.mahindra.epcfrm.dto.DashBoardLeadsResponseDto;
import com.mahindra.epcfrm.dto.GetLeadNamesDto;
import com.mahindra.epcfrm.dto.GetLeadNamesResponseDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.entity.ActivityHistoryEntity;
import com.mahindra.epcfrm.entity.FarmerMasterEntity;
import com.mahindra.epcfrm.entity.LeadMasterEntity;
import com.mahindra.epcfrm.repository.ActivityHistoryRepo;
import com.mahindra.epcfrm.repository.FarmerMasterRepo;
import com.mahindra.epcfrm.repository.LeadMasterRepo;
import com.mahindra.epcfrm.service.DashBoardApiService;

@Service
public class DashBoardApiServiceImpl implements DashBoardApiService {

	Logger log = LoggerFactory.getLogger(DashBoardApiServiceImpl.class);

	@Autowired
	LeadMasterRepo leadMasterRepo;
	@Autowired
	ActivityHistoryRepo activityRepo;
	@Autowired
	FarmerMasterRepo farmerMasterRepo;

	private static final String SUCCESSMSG = "success";

	@SuppressWarnings("unused")

	@Override
	public MasterResponseDto getCountsOnStatus() {
		log.info("inside getCountsOnStatus service");
		log.debug("inside getCountsOnStatus service");
		MasterResponseDto masterRes = new MasterResponseDto();
		DashBoardCountResponseDto dbCRes = new DashBoardCountResponseDto();
		//List<LeadMasterEntity> leadsList = leadMasterRepo.findLeads();
		//to be changed
		List<LeadMasterEntity> leadsList=new ArrayList<LeadMasterEntity>();
		List<LeadMasterEntity> woPendLeads = leadsList.stream()
				.filter(e -> e.getWorkOrderStatus().equalsIgnoreCase("pending")).collect(Collectors.toList());
		List<LeadMasterEntity> kycPendLeads = leadsList.stream()
				.filter(e -> e.getKycStatus().equalsIgnoreCase("pending")).collect(Collectors.toList());
	//	List<LeadMasterEntity> qtpPendLeads = leadsList.stream()
		//		.filter(e -> e.getQuotationStatus().equalsIgnoreCase("pending")).collect(Collectors.toList());
		dbCRes.setWorkOrderStatusCount(woPendLeads.size());
		dbCRes.setKycStatusCount(kycPendLeads.size());
		//dbCRes.setQuotaionStatusCount(qtpPendLeads.size());
		if (dbCRes != null) {
			masterRes.setStatusCode(0);
			masterRes.setMessage(SUCCESSMSG);
			masterRes.setData(dbCRes);
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage("Count is not available");
			masterRes.setData(null);
		}
		return masterRes;
	}

	@SuppressWarnings("unused")
	@Override
	public MasterResponseDto getListOfPendingLeads(DashBoardCountRequestDto reqDto) {
		log.info("inside getListOfPendingLeads service");
		log.debug("inside getListOfPendingLeads service");
		MasterResponseDto masterRes = new MasterResponseDto();
		DashBoardLeadsResponseDto dbLRes = new DashBoardLeadsResponseDto();
		List<LeadMasterEntity> leadList = new ArrayList<>();
		//List<LeadMasterEntity> allLeadsList = leadMasterRepo.findLeads();
		//to be changed
		List<LeadMasterEntity> allLeadsList=new ArrayList<LeadMasterEntity>();
		String tag = reqDto.getTag();
		masterRes.setStatusCode(0);
		masterRes.setMessage(SUCCESSMSG);
		masterRes.setData(dbLRes);
		if (tag.equalsIgnoreCase("WOP")) {
			leadList = allLeadsList.stream().filter(e -> e.getWorkOrderStatus().equalsIgnoreCase("pending"))
					.collect(Collectors.toList());
			dbLRes.setLeadsOnWoPending(leadList);
			log.info("count of leadList:" + leadList.size());
			masterRes.setData(dbLRes);
		} else if (tag.equalsIgnoreCase("KYC")) {
			leadList = allLeadsList.stream().filter(e -> e.getKycStatus().equalsIgnoreCase("pending"))
					.collect(Collectors.toList());
			dbLRes.setLeadsOnWoPending(leadList);
			log.info("count of leadList:" + leadList.size());
			masterRes.setData(dbLRes);
		} /*
			 * else if (tag.equalsIgnoreCase("QTP")) { leadList =
			 * allLeadsList.stream().filter(e ->
			 * e.getQuotationStatus().equalsIgnoreCase("pending"))
			 * .collect(Collectors.toList()); dbLRes.setLeadsOnWoPending(leadList);
			 * log.info("count of leadList:" + leadList.size()); masterRes.setData(dbLRes);
			 * }
			 */
		else {
			masterRes.setStatusCode(1);
			masterRes.setMessage("Leads is not available");
			masterRes.setData(null);
		}
		return masterRes;
	}

	@Override
	public MasterResponseDto getActivity(String date, HttpSession session) {
		String user = (String) session.getAttribute("loginUser");
		log.info("user name is {}", user);
		LocalDate activityDate = date == null ? LocalDate.now() : LocalDate.parse(date);
		log.info("activityDate {}", activityDate);
		List<ActivityHistoryEntity> activityList = activityRepo.getActivity(user, activityDate);

		MasterResponseDto dealerResp = new MasterResponseDto();
		if (activityList.isEmpty()) {
			dealerResp.setStatusCode(1);
			dealerResp.setMessage("No activity found");
			dealerResp.setData(null);
		} else {
			dealerResp.setStatusCode(0);
			dealerResp.setMessage(SUCCESSMSG);
			dealerResp.setData(activityList);
		}
		return dealerResp;

	}

	@Override
	public CreateUpdateRespDto createUpdateActivity(ActivityRequestDto actReqDto, HttpSession session) {

		CreateUpdateRespDto respDto = new CreateUpdateRespDto();

		if (actReqDto == null) {
			respDto.setStatusCode(1);
			respDto.setMessage("Requested with no-data");
			return respDto;
		} else if (actReqDto.getDate() == null || actReqDto.getFromTime() == null || actReqDto.getToTime() == null) {
			respDto.setStatusCode(1);
			respDto.setMessage("Mandatory field(s) found empty");
			return respDto;
		} else if (LocalDate.now().isAfter(actReqDto.getDate())) {
			respDto.setStatusCode(1);
			respDto.setMessage("Activity date should be greaterthan or equals to the current date");
			return respDto;
		} else {
			String user = (String) session.getAttribute("loginUser");
			ActivityHistoryEntity activityEntity = new ActivityHistoryEntity();
			LocalDate activityDate = actReqDto.getDate();
			LocalTime fromTime = actReqDto.getFromTime();
			ActivityHistoryEntity activityDb = activityRepo.getUserActivity(user, activityDate, fromTime);

			if (activityDb == null) {
				activityEntity.setCreatedBy(user);
				activityEntity.setActivityType(actReqDto.getActivityType());
				activityEntity.setCustomerMobile(actReqDto.getCustomerMobile());
				activityEntity.setCustomerName(actReqDto.getCustomerName());
				activityEntity.setDate(activityDate);
				activityEntity.setFromTime(actReqDto.getFromTime());
				activityEntity.setToTime(actReqDto.getToTime());
				activityEntity.setFarmerMobile(actReqDto.getFarmerMobile());
				activityEntity.setFarmerName(actReqDto.getFarmerName());
				activityEntity.setRemarks(actReqDto.getRemarks());
				activityEntity.setUserId(user);
				/*
				 * activityEntity.setIrrSystem(actReqDto.getIrrSystem());
				 * activityEntity.setPin(actReqDto.getPin());
				 * activityEntity.setVillage(actReqDto.getVillage());
				 * activityEntity.setArea(actReqDto.getArea());
				 */

				activityRepo.save(activityEntity);

				respDto.setStatusCode(0);
				respDto.setMessage("Activity created");
			} else {
				activityDb.setModifiedBy(user);
				activityDb.setActivityType(actReqDto.getActivityType());
				activityDb.setCustomerMobile(actReqDto.getCustomerMobile());
				activityDb.setCustomerName(actReqDto.getCustomerName());
				activityDb.setDate(activityDate);
				activityDb.setFromTime(actReqDto.getFromTime());
				activityDb.setToTime(actReqDto.getToTime());
				activityDb.setUserId(user);
				activityDb.setFarmerMobile(actReqDto.getFarmerMobile());
				activityDb.setFarmerName(actReqDto.getFarmerName());
				activityDb.setRemarks(actReqDto.getRemarks());
				activityRepo.save(activityDb);

				respDto.setStatusCode(0);
				respDto.setMessage("Activity updated");
			}

			return respDto;
		}
	}

	@Override
	public MasterResponseDto deleteActivity(int id) {
		log.info("inside deleteActivity service");
		log.debug("inside deleteActivity service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<ActivityHistoryEntity> actDb = activityRepo.findById(id);
		if (actDb.isPresent()) {
			activityRepo.deleteById(id);
			masterRes.setStatusCode(0);
			masterRes.setMessage("Activity is deleted");
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage("This activity is not available :" + id);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto leadSearchForActivity(String leadName, HttpSession session) {
		log.info("inside leadSearchForActivity service");
		log.debug("inside leadSearchForActivity service");
		String user = (String) session.getAttribute("loginUser");
		MasterResponseDto masterRes = new MasterResponseDto();
		List<GetLeadNamesResponseDto> farmerList = farmerMasterRepo.findByFirstName(leadName,user);
		log.info("farmerList size:"+farmerList.size());
		if (farmerList.isEmpty()) {
			masterRes.setStatusCode(1);
			masterRes.setMessage("No leads available");
			masterRes.setData(null);
		} else {
			masterRes.setStatusCode(0);
			masterRes.setMessage("SUCCESS");
			masterRes.setData(farmerList);
		}
		return masterRes;
	}
}
